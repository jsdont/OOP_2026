import gradebook.Course;
import gradebook.GradeBook;
import students.Student;
import java.util.Scanner;
public class GradeBookTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Course course = new Course("CS101", "Object-oriented Programming and Design", 3);
        String[] names = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        GradeBook gradeBook = new GradeBook(course);
        gradeBook.displayMessage();
        System.out.println("Please, input grades for students:");
        for (int i = 0; i < names.length; i++) {
            double grade = -1;
            while (grade < 0 || grade > 100) {
                System.out.print("Student " + names[i] + ": ");
                try {
                    grade = Double.parseDouble(scanner.nextLine().trim());
                    if (grade < 0 || grade > 100) {
                        System.out.println("Grade must be between 0 and 100.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Enter a number between 0 and 100.");
                }
            }
            gradeBook.addStudent(new Student(names[i], i + 1, grade));
        }
        gradeBook.displayGradeReport();
        scanner.close();
    }
}
