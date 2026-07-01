package com.cognizant.ormlearn.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Country;

/**
 * Repository for the Country entity showcasing several Spring Data JPA features:
 *
 *  1. Derived query methods  (containing, startingWith, sorted, top-N)
 *  2. JPQL / HQL via @Query
 *  3. Native SQL via @Query(nativeQuery = true)
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    // -------------------------------------------------------------------
    //  DERIVED QUERY METHODS (Spring Data JPA auto-generates the SQL)
    // -------------------------------------------------------------------

    /** Countries whose name contains the given text (LIKE '%text%'). */
    List<Country> findByNameContaining(String keyword);

    /** Countries whose name starts with the given prefix (LIKE 'prefix%'). */
    List<Country> findByNameStartingWith(String prefix);

    /** All countries sorted by name ascending. */
    List<Country> findAllByOrderByNameAsc();

    /** All countries sorted by name descending. */
    List<Country> findAllByOrderByNameDesc();

    /** Countries whose code is alphabetically greater than the given value. */
    List<Country> findByCodeGreaterThan(String code);

    /** Countries whose code is alphabetically less than the given value. */
    List<Country> findByCodeLessThan(String code);

    /**
     * Top-N countries by name alphabetical order.
     * The Pageable parameter controls how many rows are returned.
     */
    List<Country> findTopByOrderByNameAsc(Pageable pageable);

    // -------------------------------------------------------------------
    //  JPQL / HQL QUERIES (database-agnostic object queries)
    // -------------------------------------------------------------------

    /**
     * JPQL query using the 'LIKE' operator.
     * :keyword is bound at runtime.
     */
    @Query("SELECT c FROM Country c WHERE c.name LIKE %:keyword%")
    List<Country> searchByNameJPQL(@Param("keyword") String keyword);

    /**
     * JPQL aggregate: count all records in the country table.
     */
    @Query("SELECT COUNT(c) FROM Country c")
    long countAllCountriesJPQL();

    /**
     * JPQL query that fetches countries whose code falls between two values.
     */
    @Query("SELECT c FROM Country c WHERE c.code BETWEEN :startCode AND :endCode ORDER BY c.code")
    List<Country> findByCodeBetweenJPQL(@Param("startCode") String start,
                                        @Param("endCode") String end);

    // -------------------------------------------------------------------
    //  NATIVE SQL QUERIES (database-specific raw SQL)
    // -------------------------------------------------------------------

    /**
     * Native query example: search by partial name using MySQL syntax.
     */
    @Query(value = "SELECT * FROM country WHERE co_name LIKE %:keyword%", nativeQuery = true)
    List<Country> searchByNameNative(@Param("keyword") String keyword);

    /**
     * Native aggregate: count rows in the country table.
     */
    @Query(value = "SELECT COUNT(*) FROM country", nativeQuery = true)
    long countAllCountriesNative();
}
