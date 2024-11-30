package pieces;

/**
 * Represents a king chess piece.
 * Implements movement and behavior specific to kings.
 */
public class King extends ChessPiece {

    /**
     * Constructs a new King.
     *
     * @param x       The initial x-coordinate (column) of the king.
     * @param y       The initial y-coordinate (row) of the king.
     * @param isWhite {@code true} if the king belongs to the white player, {@code false} otherwise.
     */
    public King(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
    }

    /**
     * Checks if the king can make a valid move to the specified position.
     * Kings move one square in any direction but cannot move into a square occupied by a friendly piece.
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

        // King can move one square in any direction
        if (dx <= 1 && dy <= 1) {
            // Ensure the destination is either empty or occupied by an opponent piece
            return board[x][y] == null || board[x][y].isWhite != this.isWhite;
        }

        // Invalid move for a king
        return false;
    }

    /**
     * Returns the character representation of the king.
     *
     * @return A Unicode character representing the king ('♔' for white, '♚' for black).
     */
    @Override
    public char getPieceChar() {
        return isWhite ? '♔' : '♚';
    }
}
