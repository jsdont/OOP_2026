import java.util.HashSet;
public class TestProblem1 {
    public static void main(String[] args) {
        System.out.println("===== Part A: 3D Shapes =====");
        Shape3D cylinder = new Cylinder(3.0, 7.0);
        Shape3D sphere   = new Sphere(5.0);
        Shape3D cube     = new Cube(4.0);
        System.out.println(cylinder);
        System.out.println(sphere);
        System.out.println(cube);
        System.out.println("\n===== Part B: Library System =====");
        Book book1 = new Book("Clean Code", "Robert C. Martin", 2008, 431, "978-0132350884", "Programming");
        Book book2 = new Book("The Hobbit", "J.R.R. Tolkien", 1937, 310);
        System.out.println(book1);
        System.out.println(book2);
        System.out.println("Genre of book1: " + book1.getGenre());
        System.out.println("Pages in book2: " + book2.getNumberOfPages());
        System.out.println("\n===== Part C: Superclass and Subclass =====");
        HashSet<Person> personSet = new HashSet<>();
        Person p1 = new Person("Alice", 30);
        Person p2 = new Person("Alice", 30); 
        Person p3 = new Person("Bob", 25);
        personSet.add(p1);
        personSet.add(p2); 
        personSet.add(p3);
        System.out.println("Person HashSet size (expected 2): " + personSet.size());
        personSet.forEach(System.out::println);
        HashSet<Employee> employeeSet = new HashSet<>();
        Employee e1 = new Employee("Carol", 28, "EMP001", "Engineering");
        Employee e2 = new Employee("Carol", 35, "EMP001", "HR"); 
        Employee e3 = new Employee("Dave",  40, "EMP002", "Finance");
        employeeSet.add(e1);
        employeeSet.add(e2); 
        employeeSet.add(e3);
        System.out.println("\nEmployee HashSet size (expected 2): " + employeeSet.size());
        employeeSet.forEach(System.out::println);
        System.out.println("\np1.equals(p2): " + p1.equals(p2)); 
        System.out.println("e1.equals(e2): " + e1.equals(e2)); 
        System.out.println("e1.equals(e3): " + e1.equals(e3)); 
    }
}
