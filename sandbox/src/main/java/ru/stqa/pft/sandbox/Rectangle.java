package ru.stqa.pft.sandbox;

public class Rectangle {

    public double a;
    public double b;

    public Rectangle(double a, double b) {
        if (a >= 0 && b >= 0) {
            this.a = a;
            this.b = b;
        } else {
            System.out.println("Одна из сторон указана отрицательной, объект не создан");
        }
    }

    public double area() {
        return this.a * this.b;
    }

    public double perimeter() {
        return this.a * 2 + this.b * 2;
    }
}
