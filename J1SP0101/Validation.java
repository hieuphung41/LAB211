package J1SP0101;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Validation {

    Scanner scanner = new Scanner(System.in);
    EmployeeManagement em = new EmployeeManagement();
    List<Employee> list = em.list;

    public int getValidChoice(int min, int max) {
        while (true) {
            try {
                int x = Integer.parseInt(scanner.nextLine().trim());
                if (x < min || x > max) {
                    throw new NumberFormatException();
                }
                return x;
            } catch (NumberFormatException e) {
                System.err.println("Input choice must in [" + min + ", " + max + "]!");
                System.out.print("Input again: ");
            }
        }
    }

    public int getValidId(List<Employee> list) {
        while (true) {
            try {
                int id = Integer.parseInt(scanner.nextLine().trim());
                if (id <= 0) {
                    throw new NumberFormatException();
                }
                for (Employee x : list) {
                    if (x.getId() == id) {
                        throw new NumberFormatException();
                    }
                }
                return id;
            } catch (NumberFormatException e) {
                System.err.println("Id must be a positive integer!");
                System.out.print("Input again: ");
            }
        }
    }

    public String getValidSex() {
        while (true) {
            try {
                String str = scanner.nextLine();
                if (str.equalsIgnoreCase("man") || str.equalsIgnoreCase("woman")) {
                    return str;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.err.println("Only man or woman!");
                System.out.print("Input again: ");
            }
        }
    }

    public Date getValidDate() {
        while (true) {
            try {
                String str = scanner.nextLine();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                dateFormat.setLenient(false);
                Date date = dateFormat.parse(str);
                return date;
            } catch (ParseException e) {
                System.err.println("Invalid format!");
                System.out.print("Input again (dd/MM/yyyy): ");
            }
        }
    }

    public boolean getYN() {
        while (true) {
            try {
                String str = scanner.nextLine();
                if (str.equalsIgnoreCase("y")) {
                    return true;
                } else if (str.equalsIgnoreCase("n")) {
                    return false;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.err.println("Only y (yes) or n (no)!");
                System.out.print("Input again: ");
            }
        }
    }

    public Employee getEmployeeById(int id) {
        for (Employee x : list) {
            if (x.getId() == id) {
                return x;
            }
        }
        return null;
    }

    public List<Employee> getEmployeeByName(String str) {
        List<Employee> el = new ArrayList<>();
        for (Employee x : list) {
            if (x.getFirstName().contains(str) || x.getLastName().contains(str)) {
                el.add(x);
            }
        }
        if (!el.isEmpty()) {
            return el;
        }
        return null;
    }

    public String getValidString() {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                if (!input.isEmpty()) {
                    return input;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.err.println("Invalid string!");
                System.out.print("Input again: ");
            }
        }
    }

    public double getValidDouble() {
        while (true) {
            try {
                double tmp = Double.parseDouble(scanner.nextLine());
                if (tmp > 0) {
                    return tmp;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid double!");
                System.out.print("Input again: ");
            }
        }
    }

    public int getValidInt() {
        while (true) {
            try {
                int tmp = Integer.parseInt(scanner.nextLine());
                return tmp;
            } catch (NumberFormatException e) {
                System.err.println("Invalid double!");
                System.out.print("Input again: ");
            }
        }
    }

}
