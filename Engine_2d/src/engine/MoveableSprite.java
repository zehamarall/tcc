package engine;

import java.awt.Color;
import java.awt.image.BufferedImage;

public abstract class MoveableSprite extends MoveAbleGameObject {

	public BufferedImage image;

	public MoveableSprite(BufferedImage _image, int _x, int _y, int _velx,
			int _vely, int _raio, Color _Cor) {
		super(_x, _y, _velx, _vely, _image.getWidth(), _image.getHeight(), _Cor);
		image = _image;
	}

	public MoveableSprite(int _x, int _y, int _velx, int _vely, int _raio,
			Color _Cor) {
		super(_x, _y, _velx, _vely, _raio, _Cor);
	}

}
