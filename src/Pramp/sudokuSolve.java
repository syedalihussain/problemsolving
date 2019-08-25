package Pramp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class sudokuSolve {


	ArrayList<HashSet<Integer>> boxSets;
	ArrayList<HashSet<Integer>> colSets;
	ArrayList<HashSet<Integer>> rowSets;
	public void solveSudoku(char[][] board) {
		// HashSet<Integer>[] boxSets = new HashSet[9];
		// HashSet<Integer>[] colSets = new HashSet[9];
		// HashSet<Integer>[] rowSets = new HashSet[9];
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
		this.boxSets = boxSets;
		this.colSets = colSets;
		this.rowSets = rowSets;
		solveSudoku(min_i, min_j, board);
		// HashSet<Integer> set = boxSets.get(7);
		// for (Integer i : set) {
		//     System.out.print(i + ", ");
		// }
		// System.out.println("i: " + min_i + ", j: " + min_j);
	}
	public void solveSudoku(int i, int j, char[][] board) {
		HashSet<Integer> rowSet = rowSets.get(i);
		HashSet<Integer> colSet = colSets.get(j);
		HashSet<Integer> boxSet = boxSets.get(i/3*3+j/3);
		for (int i = 1; i < 9; i++) {
			if (!colSet.contains(i) && !rowSet.contains(i) && !boxSet.contains(i)) {
				colSet.add(i); rowSet.add(i); boxSet.add(i);
				if (solveSudokuFwd(i, j+1, board) && solveSudokuBwd(i, j-1, board)) {
					return;
				}
				colSet.remove(i); rowSet.remove(i); boxSet.remove(i);
			}
		}
		if ((i == 0 && j == -1) || (i == 8 && j == 9)) {
			return true;
		} else if (j == -1) {
			return solveSudoku(i-1, 8, board);
		} else if (j == 9) {
			return
		}
	}
	public static void main(String[] args) {
		System.out.println((char) 49);
		System.out.println((char) 57);
		List<Character> list = new ArrayList<>();
		System.out.println(list.size());
	}
}
