package com.geekbrains;

public class TriangleArea {
    public static double calculateArea(double sideA, double sideB, double sideC) throws Exception {
        if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
            throw new Exception("Одна из сторон меньше или равна нулю");
        }

            double halfPerimeter = (sideA + sideB + sideC) / 2;
            return  Math.sqrt(halfPerimeter * (halfPerimeter - sideA) * (halfPerimeter - sideB) * (halfPerimeter - sideC));

        }
    }

