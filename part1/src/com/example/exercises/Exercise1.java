package com.example.exercises;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.dao.InMemoryWorldDao;
import com.example.dao.WorldDao;
import com.example.domain.Country;
import com.example.domain.Movie;
import com.example.service.InMemoryMovieService;
import com.example.service.MovieService;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise1 {
	private static final WorldDao worldDAO = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		// Find the continents list
        final Collection<Country> countries = worldDAO.findAllCountries();
		Comparator<String> dictionaryOrderDesc =
				(r, s) -> s.compareTo(r); // partial order
		List<String> continents = countries.stream()
				 //.map( country -> country.getContinent() ) // Lambda Expression
				 .map( Country::getContinent ) // Method Reference
				 .peek(System.out::println)
				 .distinct()
				 .peek( continent -> {
					 System.out.println("After distinct: "+continent);
				 })
				 .sorted(dictionaryOrderDesc)
				 .peek(System.out::println)
				 .collect(Collectors.toList());
		System.out.println(continents);
		Map<String,Long> groupByContinentCounts = countries.stream()
				 .collect(Collectors.groupingBy(
				 		     Country::getContinent,
						     Collectors.counting()
						 )
				 );
		System.out.println(groupByContinentCounts);
		Map<String,List<Country>> groupByContinentCountries = countries.stream()
				 .collect(Collectors.groupingBy(
				 		     Country::getContinent
						 )
				 );
		System.out.println(groupByContinentCountries);
	}

}
