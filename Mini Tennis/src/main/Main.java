package main;

import javax.swing.JOptionPane;

import display.Canvas;
import display.Window;
import game.Game;
import keylistener.MyKeyListener;
import score.Score;
import sound.Sound;

public class Main {
	public static void main(String[] args) throws Exception {
		new Score();
		boolean gameOn = true;
		while (gameOn) {
			Window window = new Window();
			Canvas canvas = new Canvas();
			Game controller = new Game(canvas, new MyKeyListener(canvas.getShapes()));
			controller.gameStart(window);
			if (JOptionPane.showConfirmDialog(canvas, "New game? :D", "New game",
			        JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
				gameOn = false;
				window.closeWindow();
			}
		}	
	}
}
