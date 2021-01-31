package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

    @Test
    public void distancePointsFirstTest() {
        Point p1 = new Point(1,1);
        Point p2 = new Point(1, 1);
        Assert.assertEquals(p1.distancePlane(p2), 0.0);
    }

    @Test
    public void distancePointsSecondTest() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 4);
        Assert.assertEquals(p1.distancePlane(p2), 3.0);
    }

    @Test
    public void distancePointsThirdTest() {
        // test fail
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2,2);
        Assert.assertEquals(p1.distancePlane(p2), 2);
    }

    @Test
    public void distanceAreaFirstTest() {
        Point p1 = new Point(1, 1, 1);
        Point p2 = new Point(4, 1, 1);
        Assert.assertEquals(p1.distanceArea(p2), 3.0);
    }

    @Test
    public void distanceAreaSecondTest() {
        Point p1 = new Point(1, 1, 2);
        Point p2 = new Point(2, 3, 4);
        Assert.assertEquals(p1.distanceArea(p2), 3.0);
    }

    @Test
    public void distanceAreaThirdTest() {
        // test fail
        Point p1 = new Point(1, 2, 3);
        Point p2 = new Point(3, 2, 1);
        Assert.assertEquals(p1.distanceArea(p2), 2.8284);
    }
}
