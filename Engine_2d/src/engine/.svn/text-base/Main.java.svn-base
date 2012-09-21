package engine;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.Font;
import java.awt.Label;

import javax.swing.JApplet;

import level.GameLevel;

import pong.PongGame;

public class Main extends JApplet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Main instance;

	private GamePanel meuGamePanel;

	@Override
	public void init() {
		// TODO Auto-generated method stub

		super.init();

		instance = this;
		setFocusable(true);

		Container c = getContentPane();
		c.setLayout(new BorderLayout());

		// meuGamePanel = new GamePanel(new Simulacao());
		// meuGamePanel = new GamePanel(new PongGame());
		meuGamePanel = new GamePanel(new GameLevel());

		c.add(meuGamePanel, "Center");

		resize(GamePanel.GAME_WIDTH, GamePanel.GAME_HEIGHT);

		meuGamePanel.startGame();

	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		super.start();
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		super.stop();
		meuGamePanel.stopGame();
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		meuGamePanel.stopGame();
	}

}
