import java.util.Scanner;
import java.io.PrintStream;

public class Main {
    public static Scanner in = new Scanner(System.in);
    public static PrintStream out = System.out;

    public static void main(String[] args) {
        // Ввод размеров массива (n - кол-во строк, m - кол-во столбцов).
        int n = in.nextInt();
        int m = in.nextInt();
        // Создание двумерного массива.
        boolean[][] matrix = new boolean[n][m];

        // Заполнения двумерного массива matrix значениями true или false.
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                matrix[i][j] = in.nextBoolean();

        // Массив для хранения строки с max кол-вом послед. значений true.
        boolean[] max_island = new boolean[0];
        // Переменная для хранения длины максимальной послед. значений true.
        int max_len_islant = 0;
        // Переменная для хранения кол-ва островков (групп соседних true).
        int cnt_islant = 0;

        // Двумерный массив для хранения кол-ва true и длины max последовательности значений true
        // в каждой строке
        int[][] cnt_true_max_island = new int[matrix.length][2];
        // Цикл для прохода по каждой строке массива matrix.
        for (int i = 0; i < matrix.length; i++) {
            // Переменная для подсчета кол-ва true в строке.
            int cnt_true_i = 0;
            // Проходим по каждому значению строки и проверяем: является ли это значение true.
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == true)
                    cnt_true_i += 1;
            }
            // Добавление в массив cnt_true_max_island на место 0 кол-ва true в строке i.
            cnt_true_max_island[i][0] = cnt_true_i;

            // Переменные для хранения длины max островка в строке i и подсчета длины каждого островка в строке i
            int max_island_in_i = 0;
            int lenn_island = 1;
            // Цикл для прохода по значениям строки i.
            for (int j = 0; j < matrix[i].length - 1; j++) {
                // Проверка является ли текущее значение и следующее значение true.
                if (matrix[i][j] == matrix[i][j + 1] && matrix[i][j] == true) {
                    // Если является, то прибавляем 1 к длине островка.
                    lenn_island += 1;
                    // Также если мы дошли до конца строки i и последние значения равны true,
                    // то прибавляем к кол-ву островков 1 и объединичиваем значение длины островка.
                    if (j + 1 == matrix[i].length - 1) {
                        // Если длина островка больше длины текущего островка с max длиной, то обновляем его.
                        if (max_island_in_i < lenn_island)
                            max_island_in_i = lenn_island;
                        cnt_islant += 1;
                        lenn_island = 1;
                    }
                // Иначе если предыдущий элемент и нынешний элемент равны true, а следующий не равен true,
                // то прибавляем к кол-ву островков 1 и объединичиваем значение длины островка.
                } else if (lenn_island != 1 && (matrix[i][j - 1] == true && matrix[i][j] == true)) {
                    // Если длина островка больше длины текущего островка с max длиной, то обновляем его.
                    if (max_island_in_i < lenn_island)
                        max_island_in_i = lenn_island;
                    cnt_islant += 1;
                    lenn_island = 1;
                }
            }
            // Добавляем в массив cnt_true_max_island на место 1 длину самого большого островка в строке i.
            cnt_true_max_island[i][1] = max_island_in_i;

            // Если самый большой островок в i строке больше длины текущего островка из всех обработанных,
            // то обновляем его. Также запоминаем строку, в которой этот островок находится.
            if (max_island_in_i > max_len_islant) {
                max_len_islant = max_island_in_i;
                max_island = matrix[i];
            }
        }

        // Дополнительные массивы для сортировки.
        boolean[] swap1;
        int[] swap2;
        // Сортировка массива пузырьком.
        // Смотрим из массива cnt_true_max_island кол-во значений true и кол-во последовательных
        // значений true, и исходя из этих значений сортируем массив matrix. Также не забываем
        // менять строки и в массиве cnt_true_max_island.
        for (int k = 1; k < matrix.length; k++) {
            for (int i = 0; i < cnt_true_max_island.length - k; i++) {
                if (cnt_true_max_island[i + 1][0] > cnt_true_max_island[i][0]
                        || ((cnt_true_max_island[i + 1][0] == cnt_true_max_island[i][0])
                        && (cnt_true_max_island[i + 1][1] > cnt_true_max_island[i][1]))) {
                    swap1 = matrix[i];
                    matrix[i] = matrix[i + 1];
                    matrix[i + 1] = swap1;

                    swap2 = cnt_true_max_island[i];
                    cnt_true_max_island[i] = cnt_true_max_island[i + 1];
                    cnt_true_max_island[i + 1] = swap2;
                }
            }
        }

        // Выводим строку с максимальным количеством последовательных значений true,
        // а также длину этой последовательности
        if (max_len_islant != 0) {
            for (int i = 0; i < max_island.length; i++)
                out.print(max_island[i] + " ");
            out.printf("\nДлина: %d\n\n", max_len_islant);
        }
        else
            out.println("no such line\n");

        // Выводим элементы массива в виде матрицы, заменяя true на символ ’+’, а false на ’-’.
        // Дополнительно выводим число островков (групп соседних true).
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

        // Проверка на, то что матрица квадратная. (т.к в неквадратной матрице симметрия не возможна)
        if (n == m) {
            // Указатель о наличии симметрии относительно главной диагонали в массиве matrix.
            boolean symmetry_flag = true;
            // Переменная для подсчета min кол-ва изменений.
            int cnt_replace = 0;
            // Проходим по массиву рассматривая 1 и (n - 2) строки, 2 и (n - 2) строки и т.д.
            for (int i = 1; i < matrix.length; i++) {
                // Также проходимся по элементам строки до главной диагонали с двух сторон, и сравниваем
                // равняется ли 0 элемент в i строке (m - 1) элементу в (n - 1 - i), дальше
                // равняется ли 1 элемент в i строке (m - 2) элементу в (n - 1 - i) и так до главной диагонали.
                // Если находится два элемента не равных друг другу, то указатель симметрии становится faslse,
                // а к кол-ву изменений добавляется 1.
                for (int j = 0; j < i; j++) {
                    if (matrix[i][j] != matrix[matrix.length - 1 - i][matrix[i].length - 1 - j]) {
                        symmetry_flag = false;
                        cnt_replace += 1;
                    }
                }
            }
            // Если указатель симметрии равен true, то выводим "YES", иначе выводим "NO" и минимальное
            // кол-во изменений для достижения симметрии.
            if (symmetry_flag)
                out.printf("Симметричность: %s\n", "YES");
            else
                out.printf("Симметричность: %s\nMin кол-во измениений: %d", "NO", cnt_replace);
        } else
            out.printf("Симметричность: %s\n", "NO");
    }
}