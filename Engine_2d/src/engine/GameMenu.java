package engine;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import sun.security.jca.GetInstance.Instance;

import engine.util.Constantes;

public class GameMenu extends GameCanvas  {

	BufferedImage tileset;
	Main main;
	public GameMenu(Main test){
		// Imagem do mapa
		 main = test;
		tileset = Constantes.LoadImage("tileset.png");
	}
	@Override
	public void gameUpdate(long diffTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics2D dbg) {
		// TODO Auto-generated method stub
		dbg.drawImage(tileset, null, null);
		
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
		main.cria_jogo(2);
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
