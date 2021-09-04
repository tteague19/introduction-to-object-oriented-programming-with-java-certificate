import java.util.Scanner;

public class Battleship {
    public static void main(String[] args) {
		// Sub-Task 1
		// Print out the message Welcome to Battleship!
		System.out.println("Welcome to Battleship!\n");

		// Prompt each user to enter coordinates for five ships of
		// length one. There must be five separate prompts for each
		// ship (use the example below as a guide). You can expect the
		// user input will be two ints separated by a space. The first
		// int represents the row number and the second int represents
		// the column number.
		//
		// If the user enters invalid integers, print
		// "Invalid coordinates. Choose different coordinates.""
		//
		// If the user enters a coordinate that they had already
		// entered, print "You already have a ship there. Choose
		// different coordinates.""
		//
		// After each player enters their fifth coordinate, a board
		// representing the player’s ship locations must be printed
		// to the console using the provided method. See step three on
		// how to construct these Locations Boards.
		//
		// 100 new lines must follow the printed board so that the
		// other player will not see the entered coordinates and board
		// of their opponent.

		// Sub-Task 3
		// Create two 5x5 grids in the form of 2D arrays using the
		// coordinates entered by the players. These Location Boards
		// store each player's ship locations and will be used to keep
		// track of the damage states of each player’s ships, as well
		// as any misses. The corresponding Location Board must be
		// printed to the console right after a player enters the
		// coordinates of their ships.
		// A ‘–’ character must represent an empty space.
		// An ‘@’ character must represent a ship that is not hit.
		// When the game begins, all ships will start fresh with no hits.
		//
		// An ‘X’ character will represent a space with a ship that
		// has been hit.
		//
		// An ‘O’ character will represent a space that was fired upon,
		// but since there is not ship at that location, the shot
		// was a miss.
		// Each player’s board must have five ships of length one.
		// Five of the 25 grid spaces will start with ships on them.
		int boardSize = 5;
		int numShips = 5;
		int[][] player1ShipLocations = getShipCoords(1, numShips, boardSize);
		char[][] player1LocationBoard = createLocationBoard(player1ShipLocations, boardSize);
		printBattleShip(player1LocationBoard);
		printBoardSeparation(100);

		int[][] player2ShipLocations = getShipCoords(2, numShips, boardSize);
		char[][] player2LocationBoard = createLocationBoard(player2ShipLocations, boardSize);
		printBattleShip(player2LocationBoard);
		printBoardSeparation(100);

		// Sub-Task 4
		// Additionally, you must generate two more 5x5 grids in the
		// form of 2D arrays. These Target History Boards will allow
		// each player to visually track their hits and misses. After
		// each hit or miss by the player, their Target History Board
		// must be printed to the console using the provided method.
		// On this board, an ‘X’ character must represent a hit by the
		// player, an ‘O’ character must represent a miss by the
		// player, and a ‘-’ character must represent a space that
		// has not been attacked.
		char[][] player1TargetHistoryBoard = createTargetHistoryBoard(boardSize);
		char[][] player2TargetHistoryBoard = createTargetHistoryBoard(boardSize);
    }

	private static int[][] getShipCoords(int playerNum, int numShips, int boardSize) {
		System.out.println("PLAYER "
							+ playerNum
							+ ", ENTER YOUR SHIPS' COORDINATES.");

		Scanner input = new Scanner(System.in);
		int numCoords = 2;
		int numValidCoords = 0;
		int[][] shipLocations = new int[numShips][numCoords];

		while (numValidCoords < numShips) {
			System.out.println("Enter ship "
								+ (numValidCoords + 1)
								+ " location:");

			int coordX = input.nextInt();
			int coordY = input.nextInt();

			if (!checkValidCoords(coordX, coordY, boardSize)) {
				String msg = "Invalid coordinates. Choose different coordinates.";
				System.out.println(msg);
				continue;
			}

			if (checkDuplicateCoords(shipLocations, numValidCoords, coordX, coordY)) {
				String msg = "You already have a ship there. Choose different coordinates.";
				System.out.println(msg);
				continue;
			}

			shipLocations[numValidCoords][0] = coordX;
			shipLocations[numValidCoords][1] = coordY;
			numValidCoords++;
		}

		return shipLocations;
	}

	private static boolean checkValidCoords(int coordX, int coordY, int boardSize) {

		boolean validCoords = true;

		if (coordX < 0 || coordX >= boardSize) {
			validCoords = false;
		}

		if (coordY < 0 || coordY >= boardSize) {
			validCoords = false;
		}

		return validCoords;
	}

	private static boolean checkDuplicateCoords(
		int[][] shipLocations,
		int numValidCoords,
		int coordX,
		int coordY
		) {
		boolean duplicatedCoords = false;

		// We only consider the entries in the array that have been
		// overwritten by the user. Otherwise, he or she would be
		// unable to enter (0, 0) as a coordinate.
		for (int arrIndex = 0; arrIndex <= numValidCoords; arrIndex++) {
			if (shipLocations[arrIndex][0] == coordX && shipLocations[arrIndex][1] == coordY) {
				duplicatedCoords = true;
				break;
			}
		}

		return duplicatedCoords;
	}

	private static void printBoardSeparation(int numLines) {
		for (int index = 0; index < numLines; index++) {
			System.out.println();
		}
	}

	private static char[][] createLocationBoard(int[][] shipLocations, int boardSize) {

		int numRows = boardSize;
		int numCols = numRows;
		char[][] locationBoard = new char[numRows][numCols];

		locationBoard = createBlankBoard(locationBoard, '-');
		locationBoard = addShipsToLocationBoard(locationBoard, shipLocations, '@');

		return locationBoard;
	}

	private static char[][] createTargetHistoryBoard(int boardSize) {

		int numRows = boardSize;
		int numCols = numRows;
		char[][] targetHistoryBoard = new char[numRows][numCols];

		return createBlankBoard(targetHistoryBoard, '-');
	}

	private static char[][] createBlankBoard(
		char[][] board,
		char emptyChar
		) {

		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				board[row][col] = emptyChar;
			}
		}

		return board;
	}

	private static char[][] addShipsToLocationBoard(
		char[][] locationBoard,
		int[][] shipLocations,
		char shipChar
		) {

		for (int shipIndex = 0; shipIndex < shipLocations.length; shipIndex++) {
			int shipCoordX = shipLocations[shipIndex][0];
			int shipCoordY = shipLocations[shipIndex][1];

			locationBoard[shipCoordX][shipCoordY] = shipChar;
		}

		return locationBoard;
	}

    // Use this method to print game boards to the console.
	private static void printBattleShip(char[][] player) {
		System.out.print("  ");
		for (int row = -1; row < 5; row++) {
			if (row > -1) {
				System.out.print(row + " ");
			}
			for (int column = 0; column < 5; column++) {
				if (row == -1) {
					System.out.print(column + " ");
				} else {
					System.out.print(player[row][column] + " ");
				}
			}
			System.out.println("");
		}
    }
}
