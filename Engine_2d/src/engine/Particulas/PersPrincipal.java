package engine.Particulas;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import engine.GamePanel;
import engine.MoveableSprite;

public class PersPrincipal extends MoveableSprite {

	public PersPrincipal(BufferedImage _image, int _x, int _y, int _velx,
			int _vely, int _raio, Color _Cor) {
		super(_image, _x, _y, _velx, _vely, _raio, _Cor);
	}

	@Override
	public void simula(long diffTime) {

		if (this.y < 0) {
			colidiu();
			return;
		}

		if (this.y + this.image.getWidth() > GamePanel.GAME_HEIGHT) {
			colidiu();
			return;
		}

		if (this.x < 0) {
			colidiu();
			return;
		}

		if (this.x + this.image.getWidth() > GamePanel.GAME_WIDTH) {
			colidiu();
			return;
		}

		int coeficienteX = (int) (this.x + (this.largura / 2)) / 16;
		int coeficientey = (int) (this.y + (this.altura / 2)) / 16;
		
		if (coeficienteX >= 0 && coeficientey >= 0) {
			int valor = coeficienteX + (((coeficientey*60)/60)*60);
			int[][] matrizDoMapa = engine.mapa.Fase1.matrizDoMapa;
			if (matrizDoMapa[1][valor] != 0){
				this.colidiu();
				return;
			}
		}
	}

	@Override
	public void draw(Graphics2D dbg) {
		dbg.drawImage(image, (int) x, (int) y, null);
	}

	public void colidiu() {
		x = oldx;
		y = oldy;
	}
}
