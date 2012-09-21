package engine.Particulas;

import java.awt.Color;
import java.awt.Graphics2D;

public class Projetil extends Particula {

	public int dano;

	public Projetil(int _x, int _y, int _velx, int _vely, Color _Cor,
			double _angle, int _TEMPO_DE_VIDA, int _dano) {
		super(_x, _y, (float) Math.cos(_angle) * _velx, (float) Math
				.sin(_angle) * _velx, _Cor, _angle, _TEMPO_DE_VIDA);
		dano = _dano;

	}

	@Override
	public void simula(long diffTime) {
		// TODO Auto-generated method stub
		contadorDeVida += diffTime;

		if (contadorDeVida > TEMPO_TOTAL_DE_VIDA) {
			vida = false;
			System.out.println("dead");
		}
		x += velx * diffTime / 1000.0f;
		y += vely * diffTime / 1000.0f;
	}

	@Override
	public void draw(Graphics2D dbg) {
		Color tmpColor = dbg.getColor();
		dbg.setColor(cor);
		dbg.fillArc((int) x, (int) y, 20, 20, 0, 360);
		dbg.setColor(tmpColor);

	}

}
