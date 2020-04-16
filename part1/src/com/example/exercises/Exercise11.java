package com.example.exercises;

import com.example.dao.InMemoryWorldDao;
import com.example.dao.WorldDao;
import com.example.domain.Country;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.stream.Collectors;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise11 {
	private static final WorldDao worldDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		// Find the minimum, the maximum and the average population of world countries
		List<Country> countries = worldDao.findAllCountries();
		LongSummaryStatistics popStatistics =
				countries.stream().collect(Collectors.summarizingLong(Country::getPopulation));
		DoubleSummaryStatistics surfAreaStatistics =
				countries.stream().collect(Collectors.summarizingDouble(Country::getSurfaceArea));
		System.out.println(popStatistics);
		System.out.println(surfAreaStatistics);
	}

}
