package ru.stqa.pft.sandbox;

public class Point {
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static void main(String[] args) {
        Point p1 = new Point(4, 6);
        Point p2 = new Point(6, 4);
        System.out.println("Расстояние между точкой p1 с координатой х=" + p1.x + " y=" + p1.y + " и p2 с координатами x=" + p2.x + " y=" + p2.y + " равно " + distance(p1, p2) + " рассчитанный функцией");
        System.out.println("Расстояние между точкой p1 с координатой х=" + p1.x + " y=" + p1.y + " и p2 с координатами x=" + p2.x + " y=" + p2.y + " равно " + p1.distanceMethod(p2) + " рассчитанный методом");

    }

    public static double distance(Point p1, Point p2) {
        return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
    }

    public double distanceMethod(Point p2) {
        return Math.sqrt((p2.x - this.x) * (p2.x - this.x) + (p2.y - this.y) * (p2.y - this.y));
    }
}
