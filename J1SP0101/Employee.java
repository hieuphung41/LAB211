package J1SP0101;

import java.util.Date;

public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private Date DOB;
    private String sex;
    private double salary;
    private String agency;

    public Employee() {
    }

    public Employee(int id, String firstName, String lastName, String phone, String email, String address, Date DOB, String sex, double salary, String agency) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.DOB = DOB;
        this.sex = sex;
        this.salary = salary;
        this.agency = agency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    Validation validation = new Validation();
    EmployeeManagement em = new EmployeeManagement();

    public Employee createEmployee() {
        System.out.print("Input id: ");
        this.setId(validation.getValidId(em.list));
        System.out.print("Input first name: ");
        this.setFirstName(validation.getValidString());
        System.out.print("Input last name: ");
        this.setLastName(validation.getValidString());
        System.out.print("Input phone: ");
        this.setPhone(validation.getValidString());
        System.out.print("Input email: ");
        this.setEmail(validation.getValidString());
        System.out.print("Input address: ");
        this.setAddress(validation.getValidString());
        System.out.print("Input date of birth: ");
        this.setDOB(validation.getValidDate());
        System.out.print("Input sex: ");
        this.setSex(validation.getValidSex());
        System.out.print("Input salary: ");
        this.setSalary(validation.getValidDouble());
        System.out.print("Input agency: ");
        this.setAgency(validation.getValidString());
        return this;
    }

    public Employee createUpdateEmployee(int id) {
        this.setId(id);
        System.out.print("Input first name: ");
        this.setFirstName(validation.getValidString());
        System.out.print("Input last name: ");
        this.setLastName(validation.getValidString());
        System.out.print("Input phone: ");
        this.setPhone(validation.getValidString());
        System.out.print("Input email: ");
        this.setEmail(validation.getValidString());
        System.out.print("Input address: ");
        this.setAddress(validation.getValidString());
        System.out.print("Input date of birth: ");
        this.setDOB(validation.getValidDate());
        System.out.print("Input sex: ");
        this.setSex(validation.getValidSex());
        System.out.print("Input salary: ");
        this.setSalary(validation.getValidDouble());
        System.out.print("Input agency: ");
        this.setAgency(validation.getValidString());
        return this;
    }
}
