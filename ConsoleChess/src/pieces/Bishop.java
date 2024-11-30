package pieces;

/**
 * Represents a bishop chess piece.
 * Implements movement and behavior specific to bishops.
 */
public class Bishop extends ChessPiece {

    /**
     * Constructs a new Bishop.
     *
     * @param x       The initial x-coordinate (column) of the bishop.
     * @param y       The initial y-coordinate (row) of the bishop.
     * @param isWhite {@code true} if the bishop belongs to the white player, {@code false} otherwise.
     */
    public Bishop(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
    }

    /**
     * Checks if the bishop can make a valid move to the specified position.
     * Bishops move any number of squares diagonally but cannot jump over other pieces.
     *
     * @param x     The target x-coordinate (column) for the move.
     * @param y     The target y-coordinate (row) for the move.
     * @param board The current state of the chessboard.
     * @return {@code true} if the move is valid, {@code false} otherwise.
     */
    @Override
    protected boolean canMakeMove(int x, int y, ChessPiece[][] board) {
        // Check for diagonal movement (absolute difference in x and y must be equal)
        if (Math.abs(this.x - x) == Math.abs(this.y - y)) {
            // Determine movement direction
            int xDirection = Integer.compare(x, this.x); // +1 or -1 for diagonal movement
            int yDirection = Integer.compare(y, this.y); // +1 or -1 for diagonal movement

            // Check for obstacles along the diagonal path
            int checkX = this.x + xDirection;
            int checkY = this.y + yDirection;
            while (checkX != x || checkY != y) {
                if (board[checkX][checkY] != null) {
                    return false; // Path is blocked
                }
                checkX += xDirection;
                checkY += yDirection;
            }

            // Ensure the destination is either empty or occupied by an opponent piece
            return board[x][y] == null || board[x][y].isWhite != this.isWhite;
        }

        // Invalid move for a bishop
        return false;
    }

    /**
     * Returns the character representation of the bishop.
     *
     * @return A Unicode character representing the bishop ('♗' for white, '♝' for black).
     */
    @Override
    public char getPieceChar() {
        return isWhite ? '♗' : '♝';
    }
}
