package arraysandhashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {
    //time - O(n^2), space - O(n)
    public boolean isValidSudokuBruteForce(char[][] board) {
        //go through rows
        int size = board.length;
        for (int i = 0; i < size; i++) {
            char[] row = board[i];
            Set<Character> seenNums = new HashSet<>();
            for (int j = 0; j < size; j++) {
                char num = row[j];
                if (num != '.') {
                    if (seenNums.contains(num)) {
                        return false;
                    }
                    seenNums.add(num);
                }
            }
        }

        //go through cols
        for (int i = 0; i < size; i++) {
            Set<Character> seenNums = new HashSet<>();
            for (int j = 0; j < size; j++) {
                char num = board[j][i];
                if (num != '.') {
                    if (seenNums.contains(num)) {
                        return false;
                    }
                    seenNums.add(num);
                }
            }
        }

        //go through boxes
        int sizeOfBox = (int) Math.sqrt(size);
        for (int i = 0; i <= size - sizeOfBox; i += 3) {
            for (int k = 0; k <= size - sizeOfBox; k += 3) {
                Set<Character> seenNums = new HashSet<>();
                for (int j = i; j < i + sizeOfBox; j++) {
                    for (int l = k; l < k + sizeOfBox; l++) {
                        char num = board[j][l];
                        if (num != '.') {
                            if (seenNums.contains(num)) {
                                return false;
                            }
                            seenNums.add(num);
                        }
                    }
                }
            }
        }

        return true;
    }

    //space - O(n2), worse than the one above in terms of space
    public boolean isValidSudokuOnePass(char[][] board) {
        int size = board.length;
        int boxSize = (int) Math.sqrt(size);
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> boxes = new HashMap<>();

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                char num = board[row][col];
                if (num != '.') {
                    if (rows.computeIfAbsent(row, n -> new HashSet<>()).contains(num)) {
                        return false;
                    }
                    if (cols.computeIfAbsent(col, n -> new HashSet<>()).contains(num)) {
                        return false;
                    }
                    //neetcode uses a string of "row,col", instead i calculate an index,
                    //going through rows left to right, starting at zero
                    int idxOfBox = (row / boxSize) * boxSize + col / boxSize;
                    if (boxes.computeIfAbsent(idxOfBox, n -> new HashSet<>()).contains(num)) {
                        return false;
                    }
                    rows.get(row).add(num);
                    cols.get(col).add(num);
                    boxes.get(idxOfBox).add(num);
                }
            }
        }
        return true;
    }

    //time - O(n^2), space - O(n), super fast due to not hashing anything
    public boolean isValidSudokuBitMaskOnePass(char[][] board) {
        int size = board.length;
        int boxSize = (int) Math.sqrt(size);
        int[] rows = new int[size];
        int[] cols = new int[size];
        int[] boxes = new int[size];

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                char num = board[row][col];
                if (num != '.') {
                    int index = 1 << (num - '1');
                    int boxIndex = (row / boxSize) * boxSize + (col / boxSize);
                    if ((rows[row] & index) > 0 || (cols[col] & index) > 0 ||
                            (boxes[boxIndex] & index) > 0) {
                        return false;
                    }
                    rows[row] |= index;
                    cols[col] |= index;
                    boxes[boxIndex] |= index;
                }
            }
        }
        return true;
    }
}
