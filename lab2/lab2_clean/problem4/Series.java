public class Series extends Circuit {
    private Circuit first;
    private Circuit second;
    public Series(Circuit first, Circuit second) {
        this.first  = first;
        this.second = second;
    }
    @Override
    public double getResistance() {
        return first.getResistance() + second.getResistance();
    }
    @Override
    public double getPotentialDiff() {
        return first.getPotentialDiff() + second.getPotentialDiff();
    }
    @Override
    public void applyPotentialDiff(double v) {
        double totalR = getResistance();
        if (totalR == 0) return;
        double current = v / totalR;
        first.applyPotentialDiff(current * first.getResistance());
        second.applyPotentialDiff(current * second.getResistance());
    }
    @Override
    public String toString() {
        return String.format("Series(R=%.4fΩ, V=%.2fV, I=%.4fA, P=%.4fW)",
                getResistance(), getPotentialDiff(), getCurrent(), getPower());
    }
}
