package pieces;

/**
 * Represents a pawn chess piece.
 * Implements movement and behavior specific to pawns.
 */
public class Pawn extends ChessPiece {

    /** Tracks whether the pawn is making its first move. */
    private boolean isFirstMove = true;

    /**
     * Constructs a new Pawn.
     *
     * @param x       The initial x-coordinate (column) of the pawn.
     * @param y       The initial y-coordinate (row) of the pawn.
     * @param isWhite {@code true} if the pawn belongs to the white player, {@code false} otherwise.
     */
    public Pawn(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
    }

    /**
     * Checks if the pawn can make a valid move to the specified position.
     * Pawns can move forward one square (or two on their first move) and capture diagonally.
     *
     * @param x     The target x-coordinate (column) for the move.
     * @param y     The target y-coordinate (row) for the move.
     * @param board The current state of the chessboard.
     * @return {@code true} if the move is valid, {@code false} otherwise.
     */
    @Override
    public boolean canMakeMove(int x, int y, ChessPiece[][] board) {
        // Determine the direction based on the pawn's color
        int direction = isWhite ? 1 : -1; // White pawns move up (-1), Black pawns move down (+1)

        // Check for forward moves
        if (this.x == x) {
            // Single-step forward move if the destination square is empty
            if (this.y + direction == y && board[x][y] == null) {
                isFirstMove = false;
                return true;
            }

            // Two-step forward move on the first move if both squares are empty
            if (isFirstMove && this.y + 2 * direction == y && board[x][y] == null && board[x][this.y + direction] == null) {
                isFirstMove = false;
                return true;
            }
        }

        // Check for diagonal captures
        if ((this.x == x + 1 || this.x == x - 1) && this.y + direction == y && board[x][y] != null
                && board[x][y].isWhite() != this.isWhite) {
            return true;
        }

        // Invalid move
        return false;
    }

    /**
     * Returns the character representation of the pawn.
     *
     * @return A Unicode character representing the pawn ('♟' for black, '♙' for white).
     */
    @Override
    public char getPieceChar() {
        return isWhite ? '♙' : '♟';
    }
}
