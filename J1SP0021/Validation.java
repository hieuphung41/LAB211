package J1SP0021;

import java.util.Scanner;

public class Validation {
    private Scanner scanner = new Scanner(System.in);
    private StudentManagement sm = new StudentManagement();

    public int getInt() {
        while (true) {
            try {
                int x = Integer.parseInt(scanner.nextLine());
                if (x > 0) {
                    return x;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid positive integer!");
                System.out.print("Input again: ");
            }
        }
    }

    public int getIntInRange(int min, int max) {
        while (true) {
            try {
                int x = Integer.parseInt(scanner.nextLine());
                if (x >= min && x <= max) {
                    return x;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid positive integer!");
                System.out.print("Input again: ");
            }
        }
    }

    public String getValidName(int id) {
        while (true) {
            try {
                String str = scanner.nextLine().trim();
                for (Student x : sm.studentList) {
                    if (x.getId() == id && x.getName().equals(str)) {
                        return str;
                    } else if (x.getId() == id && !x.getName().equals(str)) {
                        throw new IllegalArgumentException();
                    }
                }
                return str;
            } catch (IllegalArgumentException e) {
                System.err.println("Invalid string!");
                System.out.print("Input again: ");
            }
        }
    }

    public String getCourse() {
        while (true) {
            try {
                String str = scanner.nextLine().trim();
                if (str.equals("Java") || str.equals(".Net") || str.equals("C/C++")) {
                    return str;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.err.println("Invalid course!");
                System.out.print("Input again: ");
            }
        }
    }

    public String getString() {
        while (true) {
            try {
                String str = scanner.nextLine().trim();
                if (!str.isEmpty()) {
                    return str;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.err.println("Invalid course!");
                System.out.print("Input again: ");
            }
        }
    }

    public boolean getYN() {
        while (true) {
            try {
                String str = scanner.nextLine().trim();
                if (str.equalsIgnoreCase("y")) {
                    return true;
                } else if (str.equalsIgnoreCase("n")) {
                    return false;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.err.println("Invalid choice!");
                System.out.print("Input again: ");
            }
        }
    }

    public String getUD() {
        while (true) {
            try {
                String str = scanner.nextLine().trim();
                if (str.equalsIgnoreCase("u")) {
                    return "u";
                } else if (str.equalsIgnoreCase("d")) {
                    return "d";
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.err.println("Invalid choice!");
                System.out.print("Input again: ");
            }
        }
    }
}
