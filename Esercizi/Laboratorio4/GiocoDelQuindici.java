import java.util.Arrays;
import java.util.Random;

public class GiocoDelQuindici {
	//CAMPI
	private int[][] matrix;
	private Random rand;
	
	private static final int ROWS = 4;
	private static final int COLS = 4;
	private static final int EMPTY = -1;
	
	private enum Direction {
		UP(0,-1), DOWN(0,1), LEFT(-1,0), RIGHT(1,0);
		
		private int offX, offY;
		
		Direction(int offX, int offY) {
			this.offX = offX;
			this.offY = offY;
		}
		
		public int getOffX() { return offX; }
		public int getOffY() { return offY; }
	}
	
	//COSTRUTTORE
	public GiocoDelQuindici(){
		matrix = new int[ROWS][COLS]
				{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,EMPTY};
		
		shuffle();
	}
	
	//METODI
	/**
	 * Checks if params are in matrix bonds
	 * @param r
	 * @param c
	 * @return
	 */
	private boolean inMatrix(int r, int c) {
		if(r > 0 && r < ROWS-1 && c > 0 && c < COLS-1) { return true; }
		return false;
	}
	
	/**
	 * Checks if the cell is empty
	 * @param r
	 * @param c
	 * @return
	 */
	public boolean isEmpty(int r, int c) {
		if(inMatrix(r,c) && matrix[r][c] == EMPTY) { return true; }
		return false;
	}
	
	private void swapPosition(int i1, int j1, int i2, int j2) {
		int tmp = matrix[i1][j1];
		matrix[i1][j1] = matrix[i2][j2];
		matrix[i2][j2] = tmp;
	}
	
	/**
	 * Shuffles cells
	 */
	public void shuffle() {
		var rand = new Random();
		for(int i = 0; i<matrix.length; i++) {
			for(int j = 0; j<matrix.length; j++) {
				int i1 = rand.nextInt(matrix.length);
				int j1 = rand.nextInt(matrix.length);
				swapPosition(i,j,i1,j1);
			}
		}
	}
	
	
	/**
	 * Moves a piece in the given direction if the cell in that given direction is empty
	 * @param x
	 * @param y
	 * @param direction
	 */
	public boolean slide(int x, int y, Direction direction) {
		int newY = y+dir.getOffY(), newX = x+dir.getOffX();

        if(isEmpty(newX,newY))
        {
            swapPosition(y, x, newY, newX);
            return true;
        }
        return false;
	}
	
	/**
	 * Checks if win
	 * @return
	 */
	public boolean checkWin() {
		for(int i=0;i<matrix.length-1; i++)
            for(int j=0; j<matrix.length-1; j++)
                if((matrix[i][j] > matrix[i][j+1]) || (matrix[i][j] > matrix[i+1][j]))
                    return false;
        return true;
	}
	
	public void printTable()
    {
        for(int i=0; i<matrix.length; i++)
        {
            for(int j=0; j<matrix[i].length; j++)
            {
                String c = matrix[i][j] != EMPTY ? ""+matrix[i][j] : " ";
                c += c.length() > 1 ? "" : " ";
                System.out.print(" "+c+" |");
            }
            System.out.println();
        }
    }
}
