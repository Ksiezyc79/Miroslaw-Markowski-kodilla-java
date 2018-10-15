package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public final class Continent {

    private final String name;
    private final List<Country> countriesOnTheContinent = new ArrayList<>();

    public Continent(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addCountry (Country country) {
        countriesOnTheContinent.add(country);
    }

    public List<Country> getCountriesOnTheContinent() {
        return countriesOnTheContinent;
    }
}
