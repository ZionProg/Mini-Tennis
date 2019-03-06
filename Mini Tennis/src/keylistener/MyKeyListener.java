package keylistener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import shapes.Shape;

public class MyKeyListener extends JPanel implements KeyListener {

	private Shape shapes;

	public MyKeyListener(Shape shapes) {
		this.shapes = shapes;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		shapes.getRacquet().keyPressed(e);

	}

	@Override
	public void keyReleased(KeyEvent e) {
		shapes.getRacquet().keyReleased();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// no needs but have to be implemented

	}
}
