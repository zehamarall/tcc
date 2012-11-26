package engine;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import engine.util.Constantes;

public class GameInfo extends GameCanvas {

	BufferedImage tileset;
	BufferedImage mBackground;
	BufferedImage info;
	
	ArrayList<Botao> mListaDeBotoes = new ArrayList<Botao>();

	public GameInfo() {
		
	
		tileset = Constantes.LoadImage("tileset.png");
		BufferedImage over = Constantes.LoadImage("jogar4.png");
		BufferedImage notOver = Constantes.LoadImage("jogar3.png");
		
		mBackground = Constantes.LoadImage("menu2.jpg");
		info = Constantes.LoadImage("info.png");

		Botao mPlayButton = new Botao(400, 430, over, notOver) {

			@Override
			public void buttonAction() {
				
				GamePanel.trocaFase(GamePanel.GAME_MENU);

			}
		};

		mListaDeBotoes.add(mPlayButton);

	}

	@Override
	public void gameUpdate(long diffTime) {
	
	}

	@Override
	public void draw(Graphics2D dbg) {

		dbg.drawImage(mBackground, 0, 0, null, null);
		dbg.drawImage(info, 260, 40, null, null);
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
