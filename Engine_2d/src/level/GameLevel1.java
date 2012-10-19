package level;

//import Nodo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import engine.GameCanvas;
import engine.Gerenciadores.GerenciadorDeParticulas;
import engine.Gerenciadores.GerenciadorDeSom;
import engine.IntArtificail.AEstrela;
import engine.IntArtificail.Nodo;
import engine.mapa.Fase1;
import engine.util.Constantes;

public class GameLevel1 extends GameCanvas {

	Fase1 meuMapa;
	GerenciadorDeParticulas meuGerenciador = new GerenciadorDeParticulas(false);
	GerenciadorDeSom meuSom;

	public ArrayList<AEstrela> LISTA_IA = new ArrayList<AEstrela>();
	public ArrayList<Nodo> caminho = new ArrayList<Nodo>();

	private boolean UP = false;
	private boolean DOWN = false;
	private boolean LEFT = false;
	private boolean RIGHT = false;
	private static int animacao = 0;

	@Override
	public void gameUpdate(long diffTime) {

		meuGerenciador.persoangem.oldx = (int) meuGerenciador.persoangem.x;
		meuGerenciador.persoangem.oldy = (int) meuGerenciador.persoangem.y;

		if (UP) {
			meuGerenciador.persoangem.UP = true;

		} else if (DOWN) {
			meuGerenciador.persoangem.DOWN = true;

		} else if (LEFT) {
			meuGerenciador.persoangem.LEFT = true;

		} else if (RIGHT) {
			meuGerenciador.persoangem.RIGHT = true;

		}
		// Random rnd = new Random();

		for (int i = 0; i < meuGerenciador.LISTA_DE_PARTICULAS.size(); i++) {
			meuGerenciador.LISTA_DE_PARTICULAS.get(i).oldx = (int) meuGerenciador.LISTA_DE_PARTICULAS
					.get(i).x;
			meuGerenciador.LISTA_DE_PARTICULAS.get(i).oldy = (int) meuGerenciador.LISTA_DE_PARTICULAS
					.get(i).y;
			int x = (int) meuGerenciador.LISTA_DE_PARTICULAS.get(i).x;
			int y = (int) meuGerenciador.LISTA_DE_PARTICULAS.get(i).y;
			int tmpx = ((x) / 16);
			int tmpy = ((y) / 16);

			// if (tmpx >= 0 && tmpy >= 0) {

			System.out.println("ANTES X" + x);
			System.out.println("ANTES Y" + y);
			AEstrela ia = LISTA_IA.get(i);
			// caminho = ia.calculaPath(tmpx, tmpy, 30, 30);
			caminho = ia.calculaPath(tmpy, tmpx, 4, 4);
			System.out.println("DEPOIS Tamanho " + caminho.size());

			meuGerenciador.LISTA_DE_PARTICULAS.get(i).x = caminho.get(1).getx() * 16;
			meuGerenciador.LISTA_DE_PARTICULAS.get(i).y = caminho.get(1).gety() * 16;
			for (int h = 0; h < caminho.size(); h++) {
				System.out.println("INDICE "+ h);
				System.out.println("POSICAO x " + caminho.get(h).getx() * 16);
				System.out.println("POSICAO y " + caminho.get(h).gety() * 16);
			}
			ia.resetaEstrela();
			// }
			// for (int j = 0; j < caminho.size(); j++) {
			// Nodo n = caminho.get(j);
			// System.out.println("NODO "+ );
			// }

			/*
			 * if (animacao == 0) { x = rnd.nextInt(4); }
			 * 
			 * if (x == 0) { meuGerenciador.LISTA_DE_PARTICULAS.get(i).UP =
			 * true; } if (x == 1) {
			 * meuGerenciador.LISTA_DE_PARTICULAS.get(i).DOWN = true; } if (x ==
			 * 2) { meuGerenciador.LISTA_DE_PARTICULAS.get(i).LEFT = true; } if
			 * (x == 3) { meuGerenciador.LISTA_DE_PARTICULAS.get(i).RIGHT =
			 * true; }
			 */
		}
		animacao += 1;

		meuGerenciador.persoangem.simula(diffTime);
		meuGerenciador.simula(diffTime);
		meuGerenciador.persoangem.UP = false;
		meuGerenciador.persoangem.DOWN = false;
		meuGerenciador.persoangem.LEFT = false;
		meuGerenciador.persoangem.RIGHT = false;

		// tempo que o personagem segue uma direcao
		if (animacao == 35) {
			for (int i = 0; i < meuGerenciador.LISTA_DE_PARTICULAS.size(); i++) {
				meuGerenciador.LISTA_DE_PARTICULAS.get(i).UP = false;
				meuGerenciador.LISTA_DE_PARTICULAS.get(i).DOWN = false;
				meuGerenciador.LISTA_DE_PARTICULAS.get(i).LEFT = false;
				meuGerenciador.LISTA_DE_PARTICULAS.get(i).RIGHT = false;

			}
			animacao = 0;
		}

	}

	public GameLevel1(int nivel) {

		String[] musica = { "som/som.wav" };
		meuSom = new GerenciadorDeSom(musica, false);

		// Imagem do mapa
		BufferedImage tileset = Constantes.LoadImage("tileset.png");
		// meuMapa = new Mapa(tileset, 0, 0, 0, 0, Color.black, 16, 16);
		meuMapa = new Fase1(tileset, 0, 0, 0, 0, Color.black, 16, 16);

		Constantes.LoadScript("scripts/scriptNomes.csv");

		// Imagem do personagem
		BufferedImage image = Constantes.LoadImage("p1.png");
		meuGerenciador.criaPersonagem(image);

		// criando os alimentos saudaveis
		for (int i = 0; i < 3; i++) {
			BufferedImage image2 = Constantes.LoadImage("cenoura.png");
			meuGerenciador.criaAlimentoBom(image2);
		}
		// alimentos nao saudaveis
		for (int i = 0; i < 3; i++) {
			BufferedImage image3 = Constantes.LoadImage("fantasma.png");
			meuGerenciador.criaAlimentoRuim(image3);
		}

		// criando os personagens fantasma
		for (int i = 0; i < nivel * 2; i++) {
			BufferedImage image2 = Constantes.LoadImage("p2.png");
			meuGerenciador.criaPersonagemDoenca(image2);

			// AESTRELA
			AEstrela ia = new AEstrela(meuMapa.matrizDoMapa, 42, 60);
			LISTA_IA.add(ia);

		}

	}

	@Override
	public void draw(Graphics2D dbg) {

		meuMapa.draw(dbg);
		meuGerenciador.draw(dbg);
	}

	@Override
	public void keyPressed(KeyEvent tecla) {

		meuGerenciador.persoangem.oldx = (int) meuGerenciador.persoangem.x;
		meuGerenciador.persoangem.oldy = (int) meuGerenciador.persoangem.y;

		int code = tecla.getKeyCode();

		switch (code) {

		case KeyEvent.VK_UP:
			UP = true;
			break;

		case KeyEvent.VK_DOWN:
			DOWN = true;
			break;

		case KeyEvent.VK_LEFT:
			LEFT = true;
			break;

		case KeyEvent.VK_RIGHT:
			RIGHT = true;
			break;
		default:
			break;
		}

	}

	@Override
	public void keyreleassed(KeyEvent tecla) {

		int code = tecla.getKeyCode();

		switch (code) {
		case KeyEvent.VK_UP:
			UP = false;
			break;
		case KeyEvent.VK_DOWN:
			DOWN = false;
			break;
		case KeyEvent.VK_LEFT:
			LEFT = false;
			break;
		case KeyEvent.VK_RIGHT:
			RIGHT = false;
			break;
		default:
			break;
		}

	}

	@Override
	public void mousePressed(MouseEvent mouse) {
		/*
		 * int x = mouse.getX(); int y = mouse.getY();
		 * 
		 * meuGerenciador.criaParticula(Math.atan2(y - GamePanel.GAME_HEIGHT/2,
		 * x - GamePanel.GAME_WIDTH/2)); meuGerenciador.criaPad(10);
		 * 
		 * meuSom.playSomInALoop(0);
		 */
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent mouse) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseMoved(MouseEvent mouse) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent mouse) {
		// TODO Auto-generated method stub

	}

}
