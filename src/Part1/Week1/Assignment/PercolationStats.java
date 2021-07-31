package Part1.Week1.Assignment;
// The notation may be a little confusing, but just remember that square brackets mean the end point is included, and round parentheses mean it's excluded.
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private int N;
    private int trials;
    private double[] percolatedThresholds;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) throw new IllegalArgumentException("n and trials must be greater than 0");
        N = n;
        this.trials = trials;
        percolatedThresholds = new double[trials];

        for (int i = 0; i < trials; i++) {
            double threshold = 0;
            boolean percolates = false;
            Percolation percolation = new Percolation(N);
            while (!percolates) {
                int row = StdRandom.uniform(1, N + 1);
                int col = StdRandom.uniform(1, N + 1);
            if (!percolation.isOpen(row, col)) {
                percolation.open(row, col);
                threshold++;
                percolates = percolation.percolates();
            }
            }
            percolatedThresholds[i] = threshold;
        }
    }

    // sample mean of percolation threshold
    public double mean() {

    }

    // sample standard deviation of percolation threshold
    public double stddev()

    // low endpoint of 95% confidence interval
    public double confidenceLo()

    // high endpoint of 95% confidence interval
    public double confidenceHi()

   // test client (see below)
   public static void main(String[] args)

}
