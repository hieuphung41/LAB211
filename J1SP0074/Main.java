package J1SP0074;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // TODO code application logic here
        String choice;
        while (true) {
            menu();
            System.out.print("> Your choice: ");
            do {
                choice = scanner.nextLine();
                if (!isValidChoice(choice)) {
                    System.out.println("Input again!");
                }
            } while (!isValidChoice(choice));
            Matrix matrix1, matrix2, matrix3;
            switch (Integer.parseInt(choice)) {
                case 1:
                    System.out.println("=========== Add ==========");
                    matrix1 = inputMatrix(1);
                    matrix2 = inputMatrix(2);
                    matrix3 = matrix1.addMatrix(matrix2);
                    System.out.println("========== Result ========");
                    matrix1.printMatrix();
                    System.out.println("+");
                    matrix2.printMatrix();
                    System.out.println("=");
                    matrix3.printMatrix();
                    break;
                case 2:
                    System.out.println("=========== Sub ==========");
                    matrix1 = inputMatrix(1);
                    matrix2 = inputMatrix(2);
                    matrix3 = matrix1.subMatrix(matrix2);
                    System.out.println("========== Result ========");
                    matrix1.printMatrix();
                    System.out.println("-");
                    matrix2.printMatrix();
                    System.out.println("=");
                    matrix3.printMatrix();
                    break;
                case 3:
                    System.out.println("=========== Mul ==========");
                    matrix1 = inputMatrix(1);
                    matrix2 = inputMatrix(2);
                    matrix3 = matrix1.mulMatrix(matrix2);
                    System.out.println("========== Result ========");
                    matrix1.printMatrix();
                    System.out.println("*");
                    matrix2.printMatrix();
                    System.out.println("=");
                    matrix3.printMatrix();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }

    }

    public static Matrix inputMatrix(int num) {
        String rows, cols, value;

        System.out.print("Enter Row Matrix " + num + ": ");
        do {
            rows = scanner.nextLine();
            if (!isPositive(rows)) {
                System.out.println("Input again!");
            }
        } while (!isPositive(rows));
        System.out.print("Enter Column Matrix " + num + ": ");
        do {
            cols = scanner.nextLine();
            if (!isPositive(cols)) {
                System.out.println("Input again!");
            }
        } while (!isPositive(cols));
        Matrix matrix = new Matrix(Integer.parseInt(rows), Integer.parseInt(cols));
        for (int i = 0; i < Integer.parseInt(rows); i++) {
            for (int j = 0; j < Integer.parseInt(cols); j++) {
                System.out.print("Enter Matrix" + num + "[" + i + "][" + j + "]: ");
                do {
                    value = scanner.nextLine();
                    if (!isNumber(value)) {
                        System.out.println("Input again!");
                    }
                } while (!isNumber(value));
                matrix.setValue(i, j, Integer.parseInt(value));
            }
        }
        return matrix;
    }

    public static void menu() {
        System.out.println("========== Menu ==========");
        System.out.println("1. Add");
        System.out.println("2. Sub");
        System.out.println("3. Mul");
        System.out.println("4. Exit");
    }

    //    validation
    public static boolean isValidChoice(String input) {
        return input.matches("^[1-4]$");
    }

    public static boolean isPositive(String input) {
        return (input.matches("^[0-9]+$") && Integer.parseInt(input) > 0);
    }

    public static boolean isNumber(String input) {
        return input.matches("^-?\\d+$");
    }

}
