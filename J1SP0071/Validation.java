package J1SP0071;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validation {

    private Scanner scanner = new Scanner(System.in);

    public int getIntInRange(int min, int max) {
        while (true) {
            try {
                int num = Integer.parseInt(scanner.nextLine());
                if (num >= min && num <= max) {
                    return num;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid integer in range [" + min + ", " + max + "]!");
                System.out.print("Input again: ");
            }
        }
    }

    public Date getValidDate() {
        while (true) {
            try {
                String str = scanner.nextLine();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                dateFormat.setLenient(false);
                Date date = dateFormat.parse(str);
                return date;
            } catch (ParseException e) {
                System.err.println("Invalid format!");
                System.out.print("Input again (dd-MM-yyyy): ");
            }
        }
    }

    public int getInt() {
        while (true) {
            try {
                int num = Integer.parseInt(scanner.nextLine());
                if (num > 0) {
                    return num;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid positive integer!");
                System.out.print("Input again: ");
            }
        }
    }

    public String getValidTaskType() {
        while (true) {
            try {
                String input = scanner.nextLine();
                if (input.equals("Code") || input.equals("Test") || input.equals("Design") || input.equals("Review"))
                    return input;
                else throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid task type! It must be Code or Test or Design or Review!");
                System.out.print("Input again: ");
            }
        }
    }

    public double getDouble() {
        while (true) {
            String result = getString();
            if (result.matches("^[0-9]{1,2}\\.5|[0-9]{1,2}\\.0$") && Double.parseDouble(result) >= 8.0
                    && Double.parseDouble(result) <= 17.5) {
                return Double.parseDouble(result);
            } else {
                System.err.println("Re-input in [8.0, 17.5]: ");
            }
        }
    }

    public String getString() {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                if (!input.isEmpty()) return input;
                else throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid string!");
                System.out.print("Input again: ");
            }
        }
    }

}
