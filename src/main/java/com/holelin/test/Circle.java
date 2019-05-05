package com.holelin.template;

import java.awt.*;
import java.util.Random;

/**
 * ClassName: Circle
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/3/17
 */

public class Circle {
	/**
	 * 起始坐标
	 */
	public int x, y;
	private int radius;
	/**
	 * 坐标移动距离
	 */
	public int vx, vy;
	/**
	 * 是否绘制为实心圆
	 */
	public boolean isFilled = false;
	private Random mRandom=new Random();
	private Color mColor=Color.RED;

	public Color getColor() {
		return mColor;
	}

	public Circle(int x, int y, int radius, int vx, int vy) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.vx = vx;
		this.vy = vy;
	}

	public int getRadius() {
		return radius;
	}

	public void move(int min_x, int min_y, int max_x, int max_y) {
		x += vx;
		y += vy;
		checkCollision(min_x, min_y, max_x, max_y);
	}

	public void changeColor() {
		mColor=Color.getHSBColor(mRandom.nextInt(255),mRandom.nextInt(255),mRandom.nextInt(255));
	}

	private void checkCollision(int min_x, int min_y, int max_x, int max_y) {
		// 圆贴到左边缘
		if (x - radius < min_x) {
			x = radius;
			vx = -vx;
		}
		// 圆贴到右边缘
		if (x + radius >= max_x) {
			x = max_x - radius;
			vx = -vx;
		}
		// 圆贴到上边缘
		if (y - radius < min_y) {
			y = radius;
			vy = -vy;
		}
		// 圆贴到下边缘
		if (y + radius >= max_y) {
			y = max_y - radius;
			vy = -vy;
		}
	}
	public boolean checkCollisionAndReturn(int min_x, int min_y, int max_x, int max_y) {
		// 圆贴到左边缘
		if (x - radius < min_x) {
			x = radius;
			vx = -vx;
			return true;

		}
		// 圆贴到右边缘
		if (x + radius >= max_x) {
			x = max_x - radius;
			vx = -vx;
			return true;

		}
		// 圆贴到上边缘
		if (y - radius < min_y) {
			y = radius;
			vy = -vy;
			return true;

		}
		// 圆贴到下边缘
		if (y + radius >= max_y) {
			y = max_y - radius;
			vy = -vy;
			return true;
		}
		return false;
	}
	public boolean contain(Point point) {
		return (x - point.x) * (x - point.x) + (y - point.y) * (y - point.y) <= radius * radius;
	}
}

