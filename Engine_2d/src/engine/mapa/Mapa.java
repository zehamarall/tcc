package engine.mapa;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import engine.MoveableSprite;

public abstract class Mapa extends MoveableSprite {

	int larguraDoTile, alturaDoTile;
	public static int[][] matrizDoMapa;

	public Mapa(BufferedImage _image, int _x, int _y, int _velx, int _vely,
			Color _Cor, int _larguraDoTile, int _alturaDoTile) {
		super(_image, _x, _y, _velx, _vely, 0, _Cor);

		larguraDoTile = _alturaDoTile;
		alturaDoTile = _larguraDoTile;

		preparaMapa();

	}

	private void preparaMapa() {

	}

	@Override
	public void simula(long diffTime) {

	}

	@Override
	public void draw(Graphics2D dbg) {
		dbg.drawImage(image, 0, 0, null);

	}

}
