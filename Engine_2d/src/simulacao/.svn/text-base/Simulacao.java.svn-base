package simulacao;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Random;

import engine.GameCanvas;
import engine.GamePanel;

public class Simulacao extends GameCanvas {

	public static final int QUANTIDADE_DE_FORMIGAS = 3000;
	public Mapa meuMapa;
	Random rnd = new Random();

	public Simulacao() {

		meuMapa = new Mapa();

		for (int i = 0; i < QUANTIDADE_DE_FORMIGAS; i++) {

			Formiga tmp = new Formiga(0, 0, Color.red);
			tmp.posX = rnd.nextInt(Mapa.LARGURA);
			tmp.posY = rnd.nextInt(Mapa.ALTURA);
			listaDeObjetos.add(tmp);
		}

	}

	@Override
	public void gameUpdate(long diffTime) {

		for (int i = 0; i < listaDeObjetos.size(); i++) {
			listaDeObjetos.get(i).simula(diffTime);
		}
	}

	@Override
	public void draw(Graphics2D dbg) {

		Color tmpColor = dbg.getColor();

		meuMapa.draw(dbg);
		for (int i = 0; i < listaDeObjetos.size(); i++) {
			listaDeObjetos.get(i).draw(dbg);
		}
		dbg.setColor(Color.black);
		dbg.drawString("Quantidade de formigas " + listaDeObjetos.size(),
				GamePanel.GAME_WIDTH - 100, 100);
		dbg.setColor(tmpColor);

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
		// TODO Auto-generated method stub

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
