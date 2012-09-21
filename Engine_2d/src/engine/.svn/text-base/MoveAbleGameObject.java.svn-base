package engine;

import java.awt.Color;

public abstract class MoveAbleGameObject extends GameObject {

	public int largura, altura, raio;
	public float velx, vely; // velocidade no eixo x e y
	public int oldx, oldy;

	public MoveAbleGameObject(int _x, int _y, float _velx, float _vely,
			Color _Cor) {
		super(_x, _y, _Cor);
		velx = _velx;
		vely = _vely;
		oldx = _x;
		oldy = _y;
	}

	public MoveAbleGameObject(int _x, int _y, float _velx, float _vely,
			int _largura, int _altura, Color _Cor) {
		super(_x, _y, _Cor);
		altura = _altura;
		largura = _largura;
		velx = _velx;
		vely = _vely;
		oldx = _x;
		oldy = _y;
	}

	public MoveAbleGameObject(int _x, int _y, float _velx, float _vely,
			int _raio, Color _Cor) {
		super(_x, _y, _Cor);
		raio = _raio;
		velx = _velx;
		vely = _vely;
		oldx = _x;
		oldy = _y;
	}

}
