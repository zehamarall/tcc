package engine;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import engine.util.Constantes;

public abstract class Botao extends GameObject {

	BufferedImage over;
	BufferedImage notOver;
	int width;
	int heigth;
	boolean isOver = false;

	public Botao(int _x, int _y, BufferedImage _over, BufferedImage _notOver) {
		super(_x, _y, null);

		over = _over;
		notOver = _notOver;
		width = over.getWidth();
		heigth = over.getHeight();
	}

	@Override
	public void simula(long diffTime) {

	}

	@Override
	public void draw(Graphics2D dbg) {

		if (isOver) {

			dbg.drawImage(over, (int) x, (int) y, null);
		} else {
			dbg.drawImage(notOver, (int) x, (int) y, null);

		}

	}

	public void buttonPressed(MouseEvent mouse) {

		isOver = true;
		
	}

	public void buttonReleased(MouseEvent mouse) {

		if (Constantes.colidePorRetangulo(mouse.getX(), mouse.getY(), 1, 1,
				(int) x, (int) y, width, heigth)) {

			buttonAction();
		}
		isOver = false;

	}

	public abstract void buttonAction();

}
