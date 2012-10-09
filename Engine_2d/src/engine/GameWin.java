package engine;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import engine.util.Constantes;

public class GameWin extends GameCanvas {

	BufferedImage tileset;
	BufferedImage mBackground;
	// Main main;

	ArrayList<Botao> mListaDeBotoes = new ArrayList<Botao>();

	public GameWin() {

		BufferedImage over = Constantes.LoadImage("play2.png");
		BufferedImage notOver = Constantes.LoadImage("play1.png");
		mBackground = Constantes.LoadImage("game_over.png");

		Botao mPlayButton = new Botao(700, 500, over, notOver) {

			@Override
			public void buttonAction() {
				int fase = GamePanel.indiceGameCanvas;
				if (fase < 4)
					GamePanel.trocaFase(GamePanel.GAME_LEVEL_1, fase+1);
				
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

		dbg.drawImage(mBackground, 0, 0, null, null);
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

	public boolean mouseButonPressed(Botao bt, int x, int y) {

		if (Constantes.colidePorRetangulo(x, y, 1, 1, (int) bt.x, (int) bt.y,
				bt.width, bt.heigth)) {
			return true;
		} else {
			return false;
		}
	} 

}
