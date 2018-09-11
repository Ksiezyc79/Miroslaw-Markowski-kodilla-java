package com.kodilla.testing.collection;

import com.kodilla.testing.collection.OddNumbersExterminator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class TestOddNumbersExterminator {

    @Before
    public void before() {
        System.out.println("Test Start");
    }

    @After
    public void after() {
        System.out.println("Test end");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        ArrayList<Integer> empty = new ArrayList<>();
        //When
        ArrayList<Integer> resultList = oddNumbersExterminator.exterminate(empty);
        System.out.println("Test: empty list");
        //Then
        Assert.assertEquals(empty, resultList);
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        ArrayList<Integer> testList = new ArrayList<>();
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        testList.add(5);

        /*lub przez pętlę
        for (int n=0; n<5; n++) {
        testList.add(n+1);
        }*/

        //When
        ArrayList<Integer> resultList = oddNumbersExterminator.exterminate(testList);
        System.out.println ("Test: test List");
        //Then
        ArrayList<Integer> expectedList = new ArrayList<>();
        expectedList.add(2);
        expectedList.add(4);

        Assert.assertEquals(expectedList, resultList);

    }
}
