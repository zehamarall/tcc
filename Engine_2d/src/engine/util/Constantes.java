package engine.util;

import java.applet.AudioClip;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import res.resource.Link;
import engine.MoveAbleGameObject;
import engine.Sprite;
import engine.Particulas.PersDoenca;
import engine.Particulas.PersPrincipal;
import engine.Particulas.PersonagemDoenca;
import engine.Particulas.PersonagemPrincipal;

public class Constantes {
	static int count = 0;
	static Link meulink;

	public static BufferedImage LoadImage(String nomedoaarquivo) {
		meulink = new Link();
		BufferedImage imagem = null;
		try {
			imagem = ImageIO.read(Link.singleton.getClass().getResource(
					"img/" + nomedoaarquivo));
			System.out.println();
		} catch (Exception e) {
			System.out.println("ERRO AO ABRIR ARQUIVO");
		}
		return imagem;
	}

	/**
	 * metodos de colis�o raio e reytangulo
	 */
	public static boolean colidePorRaio(int x1, int y1, int raio1, int x2,
			int y2, int raio2) {
		int dX = x1 - x2;
		int dY = y1 - y2;
		int sr = raio1 + raio2;
		int distancia = dX * dX + dY * dY;
		return (distancia < (sr * sr)) ? true : false;
	}

	public static boolean colidePorRaio(MoveAbleGameObject entidadeum,
			MoveAbleGameObject entidadedois) {
		int dX = (int) entidadeum.x - (int) entidadedois.x;
		int dY = (int) entidadeum.y - (int) entidadedois.y;
		int sr = entidadeum.raio + entidadedois.raio;
		int distancia = dX * dX + dY * dY;
		return (distancia < (sr * sr)) ? true : false;
	}

	public static boolean colidePorRetangulo(int x1, int y1, int largura1,
			int altura1, int x2, int y2, int largura2, int altura2) {

		if (x1 + largura1 > x2 && x1 < x2 + largura2 && y1 + altura1 > y2
				&& y1 < y2 + altura2) {
			return true;
		}
		return false;
	}

	public static boolean colideRetangulo(PersPrincipal entidadeum,
			Sprite entidadedois) {

		if (entidadeum.x + entidadeum.image.getWidth() > entidadedois.x
				&& entidadeum.x < entidadedois.x
						+ entidadedois.image.getWidth()
				&& entidadeum.y + entidadeum.image.getHeight() > entidadedois.y
				&& entidadeum.y < entidadedois.y
						+ entidadedois.image.getHeight()) {
			return true;
		}
		return false;
	}

	public static boolean colideRetangulo(PersonagemPrincipal entidadeum,
			Sprite entidadedois) {
		if (entidadeum.x + entidadeum.sizeX > entidadedois.x
				&& entidadeum.x < entidadedois.x
						+ entidadedois.image.getWidth()
				&& entidadeum.y + entidadeum.sizeY > entidadedois.y
				&& entidadeum.y < entidadedois.y
						+ entidadedois.image.getHeight()) {
			return true;
		}

		return false;
	}

	public static boolean colideRetangulo(PersonagemPrincipal entidadeum,
			PersonagemDoenca entidadedois) {

		if (entidadeum.efeito == false) {
			if ((entidadeum.x + (entidadeum.sizeX - 15)) > entidadedois.x
					&& entidadeum.x < (entidadedois.x + (entidadedois.sizeX - 15))
					&& (entidadeum.y + (entidadeum.sizeY - 15)) > entidadedois.y
					&& entidadeum.y < (entidadedois.y + (entidadedois.sizeY - 15))) {

				entidadeum.efeito = true;
				return true;

			} else {
				return false;
			}

		} else {
			return false;
		}

	}

	public static boolean colideRetangulo(PersonagemPrincipal entidadeum,
			PersDoenca entidadedois) {
		if (entidadeum.x + entidadeum.sizeX > entidadedois.x
				&& entidadeum.x < entidadedois.x
						+ entidadedois.image.getWidth()
				&& entidadeum.y + entidadeum.sizeY > entidadedois.y
				&& entidadeum.y < entidadedois.y
						+ entidadedois.image.getHeight()) {
			return true;
		}

		return false;
	}

	public static boolean colideRetangulo(MoveAbleGameObject entidadeum,
			MoveAbleGameObject entidadedois) {
		if (entidadeum.x + entidadeum.largura > entidadedois.x
				&& entidadeum.x < entidadedois.x + entidadedois.largura
				&& entidadeum.y + entidadeum.altura > entidadedois.y
				&& entidadeum.y < entidadedois.y + entidadedois.altura) {
			return true;
		}
		return false;
	}

	public static Object LoadScript(String filename) {
		BufferedReader scriptFile = new BufferedReader(new InputStreamReader(
				Link.singleton.getClass().getResourceAsStream(filename)));

		String str = "";
		try {
			while ((str = scriptFile.readLine()) != null) {
				if (str.charAt(0) != '#') {
					String[] tmp = str.split(";");
					String nome = tmp[0];
					String sobrenome = tmp[1];
					System.out.println("Nome: " + nome);
					System.out.println("Sobrenome: " + sobrenome);
				}

			}
		} catch (Exception e) {
			System.out.println("erro ao abrir arquivo de script");
		}

		return null;
	}

	public static AudioClip loadAudio(String nomedoaarquivo) {

		return null;

	}
}
