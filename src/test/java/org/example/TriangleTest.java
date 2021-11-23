package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.assertTrue;

public class TriangleTest
{
    @DisplayName("Расчет площади треугольника")
    @ParameterizedTest
    @ValueSource(strings = {"5,6,7"})
    public void IsTriangleExistsTest(String input) {
        String[] ss = input.split(",");
        //
        //Уверен, что можно сделать проще и не призывать дьявола здесь
        int a = 0;
        int b = 0;
        int c = 0;
        try {
            for (int i = 0; i < ss.length; i++) {
                if (i == 0) {
                    a = Integer.parseInt(ss[i]);
                }
                if (i == 1) {
                    b = Integer.parseInt(ss[i]);
                }
                if (i == 2) {
                    c = Integer.parseInt(ss[i]);
                }
            }
        } catch (NumberFormatException ex) {
            System.out.println("Одно из входных значение не число!Тест провален!");
            ex.printStackTrace();
        }
        //

        if (a + b > c && a + c > b && b + c > a)
        {
            System.out.println("Треугольник существует. Рассчитываем площадь по теореме Герона");
            double p = (a + b + c) / 2.0;
            double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
            System.out.println("Площадь треугольника равна: " + area);

            assertTrue("Треугольник существует. Тест пройден", true);
        }
        else
        {
            System.out.println("Треугольник с указанными сторонами не существует. Тест провален");
            assertTrue("Треугольник с указанными сторонами не существует. Тест провален", false);
        }
    }

}


