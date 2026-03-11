public class Resistor extends Circuit {
    private double resistance;
    private double potentialDifference;
    public Resistor(double resistance) {
        this.resistance = resistance;
        this.potentialDifference = 0.0;
    }
    @Override
    public double getResistance() { return resistance; }
    @Override
    public double getPotentialDiff() { return potentialDifference; }
    @Override
    public void applyPotentialDiff(double v) {
        this.potentialDifference = v;
    }
    @Override
    public String toString() {
        return String.format("Resistor(%.1fΩ, V=%.2fV, I=%.4fA, P=%.4fW)",
                resistance, potentialDifference, getCurrent(), getPower());
    }
}
