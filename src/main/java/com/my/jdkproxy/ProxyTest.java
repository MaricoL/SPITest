package com.my.jdkproxy;

import java.lang.reflect.Proxy;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Supplier;

/**
 * @author mrjimmylin
 * @description 代理测试类
 * @date 2019/9/20 13:24
 */
public class ProxyTest {

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        IFun proxyObject = (IFun) Proxy.newProxyInstance(IFun.class.getClassLoader(), new Class[]{IFun.class}, new MyInvocationHandler());
        proxyObject.helloWorld();


    }
}
