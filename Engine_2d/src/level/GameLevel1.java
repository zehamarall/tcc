package level;

//import Nodo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

import engine.GameCanvas;
import engine.GamePanel;
import engine.Gerenciadores.GerenciadorDeParticulas;
import engine.Gerenciadores.GerenciadorDeSom;
import engine.mapa.Fase1;
import engine.util.Constantes;

public class GameLevel1 extends GameCanvas {

	Fase1 meuMapa;
	GerenciadorDeParticulas meuGerenciador = new GerenciadorDeParticulas(false);
	GerenciadorDeSom meuSom;
	public static int[] alimentobom = new int[3];
	public static int[] alimentoruim = new int[3];
	Random rnd = new Random();

	private boolean UP = false;
	private boolean DOWN = false;
	private boolean LEFT = false;
	private boolean RIGHT = false;

	@Override
	public void gameUpdate(long diffTime) {

		if (UP) {
			meuGerenciador.persoangem.UP = true;

		} else if (DOWN) {
			meuGerenciador.persoangem.DOWN = true;

		} else if (LEFT) {
			meuGerenciador.persoangem.LEFT = true;

		} else if (RIGHT) {
			meuGerenciador.persoangem.RIGHT = true;

		}

		meuGerenciador.persoangem.simula(diffTime);
		meuGerenciador.simula(diffTime);

		for (int i = 0; i < meuGerenciador.LISTA_DE_PARTICULAS.size(); i++) {

			meuGerenciador.LISTA_DE_PARTICULAS.get(i).objx = (int) (meuGerenciador.persoangem.y + (meuGerenciador.persoangem.sizeY / 2)) / 16;
			meuGerenciador.LISTA_DE_PARTICULAS.get(i).objy = (int) (meuGerenciador.persoangem.x + (meuGerenciador.persoangem.sizeX / 2)) / 16;

			meuGerenciador.LISTA_DE_PARTICULAS.get(i).simula(diffTime);
		}

	}

	public GameLevel1(int nivel) {

		// String[] musica = { "som/som.wav" };
		// meuSom = new GerenciadorDeSom(musica, false);

		// meuSom.playSomInALoop(0);

		// Imagem do mapa
		BufferedImage tileset = Constantes.LoadImage("tileset.png");
		meuMapa = new Fase1(tileset, 0, 0, 0, 0, Color.black, 16, 16);

		Constantes.LoadScript("scripts/scriptNomes.csv");

		// Imagem do personagem
		BufferedImage image = Constantes.LoadImage("pnovo.png");
		meuGerenciador.criaPersonagem(image);

		BufferedImage image2 = Constantes.LoadImage("bons2.png");

		// criando os alimentos saudaveis
		for (int i = 0; i < 3; i++) {
			int x = rnd.nextInt(19);
			BufferedImage tmpImagem = new BufferedImage(50, 50,
					BufferedImage.TYPE_INT_ARGB);
			Graphics tmpGraphic = tmpImagem.getGraphics();
			tmpGraphic.drawImage(image2, 0, 0, 50, 50, (x * 50), 0,
					((x * 50) + 50), 50, null);
			alimentobom[i] = x;
			meuGerenciador.criaAlimentoBom(tmpImagem);
		}

		BufferedImage image4 = Constantes.LoadImage("ruins2.png");
		// alimentos nao saudaveis
		for (int i = 0; i < 3; i++) {
			int x = rnd.nextInt(13);
			BufferedImage tmpImagem = new BufferedImage(50, 50,
					BufferedImage.TYPE_INT_ARGB);
			Graphics tmpGraphic = tmpImagem.getGraphics();
			System.out.println("CRIANDO X " + x);
			tmpGraphic.drawImage(image4, 0, 0, 50, 50, (x * 50), 0,
					((x * 50) + 50), 50, null);
			alimentoruim[i] = x;
			meuGerenciador.criaAlimentoRuim(tmpImagem);

		}

		/* criando os personagens Maldoso */

		for (int i = 0; i < nivel + 1; i++) {
			BufferedImage image3 = Constantes.LoadImage("bruxa.png");
			meuGerenciador.criaPersonagemDoenca(image3);
		}
		GamePanel.tempo = 0;

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

		// meuSom.playSomInALoop(0);

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent mouse) {

	}

	@Override
	public void mouseMoved(MouseEvent mouse) {

	}

	@Override
	public void mouseDragged(MouseEvent mouse) {

	}

}
