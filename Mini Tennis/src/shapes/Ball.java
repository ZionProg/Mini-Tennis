package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import display.Canvas;
import score.Score;
import sound.Sound;

public class Ball extends Shape {

	private Canvas canvas;
	private static boolean ballHitLowerSideOfScreen;

	public Ball(Canvas c) {
		ballHitLowerSideOfScreen = false; //need to reset it each new game
		xAxis = yAxis = 1 + 60;
		width = height = 30;
		SpeedAndDirectionOfX = 2;
		SpeedAndDirectionOfY = 2;
		canvas = c;
	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.black);
		g2d.fillOval(xAxis, yAxis, width, height);
	}

	public void updateMove() {
		if (xAxis + SpeedAndDirectionOfX > canvas.getWidth() - 30 || xAxis + SpeedAndDirectionOfX < 0) {
			if (canvas.getWidth() != 0)
				SpeedAndDirectionOfX = -SpeedAndDirectionOfX;
		}
		xAxis += SpeedAndDirectionOfX;

		if (yAxis + SpeedAndDirectionOfY < 0)
			SpeedAndDirectionOfY = -SpeedAndDirectionOfY;

		if (this.collisionDetection(canvas.getShapes().getRacquet().getBounds())) {
			Sound.getInstance().getCollision().play();
			Score.getInstance().incScore();
			if (Score.getInstance().getScore() % 5 == 0) {

				if (Score.getInstance().getScore() % 10 == 0)
					Sound.getInstance().getTenLU().play();
				else
					Sound.getInstance().getFiveLU().play();

				super.setSpeedAndDirection();
			}

			yAxis = canvas.getShapes().getRacquet().getYAxis() - height;
			SpeedAndDirectionOfY = -SpeedAndDirectionOfY;
		}
		yAxis += SpeedAndDirectionOfY;

		if (yAxis + SpeedAndDirectionOfY > canvas.getHeight() - 30) {
			if (canvas.getHeight() != 0)
				setBallHitLowerSideOfScreen();
		}
	}

	public static boolean getballHitLowerSideOfScreen() {
		return ballHitLowerSideOfScreen;
	}

	public void setBallHitLowerSideOfScreen() {
		ballHitLowerSideOfScreen = true;
	}

	public boolean collisionDetection(Rectangle shape) {
		return this.getBounds().intersects(shape.getBounds());
	}
}
