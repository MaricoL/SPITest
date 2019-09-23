package com.my.jdkproxy;

import java.lang.reflect.Proxy;

/**
 * @author mrjimmylin
 * @description 代理测试类
 * @date 2019/9/20 13:24
 */
public class ProxyTest {

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        IFun ifun = (IFun) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(), new Class[]{IFun.class}, new MyInvocationHandler(new MyFun()));
        try {
            ifun.helloWorld();
        } catch (Throwable e) {
            e.printStackTrace();
        }


    }
}
