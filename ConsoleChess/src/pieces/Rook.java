package pieces;

/**
 * Represents a rook chess piece.
 * Implements movement and behavior specific to rooks.
 */
public class Rook extends ChessPiece {

    /**
     * Constructs a new Rook.
     *
     * @param x       The initial x-coordinate (column) of the rook.
     * @param y       The initial y-coordinate (row) of the rook.
     * @param isWhite {@code true} if the rook belongs to the white player, {@code false} otherwise.
     */
    public Rook(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
    }

    /**
     * Checks if the rook can make a valid move to the specified position.
     * Rooks move any number of squares vertically or horizontally but cannot jump over other pieces.
     *
     * @param x     The target x-coordinate (column) for the move.
     * @param y     The target y-coordinate (row) for the move.
     * @param board The current state of the chessboard.
     * @return {@code true} if the move is valid, {@code false} otherwise.
     */
    @Override
    protected boolean canMakeMove(int x, int y, ChessPiece[][] board) {
        // Check for horizontal or vertical movement
        if (this.x == x || this.y == y) {
            // Determine movement direction
            int xDirection = Integer.compare(x, this.x); // +1, -1, or 0 for horizontal movement
            int yDirection = Integer.compare(y, this.y); // +1, -1, or 0 for vertical movement

            // Check for obstacles along the path
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

        // Invalid move for a rook
        return false;
    }

    /**
     * Returns the character representation of the rook.
     *
     * @return A Unicode character representing the rook ('♖' for white, '♜' for black).
     */
    @Override
    public char getPieceChar() {
        return isWhite ? '♖' : '♜';
    }
}
