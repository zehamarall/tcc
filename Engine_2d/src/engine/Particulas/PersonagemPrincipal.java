package engine.Particulas;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import engine.GamePanel;
import engine.Personagem;

public class PersonagemPrincipal extends Personagem {

	public boolean LEFT, RIGHT, UP, DOWN;
	double rotacao = 0;
	public boolean efeito = false;
	static int count = 0;

	public PersonagemPrincipal(BufferedImage _imagem, int _x, int _y, Color _Cor) {
		super(_imagem, _x, _y, _Cor);
		sizeX = 80;
		sizeY = 97;
	}

	@Override
	public void simula(long diffTime) {

		oldx = (int) x;
		oldy = (int) y;

		if (UP) {
			vely = -100;
		} else if (DOWN) {
			vely = +100;
		} else {
			vely = 0;
		}

		if (LEFT) {
			velx = -100;
		} else if (RIGHT) {
			velx = +100;
		} else {
			velx = 0;
		}

		timeranimacao += diffTime;
		frame = (timeranimacao / tempoentreframes) % 8;

		x += velx * diffTime / 1000.0f;
		y += vely * diffTime / 1000.0f;

		// tratar as colisões
		check_colidiu_extremos();
		check_colidiu_mapa();

		if (velx == 0 && vely == 0) {
			frame = 0;
		} else if (Math.abs(velx) > Math.abs(vely)) {
			if (velx > 0) {
				animacao = 3;
			} else {
				animacao = 2;
			}

		} else {
			if (vely > 0) {
				animacao = 0;
			} else {
				animacao = 1;
			}
		}
		UP = false;
		DOWN = false;
		RIGHT = false;
		LEFT = false;
	}

	@Override
	public void draw(Graphics2D dbg) {

		if (!efeito) {
				dbg.drawImage(image, (int) x, (int) y, (int) (x + sizeX),
					(int) (y + sizeY), sizeX * frame, sizeY * animacao,
					(sizeX * frame) + sizeX, (sizeY * animacao) + sizeY, null);

		} else {
				System.out.println("Efeito else " + count);
				if (count % 2 == 0){
					dbg.drawImage(image, (int) x, (int) y, (int) (x + sizeX),
						(int) (y + sizeY), sizeX * frame, sizeY * animacao,
						(sizeX * frame) + sizeX, (sizeY * animacao) + sizeY,
						null);
						count++;
				}else{
					if (count >= 35){
						count = 1;
						efeito = false;
					}
					count ++;
				}	
		}
		
	}

	public void check_colidiu_extremos() {

		if (this.y < 0) {
			colidiu();
			return;
		}

		if (this.y + (this.sizeX) > GamePanel.GAME_HEIGHT) {
			colidiu();
			return;
		}

		if (this.x < 0) {
			colidiu();
			return;
		}

		if (this.x + (this.sizeY / 2) > GamePanel.GAME_WIDTH) {
			colidiu();
			return;
		}
	}

	public void check_colidiu_mapa() {
		int coeficienteX = (int) (this.x + (this.sizeX / 2)) / 16;
		int coeficientey = (int) (this.y + (this.sizeY / 2)) / 16;

		if (coeficienteX >= 0 && coeficientey >= 0) {
			int valor = coeficienteX + (((coeficientey * 64) / 64) * 64);

			int[][] matrizDoMapa;

			if (GamePanel.fase == 1) {
				matrizDoMapa = engine.mapa.Fase1.matrizDoMapa;
			} else if (GamePanel.fase == 2) {
				matrizDoMapa = engine.mapa.Fase2.matrizDoMapa;
			} else {
				matrizDoMapa = engine.mapa.Fase1.matrizDoMapa;
			}

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
