/**
 * Class to represent Box Shogi board
 */
public class Board {

    Piece[][] board;

    final int BOARD_SIZE = 5;

    public Board()
    {
        board=new Piece[BOARD_SIZE][BOARD_SIZE];
    }

    /* Print board */
    public String toString() {
        String[][] pieces = new String[BOARD_SIZE][BOARD_SIZE];
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                Piece curr = (Piece) board[col][row];
                pieces[col][row] = this.isOccupied(col, row) ? board[col][row].toString() : "";
            }
        }
        return stringifyBoard(pieces);
    }

    public boolean isOccupied(int col, int row) {
        return board[col][row] != null;
    }

    private String stringifyBoard(String[][] board) {
        String str = "";

        for (int row = board.length - 1; row >= 0; row--) {

            str += Integer.toString(row + 1) + " |";
            for (int col = 0; col < board[row].length; col++) {
                str += stringifySquare(board[col][row]);
            }
            str += System.getProperty("line.separator");
        }

        str += "    a  b  c  d  e" + System.getProperty("line.separator");

        return str;
    }

    private String stringifySquare(String sq) {
        switch (sq.length()) {
            case 0:
                return "__|";
            case 1:
                return " " + sq + "|";
            case 2:
                return sq + "|";
        }

        throw new IllegalArgumentException("Board must be an array of strings like \"\", \"P\", or \"+P\"");
    }
    public boolean isOnMap(int x_board,int y_board)
    {
        return x_board >= 0 && y_board >= 0 && x_board < BOARD_SIZE && y_board < BOARD_SIZE;
    }
    public Piece getPiece(int x ,int y)
    {
        return this.board[x][y];
    }
    public void setPiece(Position p , Piece place)
    {
        this.board[p.getX()][p.getY()]=place; //y starts from 1 not 0
    }
    public void removePiece(Position p)
    {
        this.board[p.getX()][p.getY()]=null;
    }
}

