package J1SP0011;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        while (true) {
            Number num = new Number();
            System.out.print("Choose the base number input (2 is binary, 10 is decimal, 16 is hexadecimal): ");
            int inputBase = getUserChoice();
            num.setBase(inputBase);
            System.out.print("Choose the base number output (2 is binary, 10 is decimal, 16 is hexadecimal): ");
            int outputBase = getUserChoice();
            System.out.print("Enter the input value: ");
            String value = getNumber(num.getBase());
            num.setValue(value);
            System.out.println("Output value: " + num.convert(outputBase));
            System.out.print("Do you want to continue? (y/n): ");
            if (!scanner.nextLine().equalsIgnoreCase("y")) {
                System.exit(0);
            }
        }

    }

    public static int getUserChoice() {
        String input;
        do {
            input = scanner.nextLine();
            if (!isValidBase(input)) {
                System.out.println("Only base 2, base 10 and base 16! Input again!");
            }
        } while (!isValidBase(input));
        return Integer.parseInt(input);
    }

    public static String getNumber(int inputBase) {
        boolean check;
        String input;
        do {
            input = scanner.nextLine();
            check = true;
            switch (inputBase) {
                case 2:
                    check = isBinary(input);
                    break;
                case 10:
                    check = isDecimal(input);
                    break;
                case 16:
                    check = isHexadecimal(input);
                    break;
                default:
                    System.out.println("Invalid!");
            }
            if (!check) {
                System.out.println("Invalid number with base " + inputBase);
            }
        } while (!check);
        return input;
    }

    //    validation
    public static boolean isValidBase(String input) {
        return (input.equals("2") || input.equals("10") || input.equals("16"));
    }

    public static boolean isBinary(String input) {
        return input.matches("^[01]+$");
    }

    public static boolean isDecimal(String input) {
        return input.matches("^[0-9]+$");
    }

    public static boolean isHexadecimal(String input) {
        return input.matches("^[0-9A-F]+$");
    }
}
