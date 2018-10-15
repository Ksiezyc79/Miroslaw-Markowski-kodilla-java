package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class World {
    private final List<Continent> countriesOfTheWorld = new ArrayList<>();

    public void addCountryOfTheWorld(Continent continent) {
        countriesOfTheWorld.add(continent);
    }

    public List<Continent> getCountriesOfTheWorld() {
        return countriesOfTheWorld;
    }

    public BigDecimal getPeopleQuantity() {
        BigDecimal peopleInTheWorld = countriesOfTheWorld.stream()
                .flatMap(continent -> continent.getCountriesOnTheContinent().stream())
                .map(country -> country.getPeopleQuantity())
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));

        return peopleInTheWorld;
    }
}