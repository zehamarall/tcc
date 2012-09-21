package simulacao;

import java.awt.Color;
import java.awt.Graphics2D;

import engine.GameObject;

public class Formiga extends GameObject {

	// posX no mapa e posY no mapa (tiles)
	public int posX, posY;
	// Sentido da Direcao da formiga
	private int direcao;

	public Formiga(int _x, int _y, Color _Cor) {
		super(_x, _y, _Cor);

	}

	@Override
	public void simula(long diffTime) {

		movimentaNaMatrix();

	}

	@Override
	public void draw(Graphics2D dbg) {
		Color corTmp = dbg.getColor();
		dbg.setColor(cor);
		dbg.drawArc((int)x, (int)y, 3, 3, 0, 360);
		dbg.setColor(corTmp);

	}

	// Movimenta Formiga na Matrix
	public void movimentaNaMatrix() {

		int estado = Mapa.matrix[posX][posY];
		Mapa.matrix[posX][posY] = Mapa.matrix[posX][posY] == 0 ? 1 : 0;

		switch (estado) {
		case 0:

			switch (direcao) {
			case 0:
				 posX++;
				break;
			case 1:
				posY++;
				break;
			case 2:
				posX--;
				break;
			case 3:
				posY--;
				break;

			}
			
			direcao = (direcao+1)%4;

			break;
		case 1:

			switch (direcao) {
			case 0:
				posX--;
				break;
			case 1:
				posY--;
				break;
			case 2:
				posX++;
				break;
			case 3:
				posY++;
				break;

			}
			direcao = (direcao-1+4)%4;
			break;
		}
		
		if(posX <0)
			posX = Mapa.LARGURA-1;
		else if(posX >= Mapa.LARGURA)
				posX =0;
		else if(posY  < 0)
			posY = Mapa.ALTURA-1;
		else if(posY >= Mapa.ALTURA)
			posY = 0;
		
		
		x = posX*Mapa.LARGURA_DO_TILE;
		y = posY*Mapa.ALTURA_DO_TILE;
				
				
		
		
	}

}
