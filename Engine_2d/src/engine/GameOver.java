package engine;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import engine.util.Constantes;

public class GameOver extends GameCanvas {

	BufferedImage tileset;
	BufferedImage mBackground;
	ArrayList<Botao> mListaDeBotoes = new ArrayList<Botao>();
	Font font;

	public GameOver() {

		BufferedImage over = Constantes.LoadImage("jogar4.png");
		BufferedImage notOver = Constantes.LoadImage("jogar3.png");
		BufferedImage sair = Constantes.LoadImage("sair4.png");
		BufferedImage notSair = Constantes.LoadImage("sair3.png");
		mBackground = Constantes.LoadImage("game_over_t.png");

		Botao mPlayButton = new Botao(680, 550, over, notOver) {

			@Override
			public void buttonAction() {
				GamePanel.trocaFase(GamePanel.GAME_LEVEL_1, GamePanel.fase);
			}
		};
		
		Botao mPlayButton2 = new Botao(100, 550, sair, notSair) {

			@Override
			public void buttonAction() {
				GamePanel.isntance.stopGame();
			}
		};

		mListaDeBotoes.add(mPlayButton);
		mListaDeBotoes.add(mPlayButton2);

	}

	@Override
	public void gameUpdate(long diffTime) {

	}

	@Override
	public void draw(Graphics2D dbg) {

		dbg.drawImage(mBackground, 60, 0, null, null);
		font = new Font("Book Antiqua", Font.BOLD, 90);
		dbg.setFont(font);
		dbg.setColor(Color.black);
		dbg.drawString("Game Over", 300, 225);
		
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
