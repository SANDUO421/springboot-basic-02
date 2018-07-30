package com.sanduo.springboot.java.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * 反射示例
 * 
 * @author sanduo
 * @date 2018/07/11
 */
public class ShowMethods {

    private static String usage = "usage:\n" + "ShowMethods qualified.class.name\n";
    private static Pattern pattern = Pattern.compile("\\w+\\.");

    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println(usage);
            System.exit(0);// 关闭虚拟机
        }
        int lines = 0;
        try {
            Class<?> c = Class.forName(args[0]);
            Method[] methods = c.getMethods();
            Constructor<?>[] ctros = c.getConstructors();
            if (args.length == 1) {
                for (Method method : methods) {
                    System.out.println(pattern.matcher(method.toString()).replaceAll(""));
                    System.out.println("method:" + method.toString());
                }
                for (Constructor<?> ctro : ctros)
                    System.out.println(pattern.matcher(ctro.toString()).replaceAll(""));
                lines = methods.length + ctros.length;
            } else {
                for (Method method : methods)
                    if (method.toString().indexOf(args[1]) != -1) {
                        System.out.println(pattern.matcher(method.toString()).replaceAll(""));
                        lines++;
                    }
                for (Constructor<?> ctro : ctros)
                    if (ctro.toString().indexOf(args[1]) != -1) {
                        System.out.println(pattern.matcher(ctro.toString()).replaceAll(""));
                        lines++;
                    }
            }

        } catch (ClassNotFoundException e) {
            System.out.println("No Such Class" + e);
        }
        System.out.println(lines);
    }
}
