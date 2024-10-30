package vttp.batch5.sdf.task02;

public class GamePiece {

    public static final char X = 'X';    //player
    public static final char O ='O';   //computer
    public static final char EMPTY_T = ',';
    
    private final char PIECE;
    
    //set GamePiece. to any of the obj
    GamePiece(char initPiece) {
        this.PIECE = initPiece;
    }
    
    //check for presence
    public boolean isPlaced() {
        return this.PIECE != EMPTY_T;
    }

    //retrieve value of PIECE
    public char getPiece() {
        return this.PIECE;
    }

    @Override
    public String toString() {
        return String.valueOf(PIECE);
    }
    
}
