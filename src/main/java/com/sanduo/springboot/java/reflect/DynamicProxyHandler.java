package com.sanduo.springboot.java.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 创建动态代理对象
 * 
 * @author sanduo
 * @date 2018/07/15
 */
public class DynamicProxyHandler implements InvocationHandler {

    private Object proxied;// 被代理对象

    /**
     * @param proxy
     */
    public DynamicProxyHandler(Object proxied) {
        super();
        this.proxied = proxied;
    }

    /* 动态代理对象
     * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("---proxy:" + proxy.getClass() + "---method:" + method + "---args:" + args);
        if (args != null) {
            int m = 0;
            for (Object arg : args) {
                System.out.println("arg" + (m++) + ":" + arg);
            }
        }
        return method.invoke(proxied, args);
    }

}
