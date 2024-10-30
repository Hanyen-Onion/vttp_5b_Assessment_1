package vttp.batch5.sdf.task02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;

public class TicTacToe {

    private String tttFile;

    //board
    private char[][] board = null;

    //initialise
    private int width = 0;
    private int offsetX = 0;
    private int offsetY = 0;
    
    private int round = 0;
    
    //constructors
    public TicTacToe(String ttt) {
        tttFile = ttt;
    }
    
    //3x3 board
    public TicTacToe(char[][] tttB ) {
        board = tttB;
        width = tttB.length;
    }

    public void loadBoard() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(tttFile));
        String line = "";
        int y = offsetY;
            
        while ((line = br.readLine()) != null) {
            line = line.replaceAll(".", ",.").trim();
            char[] tile = line.toCharArray();
            for (int x = 0; x < tile.length; x++) {
                board[y][x + offsetX] = tile[x];
                y++;
            }
        }
    }

    public TicTacToe nextMove() {
        //check if space occupied.
        for (int r = 0; r < width; r++) {
            for (int c = 0; c < width; c++) {
                if(board[r][c] == GamePiece.EMPTY_T) {
                    evaluateBoard();
                    if (evaluateBoard()==1) {
                        System.out.printf("y=%d, x=%d, utility=1\n", r,c);
                        //play move
                        //setPieceAt(GamePiece.X, r, c);  
                    } else if (evaluateBoard()==0) {
                        System.out.printf("y=%d, x=%d, utility=0\n", r,c);
                    } else System.out.printf("y=%d, x=%d, utility=-1\n", r,c);
                }         
            }
        }
        return nextMove();
    }

    public int evaluateBoard() {
        //check for row win
        int sumX = 0;
        int sumO = 0;
        int sumEmp = 0;
        for (int r = 0; r < width; r++) {
            for (int c = 0; c < width; c++) {
                if (board[r][c] == GamePiece.X) 
                    sumX ++;
                if (board[r][c] == GamePiece.O) 
                    sumO++;
            }
            if (sumX == 3) 
                return 1; 
            else if (sumO == 2 && sumEmp == 1) 
                return -1;
            sumO = 0;
            sumX = 0;
        }

        //check for col win
        for (int c = 0; c < width; c++) {
            for (int r = 0; r < width; r++) {
                if (board[r][c] == GamePiece.X) 
                    sumX ++;
                if (board[r][c] == GamePiece.O) 
                    sumO++;
            }
            if (sumX == 3) 
                return 1; 
            else if (sumO == 2 && sumEmp == 1) 
                return -1;
            sumO = 0;
            sumX = 0;
        }

        //check for L>R diagonal win
        for (int c = 0; c < width; c++) {
            if (board[c][c] == GamePiece.X) 
                sumX ++;
            if (board[c][c] == GamePiece.O) 
                sumO++;
        
            if (sumX == 3) 
                return 1; 
            else if (sumO == 2 && sumEmp == 1) 
                return -1;
            sumO = 0;
            sumX = 0;
        }

        //check for R>L diagonal win
        for (int c = 0; c < width; c++) {
            if (board[c][c-width-1] == GamePiece.X) 
                sumX ++;
            if (board[c][c-width-1] == GamePiece.O) 
                sumO++;
        
            if (sumX == 3) 
                return 1; 
            else if (sumO == 2 && sumEmp == 1) 
                return -1;
            sumO = 0;
            sumX = 0;
        }
        return 0;
    }

    public void printBoard() {
        System.out.printf("Board: %d\n", round);
        for (int i = 0; i < width; i++) {
            System.out.printf("%s", new String(board[i]));
        }
        System.out.println("\n" + "-------------------------------");

    }

    //getter setter
    public int getWidth() {    return width;}
    public void setWidth(int width) { this.width = width;}
        
    public int getRound() {    return round;}
    public void setRound(int round) {    this.round = round;}
        
    private char[][] initialiseBoard(int width, int height) {
        char[][] board = new char[width][width];
        return board;
    }

    public void setPieceAt(char x,int row, int col) {
        this.board[row][col] = x;
    }
}
