package shapes;

import java.awt.Graphics;
import java.awt.Rectangle;

import display.Canvas;

public class Shape {

	private Ball ball;
	private Racquet racquet;

	protected int xAxis;
	protected int yAxis;
	protected int height;
	protected int width;
	protected int SpeedAndDirectionOfX;
	protected int SpeedAndDirectionOfY;

	public Shape() {
	}

	public Shape(Canvas canvas) {
		ball = new Ball(canvas);
		racquet = new Racquet(canvas);
	}

	public void paint(Graphics g) {
		ball.paint(g);
		racquet.paint(g);
	}

	public void updateMove() {
		ball.updateMove();
		racquet.updateMove();
	}

	protected Ball getBall() {
		return ball;
	}

	public Racquet getRacquet() {
		return racquet;
	}

	protected Rectangle getBounds() {
		return new Rectangle(xAxis, yAxis, width, height);
	}

	protected int getYAxis() {
		return yAxis;
	}

	protected void setSpeedAndDirection() {
		SpeedAndDirectionOfX = SpeedAndDirectionOfX < 0 ? --SpeedAndDirectionOfX : ++SpeedAndDirectionOfX;
		SpeedAndDirectionOfY = SpeedAndDirectionOfY < 0 ? --SpeedAndDirectionOfY : ++SpeedAndDirectionOfY;
	}
}
