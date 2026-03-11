package students;

public class Student {
    private String name;
    private int id;
    private double grade;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.grade = 0.0;
    }

    public Student(String name, int id, double grade) {
        this.name = name;
        this.id = id;
        setGrade(grade);
    }

    public String getName() { return name; }
    public int getId()      { return id; }
    public double getGrade(){ return grade; }

    public void setGrade(double grade) {
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Grade must be between 0 and 100.");
        }
        this.grade = grade;
    }

    @Override
    public String toString() {
        return String.format("Student[name=%s, id=%d, grade=%.1f]", name, id, grade);
    }
}
