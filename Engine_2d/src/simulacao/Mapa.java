package simulacao;

import java.awt.Color;
import java.awt.Graphics2D;

import engine.GamePanel;

public class Mapa {

	public static final int LARGURA = 300,ALTURA = 300;
	
	public static int[][] matrix = new int[LARGURA][ALTURA];
	
	public static final int ALTURA_DO_TILE = GamePanel.GAME_HEIGHT/ALTURA,
			LARGURA_DO_TILE = GamePanel.GAME_WIDTH/LARGURA;
	
	
	
	public Mapa() {
		
		
	}
	
	public void draw(Graphics2D dbg){
		
		int i,j;
		Color colorTmp = dbg.getColor();
		
		dbg.setColor(Color.blue);
		
		for (i  = 0; i < ALTURA; i++) {
			
			for (j = 0;  j < LARGURA; j++) {
				
				if(matrix[i][j]==1)
				{
					
					dbg.fillRect(i*LARGURA_DO_TILE, j*ALTURA_DO_TILE, LARGURA_DO_TILE,ALTURA_DO_TILE);
					
				}
				
			}
			
		}
		
		dbg.setColor(colorTmp);
		
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
