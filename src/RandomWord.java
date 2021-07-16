import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
public static void main(String[] args) {
    String champ = args[0];
    for (int i = 1; i <= args.length; i++) {
        if (StdRandom.bernoulli(1 /i)) {
           champ = args[i - 1]; 
        }
    }
    StdOut.println(champ);
}    
}
