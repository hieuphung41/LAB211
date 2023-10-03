package J1SP0021;

public class Student {
    private int id;
    private String name;
    private int semester;
    private String course;

    public Student() {
    }

    public Student(int id, String name, int semester, String course) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return name + " - " + semester + " - " + course;
    }

    private Validation validation = new Validation();

    public Student createStudent() {
        System.out.print("Input id: ");
        this.id = validation.getInt();
        System.out.print("Input name: ");
        this.name = validation.getValidName(this.id);
        System.out.print("Input semester: ");
        this.semester = validation.getInt();
        System.out.print("Input course name: ");
        this.course = validation.getCourse();
        return this;
    }

    public Student updateInfo(int id) {
        this.id = id;
        System.out.print("Input name: ");
        this.name = validation.getValidName(this.id);
        System.out.print("Input semester: ");
        this.semester = validation.getInt();
        System.out.print("Input course name: ");
        this.course = validation.getCourse();
        return this;
    }
}
