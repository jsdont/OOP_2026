public class Temperature {

    private double degrees;
    private char scale;

    // Default constructor: 0 degrees Celsius
    public Temperature() {
        this.degrees = 0.0;
        this.scale = 'C';
    }

    // Constructor with only value (default scale = Celsius)
    public Temperature(double degrees) {
        this.degrees = degrees;
        this.scale = 'C';
    }

    // Constructor with only scale (default value = 0)
    public Temperature(char scale) {
        this.degrees = 0.0;
        setScale(scale);
    }

    // Constructor with both parameters
    public Temperature(double degrees, char scale) {
        this.degrees = degrees;
        setScale(scale);
    }

    // Return temperature in Celsius
    public double getCelsius() {
        if (scale == 'C') {
            return degrees;
        } else {
            return 5.0 * (degrees - 32) / 9.0;
        }
    }

    // Return temperature in Fahrenheit
    public double getFahrenheit() {
        if (scale == 'F') {
            return degrees;
        } else {
            return (9.0 * degrees / 5.0) + 32;
        }
    }

    // Set only the value
    public void setValue(double degrees) {
        this.degrees = degrees;
    }

    // Set only the scale
    public void setScale(char scale) {
        if (scale != 'C' && scale != 'F') {
            throw new IllegalArgumentException("Scale must be 'C' or 'F'.");
        }
        this.scale = scale;
    }

    // Set both value and scale
    public void set(double degrees, char scale) {
        setValue(degrees);
        setScale(scale);
    }

    // Return the scale character
    public char getScale() {
        return scale;
    }

    @Override
    public String toString() {
        return degrees + " degrees " + (scale == 'C' ? "Celsius" : "Fahrenheit");
    }

    public static void main(String[] args) {
        Temperature t1 = new Temperature();
        Temperature t2 = new Temperature(100.0);
        Temperature t3 = new Temperature('F');
        Temperature t4 = new Temperature(32.0, 'F');

        System.out.println(t1 + " -> in F: " + t1.getFahrenheit());
        System.out.println(t2 + " -> in F: " + t2.getFahrenheit());
        System.out.println(t3 + " -> in C: " + t3.getCelsius());
        System.out.println(t4 + " -> in C: " + t4.getCelsius());

        t4.set(212.0, 'F');
        System.out.println("Updated: " + t4 + " -> in C: " + t4.getCelsius());
    }
}
