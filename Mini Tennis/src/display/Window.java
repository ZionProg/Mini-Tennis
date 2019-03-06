package display;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import keylistener.MyKeyListener;

public class Window extends JFrame {

	private final JFrame window;
	private int windowWidth;
	private int windowHeight;

	public Window() {
		window = new JFrame("Mini Tenis");
		windowWidth = 500;
		windowHeight = 400;
	}

	public void drawCanvas(Canvas canvas) {
		window.add(canvas);

	}

	public void activateListener(MyKeyListener listener) {
		window.addKeyListener(listener);
		window.setFocusable(true);
	}

	public void openWindow() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		window.setSize(windowWidth, windowHeight);
		window.setLocation(dim.width / 2 - window.getSize().width, dim.height / 2 - window.getSize().height);
		window.setVisible(true);
		window.setResizable(false);
		window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
	}
	
	public void closeWindow() {
		window.setVisible(false);
		window.dispose();
	}

	public int getWindowWidth() {
		return windowWidth;
	}

	public int getWindowHeigth() {
		return windowHeight;
	}
}
