package engine.Gerenciadores;

import engine.GamePanel;

public abstract class GerenciadorBase implements Runnable {

	public boolean processoParalelo;
	public boolean running;

	public GerenciadorBase(boolean _processoParalelo) {
		if (_processoParalelo) {
			processoParalelo = _processoParalelo;
			running = true;
			new Thread(this).start();
		}
	}

	@Override
	public void run() {
		while (running) {
			simula(GamePanel.diffTime);
		}

	}

	public abstract void simula(long diffTime);

}
