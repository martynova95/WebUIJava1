package com.geekbrains.lesson4;

import com.geekbrains.TriangleArea;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TriangleAreaTest {
    @Test
    void triangleAreaTest() throws Exception {
        Assertions.assertEquals(TriangleArea.calculateArea(2, 2, 2), 1.73205, 0.001);
    }

    @Test
    void triangleAreaNegativeTest() {
        Assertions.assertThrows(Exception.class, () -> TriangleArea.calculateArea(-2, 2, 2));
    }

}
