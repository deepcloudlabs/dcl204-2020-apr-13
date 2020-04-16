package com.example.exercises;

import com.example.dao.CountryDao;
import com.example.dao.InMemoryWorldDao;
import com.example.domain.Country;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class Exercise6 {
    private static final CountryDao countryDao = InMemoryWorldDao.getInstance();

    public static void main(String[] args) {
        // Sort the countries by number of their cities in descending order
        List<Country> countries = countryDao.findAllCountries();

        Predicate<Country> countriesHavingAtLeastOneCity = country -> country.getCities().size() > 0;
        Consumer<Country> printCountry = System.out::println;
        countries.stream()
                .filter(countriesHavingAtLeastOneCity)
                .sorted((c1, c2) -> c2.getCities().size() - c1.getCities().size())
                .forEach(printCountry);

        Comparator<Country> comparingByCitySize =
                Comparator.comparing(country -> country.getCities().size());
        Comparator<Country> comparingByCitySizeDesc = comparingByCitySize.reversed();
        countries.stream() // DSL : Domain Specific Language
                .filter(countriesHavingAtLeastOneCity)
                .sorted(comparingByCitySizeDesc)
                .forEach(printCountry);
    }

}
