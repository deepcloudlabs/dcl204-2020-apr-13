package com.example.animals.exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.example.animals.domain.*;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise1 {
	public static void main(String[] args) {
		// Take a list of wild animals
		List<Animal> animals = Arrays.asList(new Cat(), new Spider(), new Cat("Tekir"), new Fish("Free Willy"),
				new Spider(), new Fish("Jaws"));
		Predicate<Animal> ifPet = Pet.class::isInstance;
		Predicate<Animal> ifWild = ifPet.negate();
		List<Animal> pets = animals.stream()
				        .filter(ifPet)
				        .collect(Collectors.toList());
		List<Animal> wildAnimals = animals.stream()
				        .filter(ifWild)
				        .collect(Collectors.toList());
		System.out.println(pets);
		System.out.println(wildAnimals);
		Map<String,Long> groupByWildOrPetCounts = animals.stream().collect(
				Collectors.groupingBy(
						animal -> Pet.class.isInstance(animal) ? "Pet" : "Wild"
						,Collectors.counting()));
		System.out.println(groupByWildOrPetCounts);
	}
}
