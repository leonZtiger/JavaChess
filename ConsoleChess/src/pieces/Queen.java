package pieces;

/**
 * Represents a queen chess piece.
 * Implements movement and behavior specific to queens.
 */
public class Queen extends ChessPiece {

    /**
     * Constructs a new Queen.
     *
     * @param x       The initial x-coordinate (column) of the queen.
     * @param y       The initial y-coordinate (row) of the queen.
     * @param isWhite {@code true} if the queen belongs to the white player, {@code false} otherwise.
     */
    public Queen(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
    }

    /**
     * Checks if the queen can make a valid move to the specified position.
     * Queens can move any number of squares in a straight line vertically, horizontally, or diagonally.
     * This is a combination of the rook's and bishop's movement rules.
     *
     * @param x     The target x-coordinate (column) for the move.
     * @param y     The target y-coordinate (row) for the move.
     * @param board The current state of the chessboard.
     * @return {@code true} if the move is valid, {@code false} otherwise.
     */
    @Override
    protected boolean canMakeMove(int x, int y, ChessPiece[][] board) {
        // Combine the movement rules of a rook and a bishop
        Rook rookMovement = new Rook(this.x, this.y, this.isWhite);
        Bishop bishopMovement = new Bishop(this.x, this.y, this.isWhite);

        // Valid if the move is valid for either a rook or a bishop
        return rookMovement.canMakeMove(x, y, board) || bishopMovement.canMakeMove(x, y, board);
    }

    /**
     * Returns the character representation of the queen.
     *
     * @return A Unicode character representing the queen ('♕' for white, '♛' for black).
     */
    @Override
    public char getPieceChar() {
        return isWhite ? '♕' : '♛';
    }
}
