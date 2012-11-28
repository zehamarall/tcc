package engine;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import level.GameLevel1;
import level.GameLevel2;
import level.GameLevel3;

import engine.util.Constantes;

public class GameWin extends GameCanvas {

	BufferedImage tileset;
	BufferedImage mBackground;
	ArrayList<Botao> mListaDeBotoes = new ArrayList<Botao>();
	BufferedImage alimentobom;
	BufferedImage alimentoruim;
	Font font;

	public GameWin() {

		BufferedImage over = Constantes.LoadImage("proximo2.png");
		BufferedImage notOver = Constantes.LoadImage("proximo1.png");
		BufferedImage sair = Constantes.LoadImage("sair4.png");
		BufferedImage notSair = Constantes.LoadImage("sair3.png");
		alimentobom = Constantes.LoadImage("bons2.png");
		alimentoruim = Constantes.LoadImage("ruins2.png");
		mBackground = Constantes.LoadImage("game_over2.png");

		Botao mPlayButton = new Botao(680, 550, over, notOver) {

			@Override
			public void buttonAction() {
				System.out.println("FASE " + GamePanel.fase);
				if (GamePanel.fase < 3) {
					GamePanel.fase += 1;
					GamePanel.trocaFase(GamePanel.GAME_LEVEL_1, GamePanel.fase);
				} else {
					System.out.println("Acabou o Jogo");
					
				}
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
		font = new Font("Book Antiqua", Font.BOLD, 50);
		dbg.setFont(font);
		dbg.setColor(Color.black);		
		dbg.drawString("Parabéns", 395, 80);
		dbg.drawString("Você passou de fase", 300, 150);
		dbg.drawString("Total de Pontos = " + GamePanel.total_pontos, 300, 230);
		for (int i = 0; i < mListaDeBotoes.size(); i++) {
			mListaDeBotoes.get(i).draw(dbg);
		}
		
		String aux = "";
		alimentoInfo info = new alimentoInfo();
		for (int i = 0; i < 3; i++) {
			int x = 0;
			if (GamePanel.fase == 1){
				x = (int)GameLevel1.alimentobom[i];
			}else if (GamePanel.fase == 2){
				x = (int)GameLevel2.alimentobom[i];
			}else if (GamePanel.fase == 3){
				x = (int)GameLevel3.alimentobom[i];
			}
			BufferedImage tmpImagem = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);
			Graphics tmpGraphic = tmpImagem.getGraphics();
			tmpGraphic.drawImage(alimentobom, 0, 0, 50, 50, (x * 50), 0, ((x * 50) + 50), 50, null);
			dbg.drawImage(tmpImagem, 70+i*50, 330, null, null);
			aux += info.alimentoCaracteristica(x);
			if(i != 2){
				aux += ", ";
			}

		}
		dbg.drawString(aux, 250, 370);
		
		for (int i = 0; i < 3; i++) {
			int x = 0;
			if (GamePanel.fase == 1){
				x = (int)GameLevel1.alimentoruim[i];
			}else if (GamePanel.fase == 2){
				x = (int)GameLevel2.alimentoruim[i];
			}else if (GamePanel.fase == 3){
				x = (int)GameLevel3.alimentoruim[i];
			}
			BufferedImage tmpImagem = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);
			Graphics tmpGraphic = tmpImagem.getGraphics();
			tmpGraphic.drawImage(alimentoruim, 0, 0, 50, 50, (x * 50), 0, ((x * 50) + 50), 50, null);
			dbg.drawImage(tmpImagem, 70+i*50, 400, null, null);

		}
		dbg.drawString("Excesso gordura e açúcar ", 250, 440);
		
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
