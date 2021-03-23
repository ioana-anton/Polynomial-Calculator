package Model;

import java.util.Comparator;

public class ComparatorDegree implements Comparator<Monomial> {
    public int compare(Monomial a, Monomial b){
        return a.compareTo(b);
    }
}
