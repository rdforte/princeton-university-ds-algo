package Part1.Week1.Assignment;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

       private int[] sites;
       private boolean[] openSites;
       private int N;

       /**
        * Takes a Row and a Col and then convets it to a single intiger for its place in the sites array
        */
       private int convertRowColToSitePosition(int row, int col) {
              return ((row - 1) * N) + col;
       }

       private int getNeighbouringSites(int row, int col) {
              int neighbours[] = new int[4]; // array can have 4 items max: above, below, left, right

              // Above
              if (row - 1 > 0) {
                     int sitePosition
              }
       }
       
       // creates n-by-n grid, with all sites initially blocked
       public Percolation(int n) {
              if (n <= 0) throw new IllegalArgumentException("Error: Requires a value greater than 0");

              N = n;

              int gridItemSize = n * n + 2; // adding two virtual layers to the top and bottom
              sites = new int[gridItemSize];
              openSites = new boolean[gridItemSize];

              for (int i = 0; i < gridItemSize; i++) {
                     sites[i] = i;
                     if (i == 0 || i == gridItemSize - 1) openSites[i] = true;
                     else openSites[i] = false;
              }

              System.out.println(openSites[9]);
       }

       // opens the site (row, col) if it is not open already
       public void open(int row, int col) {
              // if in top row connect to 0
              // if in bottom row connect to n * n + 1

              // find the neighbouring sites in the grid n * n, dont worry about virtual nodes as they are connected in the above step
              // see if the neighbours are open
              // if they are open then connect
       }
   
       // is the site (row, col) open?
       public boolean isOpen(int row, int col) {

       }
   
       // is the site (row, col) full?
       public boolean isFull(int row, int col) {

       }
   
       // returns the number of open sites
       public int numberOfOpenSites() {

       }
   
       // does the system percolate?
       public boolean percolates() {

       }
   
       // test client (optional)
       public static void main(String[] args) {
              Percolation Perc = new Percolation(3);
       }
}
