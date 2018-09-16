package com.kodilla.testing.shape;

import org.junit.*;

public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is Start of tests");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("Tests are finished");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void testAddAndGetFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.showFigures();
        Shape square = new Square(5);
        //When
        shapeCollector.addFigure(square);
        shapeCollector.showFigures();
        Shape result = shapeCollector.getFigure(0);
        //Then
        Assert.assertEquals(square, result);
    }

    @Test
    public void testRemoveFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Square square = new Square(5);
        shapeCollector.addFigure(square);
        //When
        boolean result = shapeCollector.removeFigure(square);
        //Then
        Assert.assertTrue(result);
    }
}