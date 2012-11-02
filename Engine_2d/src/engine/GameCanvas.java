package engine;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public abstract class GameCanvas {

	public ArrayList<GameObject> listaDeObjetos;
	public int score;

	public GameCanvas() {
		listaDeObjetos = new ArrayList<GameObject>();
		score = 0;

	}

	public abstract void gameUpdate(long diffTime);

	public abstract void draw(Graphics2D dbg);

	public abstract void keyPressed(KeyEvent tecla);

	public abstract void keyreleassed(KeyEvent tecla);

	public abstract void mousePressed(MouseEvent mouse);

	public abstract void mouseReleased(MouseEvent e);

	public abstract void mouseClicked(MouseEvent mouse);

	public abstract void mouseMoved(MouseEvent mouse);

	public abstract void mouseDragged(MouseEvent mouse);
}
