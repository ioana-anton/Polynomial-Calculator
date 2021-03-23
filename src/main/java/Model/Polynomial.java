package Model;

import java.util.ArrayList;

public class Polynomial {
    private ArrayList<Monomial> monomialsList = new ArrayList<Monomial>();

    public Polynomial() {
    }

    public Polynomial(ArrayList<Monomial> m) {
        monomialsList = m;
    }

   /* public void setMonomialsList(ArrayList<Monomial> s) {
        monomialsList = s;
    }*/

    public ArrayList<Monomial> getMonomialsList() {
        return monomialsList;
    }

    public void print() {
        for (Monomial it : monomialsList)
            System.out.printf("%d %d\n", it.getDegree(), it.getCoef());
    }

    public boolean equalPolynomials(Polynomial a) {
        boolean ok = true;
        if (monomialsList.isEmpty() && a.monomialsList.isEmpty())
            return true;
        for (Monomial it : monomialsList)
            if ((it.equalMonomial(a.monomialsList.get(monomialsList.indexOf(it))) == false))
                ok = false;
        return ok;
    }

    public void resetVisited() {
        for (Monomial it : monomialsList)
            it.setVisited(0);
    }

    public Polynomial removeNullCoef(Polynomial a) {
        Polynomial result = a;
        ArrayList<Monomial> resultList = new ArrayList<Monomial>(a.monomialsList);
        for (Monomial it : a.monomialsList)
            if (it.getCoef() == 0) {
                resultList.remove(it);
            }
        result.monomialsList = resultList;
        return result;
    }

    public Polynomial minimize() {
        Polynomial c = new Polynomial();
        int currentDegree = monomialsList.get(0).getDegree();
        Monomial result = new Monomial(currentDegree, 0);

        for (Monomial it : monomialsList) {
            if (it.getDegree() == currentDegree) {
                result.setCoef(it.getCoef() + result.getCoef());
            } else {
                c.monomialsList.add(result);
                result = new Monomial(it.getDegree(), it.getCoef());
                currentDegree = it.getDegree();
            }
        }
        c.monomialsList.add(result);

        return c;
    }


    public Polynomial add(Polynomial a) {
        Polynomial c = new Polynomial();
        Monomial result = new Monomial(0, 0);
        ComparatorDegree comp = new ComparatorDegree();
        a.resetVisited();
        resetVisited();
        for (Monomial it : monomialsList) {
            for (Monomial it2 : a.monomialsList)
                if (it.equalDegree(it2)) {
                    result = new Monomial(it.getDegree(), it.getCoef() + it2.getCoef());
                    it.setVisited(1);
                    it2.setVisited(1);
                    c.monomialsList.add(result);
                }
        }
        for (Monomial it : monomialsList) {
            if (it.getVisited() == 0) {
                result = new Monomial(it.getDegree(), it.getCoef());
                c.monomialsList.add(result);
            }
        }
        for (Monomial it : a.monomialsList) {
            if (it.getVisited() == 0) {
                result = new Monomial(it.getDegree(), it.getCoef());
                c.monomialsList.add(result);
            }
        }
        c = removeNullCoef(c);
        if (c.monomialsList.isEmpty() == false) {
            c.minimize();
            c.monomialsList.sort(comp);
        }
        return c;
    }

    public Polynomial subtract(Polynomial a) {
        Polynomial c = new Polynomial();
        Monomial result = new Monomial(0, 0);
        ComparatorDegree comp = new ComparatorDegree();
        a.resetVisited();
        resetVisited();
        for (Monomial it : monomialsList) {
            for (Monomial it2 : a.monomialsList)
                if (it.equalDegree(it2)) {
                    result = new Monomial(it.getDegree(), it.getCoef() - it2.getCoef());
                    it.setVisited(1);
                    it2.setVisited(1);
                    c.monomialsList.add(result);
                }
        }
        for (Monomial it : monomialsList) {
            if (it.getVisited() == 0) {
                result = new Monomial(it.getDegree(), it.getCoef());
                c.monomialsList.add(result);
            }
        }
        for (Monomial it : a.monomialsList) {
            if (it.getVisited() == 0) {
                result = new Monomial(it.getDegree(), it.getCoef());
                c.monomialsList.add(result);
            }
        }

        c = removeNullCoef(c);
        if (c.monomialsList.isEmpty() == false) {
            c.minimize();
            c.monomialsList.sort(comp);
        }
        return c;
    }


    public Polynomial multiply(Polynomial a) {
        Polynomial c = new Polynomial();
        Monomial result = new Monomial(0, 0);
        ComparatorDegree comp = new ComparatorDegree();

        for (Monomial it : monomialsList) {
            for (Monomial it2 : a.monomialsList) {
                result = new Monomial(it.getDegree() + it2.getDegree(), it.getCoef() * it2.getCoef());
                c.monomialsList.add(result);
            }
        }

        Polynomial finalPolynomial = new Polynomial();
        if (c.monomialsList.isEmpty() == false) {
            finalPolynomial = c.minimize();
            finalPolynomial = removeNullCoef(finalPolynomial);
            finalPolynomial.monomialsList.sort(comp);
        }

        return finalPolynomial;
    }

    public Polynomial derivation() {
        Polynomial c = new Polynomial();
        Monomial result = new Monomial(0, 0);
        ComparatorDegree comp = new ComparatorDegree();

        for (Monomial it : monomialsList) {
            if (it.getDegree() != 0) {
                result = new Monomial(it.getDegree() - 1, it.getCoef() * it.getDegree());
                c.monomialsList.add(result);
            }
        }
        if (c.monomialsList.isEmpty() == false) {
            c = removeNullCoef(c);
            c.monomialsList.sort(comp);
        }
        return c;
    }

    public Polynomial integration() {
        Polynomial c = new Polynomial();
        Monomial result = new Monomial(0, 0);
        ComparatorDegree comp = new ComparatorDegree();

        for (Monomial it : monomialsList) {
            result = new Monomial(it.getDegree() + 1, (double) it.getCoef() / (it.getDegree() + 1));
            c.monomialsList.add(result);
        }
        if (c.monomialsList.isEmpty() == false) {
            c = removeNullCoef(c);
            c.monomialsList.sort(comp);
        }
        return c;
    }

    public Polynomial[] monoDivision(Polynomial a) {
        Polynomial Q = new Polynomial();
        Polynomial R = new Polynomial();
        Polynomial[] c = new Polynomial[2];
        Monomial result = new Monomial();
        Polynomial Temp;
        Polynomial monoPoly = new Polynomial();
        ComparatorDegree comp = new ComparatorDegree();

        R = new Polynomial(new ArrayList<>(monomialsList));
        while (R.monomialsList.get(0).getDegree() >= a.monomialsList.get(0).getDegree()) {
            result = new Monomial(R.monomialsList.get(0).getDegree() - a.monomialsList.get(0).getDegree(), R.monomialsList.get(0).getCoef() / a.monomialsList.get(0).getCoef());
            Q.monomialsList.add(result);
            monoPoly.monomialsList = new ArrayList<Monomial>();
            monoPoly.monomialsList.add(result);
            Temp = a.multiply(monoPoly);
            R = R.subtract(Temp);
            R.monomialsList.sort(comp);
        }

        c[0] = Q;
        c[1] = R;
        return c;
    }

    public Polynomial[] division(Polynomial a) {
        Polynomial[] c = new Polynomial[2];
        ComparatorDegree comp = new ComparatorDegree();

        monomialsList.sort(comp);
        a.monomialsList.sort(comp);

            if (monomialsList.get(0).getDegree() > a.monomialsList.get(0).getDegree()) {
                c = monoDivision(a);
            } else {
                c = a.monoDivision(this);
            }

            return c;

    }

}
