package engine;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import engine.util.Constantes;

public class GameOpcoes extends GameCanvas {
	
	BufferedImage tileset;
	BufferedImage mBackground;

	ArrayList<Botao> mListaDeBotoes = new ArrayList<Botao>();

	public GameOpcoes() {
		
		BufferedImage over = Constantes.LoadImage("play2.png");
		BufferedImage notOver = Constantes.LoadImage("play1.png");
		mBackground = Constantes.LoadImage("menu.jpg");

		Botao mPlayButton = new Botao(430, 230, over, notOver) {

			@Override
			public void buttonAction() {
				GamePanel.fase = 1;
				GamePanel.trocaFase(GamePanel.GAME_LEVEL_1, GamePanel.fase);

			}
		};

		mListaDeBotoes.add(mPlayButton);
		
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
