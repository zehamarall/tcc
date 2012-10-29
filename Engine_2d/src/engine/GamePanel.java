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

import level.GameLevel1;
import level.GameLevel2;
import level.GameLevel3;

public class GamePanel extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	// Variaveis para calcular FPS
	long Fps, Sfps;

	// Variaveis de Sistema
	public static final int GAME_WIDTH = 1024;
	public static final int GAME_HEIGHT = 640;
	private Thread animator;
	private boolean running = false;
	public static GamePanel isntance = null;
	public static Random rnd = new Random();
	public static int fase = 0;
	public static int total_pontos = 0;
	public static int nivelDificuldade = 0;

	//Fases do jogo 
	public static final short GAME_MENU = 0;
	public static final short GAME_OPCOES = 1;
	public static final short GAME_VENCEDOR = 2;
	public static final short GAME_OVER = 3;
	public static final short GAME_LEVEL_1 = 4;
	public static final short GAME_LEVEL_2 = 5;
	public static final short GAME_LEVEL_3 = 6;
	public static final short GAME_FINISH = 7;

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
		listaDeGameCanvas.add(new GameWin());
		listaDeGameCanvas.add(new GameOver());
		listaDeGameCanvas.add(new GameLevel1(1));
		listaDeGameCanvas.add(new GameLevel2(1));
		listaDeGameCanvas.add(new GameLevel3(1));
		listaDeGameCanvas.add(new GameFinish());

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

		 //dbg.setColor(Color.black);
		 //dbg.drawString("FPS: " + Fps, 20, 20);
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

	public static void trocaFase(int INDEX) {

		if (INDEX == GAME_LEVEL_1) {
			GamePanel.isntance.listaDeGameCanvas.remove(GamePanel.GAME_LEVEL_1);
			GameLevel1 tmp = new GameLevel1(GamePanel.nivelDificuldade);
			GamePanel.isntance.listaDeGameCanvas.add(GamePanel.GAME_LEVEL_1,
					tmp);
			GamePanel.isntance.gameCanvasAtual = GamePanel.isntance.listaDeGameCanvas
					.get(GamePanel.GAME_LEVEL_1);
			return;
		
		} else if (INDEX == GAME_LEVEL_2) {
			GamePanel.isntance.listaDeGameCanvas.remove(GamePanel.GAME_LEVEL_2);
			GameLevel2 tmp = new GameLevel2(GamePanel.nivelDificuldade);
			GamePanel.isntance.listaDeGameCanvas.add(GamePanel.GAME_LEVEL_2,
					tmp);
			GamePanel.isntance.gameCanvasAtual = GamePanel.isntance.listaDeGameCanvas
					.get(GamePanel.GAME_LEVEL_2);
			return;
			
		} else if (INDEX == GAME_LEVEL_3) {
			GamePanel.isntance.listaDeGameCanvas.remove(GamePanel.GAME_LEVEL_3);
			GameLevel3 tmp = new GameLevel3(GamePanel.nivelDificuldade);
			GamePanel.isntance.listaDeGameCanvas.add(GamePanel.GAME_LEVEL_3,
					tmp);
			GamePanel.isntance.gameCanvasAtual = GamePanel.isntance.listaDeGameCanvas
					.get(GamePanel.GAME_LEVEL_3);
			return;
			
		}

		GamePanel.isntance.gameCanvasAtual = GamePanel.isntance.listaDeGameCanvas
				.get(INDEX);
	}

	public static void trocaFase(int INDEX, int fase) {

		if (fase == 1) {
			GamePanel.isntance.listaDeGameCanvas.remove(GamePanel.GAME_LEVEL_1);
			GameLevel1 tmp = new GameLevel1(GamePanel.nivelDificuldade);
			GamePanel.isntance.listaDeGameCanvas.add(GamePanel.GAME_LEVEL_1,
					tmp);
			GamePanel.isntance.gameCanvasAtual = GamePanel.isntance.listaDeGameCanvas
					.get(GamePanel.GAME_LEVEL_1);
		
		} else if (fase == 2) {
			GamePanel.isntance.listaDeGameCanvas.remove(GamePanel.GAME_LEVEL_2);
			GameLevel2 tmp = new GameLevel2(GamePanel.nivelDificuldade);
			GamePanel.isntance.listaDeGameCanvas.add(GamePanel.GAME_LEVEL_2,
					tmp);
			GamePanel.isntance.gameCanvasAtual = GamePanel.isntance.listaDeGameCanvas
					.get(GamePanel.GAME_LEVEL_2);
		
		} else if (fase == 3) {
			GamePanel.isntance.listaDeGameCanvas.remove(GamePanel.GAME_LEVEL_3);
			GameLevel3 tmp = new GameLevel3(GamePanel.nivelDificuldade);
			GamePanel.isntance.listaDeGameCanvas.add(GamePanel.GAME_LEVEL_3,
					tmp);
			GamePanel.isntance.gameCanvasAtual = GamePanel.isntance.listaDeGameCanvas
					.get(GamePanel.GAME_LEVEL_3);
		}

	}

}
