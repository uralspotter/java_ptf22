package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

    @Test
    public void distancePointsFirstTest() {
        Point p1 = new Point(1,1);
        Point p2 = new Point(1, 1);
        Assert.assertEquals(p1.distanceMethod(p2), 0.0);
    }

    @Test
    public void distancePointsSecondTest() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 4);
        Assert.assertEquals(p1.distanceMethod(p2), 3.0);
    }

    @Test
    public void distancePointsThirdTest() {
        // test fail
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2,2);
        Assert.assertEquals(p1.distanceMethod(p2), 2);
    }
}
