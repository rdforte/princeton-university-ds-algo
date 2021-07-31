package Part1.Week1;
// The notation may be a little confusing, but just remember that square brackets mean the end point is included, and round parentheses mean it's excluded.
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private int N;
    private double trials;
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
            percolatedThresholds[i] = threshold / (N * N);
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(percolatedThresholds);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(percolatedThresholds);
    }

    // The basis for calculating the confidence lo and hi
    private double confidence() {
        return (1.96 * stddev()) / Math.sqrt(trials);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - confidence();
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + confidence();
    }

   // test client (see below)
   public static void main(String[] args) {
      PercolationStats percolation = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1])); 
      System.out.printf("mean = %f\nstddev = %f\n95%% confidence interval = [%f, %f]\n",
                percolation.mean(), percolation.stddev(), percolation.confidenceLo(), percolation.confidenceHi());
   }

}
