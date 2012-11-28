package engine.Particulas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import engine.GameObject;
import engine.GamePanel;

public class EffectPontos extends GameObject {
	
	public int contadorDeVida;
	public int TEMPO_TOTAL_DE_VIDA;
	public String pontos;
	Font font;

	public EffectPontos( int _x, int _y, Color _Cor, String _pontos) {
		super(_x, _y, _Cor);
		TEMPO_TOTAL_DE_VIDA = 150;
		pontos = _pontos;
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void draw(Graphics2D dbg){
		font = new Font("Book Antiqua", Font.BOLD, 25);
		dbg.setFont(font);
		dbg.setColor(Color.black);
		dbg.drawString( pontos , (int) x, (int) y );

	}

	@Override
	public void simula(long diffTime) {
		// TODO Auto-generated method stub
		
	}

}
