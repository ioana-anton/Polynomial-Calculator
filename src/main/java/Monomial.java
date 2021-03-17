public class Monomial {
    private int degree;
    private int coef;

    Monomial(int degreeC, int coefC){
        degree=degreeC;
        coef=coefC;
    }

    int getDegree(){
        return degree;
    }

    int getCoef(){
        return coef;
    }

    void setDegree(int degreeS){
        degree=degreeS;
    }

    void setCoef(int coefS){
        coef=coefS;
    }

    boolean equalDegree(Monomial a){
        return degree==a.getDegree();
    }
}
