package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

public class ArrayOperationsTestSuite {

    @Test
    public void testGetAverage() {
        //given
        int numbers [] = {1,2,3,4,5,6,7,8,9};
        double trialAverage = 5;
        //when
        double average = ArrayOperations.getAverage(numbers);
        //then
        Assert.assertEquals(trialAverage, average, 0.1 );

    }


}
