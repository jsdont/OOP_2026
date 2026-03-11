public class TestProblem5 {
    public static void main(String[] args) {
        System.out.println("===== Problem 5: Pet Management System =====\n");
        Person john  = new Employee("John", 30, "Engineer");
        Person alice = new PhDStudent("Alice", 26, "Comp. Science", "AI");
        Person bob   = new Student("Bob", 22, "Biology");
        Animal murka = new Cat("Murka", 5);
        Animal rex   = new Dog("Rex", 3);
        Animal tweety = new Bird("Tweety", 2);
        Animal nemo  = new Fish("Nemo", 1);
        john.assignPet(murka);
        bob.assignPet(rex);
        PersonRegistry registry = new PersonRegistry();
        registry.addPerson(john);
        registry.addPerson(alice);
        registry.addPerson(bob);
        System.out.println("\nInitial state:");
        System.out.println(registry);
        System.out.println("\nJohn goes on vacation and leaves Murka with Alice:");
        john.leavePetWith(alice);
        System.out.println(registry);
        System.out.println("\nJohn returns and retrieves Murka:");
        john.retrievePetFrom(alice);
        System.out.println(registry);
        System.out.println("\nTesting PhD restriction - Bob tries to leave Rex with Alice:");
        try {
            bob.leavePetWith(alice);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }
        System.out.println("\nAlice can accept a Bird:");
        alice.assignPet(tweety);
        System.out.println(alice);
        System.out.println("\nPeople WITH pets:");
        registry.findPeopleWithPets().forEach(p -> System.out.println("  " + p.getName()));
        System.out.println("People WITHOUT pets:");
        registry.findPeopleWithoutPets().forEach(p -> System.out.println("  " + p.getName()));
        System.out.println("\nTrying to leave pet with someone who already has one:");
        try {
            john.leavePetWith(alice); 
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }
        alice.removePet();
        System.out.println("\nTrying to directly assign a Dog to Alice (PhD student):");
        try {
            alice.assignPet(rex);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }
        System.out.println("\nTrying to retrieve pet from someone with no pet:");
        try {
            john.retrievePetFrom(alice);
        } catch (IllegalStateException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }
        System.out.println("\nFinal state of registry:");
        System.out.println(registry);
    }
}
