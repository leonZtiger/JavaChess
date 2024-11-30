package main;

import pieces.ChessPiece;
import pieces.King;

/**
 * Represents a chess game, managing the game state, turns, and moves.
 */
public class ChessGame {

    /** The chessboard containing the current state of the game. */
    private ChessBoard board;

    /** Indicates whether it's white's turn to play. */
    private boolean whiteTurn = true;

    /**
     * Constructs a new ChessGame with a freshly initialized chessboard.
     */
    public ChessGame() {
        board = new ChessBoard();
    }

    /**
     * Renders the current state of the chessboard to the console.
     */
    public void render() {
        board.print();
    }

    /**
     * Attempts to move a piece from one position to another on the chessboard.
     *
     * @param x    The starting x-coordinate (column) of the piece.
     * @param y    The starting y-coordinate (row) of the piece.
     * @param toX  The target x-coordinate (column) for the move.
     * @param toY  The target y-coordinate (row) for the move.
     * @return {@code true} if the move is successful, {@code false} otherwise.
     */
    public boolean movePiece(int x, int y, int toX, int toY) {
        ChessPiece[][] pieces = board.getPieces();

        // Validate the piece exists and belongs to the current player
        if (pieces[x][y] != null && pieces[x][y].isWhite() == whiteTurn) {
            // Attempt to make the move
            if (pieces[x][y].makeMove(toX, toY, pieces)) {
                whiteTurn = !whiteTurn; // Switch turns if move is successful
                return true;
            }
        }
        return false; // Move failed
    }

    /**
     * Checks if the game is finished.
     * The game ends when one of the kings is no longer on the board.
     *
     * @return {@code true} if the game is finished, {@code false} otherwise.
     */
    public boolean isFinished() {
        boolean hasWhiteKingLeft = false;
        boolean hasBlackKingLeft = false;

        ChessPiece[][] pieces = board.getPieces();

        // Search for both kings on the board
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces[i].length; j++) {
                ChessPiece piece = pieces[i][j];
                if (piece != null && piece instanceof King) {
                    if (piece.isWhite()) {
                        hasWhiteKingLeft = true;
                    } else {
                        hasBlackKingLeft = true;
                    }
                }
            }
        }

        // The game is finished if either king is missing
        return !(hasBlackKingLeft && hasWhiteKingLeft);
    }
}
