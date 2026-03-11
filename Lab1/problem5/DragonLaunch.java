// ─── Gender.java ───────────────────────────────────────────────────────────
enum Gender {
    BOY, GIRL
}


// ─── Person.java ────────────────────────────────────────────────────────────
class Person {
    private String name;
    private Gender gender;

    public Person(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public Gender getGender() { return gender; }
    public String getName()   { return name; }

    @Override
    public String toString() {
        return name + "(" + (gender == Gender.BOY ? "B" : "G") + ")";
    }
}


// ─── DragonLaunch.java ──────────────────────────────────────────────────────
import java.util.Vector;

public class DragonLaunch {

    private Vector<Person> prisoners = new Vector<>();

    public void kidnap(Person p) {
        prisoners.add(p);
        System.out.println("Kidnapped: " + p);
    }

    /**
     * Determines how many people remain after all B-G pairs vanish.
     * Runs in O(n) time using a counter — no extra data structures.
     *
     * Logic: iterate left-to-right keeping a "pending boys" counter.
     * When we see a BOY  → increment counter.
     * When we see a GIRL → if counter > 0, a B-G pair vanishes (decrement),
     *                      otherwise the girl stays (increment remaining count).
     * Remaining = pendingBoys + remainingGirls
     */
    public int willDragonEatOrNot() {
        int pendingBoys = 0;   // boys waiting for a girl to their right
        int remaining = 0;     // girls with no boy to their left

        for (Person p : prisoners) {
            if (p.getGender() == Gender.BOY) {
                pendingBoys++;
            } else {
                // GIRL
                if (pendingBoys > 0) {
                    pendingBoys--; // this girl and the nearest unpaired boy vanish
                } else {
                    remaining++; // no boy before her — she stays
                }
            }
        }

        remaining += pendingBoys; // boys that never found a girl to their right stay
        return remaining;
    }

    public void showLine() {
        System.out.print("Current line: ");
        for (Person p : prisoners) System.out.print(p + " ");
        System.out.println();
    }

    // ── main ────────────────────────────────────────────────────────────────
    public static void main(String[] args) {
        // Test 1: BBGG → 0 remain (no launch)
        DragonLaunch d1 = new DragonLaunch();
        d1.kidnap(new Person("B1", Gender.BOY));
        d1.kidnap(new Person("B2", Gender.BOY));
        d1.kidnap(new Person("G1", Gender.GIRL));
        d1.kidnap(new Person("G2", Gender.GIRL));
        d1.showLine();
        System.out.println("People left for lunch: " + d1.willDragonEatOrNot());
        System.out.println("Dragon eats? " + (d1.willDragonEatOrNot() > 0 ? "YES" : "NO"));

        System.out.println();

        // Test 2: GBGB → 2 remain (G stays, B stays, G stays, B stays)
        DragonLaunch d2 = new DragonLaunch();
        d2.kidnap(new Person("G1", Gender.GIRL));
        d2.kidnap(new Person("B1", Gender.BOY));
        d2.kidnap(new Person("G2", Gender.GIRL));
        d2.kidnap(new Person("B2", Gender.BOY));
        d2.showLine();
        System.out.println("People left for lunch: " + d2.willDragonEatOrNot());
        System.out.println("Dragon eats? " + (d2.willDragonEatOrNot() > 0 ? "YES" : "NO"));

        System.out.println();

        // Test 3: BGBG → 0 remain
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
