package engine;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import level.GameLevel;

public class GameMenu extends Applet  {

	private static final long serialVersionUID = 1L;
	public static final int GAME_WIDTH =  960;
	public static final int GAME_HEIGHT = 672;
	private GamePanel meuGamePanel;

	public GameMenu() {


		meuGamePanel = new GamePanel(new GameLevel(2));
		
		addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
	
				setFocusable(true);
				Container c = getContentPane();
				c.setLayout(new BorderLayout());
				System.out.println("Click");
				c.add(meuGamePanel, "Center");
				resize(GAME_WIDTH, GAME_HEIGHT);
				//meuGamePanel.startGame();
				

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
	}
	public void setConteiner(Container _c ){
		c = _c;
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
		//meuGamePanel.stopGame();
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		//meuGamePanel.stopGame();
	}

}
