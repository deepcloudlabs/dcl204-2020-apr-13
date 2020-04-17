package com.example.service.app;

import com.example.service.Calculator;
import com.example.service.handler.LoggingHandler;
import com.example.service.handler.ProfilingHandler;
import com.example.service.impl.SimpleCalculator;

import java.lang.reflect.Proxy;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
// Deployment File Types
// Java SE : JAR (Java ARchive file)
// Java EE : (i) WAR (WebARchive file) -> Web Centric Architecture -> Web Container
//          (ii) EJB-JAR -> EJB Container
//         (iii) RAR (Resource ARchive file) -> JCA Adapter
//          (iv) EAR (Enterprise ARchive file) -> Full Platform
// AOP : (1) Proxy-Based AOP (Java SE 6+, Reflection API)
//       (2) Instrumentation-Based AOP (Spring AOP -> CG Library)
public class CalculatorApp {
    public static void main(String[] args) {
        Calculator calculator = new SimpleCalculator();
        LoggingHandler loggingHandler = new LoggingHandler(calculator);
        Class<? extends Calculator> clazz = calculator.getClass();
        calculator = (Calculator) Proxy.newProxyInstance(
                clazz.getClassLoader(),
                clazz.getInterfaces(),
                loggingHandler);
        ProfilingHandler profilingHandler = new ProfilingHandler(calculator);
        calculator = (Calculator) Proxy.newProxyInstance(
                clazz.getClassLoader(),
                clazz.getInterfaces(),
                profilingHandler);
        System.out.println("3+5=" + calculator.add(3, 5));
        System.out.println("3-5=" + calculator.sub(3, 5));
        System.out.println("3*5=" + calculator.mul(3, 5));
        System.out.println("3/5=" + calculator.div(3, 5));
        System.err.println(calculator.getClass());
    }
}
