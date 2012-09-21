package engine;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public abstract class Sprite extends GameObject {

	public BufferedImage image;
	public boolean flagVida;

	public Sprite(BufferedImage _imagem, int _x, int _y, Color _Cor) {
		super(_x, _y, _Cor);
		image = _imagem;
		flagVida = true;
	}

	@Override
	public void simula(long diffTime) {

	}

	@Override
	public void draw(Graphics2D dbg){ 
		
		dbg.drawImage(image, (int) x, (int) y, null);

	}

}
