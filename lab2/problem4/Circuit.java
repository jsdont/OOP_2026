public abstract class Circuit {
    public abstract double getResistance();
    public abstract double getPotentialDiff();
    public abstract void applyPotentialDiff(double v);
    public double getPower() {
        double r = getResistance();
        double v = getPotentialDiff();
        if (r == 0) return 0;
        return (v * v) / r;
    }
    public double getCurrent() {
        double r = getResistance();
        if (r == 0) return 0;
        return getPotentialDiff() / r;
    }
}
