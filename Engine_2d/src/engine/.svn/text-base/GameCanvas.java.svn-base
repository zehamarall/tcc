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

	/**
	 * Metodo de simulacao do GameCanvas.
	 * 
	 * @param diffTime
	 *            diferencaEntreTempo
	 **/
	public abstract void gameUpdate(long diffTime);

	/**
	 * Metodo de Renderizacao do GameCanvas
	 * 
	 * @param dbg
	 *            BufferDeDesenho
	 * **/
	public abstract void draw(Graphics2D dbg);

	/**
	 * @param evento
	 *            da tecla presionado
	 */
	public abstract void keyPressed(KeyEvent tecla);

	/**
	 * @param evento
	 *            da tecla desprecionado
	 */
	public abstract void keyreleassed(KeyEvent tecla);

	/**
	 * @param evento
	 *            do mouse presionado
	 */
	public abstract void mousePressed(MouseEvent mouse);

	/**
	 * @param evento
	 *            do mouse desprecionado
	 */
	public abstract void mouseReleased(MouseEvent e);

	/**
	 * @param evento
	 *            do mouse
	 */
	public abstract void mouseClicked(MouseEvent mouse);

	public abstract void mouseMoved(MouseEvent mouse);

	public abstract void mouseDragged(MouseEvent mouse);
}
