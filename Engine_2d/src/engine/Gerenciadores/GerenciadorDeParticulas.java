package engine.Gerenciadores;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import level.GameLevel;

import engine.GamePanel;
import engine.Sprite;
import engine.Particulas.PersonagemDoenca;
import engine.Particulas.PersonagemPrincipal;
import engine.util.Constantes;

public class GerenciadorDeParticulas extends GerenciadorBase {

	public ArrayList<PersonagemDoenca> LISTA_DE_PARTICULAS = new ArrayList<PersonagemDoenca>();
	public PersonagemPrincipal persoangem;
	public ArrayList<Sprite> LISTA_DE_ALIMENTOS = new ArrayList<Sprite>();
	public boolean gameOver = false;
	int contador;
	int pontos = 0;
	int vidas = 3;
	Random rnd = new Random();
	Font font = new Font("Serlf", Font.BOLD, 32);

	public GerenciadorDeParticulas(boolean _processoParalelo) {
		super(_processoParalelo);
	}

	public void criaObjeto(BufferedImage image) {

		while (true) {
			int x = rnd.nextInt(GamePanel.GAME_WIDTH - 40);
			int y = rnd.nextInt(GamePanel.GAME_HEIGHT - 40);
			int tmpx = ((x + 12) / 16);
			int tmpy = ((y + 12) / 16);

			if (tmpx >= 0 && tmpy >= 0) {
				int valor = tmpx + (((tmpy * 60) / 60) * 60);
				System.out.println(" Coeficiente X " + tmpx + " MOD "
						+ ((tmpy * 60) / 60));
				int[][] matrizDoMapa = engine.mapa.Fase1.matrizDoMapa;
				System.out.println("Valor " + valor + "MAPA "
						+ matrizDoMapa[1][valor]);
				if (matrizDoMapa[1][valor] == 0) {

					LISTA_DE_ALIMENTOS
							.add(new Sprite(image, x, y, Color.black) {
							});
					return;
				}
			}
		}
	}

	public void criaPersonagem(BufferedImage image) {
		System.out.println("Criando o personagem");
		persoangem = new PersonagemPrincipal(image, GamePanel.GAME_WIDTH / 2,
				GamePanel.GAME_HEIGHT / 2, Color.black);
	}

	public void criaPersonagemDoenca(BufferedImage image) {

		while (true) {
			int x = rnd.nextInt(GamePanel.GAME_WIDTH - 40);
			int y = rnd.nextInt(GamePanel.GAME_HEIGHT - 40);
			int tmpx = ((x + 18) / 16);
			int tmpy = ((y + 18) / 16);

			if (tmpx >= 0 && tmpy >= 0) {
				int valor = tmpx + (((tmpy * 60) / 60) * 60);
				System.out.println(" Coeficiente X " + tmpx + " MOD "
						+ ((tmpy * 60) / 60));
				int[][] matrizDoMapa = engine.mapa.Fase1.matrizDoMapa;
				System.out.println("Valor " + valor + "MAPA "
						+ matrizDoMapa[1][valor]);
				if (matrizDoMapa[1][valor] == 0) {

					LISTA_DE_PARTICULAS.add(new PersonagemDoenca(image, x, y,
							Color.black));
					return;
				}
			}
		}
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
				System.out.println("VIDA" + vidas);
				if (Constantes.colideRetangulo(persoangem,
						LISTA_DE_PARTICULAS.get(i))) {
					persoangem.colidiu();
					vidas -= 1;
					System.out.println("Colidiu Com a doença Vidas " + vidas);
					if (vidas <= 0) {
						
						System.out.println("GAME OVER");
						gameOver = true;
					}
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
		if (gameOver == false) {
			persoangem.draw(dbg);

			for (i = 0; i < LISTA_DE_PARTICULAS.size(); i++) {
				LISTA_DE_PARTICULAS.get(i).draw(dbg);
			}

			for (i = 0; i < LISTA_DE_ALIMENTOS.size(); i++) {
				LISTA_DE_ALIMENTOS.get(i).draw(dbg);
			}
			dbg.setColor(Color.black);
			dbg.drawString("VIDAS: " + vidas, GamePanel.GAME_WIDTH - 100, 15);
			dbg.drawString("PONTOS: " + pontos, GamePanel.GAME_WIDTH - 100, 30);
		} // else {
			// dbg.drawString("Game Over", 100 ,
			// 100);
			// dbg.drawString("Game Over", GamePanel.GAME_HEIGHT / 2 ,
			// GamePanel.GAME_WIDTH / 2);
		// }
		if (gameOver == true) {
			GamePanel.trocaFase(GamePanel.GAME_OVER);
			gameOver = false;
			vidas = 3;
			/*dbg.setFont(font);
			dbg.drawString("Game Over", (GamePanel.GAME_WIDTH / 2) - 20,
					GamePanel.GAME_HEIGHT / 2);
			dbg.drawString("Jogar Novamente ?",
					(GamePanel.GAME_WIDTH / 2) - 20,
					(GamePanel.GAME_HEIGHT / 2) + 70);
			 */
		}
		if (LISTA_DE_ALIMENTOS.size() == 0) {
			dbg.setFont(font);
			dbg.drawString("Você Venceu", (GamePanel.GAME_WIDTH / 2) - 20,
					GamePanel.GAME_HEIGHT / 2);
			GamePanel.trocaFase(GamePanel.GAME_VENCEDOR);
		}
	}
}
