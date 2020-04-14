package com.example.animals;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
// concrete : you can create an instance using new operator
public class Cat extends Animal implements Pet {
    private String name;

    public Cat() { // default/no-arg constructor
        this("Tekir");
    }

    public Cat(String name) {
        super(4); // delegates to Animal(int)
        this.name = name;
    }

    @Override
    public void eat() {
        System.err.println(String.format("%s is eating now...",name));
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void play() {
        System.err.println(String.format("%s is playing now...",name));
    }
}
