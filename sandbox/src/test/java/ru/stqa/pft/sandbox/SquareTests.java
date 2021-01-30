package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SquareTests {

    @Test
    public void testAreaWithAssert() {
        Square s = new Square(5);
        assert s.area() == 25.0;
    }

    @Test
    public void testAreaWithAssertEquals() {
        Square s = new Square(5);
        Assert.assertEquals(s.area(), 25.0);
    }

}
