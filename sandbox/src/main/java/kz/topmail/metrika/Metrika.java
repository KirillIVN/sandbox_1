package kz.topmail.metrika;

import kz.topmail.metrika.figues.Triangle;

public class Metrika {

    public static void main(String[] args) {
        Triangle.CalculatePerimeterTriangle(new Triangle(4., 2., 5.));
        Triangle.CalculateSquareTriangle(new Triangle(2.0, 2.0, -5.0));

    }
}