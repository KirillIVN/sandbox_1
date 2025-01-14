package kz.topmail.metrika.figues;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PerimeterTests {

    @Test
    void checkTriangle() {
        Triangle triangle = new Triangle(4., 5., 5.);
        double result = triangle.perimeter();
        Assertions.assertEquals(14.0, result);
    }

    @Test
    void checkTriangleSide() {
        try {
            new Triangle(4., 5., -5.);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
//        OK
        }
    }
}

