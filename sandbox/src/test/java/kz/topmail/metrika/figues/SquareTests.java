package kz.topmail.metrika.figues;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SquareTests {
    @Test
    void checkSquare() {
        Triangle triangle = new Triangle(4., 5., 5.);
        double result = triangle.square();
        Assertions.assertEquals(3.0, result);
    }
    @Test
    void checkTriangleSide () {
        try {
            new Triangle(4., 5., -5.);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
//        OK
        }
    }
}
