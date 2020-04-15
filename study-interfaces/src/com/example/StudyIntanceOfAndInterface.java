package com.example;

public class StudyIntanceOfAndInterface {
    public static void main(String[] args) {
        A a = new B();
        if (a instanceof X) { //false
        }
    }
}

class A {
}

class B extends A {
}

class C  {
}

interface X {}