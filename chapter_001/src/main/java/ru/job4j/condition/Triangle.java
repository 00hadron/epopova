package ru.job4j.condition;
/**
 * Класс Triangle строит треульник и вычисляет его площадь.
 * @author epopova
 * @since 10.03.2018
 * @version $Id$
 */

public class Triangle {
    private Point a;
    private Point b;
    private Point c;

    /**
     * Конструктор для инициализации точек.
     */
    public Triangle(Point a, Point b, Point c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Метод вычисления полупериметра по длинам сторон.
     *
     * Формула.
     *
     * (ab + ac + bc) / 2
     *
     * @param ab расстояние между точками a b
     * @param ac расстояние между точками a c
     * @param bc расстояние между точками b c
     * @return полуперимент.
     */
    public double period(double ab, double ac, double bc) {
        double p = (ab + ac + bc) / 2;
        System.out.println("ab = " + ab);
        System.out.println("ac = " + ac);
        System.out.println("bc = " + bc);
        System.out.println("p = " + p);
        return  p;
    }

    /**
     * Метод вычисляет площадь треугольника.
     *
     * @return Вернуть прощадь, если треугольник существует или -1, если треугольника нет.
     */
    public double area() {
        double rsl;
        double ab = this.a.distanceTo(this.b);
        double ac = this.a.distanceTo(this.c);
        double bc = this.b.distanceTo(this.c);
        double p = this.period(ab, ac, bc);

        if (this.exist(ab, ac, bc)) {
            rsl = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
        } else rsl = -1;

        System.out.println("rsl = " + rsl);
        return rsl;
    }

    /**
     * Метод проверяет можно ли построить треугольник с такими длинами сторон.
     *
     * @param ab Длина от точки a b.
     * @param ac Длина от точки a c.
     * @param bc Длина от точки b c.
     * @return false или true.
     */
    private boolean exist(double ab, double ac, double bc) {
        if ((ab >= (ac + bc))||(ac >= (ab + bc))||(bc >= (ab + ac))){
            System.out.println("Не возможно построить треугольник! ");
            return false;
        } else
            return true;
    }
}



