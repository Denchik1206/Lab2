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

Первым делом нужно считать размеры двумерного массива N и M, создать этот двумерный массив N × M 
и заполнить его значениями `true` или `false`. 

### 2. Входные и выходные данные

#### Данные на вход

На вход программа сначала получает два числа N и M (размеры двумерного массива). Так как размеры 
массива не могут быть отрицательными, то числа должны быть больше нуля. Также, не умаляя общности задачи, 
будем считать, что максимальный размер двумерного массива составляет 100 * 100, а минимальный 2 * 2. Значит, эти 
два числа — целые числа, большие 2 и не превышающие 100.

Далее на вход подаются булевые значения `true` или `false` в количестве N * M. Значит минимальное кол-во значений 
равно 4, а максимальное 10000.

|                  | Тип         | min кол-во | max кол-во | min значение | max значение |
|------------------|-------------|------------|------------|--------------|--------------|
| N (Число 1)      | Целое число | 1          | 1          | 2            | 100          |
| M (Число 2)      | Целое число | 1          | 1          | 2            | 100          |
| Булевые значения | Булевый     | 4          | 10000      | -            | -            |

#### Данные на выход

Сначала программа должна вывести строку с максимальным количеством м последовательных значений `true`, 
и длину этой последовательности (L). Максимальная длина этой строки равна 100, а минимальная 2. Минимальное
значение длины этой последовательности равна 2, а максимальное 100.

Далее нужно вывести элементы массива с замененным `true` и `false` на `+` и `-` и вывести кол-во групп 
соседних `true` (K). Минимальное кол-во элементов двумерного массива равна 4, а максимальное кол-во равна 10000. 
А минимальное значение кол-ва островков равна 0. Рассчитаем максимальное значение кол-ва. Возьмем самый большой размер двумерного массива
(100 * 100). Чтобы в строку влезло максимальное кол-во островков нужно, чтобы они состояли только из двух 
последовательных `true` и между островками был только один `false`. В одну строку влезает 33 таких островка, кол-во 
таких строк равно 100. Тогда максимальное значение кол-ва групп соседних `true` равна 3300.

В конце программа должна вывести результат проверки на симметричность массива относительно главной 
диагонали (`YES` или `NO`). И если не симметричен, то вывести минимальное кол-во изменений (R). Минимальное  
значение кол-ва изменений равна 1 (если будет 0, то изменения не нужны, и программа должна вывести `YES`),
а максимальное значение равно ((100 - 1) / 2) * 100 = 4950 (т.к. нужно изменить только одну сторону главной диагонали,
а кол-во элементов до главной диагонали в каждой строке образуют арифм. прогрессию)

|                    | Тип         | min кол-во | max кол-во | min значение | max значение |
|--------------------|-------------|------------|------------|--------------|--------------|
| Строка             | Булевый     | 2          | 100        | -            | -            |
| L                  | Целое число | 1          | 1          | 2            | 100          |
| Массив             | Символы     | 4          | 10000      | -            | -            |
| K                  | Целое число | 1          | 1          | 0            | 3300         |
| Результат проверки | Строка      | 1          | 1          | -            | -            |
| R                  | Целое число | 1          | 1          | 1            | 4950         |

### 2,5. Математическая модель

### 3. Выбор структуры данных



### 4. Алгоритм

### 5. Программа

### 6. Анализ правильности решения
