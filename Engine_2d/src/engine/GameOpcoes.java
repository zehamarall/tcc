package engine;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import engine.util.Constantes;

public class GameOpcoes extends GameCanvas {
	
	BufferedImage tileset;
	BufferedImage mBackground;
	Font font;

	ArrayList<Botao> mListaDeBotoes = new ArrayList<Botao>();

	public GameOpcoes() {
		
		BufferedImage easy = Constantes.LoadImage("facil2.png");
		BufferedImage notEasy = Constantes.LoadImage("facil1.png");
		BufferedImage mediun = Constantes.LoadImage("medio2.png");
		BufferedImage notMediun = Constantes.LoadImage("medio1.png");
		BufferedImage hard = Constantes.LoadImage("dificil2.png");
		BufferedImage notHard = Constantes.LoadImage("dificil1.png");
		mBackground = Constantes.LoadImage("menu.jpg");

		Botao mPlayButtonEasy = new Botao(420, 200, easy, notEasy) {

			@Override
			public void buttonAction() {
				GamePanel.nivelDificuldade = 1;
				GamePanel.fase = 1;
				GamePanel.trocaFase(GamePanel.GAME_LEVEL_1, GamePanel.fase);

			}
		};
		Botao mPlayButtonMediun = new Botao(420, 300, mediun, notMediun) {

			@Override
			public void buttonAction() {
				GamePanel.nivelDificuldade = 2;
				GamePanel.fase = 1;
				GamePanel.trocaFase(GamePanel.GAME_LEVEL_1, GamePanel.fase);

			}
		};

		Botao mPlayButtonHard = new Botao(420, 400, hard, notHard) {

			@Override
			public void buttonAction() {
				GamePanel.nivelDificuldade = 3;
				GamePanel.fase = 1;
				GamePanel.trocaFase(GamePanel.GAME_LEVEL_1, GamePanel.fase);

			}
		};

		mListaDeBotoes.add(mPlayButtonEasy);
		mListaDeBotoes.add(mPlayButtonMediun);
		mListaDeBotoes.add(mPlayButtonHard);
		
	}	

	@Override
	public void gameUpdate(long diffTime) {
		
	}

	@Override
	public void draw(Graphics2D dbg) {
		dbg.drawImage(mBackground, 150, 0, null, null);
		
		font = new Font("Book Antiqua", Font.BOLD, 36);
		dbg.setFont(font);
		dbg.setColor(Color.black);		
		dbg.drawString("Selecione o nivel do jogo", 350, 150);
		
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
