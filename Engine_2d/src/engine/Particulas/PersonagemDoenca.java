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

public class PersonagemDoenca extends Personagem {

	public boolean LEFT, RIGHT, UP, DOWN;
	public AEstrela aestrela;
	double rotacao = 0;
	Random rnd = new Random();
	public ArrayList<Nodo> caminho = new ArrayList<Nodo>();
	int count = 0;

	public PersonagemDoenca(BufferedImage _imagem, int _x, int _y, Color _Cor) {

		super(_imagem, _x, _y, _Cor);
		sizeX = 51;
		sizeY = 80;
	}

	public PersonagemDoenca(BufferedImage _imagem, int _x, int _y, Color _Cor,
			int[][] _mapa) {

		super(_imagem, _x, _y, _Cor);
		sizeX = 51;
		sizeY = 80;
		aestrela = new AEstrela(_mapa, 42, 60);
	}

	@Override
	public void simula(long diffTime) {
		
		simulaAestrela();

		if (UP) {
			vely = -40;
		} else if (DOWN) {
			vely = +40;
		} else {
			vely = 0;
		}

		if (LEFT) {
			velx = -40;
		} else if (RIGHT) {
			velx = +40;
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

		// System.out.println("X: " + x + " Y: " + y);

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
		
		UP 		= false;
		DOWN 	= false;
		RIGHT 	= false;
		LEFT  	= false;
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

		// System.out.println("TILE X " + coeficienteX + "TILE Y " +
		// coeficientey);

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

	public void simulaAestrela() {
		
		int tmpx = (int) (this.x / 16);
		int tmpy = (int) (this.y / 16);
		
		//primeira vez calcula caminho
		if (caminho.size() == 0) {
			caminho = aestrela.calculaPath(tmpy, tmpx, 0, 0);
			System.out.println("DEPOIS Tamanho " + caminho.size());
			count = caminho.size()-1;
		}
		
		
		if (caminho.size() > 0) {

			int z = caminho.get(count).getx();
			int c = caminho.get(count).gety();
			
			System.out.println("tmpx "+tmpx + " tmpy "+ tmpy + " Z "+ z+ " C "+c);

			if (z == (int) tmpx || c == (int) tmpy){
				System.out.println("IGUAIS");
			}else if (z < (int) tmpy) {
				this.UP = true;
			} else if (z > (int) tmpy) {
				//System.out.println("DESCENDO");
				this.DOWN = true;
			} else if (c < (int) tmpx) {
				this.LEFT = true;
			} else if (c > (int) tmpx) {
				this.RIGHT = true;
			}

				System.out.println("INDICE " + count+ "POSICAO x " + caminho.get(count).getx()
						* 16 + "POSICAO x " + caminho.get(count).gety()
						* 16);

			if (count == 0) {
				aestrela.resetaEstrela();
				count = 0;

			}
			count--;
		}
		

	}
}
