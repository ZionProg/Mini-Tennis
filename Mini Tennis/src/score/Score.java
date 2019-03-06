package score;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Score {
	private static Score instance = new Score();
	private  int score;
	private  boolean allowRacquet;
	private  int fontSize;
	private  Font font;
	

	public Score() {
		score = 0;
		allowRacquet = false;
		fontSize = 70;
		font = new Font("Verdana", Font.BOLD, 70);

	}

	public  void incScore() {
		++score;
		if (!allowRacquet)
			allowRacquet = true;
	}

	public  int getScore() {
		return score;
	}

	public  void setAllowRacquet(boolean bool) {
		allowRacquet = bool;
	}

	public  boolean getAllowRacquet() {
		return allowRacquet;
	}

	public  int getDim() {
		return fontSize;
	}

	public  void print(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.GRAY);
		g2d.setFont(font);
		g2d.drawString(String.valueOf(getScore()), 10, 60);
	}
	
	public  void resetScore() {
		score = 0;
	}

	public static Score getInstance() {
		return instance;
	}
	
}
