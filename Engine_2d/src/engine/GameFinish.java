package engine;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import engine.util.Constantes;

public class GameFinish extends GameCanvas {

	BufferedImage tileset;
	BufferedImage mBackground;
	ArrayList<Botao> mListaDeBotoes = new ArrayList<Botao>();
	Font font;

	public GameFinish() {

		BufferedImage over = Constantes.LoadImage("sair2.png");
		BufferedImage notOver = Constantes.LoadImage("sair1.png");
		BufferedImage jogar = Constantes.LoadImage("jogar2.png");
		BufferedImage notJogar = Constantes.LoadImage("jogar.png");
		mBackground = Constantes.LoadImage("finish.png");

		Botao mSairButton = new Botao(600, 500, over, notOver) {

			@Override
			public void buttonAction() {
				GamePanel.isntance.stopGame();
			}
		};

		Botao mJogarButton = new Botao(600, 400, jogar, notJogar) {

			@Override
			public void buttonAction() {
				GamePanel.fase = 1;
				GamePanel.trocaFase(GamePanel.GAME_MENU);
			}
		};

		mListaDeBotoes.add(mSairButton);
		mListaDeBotoes.add(mJogarButton);

	}

	@Override
	public void gameUpdate(long diffTime) {

	}

	@Override
	public void draw(Graphics2D dbg) {

		dbg.drawImage(mBackground, 0, 0, null, null);
		font = new Font("Book Antiqua", Font.BOLD, 32);
		dbg.setFont(font);
		dbg.setColor(Color.black);
		dbg.drawString("Parabéns", 520, 100);
		dbg.drawString("Você Concluiu o jogo", 520, 150);
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
