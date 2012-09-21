package pong;

import java.awt.Color;
import java.awt.Graphics2D;

import engine.GamePanel;
import engine.Particulas.Particula;

public class PongPand extends Particula {

	public PongPand(int _x, int _y, int _velx, int _vely, int _largura,
			int _altura, Color _Cor, double _angle, int _TEMPO_DE_VIDA, int _dano) {
		super(_x, _y, (float)_velx , (float) _velx, _Cor, _angle, _TEMPO_DE_VIDA);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void simula(long diffTime) {
		// TODO Auto-generated method stub
		oldx = (int)x;
		oldy = (int)y;
		
		/*if(y < 0)
			y = oldy;
		else if (y+altura > GamePanel.GAME_HEIGHT)
			y = oldy;
		
		if(x < 0)
			x = oldx;
		else if (x+largura > GamePanel.GAME_WIDTH)
			x = oldx;
		*/
	}

	@Override
	public void draw(Graphics2D dbg) {
		// TODO Auto-generated method stub
		Color tmp = dbg.getColor();
		dbg.setColor(cor);
		dbg.fillRect((int)x, (int)y, 10 , 10);
		dbg.setColor(tmp);
		//System.out.println("DEBUG desenha");
		
	}

}
