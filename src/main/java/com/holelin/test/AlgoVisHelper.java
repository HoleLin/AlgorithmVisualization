package com.holelin.template;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * ClassName: AlgoVisHelper
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/3/17
 */

public class AlgoVisHelper {
	public static final Color Red = new Color(0xF44336);
	public static final Color Pink = new Color(0xE91E63);
	public static final Color Purple = new Color(0x9C27B0);
	public static final Color DeepPurple = new Color(0x673AB7);
	public static final Color Indigo = new Color(0x3F51B5);
	public static final Color Blue = new Color(0x2196F3);
	public static final Color LightBlue = new Color(0x03A9F4);
	public static final Color Cyan = new Color(0x00BCD4);
	public static final Color Teal = new Color(0x009688);
	public static final Color Green = new Color(0x4CAF50);
	public static final Color LightGreen = new Color(0x8BC34A);
	public static final Color Lime = new Color(0xCDDC39);
	public static final Color Yellow = new Color(0xFFEB3B);
	public static final Color Amber = new Color(0xFFC107);
	public static final Color Orange = new Color(0xFF9800);
	public static final Color DeepOrange = new Color(0xFF5722);
	public static final Color Brown = new Color(0x795548);
	public static final Color Grey = new Color(0x9E9E9E);
	public static final Color BlueGrey = new Color(0x607D8B);
	public static final Color Black = new Color(0x000000);
	public static final Color White = new Color(0xFFFFFF);

	private AlgoVisHelper() {
	}

	public static void setStrokeWidth(Graphics2D graphics2D, int width) {

		int strokeWidth = width;
		graphics2D.setStroke(new BasicStroke(strokeWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
	}
	public static void setColor(Graphics2D graphics2D, Color color) {
		graphics2D.setColor(color);
	}

	public static void strokeCircle(Graphics2D graphics2D, int x, int y, int radius) {
		Ellipse2D circle = new Ellipse2D.Double(x - radius, y - radius, 2 * radius, 2 * radius);
		graphics2D.draw(circle);

	}

	public static void strokeCircle(Graphics2D graphics2D, int x, int y, int radius, Color color) {
		graphics2D.setColor(color);
		Ellipse2D circle = new Ellipse2D.Double(x - radius, y - radius, 2 * radius, 2 * radius);
		graphics2D.draw(circle);

	}

	public static void fillCircle(Graphics2D graphics2D, int x, int y, int radius) {
		Ellipse2D circle = new Ellipse2D.Double(x - radius, y - radius, 2 * radius, 2 * radius);
		graphics2D.fill(circle);

	}

	public static void fillCircle(Graphics2D graphics2D, int x, int y, int radius, Color color) {
		graphics2D.setColor(color);
		Ellipse2D circle = new Ellipse2D.Double(x - radius, y - radius, 2 * radius, 2 * radius);
		graphics2D.fill(circle);

	}

	public static void strokeRectangle(Graphics2D g, int x, int y, int w, int h){
		Rectangle2D rectangle = new Rectangle2D.Double(x, y, w, h);
		g.draw(rectangle);
	}

	public static void fillRectangle(Graphics2D g, int x, int y, int w, int h){

		Rectangle2D rectangle = new Rectangle2D.Double(x, y, w, h);
		g.fill(rectangle);
	}

	public static void putImage(Graphics2D g, int x, int y, String imageURL){

		ImageIcon icon = new ImageIcon(imageURL);
		Image image = icon.getImage();

		g.drawImage(image, x, y, null);
	}

	public static void drawText(Graphics2D g, String text, int centerx, int centery){

		if(text == null) {
			throw new IllegalArgumentException("Text is null in drawText function!");
		}

		FontMetrics metrics = g.getFontMetrics();
		int w = metrics.stringWidth(text);
		int h = metrics.getDescent();
		g.drawString(text, centerx - w/2, centery + h);
	}
	public static void pause(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			System.out.println("Error in sleeping");

		}
	}
}
