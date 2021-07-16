package Part1.Week1;

// quick union is faster than quick find though it can still be too slow
// ids[i] is the parent node of i (index)
// if we have a very tall tree this can be detrimental to its performance
public class QuickUnionUF {
    private int[] ids;

    // set id of each object to itself
    public QuickUnionUF(int N){
        ids = new int[N];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = i;
        }
    }
   
    // chase the parents pointers until reach root
    private int root(int i) {
        while (i != ids[i]) i = ids[i];
        return i;
    }

    // check if p and q have he same root
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    // change root of p to point to root of q
    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        ids[i] = j;
    }
}
