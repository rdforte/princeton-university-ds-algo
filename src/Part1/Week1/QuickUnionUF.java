package Week1;

public class QuickUnionUF {
    private int[] ids;

    public QuickUnionUF(int N){
        ids = new int[N];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = i;
        }
    }
    
}
