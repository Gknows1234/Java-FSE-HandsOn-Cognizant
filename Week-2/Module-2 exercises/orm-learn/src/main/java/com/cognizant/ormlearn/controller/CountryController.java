package com.cognizant.ormlearn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

/**
 * REST controller that exposes country-related endpoints.
 *
 * Test in Postman:
 *   GET    http://localhost:8080/api/countries
 *   GET    http://localhost:8080/api/countries/{code}
 *   GET    http://localhost:8080/api/countries/search?keyword=land
 *   POST   http://localhost:8080/api/countries         (body: JSON)
 *   PUT    http://localhost:8080/api/countries/{code}   (body: JSON)
 *   DELETE http://localhost:8080/api/countries/{code}
 */
@RestController
@RequestMapping("/api")
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    /** Returns all countries. */
    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        LOGGER.info("GET /api/countries invoked");
        return countryService.getAllCountries();
    }

    /** Returns a single country by its two-letter code. */
    @GetMapping("/countries/{code}")
    public Country getCountryByCode(@PathVariable String code) throws CountryNotFoundException {
        LOGGER.info("GET /api/countries/{} invoked", code);
        return countryService.findCountryByCode(code);
    }

    /** Searches countries by partial name match. */
    @GetMapping("/countries/search")
    public List<Country> searchCountries(@RequestParam String keyword) {
        LOGGER.info("GET /api/countries/search?keyword={} invoked", keyword);
        return countryService.findCountriesByPartialName(keyword);
    }

    /** Adds a new country. */
    @PostMapping("/countries")
    public String addCountry(@RequestBody Country country) {
        LOGGER.info("POST /api/countries invoked for {}", country);
        countryService.addCountry(country);
        return "Country added successfully";
    }

    /** Updates an existing country's name. */
    @PutMapping("/countries/{code}")
    public String updateCountry(@PathVariable String code,
                                @RequestBody Country country) throws CountryNotFoundException {
        LOGGER.info("PUT /api/countries/{} invoked", code);
        countryService.updateCountry(code, country.getName());
        return "Country updated successfully";
    }

    /** Deletes a country by code. */
    @DeleteMapping("/countries/{code}")
    public String deleteCountry(@PathVariable String code) {
        LOGGER.info("DELETE /api/countries/{} invoked", code);
        countryService.deleteCountry(code);
        return "Country deleted successfully";
    }
}
