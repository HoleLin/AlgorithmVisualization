package com.holelin.template;

import javax.swing.*;
import java.awt.*;

/**
 * ClassName: AlgoFrame
 * 算法Frame
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/3/17
 */

public class AlgoFrame extends JFrame {

	private int canvasWidth;
	private int canvasHeight;
	private Circle[] mCircles;

	public AlgoFrame(String title, int canvasWidth, int canvasHeight) throws HeadlessException {
		super(title);
		this.canvasWidth = canvasWidth;
		this.canvasHeight = canvasHeight;
		// 创建画布和设置大小
		AlgoCanvas canvas = new AlgoCanvas();
		// 设置内容面板
		this.setContentPane(canvas);
		// 自动调整窗口大小
		pack();
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public AlgoFrame(String title) throws HeadlessException {
		this(title, 1024, 768);
	}

	public int getCanvasWidth() {
		return canvasWidth;
	}

	public int getCanvasHeight() {
		return canvasHeight;
	}


	public void render(Circle[] circles) {
		mCircles = circles;
		repaint();
	}

	/**
	 * 自己的JPanel
	 */
	private class AlgoCanvas extends JPanel {

		public AlgoCanvas() {
			// 开启双缓存
			super(true);
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D graphics2D = (Graphics2D) g;

			// 设置抗锯齿
			RenderingHints hints = new RenderingHints(
					RenderingHints.KEY_ALPHA_INTERPOLATION,
					RenderingHints.VALUE_ANTIALIAS_ON);

			graphics2D.addRenderingHints(hints);
			// 具体绘制
			AlgoVisHelper.setStrokeWidth(graphics2D, 1);
			AlgoVisHelper.setColor(graphics2D, Color.RED);

			for (Circle circle :
					mCircles) {
				if (!circle.isFilled) {
					AlgoVisHelper.strokeCircle(graphics2D, circle.x, circle.y, circle.getRadius());
				} else {
					AlgoVisHelper.fillCircle(graphics2D, circle.x, circle.y, circle.getRadius());
				}

			}
		}

		@Override
		public Dimension getPreferredSize() {
			return new Dimension(canvasWidth, canvasHeight);
		}
	}
}
