package com.example.service.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class LoggingHandler implements InvocationHandler {
    private Object target;

    public LoggingHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.err.println(String.format("%s is called at %s", method.getName(), new Date()));
        System.err.println(String.format("Parameters are %s", Arrays.toString(args)));
        Object result = method.invoke(target, args); // target object is running
        System.err.println(String.format("%s return %s", method.getName(), result));
        return result;
    }
}
