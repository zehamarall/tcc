package engine.Gerenciadores;

import java.applet.AudioClip;

public class GerenciadorDeSom extends GerenciadorBase {

	static AudioClip[] playlist;
	int tocandoAgora;

	public GerenciadorDeSom(String[] musica, boolean _processoParalelo) {
		super(_processoParalelo);
		// playlist = new AudioClip[musica.length];
		for (int i = 0; i < musica.length; i++) {
			// playlist[i] = Constantes.loadAudio(musica[i]);
		}
	}

	public void playSomInALoop(int index) {
		// playlist[index].loop();
	}

	public void playSom(int index) {
		playlist[index].play();
	}

	public void stopAll() {
		for (int i = 0; i < playlist.length; i++) {
			playlist[i].stop();

		}
	}

	@Override
	public void simula(long diffTime) {
		// TODO Auto-generated method stub

	}

}
