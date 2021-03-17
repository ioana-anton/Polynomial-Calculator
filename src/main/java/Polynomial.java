import java.util.ArrayList;

public class Polynomial {
    private ArrayList<Monomial> monomialsList = new ArrayList<Monomial>();

    private Polynomial add(Polynomial a) {
        Polynomial c = new Polynomial();
        Monomial result = new Monomial(0, 0);
        if (monomialsList.size() >= a.monomialsList.size()) {
            for (Monomial it : monomialsList) {
                for (Monomial it2 : a.monomialsList)
                    if (it.equalDegree(it2)) {
                        result.setDegree(it.getDegree());
                        result.setCoef(it.getCoef() + it2.getCoef());
                        c.monomialsList.add(result);
                    }
            }
        } else {
            for (Monomial it : a.monomialsList) {
                for (Monomial it2 : monomialsList)
                    if (it.equalDegree(it2)) {
                        result.setDegree(it.getDegree());
                        result.setCoef(it.getCoef() + it2.getCoef());
                        c.monomialsList.add(result);
                    }
            }
        }
        return c;
    }

}
