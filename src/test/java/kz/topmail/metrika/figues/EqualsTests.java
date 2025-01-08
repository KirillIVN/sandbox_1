package kz.topmail.metrika.figues;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EqualsTests {
    @Test
    void checkTriangleEquality() {
        Triangle triangle = new Triangle(2., 3., 4.);
        Triangle triangle1 = new Triangle(3., 4., 2.);
        Assertions.assertEquals(triangle, triangle1);
    }
}

