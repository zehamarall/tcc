package engine.Gerenciadores;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import engine.GamePanel;
import engine.Sprite;
import engine.Particulas.PersonagemDoenca;
import engine.Particulas.PersonagemPrincipal;
import engine.util.Constantes;

public class GerenciadorDeParticulas extends GerenciadorBase {

	public static final ArrayList<PersonagemDoenca> LISTA_DE_PARTICULAS = new ArrayList<PersonagemDoenca>();
	public PersonagemPrincipal persoangem;
	public static final ArrayList<Sprite> LISTA_DE_ALIMENTOS = new ArrayList<Sprite>();
	int contador;
	int pontos = 0;
	int vidas = 3;
	Random rnd = new Random();

	public GerenciadorDeParticulas(boolean _processoParalelo) {
		super(_processoParalelo);
	}

	public void criaObjeto(BufferedImage image) {
		LISTA_DE_ALIMENTOS.add(new Sprite(image, rnd
				.nextInt(GamePanel.GAME_WIDTH), rnd
				.nextInt(GamePanel.GAME_HEIGHT), Color.black) {
		});
	}

	public void criaPersonagem(BufferedImage image) {
		System.out.println("Criando o personagem");
		persoangem = new PersonagemPrincipal(image, GamePanel.GAME_WIDTH / 2,
				GamePanel.GAME_HEIGHT / 2, Color.black);
	}

	public void criaPersonagemDoenca(BufferedImage image) {

		System.out.println("Criando o personagem");

		LISTA_DE_PARTICULAS.add(new PersonagemDoenca(image, rnd
				.nextInt(GamePanel.GAME_WIDTH - 40), rnd
				.nextInt(GamePanel.GAME_HEIGHT - 40), Color.black));

	}

	@Override
	public void simula(long diffTime) {
		// persoangem.simula(diffTime);
		if (vidas > 0 && LISTA_DE_ALIMENTOS.size() > 0) {

			for (int i = 0; i < LISTA_DE_ALIMENTOS.size(); i++) {
				Sprite tmp = LISTA_DE_ALIMENTOS.get(i);

				tmp.simula(diffTime);

			}

			for (int i = 0; i < LISTA_DE_PARTICULAS.size(); i++) {
				PersonagemDoenca tmp = LISTA_DE_PARTICULAS.get(i);
				tmp.simula(diffTime);
			}
			// lista de alimentos saudaveis
			for (int i = 0; i < LISTA_DE_ALIMENTOS.size(); i++) {
				if (Constantes.colideRetangulo(persoangem,
						LISTA_DE_ALIMENTOS.get(i))) {
					persoangem.colidiu();
					LISTA_DE_ALIMENTOS.remove(i);
					pontos += 10;
					System.out.println("Colidiu Alimento Saudavel Pontos "
							+ pontos);
				}
			}
			// lista de personagens doença
			for (int i = 0; i < LISTA_DE_PARTICULAS.size(); i++) {
				System.out.println("");
				if (Constantes.colideRetangulo(persoangem,
						LISTA_DE_PARTICULAS.get(i))) {
					persoangem.colidiu();
					vidas -= 1;
					System.out.println("Colidiu Com a doença Vidas " + vidas);
					if (vidas < 0)
						System.out.println("GAME OVER");
				}
			}
		} else {
			if (vidas < 0)
				System.out.println("GAME OVER");
			if (LISTA_DE_ALIMENTOS.size() == 0)
				System.out.println("Você Venceu");

		}

	}

	public void draw(Graphics2D dbg) {
		int i;

		persoangem.draw(dbg);

		for (i = 0; i < LISTA_DE_PARTICULAS.size(); i++) {
			LISTA_DE_PARTICULAS.get(i).draw(dbg);
		}

		for (i = 0; i < LISTA_DE_ALIMENTOS.size(); i++) {
			LISTA_DE_ALIMENTOS.get(i).draw(dbg);
		}
		dbg.setColor(Color.black);
		dbg.drawString("VIDAS: " + vidas, GamePanel.GAME_WIDTH -100 , 15);
		dbg.drawString("PONTOS: " + pontos, GamePanel.GAME_WIDTH -100, 30);
	}

}
