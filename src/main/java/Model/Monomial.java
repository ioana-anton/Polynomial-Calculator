package Model;

public class Monomial {
    private int degree = 0;
    private int coef;
    private double coefD = 0;
    int visited = 0;

    public Monomial() {

    }

    public Monomial(int degreeC, int coefC) {
        degree = degreeC;
        coef = coefC;
    }

    public Monomial(int degreeDo, double coefDo) {
        degree = degreeDo;
        coefD = coefDo;
    }

    int getDegree() {
        return degree;
    }

    double getCoefD() {
        return coefD;
    }

    int getCoef() {
        return coef;
    }

    int getVisited() {
        return visited;
    }

    void setDegree(int degreeS) {
        degree = degreeS;
    }

    void setCoef(int coefS) {
        coef = coefS;
    }

    void setVisited(int s) {
        visited = s;
    }

    boolean equalDegree(Monomial a) {
        return degree == a.getDegree();
    }
    boolean equalMonomial(Monomial a){return (degree==a.getDegree())&&(coef==a.getCoef());}

    int compareTo(Monomial p) {
        Integer x = (Integer) p.degree;
        return x.compareTo((Integer) degree);
    }


}
