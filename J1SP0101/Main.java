package J1SP0101;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // TODO code application logic here
        EmployeeManagement em = new EmployeeManagement();
        Validation validation = new Validation();
        while (true) {
            menu();
            System.out.println("> Your choice: ");
            int choice = validation.getValidChoice(1, 6);
            switch (choice) {
                case 1:
                    while (true) {
                        Employee employee = new Employee();
                        employee.createEmployee();
                        em.addEmployee(employee);
                        System.out.print("Do you want to continue? (y/n): ");
                        if (!validation.getYN()) {
                            break;
                        }
                    }
                    break;
                case 2:
                    if (em.list.isEmpty()) {
                        System.err.println("List is empty!");
                    } else {
                        System.out.print("Input id to find: ");
                        int idE = validation.getValidInt();
                        Employee employee = validation.getEmployeeById(idE);
                        if (employee != null) {
                            Employee employee1 = new Employee();
                            employee.createUpdateEmployee(idE);
                            em.updateEmployee(employee1);
                        } else {
                            System.out.println("Not found employee!");
                        }
                    }
                    break;
                case 3:
                    if (em.list.isEmpty()) {
                        System.err.println("List is empty!");
                    } else {
                        System.out.print("Input id to find: ");
                        int idEm = validation.getValidInt();
                        Employee employee1 = validation.getEmployeeById(idEm);
                        if (employee1 != null) {
                            em.removeEmployee(employee1, idEm);
                        } else {
                            System.out.println("Not found employee!");
                        }
                    }
                    break;
                case 4:
                    if (em.list.isEmpty()) {
                        System.err.println("List is empty!");
                    } else {
                        System.out.println("Input name (or a part of name) to find: ");
                        List<Employee> el = validation.getEmployeeByName(validation.getValidString());
                        if (el.isEmpty()) {
                            System.out.println("Not found!");
                        } else {
                            em.searchEmployee(el);
                        }
                    }
                    break;
                case 5:
                    if (em.list.isEmpty()) {
                        System.err.println("List is empty!");

                    } else {
                        em.sortEmployee();
                    }
                    break;
                case 6:
                    System.out.println("Exit...");
                    System.exit(0);
                default:
                    System.out.println("Invalid!");
            }
        }
    }

    //    menu
    public static void menu() {
        System.out.println("========== Main menu ==========");
        System.out.println("1. Add employees");
        System.out.println("2. Update employees");
        System.out.println("3. Remove employees");
        System.out.println("4. Search employees");
        System.out.println("5. Sort employees by salary");
        System.out.println("6. Exit");
    }
}
