package engine.Particulas;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import engine.GamePanel;
import engine.MoveableSprite;

public class PersDoenca extends MoveableSprite {
	Random rnd = new Random();

	public PersDoenca(BufferedImage _image, int _x, int _y, int _velx,
			int _vely, int _raio, Color _Cor) {
		super(_image, _x, _y, _velx, _vely, _raio, _Cor);
	}

	@Override
	public void simula(long diffTime) {

		this.oldx = (int) this.x;
		this.oldy = (int) this.y;

		int i = rnd.nextInt(4);

		switch (i) {

		case 0:
			this.y -= 10 * diffTime / 100;
			break;

		case 1:
			this.y += 10 * diffTime / 100;
			break;

		case 2:
			this.x -= 10 * diffTime / 100;
			break;

		case 3:
			this.x += 10 * diffTime / 100;

			break;
		default:
			break;
		}
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
		//int coeficienteX2 = (int) (this.x + this.altura) / 16;
		//int coeficientey2 = (int) (this.y + this.largura) / 16;
		// System.out.println("DEBUG X " + coeficienteX + " Y " + coeficientey);
		System.out.println("TILE X " + coeficienteX + "TILE Y " + coeficientey);

		if (coeficienteX >= 0 && coeficientey >= 0) {
			int valor = coeficienteX + (((coeficientey*60)/60)*60);
			System.out.println(" Coeficiente X "+ coeficienteX + " MOD " +((coeficientey*60)/60));
			int[][] matrizDoMapa = engine.mapa.Mapa2.matrizDoMapa;
			System.out.println("Valor " + valor + "MAPA "+matrizDoMapa[1][valor]);
			if (matrizDoMapa[1][valor] != 0){
					//|| matrizDoMapa[1][valor] != 1861) {
				System.out.println("COLIDIU personagem principal ");
				System.out.println("Valor da matriz " + matrizDoMapa[1][valor]
						+ "*************************************");
				this.colidiu();
				return;
			}
		}/*
		 * if (coeficienteX2 >= 0 && coeficientey2 >= 0) { int valor =
		 * coeficienteX2 + (coeficientey2 * 50); int[][] matrizDoMapa =
		 * engine.mapa.Mapa.matrizDoMapa; if (matrizDoMapa [1][valor] != 0) {
		 * System.out.println("COLIDIU 2 personagem principal ");
		 * System.out.println("Valor da matriz " + matrizDoMapa
		 * [1][valor]+"*************************************"); this.colidiu();
		 * return; } }
		 */

	}

	@Override
	public void draw(Graphics2D dbg) {
		dbg.drawImage(image, (int) x, (int) y, null);

	}

	public void colidiu() {
		// velx *=-1;
		x = oldx;
		y = oldy;
	}
}
