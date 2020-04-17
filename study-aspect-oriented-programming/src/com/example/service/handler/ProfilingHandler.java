package com.example.service.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.Instant;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class ProfilingHandler implements InvocationHandler {
    private Object target;

    public ProfilingHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Instant t1 = Instant.now();
        Object result = method.invoke(target, args);
        Instant t2 = Instant.now();
        Duration between = Duration.between(t1, t2);
        System.err.println(String.format("%s runs %d ns.", method.getName(), between.toNanos()));
        return result;
    }
}
