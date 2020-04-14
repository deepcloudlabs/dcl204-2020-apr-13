package com.example;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
// 1. Polymorphism -> Abstract
// 2. Single Inheritance vs Multiple Inheritance

// 1. Abstract Class : attr. + constructor + abstract method + concrete method
// Plane, Bird, Superman, UFO : fly()
// abstract class Flyable {
//    public abstract void fly();
// }
// class Plane extends Flyable {}
// class Bird extends Flyable {}
// class Superman extends Flyable {}
// class UFO extends Flyable {}
// Account, Bank, Customer, String, ... -> new -> Concrete Class

// 2. Interface : Multiple Inheritance
// Interface = Abstract Class - attr. - constructor - concrete method
// Interface = Abstract Class with only abstract method
// class extends A implements B , C, D {}
// public interface B {}
// public interface C {}
// public interface D {}
// public interface X {}
// public interface Y {}
// public interface Z extends X , Y {}
public class InterfaceAndAbstractClassNotes {

    public static void main(String[] args) {
    }
}

/*
class D { int x;}
class A extends D {}
class B extends D {}
class C extends A , B { // multiple inheritance
    public void fun(){
        x++; // diamond problem
    }
}
 */