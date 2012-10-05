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
		BufferedImage over = Constantes.LoadImage("play2.png");
		BufferedImage notOver = Constantes.LoadImage("play1.png");
		mBackground = Constantes.LoadImage("menu.jpg");

		Botao mPlayButton = new Botao(230, 230, over, notOver) {

			@Override
			public void buttonAction() {
				GamePanel.trocaFase(GamePanel.GAME_LEVEL);

			}
		};

		mListaDeBotoes.add(mPlayButton);
	}

	@Override
	public void gameUpdate(long diffTime) {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Graphics2D dbg) {

		dbg.drawImage(mBackground, null, null);
		for (int i = 0; i < mListaDeBotoes.size(); i++) {
			mListaDeBotoes.get(i).draw(dbg);
		}

	}

	@Override
	public void keyPressed(KeyEvent tecla) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyreleassed(KeyEvent tecla) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent mouse) {
		
		int x = mouse.getX();
		int y = mouse.getY();
		
		for (int i = 0; i < mListaDeBotoes.size(); i++) {
			Botao tmp = mListaDeBotoes.get(i);
			tmp.buttonPressed(mouse);

		}
	}

	@Override
	public void mouseReleased(MouseEvent mouse) {
		
		int x = mouse.getX();
		int y = mouse.getY();
		
		for (int i = 0; i < mListaDeBotoes.size(); i++) {
			Botao tmp = mListaDeBotoes.get(i);
			tmp.buttonReleased(mouse);

		}

	}

	@Override
	public void mouseClicked(MouseEvent mouse) {

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
