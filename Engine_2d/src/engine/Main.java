package engine;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JApplet;

public class Main extends JApplet {

	private static final long serialVersionUID = 1L;
	public static Main instance;

	private GamePanel meuGamePanel;

	@Override
	public void init() {

		super.init();

		instance = this;
		setFocusable(true);

		Container c = getContentPane();
		c.setLayout(new BorderLayout());

		meuGamePanel = new GamePanel(new GameMenu(instance));
		c.add(meuGamePanel, "Center");

		resize(GamePanel.GAME_WIDTH, GamePanel.GAME_HEIGHT);

		meuGamePanel.startGame();

	}

	@Override
	public void start() {
		super.start();
	}

	@Override
	public void stop() {
		super.stop();
		meuGamePanel.stopGame();
	}

	@Override
	public void destroy() {
		super.destroy();
		meuGamePanel.stopGame();
	}
}
