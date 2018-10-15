package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WorldTestSuite {

    @Test
    public void testGetPeopleQuantity() {

        //Given
        World world = new World();

        Continent europe = new Continent("Europa");
        Continent australia = new Continent("Australia");
        Continent afryka = new Continent("Afryka");
        world.addCountryOfTheWorld(europe);
        world.addCountryOfTheWorld(australia);
        world.addCountryOfTheWorld(afryka);

        Country country1 = new Country("Polska", new BigDecimal("2000000"));
        Country country2 = new Country("Niemcy", new BigDecimal("3000000"));
        Country country3 = new Country("Australia", new BigDecimal("1000000"));
        Country country4 = new Country("Etiopia", new BigDecimal("1500000"));
        Country country5 = new Country("Egipt", new BigDecimal("2500000"));

        europe.addCountry(country1);
        europe.addCountry(country2);

        australia.addCountry(country3);

        afryka.addCountry(country4);
        afryka.addCountry(country5);

        //When
        BigDecimal total = new BigDecimal("10000000");
        BigDecimal quantity = world.getPeopleQuantity();

        //Then
        Assert.assertEquals(total, quantity);
    }
}




