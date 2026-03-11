import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class PersonRegistry {
    private List<Person> people;
    public PersonRegistry() {
        this.people = new ArrayList<>();
    }
    public void addPerson(Person person) {
        people.add(person);
        System.out.println("Added to registry: " + person.getName());
    }
    public void removePerson(Person person) {
        if (people.remove(person)) {
            System.out.println("Removed from registry: " + person.getName());
        } else {
            System.out.println("Person not found in registry: " + person.getName());
        }
    }
    public List<Person> findPeopleWithPets() {
        return people.stream().filter(Person::hasPet).collect(Collectors.toList());
    }
    public List<Person> findPeopleWithoutPets() {
        return people.stream().filter(p -> !p.hasPet()).collect(Collectors.toList());
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("=== PersonRegistry ===\n");
        for (Person p : people) {
            sb.append("  ").append(p).append("\n");
        }
        sb.append("======================");
        return sb.toString();
    }
}
