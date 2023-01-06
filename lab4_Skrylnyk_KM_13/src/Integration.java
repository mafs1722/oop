public class Integration {
    public double result = 0;
    public static double f(double x) {
        return x + 4;
    }

    public Integration(double a, double b, int n, int choice) {
        double h = (b - a) / n;

        for(int i = 0; i < n; i++) {
            this.result += f(a + h * (i + choice - 1));
        }

        this.result *= h;

        new Save(a, b, n, this.result);
    }
}
