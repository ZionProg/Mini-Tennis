package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import display.Canvas;
import score.Score;

public class Racquet extends Shape {

	private Canvas canvas;
	private int speed;

	public Racquet(Canvas canvas) {
		xAxis = 250 - 45;
		yAxis = 330;
		width = 70;
		height = 15;
		SpeedAndDirectionOfX = 0;
		SpeedAndDirectionOfY = 0;
		this.canvas = canvas;
		speed = 2;
	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.black);
		g2d.fillRect(xAxis, yAxis, width, height);
	}

	public void updateMove() {
		if (xAxis + SpeedAndDirectionOfX > canvas.getWidth() - 70 || xAxis + SpeedAndDirectionOfX < 0) {
			SpeedAndDirectionOfX = 0;
		}

		xAxis += SpeedAndDirectionOfX;
	}

	public void keyPressed(KeyEvent key) {

		if (Score.getInstance().getScore() % 10 == 0 && Score.getInstance().getScore() != 0 && Score.getInstance().getAllowRacquet()) {
			++speed;
			Score.getInstance().setAllowRacquet(false);
		}

		if (key.getKeyCode() == KeyEvent.VK_RIGHT) {
			SpeedAndDirectionOfX = speed;
		}

		else if (key.getKeyCode() == KeyEvent.VK_LEFT) {
			SpeedAndDirectionOfX = -speed;
		}
	}

	public void keyReleased() {
		SpeedAndDirectionOfX = 0;
	}

	protected void setSpeedAndDirection() {
		SpeedAndDirectionOfX = SpeedAndDirectionOfX < 0 ? --SpeedAndDirectionOfX : ++SpeedAndDirectionOfX;
	}
}
