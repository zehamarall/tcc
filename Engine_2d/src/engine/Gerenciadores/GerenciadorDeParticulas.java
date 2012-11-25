package engine.Gerenciadores;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import engine.GamePanel;
import engine.Sprite;
import engine.Particulas.EffectPontos;
import engine.Particulas.PersonagemaMaldoso;
import engine.Particulas.PersonagemPrincipal;
import engine.util.Constantes;

public class GerenciadorDeParticulas extends GerenciadorBase {

	public ArrayList<PersonagemaMaldoso> LISTA_DE_PARTICULAS = new ArrayList<PersonagemaMaldoso>();
	public PersonagemPrincipal persoangem;
	public ArrayList<Sprite> LISTA_DE_ALIMENTOS_BOM = new ArrayList<Sprite>();
	public ArrayList<Sprite> LISTA_DE_ALIMENTOS_RUIM = new ArrayList<Sprite>();
	public ArrayList<EffectPontos> LISTA_DE_EFEITOS = new ArrayList<EffectPontos>();
	
	public boolean gameOver = false;
	int contador;
	int pontos = 0;
	int vidas = 3;
	Random rnd = new Random();
	Font font = new Font("Serlf", Font.BOLD, 32);

	public GerenciadorDeParticulas(boolean _processoParalelo) {
		super(_processoParalelo);
	}

	public void criaAlimentoBom(BufferedImage image) {

		while (true) {
			int x = rnd.nextInt(GamePanel.GAME_WIDTH - 40);
			int y = rnd.nextInt(GamePanel.GAME_HEIGHT - 40);
			int tmpx = ((x + 12) / 16);
			int tmpy = ((y + 12) / 16);

			if (tmpx >= 0 && tmpy >= 0) {
				int valor = tmpx + (((tmpy * 64) / 64) * 64);

				int[][] matrizDoMapa;

				if (GamePanel.fase == 1) {
					matrizDoMapa = engine.mapa.Fase1.matrizDoMapa;
				} else if (GamePanel.fase == 2) {
					matrizDoMapa = engine.mapa.Fase2.matrizDoMapa;
				} else {
					matrizDoMapa = engine.mapa.Fase3.matrizDoMapa;
				}

				if (matrizDoMapa[1][valor] == 0) {

					LISTA_DE_ALIMENTOS_BOM.add(new Sprite(image, x, y,
							Color.black) {
					});
					return;
				}
			}
		}
	}

	public void criaAlimentoRuim(BufferedImage image) {

		while (true) {
			int x = rnd.nextInt(GamePanel.GAME_WIDTH - 50);
			int y = rnd.nextInt(GamePanel.GAME_HEIGHT - 50);
			int tmpx = ((x) / 16);
			int tmpy = ((y) / 16);
			int tmpx2 = ((x + 16) / 16);
			int tmpy2 = ((y + 16) / 16);

			if (tmpx >= 0 && tmpy >= 0 && tmpx2 >= 0 && tmpy2 >= 0) {
				int valor = tmpx + (((tmpy * 64) / 64) * 64);
				int valor2 = tmpx2 + (((tmpy2 * 64) / 64) * 64);
				System.out.println(" Coeficiente X " + tmpx + " MOD "
						+ ((tmpy * 64) / 64));

				int[][] matrizDoMapa;

				if (GamePanel.fase == 1) {
					matrizDoMapa = engine.mapa.Fase1.matrizDoMapa;
				} else if (GamePanel.fase == 2) {
					matrizDoMapa = engine.mapa.Fase2.matrizDoMapa;
				} else {
					matrizDoMapa = engine.mapa.Fase3.matrizDoMapa;
				}

				System.out.println("Valor " + valor + "MAPA "
						+ matrizDoMapa[1][valor]);
				if (matrizDoMapa[1][valor] == 0 && matrizDoMapa[1][valor2] == 0) {

					LISTA_DE_ALIMENTOS_RUIM.add(new Sprite(image, x, y,
							Color.black) {
					});
					return;
				}
			}
		}
	}

	public void criaPersonagem(BufferedImage image) {
		System.out.println("Criando o personagem");
		 persoangem = new PersonagemPrincipal(image, (GamePanel.GAME_WIDTH / 2) +32,
		 (GamePanel.GAME_HEIGHT / 2)+32, Color.black);
	}

	public void criaEfeitoAlimento(int _x, int _y, String str) {
		
		LISTA_DE_EFEITOS.add(new EffectPontos(_x, _y, Color.black, str));
		
	}
	
	public void criaPersonagemDoenca(BufferedImage image) {

		while (true) {
			int x = rnd.nextInt(GamePanel.GAME_WIDTH - 40);
			int y = rnd.nextInt(GamePanel.GAME_HEIGHT - 40);
			int tmpx = ((x) / 16);
			int tmpy = ((y) / 16);
			int tmpx2 = ((x + 16) / 16);
			int tmpy2 = ((y + 16) / 16);
			int tmpx3 = ((x - 16) / 16);
			int tmpy3 = ((y - 16) / 16);

			if (tmpx >= 0 && tmpy >= 0) {
				int valor = tmpx + (((tmpy * 64) / 64) * 64);
				int valor2 = tmpx2 + (((tmpy2 * 64) / 64) * 64);
				int valor3 = tmpx3 + (((tmpy3 * 64) / 64) * 64);
				System.out.println(" Coeficiente X " + tmpx + " MOD "
						+ ((tmpy * 64) / 64));

				int[][] matrizDoMapa;

				if (GamePanel.fase == 1) {
					matrizDoMapa = engine.mapa.Fase1.matrizDoMapa;
				} else if (GamePanel.fase == 2) {
					matrizDoMapa = engine.mapa.Fase2.matrizDoMapa;
				} else {
					matrizDoMapa = engine.mapa.Fase3.matrizDoMapa;
				}

				if (matrizDoMapa[1][valor] == 0 && matrizDoMapa[1][valor2] == 0
						&& matrizDoMapa[1][valor3] == 0) {

					LISTA_DE_PARTICULAS.add(new PersonagemaMaldoso(image, x, y,
							Color.black, matrizDoMapa));
					return;
				}

			}
		}
	}

	@Override
	public void simula(long diffTime) {
	
		if (vidas > 0 && LISTA_DE_ALIMENTOS_BOM.size() > 0) {
			
			//atualiza os efeitos
			for (int i = 0; i < LISTA_DE_EFEITOS.size(); i++) {
				EffectPontos tmp = LISTA_DE_EFEITOS.get(i);
				tmp.contadorDeVida +=1;
				tmp.simula(diffTime);
				
				if(tmp.contadorDeVida == tmp.TEMPO_TOTAL_DE_VIDA){
					LISTA_DE_EFEITOS.remove(i);
				}

			}

			for (int i = 0; i < LISTA_DE_ALIMENTOS_BOM.size(); i++) {
				Sprite tmp = LISTA_DE_ALIMENTOS_BOM.get(i);
				tmp.simula(diffTime);

			}

			for (int i = 0; i < LISTA_DE_PARTICULAS.size(); i++) {
				PersonagemaMaldoso tmp = LISTA_DE_PARTICULAS.get(i);
				tmp.simula(diffTime);
			}
			// lista de alimentos saudaveis
			for (int i = 0; i < LISTA_DE_ALIMENTOS_BOM.size(); i++) {
				if (Constantes.colideRetangulo(persoangem,
						LISTA_DE_ALIMENTOS_BOM.get(i))) {
					persoangem.colidiu();
					
					pontos += 20;
					int x = (int) LISTA_DE_ALIMENTOS_BOM.get(i).x;
					int y = (int) LISTA_DE_ALIMENTOS_BOM.get(i).y;
					criaEfeitoAlimento(x, y, "+20");
					LISTA_DE_ALIMENTOS_BOM.remove(i);
				}
			}

			// lista de alimentos nao saudaveis
			for (int i = 0; i < LISTA_DE_ALIMENTOS_RUIM.size(); i++) {
				if (Constantes.colideRetangulo(persoangem,
						LISTA_DE_ALIMENTOS_RUIM.get(i))) {
					persoangem.colidiu();
					
					pontos -= 10;
					int x = (int) LISTA_DE_ALIMENTOS_RUIM.get(i).x;
					int y = (int) LISTA_DE_ALIMENTOS_RUIM.get(i).y;
		
					criaEfeitoAlimento(x, y, "-10");
					LISTA_DE_ALIMENTOS_RUIM.remove(i);
					
					
				}
			}
			// lista de personagens doença
			for (int i = 0; i < LISTA_DE_PARTICULAS.size(); i++) {
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
			if (LISTA_DE_ALIMENTOS_BOM.size() == 0)
				System.out.println("Você Venceu");

		}

	}

	public void draw(Graphics2D dbg) {

		int i;
		if (gameOver == false) {
			persoangem.draw(dbg);
			
			for (i = 0; i < LISTA_DE_EFEITOS.size(); i++) {
				LISTA_DE_EFEITOS.get(i).draw(dbg);
			}

			for (i = 0; i < LISTA_DE_PARTICULAS.size(); i++) {
				LISTA_DE_PARTICULAS.get(i).draw(dbg);
			}

			for (i = 0; i < LISTA_DE_ALIMENTOS_BOM.size(); i++) {
				LISTA_DE_ALIMENTOS_BOM.get(i).draw(dbg);
			}

			for (i = 0; i < LISTA_DE_ALIMENTOS_RUIM.size(); i++) {
				LISTA_DE_ALIMENTOS_RUIM.get(i).draw(dbg);
			}

			font = new Font("Book Antiqua", Font.BOLD, 18);
			dbg.setFont(font);
			dbg.setColor(Color.black);
			dbg.drawString("VIDAS: " + vidas, GamePanel.GAME_WIDTH - 150, 15);
			dbg.drawString("PONTOS: " + pontos, GamePanel.GAME_WIDTH - 150, 40);
			dbg.drawString("TEMPO: " + GamePanel.tempo,  GamePanel.GAME_WIDTH - 110, GamePanel.GAME_HEIGHT - 10);
		}

		if (gameOver == true) {
			GamePanel.trocaFase(GamePanel.GAME_OVER);
			gameOver = false;
			vidas = 3;
		}

		if (LISTA_DE_ALIMENTOS_BOM.size() == 0) {
			GamePanel.total_pontos += ((pontos*20)/GamePanel.tempo);
			if (GamePanel.fase < 3) {
				GamePanel.trocaFase(GamePanel.GAME_VENCEDOR);
			} else {
				GamePanel.trocaFase(GamePanel.GAME_FINISH);
			}
		}
	}
}
