package engine;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Personagem extends Sprite {

	public int frame;
	public int timeranimacao;
	public int animacao;
	public int tempoentreframes;
	public int velocidade = 0;
	public double ang = 0;
	public boolean segueobjetivo = false;
	public int sizeX = 24;
	public int sizeY = 32;
	public int velx, vely;
	public int oldx, oldy;

	public Personagem(BufferedImage _imagem, int _x, int _y, Color _Cor) {
		super(_imagem, _x, _y, _Cor);

		frame = 0;
		animacao = 0;
		timeranimacao = 0;

		velx = 0;
		vely = 0;

		tempoentreframes = 170;
	}

	@Override
	public void simula(long diffTime) {
		timeranimacao += diffTime;
		frame = (timeranimacao / tempoentreframes) % 8;

		x += velx * diffTime / 1000.0f;
		y += vely * diffTime / 1000.0f;

		if (velx == 0 && vely == 0) {
			frame = 0;
		} else if (Math.abs(velx) > Math.abs(vely)) {
			if (velx > 0) {
				animacao = 1;
			} else {
				animacao = 3;
			}

		} else {
			if (vely > 0) {
				animacao = 2;
			} else {
				animacao = 0;
			}
		}
	}

	@Override
	public void draw(Graphics2D dbg) {
		dbg.drawImage(image, (int) x, (int) y, (int) (x + sizeX),
				(int) (y + sizeY), sizeX * frame, sizeY * animacao,
				(sizeX * frame) + sizeX, (sizeY * animacao) + sizeY, null);

	}

}
