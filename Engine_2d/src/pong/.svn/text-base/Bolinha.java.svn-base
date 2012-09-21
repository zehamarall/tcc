package pong;

import java.awt.Color;
import java.awt.Graphics2D;

import engine.GamePanel;
import engine.MoveAbleGameObject;

public class Bolinha extends MoveAbleGameObject {

	
	float angulo = 0;
	public Bolinha(int _x, int _y, int velx, int vely, int _raio, Color _Cor) {
		super(_x, _y, velx, vely, _raio, _Cor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void simula(long diffTime) {
		// TODO Auto-generated method stub
		
		oldx = (int) x;
		oldy = (int) y;
		x += velx*diffTime/100.0f;
		y += vely*diffTime/100.0f;
		
		if( x < 0 ){
			velx *= -1;
			x = oldx;
		}else if(x+raio > GamePanel.GAME_WIDTH){
			velx *= -1;
			x = oldx;
		}
		
		
		if( y < 0 ){
			vely *= -1;
			y = oldy;
		}else if(y+raio > GamePanel.GAME_HEIGHT){
			vely *= -1;
			y = oldy;
		}
		
		if(angulo<360){
			angulo++;
		}else{
			angulo = 0;
		}

	}

	@Override
	public void draw(Graphics2D dbg) {
		// TODO Auto-generated method stub
		Color tmp = dbg.getColor();
		
		//AffineTransform tmpaffine = dbg.getTransform();
		//AffineTransform affineDoDbg = new AffineTransform();
		//affineDoDbg.translate(x+raio/2, y+raio/2);
		
		//affineDoDbg.rotate(Math.toRadians(angulo));
		
		//dbg.setTransform(affineDoDbg);
		
		
		dbg.setColor(cor);
		
		//dbg.fillArc(-50, -50, raio, raio, 0, 360);
		
		dbg.fillOval((int) x,(int) y, raio, raio);
		
		dbg.setColor(Color.white);
		
		//dbg.drawLine(-raio/2, -raio/2, raio, raio);
		
		//dbg.setTransform(tmpaffine);
		dbg.setColor(tmp);
		
		
		
	}
	public void  colidiu() {
		velx *=-1;
		x = oldx;
	}

}
