package level;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import engine.GameCanvas;
import engine.Gerenciadores.GerenciadorDeParticulas;
import engine.Gerenciadores.GerenciadorDeSom;
import engine.mapa.Fase2;
import engine.util.Constantes;

public class GameLevel2 extends GameCanvas {

	Fase2 meuMapa;
	GerenciadorDeParticulas meuGerenciador = new GerenciadorDeParticulas(false);
	GerenciadorDeSom meuSom;

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
			meuGerenciador.LISTA_DE_PARTICULAS.get(i).objx = meuGerenciador.persoangem.oldy/16;
			meuGerenciador.LISTA_DE_PARTICULAS.get(i).objy = meuGerenciador.persoangem.oldx/16;
			meuGerenciador.LISTA_DE_PARTICULAS.get(i).simula(diffTime);
		}

	}

	public GameLevel2(int nivel) {

		String[] musica = { "som/som.wav" };
		meuSom = new GerenciadorDeSom(musica, false);

		// Imagem do mapa
		BufferedImage tileset = Constantes.LoadImage("tileset.png");
		// meuMapa = new Mapa(tileset, 0, 0, 0, 0, Color.black, 16, 16);
		meuMapa = new Fase2(tileset, 0, 0, 0, 0, Color.black, 16, 16);

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
