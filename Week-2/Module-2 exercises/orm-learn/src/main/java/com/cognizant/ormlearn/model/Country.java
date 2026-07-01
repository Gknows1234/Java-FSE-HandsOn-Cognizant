package com.cognizant.ormlearn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity class that maps to the 'country' table in the ormlearn schema.
 * Each record stores a two-letter ISO country code along with its full name.
 */
@Entity
@Table(name = "country")
public class Country {

    @Id
    @Column(name = "co_code", length = 2)
    private String code;

    @Column(name = "co_name", length = 50)
    private String name;

    /** No-argument constructor required by JPA specification. */
    public Country() {
    }

    /**
     * Convenience constructor for quickly building a Country instance.
     *
     * @param code two-character country code (e.g. "IN")
     * @param name full country name (e.g. "India")
     */
    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    // ---- Accessor methods ----

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns a human-readable representation of this Country.
     */
    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + "]";
    }
}
