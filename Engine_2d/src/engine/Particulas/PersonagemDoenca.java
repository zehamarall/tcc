package engine.Particulas;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import engine.GamePanel;
import engine.Personagem;

public class PersonagemDoenca extends Personagem {

	public boolean LEFT, RIGHT, UP, DOWN;

	double rotacao = 0;
	Random rnd = new Random();

	public PersonagemDoenca(BufferedImage _imagem, int _x, int _y, Color _Cor) {

		super(_imagem, _x, _y, _Cor);
		sizeX = 51;
		sizeY = 80;
	}

	@Override
	public void simula(long diffTime) {

		if (UP) {
			vely = -30;
		} else if (DOWN) {
			vely = +30;
		} else {
			vely = 0;
		}

		if (LEFT) {
			velx = -30;
		} else if (RIGHT) {
			velx = +30;
		} else {
			velx = 0;
		}

		timeranimacao += diffTime;
		frame = (timeranimacao / tempoentreframes) % 6;

		x += velx * diffTime / 1000.0f;
		y += vely * diffTime / 1000.0f;

		// tratar as colisões
		check_colidiu_extremos();
		check_colidiu_mapa();

		//System.out.println("X: " + x + " Y: " + y);

		if (velx == 0 && vely == 0) {
			frame = 0;
		} else if (Math.abs(velx) > Math.abs(vely)) {
			if (velx > 0) {
				animacao = 2;
			} else {
				animacao = 3;
			}

		} else {
			if (vely > 0) {
				animacao = 0;
			} else {
				animacao = 1;
			}
		}
	}

	@Override
	public void draw(Graphics2D dbg) {

		dbg.drawImage(image, (int) x, (int) y, (int) (x + sizeX),
				(int) (y + sizeY), sizeX * frame, sizeY * animacao,
				(sizeX * frame) + sizeX, (sizeY * animacao) + sizeY, null);
	}

	public void check_colidiu_extremos() {

		if (this.y < 0) {
			colidiu();
			return;
		}

		if (this.y + this.sizeX > GamePanel.GAME_HEIGHT) {
			colidiu();
			return;
		}

		if (this.x < 0) {
			colidiu();
			return;
		}

		if (this.x + this.sizeY > GamePanel.GAME_WIDTH) {
			colidiu();
			return;
		}
	}

	public void check_colidiu_mapa() {
		int coeficienteX = (int) (this.x + (this.sizeX / 2)) / 16;
		int coeficientey = (int) (this.y + (this.sizeY / 2)) / 16;

		//System.out.println("TILE X " + coeficienteX + "TILE Y " + coeficientey);

		if (coeficienteX >= 0 && coeficientey >= 0) {
			int valor = coeficienteX + (((coeficientey * 60) / 60) * 60);
			int[][] matrizDoMapa = engine.mapa.Fase1.matrizDoMapa;
			if (matrizDoMapa[1][valor] != 0) {
				this.colidiu();
				return;
			}
		}
	}

	public void colidiu() {
		x = oldx;
		y = oldy;
	}
}
