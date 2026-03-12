public class Data {
    private double sum;
    private double max;
    private int count;
    public Data() {
        sum = 0.0;
        max = Double.NEGATIVE_INFINITY;
        count = 0;
    }
    public void add(double value) {
        sum += value;
        count++;
        if (value > max) {
            max = value;
        }
    }
    public double getAverage() {
        if (count == 0) return 0;
        return sum / count;
    }
    public double getMax() {
        return max;
    }
}
