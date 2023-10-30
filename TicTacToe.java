package Baitap;

public class TicTacToe {
	private static final char EMPTY = ' ';
	private char[][] board;

	public TicTacToe(int size) {
		board = new char[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				board[i][j] = EMPTY;
			}
		}
	}

	public boolean checkRows() {
		for (int i = 0; i < board.length; i++) {
			char first = board[i][0];
			if (first == EMPTY)
				continue;

			for (int j = 1; j < board[i].length; j++) {
				if (board[i][j] != first) {
					break;
				}
				if (j == board[i].length - 1) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean checkColumns() {
		for (int i = 0; i < board[0].length; i++) {
			char first = board[0][i];
			if (first == EMPTY)
				continue;

			for (int j = 1; j < board.length; j++) {
				if (board[j][i] != first) {
					break;
				}
				if (j == board.length - 1) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean checkDiagonals() {
		int size = board.length;
		char topLeft = board[0][0];
		char bottomLeft = board[size - 1][0];

		if (topLeft != EMPTY) {
			int i;
			for (i = 1; i < size; i++) {
				if (board[i][i] != topLeft) {
					break;
				}
			}
			if (i == size) {
				return true;
			}
		}

		if (bottomLeft != EMPTY) {
			int i;
			for (i = 1; i < size; i++) {
				if (board[size - i - 1][i] != bottomLeft) {
					break;
				}
			}
			if (i == size) {
				return true;
			}
		}

		return false;
	}

	public void makeMove(int row, int col, char player) {
		if (board[row][col] == EMPTY) {
			board[row][col] = player;
		} else {
			System.out.println("Cell is already occupied");
		}
	}

	public static void main(String[] args) {
		TicTacToe game = new TicTacToe(3);

		game.makeMove(0, 0, 'X');
		game.makeMove(0, 1, 'X');
		game.makeMove(0, 2, 'X');

		game.makeMove(1, 0, 'O');
		game.makeMove(2, 0, 'O');

		game.makeMove(1, 1, 'X');
		game.makeMove(2, 2, 'X');

		System.out.println("checkRows: " + game.checkRows());
		System.out.println("checkColumns: " + game.checkColumns());
		System.out.println("checkDiagonals: " + game.checkDiagonals());
	}
}

