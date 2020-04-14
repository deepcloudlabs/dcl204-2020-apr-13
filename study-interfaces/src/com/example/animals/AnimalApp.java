package com.example.animals;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class AnimalApp {
    public static void main(String[] args) {
        List<Animal> animals = List.of(
                new Cat("Garfield"),
                new Spider(),
                new Fish("Free Willy"),
                new Cat(),
                new Spider(),
                new Fish("Jaws")
        );
        for (Animal animal : animals) {
            animal.walk();
            animal.eat();
            if (animal instanceof Pet) {
                ((Pet) animal).play();
            }
        }
        // Java 8
        Consumer<Animal> walk = Animal::walk;
        Consumer<Animal> eat = Animal::eat;
        Consumer<Animal> playIfPet = animal -> {
            if (animal instanceof Pet) {
                ((Pet) animal).play();
            }
        };
        animals.forEach(walk.andThen(eat).andThen(playIfPet));
        int numOfLegs = animals.stream().mapToInt(Animal::getLegs).sum();
        Predicate<Animal> isPet = Pet.class::isInstance;
        long numOfPet = animals.stream().filter(isPet).count();
        long numOfWild = animals.stream().filter(isPet.negate()).count();
        System.out.println("numOfLegs=" + numOfLegs);
        System.out.println("numOfPet=" + numOfPet);
        System.out.println("numOfWild=" + numOfWild);
        List<Animal> pet = animals.stream()
                .peek(System.out::println)
                .filter(isPet)
                .peek(System.out::println)
                .collect(Collectors.toList());
        List<Animal> wild = animals.stream().filter(isPet.negate())
                .collect(Collectors.toList());
    }
}
