package com.sanduo.springboot.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.sanduo.springboot.entity.Person;

/**
 * JpaSpecificationExecutor 标准规范的查询
 * 
 * @author sanduo
 * @date 2018/07/04
 */
// public interface PersonRepository extends JpaRepository<Person, Long>, JpaSpecificationExecutor<Person> {
public interface PersonRepository extends CustomerRepository<Person, Long> {

    /**
     * 通过名字相等查询，参数name select p from Person p where p.name = ?1 </br>
     * 方法名查询：接受一个参数name
     * 
     * @param name
     * @return
     */
    List<Person> findByName(String name);

    /**
     * like模糊查询 参数name sql：select p from Person p where p.name like ?1
     * 
     * @param name
     * @return
     */
    List<Person> findByNameLike(String name);

    /**
     * 通过地址和名字查询：name,address select p from Person p where p.name=?1 and p.address=?2
     * 
     * @param name
     * @param address
     * @return
     */
    Person findByNameAndAddress(String name, String address);

    /**
     * 获取符合查询条件的前10条数据
     * 
     * @param name
     * @return
     */
    List<Person> findFirst10ByName(String name);

    /**
     * 获取符合条件的前30条数据（first作用=top）
     * 
     * @param name
     * @return
     */
    List<Person> findTop10ByName(String name);

    /**
     * 此时使用的是NameQuery定义的查询语句，而不是根据方法名称查询
     * 
     * @param address
     * @return
     */
    List<Person> findByAddress(String address);

    /**
     * @Query查询
     * @param address
     * @return
     */
    @Query(" select p from Person p where p.address like ?1")
    List<Person> findByAddressLike(String address);

    /**
     * 命名参数查询
     * 
     * @param address
     * @return
     */
    @Query(" select p from Person p where p.address not like :address")
    List<Person> findByAddressNotLike(@Param("address") String address);

    /**
     * @Modifying 和@Query 组合实现更新操作，int 表示影响的条数
     * @param name
     * @return
     */
    @Modifying(flushAutomatically = true)
    @Transactional
    @Query("update Person p set p.name=?1")
    int setName(String name);

    /**
     * 排序
     * 
     * @param name
     * @param sort
     * @return
     */
    List<Person> findByName(String name, Sort sort);

    /**
     * 分页
     * 
     * @param name
     * @param pageable
     * @return
     */
    List<Person> findByName(String name, Pageable pageable);

    /**
     * 自定义Query:参数按照名称绑定
     * 
     * @param name
     * @param address
     * @return
     */
    @Query("select p from Person p where p.name= :name and p.address= :address")
    Person withNameAndAddressQuery(@Param("name") String name, @Param("address") String address);

    /**
     * 自定义@NameQuery
     * 
     * @param name
     * @param address
     * @return
     */
    List<Person> withNameAndAddressNamedQuery(String name, String address);

}
