package game;

import javax.swing.JOptionPane;

import display.Canvas;
import display.Window;
import keylistener.MyKeyListener;
import score.Score;
import shapes.Ball;
import sound.Sound;

public class Game {
	private Canvas canvas;
	private MyKeyListener listener;
	private boolean gameOver;

	public Game(Canvas can,MyKeyListener lis) throws Exception {
		canvas = can;
		listener = lis;
		gameOver = false;
	}

	public void gameStart(Window gameWindow) throws InterruptedException {
		gameWindow.openWindow();
		gameWindow.drawCanvas(canvas);
		gameWindow.activateListener(listener);
		Sound.getInstance().getReadyGo().play();
		Thread.sleep(2025);
		Sound.getInstance().getBackgroundMusic().loop();

		while (!gameOver) {
			canvas.updateMove();
			canvas.repaint();
			Thread.sleep(10);

			if (Ball.getballHitLowerSideOfScreen()) {
				gameOver = gameOver();
			}
		}
	}

	public boolean gameOver() throws InterruptedException {
		String string = "";

		Sound.getInstance().getBackgroundMusic().stop();
		Sound.getInstance().getGameOver().play();
		Thread.sleep(1000);
		
		if(Score.getInstance().getScore() >= 0) {
			
			if (Score.getInstance().getScore() <= 10) {
				string = "You kidding me? try one more!";
			}

			else if (Score.getInstance().getScore() <= 20) {
				string = "Not bad, you can do better!";
			}

			else if (Score.getInstance().getScore() <= 30) {
				string = "Not bad, you are pretty good!";
			}

			else if (Score.getInstance().getScore() < 40) {
				string = "Damn, good job!";		
			} 
			
			else if (Score.getInstance().getScore() >= 40) {
				string = "Amazing! your a god!";
			}
		}

		string += "\n" + "Your Score is: " + Score.getInstance().getScore();
		JOptionPane.showMessageDialog(canvas, string, "Game Over", JOptionPane.OK_OPTION);
		return true;
	}
}
