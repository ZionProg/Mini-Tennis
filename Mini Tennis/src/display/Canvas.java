package display;

import java.awt.Graphics;

import javax.swing.JPanel;

import score.Score;
import shapes.Shape;

public class Canvas extends JPanel {

	private Shape shapes;

	public Canvas() {
		shapes = new Shape(this);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		shapes.paint(g);
		Score.getInstance().print(g);
	}

	public void updateMove() {
		shapes.updateMove();
	}

	public Shape getShapes() {
		return shapes;
	}

}
