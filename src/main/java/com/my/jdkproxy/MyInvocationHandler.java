package com.my.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.SQLException;

class MyFun implements IFun {

    @Override
    public void helloWorld() throws SQLException {
        throw new SQLException("throw exception");
    }
}

/**
 * @author mrjimmylin
 * @description 自定调用处理类
 * @date 2019/9/20 13:23
 */
public class MyInvocationHandler implements InvocationHandler {

    private IFun iFun;

    public MyInvocationHandler(IFun iFun) {
        this.iFun = iFun;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(iFun, args);
    }
}
