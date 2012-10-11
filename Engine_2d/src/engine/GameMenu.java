package engine;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import engine.util.Constantes;

public class GameMenu extends GameCanvas {

	BufferedImage tileset;
	BufferedImage mBackground;
	Main main;

	ArrayList<Botao> mListaDeBotoes = new ArrayList<Botao>();

	public GameMenu(Main test) {
		// Imagem do mapa
		main = test;
		tileset = Constantes.LoadImage("tileset.png");
		BufferedImage over = Constantes.LoadImage("jogar2.png");
		BufferedImage notOver = Constantes.LoadImage("jogar.png");
		BufferedImage opcoes = Constantes.LoadImage("opcoes2.png");
		BufferedImage notOpcoes = Constantes.LoadImage("opcoes.png");
		BufferedImage sair = Constantes.LoadImage("sair2.png");
		BufferedImage notSair = Constantes.LoadImage("sair1.png");
		mBackground = Constantes.LoadImage("menu.jpg");

		Botao mPlayButton = new Botao(430, 130, over, notOver) {

			@Override
			public void buttonAction() {
				GamePanel.fase = 1;
				GamePanel.trocaFase(GamePanel.GAME_LEVEL_1, GamePanel.fase);

			}
		};
		
		Botao mOpcoes = new Botao(430, 230, opcoes, notOpcoes) {

			@Override
			public void buttonAction() {
				GamePanel.trocaFase(GamePanel.GAME_OPCOES);

			}
		};
		
		Botao mExitButton = new Botao(430, 530, sair, notSair) {

			@Override
			public void buttonAction() {
				GamePanel.isntance.stopGame();

			}
		};

		mListaDeBotoes.add(mPlayButton);
		mListaDeBotoes.add(mOpcoes);
		mListaDeBotoes.add(mExitButton);
	}

	@Override
	public void gameUpdate(long diffTime) {
	
	}

	@Override
	public void draw(Graphics2D dbg) {

		dbg.drawImage(mBackground, 150, 0, null, null);
		for (int i = 0; i < mListaDeBotoes.size(); i++) {
			mListaDeBotoes.get(i).draw(dbg);
		}

	}

	@Override
	public void keyPressed(KeyEvent tecla) {

	}

	@Override
	public void keyreleassed(KeyEvent tecla) {

	}

	@Override
	public void mousePressed(MouseEvent mouse) {

		int x = mouse.getX();
		int y = mouse.getY();

		for (int i = 0; i < mListaDeBotoes.size(); i++) {
			Botao tmp = mListaDeBotoes.get(i);
			if (mouseButonPressed(tmp, x, y)) {
				tmp.buttonPressed(mouse);
			}

		}
	}

	@Override
	public void mouseReleased(MouseEvent mouse) {

		int x = mouse.getX();
		int y = mouse.getY();

		for (int i = 0; i < mListaDeBotoes.size(); i++) {
			Botao tmp = mListaDeBotoes.get(i);
			if (mouseButonPressed(tmp, x, y)) {
				tmp.buttonReleased(mouse);
			}
		}

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

	public boolean mouseButonPressed(Botao bt, int x, int y) {

		if (Constantes.colidePorRetangulo(x, y, 1, 1, (int) bt.x, (int) bt.y,
				bt.width, bt.heigth)) {
			return true;
		} else {
			return false;
		}
	}

}
