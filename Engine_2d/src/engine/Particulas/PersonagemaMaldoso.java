package engine.Particulas;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import engine.GamePanel;
import engine.Personagem;
import engine.IntArtificail.AEstrela;
import engine.IntArtificail.Nodo;

public class PersonagemaMaldoso extends Personagem {

	public boolean LEFT, RIGHT, UP, DOWN;
	public AEstrela aestrela;
	public ArrayList<Nodo> caminho = new ArrayList<Nodo>();
	public int objx = 0;
	public int objy = 0;
	double rotacao = 0;
	Random rnd = new Random();
	int count = 0;
	int antobjx = 0;
	int antobjy = 0;

	public PersonagemaMaldoso(BufferedImage _imagem, int _x, int _y, Color _Cor) {

		super(_imagem, _x, _y, _Cor);
		sizeX = 78;
		sizeY = 102;
	}

	public PersonagemaMaldoso(BufferedImage _imagem, int _x, int _y, Color _Cor,
			int[][] _mapa) {

		super(_imagem, _x, _y, _Cor);
		objx = 10;
		objy = 10;
		sizeX = 68;
		sizeY = 102;
		aestrela = new AEstrela(_mapa, 40, 64);

	}

	@Override
	public void simula(long diffTime) {

		oldx = (int) x;
		oldy = (int) y;

		simulaAestrela();

		if (UP) {
			vely = -15;
		} else if (DOWN) {
			vely = +15;
		} else {
			vely = 0;
		}

		if (LEFT) {
			velx = -15;
		} else if (RIGHT) {
			velx = +15;
		} else {
			velx = 0;
		}

		timeranimacao += diffTime;
		frame = (timeranimacao / tempoentreframes) % 9;
System.out.println("doen�a Frame "+frame);
		x += velx * diffTime / 1000.0f;
		y += vely * diffTime / 1000.0f;

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
		System.out.println("DRAW doen�a");
		dbg.drawImage(image, (int) x, (int) y, (int) (x + sizeX),
				(int) (y + sizeY), sizeX * frame, sizeY * animacao,
				(sizeX * frame) + sizeX, (sizeY * animacao) + sizeY, null);
	}

	public void check_colidiu_extremos() {

		if (this.y < 0) {
			colidiu();
			return;
		}

		if (this.y + this.sizeX / 2 > GamePanel.GAME_HEIGHT) {
			colidiu();
			return;
		}

		if (this.x < 0) {
			colidiu();
			return;
		}

		if (this.x + this.sizeY / 2 > GamePanel.GAME_WIDTH) {
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

			matrizDoMapa = engine.mapa.Fase1.matrizDoMapa;

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

	public void simulaAestrela() {

		int tmpx = (int) (this.x + (this.sizeX / 2)) / 16;
		int tmpy = (int) (this.y + (this.sizeY / 2)) / 16;

		if (aestrela.mapa[objx][objy] != 0) {
			/*
			 * havia situacoes em que o persoangem ficava em sima de um
			 * obstaculo no mapa foi implementado para somente pegar posicoes
			 * que nao tinha nenhum personagem
			 */

			objx = antobjx;
			objy = antobjy;
		}

		caminho = aestrela.calculaPath(tmpy, tmpx, objx, objy);

		antobjx = objx;
		antobjy = objy;

		count = caminho.size() - 2;
		System.out.println("DEPOIS Tamanho " + count + " POSICAO X " + tmpx
				+ " POSICAO Y " + tmpy);

		if (count > 0) {

			int z = caminho.get(count).getx();
			int c = caminho.get(count).gety();

			if (z == (int) tmpy && c == (int) tmpx) {
				System.out.println("IGUAIS");
			} else if (z < (int) tmpy) {
				this.UP = true;
				System.out.println("SUBINDO");
			} else if (z > (int) tmpy) {
				System.out.println("DESCENDO");
				this.DOWN = true;
			} else if (c < (int) tmpx) {
				this.LEFT = true;
				System.out.println("ESQUERDA");
			} else if (c > (int) tmpx) {
				this.RIGHT = true;
				System.out.println("DIREITA");
			}

			aestrela.resetaEstrela();

		}

	}
}
