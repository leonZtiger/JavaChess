package main;

import pieces.Bishop;
import pieces.ChessPiece;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Queen;
import pieces.Rook;

/**
 * Represents a chessboard and handles initialization and rendering.
 */
public class ChessBoard {

    /** A 2D array representing the board with chess pieces. */
    private ChessPiece[][] pieces;

    /** The size of the chessboard (8x8). */
    public static final int boardSize = 8;

    /**
     * Constructor for the ChessBoard class.
     * Initializes the chessboard with the standard set of pieces.
     */
    public ChessBoard() {
        pieces = getSetOfPieces();
    }

    /**
     * Initializes and returns the chessboard with a standard set of pieces.
     *
     * @return A 2D array representing the chessboard with initialized pieces.
     */
    private ChessPiece[][] getSetOfPieces() {
        ChessPiece[][] board = new ChessPiece[boardSize][boardSize];

        // Initialize pawns
        for (int i = 0; i < boardSize; i++) {
            board[i][1] = new Pawn(i, 1, true);  // White pawns
            board[i][6] = new Pawn(i, 6, false); // Black pawns
        }

        // Initialize white back row
        board[0][0] = new Rook(0, 0, true);
        board[7][0] = new Rook(7, 0, true);
        board[2][0] = new Bishop(2, 0, true);
        board[5][0] = new Bishop(5, 0, true);
        board[1][0] = new Knight(1, 0, true);
        board[6][0] = new Knight(6, 0, true);
        board[4][0] = new King(4, 0, true);
        board[3][0] = new Queen(3, 0, true);

        // Initialize black back row
        board[0][7] = new Rook(0, 7, false);
        board[7][7] = new Rook(7, 7, false);
        board[2][7] = new Bishop(2, 7, false);
        board[5][7] = new Bishop(5, 7, false);
        board[1][7] = new Knight(1, 7, false);
        board[6][7] = new Knight(6, 7, false);
        board[4][7] = new King(4, 7, false);
        board[3][7] = new Queen(3, 7, false);

        return board;
    }

    /**
     * Prints the chessboard to the console.
     * Displays pieces and empty squares in a visually understandable format.
     */
    public void print() {
        System.out.flush();
        System.out.println("  1 2 3 4 5 6 7 8");

        for (int i = 0; i < boardSize; i++) {
            System.out.print((char) (i + 'a') + " "); // Row labels ('a' to 'h')

            for (int j = 0; j < boardSize; j++) {
                if (pieces[i][j] != null) {
                    // Print piece character
                    System.out.print(pieces[i][j].getPieceChar() + " ");
                } else {
                    // Print empty square (checkerboard pattern)
                    System.out.print((i + (j % 2)) % 2 == 0 ? "□ " : "■ ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Retrieves the current state of the chessboard.
     *
     * @return A 2D array of {@link ChessPiece} objects representing the chessboard.
     */
    public ChessPiece[][] getPieces() {
        return pieces;
    }
}
