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
		/*
		 * BufferedImage tmpImagem = new BufferedImage(60 * larguraDoTile, 42 *
		 * alturaDoTile, BufferedImage.TYPE_INT_ARGB); Graphics tmpGraphic =
		 * tmpImagem.getGraphics(); int i, j;
		 * 
		 * for (i = 0; i < matrizDoMapa.length; i++) { for (j = 0; j <
		 * matrizDoMapa[i].length; j++) {
		 * 
		 * int valorTile = matrizDoMapa[i][j]-1; if(valorTile == -1){ valorTile
		 * = 1860; } //numero de tiled do mapa em largura int fx = j / 60; int
		 * fy = j % 60; // dbg.drawImage(image, valorTile*larguraDoTile, //
		 * valorTile*alturaDoTile, larguraDoTile, alturaDoTile, //
		 * i*larguraDoTile, j*alturaDoTile,larguraDoTile, alturaDoTile, //
		 * null); System.out.println("pos x "+fx+" pos y "+fy +" TILE " +
		 * valorTile); int sx = valorTile % (image.getWidth() / larguraDoTile);
		 * int sy = valorTile / (image.getWidth() / larguraDoTile);
		 * 
		 * tmpGraphic.drawImage(image, fy * larguraDoTile, fx larguraDoTile, fy
		 * * larguraDoTile + larguraDoTile, fx alturaDoTile + alturaDoTile, sx *
		 * larguraDoTile, sy alturaDoTile, sx * larguraDoTile + larguraDoTile,
		 * sy alturaDoTile + alturaDoTile, null); } }
		 * 
		 * image = tmpImagem;
		 */
	}

	@Override
	public void simula(long diffTime) {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Graphics2D dbg) {
		dbg.drawImage(image, 0, 0, null);

	}

}
