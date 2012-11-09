package engine.Particulas;

import java.awt.Color;
import java.awt.image.BufferedImage;

import engine.Sprite;

public class EffectPontos extends Sprite {
	
	public int contadorDeVida;
	public int TEMPO_TOTAL_DE_VIDA;

	public EffectPontos(BufferedImage _imagem, int _x, int _y, Color _Cor) {
		super(_imagem, _x, _y, _Cor);
		TEMPO_TOTAL_DE_VIDA = 150;
		// TODO Auto-generated constructor stub
	}

}
