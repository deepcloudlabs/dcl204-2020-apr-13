package com.example.lottery.app;

import com.example.lottery.service.LotteryService;
import com.example.random.service.RandomNumberService;
import java.util.ServiceLoader;
// (1) OSGI : bundle (i) version (ii) OSGI runtime -> Hot-plug
//     Enterprise OSGI
//     OSGIfy
// (2) JBoss 6 -> MSC (Modular Service Container)
// (3) Java 9 Modules:
// App --> lottery , random
//           |         /\
//           |_________|
//       Module -> Jar -> module-info
//                             /\
//                             |
// JVM -> JIT Compiler,   Class Loader, Garbage Collector
public class LotteryApp {
    public static void main(String[] args) {
        LotteryService lotteryService =
                ServiceLoader.load(LotteryService.class)
                             .findFirst().get();
        RandomNumberService randomNumberService =
                ServiceLoader.load(RandomNumberService.class)
                             .findFirst().get();
        // Dependency Injection: setter injection
        lotteryService.setRandomNumberService(
                randomNumberService);
        System.err.println(lotteryService.getClass());
        System.err.println(randomNumberService.getClass());
        // Loosely Coupled : Between classes + Between Modules
        lotteryService.draw(10)
                      .forEach(System.out::println);
    }
}
