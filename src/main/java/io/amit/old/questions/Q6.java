package io.amit.old.questions;

/**
 * Software entities (classes, modules, functions) should be open
 *  for extension but closed for modification.
 */



// Base class
abstract class Shape {
    abstract double area();
}

// Extended classes
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double width, height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    double area() {
        return width * height;
    }
}

// Adding new shapes without modifying existing ones



public class Q6 {
}
