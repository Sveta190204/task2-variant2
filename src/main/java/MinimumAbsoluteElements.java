import java.util.Random;
import java.util.Scanner;

public class MinimumAbsoluteElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean continueProgram;

        do {
            // Ввод размерности матрицы
            System.out.println("Введите количество строк (n) матрицы: ");
            int rows = getPositiveInteger(scanner);
            System.out.println("Введите количество столбцов (m) матрицы: ");
            int cols = getPositiveInteger(scanner);

            // Создание и заполнение матрицы
            int[][] matrix = new int[rows][cols];
            fillMatrixWithRandomValues(matrix, random);

            // Вывод матрицы
            System.out.println("Сгенерированная матрица A:");
            printMatrix(matrix);

            // Нахождение минимальных по абсолютной величине элементов в каждой строке
            int[] minAbsValues = findMinAbsoluteInRows(matrix);

            // Вывод результата
            System.out.println("Вектор минимальных по абсолютной величине элементов:");
            printVector(minAbsValues);

            // Запрос на продолжение работы программы
            System.out.println("Хотите продолжить? (да/нет)");
            String response = scanner.next();
            continueProgram = response.equalsIgnoreCase("да");
        } while (continueProgram);

        scanner.close();
        System.out.println("Завершение работы программы.");
    }

    // Метод для заполнения матрицы случайными значениями в диапазоне [-50, 50]
    private static void fillMatrixWithRandomValues(int[][] matrix, Random random) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(101) - 50; // Генерация значения от -50 до 50
            }
        }
    }

    // Метод для вывода матрицы
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%4d ", value);
            }
            System.out.println();
        }
    }

    // Метод для нахождения минимальных по абсолютной величине значений в каждой строке матрицы
    private static int[] findMinAbsoluteInRows(int[][] matrix) {
        int[] minAbsValues = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            int minAbs = Math.abs(matrix[i][0]);
            for (int j = 1; j < matrix[i].length; j++) {
                int currentAbs = Math.abs(matrix[i][j]);
                if (currentAbs < minAbs) {
                    minAbs = currentAbs;
                }
            }
            minAbsValues[i] = minAbs;
        }
        return minAbsValues;
    }

    // Метод для вывода вектора
    private static void printVector(int[] vector) {
        for (int value : vector) {
            System.out.printf("%4d ", value);
        }
        System.out.println();
    }

    // Метод для получения положительного целого числа
    private static int getPositiveInteger(Scanner scanner) {
        int number;
        while (true) {
            number = scanner.nextInt();
            if (number > 0) {
                break;
            } else {
                System.out.println("Введите положительное число. Попробуйте еще раз:");
            }
        }
        return number;
    }
}