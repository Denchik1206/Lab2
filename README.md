## Отчет по лабораторной работе №2

---

#### № группы: `ПМ-2401`

#### Выполнил: `Данилов Денис Юрьевич`

#### Вариант: `11`

### Содержание:

- [Постановка задачи](#1-постановка-задачи)
- [Входные и выходные данные](#2-входные-и-выходные-данные)
- [Математическая модель](#25-математическая-модель)
- [Выбор структуры данных](#3-выбор-структуры-данных)
- [Алгоритм](#4-алгоритм)
- [Программа](#5-программа)
- [Анализ правильности решения](#6-анализ-правильности-решения)

### 1. Постановка задачи

> Написать программу на Java, которая выполняет следующие действия
с двумерным массивом булевых значений:
>1. Считывает с консоли размеры массива N и M, затем элементы
   массива размером N × M (значения true или false).
>2. Сортирует строки массива по возрастанию количества значений
   true в каждой строке. Если количества равны, сортирует строки
   по количеству последовательных значений true.
>3. Находит и выводит строку с максимальным количеством последовательных значений true,
   а также длину этой последовательности.
>4. Выводит элементы массива в виде матрицы, заменяя true на символ ’+’, а false на ’-’.
   Дополнительно выводит число островков (групп соседних true).
>5. Проверяет, является ли массив симметричным относительно главной диагонали, и выводит 
   результат проверки. Если массив не симметричен, выводит минимальное количество изменений для достижения симметрии.

Первым делом нужно считать размеры двумерного массива N и M, создать этот двумерный массив N × M (1)
и заполнить его значениями `true` или `false`. Далее нужно создать двумерный массив (2) для хранения 
кол-ва значений `true` и максимального кол-ва последовательных значений `true` в каждой строке. 
Значит кол-во строк в этом массиве равно кол-ву строк в массиве (1), а кол-во столбцов равно 2. 

Во время заполнения массива (2), параллельно будем искать строку с максимальным количеством последовательных 
значений true, а также длину этой последовательности. А еще кол-во всех островков (групп соседних true) в массиве (1).

Дальше нужно отсортировать массив (1). Для это будем использовать сортировку пузырьком и дополнительный
массив (2). Т.е. будем смотреть значения параметров каждой строки массива (1) из массива (2) и
сортировать исходя из этих значений массив (1).

После этого выводим строку с максимальным количеством последовательных значений true, а также длину 
этой последовательности. Еще выводим отсортированный массив (1) в виде матрицы, заменяя true на 
символ ’+’, а false на ’-’. Дополнительно выводим число островков (групп соседних true).

В конце проверяем квадратная ли матрица. Если так, то проверяем на симметрию относительно главной диагонали. Если симметрична, выводим "YES",
а если несимметричен, то выводим "NO" и минимальное количество изменений для достижения симметрии.

### 2. Входные и выходные данные

#### Данные на вход

На вход программа сначала получает два числа N и M (размеры двумерного массива). Так как размеры 
массива не могут быть отрицательными, то числа должны быть больше нуля. Также, не умаляя общности задачи, 
будем считать, что максимальный размер двумерного массива составляет 50 * 50, а минимальный 2 * 2. Значит, эти 
два числа — целые числа, большие 2 и не превышающие 50.

Далее на вход подаются булевые значения `true` или `false` в количестве N * M. Значит минимальное кол-во значений 
равно 4, а максимальное 2500.

|                  | Тип         | min кол-во | max кол-во | min значение | max значение |
|------------------|-------------|------------|------------|--------------|--------------|
| N (Число 1)      | Целое число | 1          | 1          | 2            | 50           |
| M (Число 2)      | Целое число | 1          | 1          | 2            | 50           |
| Булевые значения | Булевый     | 4          | 2500       | -            | -            |

#### Данные на выход

Сначала программа должна вывести строку с максимальным количеством последовательных значений `true`, 
и длину этой последовательности (L). Максимальная длина этой строки равна 50, а минимальная 2. Минимальное
значение длины этой последовательности равна 2, а максимальное 50.

Далее нужно вывести элементы массива с замененным `true` и `false` на `+` и `-` и вывести кол-во групп 
соседних `true` (K). Минимальное кол-во элементов двумерного массива равна 4, а максимальное кол-во равна 2500. 
А минимальное значение кол-ва островков равна 0. Рассчитаем максимальное значение кол-ва. Возьмем самый большой размер двумерного массива
(50 * 50). Чтобы в строку влезло максимальное кол-во островков нужно, чтобы они состояли только из двух 
последовательных `true` и между островками был только один `false`. В одну строку влезает 17 таких островка 
(++-++-++-++-++-++-++-++-++-++-++-++-++-++-++-++-++), кол-во таких строк равно 50. Тогда максимальное значение 
кол-ва групп соседних `true` равна 17*50=850.

В конце программа должна вывести результат проверки на симметричность массива относительно главной 
диагонали (`YES` или `NO`). И если не симметричен, то вывести минимальное кол-во изменений (R). Минимальное
значение кол-ва изменений равна 1 (если будет 0, то изменения не нужны, и программа должна вывести `YES`),
а максимальное значение равно (((50 - 1) + 0) / 2) * 50 = 1225 (т.к. нужно изменить только одну сторону главной диагонали,
а кол-во элементов до главной диагонали в каждой строке образуют арифм. прогрессию)

|                    | Тип         | min кол-во | max кол-во | min значение | max значение |
|--------------------|-------------|------------|------------|--------------|--------------|
| Строка             | Булевый     | 2          | 50         | -            | -            |
| L                  | Целое число | 1          | 1          | 2            | 50           |
| Массив             | Символы     | 4          | 2500       | -            | -            |
| K                  | Целое число | 1          | 1          | 0            | 850          |
| Результат проверки | Строка      | 1          | 1          | -            | -            |
| R                  | Целое число | 1          | 1          | 1            | 1225         |

### 2,5. Математическая модель

1. **Определение кол-ва значений true в каждой строке**   
    Создается вложенный цикл проходящий по каждой строке и элементам массива (1).
    Проверяется каждый элемент строки на, то является ли он true. Если так, то к кол-ву
    true в этой строке прибавляется 1.   
    После того как цикл пройдется по всем элементам строки, в массив (2), состоящий из 2 столбцов и строк равных 
    количеству строк массива (1), в строку с тем же номером, что и строка в которой считали true, добавляется 
    значение кол-ва true.

2. **Определение длины максимальной последовательности значений true в каждой строке. Определение строки и его длины с 
максимальным кол-во последовательных значений true и определение кол-ва островков в массиве**    
    Создается вложенный цикл проходящий по каждой строке и элементам массива (1).
    При этом второй цикл доходит только до предпоследнего элемента строки (это нужно, чтобы при дальнейших проверках
    не было выхода за пределы списка).   
    В каждой строке проверяем является ли нынешнее значение и следующее значение true. Если так, то это к длине островка добавляем 1.
    И будем добавлять к длине 1 до тех пор, пока не найдется такой момент, когда предыдущий и нынешний элементы равны true,
    а следующий не равен или не дойдем до конца строки. Тогда к общему количеству островков добавляем 1, и сравниваем
    длину данного островка с максимальной длиной островка в этой строке, если длина данного островка больше, то обновляем
    значение максимальной длины островка.    
    Когда цикл завершит обработку строки в массив (2), состоящий из 2 столбцов 
    и строк равных количеству строк массива (1), в строку с тем же номером, что и строка в которой находили островки 
    добавляем значение длины максимального островка в строке. Также сравниваем значение длины максимального островка 
    в строке со значением длины максимального островка во всем массиве, если в этой строке длина больше, то обновляем
    значение и сохраняем строку, в которой находится этот островок.

3. **Сортировка массива пузырьком**  
    Нужно сортировать строки массива по возрастанию количества значений true в каждой строке. Если количества равны, строки сортируются
    по количеству последовательных значений true. Эти значения будем брать из массива (2), в котором под столбцом 0
    находятся кол-во значений true в каждой строке, а под столбцом 1 максимальное кол-во последовательных значений true.
    Во время сортировки будем сравнивать значения из массива (2) и исходя из результатов этих сравнений
    сортировать массива (1) и массив(2).

4. **Проверка симметричности относительно главной диагонали и определение минимального кол-ва изменений для достижения симметрии**   
    Для начала проверим равны ли размеры массива, т.к в неквадратной матрице проверить симметричность не возможно.   
    Далее, если двумерный массив квадратный, то создадим вложенный цикл. Первый цикл, c переменной i, будет проходить по строкам от 1 до последнего,
    а второй, c переменной j, по элементам от 0 до значения первого цикла.   
    Первый цикл начинается с 1, т.к. 0 элемент 0 строки и последний элемент (Длина строк (L) - 1 - 0) последней строки 
    (Кол-во строк (K) - 1 - 0) являются элементами главной диагонали, и сравнивать элементы главной диагонали нам не нужно.
    А второй цикл идет до значения первого цикла, то есть до i, потому что нужно сравнивать элементы до главной диагонали,
    а номера элементов этой диагонали такие, что номер строки совпадает с номером столбца ([0][0], [1][1], [2][2] и т.д.)   
    Проверять на симметрию будем следующим образом: 
    * начинаем с первой строки и предпоследней (Кол-во строк (K) - 1 - 1).
    * сравниваем 0 элемент первой строки с последним элементом (Длина строк (L) - 1 - 0) предпоследней строки. И переходим
    на следующую строку, т.к. 1 элемент в первой строке и предпоследний элемент предпоследней строки являются элементами 
    главной диагонали.
    * Далее сравниваем j элемент i строки с (L - 1 - j) элементом (K - 1 - i) строки. Потом j + 1 элемент i cтроки с
    с (L - 1 - (i + 1)) элементом (K - 1 - i) строки и т.д. до главной диагонали. Если какие-то два элемента не совпадут, 
    то индикатор симметрии изменяем на false и к кол-ву изменений для достижения симметрии прибавляем 1.


### 3. Выбор структуры данных

* Программа на вход получает два значения N и M (размеры двумерного массива). Поскольку эти значения
  не превышают 2<sup>31</sup>, для их хранения будем использовать две переменные `n` и `m` типа `int`.

* Далее нам необходимо создать двумерный массив `matrix` (m1), для хранения значений true или false. Поскольку эти 
  значения являются булевыми, массив будет иметь тип `boolean[][]`.

* Также потребуется еще один массив `max_island` (m2), который будет сохранять строку с максимальным кол-вом 
  последовательных значений true. Поскольку все строки в массиве состоят из true или false, тип этого массива должен
  быть `boolean[]`.

* Еще нужны переменные `max_len_islant` (n3) и `cnt_islant` (n4), для хранения длины максимальной последовательности значений true и
  кол-ва островков (групп соседних true) соответственно. Эти переменные будут иметь тип `int`, т.к. максимальное значение 
  максимальной послед. значений true может достигать 50 (если массив имеет размеры X x 50 и все значения в строке равны true),
  а максимальное кол-во островков равно 850 (выяснили это выше). Оба этих значения не превышают 2<sup>31</sup>.

* Также необходим двумерный массив `cnt_true_max_island` (m3), который будет хранить кол-во true и длину максимальной последовательности 
  значений true в каждой строке. Поскольку оба этих значения — целые числа, не превышающие 2<sup>31</sup> (max кол-во true 
  и длина max последовательности значений true в строке равно 50), массив будет иметь тип `int[][]`.

* Еще будет использоваться переменная `cnt_true_i` (n5) для подсчета кол-ва true. Максимальное кол-во true в строке 
  составляет 100, что меньше 2<sup>31</sup>, поэтому переменная будет иметь тип `int`.

* Будем использовать еще две переменные `max_island_in_i` (n6) и `lenn_island` (n7), для временного хранения длины max островка 
  в строке i и подсчета длины каждого островка в строке i. Максимальное значение обеих переменных равно 50. 
  Будем использовать переменные типа `int`.

* Также потребуются два массива `swap1` (m4) и `swap2` (m5). Оба нужны для временного хранения строки во время сортировки массивов.
  Первый для массива `matrix`, значит массив нужен типа `boolean[]`, а второй для массива `cnt_true_max_island`, значит 
  массив типа `int[]`.

* Далее во время проверки на симметрию будет использоваться переменная `symmetry_flag`, которая может принимать
  значения true или false. Эта переменная будет иметь тип `boolean`.

* Еще переменная `cnt_replace` (n8) для подсчета минимального кол-ва изменений. Максимальное значение переменной равно 1225,
  что меньше 2<sup>31</sup>, поэтому она будет иметь тип `int`.

|             | название переменной   | Тип (в Java)  |
|-------------|-----------------------|---------------|
| N (Число 1) | `n`                   | `int`         |        
| M (Число 2) | `m`                   | `int`         |
| Массив 1    | `matrix`              | `boolean[][]` |
| Массив 2    | `max_island`          | `boolean`     |
| Массив 3    | `cnt_true_max_island` | `int[][]`     |
| Массив 4    | `swap1`               | `boolean[]`   |
| Массив 5    | `swap2`               | `int[]`       |
| Число 3     | `max_len_islant`      | `int`         |  
| Число 4     | `cnt_islant`          | `int`         |          
| Число 5     | `cnt_true_i`          | `int`         |
| Число 6     | `max_island_in_i`     | `int`         |
| Число 7     | `lenn_island`         | `int`         |
| Число 8     | `cnt_replace`         | `int`         |
| Указатель   | `symmetry_flag`       | `boolean`     |

### 4. Алгоритм

1. **Ввод данных:**   
    Программа считывает два целых числа, которые обозначены как `n` и `m`. После создается массив, под названием `matrix`,
    который будет заполняться значениями true или false.

2. **Подсчет кол-ва true и длины max последовательности значений true в каждой строке, определение строки с 
max кол-вом послед. значений true и его длины и подсчет кол-ва островков**   
    Программа проходится циклом по строкам и элементам массива `matrix` и подсчитывает количество true. После каждой
    обработанной строки добавляет в массив `cnt_true_max_island` количество true в данной строке.
    После определения кол-ва true в строке программа начинает искать островки (группы соседних true) и определяет их
    длины. Также она подсчитывает общее кол-во островков. В конце обработки строки в массив `cnt_true_max_island` добавляется 
    длина самого большого островка в этой строке.
    Еще во время этого цикла программа ищет строку с самой длинной последовательностью значений true и запоминает 
    эту строку и длину этой последовательности значений true.

3. **Сортировка массива `matrix`**  
    Программа сортирует массив с помощью алгоритма сортировки пузырьком. Берутся значения из массива `cnt_true_max_island`,
    и исходя из этих значений сортируется массив `matrix`.

4. **Вывод результатов**   
    На экран выводится строка с максимальным количеством последовательных значений true, а также длина 
    этой последовательности. 
    Также выводится отсортированный массив `matrix` в виде матрицы с замененными значениями true и false на + и -.
    И еще выводится кол-во островков.

5. **Проверка симметричности относительно главной диагонали и вывод минимального кол-ва изменений для достижения симметрии**   
    Программа проверяет на равенство размеров двумерного массива, если они равны, то проходится по строкам массива с двух 
    сторон начиная с 1 и -2 (считаем, что строки нумеруются с 0) и заканчивая -1 и 0. Дальше проходимся по элементам 
    строки с левой и правой стороны до главной диагонали и сравниваем (0 элемент в 1 строке с -1 элементом в -2 строке, 
    дальше переходим на 2 и -3 строки, т.к. 1 элемент 1 строки и -2 элемент -2 строки являются элементами главной диагонали).
    Если какие-то элементы не совпадают, то добавляем к кол-ву изменений 1.

### 5. Программа

```java
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
```

### 6. Анализ правильности решения

1. Тесты при обычных размерах массива:
    - **Input**:
         ```
        18
        21
        false false true true false true true true false true false false false false true false false false true true false false true false false true false false true false true false false false false false false true true false false false false true false true true true true true false false false false true true false true false true false false false true false false true true true false false false false true true true true true true false false true false true false true true true true true true true true false false true true true true true true false false false true false false true false true true true false false false false true true false false false false true false false false false true true false true false false true false false false false true false true true true true false true false true false false true true false true false true true false false true true true true false true false true false false false true true true true false false false true true false true false true true false false true true false false true true true true true true true false true false true false false false false false false false true false true true true true false false true true true true false true true false false true true false false false true false false false true false false true false false true true false true true true false true false false true true true true false true false false true true false true false false false true true false true false true true true false false true true true true true false false false true true true false false false false true true true true false true false false false true false false true false false false true false true false true true false false true true true true true false false true false true false true false true false false true true false true false true true false true true true false false true false true false false true false false true false false false true true false true true false true false false true false false false true false false true true true false false true true
        ```
      
    - **Output**:
        ```
        false true true true true true true true true false false true true true true true true false false false true 
        Длина: 8
        
        - + + + + + + + + - - + + + + + + - - - +
        + + + + - - + + + + - + + - - + + - - - +
        + - - + + + - - - - + + + + + + - - + - +
        - - + + + + + - - - + + + - - - - + + + +
        + - - + + - + - + + - - + + + + - + - + -
        + + + + - - + - + - + - + - - + + - + - +
        + + - + - - + + - + - - - + + - + - + + +
        - - + + + + - - - + + - + - + + - - + + -
        - + + + + + + + - + - + - - - - - - - + -
        - + - + + + + + - - - - + + - + - + - - - 
        - + + - + - - + - - - - + - + + + + - + -
        - - - + - - + - - + + - + + + - + - - + +
        + - + + + - - + - + - - + - - + - - - + +
        - + + - + - - + - - - + - - + + + - - + +
        - - + + - + + + - + - - - - + - - - + + -
        - + - - - + - - + - - - + - + - + + - - +
        - - + - + + + - - - - + + - - - - + - - - 
        - + - - + - - + - + - - - - - - + + - - - 
        Число островков: 44
        Симметричность: NO
      ```

2. Тест при максимальных размерах массива:
    
    - **Input**:
        ```
      50
      50
      false true false false true false true true true false true false true false false false true false true false true false true true false false false true true false true false true true true false true false false true false false true false false true false false false true false true true true true true false false true true true true false true true false false false false false false false true false true false false true false false true true true true false true true false true true true true true true false true true false false false true true true true true false true false false true false true false false true false true true true true false false false true false true true false false true false false true false false false false true false false false true false false false false true true false false false false false true true false true false false true false true false false true false true true false false true true true true true false true false true true false false true false false false false true true true true true true true true false false false true false false true false true true false false true false false false true true true false false false false false true false false false true false true false false true false false false false true true true false true true false false true false true true false true false true true true false true false true false true false false true false false false false false false true false false false true false false false false true false true false true false true false false true true false true true true false false false false false false true false true false true true true false false true false true true true true true true false true true true false true true false true true false true false true true true false false true false false false true true true false false true true false true false false false true false true false false false false false false true true true true true false true true false false false false false false true false true false true false false true true true false false false false false true true true false true false false false true false true true false true false false true false false false false false true true true true true false false true true true false true false false false false true false false true false false true true true true true true false false false true true true true true false true true false false true true true true false true true false true false false true true false false false true false true false false true false true false false true true true false false false true true false false false true false false true true true false false true true true false true true false false false true true false false true true true false true true true false false true true false false false true false false true false true true false true false true false true true false true true true false false false false false false true true true true true false true true false false true false true true true false true true false false true true true true false false false false true false false false false false true true true true false true false false true false true true false true true false true true true true false true false true false true false false false false false false false true true false false false true false false false true true true false true true false true false true true true false true true false false true true false false false false true false false true false false true false true false false true true false true true true true true false true false true true true true true true false true true false true false false true true true false true false false false true false false false true false true false true true true false false false true true true true true true true true false true true false false false false true false true true true false false false true false false false false false false true true true true false false true false true true true true true true false true true true true true false false true true true true true false false true true true true false true true false false false true true false true true true false true true true false true false false false false false true false true true false true false true true true false true true true true false true true false false true true false true false true false false true false false true false true true true false false false true true false false true true false false false true false true false false true true true true true false false false true true false false false true false true true true false false true false false true false true true false false true true true false true false true false true true true true false false false false false false true true true false true false false true true true true true true true true false false false false false true true true true true false false true true true false true false true true true true true true false true true false true false true true false true true false false true true true true false false false false true true false true false false false false true true true false true false false true false false true false false true true false false false true false true true true true true true false false true false false true true true true true true false true true true false false true false false true false true true false false false true true false true false false false false false true false true false false true false false true false false false false false false false false false false true true true false false true false false false true true false false false false true true true false true false false true false true false false false false false true true false false false false false true true true false false true false false true false true false false false true false true true false true false false false true true false true false true false true false true false true false false false true true false true true false false false true true true false false true false true false true false false false true true false false false true false true false false false true true true false true false true false false true false true true true true false true true false false false false true false true true false true false true false false true true false false true true true false false true true false true true true true true false true false false false true true true true true true true false false true false false false false true true false false true false true true true true true false true true false false true false true false true true false true true false true true true false true false true false true false false false false false false false false false true false true false true false true false false true true false true true true false true false false true true true false false true false true true false false false true true true false false false true true false true false true true false true false false false true false true false true true true false false true false false false false true false true true true false true false true true true true false false false false false true true true true false true true true true true false false true false false true true true false false false true true false true true false false false false false true false true false false true true true true true false false true false false true true true true true false false true false false true true false false false true false true true true false false false false false true false false true true false true false false true true true false true true true false false false false false false true true true true false false true false true true true false false true true false true false true false true true false false false true false true false true false false true true false true true false false true false false false true true true true true false false false false false true true false true true false true false false false false true false false true false false false true true true true true false true true false true false false false true true true false true false true false false true false true true true true false false true true true false true false true false true false true true false true false false true true true true false false false false true false true false true true true true false false false true true true false true false true true false false false true true false false false true false true false true true true true true true false false true true false true true false true true false true false false true true false true true true true true true true true false false false true true true true true true true true false false true false false true false true false true false true true true true false false true false true false false true false false false true false true true true true true false false false true false false true true false false false true false true true true true false false false true true false false false true true false true true true true true true true false false true false false false false false true false false true true true true false true true false false true true false true false false true false false false true true false false true false true false true true true true true false true false true false false true true true false true false false false true false false true false false true true false true false false false false true true false true true false true true false true false false false true true true false false false false false true false false false true false false false true false true true false true false false false true false true true true false false true false true false false false false false true false true true true true false true true true true false true false true true false true true false true false false false true false true false false false true true false true true true false true false false false true true true false true true false true false false true true false false false false true false false true false false false false true true false true true true false false true false true true false false true false false true true true true false false true true true false true true true false true true true true false true false false true false false true true true true false false false true true true true true true true false false true true true true false false false false false true false true true true true true true true false false false true false true true true true false true false false true true false true true true false true false true true false true true true true false false true true true true false true true true false true false false true true true false true true true false false false true true false true false false true true false true true true false true false false false true true false false true true true false false true false true false false true false false false false false true true true true false false true true true true false false false true false true false false true true true false true false true true true true true true true false true false true false true true false false true true true false true false true false true false false true true true false true false true true false true false false false false true true true true true true false true true true true true true false false true true false false true false false false true true true false false false false false false false true true true true false true false true false true false false true false false false true true false true true false false true true true false false true false false true true true true true false false false true true true false false false false false false false false false true false true true true true false true true true false false false false false true true false false true true false true true true true false true true true false false true false false false true false false true false true false false false false true true false false false true false true true false true false false false false true false true true true true false true true false false false false true false true false true true true false false true true false true true true false false false false false true false true true true false true false false true false false false true true true false true true false true false false true true false false false false true true false true false true false false false true false false false false true true true false true true true false false true false false true false true true true true false true false false true true false true true false false true false false true false true true true false false true false true true true true true false false false false false false false false false false false false true true true false true true true false false false false false false true false true false false true true true false true false true true true false true false true true false false true false true true true true false false true false true true true true true false false false false false true true true true false true true false true false false true false false true false false false true false true false true true false true false false true true false false true false true false false true true true false false false true false true false false false false false false false false
      ```
      
    - **Output**:
        ```
      false false false true true false true false false true false true false false true false true true false false true true true true true false true false true true false false true false false false false true true true true true true true true false false false true false 
      Длина: 8
            
      - + + + + + + + - - - + - + + + + - + - - + + - + + + - + - + + - + + + + - - + + + + - + + + - + -
      + + + + + + + + - + + - - - - + - + + + - - - + - - - - - - + + + + - - + - + + + + + + - + + + + +
      + + + - - + + + - + + + - + + + + - + - - + - - + + + + - - - + + + + + + + - - + + + + - - - - - +
      + - - + + - + + + + + + + + - - - + + + + + + + + - - + - - + - + - + - + + + + - - + - + - - + - -
      + + - - + + + + - - - + - + - - + + + - + - + + + + + + + - + - + - + + - - + + + - + - + - + - - +
      + + + - - + - + + + + + + - + + + - + + - + + - + - + + + - - + - - - + + + - - + + - + - - - + - +
      + - - - - - + + + + + - - + + + - + - + + + + + + - + + - + - + + - + + - - + + + + - - - - + + - +
      - - + + + + + - - + + + + - + + - - - + + - + + + - + + + - + - - - - - + - + + - + - + + + - + + +
      - + - + + + + - + + - - - - + - + + - + - + - - + + - - + + + - - + + - + + + + + - + - - - + + + +
      + + + - + + - + - - - + + + - + - + - - + - + + + + - - + + + - + - + - + - + + - + - - + + + + - -
      - - + - + + + - - + - - + - + + - - + + + - + - + - + + + + - - - - - - + + + - + - - + + + + + + +
      - + + + + + - - + + + + - + + - - - - - - - + - + - - + - - + + + + - + + - + + + + + + - + + - - - 
      - + - - + + - + + + + + - + - + + + + + + - + + - + - - + + + - + - - - + - - - + - + - + + + - - - 
      - - + - + - + + + + - - - + + + - + - + + - - - + + - - - + - + - + + + + + + - - + + - + + - + + -
      + + - + - + + - + - - - - + + + + + + - + + + + + + - - + + - - + - - - + + + - - - - - - - + + + +
      + + - - + - + + + - + + - - + + + + - - - - + - - - - - + + + + - + - - + - + + - + + - + + + + - +
      - + - - - - - + + + + + - - + + + - + - - - - + - - + - - + + + + + + - - - + + + + + - + + - - + +
      - - - - - + - + - - + + + - + - + + + - + - + + - - + - + + + + - - + - + + + + + - - - - - + + + +
      - - - + + - + - - + - + - - + - + + - - + + + + + - + - + + - - + - - - - + + + + + + + + - - - + -
      - + - + + + + + - - - + - - + + - - - + - + + + + - - - + + - - - + + - + + + + + + + - - + - - - - 
      - - - - + + + - + - - + - - + - - + + - - - + - + + + + + + - - + - - + + + + + + - + + + - - + - -
      - - + + - - + + + - + + + - - + + - - - + - - + - + + - + - + - + + - + + + - - - - - - + + + + + -
      + + + - - + - - - - + + - - + - + + + + + - + + - - + - + - + + - + + - + + + - + - + - + - - - - - 
      - - - + - + - + + + - - + - - - - + - + + + - + - + + + + - - - - - + + + + - + + + + + - - + - - +
      + + - - - + + - + + - - - - - + - + - - + + + + + - - + - - + + + + + - - + - - + + - - - + - + + +
      - + - - + + + + - + + - - + + - + - - + - - - + + - - + - + - + + + + + - + - + - - + + + - + - - - 
      + - + + - - + + - + - + - - + - - + - + + + - - - + + - - + + - - - + - + - - + + + + + - - - + + -
      - - + - + + + - - + - + - - - - - + - + + + + - + + + + - + - + + - + + - + - - - + - + - - - + + -
      + + - + - - - - + - + + + + - + + - - - - + - + - + + + - - + + - + + + - - - - - + - + + + - + - -
      + + - + + - + - - + + - - - + - + - - + - + - - + + + - - - + + - - - + - - + + + - - + + + - + + -
      - - - - + - + - + - + - - + + - + + + - + - - + + + - - + - + + - - - + + + - - - + + - + - + + - +
      - + + + - + + + - - - + + - + - - + + - + + + - + - - - + + - - + + + - - + - + - - + - - - - - + +
      + + - + - - + + - + + - - + - - + - + + + - - + - + + + + + - - - - - - - - - - - - + + + - + + + -
      - - - - - + - - + + - + - - + + + - + + + - - - - - - + + + + - - + - + + + - - + + - + - + - + + -
      + + + - + + + - - - - - + + - - + + - + + + + - + + + - - + - - - + - - + - + - - - - + + - - - + -
      + + + - + - - - + + + - + + - + - - + + - - - - + - - + - - - - + + - + + + - - + - + + - - + - - +
      + - - - + + + - + + - + - - + + - - - - + + - + - + - - - + - - - - + + + - + + + - - + - - + - + +
      - + - - + - + + + - + - + - - - + - + - + - + + - - - + + - + - + + + - + - - + - - + - - + - - - +
      + - + - + - + - - - + + - + + - - - + + + - - + - + - + - - - + + - - - + - + - - - + + + - + - + -
      + + + + + - + - - + - + - - + - + + + + - - - + - + + - - + - - + - - - - + - - - + - - - - + + - -
      - - + - + - + - - + + - + + - - + - - - + + + + + - - - - - + + - + + - + - - - - + - - + - - - + +
      - + - + - + - - + - - - + + - + + - - + + + - - + - - + + + + + - - - + + + - - - - - - - - - + - +
      - + - + + - - + - - - + + + - - - - - + - - - + - + - - + - - - - + + + - + + - - + - + + - + - + +
      - - - - - - + + + + + - + + - - - - - - + - + - + - - + + + - - - - - + + + - + - - - + - + + - + -
      - + - + - - - - - - - + + - - - + - - - + + + - + + - + - + + + - + + - - + + - - - - + - - + - - +
      + + + - + - - + - + - - - - - + + - - - - - + + + - - + - - + - + - - - + - + + - + - - - + + - + -
      + - - + - - + + - + - - - - + + - + + - + + - + - - - + + + - - - - - + - - - + - - - + - + + - + -
      - + + - + - - + - - + - - - + - + - + + - + - - + + - - + - + - - + + + - - - + - + - - - - - - - - 
      + - + - + - + - - + - - - - - - + - - - + - - - - + - + - + - + - - + + - + + + - - - - - - + - + -
      + - + + - - - + + - + - - - - - + - + - - + - - + - - - - - - - - - - + + + - - + - - - + + - - - - 
      Число островков: 314
      Симметричность: NO
      Min кол-во измениений: 630
      ```

3. Тест при минимальных размерах массива:

    - **Input**:
        ```
      2
      2
      true false true true
      ```

    - **Output**:
        ```
        true true 
        Длина: 2
        
        + +
        + -
        Число островков: 1
        Симметричность: YES
      ```

4. Тест вывода строки и длины с максимальным кол-вом последовательных значений true:
    
    - **Input**:
        ```
      21
      50
      true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true false false false true false true true false true false true true false true true false true false true true false true false true false false false false false true false false false true false true false false true true false true false false true true false true true true true false false true true false true false true false false false true true true true false true true false true false true false true false false false false false true false true false false true false true true true false false true false true false true true true false false false false false false true false true false true true true false false false true true true true false false true true true true false true false false false true true false false false true false false true true true true false false true true false true false true true false true false true false false false false false true false true true false true false false true false true true false true true false true true false false true false true true true false true true false false true false false false false false true false false true true true true true true true false false false true false true false false true true false false false false true false false false false true false false false false false true false true false true false false false false true true false false true false true false false true false false false false true false true false true true false true true true false false false false true true false true false true false true false false true true false false false false false false true true false false false true true true false false true true true false false true false true false false true false false true true false true false false true true false false false true false true true true true false false false false true true true false true true false false true false true true true true false true true false false true true false false false false false true true false false true false false true false true false true true false true true true true true true false false false true true false true true true false false false true true true false true true true true false true true true true false false false true false false true true true true false true false false false true false true false true true true false true false false false true false true true true true true false true true false true true true false true false true false false true true true true true false false false false true false false false false false true true true false true true true false true false true false false true false true false false false false false true false true true true false true false false false false true true false true false false false false true false false true true false true true true false true true true false true false false false false false true true false false false true true true false true false false false false true false true true true true true true true false true true false true false false true false true true true true true true true true true true true false true true true true true false true true false false true true false false false true false true true true false true true true false false false true false true true false false false false true true false true false false false false false true true false false false true true true true false true true false true false false true false false false true false false false false true false false true false false false true false true true true true true false true true false true false false true true true false true false false false false true false false false false false false false true true false false true false true false true false false false false true false false false false false false true true false true false true true false true false false false true false true false true false true true false true true false false false false true true true true false true false true true false true false true false false false true true false false false true true true false true true true true false false false true true false true false true true true true true false false false false true true true false false false true false false true false true true true false true false true false true true true false true true true true true false true false false false true true false true false true true true false false true false true false false true false false false false false false false false true true true true true true false true false true true true true true true false false true false true true false false false false false false true true false true false false false true true true false false false true false true true true true false true false false false true true true true false true false false false false false false false false false true true true false true false true true false true false false true false false true true false true false false false false false true false true true true true false true false false false true true true true false false true false false false true false false true true true false false true true false false false true true true false true true false false false false false true false true true false true true true true false false true true true true false false true false true false true false false true true true false false true false false false true true false true true true true false
      ```
      
    - **Output**:
        ```
      true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true 
        Длина: 50
        
        + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + +
        + - - + - + + + + + + + + + + + - + + + + + - + + - - + + - - - + - + + + - + + + - - - + - + + - -
        + - - - - - + + - - + - - + - + - + + - + + + + + + - - - + + - + + + - - - + + + - + + + + - + + +
        + - - - + - - + + + + - + - - - + - + - + + + - + - - - + - + + + + + - + + - + + + - + - + - - + +
        - - - + + - + - + + + + + - - - - + + + - - - + - - + - + + + - + - + - + + + - + + + + + - + - - - 
        + - + - - - + - + - + - + + - + + - - - - + + + + - + - + + - + - + - - - + + - - - + + + - + + + +
        + - + + - - - - - + - + + - + + + + - - + + + + - - + - + - + - - + + + - - + - - - + + - + + + + -
        - - - + - - + + - + + + - + + + - + - - - - - + + - - - + + + - + - - - - + - + + + + + + + - + + -
        - + - + - - + - - + + - + - - + + - - - + - + + + + - - - - + + + - + + - - + - + + + + - + + - - +
        + + - + - + + + - - + - + - - + - - - - - - - - + + + + + + - + - + + + + + + - - + - + + - - - - - 
        + - - + + - + - + - - - + + + + - + + - + - + - + - - - - - + - + - - + - + + + - - + - + - + + + -
        - - - - - + - + - + + + - - - + + + + - - + + + + - + - - - + + - - - + - - + + + + - - + + - + - +
        - + + - + - - - + + + - - - + - + + + + - + - - - + + + + - + - - - - - - - - - + + + - + - + + - +
        - - - + - + + - + - + + - + + - + - + + - + - + - - - - - + - - - + - + - - + + - + - - + + - + + +
        - - + - - + + - + - - - - - + - + + + + - + - - - + + + + - - + - - - + - - + + + - - + + - - - + +
        + - + - + - - - - - + - + + - + - - + - + + - + + - + + - - + - + + + - + + - - + - - - - - + - - +
        - - + + - + - - - - - + + - - - + + + + - + + - + - - + - - - + - - - - + - - + - - - + - + + + + +
        - - - - + - + - + + - + + + - - - - + + - + - + - + - - + + - - - - - - + + - - - + + + - - + + + -
        + + + - - - - + - - - - - + + + - + + + - + - + - - + - + - - - - - + - + + + - + - - - - + + - + -
        + + + + + + - - - + - + - - + + - - - - + - - - - + - - - - - + - + - + - - - - + + - - + - + - - +
        - + + - + - - + + + - + - - - - + - - - - - - - + + - - + - + - + - - - - + - - - - - - + + - + - +
        Число островков: 121
        Симметричность: NO
      ```

5. Тест вывода строки и длины с минимальным кол-ва последовательных значений true:
    
    - **Input**:
        ```
      12
      13
      true false false true false false false false true false true false true false true false false false true false false true false true false false true false true false true false true false true false true false true false false true false false false false false true false false true false false false false false true false false true false false true false true false true false true false false true true false false false false false true false false true false true false true false true false true false true false true false true false false false false true false false false true false true false false true false false false false true false false false true false true false true false true false true false false false false false true false false false false true false true false false false true false false false false false true false false false false false true
      ```
      
    - **Output**:
        ```
      false true false true false false true true false false false false false 
        Длина: 2
        
        + - + - + - + - + - + - +
        + - - + - + - + - + - + -
        + - - + - - - - + - + - +
        - + - + - + - + - + - - - 
        - + - + - - + + - - - - - 
        - + - - - + - - + - + - -
        - - - - + - - + - - + - +
        + - + - + - - - - + - - - 
        + - + - - + - - - - + - -
        - - + - - - - - + - - + -
        - - + - - - - + - + - - - 
        + - - - - - + - - - - - +
        Число островков: 1
        Симметричность: NO
      ```
            
6. Тест вывода максимального кол-ва островков в массиве:

    - **Input**:
        ```
      50
      50
      true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true
      ```
      
    - **Output**:
        ```
      true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true 
        Длина: 2
        
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        Число островков: 850
        Симметричность: YES
      ```

7. Тест вывода минимального кол-ва островков в массиве:

    - **Input**:
        ```
      6
      8
      false true false false false false false true false true false true false false true false false false true false true false true false true false true false false true false true false true false false false true false false true false false true false false true false
      ```
      
    - **Output**:
        ```
      no such line

        + - + - - + - +
        - + - + - - + -
        - - + - + - + -
        + - - + - - + -
        - + - - - - - +
        - + - - - + - -
        Число островков: 0
        Симметричность: NO
      ```
      
8. Тест проверки на симметрию:

    - **Input**:
        ```
      38
      38
      true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true
      ```
    - **Output**:
        ```
      true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true false true true 
        Длина: 2
        
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + + - + +
        Число островков: 494
        Симметричность: YES
      ```
      
9. Тест проверки на симметрию, когда выводится максимальное кол-во минимальных изменений для достижения симметрии

    - **Input**:
        ```
      50
      50
      true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true false true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true false false true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true false false false true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true false false false false true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true false false false false false true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true false false false false false false true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true false false false false false false false true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true false false false false false false false false true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true false false false false false false false false false true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true false false false false false false false false false false true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true false false false false false false false false false false false true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true false false false false false false false false false false false false true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true false false false false false false false false false false false false false true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true false false false false false false false false false false false false false false true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true false false false false false false false false false false false false false false false true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true false false false false false false false false false false false false false false false false true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true false false false false false false false false false false false false false false false false false true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true false false false false false false false false false false false false false false false false false false true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true false false false false false false false false false false false false false false false false false false false true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true false false false false false false false false false false false false false false false false false false false false true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true false false false false false false false false false false false false false false false false false false false false false true true true true true true true true true true true true true true true true true true true true true true true true true true true true true false false false false false false false false false false false false false false false false false false false false false false true true true true true true true true true true true true true true true true true true true true true true true true true true true true false false false false false false false false false false false false false false false false false false false false false false false true true true true true true true true true true true true true true true true true true true true true true true true true true true false false false false false false false false false false false false false false false false false false false false false false false false true true true true true true true true true true true true true true true true true true true true true true true true true true false false false false false false false false false false false false false false false false false false false false false false false false false true true true true true true true true true true true true true true true true true true true true true true true true true false false false false false false false false false false false false false false false false false false false false false false false false false false true true true true true true true true true true true true true true true true true true true true true true true true false false false false false false false false false false false false false false false false false false false false false false false false false false false true true true true true true true true true true true true true true true true true true true true true true true false false false false false false false false false false false false false false false false false false false false false false false false false false false false true true true true true true true true true true true true true true true true true true true true true true false false false false false false false false false false false false false false false false false false false false false false false false false false false false false true true true true true true true true true true true true true true true true true true true true true false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false true true true true true true true true true true true true true true true true true true true true false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false true true true true true true true true true true true true true true true true true true true false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false true true true true true true true true true true true true true true true true true true false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false true true true true true true true true true true true true true true true true true false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false true true true true true true true true true true true true true true true true false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false true true true true true true true true true true true true true true true false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false true true true true true true true true true true true true true true false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false true true true true true true true true true true true true true false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false true true true true true true true true true true true true false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false true true true true true true true true true true true false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false true true true true true true true true true true false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false true true true true true true true true true false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false true true true true true true true true false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false true true true true true true true false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false true true true true true true false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false true true true true true false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false true true true true false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false true true true false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false true true false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false false true
      ```
      
    - **Output**:
        ```
      true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true true 
        Длина: 50
        
        + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + +
        - + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + +
        - - + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + +
        - - - + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + +
        - - - - + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + +
        - - - - - + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + +
        - - - - - - + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + +
        - - - - - - - + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + +
        - - - - - - - - + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + +
        - - - - - - - - - + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + +
        - - - - - - - - - - + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + +
        - - - - - - - - - - - + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + +
        - - - - - - - - - - - - + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + +
        - - - - - - - - - - - - - + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + +
        - - - - - - - - - - - - - - + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + +
        - - - - - - - - - - - - - - - + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + +
        - - - - - - - - - - - - - - - - + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + +
        - - - - - - - - - - - - - - - - - + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + +
        - - - - - - - - - - - - - - - - - - + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + +
        - - - - - - - - - - - - - - - - - - - + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + +
        - - - - - - - - - - - - - - - - - - - - + + + + + + + + + + + + + + + + + + + + + + + + + + + + + +
        - - - - - - - - - - - - - - - - - - - - - + + + + + + + + + + + + + + + + + + + + + + + + + + + + +
        - - - - - - - - - - - - - - - - - - - - - - + + + + + + + + + + + + + + + + + + + + + + + + + + + +
        - - - - - - - - - - - - - - - - - - - - - - - + + + + + + + + + + + + + + + + + + + + + + + + + + +
        - - - - - - - - - - - - - - - - - - - - - - - - + + + + + + + + + + + + + + + + + + + + + + + + + +
        - - - - - - - - - - - - - - - - - - - - - - - - - + + + + + + + + + + + + + + + + + + + + + + + + +
        - - - - - - - - - - - - - - - - - - - - - - - - - - + + + + + + + + + + + + + + + + + + + + + + + +
        - - - - - - - - - - - - - - - - - - - - - - - - - - - + + + + + + + + + + + + + + + + + + + + + + +
        - - - - - - - - - - - - - - - - - - - - - - - - - - - - + + + + + + + + + + + + + + + + + + + + + +
        - - - - - - - - - - - - - - - - - - - - - - - - - - - - - + + + + + + + + + + + + + + + + + + + + +
        - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - + + + + + + + + + + + + + + + + + + + +
        - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - + + + + + + + + + + + + + + + + + + +
        - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - + + + + + + + + + + + + + + + + + +
        - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - + + + + + + + + + + + + + + + + +
        - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - + + + + + + + + + + + + + + + +
        - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - + + + + + + + + + + + + + + +
        - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - + + + + + + + + + + + + + +
        - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - + + + + + + + + + + + + +
        - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - + + + + + + + + + + + +
        - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - + + + + + + + + + + +
        - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - + + + + + + + + + +
        - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - + + + + + + + + +
        - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - + + + + + + + +
        - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - + + + + + + +
        - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - + + + + + +
        - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - + + + + +
        - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - + + + +
        - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - + + +
        - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - + +
        - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - +
        Число островков: 49
        Симметричность: NO
        Min кол-во измениений: 1225
      ```