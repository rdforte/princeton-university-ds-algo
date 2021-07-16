package Week1;

// Quick-find
// takes quadratic time so therefore its too slow
// quadratic algorithms dont scale with technology.
public class QuickFindUF {
    private int[] ids;

    // set id of each object to itself
    public void QuickFind(int n) {
        ids = new int[n];
        for (int i = 0; i < n; i++)
            ids[i] = i;
    }

    // check whether p and q are in the same component
    public boolean connected(int p, int q) {
        return ids[p] == ids[q];
    }

    public void union(int p, int q) {
        int pid = ids[p];
        int qid = ids[q];
        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == pid) ids[i] = qid;
        }
    }
}
