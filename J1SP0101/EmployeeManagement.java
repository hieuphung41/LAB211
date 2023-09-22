package J1SP0101;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeManagement {

    List<Employee> list = new ArrayList<>();

    public void addEmployee(Employee employee) {
        list.add(employee);
        System.out.println("Added successfully");
    }

    public void updateEmployee(Employee employee) {
        for (Employee x : list) {
            if (x.getId() == employee.getId()) {
                x.setFirstName(employee.getFirstName());
                x.setLastName(employee.getLastName());
                x.setPhone(employee.getPhone());
                x.setEmail(employee.getEmail());
                x.setAddress(employee.getAddress());
                x.setDOB(employee.getDOB());
                x.setSex(employee.getSex());
                x.setSalary(employee.getSalary());
                x.setAgency(employee.getAgency());
            }
        }
        System.out.println("Updated successfully!");
    }

    public void removeEmployee(Employee employee, int id) {
        for (Employee x : list) {
            if (x.getId() == id) {
                list.remove(x);
                break;
            }
        }
        System.out.println("Removed successfully!");
    }

    public void searchEmployee(List<Employee> el) {
        System.out.println("ID\t\tFirst Name\t\tLast Name\t\tPhone\t\tEmail\t\tAddress\t\tDOB\t\tSex\t\tSalary\t\tAgency");
        for (Employee x : el) {
            System.out.println(x.getId() + "\t\t"
                    + x.getFirstName() + "\t\t"
                    + x.getLastName() + "\t\t"
                    + x.getPhone() + "\t\t"
                    + x.getEmail() + "\t\t"
                    + x.getAddress() + "\t\t"
                    + x.getDOB() + "\t\t"
                    + x.getSex() + "\t\t"
                    + x.getSalary() + "\t\t"
                    + x.getAgency());
        }
    }

    public void sortEmployee() {
        Collections.sort(list, (Employee o1, Employee o2) -> {
            if (o1.getSalary() < o2.getSalary()) {
                return -1;
            } else if (o1.getSalary() > o2.getSalary()) {
                return 1;
            }
            return 0;
        });
        System.out.println("ID\t\tFirst Name\t\tLast Name\t\tPhone\t\tEmail\t\tAddress\t\tDOB\t\tSex\t\tSalary\t\tAgency");
        for (Employee x : list) {
            System.out.println(x.getId() + "\t\t"
                    + x.getFirstName() + "\t\t"
                    + x.getLastName() + "\t\t"
                    + x.getPhone() + "\t\t"
                    + x.getEmail() + "\t\t"
                    + x.getAddress() + "\t\t"
                    + x.getDOB() + "\t\t"
                    + x.getSex() + "\t\t"
                    + x.getSalary() + "\t\t"
                    + x.getAgency());
        }
    }
}
