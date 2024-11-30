package main;

import java.awt.Point;
import java.io.IOException;
import java.util.Scanner;

/**
 * Main class for running the chess game.
 */
public class Main {
	
	// Field for the input scanner
	private static Scanner scanner;

	/**
	 * Entry point of the program.
	 *
	 * @param args Command-line arguments (not used in this program).
	 * @throws IOException if an I/O error occurs during execution.
	 */
	public static void main(String[] args) throws IOException {

		while (true) {
			System.out.println("Ready for a game? y/n");

			scanner = new Scanner(System.in);

			// Read the user's response
			String answer = scanner.next().toLowerCase().trim();

			// If the user doesn't agree exit
			if (!answer.equals("y")) {

				// Break out of loop
				break;

			}

			ChessGame game = new ChessGame();

			// Game loop runs until the game is finished
			while (!game.isFinished()) {
				// Render the current game state
				game.render();

				// Ask the user for the piece to move
				System.out.println("Please enter the piece to move.");
				Point coordinateFrom = askUserForCoordinates();

				// Ask the user for the destination
				System.out.println("Please enter the place to move.");
				Point coordinateTo = askUserForCoordinates();

				// Clear the console (optional visual improvement)
				clearConsole();

				// Attempt the move and provide feedback if it fails
				if (!game.movePiece(coordinateFrom.x, coordinateFrom.y, coordinateTo.x, coordinateTo.y)) {
					System.out.println("Could not make move, please enter a new move.");
				}
			}
		}
		scanner.close();

	}

	/**
	 * Prompts the user for chess coordinates and validates the input.
	 *
	 * @return A {@link Point} object representing the validated coordinates.
	 */
	private static Point askUserForCoordinates() {

		while (true) {
			System.out.print("Enter chess coordinates (e.g., e2, h5): ");
			String input = scanner.nextLine().trim().toLowerCase();

			// Validate input: must match chess coordinates (a-h followed by 1-8)
			if (input.matches("^[a-h][1-8]$")) {
				int x = input.toCharArray()[0] - 'a'; // Convert 'a-h' to 0-7
				int y = input.toCharArray()[1] - '1'; // Convert '1-8' to 0-7
				return new Point(x, y);
			} else {
				System.out.println("Invalid input. Please enter a valid chess coordinate.");
			}
		}
	}

	/**
	 * Clears the console by printing multiple blank lines. This is a simple way to
	 * visually refresh the console output.
	 */
	private static void clearConsole() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
	}
}
