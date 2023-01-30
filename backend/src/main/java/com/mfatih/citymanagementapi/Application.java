package com.mfatih.citymanagementapi;

import com.mfatih.citymanagementapi.models.City;
import com.mfatih.citymanagementapi.models.CityCsv;
import com.mfatih.citymanagementapi.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ResourceLoader;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class Application {
	@Autowired
	private CityService cityService;
	@Autowired
	private ResourceLoader resourceLoader;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public ApplicationRunner importCities() throws IOException {
		return args -> {
			InputStream csvInputStream = getClass().getClassLoader().getResourceAsStream("cities.csv");
			CsvSchema schema = CsvSchema.emptySchema().withHeader();
			CsvMapper mapper = new CsvMapper();
			MappingIterator<CityCsv> it = mapper.readerFor(CityCsv.class).with(schema).readValues(csvInputStream);
			List<CityCsv> cities = it.readAll();
			for (CityCsv city : cities){
				cityService.save(new City(city.getName(), city.getPhoto()));
			}
		};
	}
}
