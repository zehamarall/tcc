package engine;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Random;

import level.GameLevel;

public class GamePanel extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	// Variaveis para calcular FPS
	long Fps, Sfps;

	// Variaveis de Sistema
	public static final int GAME_WIDTH =  1024;
	public static final int GAME_HEIGHT = 665;
	private Thread animator;
	private boolean running = false;
	public static GamePanel isntance = null;
	public static Random rnd = new Random();
	public static int fase = 1;

	public static final short GAME_MENU		= 0;
	public static final short GAME_OPCOES	= 1;
	public static final short GAME_LEVEL_1	= 2;
	public static final short GAME_LEVEL_2	= 3;
	public static final short GAME_LEVEL_3	= 4;
	public static final short GAME_VENCEDOR	= 5;
	public static final short GAME_OVER		= 6;
	
	
	public static long diffTime;

	// Variaveis da Engine
	ArrayList<GameCanvas> listaDeGameCanvas;
	GameCanvas gameCanvasAtual;
	static int indiceGameCanvas;

	public GamePanel(GameCanvas primeiroGameCanvas) {

		
		isntance = this;
		listaDeGameCanvas = new ArrayList<GameCanvas>();
		listaDeGameCanvas.add(primeiroGameCanvas);
		listaDeGameCanvas.add(new GameOpcoes());
		listaDeGameCanvas.add(new GameLevel(1));
		listaDeGameCanvas.add(new GameLevel(2));
		listaDeGameCanvas.add(new GameLevel(3));
		listaDeGameCanvas.add(new GameWin());
		listaDeGameCanvas.add(new GameOver());
		
		gameCanvasAtual = primeiroGameCanvas;
		indiceGameCanvas = 0;

		// tratar evento do teclado
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent arg0) {

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				gameCanvasAtual.keyreleassed(arg0);
			}

			@Override
			// evento do teclado
			public void keyPressed(KeyEvent arg0) {
				gameCanvasAtual.keyPressed(arg0);
			}
		});

		// tratar metodos de mouse
		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				gameCanvasAtual.mouseReleased(e);

			}

			@Override
			public void mousePressed(MouseEvent e) {
				gameCanvasAtual.mousePressed(e);

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				gameCanvasAtual.mouseClicked(e);
			}
		});

		addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				gameCanvasAtual.mouseMoved(e);
			}

			@Override
			public void mouseDragged(MouseEvent e) {				
				gameCanvasAtual.mouseDragged(e);
			}
		});

	}

	public void addNotify() {

		super.addNotify();
		startGame();

	}

	public void startGame() {

		if (animator == null || !running) {
			animator = new Thread(this);
			animator.start();
		}

	}

	public void stopGame() {
		running = false;
	}

	public void gameUpdate(long diffTime) {
		gameCanvasAtual.gameUpdate(diffTime);
	}

	public void draw(Graphics2D dbg) {
		dbg.setColor(Color.white);
		dbg.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		
		gameCanvasAtual.draw(dbg);

		dbg.setColor(Color.black);
		dbg.drawString("FPS: " + Fps, 20, 20);
	}

	@Override
	public void run() {

		running = true;

		long tempoAnterior;
		diffTime = 0;
		int segundo = 0;

		tempoAnterior = System.currentTimeMillis();

		this.createBufferStrategy(4);
		BufferStrategy strategy = this.getBufferStrategy();

		while (running) {

			gameUpdate(diffTime);
			Graphics g = strategy.getDrawGraphics();
			draw((Graphics2D) g);
			strategy.show();

			try {
				Thread.sleep(10);
			} catch (Exception e) {
				System.out.println("pau no sleep " + e);
			}

			diffTime = System.currentTimeMillis() - tempoAnterior;
			tempoAnterior = System.currentTimeMillis();

			if (segundo != (int) (tempoAnterior / 1000)) {

				Fps = Sfps;
				Sfps = 1;
				segundo = (int) (tempoAnterior / 1000);

			} else {

				Sfps++;

			}

		}

		System.exit(0);

	}

	
	public static void trocaFase(int INDEX){
		System.out.println("INDEX "+ INDEX + "LISTA LEN " + GamePanel.isntance.listaDeGameCanvas.size());
		
		GamePanel.isntance.gameCanvasAtual = GamePanel.isntance.listaDeGameCanvas.get(INDEX);
		//indiceGameCanvas = INDEX;
		if(INDEX == GAME_LEVEL_1){
			fase = 1;
		}else if(INDEX == GAME_LEVEL_2){
			fase = 2;
		}else if(INDEX == GAME_LEVEL_3){
			fase = 3;
		}
		
	}
	
	public static void trocaFase(int INDEX,int nivelDeDificuldade){
		//GameLevel tmp = (GameLevel)
		GamePanel.isntance.listaDeGameCanvas.remove(INDEX);
		GameLevel tmp = new GameLevel(nivelDeDificuldade);
		GamePanel.isntance.listaDeGameCanvas.add(INDEX, tmp);
		GamePanel.isntance.gameCanvasAtual = GamePanel.isntance.listaDeGameCanvas.get(INDEX);
	
		//indiceGameCanvas = INDEX;
		if(INDEX == GAME_LEVEL_1){
			fase = 1;
		}else if(INDEX == GAME_LEVEL_2){
			fase = 2;
		}else if(INDEX == GAME_LEVEL_3){
			fase = 3;
		}
		
	}

}
