package pong;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import engine.GameCanvas;
import engine.GameObject;
import engine.GamePanel;
import engine.util.Constantes;

public class PongGame extends GameCanvas {
	
	
	//int x, y;
	Bolinha bolinhaPong;
	PongPand padum;
	PongPand paddois;
	
	BufferedImage pacman;
	boolean DOWN = false, UP = false;
	
	public PongGame(){
		pacman = Constantes.LoadImage("pacman.png");
		bolinhaPong = new Bolinha(GamePanel.GAME_WIDTH/2 - 50, GamePanel.GAME_HEIGHT/2 - 50 ,25, 25, 10, Color.black);
		//padum = new   PongPand(30, 250, 20, 200, 0, 100, Color.blue);
		//paddois = new PongPand(GamePanel.GAME_WIDTH-30, 250, 20, 200, 0, 100, Color.CYAN);
		listaDeObjetos.add(padum);
		listaDeObjetos.add(paddois);
		listaDeObjetos.add(bolinhaPong);
	}

	
	@Override
	public void gameUpdate(long diffTime) {
		for(int i = 0; i< listaDeObjetos.size(); i++){
			GameObject tmp = listaDeObjetos.get(i);
			tmp.simula(diffTime);
		}
		
		if(Constantes.colideRetangulo(bolinhaPong, padum)){
			bolinhaPong.colidiu();
		}else if(Constantes.colideRetangulo(bolinhaPong, paddois)){
			bolinhaPong.colidiu();
		}
		
		if(UP){
			padum.y-=30*diffTime/100.f;
		}
		if(DOWN){
			padum.y+=30*diffTime/100.f;
		}
		
	}

	@Override
	public void draw(Graphics2D dbg) {
		// TODO Auto-generated method stub
		/*Color tmp = dbg.getColor();
		dbg.setColor(Color.black);
		dbg.fillRect(x, y, 100, 100);
		dbg.setColor(tmp);
		*/
		dbg.drawImage(pacman, 300, 300, null);
		
		for(int i = 0; i< listaDeObjetos.size(); i++){
			GameObject tmp = listaDeObjetos.get(i);
			tmp.draw(dbg);
		}
		 
	}


	@Override
	public void keyPressed(KeyEvent tecla) {
		// TODO Auto-generated method stub
		int key = tecla.getKeyCode();
		switch (key) {
		case KeyEvent.VK_W:
			UP = true;
			break;
		case KeyEvent.VK_S:
			DOWN = true;
			break;
		default:
			break;
		}
		
		System.out.println("oiuujo9y8mg");

		//padum.y =
	}


	@Override
	public void keyreleassed(KeyEvent tecla) {
		int key = tecla.getKeyCode();
		switch (key) {
		case KeyEvent.VK_W:
			UP = false;
			break;
		case KeyEvent.VK_S:
			DOWN = false;
			break;
		default:
			break;
		}
		System.out.println("8tbf8ni");
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
		//x = mouse.getX();
		//y = mouse.getY();
		paddois.y = mouse.getY();
		
	}


	@Override
	public void mouseDragged(MouseEvent mouse) {
		// TODO Auto-generated method stub
		
	}







}
