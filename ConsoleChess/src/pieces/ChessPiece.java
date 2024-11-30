package pieces;

/**
 * Abstract class representing a generic chess piece.
 * Provides common functionality for all chess pieces and enforces implementation of specific behavior.
 */
public abstract class ChessPiece {

    /** Indicates whether the piece belongs to the white player. */
    protected boolean isWhite;

    /** The current x-coordinate (column) of the piece on the board. */
    protected int x;

    /** The current y-coordinate (row) of the piece on the board. */
    protected int y;

    /**
     * Constructs a new chess piece.
     *
     * @param x       The initial x-coordinate (column) of the piece.
     * @param y       The initial y-coordinate (row) of the piece.
     * @param isWhite {@code true} if the piece belongs to the white player, {@code false} otherwise.
     */
    protected ChessPiece(int x, int y, boolean isWhite) {
        this.isWhite = isWhite;
        this.x = x;
        this.y = y;
    }

    /**
     * Checks if the piece belongs to the white player.
     *
     * @return {@code true} if the piece is white, {@code false} if it is black.
     */
    public boolean isWhite() {
        return isWhite;
    }

    /**
     * Attempts to move the piece to a new position on the board.
     * If the move is valid, updates the piece's position and modifies the board state.
     *
     * @param x     The target x-coordinate (column) for the move.
     * @param y     The target y-coordinate (row) for the move.
     * @param board The current state of the chessboard.
     * @return {@code true} if the move is successful, {@code false} otherwise.
     */
    public boolean makeMove(int x, int y, ChessPiece[][] board) {
        if (canMakeMove(x, y, board)) {
            // Update the board to reflect the move
            board[this.x][this.y] = null; // Clear the current position
            board[x][y] = this;          // Place the piece in the new position
            this.x = x;                 // Update the piece's coordinates
            this.y = y;
            return true;
        }
        return false; // Move is invalid
    }

    /**
     * Checks if the piece can make a valid move to the specified position.
     * Must be implemented by each specific type of chess piece according to its movement rules.
     *
     * @param x     The target x-coordinate (column) for the move.
     * @param y     The target y-coordinate (row) for the move.
     * @param board The current state of the chessboard.
     * @return {@code true} if the move is valid, {@code false} otherwise.
     */
    protected abstract boolean canMakeMove(int x, int y, ChessPiece[][] board);

    /**
     * Returns the character representation of the piece for display purposes.
     * Must be implemented by each specific type of chess piece.
     *
     * @return A character representing the piece (e.g., 'K' for King, 'Q' for Queen).
     */
    public abstract char getPieceChar();
}
