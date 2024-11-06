import java.util.Scanner;
import java.io.PrintStream;

public class Main {
    public static Scanner in = new Scanner(System.in);
    public static PrintStream out = System.out;

    public static void main(String[] args) {
        int n = in.nextInt();
        int m = in.nextInt();
        boolean[][] matrix = new boolean[n][m];

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                matrix[i][j] = in.nextBoolean();

        boolean[] max_island = new boolean[0];
        int max_len_islant = 0;

        boolean[] swap;
        for (int i = 0; i < matrix.length; i++) {
            int cnt_true = 0;
            int first_cnt_true = -1;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == true)
                    cnt_true += 1;
            }

            int max_island_in_first = 0;
            int max_island_in_i = 0;
            int lenn_island = 1;
            for (int j = 0; j < matrix[i].length - 1; j++) {
                if (matrix[i][j] == matrix[i][j + 1])
                    lenn_island += 1;
                else if (lenn_island != 1 && ((matrix[i][j] != matrix[i][j + 1]) && (matrix[i][j - 1] == matrix[i][j]))) {
                    if (max_island_in_i == 0 || max_island_in_i < lenn_island)
                        max_island_in_i = lenn_island;
                    lenn_island = 1;
                }
            }
            if (max_island_in_i > max_len_islant) {
                max_len_islant = max_island_in_i;
                max_island = matrix[i];
            }
            if (max_island_in_first == 0)
                max_island_in_first = max_island_in_i;


            if (first_cnt_true == -1) {
                first_cnt_true = cnt_true;
                continue;
            } else if (cnt_true >= first_cnt_true) {
                if (cnt_true > first_cnt_true) {
                    swap = matrix[i];
                    for (int k = i; k > 0; k++)
                        matrix[k] = matrix[k - 1];
                    matrix[0] = swap;
                } else {
                    if (max_island_in_i > max_island_in_first) {
                        swap = matrix[i];
                        for (int k = i; k > 0; k++)
                            matrix[k] = matrix[k - 1];
                        matrix[0] = swap;
                    } else {
                        swap = matrix[i];
                        for (int k = i; k > 1; k++)
                            matrix[k] = matrix[k - 1];
                        matrix[1] = swap;
                    }

                }

            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++)
                out.print(matrix[i][j] + " ");
            out.println();
        }
        
        for (int i = 0; i < max_island.length; i++)
            out.print(max_island[i] + " ");
        out.println(max_len_islant);
    }
}