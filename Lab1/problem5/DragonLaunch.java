import java.util.Vector;
public class DragonLaunch {
    private Vector<Person> prisoners = new Vector<>();
    public void kidnap(Person p) {
        prisoners.add(p);
        System.out.println("Kidnapped: " + p);
    }
    public int willDragonEatOrNot() {
        int pendingBoys = 0;   
        int remaining = 0;     
        for (Person p : prisoners) {
            if (p.getGender() == Gender.BOY) {
                pendingBoys++;
            } else {
                if (pendingBoys > 0) {
                    pendingBoys--; 
                } else {
                    remaining++; 
                }
            }
        }
        remaining += pendingBoys; 
        return remaining;
    }
    public void showLine() {
        System.out.print("Current line: ");
        for (Person p : prisoners) System.out.print(p + " ");
        System.out.println();
    }
    public static void main(String[] args) {
        DragonLaunch d1 = new DragonLaunch();
        d1.kidnap(new Person("B1", Gender.BOY));
        d1.kidnap(new Person("B2", Gender.BOY));
        d1.kidnap(new Person("G1", Gender.GIRL));
        d1.kidnap(new Person("G2", Gender.GIRL));
        d1.showLine();
        System.out.println("People left for lunch: " + d1.willDragonEatOrNot());
        System.out.println("Dragon eats? " + (d1.willDragonEatOrNot() > 0 ? "YES" : "NO"));
        System.out.println();
        DragonLaunch d2 = new DragonLaunch();
        d2.kidnap(new Person("G1", Gender.GIRL));
        d2.kidnap(new Person("B1", Gender.BOY));
        d2.kidnap(new Person("G2", Gender.GIRL));
        d2.kidnap(new Person("B2", Gender.BOY));
        d2.showLine();
        System.out.println("People left for lunch: " + d2.willDragonEatOrNot());
        System.out.println("Dragon eats? " + (d2.willDragonEatOrNot() > 0 ? "YES" : "NO"));
        System.out.println();
        DragonLaunch d3 = new DragonLaunch();
        d3.kidnap(new Person("B1", Gender.BOY));
        d3.kidnap(new Person("G1", Gender.GIRL));
        d3.kidnap(new Person("B2", Gender.BOY));
        d3.kidnap(new Person("G2", Gender.GIRL));
        d3.showLine();
        System.out.println("People left for lunch: " + d3.willDragonEatOrNot());
        System.out.println("Dragon eats? " + (d3.willDragonEatOrNot() > 0 ? "YES" : "NO"));
    }
}
