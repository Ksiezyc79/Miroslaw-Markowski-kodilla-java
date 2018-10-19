package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class World {
    private final List<Continent> continents = new ArrayList<>();

    public void addCountryOfTheWorld(Continent continent) {
        continents.add(continent);
    }

    public List<Continent> getCountriesOfTheWorld() {
        return continents;
    }

    public BigDecimal getPeopleQuantity() {
        BigDecimal peopleInTheWorld = continents.stream()
                .flatMap(continent -> continent.getCountriesOnTheContinent().stream())
                .map(country -> country.getPeopleQuantity())
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));

        return peopleInTheWorld;
    }
}