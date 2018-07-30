package com.sanduo.springboot.java.instance;

/**
 * 测试 instanceof,class,isinstance
 * 
 * @author sanduo
 * @date 2018/07/13
 */
public class InstanceTest {
    static void test(Object obj) {
        System.out.println("Test obj of type:" + obj.getClass());
        System.out.println("Base isinstance(obj):" + Base.class.isInstance(obj));
        System.out.println("Base isinstance(obj):" + Derived.class.isInstance(obj));
        System.out.println("obj instanceof Derived:" + (obj instanceof Derived));
        System.out.println("obj instanceof Derived:" + (obj instanceof Base));
    }

    public static void main(String[] args) {
        test(new Base());
        test(new Derived());
    }
}

class Base {}

class Derived extends Base {}
