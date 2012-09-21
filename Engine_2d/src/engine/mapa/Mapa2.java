package engine.mapa;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import engine.GameObject;
import engine.GamePanel;
import engine.MoveableSprite;

public class Mapa2 extends MoveableSprite {

	int larguraDoTile, alturaDoTile;
	public static int[][] matrizDoMapa = {
			{ 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861,
					1862, 1861, 1862, 1861, 1862, 1861, 1862, 1861, 1862, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891,
					1892, 1891, 1892, 1891, 1892, 1891, 1892, 1891, 1892 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 1201, 1202, 1203, 1204, 1205, 1206,
					1207, 1208, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1231, 1232,
					1233, 1234, 1235, 1236, 1237, 1238, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 1261, 1262, 1263, 1264, 1265, 1266, 1267, 1268,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1291, 1292, 1293, 1294,
					1295, 1296, 1297, 1298, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					901, 902, 903, 904, 905, 906, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 1321, 1322, 1323, 1324, 1325, 1326, 1327,
					1328, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 931, 932, 933, 934,
					935, 936, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 967, 968, 969, 970, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 1351, 1352, 1353, 1354, 1355, 1356, 1357, 1358, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 961, 962, 963, 964, 965, 966, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1123, 997,
					998, 999, 1000, 1123, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 1381, 1382, 1383, 1384, 1385, 1386, 1387, 1388, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 991, 992, 993, 994, 995, 996, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1153, 1027, 1028,
					1029, 1030, 1153, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					1411, 1412, 1413, 1414, 1415, 1416, 1417, 1418, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 1021, 1022, 1023, 1024, 1025, 1026, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1057, 1058,
					1059, 1060, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1441,
					1442, 1443, 1444, 1445, 1446, 1447, 1448, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 1051, 1052, 1053, 1054, 1055, 1056, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1471, 1472, 1473, 1474,
					1475, 1476, 1477, 1478, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1581, 1582, 1581, 1582,
					1581, 1582, 1581, 1582, 1581, 1582, 1581, 1582, 1581, 1582,
					1582, 1581, 1582, 1583, 1584, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1611, 1612, 1611, 1612,
					1611, 1612, 1611, 1612, 1611, 1612, 1611, 1612, 1611, 1612,
					1612, 1611, 1612, 1613, 1614, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1093, 1094, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 345, 346, 1643, 1644, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1123,
					1124, 1501, 1502, 1503, 1504, 1505, 1506, 1507, 1508, 0,
					1123, 0, 0, 0, 375, 376, 1673, 1674, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 1093, 1094, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1153, 1154,
					1531, 1532, 1533, 1534, 1535, 1536, 1537, 1538, 0, 1153, 0,
					0, 0, 405, 406, 1643, 1644, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					1123, 1124, 1299, 1300, 1301, 1302, 1303, 1304, 1305, 1306,
					1093, 1094, 1183, 1184, 1561, 1562, 1563, 1564, 1565, 1566,
					1567, 1568, 0, 0, 0, 0, 0, 0, 0, 1673, 1674, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 1153, 1154, 1329, 1330, 1331, 1332, 1333, 1334,
					1335, 1336, 1123, 1124, 0, 0, 1591, 1592, 1593, 1594, 1595,
					1596, 1597, 1598, 0, 0, 0, 0, 0, 0, 0, 1643, 1644, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 1183, 1184, 1359, 1360, 1361, 1362, 1363,
					1364, 1365, 1366, 1153, 1154, 0, 0, 1621, 1622, 1623, 1624,
					1625, 1626, 1627, 1628, 0, 0, 0, 1123, 0, 0, 1123, 1673,
					1674, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1093, 1094, 1389, 1390,
					1391, 1392, 1393, 1394, 1395, 1396, 1183, 1184, 0, 0, 1651,
					1652, 1653, 1654, 1655, 1656, 1657, 1658, 0, 0, 0, 1153, 0,
					0, 1153, 1643, 1644, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1123, 1124,
					1419, 1420, 1421, 1422, 1423, 1424, 1425, 1426, 1093, 1094,
					1093, 1094, 1681, 1682, 1683, 1684, 1685, 1686, 1687, 1688,
					0, 0, 0, 0, 0, 0, 0, 1673, 1674, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					1153, 1154, 1449, 1450, 1451, 1452, 1453, 1454, 1455, 1456,
					1123, 1124, 1123, 1124, 1711, 1712, 1713, 1714, 1715, 1716,
					1717, 1718, 0, 0, 0, 0, 0, 0, 0, 1643, 1644, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 1183, 1184, 1479, 1480, 1481, 1482, 1483, 1484,
					1485, 1486, 1153, 1154, 1153, 1154, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 1123, 0, 345, 346, 1643, 1644, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1183, 1184, 1183,
					1184, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1153, 0, 375, 376,
					1673, 1674, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 345, 346, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 405, 406, 1643, 1644, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 375,
					376, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1701, 1701, 1702,
					1701, 1701, 1702, 1701, 1702, 1701, 1701, 1702, 1701, 1702,
					1701, 1702, 1701, 1702, 1703, 1704, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					405, 406, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1731, 1731,
					1732, 1731, 1731, 1732, 1731, 1732, 1731, 1731, 1732, 1731,
					1732, 1731, 1732, 1731, 1732, 1733, 1734, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0} };

	public Mapa2(BufferedImage _image, int _x, int _y, int _velx, int _vely,
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
		BufferedImage tmpImagem = new BufferedImage(60 * larguraDoTile,
				42 * alturaDoTile, BufferedImage.TYPE_INT_ARGB);
		Graphics tmpGraphic = tmpImagem.getGraphics();
		int i, j;

		for (i = 0; i < matrizDoMapa.length; i++) {
			for (j = 0; j < matrizDoMapa[i].length; j++) {

				int valorTile = matrizDoMapa[i][j]-1;
				if(valorTile == -1){
					valorTile = 1860;
				}
				//numero de tiled do mapa em largura
				int fx = j / 60;
				int fy = j % 60;
				// dbg.drawImage(image, valorTile*larguraDoTile,
				// valorTile*alturaDoTile, larguraDoTile, alturaDoTile,
				// i*larguraDoTile, j*alturaDoTile,larguraDoTile, alturaDoTile,
				// null);
				System.out.println("pos x "+fx+" pos y "+fy +" TILE " + valorTile);
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
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Graphics2D dbg) {
		dbg.drawImage(image, 0, 0, null);
	}

}
