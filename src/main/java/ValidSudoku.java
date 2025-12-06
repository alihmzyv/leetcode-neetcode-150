import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
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

    //space - O(n2), worse than the one above
    public boolean isValidSudokuOnePass(char[][] board) {
        int size = board.length;
        Set[] rows = new Set[size];
        Set[] cols = new Set[size];
        Set[] boxes = new Set[size];

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                char num = board[row][col];
                if (rows[row].contains(num)) {
                    return false;
                }
                if (cols[col].contains(num)) {
                    return false;
                }
                //TODO: look into this and the other solution
            }
        }
        return false;
    }
}
