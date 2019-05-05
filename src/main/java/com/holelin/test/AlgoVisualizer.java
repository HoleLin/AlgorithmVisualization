package com.holelin.template;

import java.awt.*;
import java.awt.event.*;

/**
 * ClassName: AlgoVisualizer
 * Contorller -- 控制器
 * @author HoleLin
 * @version 1.0
 * @date 2019/3/17
 */

public class AlgoVisualizer {
	private Circle[] mCircles;
	private AlgoFrame mFrame;
	private boolean isAnimated =true;

	public AlgoVisualizer(int sceneWidth,int sceneHeight,int N) {
		int radius = 50;
		mCircles = new Circle[N];
		for (int i = 0; i < mCircles.length; i++) {
			int x = (int) (Math.random() * (sceneWidth - 2 * radius)) + radius;
			int y = (int) (Math.random() * (sceneHeight - 2 * radius)) + radius;
			int vx = (int) (Math.random() * 11) - 5;
			int vy = (int) (Math.random() * 11) - 5;
			mCircles[i] = new Circle(x, y, radius, vx, vy);
		}
		EventQueue.invokeLater(() -> {
			mFrame = new AlgoFrame("Welcome", sceneWidth, sceneHeight);
			mFrame.addKeyListener(new AlgoKeyListener());
			mFrame.addMouseListener(new AlgoMouseListener());
			new Thread(this::run).start();
		});


	}

	private void run() {
		while (true) {
			// 绘制数据
			mFrame.render(mCircles);
			AlgoVisHelper.pause(20);
			// 更新数据
			if (isAnimated) {
				for (Circle circle :
						mCircles) {
					circle.move(0,0,mFrame.getCanvasWidth(),mFrame.getCanvasHeight());
//					if (circle.checkCollision2(0,0,mFrame.getCanvasWidth(),mFrame.getCanvasHeight())){
//						circle.changeColor();
//					}
				}
			}
		}
	}

	/**
	 * 键盘事件类
	 */
	private class AlgoKeyListener extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent event) {
			if (event.getKeyChar()==' ') {
				isAnimated= !isAnimated;
			}


		}
	}

	/**
	 * 鼠标事件类
	 */
	private class AlgoMouseListener extends MouseAdapter{
		@Override
		public void mousePressed(MouseEvent event) {

			event.translatePoint(0,-(mFrame.getBounds().height-mFrame.getCanvasHeight()));
			for(Circle circle : mCircles) {
				if (circle.contain(event.getPoint())) {
					circle.isFilled = !circle.isFilled;
				}
			}
			System.out.println(event.getPoint());
		}
	}

	public static void main(String[] args) {

		int sceneWidth = 800;
		int sceneHeight = 800;
		int N = 10;
		AlgoVisualizer algoVisualizer = new AlgoVisualizer(sceneWidth, sceneHeight, N);

	}
}
