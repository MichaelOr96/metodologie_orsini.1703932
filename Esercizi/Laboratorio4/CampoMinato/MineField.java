package CampoMinato;

import java.util.Arrays;
import java.util.Random;

public class MineField {
	//CAMPI
	private int[][] matrix;
	private int rows;
	private int cols;
	private int mines;
	private int cellsDiscovered;
	private Random rand;
	private String state = "in gioco";
	private int victory = 0;
	
	private static final int NOTDISC = -2;
	private static final int MINE = -1;
	
	private static final char NOTDISC_CHAR = '-';
	private static final char MINE_CHAR = '*';
	
	private enum Direction {
		TOPLEFT(-1,-1), 
		TOPRIGHT(-1,1), 
		TOP(-1,0), 
		BOTTOMLEFT(1,-1), 
		BOTTOMRIGHT(1,1), 
		BOTTOM(1,0), 
		LEFT(0,-1), 
		RIGHT(0,1);
		
		private int offX, offY;
		
		Direction(int offX, int offY) {
			this.offX = offX;
			this.offY = offY;
		}
		
		public int getOffX() { return offX; }
		public int getOffY() { return offY; }
	}
	
	//COSTRUTTORE
	public MineField(int N, int M, int m) {
		this.rows = N;
		this.cols = M;
		
		if(m > (rows*cols)*1/2)
		{
			System.out.println("Too much mines to place... Number changed")
			this.mines = (rows*cols)*1/2;
		}
		mines = m;
		
		matrix = new int[rows][cols];
		for(int[] row : matrix) {
			Arrays.fill(row, NOTDISC);			//Fills matrix cells with NOTDISC
		}
		
		cellsDiscovered = 0;
		
		rand = new Random();
		
		while(mines > 0) {
			int randRow = rand.nextInt(rows-1);
			int randCol = rand.nextInt(cols-1);
			
			if(!isMine(randRow, randCol) && inMatrix(randRow, randCol)) {
				matrix[randRow][randCol] = MINE;   //Randomly places mines in the matrix 
				mines--;
			}
			
		}
	}
	
	//METODI
	/**
	 * Checks if params are in matrix bonds
	 * @param r
	 * @param c
	 * @return
	 */
	private boolean inMatrix(int r, int c) {
		if(r > 0 && r < rows-1 && c > 0 && c < cols-1) { return true; }
		return false;
	}
	
	/**
	 * Checks if there's a mine in the given cell
	 */
	private boolean isMine(int r, int c) {
		if(inMatrix(r,c) && matrix[r][c] == MINE) { return true; }
		return false;
	}
	
	/**
	 * Puts mine in the given cell if params are inMatrix and !isMine
	 * @param r
	 * @param c
	 */
	private void putMine(int r, int c) {
		if(!isMine(r,c) && inMatrix(r,c)) {
			matrix[r][c] = MINE;
		}
	}
	
	/**
	 * Counts number of mines around r and c
	 * @param r
	 * @param c
	 * @return
	 */
	private int countMines(int r, int c) {
		int output = 0;
		
		for(Direction dir : Direction.values()) {
			int nearX = r+dir.getOffX();
			int nearY = c+dir.getOffY();
			if(isMine(nearX,nearY)) { output++; }
		}
		
		return output;
	}
	
	/**
	 * Discovers the cell in position r,c if is NOTDISC
	 * if is a mine returns -1, if is near mines returns the number of mines
	 * otherwise discovers all the cells around
	 * @param r
	 * @param c
	 * @return
	 */
	public void discoverCell(int r, int c) {
		if(isMine(r,c)) {
			state = "perso";
			return MINE;
		}
		
		else if(!isMine(r,c) && inMatrix(r,c) && matrix[r][c] == NOTDISC) {
			victory++;
			if(vicotry == (rows*cols) - m) { state = "vinto"; }
			
			if(countMines(r,c) != 0) {
				matrix[r][c] = countMines(r,c);
				cellsDiscovered ++;
				return matrix[r][c];
			}
			
			for(Direction dir : Direction.values()) {
				int nearX = x+dir.getOffX();
				int nearY = y+getOffY();
				if(inMatrix(nearX, nearY)) { discoverCell(nearX, nearY); }
			}
		}
	}
	
	public String toString() {
		String output="";
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(matrix[i][j] == NOTDISC) {output+=NOTDISC_CHAR;}
				else if(matrix[i][j] == MINE) {output+=MINE_CHAR;}
				else {output+=matrix[i][j];}
				
				output+=' ';
			}
			output+='\n';
		}
		
		return output;
	}
	
	public String win() { return state; }
}
