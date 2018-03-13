package ru.job4j.condition;

/**
 * Класс Point Описывает точку в системе координат.
 * @author epopova
 * @since 08.03.2018
 * @version 1
 */
public class Point {
	private int x;
	private int y;

	/**
	 * Конструктор Point для иницилизации точек.
	 * @param x координата х.
	 * @param y координата у.
	 */
	public  Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Метод distanceTo возвращает расстояние от точки до точки.
	 * @param that точка B.
	 * this неявный параметр точка А.
	 * @return result.
	 */
	public double distanceTo(Point that) {
		Point a = this;
		Point b = that;
		double result;
		result = Math.sqrt(Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2));
		return result;
	}

	/**
	 * Main метод.
	 */
	public static void main(String[] args) {
		Point a = new Point(0, 1);
		Point b = new Point(2, 5);
		double result = a.distanceTo(b);
	}
}