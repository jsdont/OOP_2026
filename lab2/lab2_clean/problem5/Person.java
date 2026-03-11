import java.util.Objects;
public abstract class Person {
    private String name;
    private int age;
    private Animal pet;
    public Person(String name, int age) {
        this.name = name;
        this.age  = age;
        this.pet  = null;
    }
    public void assignPet(Animal pet) {
        this.pet = pet;
    }
    public void removePet() {
        this.pet = null;
    }
    public boolean hasPet() {
        return pet != null;
    }
    public Animal getPet() { return pet; }
    public void leavePetWith(Person caretaker) {
        if (!hasPet()) {
            throw new IllegalStateException(name + " does not have a pet to leave.");
        }
        if (caretaker.hasPet()) {
            throw new IllegalArgumentException(caretaker.getName() + " already has a pet.");
        }
        Animal myPet = this.pet;
        caretaker.assignPet(myPet);   
        this.pet = null;
        System.out.printf("%s left %s with %s.%n", name, myPet.getName(), caretaker.getName());
    }
    public void retrievePetFrom(Person caretaker) {
        if (hasPet()) {
            throw new IllegalStateException(name + " already has a pet.");
        }
        if (!caretaker.hasPet()) {
            throw new IllegalStateException(caretaker.getName() + " does not have a pet to return.");
        }
        Animal returnedPet = caretaker.getPet();
        caretaker.removePet();
        this.pet = returnedPet;
        System.out.printf("%s retrieved %s from %s.%n", name, returnedPet.getName(), caretaker.getName());
    }
    public abstract String getOccupation();
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    @Override
    public String toString() {
        String petInfo = hasPet() ? "pet=" + pet.toString() : "no pet";
        return String.format("%s('%s', age=%d, occupation=%s, %s)",
                getClass().getSimpleName(), name, age, getOccupation(), petInfo);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person p = (Person) o;
        return age == p.age && Objects.equals(name, p.name)
               && getClass() == p.getClass();
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, age, getClass());
    }
}
