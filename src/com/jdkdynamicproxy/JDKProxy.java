package com.jdkdynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author create by  huarong
 */
public class JDKProxy implements InvocationHandler {
    //被代理对象
    private Object object;

    public JDKProxy (Object object){
        this.object=object;
    }
    //获取代理对象
    public Object getProxy(){
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before-------------");
        Object result=method.invoke(object,args);
        System.out.println("after-------------");
        return result;
    }
}
