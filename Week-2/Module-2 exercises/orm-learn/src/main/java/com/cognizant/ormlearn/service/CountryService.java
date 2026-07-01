package com.cognizant.ormlearn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

/**
 * Service layer for Country operations.
 * Exposes basic CRUD plus advanced query-method, JPQL, and native-query features.
 */
@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    // ===================================================================
    //  BASIC CRUD
    // ===================================================================

    @Transactional
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Transactional
    public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
        Optional<Country> result = countryRepository.findById(countryCode);
        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country with code " + countryCode + " does not exist");
        }
        return result.get();
    }

    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    @Transactional
    public void updateCountry(String code, String newName) throws CountryNotFoundException {
        Country country = findCountryByCode(code);
        country.setName(newName);
        countryRepository.save(country);
    }

    @Transactional
    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }

    // ===================================================================
    //  DERIVED QUERY METHODS
    // ===================================================================

    /** Countries whose name contains the keyword (LIKE '%keyword%'). */
    @Transactional
    public List<Country> findCountriesByPartialName(String keyword) {
        return countryRepository.findByNameContaining(keyword);
    }

    /** Countries whose name starts with the given prefix (LIKE 'prefix%'). */
    @Transactional
    public List<Country> findByNameStartingWith(String prefix) {
        return countryRepository.findByNameStartingWith(prefix);
    }

    /** All countries sorted by name A-Z. */
    @Transactional
    public List<Country> findAllSortedByNameAsc() {
        return countryRepository.findAllByOrderByNameAsc();
    }

    /** All countries sorted by name Z-A. */
    @Transactional
    public List<Country> findAllSortedByNameDesc() {
        return countryRepository.findAllByOrderByNameDesc();
    }

    /** Countries with code alphabetically after the given value. */
    @Transactional
    public List<Country> findByCodeGreaterThan(String code) {
        return countryRepository.findByCodeGreaterThan(code);
    }

    /** Countries with code alphabetically before the given value. */
    @Transactional
    public List<Country> findByCodeLessThan(String code) {
        return countryRepository.findByCodeLessThan(code);
    }

    /** Returns the first N countries ordered by name ascending. */
    @Transactional
    public List<Country> findTopNCountries(int n) {
        return countryRepository.findTopByOrderByNameAsc(PageRequest.of(0, n));
    }

    // ===================================================================
    //  JPQL / HQL QUERIES
    // ===================================================================

    /** Searches by name using a JPQL LIKE query. */
    @Transactional
    public List<Country> searchByNameJPQL(String keyword) {
        return countryRepository.searchByNameJPQL(keyword);
    }

    /** Counts total countries using JPQL aggregate. */
    @Transactional
    public long countAllCountriesJPQL() {
        return countryRepository.countAllCountriesJPQL();
    }

    /** Countries whose code is between two values (JPQL). */
    @Transactional
    public List<Country> findByCodeBetweenJPQL(String start, String end) {
        return countryRepository.findByCodeBetweenJPQL(start, end);
    }

    // ===================================================================
    //  NATIVE SQL QUERIES
    // ===================================================================

    /** Searches by name using a native MySQL query. */
    @Transactional
    public List<Country> searchByNameNative(String keyword) {
        return countryRepository.searchByNameNative(keyword);
    }

    /** Counts total countries using native SQL. */
    @Transactional
    public long countAllCountriesNative() {
        return countryRepository.countAllCountriesNative();
    }
}
