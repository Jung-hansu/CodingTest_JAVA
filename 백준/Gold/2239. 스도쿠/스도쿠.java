import java.io.*;
import java.util.*;

public class Main {
    private static int[][] sudoku = new int[9][9];
    private static List<int[]> blanks = new ArrayList<>();
    private static boolean found = false;
    private static boolean isValid(int i, int j){
        BitSet check;

        //check row
        check = new BitSet();
        for (int k = 0; k < 9; k++)
            if (check.get(sudoku[i][k])) return false;
            else if (sudoku[i][k] != 0) check.set(sudoku[i][k]);
        //check col
        check = new BitSet();
        for (int k = 0; k < 9; k++)
            if (check.get(sudoku[k][j])) return false;
            else if (sudoku[k][j] != 0) check.set(sudoku[k][j]);
        //check box
        check = new BitSet();
        for (int I = (i/3)*3; I < (i/3)*3 + 3; I++)
            for (int J = (j/3)*3; J < (j/3)*3 + 3; J++)
                if (check.get(sudoku[I][J])) return false;
                else if (sudoku[I][J] != 0) check.set(sudoku[I][J]);

        return true;
    }
    private static void solveSudoku(int idx){
        if (idx == blanks.size()){
            found = true;
            return;
        }
        int[] p = blanks.get(idx);
        for (int i = 1; i <= 9; i++) {
            sudoku[p[0]][p[1]] = i;
            if (isValid(p[0], p[1])) {
                solveSudoku(idx + 1);
                if (found) return;
            }
            sudoku[p[0]][p[1]] = 0;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 9; i++){
            String s = br.readLine();
            for (int j = 0; j < 9; j++)
                if ((sudoku[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)))) == 0)
                    blanks.add(new int[]{i, j});
        }

        solveSudoku(0);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                sb.append(sudoku[i][j]);
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
