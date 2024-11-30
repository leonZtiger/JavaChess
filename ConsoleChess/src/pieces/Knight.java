package pieces;

/**
 * Represents a knight chess piece.
 * Implements movement and behavior specific to knights.
 */
public class Knight extends ChessPiece {

    /**
     * Constructs a new Knight.
     *
     * @param x       The initial x-coordinate (column) of the knight.
     * @param y       The initial y-coordinate (row) of the knight.
     * @param isWhite {@code true} if the knight belongs to the white player, {@code false} otherwise.
     */
    public Knight(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
    }

    /**
     * Checks if the knight can make a valid move to the specified position.
     * Knights move in an "L" shape: two squares in one direction and one square perpendicular.
     * Unlike other pieces, knights can jump over other pieces.
     *
     * @param x     The target x-coordinate (column) for the move.
     * @param y     The target y-coordinate (row) for the move.
     * @param board The current state of the chessboard.
     * @return {@code true} if the move is valid, {@code false} otherwise.
     */
    @Override
    protected boolean canMakeMove(int x, int y, ChessPiece[][] board) {
        // Calculate the change in position
        int dx = Math.abs(this.x - x);
        int dy = Math.abs(this.y - y);

        // Check for L-shape movement: (2, 1) or (1, 2)
        if ((dx == 2 && dy == 1) || (dx == 1 && dy == 2)) {
            // Ensure the destination is either empty or occupied by an opponent piece
            return board[x][y] == null || board[x][y].isWhite != this.isWhite;
        }

        // Invalid move for a knight
        return false;
    }

    /**
     * Returns the character representation of the knight.
     *
     * @return A Unicode character representing the knight ('♘' for white, '♞' for black).
     */
    @Override
    public char getPieceChar() {
        return isWhite ? '♘' : '♞';
    }
}
