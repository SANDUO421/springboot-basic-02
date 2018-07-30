package com.sanduo.springboot.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.SingularAttribute;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import com.sanduo.springboot.entity.Person;

/**
 * 测试验证 JpaSpecification 的标准规范<br/>
 * 定义Specification
 * 
 * @author sanduo
 * @date 2018/07/05
 */
public class CustomerSpecs {

    @SuppressWarnings({"unchecked", "serial"})
    public static <T> Specification<T> byAuto(final EntityManager entityManager, final T example) {// 实体管理类和作为查询条件的实体类对象
        // 获取运行时的类
        final Class<T> type = (Class<T>)example.getClass();// 获取当前实体类的对象类的类型
        return new Specification<T>() {
            // 构建查询条件
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();// 断言存储条件
                // 获取实例
                EntityType<T> entity = entityManager.getMetamodel().entity(type);// 获取实体类的实体对象，可以从EntityType中获取实体类的属性
                for (Attribute<T, ?> attr : entity.getDeclaredAttributes()) { // 循环实体类的属性
                    Object attrValue = getValue(example, attr);// 获取实体类对象的某一个属性的值
                    if (attrValue != null) {
                        if (attr.getJavaType() == String.class) {// 获取属性值为字符类型
                            if (!StringUtils.isEmpty(attrValue)) {// 字符不为空
                                predicates.add(cb.like(root.get(attribute(entity, attr.getName(), String.class)),
                                    pattern((String)attrValue)));// 构建like查询%str%
                            }
                        } else {
                            predicates.add(
                                cb.equal(root.get(attribute(entity, attr.getName(), attrValue.getClass())), attrValue));
                        }
                    }

                }
                return predicates.isEmpty() ? cb.conjunction()
                    : cb.and(predicates.toArray(new Predicate[predicates.size()]));
            }

            // 构造like
            private String pattern(String str) {
                return "%" + str + "%";
            }

            // 获取实体类当前属性的SingularAttribute，SingularAttribute包含的是实体类的某个单独属性
            private <E> SingularAttribute<T, E> attribute(EntityType<T> entity, String fieldName, Class<E> fieldClass) {

                return entity.getDeclaredSingularAttribute(fieldName, fieldClass);
            }

            // 通过反射获取实体类对象属性的属性值
            private Object getValue(T example, Attribute<T, ?> attr) {

                return ReflectionUtils.findRequiredField(type, attr.getName());
            }

        };
    }

    public static Specification<Person> personFromHefei() {
        return new Specification<Person>() {

            private static final long serialVersionUID = -7285845976428527967L;

            @Override
            public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                return cb.equal(root.get("address"), "合肥");
            }

        };

    }
}
