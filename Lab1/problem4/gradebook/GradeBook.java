package gradebook;
import students.Student;
import java.util.ArrayList;
public class GradeBook {
    private Course course;
    private ArrayList<Student> students;
    public GradeBook(Course course) {
        this.course = course;
        this.students = new ArrayList<>();
    }
    public GradeBook(Course course, ArrayList<Student> students) {
        this.course = course;
        this.students = new ArrayList<>(students);
    }
    public void addStudent(Student s) {
        students.add(s);
    }
    public void displayMessage() {
        System.out.println("Welcome to the grade book for " + course.getName()
                + " " + course.getDescription() + "!");
    }
    public double determineClassAverage() {
        if (students.isEmpty()) return 0.0;
        double total = 0;
        for (Student s : students) total += s.getGrade();
        return total / students.size();
    }
    private Student getMinStudent() {
        if (students.isEmpty()) return null;
        Student min = students.get(0);
        for (Student s : students) {
            if (s.getGrade() < min.getGrade()) min = s;
        }
        return min;
    }
    private Student getMaxStudent() {
        if (students.isEmpty()) return null;
        Student max = students.get(0);
        for (Student s : students) {
            if (s.getGrade() > max.getGrade()) max = s;
        }
        return max;
    }
    public void outputBarChart() {
        System.out.println("Grades distribution:");
        int[] buckets = new int[11]; 
        for (Student s : students) {
            int grade = (int) s.getGrade();
            int index = Math.min(grade / 10, 10);
            buckets[index]++;
        }
        for (int i = 0; i <= 9; i++) {
            System.out.printf("%02d-%02d: ", i * 10, i * 10 + 9);
            for (int j = 0; j < buckets[i]; j++) System.out.print("*");
            System.out.println();
        }
        System.out.print("100:  ");
        for (int j = 0; j < buckets[10]; j++) System.out.print("*");
        System.out.println();
    }
    public void displayGradeReport() {
        System.out.println("\nPlease, input grades for students:");
        for (Student s : students) {
            System.out.printf("Student %s: %3.0f%n", s.getName(), s.getGrade());
        }
        double avg = determineClassAverage();
        Student minS = getMinStudent();
        Student maxS = getMaxStudent();
        System.out.printf("%nClass average is %.2f.%n", avg);
        if (minS != null) {
            System.out.printf("Lowest grade is %.0f (Student %s, id:%d).%n",
                    minS.getGrade(), minS.getName(), minS.getId());
        }
        if (maxS != null) {
            System.out.printf("Highest grade is %.0f (Student %s, id:%d).%n",
                    maxS.getGrade(), maxS.getName(), maxS.getId());
        }
        outputBarChart();
    }
    @Override
    public String toString() {
        return "GradeBook[course=" + course.getName() + ", students=" + students.size() + "]";
    }
}
