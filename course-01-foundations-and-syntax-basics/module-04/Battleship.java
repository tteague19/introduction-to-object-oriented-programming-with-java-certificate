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
		Scanner input = new Scanner(System.in);
		int[][] player1ShipLocations = getShipCoords(1, numShips, boardSize, input);
		char[][] player1LocationBoard = createLocationBoard(player1ShipLocations, boardSize);
		printBattleShip(player1LocationBoard);
		printBoardSeparation(100);

		int[][] player2ShipLocations = getShipCoords(2, numShips, boardSize, input);
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

		// Sub-Task 5
		// Prompt Player 1 to enter a coordinate to fire upon. You can
		// expect the user input will be two ints separated by a space.
		// If the user enters invalid integers, print
		// Invalid coordinates. Choose different coordinates.
		// If the user enters a coordinate that they had already
		// entered, print out the following
		// "You already fired on this spot. Choose different coordinates."
		// If the user enters a coordinate with no ship on it, print
		// out the following and print the updated Target History
		// Board, where [NUM] is replaced with the attacked player’s ID.
		// "PLAYER [NUM] MISSED!"
		// If the user enters a coordinate with a ship on it, print
		// out the following and print the updated Target History
		// Board, where [NUM A] is replaced with the attacking
		// player’s ID and [NUM B] is replaced with the attacked
		// player’s ID.
		// "PLAYER [NUM A] HIT PLAYER [NUM B]’s SHIP!"

		// Sub-Task 6
		// Player 2 will get a turn after each turn that Player 1
		// takes, which will function in the same way as Player 1’s
		// turns.

		// Sub-Task 7
		// When a ship is hit by a player, the Location board
		// (which tracks the damage states) of the corresponding
		// player’s ships must be updated. Misses should be updated
		// on the Location board as well.
		boolean gameOver = false;
		int turnNum = 1;
		int numCoords = 2;

		// A list of coordinates is more appropriate here, but we
		// have not covered that data structure in the course yet.
		// These arrays are large enough to allow the players to
		// make a guess for each position on the board, at which
		// point the game is guaranteed to finish.
		int numBoardPositions = boardSize * boardSize;
		int[][] player1Guesses = new int[numBoardPositions][numCoords];
		int[][] player2Guesses = new int[numBoardPositions][numCoords];

		do
		{

			player1Guesses = getGuess(player1Guesses, turnNum, boardSize, 1, input);
			int coordX = player1Guesses[turnNum-1][0];
			int coordY = player1Guesses[turnNum-1][1];
			char updateChar = evaluateGuess(
				coordX,
				coordY,
				1,
				player2LocationBoard
			);
			player1TargetHistoryBoard = updateBoards(
				player2LocationBoard,
				player1TargetHistoryBoard,
				coordX,
				coordY,
				updateChar
				);
			printBattleShip(player1TargetHistoryBoard);
			gameOver = checkForGameOver(player1TargetHistoryBoard, numShips);
			printEndOfTurnMessage(1, gameOver);

			if (gameOver) {
				break;
			}

			player2Guesses = getGuess(player2Guesses, turnNum, boardSize, 2, input);
			coordX = player2Guesses[turnNum-1][0];
			coordY = player2Guesses[turnNum-1][1];
			updateChar = evaluateGuess(
				coordX,
				coordY,
				2,
				player1LocationBoard
			);
			// This needs to update the location board, too.
			player2TargetHistoryBoard = updateBoards(
				player1LocationBoard,
				player2TargetHistoryBoard,
				coordX,
				coordY,
				updateChar
				);
			printBattleShip(player2TargetHistoryBoard);
			gameOver = checkForGameOver(player2TargetHistoryBoard, numShips);
			printEndOfTurnMessage(2, gameOver);

			if (gameOver) {
				break;
			}

			turnNum++;
		} while (!gameOver);

		System.out.println();
		System.out.println("Final boards:");
		System.out.println();
		printBattleShip(player1LocationBoard);
		System.out.println();
		printBattleShip(player2LocationBoard);

    }

	private static void printEndOfTurnMessage(int playerNum, boolean gameOver) {
		if (gameOver) {
			System.out.println("PLAYER "
								+ playerNum
								+ " WINS! YOU SUNK ALL OF "
								+ "YOUR OPPONENT'S SHIPS!"
								);
		} else {
			System.out.println();
		}
	}

	private static boolean checkForGameOver(
		char[][] targetHistoryBoard,
		int numShips
		) {

			int numRows = targetHistoryBoard.length;
			int numCols = targetHistoryBoard[0].length;
			char hitChar = 'X';
			char shipChar = '@';
			int numHits = 0;
			int remainingShips = 0;

			for (int row = 0; row < numRows; row++) {
				for (int col = 0; col < numCols; col++) {
					if (targetHistoryBoard[row][col] == hitChar) {
						numHits++;
					}
					if (targetHistoryBoard[row][col] == shipChar) {
						remainingShips++;
					}
				}
			}

			return (numHits == numShips) && (remainingShips == 0);
		}

	private static int[][] getShipCoords(
		int playerNum,
		int numShips,
		int boardSize,
		Scanner inputScanner
		) {
		System.out.println("PLAYER "
							+ playerNum
							+ ", ENTER YOUR SHIPS' COORDINATES.");

		int numCoords = 2;
		int numValidCoords = 0;
		int[][] shipLocations = new int[numShips][numCoords];

		while (numValidCoords < numShips) {

			System.out.println("Enter ship "
								+ (numValidCoords + 1)
								+ " location:");

			int coordX = inputScanner.nextInt();
			int coordY = inputScanner.nextInt();

			if (!checkValidCoords(coordX, coordY, boardSize)) {
				System.out.println("Invalid coordinates. "
									+ "Choose different coordinates."
									);
				continue;
			}

			if (checkDuplicateCoords(shipLocations, numValidCoords, coordX, coordY)) {
				System.out.println("You already have a ship there. "
									+ "Choose different coordinates."
									);
				continue;
			}

			shipLocations[numValidCoords][0] = coordX;
			shipLocations[numValidCoords][1] = coordY;
			numValidCoords++;
		}

		return shipLocations;
	}

	private static int[][] getGuess(
		int[][] playerGuesses,
		int turnNum,
		int boardSize,
		int playerNum,
		Scanner inputScanner
		) {

		boolean validGuess = false;
		while (!validGuess) {
			System.out.println("Player "
								+ playerNum
								+ ", enter hit row/column:"
								);
			int coordX = inputScanner.nextInt();
			int coordY = inputScanner.nextInt();

			if (!checkValidCoords(coordX, coordY, boardSize)) {
				System.out.println("Invalid coordinates."
									+ " Choose different coordinates."
									);
				continue;
			}

			if (checkDuplicateCoords(playerGuesses, turnNum, coordX, coordY)) {
				System.out.println("You already fired on this spot."
									+ " Choose different coordinates."
									);
				continue;
			}

			validGuess = true;
			playerGuesses[turnNum-1][0] = coordX;
			playerGuesses[turnNum-1][1] = coordY;
		}

		return playerGuesses;
	}

	public static char evaluateGuess(
		int coordX,
		int coordY,
		int attackerNum,
		char[][] locationBoard) {


		char hitChar = 'X';
		char missChar = 'O';
		char shipChar = '@';
		char updateChar;
		int defenderNum = (attackerNum == 1 ? 2 : 1);

		if (checkForHit(coordX, coordY, locationBoard, shipChar)) {
			updateChar = hitChar;
			System.out.println("PLAYER "
								+ attackerNum
								+ " HIT PLAYER "
								+ defenderNum
								+ "’s SHIP!"
								);
		} else {
			updateChar = missChar;
			System.out.println("PLAYER " + attackerNum + " MISSED!");
		}

		return updateChar;
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
		int[][] coordArray,
		int maxIndex,
		int coordX,
		int coordY
		) {
		boolean duplicatedCoords = false;

		// We only consider the entries in the array that have been
		// overwritten by the user. Otherwise, he or she would be
		// unable to enter (0, 0) as a coordinate.
		for (int arrIndex = 0; arrIndex <= maxIndex; arrIndex++) {
			if (coordArray[arrIndex][0] == coordX && coordArray[arrIndex][1] == coordY) {
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

	private static char[][] updateBoards(
		char[][] locationBoard,
		char[][] targetHistoryBoard,
		int coordX,
		int coordY,
		char updateChar
		) {
			locationBoard[coordX][coordY] = updateChar;
			targetHistoryBoard[coordX][coordY] = updateChar;
			return targetHistoryBoard;
		}

	private static boolean checkForHit(
		int coordX,
		int coordY,
		char[][] locationBoard,
		char shipChar
		) {
			return locationBoard[coordX][coordY] == shipChar;
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
