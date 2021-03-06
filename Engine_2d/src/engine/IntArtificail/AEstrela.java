package engine.IntArtificail;

import java.util.ArrayList;

public class AEstrela {

	public int[][] mapa;
	public static int NUMERO_MAXIMO_DE_BUSCA = 99999;
	public int contador = 0;

	ArrayList<Nodo> nodosAbertos = new ArrayList<Nodo>();
	ArrayList<Nodo> nodosFechados = new ArrayList<Nodo>();
	ArrayList<Nodo> caminho = new ArrayList<Nodo>();
	Nodo candidatos[];
	int x, y;
	int largura, altura;
	int objetivox = 0;
	int objetivoy = 0;
	Nodo selecionado;

	public AEstrela(int[][] _mapa, int _largura, int _altura) {

		int k = 0;
		mapa = new int[_largura][_altura];
		System.out.println("MATRIZ ");
		for (int i = 0; i < 40; i++) {
			for (int j = 0; j < 64; j++) {
				mapa[i][j] = _mapa[1][k];
				System.out.print(mapa[i][j] + " ,");
				k++;
			}
			System.out.println();

		}

		largura = _largura;
		altura = _altura;
		candidatos = new Nodo[4];

	}

	public ArrayList<Nodo> calculaPath(int _x, int _y, int objx, int objy) {
		x = _x;
		y = _y;
		objetivox = objx;
		objetivoy = objy;

		selecionado = new Nodo(null, (short) x, (short) y, 0);

		while (abreNodo(selecionado) == false) {
			double menor = 99999999;
			int menoridx = -1;

			for (int z = 0; z < nodosAbertos.size(); z++) {
				Nodo nodo2 = nodosAbertos.get(z);
				double soma = nodo2.euristica;

				if (soma < menor) {
					menor = soma;
					menoridx = z;
				}
			}
			selecionado = nodosAbertos.get(menoridx);
			nodosAbertos.remove(menoridx);
		}

		Nodo onodo = nodosFechados.get(nodosFechados.size() - 1);

		caminho.add(onodo);
		while (onodo.pai != null) {
			onodo = onodo.pai;
			caminho.add(onodo);
		}
		return caminho;
	}

	public void resetaEstrela() {

		nodosAbertos.clear();
		nodosFechados.clear();
		caminho.clear();

	}

	public boolean abreNodo(Nodo onodo) {
		nodosFechados.add(onodo);

		candidatos[0] = new Nodo(onodo, (short) (onodo.x + 1), onodo.y,
				onodo.energia + 1);
		candidatos[1] = new Nodo(onodo, onodo.x, (short) (onodo.y + 1),
				onodo.energia + 1);
		candidatos[2] = new Nodo(onodo, (short) (onodo.x - 1), onodo.y,
				onodo.energia + 1);
		candidatos[3] = new Nodo(onodo, onodo.x, (short) (onodo.y - 1),
				onodo.energia + 1);

		for (int i = 0; i < 4; i++) {
			Nodo ntest = candidatos[i];

			if (ntest.x == objetivox && ntest.y == objetivoy) {
				nodosFechados.add(ntest);

				return true;
			} else {

				if (!(ntest.x < 0 || ntest.y < 0 || ntest.x + 1 > largura || ntest.y + 1 > altura)) {

					if (!(mapa[ntest.x][ntest.y] != 0)) {
						boolean igual = false;
						Nodo nodo2;
						for (int z = 0; z < nodosFechados.size(); z++) {
							nodo2 = nodosFechados.get(z);
							if (ntest.x == nodo2.x && ntest.y == nodo2.y) {
								igual = true;
								break;
							}
						}
						if (igual) {
							continue;
						}

						for (int z = 0; z < nodosAbertos.size(); z++) {
							nodo2 = nodosAbertos.get(z);
							if (ntest.x == nodo2.x && ntest.y == nodo2.y) {
								igual = true;
								break;
							}
						}
						if (igual) {
							continue;
						}

						ntest.euristica = calculaheuristica(ntest.x, ntest.y,
								objetivox, objetivoy);
						nodosAbertos.add(ntest);

					}

				}

			}

		}

		return false;
	}

	public double calculaheuristica(int x, int y, int objx, int objy) {
		double difx = objx - x;
		double dify = objy - y;
		return Math.sqrt(difx * difx + dify * dify);
	}
}
