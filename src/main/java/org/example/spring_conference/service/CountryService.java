package org.example.spring_conference.service;

import org.example.spring_conference.model.Country;
import org.example.spring_conference.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Country save(Country country) {
        return countryRepository.save(country);
    }

    public List<Country> saveAll(List<Country> countries) {
        return countryRepository.saveAll(countries);
    }
}
