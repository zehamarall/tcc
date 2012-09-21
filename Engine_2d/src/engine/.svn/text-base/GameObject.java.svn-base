package engine;

import java.awt.Color;
import java.awt.Graphics2D;

public abstract class GameObject {

	public float x, y;
	public Color cor;

	/**
	 * 
	 * Construtor padrao GameObject
	 * 
	 * @param _x
	 *            Posicao X do Objeto
	 * @param _y
	 *            Posicao Y do Objeto
	 * @param _Cor
	 *            Cor do Objeto
	 */
	public GameObject(int _x, int _y, Color _Cor) {
		x = _x;
		y = _y;
		cor = _Cor;
	}

	public abstract void simula(long diffTime);

	public abstract void draw(Graphics2D dbg);

}
