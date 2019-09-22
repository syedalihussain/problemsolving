package Pramp;

import java.util.*;

public class sudokuSolve {
	static ArrayList<HashSet<Integer>> boxSetsG;
	static ArrayList<HashSet<Integer>> colSetsG;
	static ArrayList<HashSet<Integer>> rowSetsG;
	public static void solveSudoku(char[][] board) {
		ArrayList<HashSet<Integer>> boxSets = new ArrayList<>();
		ArrayList<HashSet<Integer>> colSets = new ArrayList<>();
		ArrayList<HashSet<Integer>> rowSets = new ArrayList<>();
		// Fill the hashsets
		int min_i = 10, min_j = 10, min = 10;
		int rowOne, colOne;
		for (int i = 0; i < 9; i++) {
			HashSet<Integer> boxSet = new HashSet<>();
			HashSet<Integer> colSet = new HashSet<>();
			HashSet<Integer> rowSet = new HashSet<>();
			rowOne = (i/3)*3; colOne = (i%3)*3;
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					rowSet.add(board[i][j]-'0');
				}
				if (board[j][i] != '.') {
					colSet.add(board[j][i]-'0');
				}
				if (board[rowOne+j/3][colOne+j%3] != '.') {
					boxSet.add(board[rowOne+j/3][colOne+j%3]-'0');
				}
			}
			rowSets.add(rowSet);
			colSets.add(colSet);
			boxSets.add(boxSet);
		}
		//  Find the indices of the square with minimun possibilities
		int boxNum, boxSize, rowSize, colSize, new_min;
		for (int i = 0; i < 9; i++) {
			boxNum = -1;
			boxSize = -1;
			int boxOne = i/3*3;
			rowSize = 9-rowSets.get(i).size();
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					continue;
				}
				if (boxNum != (boxOne+j/3)) {
					boxNum = boxOne+j/3;
					boxSize = 9-boxSets.get(boxNum).size();
				}
				colSize = 9-colSets.get(j).size();
				new_min = Math.min(boxSize, Math.min(rowSize, colSize));
				if (new_min < min) {
					min = new_min;
					min_i = i;
					min_j = j;
				}
			}
		}
		boxSetsG = boxSets;
		colSetsG = colSets;
		rowSetsG = rowSets;
		solveSudokuFwd(0, 0, board);
	}
	public static void solveSudoku(int i, int j, char[][] board) {
		HashSet<Integer> rowSet = rowSetsG.get(i);
		HashSet<Integer> colSet = colSetsG.get(j);
		HashSet<Integer> boxSet = boxSetsG.get(i/3*3+j/3);
		for (int n = 1; n <= 9; n++) {
			if (!colSet.contains(n) && !rowSet.contains(n) && !boxSet.contains(n)) {
				colSet.add(n); rowSet.add(n); boxSet.add(n);
				board[i][j] = (char) (n + '0');
				if (solveSudokuFwd(i, j+1, board) && solveSudokuBwd(i, j-1, board)) {
					return;
				}
				colSet.remove(n); rowSet.remove(n); boxSet.remove(n);
			}
		}
	}
	public static boolean solveSudokuFwd(int i, int j, char[][] board) {
		if (i == 9) {
			return true;
		} else if (j == 9) {
			return solveSudokuFwd(i+1, 0, board);
		} else if (board[i][j] != '.') {
			return solveSudokuFwd(i, j+1, board);
		}
		HashSet<Integer> rowSet = rowSetsG.get(i);
		HashSet<Integer> colSet = colSetsG.get(j);
		HashSet<Integer> boxSet = boxSetsG.get(i/3*3+j/3);
		for (int n = 1; n <= 9; n++) {
			if (!rowSet.contains(n) && !colSet.contains(n) && !boxSet.contains(n)) {
				rowSet.add(n); colSet.add(n); boxSet.add(n);
				board[i][j] = (char) (n + '0');
				if (solveSudokuFwd(i, j+1, board)) {
					return true;
				}
				rowSet.remove(n); colSet.remove(n); boxSet.remove(n);
				board[i][j] = '.';
			}
		}
		return false;
	}
	public static boolean solveSudokuBwd(int i, int j, char[][] board) {
		if (i == -1) {
			return true;
		} else if (j == -1) {
			return solveSudokuBwd(i-1, 8, board);
		} else if (board[i][j] != '.') {
			return solveSudokuBwd(i, j-1, board);
		}
		HashSet<Integer> rowSet = rowSetsG.get(i);
		HashSet<Integer> colSet = colSetsG.get(j);
		HashSet<Integer> boxSet = boxSetsG.get(i/3*3+j/3);
		for (int n = 1; n <= 9; n++) {
			if (!rowSet.contains(n) && !colSet.contains(n) && !boxSet.contains(n)) {
				rowSet.add(n); colSet.add(n); boxSet.add(n);
				board[i][j] = (char) (n + '0');
				if (solveSudokuBwd(i, j-1, board)) {
					return true;
				}
				rowSet.remove(i); colSet.remove(i); boxSet.remove(i);
				board[i][j] = '.';
			}
		}
		return false;
	}
	public static void main(String[] args) {
		char[][] board = new char[][]	{
										{'5','3','.','.','7','.','.','.','.'},
										{'6','.','.','1','9','5','.','.','.'},
										{'.','9','8','.','.','.','.','6','.'},
										{'8','.','.','.','6','.','.','.','3'},
										{'4','.','.','8','.','3','.','.','1'},
										{'7','.','.','.','2','.','.','.','6'},
										{'.','6','.','.','.','.','2','8','.'},
										{'.','.','.','4','1','9','.','.','5'},
										{'.','.','.','.','8','.','.','7','9'}};
		solveSudoku(board);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(board[i][j] + ", ");
			}
			System.out.println();
		}
		HashMap<String, List<Integer>> cityMap = new HashMap<>();
	}
}
