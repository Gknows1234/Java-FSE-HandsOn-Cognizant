package com.cognizant.ormlearn;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

/**
 * Entry point for the orm-learn application.
 *
 * Runs test methods for every major feature area:
 *  - Country CRUD (Hands-on 1 / 5 / 6 / 7)
 *  - Derived query methods (containing, startingWith, sorting, top-N, etc.)
 *  - JPQL / HQL queries with aggregates
 *  - Native SQL queries
 *  - O/R mapping relationships tested through Employee and Department
 *
 * REST endpoints are also available at /api/** once the app starts.
 */
@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryService countryService;
    private static EmployeeService employeeService;
    private static DepartmentService departmentService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);
        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);

        LOGGER.info("ORM-Learn application started successfully");

        // =========  COUNTRY CRUD  =========
        testGetAllCountries();
        testFindCountryByCode();
        testAddCountry();
        testUpdateCountry();
        testDeleteCountry();

        // =========  QUERY METHODS  =========
        testFindByPartialName();
        testFindByNameStartingWith();
        testFindSortedByName();
        testFindByCodeRange();
        testFindTopNCountries();

        // =========  JPQL / HQL  =========
        testSearchByNameJPQL();
        testCountCountriesJPQL();
        testCodeBetweenJPQL();

        // =========  NATIVE SQL  =========
        testSearchByNameNative();
        testCountCountriesNative();

        // =========  EMPLOYEE / DEPARTMENT (O/R Mapping + REST)  =========
        testGetAllEmployees();
        testEmployeeSalaryAggregates();
        testEmployeeFetchWithDepartment();

        LOGGER.info("All tests completed. REST endpoints live at http://localhost:8080/api/");
    }

    // ===================================================================
    //  COUNTRY CRUD TESTS
    // ===================================================================

    private static void testGetAllCountries() {
        LOGGER.info("--- testGetAllCountries START ---");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("Total countries: {}", countries.size());
        LOGGER.info("--- testGetAllCountries END ---");
    }

    private static void testFindCountryByCode() {
        LOGGER.info("--- testFindCountryByCode START ---");
        try {
            Country country = countryService.findCountryByCode("IN");
            LOGGER.debug("Found: {}", country);
        } catch (CountryNotFoundException ex) {
            LOGGER.error("Lookup failed: {}", ex.getMessage());
        }
        LOGGER.info("--- testFindCountryByCode END ---");
    }

    private static void testAddCountry() {
        LOGGER.info("--- testAddCountry START ---");
        Country newCountry = new Country("ZZ", "Testland");
        countryService.addCountry(newCountry);
        LOGGER.debug("Inserted: {}", newCountry);
        try {
            Country fetched = countryService.findCountryByCode("ZZ");
            LOGGER.debug("Verified: {}", fetched);
        } catch (CountryNotFoundException ex) {
            LOGGER.error("Insert verification failed: {}", ex.getMessage());
        }
        LOGGER.info("--- testAddCountry END ---");
    }

    private static void testUpdateCountry() {
        LOGGER.info("--- testUpdateCountry START ---");
        try {
            countryService.updateCountry("ZZ", "Testlandia Updated");
            Country updated = countryService.findCountryByCode("ZZ");
            LOGGER.debug("After update: {}", updated);
        } catch (CountryNotFoundException ex) {
            LOGGER.error("Update failed: {}", ex.getMessage());
        }
        LOGGER.info("--- testUpdateCountry END ---");
    }

    private static void testDeleteCountry() {
        LOGGER.info("--- testDeleteCountry START ---");
        countryService.deleteCountry("ZZ");
        try {
            countryService.findCountryByCode("ZZ");
        } catch (CountryNotFoundException ex) {
            LOGGER.debug("Confirmed deletion: {}", ex.getMessage());
        }
        LOGGER.info("--- testDeleteCountry END ---");
    }

    // ===================================================================
    //  DERIVED QUERY METHOD TESTS
    // ===================================================================

    private static void testFindByPartialName() {
        LOGGER.info("--- testFindByPartialName START ---");
        List<Country> results = countryService.findCountriesByPartialName("land");
        LOGGER.debug("Countries containing 'land': {} records", results.size());
        results.forEach(c -> LOGGER.debug("  {}", c));
        LOGGER.info("--- testFindByPartialName END ---");
    }

    private static void testFindByNameStartingWith() {
        LOGGER.info("--- testFindByNameStartingWith START ---");
        List<Country> results = countryService.findByNameStartingWith("New");
        LOGGER.debug("Countries starting with 'New': {} records", results.size());
        results.forEach(c -> LOGGER.debug("  {}", c));
        LOGGER.info("--- testFindByNameStartingWith END ---");
    }

    private static void testFindSortedByName() {
        LOGGER.info("--- testFindSortedByName START ---");
        List<Country> ascending = countryService.findAllSortedByNameAsc();
        LOGGER.debug("First country (A-Z): {}", ascending.isEmpty() ? "none" : ascending.get(0));
        LOGGER.debug("Last  country (A-Z): {}", ascending.isEmpty() ? "none" : ascending.get(ascending.size() - 1));

        List<Country> descending = countryService.findAllSortedByNameDesc();
        LOGGER.debug("First country (Z-A): {}", descending.isEmpty() ? "none" : descending.get(0));
        LOGGER.info("--- testFindSortedByName END ---");
    }

    private static void testFindByCodeRange() {
        LOGGER.info("--- testFindByCodeRange START ---");
        List<Country> greaterThan = countryService.findByCodeGreaterThan("US");
        LOGGER.debug("Countries with code > 'US': {} records", greaterThan.size());

        List<Country> lessThan = countryService.findByCodeLessThan("BE");
        LOGGER.debug("Countries with code < 'BE': {} records", lessThan.size());
        LOGGER.info("--- testFindByCodeRange END ---");
    }

    private static void testFindTopNCountries() {
        LOGGER.info("--- testFindTopNCountries START ---");
        List<Country> topFive = countryService.findTopNCountries(5);
        LOGGER.debug("Top 5 countries by name:");
        topFive.forEach(c -> LOGGER.debug("  {}", c));
        LOGGER.info("--- testFindTopNCountries END ---");
    }

    // ===================================================================
    //  JPQL / HQL TESTS
    // ===================================================================

    private static void testSearchByNameJPQL() {
        LOGGER.info("--- testSearchByNameJPQL START ---");
        List<Country> results = countryService.searchByNameJPQL("Republic");
        LOGGER.debug("JPQL search for 'Republic': {} records", results.size());
        results.forEach(c -> LOGGER.debug("  {}", c));
        LOGGER.info("--- testSearchByNameJPQL END ---");
    }

    private static void testCountCountriesJPQL() {
        LOGGER.info("--- testCountCountriesJPQL START ---");
        long total = countryService.countAllCountriesJPQL();
        LOGGER.debug("JPQL COUNT: {} countries in database", total);
        LOGGER.info("--- testCountCountriesJPQL END ---");
    }

    private static void testCodeBetweenJPQL() {
        LOGGER.info("--- testCodeBetweenJPQL START ---");
        List<Country> results = countryService.findByCodeBetweenJPQL("CA", "CZ");
        LOGGER.debug("JPQL BETWEEN CA and CZ: {} records", results.size());
        results.forEach(c -> LOGGER.debug("  {}", c));
        LOGGER.info("--- testCodeBetweenJPQL END ---");
    }

    // ===================================================================
    //  NATIVE SQL TESTS
    // ===================================================================

    private static void testSearchByNameNative() {
        LOGGER.info("--- testSearchByNameNative START ---");
        List<Country> results = countryService.searchByNameNative("United");
        LOGGER.debug("Native search for 'United': {} records", results.size());
        results.forEach(c -> LOGGER.debug("  {}", c));
        LOGGER.info("--- testSearchByNameNative END ---");
    }

    private static void testCountCountriesNative() {
        LOGGER.info("--- testCountCountriesNative START ---");
        long total = countryService.countAllCountriesNative();
        LOGGER.debug("Native COUNT: {} countries", total);
        LOGGER.info("--- testCountCountriesNative END ---");
    }

    // ===================================================================
    //  EMPLOYEE / DEPARTMENT TESTS (O/R Mapping verification)
    // ===================================================================

    private static void testGetAllEmployees() {
        LOGGER.info("--- testGetAllEmployees START ---");
        List<Employee> employees = employeeService.getAllEmployees();
        LOGGER.debug("Total employees: {}", employees.size());
        employees.forEach(e -> LOGGER.debug("  {}", e));
        LOGGER.info("--- testGetAllEmployees END ---");
    }

    private static void testEmployeeSalaryAggregates() {
        LOGGER.info("--- testEmployeeSalaryAggregates START ---");
        BigDecimal avg = employeeService.getAverageSalary();
        BigDecimal max = employeeService.getMaxSalary();
        BigDecimal min = employeeService.getMinSalary();
        BigDecimal total = employeeService.getTotalSalaryNative();
        LOGGER.debug("Average salary : {}", avg);
        LOGGER.debug("Maximum salary : {}", max);
        LOGGER.debug("Minimum salary : {}", min);
        LOGGER.debug("Total payroll  : {}", total);
        LOGGER.info("--- testEmployeeSalaryAggregates END ---");
    }

    private static void testEmployeeFetchWithDepartment() {
        LOGGER.info("--- testEmployeeFetchWithDepartment START ---");
        Employee emp = employeeService.findByIdWithDepartment(1);
        if (emp != null) {
            LOGGER.debug("Employee with department (HQL fetch): {}", emp);
        } else {
            LOGGER.debug("Employee id=1 not found (run the SQL seed script first)");
        }
        LOGGER.info("--- testEmployeeFetchWithDepartment END ---");
    }
}
