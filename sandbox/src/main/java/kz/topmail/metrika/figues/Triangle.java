package kz.topmail.metrika.figues;

import java.util.Objects;

public class Triangle {

    double side1;
    double side2;
    double side3;


    public Triangle(double side1, double side2, double side3) {

        if (side1 < 0 || side2 < 0 || side3 < 0) {
            throw new IllegalArgumentException("Side of triangle should be positive");
        } else if (side1 + side2 < side3 || side1 + side3 < side2 ||
                side2 + side3 < side1) {
            throw new IllegalArgumentException("Side of triangle is not correct");
        }

        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    //Perimeter calculation
    public static void CalculatePerimeterTriangle(Triangle triangle) {
//        if(triangle.side1 < 0 || triangle.side2 < 0 || triangle.side3 < 0) {
//            throw new IllegalArgumentException("Side of triangle should be positive");
//        } else if(triangle.side1 + triangle.side2 < triangle.side3 || triangle.side1 + triangle.side3 < triangle.side2 ||
//                triangle.side2 + triangle.side3 < triangle.side1) {
//            throw new IllegalArgumentException("Side of triangle is not correct");
//        } else {
        System.out.println("Perimeter of Triangle = " + triangle.perimeter());
//            }
    }

    public double perimeter() {
        return this.side1 + this.side2 + this.side3;
    }

    //Square calculation
    public static void CalculateSquareTriangle(Triangle triangle) {
        System.out.println("Square of Triangle = " + triangle.square());
    }

    public double square() {
        double halfSquare = (this.side1 + this.side2 + this.side3) / 2;
        return Math.round(Math.sqrt((halfSquare - this.side1) * (halfSquare - this.side2) * (halfSquare - this.side3)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.side1, this.side1) == 0 && Double.compare(triangle.side2, this.side2) == 0 && Double.compare(triangle.side3, this.side3) == 0
            || Double.compare(triangle.side1, this.side2) == 0 && Double.compare(triangle.side2, this.side3) == 0 && Double.compare(triangle.side3, this.side1) == 0
            || Double.compare(triangle.side1, this.side3) == 0 && Double.compare(triangle.side2, this.side1) == 0 && Double.compare(triangle.side3, this.side2) == 0
            || Double.compare(triangle.side1, this.side1) == 0 && Double.compare(triangle.side2, this.side3) == 0 && Double.compare(triangle.side3, this.side2) == 0
            || Double.compare(triangle.side1, this.side3) == 0 && Double.compare(triangle.side2, this.side2) == 0 && Double.compare(triangle.side3, this.side1) == 0
            || Double.compare(triangle.side1, this.side2) == 0 && Double.compare(triangle.side2, this.side1) == 0 && Double.compare(triangle.side3, this.side3) == 0;
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
