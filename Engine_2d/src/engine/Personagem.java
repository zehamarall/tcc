package engine;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public abstract class Personagem extends Sprite {

	public int frame;
	public int timeranimacao;
	public int animacao;
	public int tempoentreframes;
	public int velocidade = 0;
	public double ang = 0;
	public boolean segueobjetivo = false;
	public int sizeX;
	public int sizeY;
	public int velx, vely;
	public int oldx, oldy;

	public Personagem(BufferedImage _imagem, int _x, int _y, Color _Cor) {
		super(_imagem, _x, _y, _Cor);

		frame = 0;
		animacao = 0;
		timeranimacao = 0;

		velx = 0;
		vely = 0;

		tempoentreframes = 150;
	}

	@Override
	public abstract void simula(long diffTime);

	@Override
	public abstract void draw(Graphics2D dbg);

}
