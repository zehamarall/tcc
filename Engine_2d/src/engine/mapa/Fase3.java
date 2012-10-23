package engine.mapa;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Fase3 extends Mapa {

	public Fase3(BufferedImage _image, int _x, int _y, int _velx, int _vely,
			Color _Cor, int _larguraDoTile, int _alturaDoTile) {
		super(_image, _x, _y, _velx, _vely, _Cor, 0, 0);

		larguraDoTile = _alturaDoTile;
		alturaDoTile = _larguraDoTile;
		matrizDoMapa = new int[][] {
				{ 973, 974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 973, 974, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 973, 974, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 973, 974, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 973, 974, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 973, 974, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 973, 974, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 973, 974, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 973, 974, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 973, 974, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 973, 974, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 973, 974, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 973, 974, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 973, 974, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 973, 974, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 973, 974, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 973, 974, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 973, 974, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 973, 974, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 973, 974, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 973, 974, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 973, 974, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 973, 974, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 973, 974, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 973, 974, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 973, 974, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 973, 974, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 973, 974, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 973, 974, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 973, 974, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 973, 974, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 973, 974, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 973, 974, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 973, 974, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 973, 974, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 973, 974, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 973, 974, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 973, 974, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 973, 974, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 973, 974, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 973, 974, 973,
						974, 973, 974, 973, 974, 973, 974, 973, 974, 973, 974,
						973, 974, 973, 974, 973, 974, 973, 974, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003,
						1004, 1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004,
						1003, 1004, 1003, 1004, 1003, 1004, 1003, 1004 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 967, 968,
						969, 970, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 997, 998, 999, 1000, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 1027, 1028, 1029, 1030, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						967, 968, 969, 970, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 1057, 1058, 1059, 1060, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 997,
						998, 999, 1000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 967, 968,
						969, 970, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1027, 1028,
						1029, 1030, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 997, 998, 999,
						1000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1057, 1058,
						1059, 1060, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1027, 1028,
						1029, 1030, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1057, 1058, 1059, 1060,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 967, 968, 969, 970, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 997,
						998, 999, 1000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1027, 1028, 1029,
						1030, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 1057, 1058, 1059, 1060, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 967,
						968, 969, 970, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 997, 998, 999, 1000,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 1027, 1028, 1029, 1030, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1015,
						1016, 1017, 1018, 1019, 1020, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 1057, 1058, 1059, 1060, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						1045, 1046, 1047, 1048, 1049, 1050, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1075,
						1076, 1077, 1078, 1079, 1080, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 1015, 1016, 1017, 1018, 1019, 1020,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 1045, 1046, 1047, 1048, 1049, 1050, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 1075, 1076, 1077, 1078, 1079, 1080, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 967, 968,
						969, 970, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 997, 998, 999, 1000, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 967, 968, 969, 970, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 1027, 1028, 1029, 1030, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 997,
						998, 999, 1000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 1057, 1058, 1059, 1060, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1027,
						1028, 1029, 1030, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1057, 1058, 1059,
						1060, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 967, 968, 969, 970, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 997, 998,
						999, 1000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 1027, 1028, 1029, 1030, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 1057, 1058, 1059, 1060, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		// matrizDoMapa = new int [1000];

		// for (int i = 0; i < 1000; i++) {
		// for (int j = 0; j < 1000; j++) {
		// matrizDoMapa[i][j] = 1 + GamePanel.rnd.nextInt(450);
		// matrizDoMapa[i] = 114 ;
		// }
		// }
		preparaMapa();

	}

	private void preparaMapa() {
		BufferedImage tmpImagem = new BufferedImage(64 * larguraDoTile,
				40 * alturaDoTile, BufferedImage.TYPE_INT_ARGB);
		Graphics tmpGraphic = tmpImagem.getGraphics();
		int i, j;

		System.out.println("LEN " + matrizDoMapa.length);
		//System.out.println("LEN " + matrizDoMapa.);
		
		for (i = 0; i < matrizDoMapa.length; i++) {
			for (j = 0; j < matrizDoMapa[i].length; j++) {
				System.out.println("MATRIZ "+ matrizDoMapa[i][j]);
				int valorTile = matrizDoMapa[i][j] - 1;
				if (valorTile == -1) {
					System.out.println("VALOR " + valorTile);
					valorTile = 1004;
				}
				// numero de tiled do mapa em largura
				int fx = j / 64;
				int fy = j % 64;
				// dbg.drawImage(image, valorTile*larguraDoTile,
				// valorTile*alturaDoTile, larguraDoTile, alturaDoTile,
				// i*larguraDoTile, j*alturaDoTile,larguraDoTile, alturaDoTile,
				// null);
				// System.out.println("pos x " + fx + " pos y " + fy + " TILE "
				// + valorTile);
				int sx = valorTile % (image.getWidth() / larguraDoTile);
				int sy = valorTile / (image.getWidth() / larguraDoTile);

				tmpGraphic.drawImage(image, fy * larguraDoTile, fx
						* larguraDoTile, fy * larguraDoTile + larguraDoTile, fx
						* alturaDoTile + alturaDoTile, sx * larguraDoTile, sy
						* alturaDoTile, sx * larguraDoTile + larguraDoTile, sy
						* alturaDoTile + alturaDoTile, null);
			}
		}

		image = tmpImagem;
	}

	@Override
	public void simula(long diffTime) {

	}

	@Override
	public void draw(Graphics2D dbg) {
		dbg.drawImage(image, 0, 0, null);
	}

}