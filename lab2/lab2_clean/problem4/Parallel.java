public class Parallel extends Circuit {
    private Circuit first;
    private Circuit second;
    public Parallel(Circuit first, Circuit second) {
        this.first  = first;
        this.second = second;
    }
    @Override
    public double getResistance() {
        double r1 = first.getResistance();
        double r2 = second.getResistance();
        if (r1 + r2 == 0) return 0;
        return (r1 * r2) / (r1 + r2);
    }
    @Override
    public double getPotentialDiff() {
        return first.getPotentialDiff();
    }
    @Override
    public void applyPotentialDiff(double v) {
        first.applyPotentialDiff(v);
        second.applyPotentialDiff(v);
    }
    @Override
    public String toString() {
        return String.format("Parallel(R=%.4fΩ, V=%.2fV, I=%.4fA, P=%.4fW)",
                getResistance(), getPotentialDiff(), getCurrent(), getPower());
    }
}
