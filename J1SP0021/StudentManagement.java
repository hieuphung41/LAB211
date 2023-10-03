package J1SP0021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class StudentManagement {
    ArrayList<Student> studentList = new ArrayList<>();

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void findAndSort(String str) {
        StudentManagement result = findStudentByName(str);
        if (!result.studentList.isEmpty()) {
            result.sort();
            result.studentList.forEach((x) -> {
                System.out.println(x.toString());
            });
        } else {
            System.err.println("Not found!");
        }
    }

    public void sort() {
        Collections.sort(studentList, (Student o1, Student o2) -> {
            if (o1.getId() < o2.getId()) {
                return -1;
            } else if (o1.getId() > o2.getId()) {
                return 1;
            } else {
                return 0;
            }
        });
    }

    public void updateStudent(Student student) {
        for (Student x : studentList) {
            if (x.getId() == student.getId()) {
                x.setName(student.getName());
                x.setSemester(student.getSemester());
                x.setCourse(student.getCourse());
            }
        }
        System.err.println("Updated successfully!");
    }

    public void deleteStudent(Student student) {
        studentList.remove(student);
        System.err.println("Deleted successfully!");
    }

    public void report() {
        HashMap<String, Integer> reports = new HashMap<>();
        for (Student x : studentList) {
            String key = x.getId() + "#" + x.getName() + "|" + x.getCourse();
            if (reports.containsKey(key)) {
                int total = reports.get(key);
                reports.put(key, total + 1);
            } else {
                reports.put(key, 1);
            }
        }
        for (String key : reports.keySet()) {
            System.out.println(key.split("#")[1] + "|" + reports.get(key));
        }
    }

    private StudentManagement findStudentByName(String str) {
        StudentManagement result = new StudentManagement();
        for (Student x : studentList) {
            if (x.getName().contains(str)) {
                result.addStudent(x);
            }
        }
        return result;
    }


    public Student findStudentById(int id) {
        for (Student x : studentList) {
            if (x.getId() == id) {
                return x;
            }
        }
        return null;
    }

    private boolean isExistID(int id) {
        for (Student x : studentList) {
            if (x.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
