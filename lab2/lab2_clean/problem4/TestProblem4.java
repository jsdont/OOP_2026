public class TestProblem4 {
    public static void main(String[] args) {
        System.out.println("===== Problem 4: Electrical Circuit System =====\n");
        Circuit a = new Resistor(3.0);
        Circuit b = new Resistor(3.0);
        Circuit c = new Resistor(6.0);
        Circuit d = new Resistor(3.0);
        Circuit e = new Resistor(2.0);
        Circuit f = new Series(a, b);           
        Circuit g = new Parallel(c, d);         
        Circuit h = new Series(g, e);           
        Circuit circuit = new Parallel(h, f);   
        double R = circuit.getResistance();
        System.out.printf("Equivalent Resistance: %.4f Ω  (expected ~2.4 Ω)%n%n", R);
        double voltage = 12.0;
        circuit.applyPotentialDiff(voltage);
        System.out.printf("Applied Voltage: %.2f V%n", voltage);
        System.out.printf("Total Current:   %.4f A%n", circuit.getCurrent());
        System.out.printf("Total Power:     %.4f W%n%n", circuit.getPower());
        System.out.println("Sub-circuit details after applying 12V:");
        System.out.println("  " + circuit);
        System.out.println("  Branch h (series g+e): " + h);
        System.out.println("  Branch f (series a+b): " + f);
        System.out.println("  g (parallel c||d): " + g);
        System.out.println("  e (resistor 2Ω):   " + e);
        System.out.println("  a (resistor 3Ω):   " + a);
        System.out.println("  b (resistor 3Ω):   " + b);
        System.out.println("  c (resistor 6Ω):   " + c);
        System.out.println("  d (resistor 3Ω):   " + d);
        System.out.println("\n--- Standalone Tests ---");
        Resistor r1 = new Resistor(10.0);
        r1.applyPotentialDiff(5.0);
        System.out.printf("Single 10Ω resistor @ 5V -> I=%.2fA, P=%.2fW%n",
                r1.getCurrent(), r1.getPower());
        Series series = new Series(new Resistor(4.0), new Resistor(6.0));
        series.applyPotentialDiff(10.0);
        System.out.printf("Series 4Ω+6Ω @ 10V -> R=%.2fΩ, I=%.2fA%n",
                series.getResistance(), series.getCurrent());
        Parallel parallel = new Parallel(new Resistor(4.0), new Resistor(4.0));
        parallel.applyPotentialDiff(8.0);
        System.out.printf("Parallel 4Ω||4Ω @ 8V -> R=%.2fΩ, I=%.2fA%n",
                parallel.getResistance(), parallel.getCurrent());
    }
}
