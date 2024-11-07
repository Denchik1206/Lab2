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
        int cnt_islant = 0;

        int[][] cnt_true_max_island = new int[matrix.length][2];
        for (int i = 0; i < matrix.length; i++) {
            int cnt_true_i = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == true)
                    cnt_true_i += 1;
            }
            cnt_true_max_island[i][0] = cnt_true_i;

            int max_island_in_i = 0;
            int lenn_island = 1;
            for (int j = 0; j < matrix[i].length - 1; j++) {
                if (matrix[i][j] == matrix[i][j + 1] && matrix[i][j] == true) {
                    lenn_island += 1;
                    if (j + 1 == matrix[i].length - 1) {
                        if (max_island_in_i == 0 || max_island_in_i < lenn_island)
                            max_island_in_i = lenn_island;
                        cnt_islant += 1;
                        lenn_island = 1;
                    }
                } else if (lenn_island != 1 && (matrix[i][j - 1] == true && matrix[i][j] == true)) {
                    if (max_island_in_i == 0 || max_island_in_i < lenn_island)
                        max_island_in_i = lenn_island;
                    cnt_islant += 1;
                    lenn_island = 1;
                }
            }
            cnt_true_max_island[i][1] = max_island_in_i;

            if (max_island_in_i > max_len_islant) {
                max_len_islant = max_island_in_i;
                max_island = matrix[i];
            }
        }

        for (int k = 0; k < matrix.length; k++) {
            for (int i = 0; i < cnt_true_max_island.length - 1; i++) {
                boolean[] swap;
                int[] swap1;
                if (cnt_true_max_island[i + 1][0] > cnt_true_max_island[i][0]) {
                    swap = matrix[i];
                    matrix[i] = matrix[i + 1];
                    matrix[i + 1] = swap;

                    swap1 = cnt_true_max_island[i];
                    cnt_true_max_island[i] = cnt_true_max_island[i + 1];
                    cnt_true_max_island[i + 1] = swap1;
                } else if (cnt_true_max_island[i + 1][0] == cnt_true_max_island[i][0]) {
                    if (cnt_true_max_island[i + 1][1] > cnt_true_max_island[i][1]) {
                        swap = matrix[i];
                        matrix[i] = matrix[i + 1];
                        matrix[i + 1] = swap;

                        swap1 = cnt_true_max_island[i];
                        cnt_true_max_island[i] = cnt_true_max_island[i + 1];
                        cnt_true_max_island[i + 1] = swap1;
                    }
                }
            }
        }

        for (int i = 0; i < max_island.length; i++)
            out.print(max_island[i] + " ");
        out.printf("\nДлина: %d\n\n", max_len_islant);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j])
                    out.print("+" + " ");
                else
                    out.print("-" + " ");
            }
            out.println();
        }
        out.printf("Число островков: %d\n", cnt_islant);

        boolean symmetry_flag = true;
        int cnt_replace = 0;
        for (int i = 1; i < (matrix.length / 2); i++) {
            for (int j = 0; j < i; j++) {
                if (matrix[i][j] != matrix[matrix.length - 1 - i][matrix[i].length - 1 - j]) {
                    symmetry_flag = false;
                    cnt_replace += 1;
                }
            }
        }
        if (symmetry_flag)
            out.println("YES");
        else
            out.printf("Симметричность: %s\nMin кол-во измениений: %d", "NO", cnt_replace);

    }
}