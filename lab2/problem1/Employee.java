import java.util.Objects;
public class Employee extends Person {
    private String employeeId;
    private String department;
    public Employee(String name, int age, String employeeId, String department) {
        super(name, age);
        this.employeeId = employeeId;
        this.department = department;
    }
    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    @Override
    public String toString() {
        return String.format("Employee{name='%s', age=%d, id='%s', dept='%s'}",
                getName(), getAge(), employeeId, department);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employeeId, employee.employeeId);
    }
    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }
}
