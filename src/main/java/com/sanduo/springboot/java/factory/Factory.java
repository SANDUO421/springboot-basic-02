package com.sanduo.springboot.java.factory;

/**
 * 工厂设计模式
 * 
 * @author sanduo
 * @date 2018/07/13
 */
public interface Factory<T> {
    // 使用泛型T可以保证每次创建的返回值类型不一样，充分利用类协变返回类型
    public T create();
}
