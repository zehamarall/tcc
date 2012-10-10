package engine;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JApplet;

import level.GameLevel1;

public class Main extends JApplet {

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
		
		//cria_jogo(1);
		meuGamePanel = new GamePanel(new GameMenu(instance));
		///cria_jogo(3);
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
	
	/*Define o nive do jogo*/
	public void cria_jogo(int nivel) {
		Container c = getContentPane();
		//c.setLayout(new BorderLayout());
		meuGamePanel = new GamePanel(new GameLevel1(nivel));
		c.add(meuGamePanel, "Center");
	
		
		
	}
}
