package ru.stqa.pft.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {

        hello("world");
        hello("user");

        Square s = new Square(5);
        System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

        Rectangle r = new Rectangle(4, 6);
        System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());

        Point p1 = new Point(1,1);
        Point p2 = new Point(4, 1);
        System.out.println("Расстояние между точкой p1 с координатой х=" + p1.x + " y=" + p1.y + " и p2 с координатами x=" + p2.x + " y=" + p2.y + " равно " + p1.distanceMethod(p2) + " рассчитанное методом");

    }

    public static void hello(String somebody) {
        System.out.println("Hello, " + somebody + "!");
    }

}