package ru.stqa.pft.sandbox;

public class Square {

    public double l;

    public Square(double l) {
        if (l >= 0) {
            this.l = l;
        } else {
            System.out.println("Сторона не может быть меньше 0");
        }

    }

    public double area() {
        return this.l * this.l;
    }

    public double perimeter() {
        return this.l * 4;
    }

}
