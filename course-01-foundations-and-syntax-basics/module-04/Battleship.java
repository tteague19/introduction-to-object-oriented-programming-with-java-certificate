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
		int[][] player1ShipLocations = getShipCoords(1, 5, 5);
		printLocationBoard(player1ShipLocations);
		printBoardSeparation(100);

		int[][] player2ShipLocations = getShipCoords(2, 5, 5);
		printLocationBoard(player1ShipLocations);
		printBoardSeparation(100);
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

	private static void printLocationBoard(int[][] shipLocations) {
		System.out.println("Player board goes here");
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
