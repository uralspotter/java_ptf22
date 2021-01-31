package ru.stqa.pft.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {

        hello("world");
        hello("user");

        Square s = new Square(5);
        System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());
        Square s1 = new Square(5);
        System.out.println("Периметр квадрата со стороной " + s1.l + " = " + s1.perimeter());
        Square s2 = new Square(-5);

        Rectangle r = new Rectangle(4, 6);
        System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());
        System.out.println("Периметр прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.perimeter());
        Rectangle r1 = new Rectangle(-1, 2);
        Rectangle r2 = new Rectangle(1, -2);

        Point p1 = new Point(1,1);
        Point p2 = new Point(4, 1);
        System.out.println("Расстояние между точкой p1 с координатой х=" + p1.x + " y=" + p1.y + " и p2 с координатами x=" + p2.x + " y=" + p2.y + " равно " + distance(p1, p2) + " рассчитанное функцией");
        System.out.println("Расстояние между точкой p1 с координатой х=" + p1.x + " y=" + p1.y + " и p2 с координатами x=" + p2.x + " y=" + p2.y + " равно " + p1.distancePlane(p2) + " рассчитанное методом");

        Point p3 = new Point(1, 1, 1);
        Point p4 = new Point(4, 2, 2);
        System.out.println("Расстояние между точкой p1 с координатой х=" + p3.x + " y=" + p3.y + " z=" + p3.z + " и точкой p2 с координатами x=" + p4.x + " y=" + p4.y + " z=" + p4.z + " равно " + p3.distanceArea(p4));

    }

    public static void hello(String somebody) {
        System.out.println("Hello, " + somebody + "!");
    }

    public static double distance(Point p1, Point p2) {
        return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
    }

}