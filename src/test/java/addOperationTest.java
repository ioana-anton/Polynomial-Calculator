import Model.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class addOperationTest {

    //Addition Tests
    @Test
    public void addTest1() {

        ArrayList<Monomial> list1=new ArrayList<>();
        list1.add(new Monomial(2,1));
        ArrayList<Monomial> list2=new ArrayList<>();
        list2.add(new Monomial(2,1));
        ArrayList<Monomial> list3=new ArrayList<>();
        list3.add(new Monomial(2,2));
        Polynomial a = new Polynomial(list1);
        Polynomial b = new Polynomial(list2);
        Polynomial result = new Polynomial(list3);
        Polynomial c=a.add(b);
        assertTrue(c.equalPolynomials(result),"The result of the addition operation is correct.");
    }

    @Test
    public void addTest2() {

        ArrayList<Monomial> list1=new ArrayList<>();
        list1.add(new Monomial(6,5));
        list1.add(new Monomial(2,-4));
        ArrayList<Monomial> list2=new ArrayList<>();
        list2.add(new Monomial(2,4));
        ArrayList<Monomial> list3=new ArrayList<>();
        list3.add(new Monomial(6,5));
        Polynomial a = new Polynomial(list1);
        Polynomial b = new Polynomial(list2);
        Polynomial result = new Polynomial(list3);
        Polynomial c=a.add(b);
        assertTrue(c.equalPolynomials(result),"The result of the addition operation is correct.");
    }

    //Subtraction Tests
    @Test
    public void subTest1() {

        ArrayList<Monomial> list1=new ArrayList<>();
        list1.add(new Monomial(2,1));
        ArrayList<Monomial> list2=new ArrayList<>();
        list2.add(new Monomial(2,1));
        ArrayList<Monomial> list3=new ArrayList<>();
        //list3.add(new Monomial(0,0));
        Polynomial a = new Polynomial(list1);
        Polynomial b = new Polynomial(list2);
        Polynomial result = new Polynomial(list3);
        Polynomial c=a.subtract(b);
        assertTrue(c.equalPolynomials(result),"The result of the subtract operation is correct.");

    }
    @Test
    public void subTest2() {

        ArrayList<Monomial> list1=new ArrayList<>();
        list1.add(new Monomial(6,5));
        list1.add(new Monomial(2,-4));
        ArrayList<Monomial> list2=new ArrayList<>();
        list2.add(new Monomial(2,4));
        ArrayList<Monomial> list3=new ArrayList<>();
        list3.add(new Monomial(6,5));
        list3.add(new Monomial(2,-8));
        Polynomial a = new Polynomial(list1);
        Polynomial b = new Polynomial(list2);
        Polynomial result = new Polynomial(list3);
        Polynomial c=a.subtract(b);
        assertTrue(c.equalPolynomials(result),"The result of the subtract operation is correct.");
    }

    //Derivation Tests
    @Test
    public void derTest1() {

        ArrayList<Monomial> list1=new ArrayList<>();
        list1.add(new Monomial(2,1));
        ArrayList<Monomial> list3=new ArrayList<>();
        list3.add(new Monomial(1,2));
        Polynomial a = new Polynomial(list1);
        Polynomial result = new Polynomial(list3);
        Polynomial c=a.derivation();
        assertTrue(c.equalPolynomials(result),"The result of the derivation operation is correct.");
    }
    @Test
    public void derTest2() {
        ArrayList<Monomial> list1=new ArrayList<>();
        list1.add(new Monomial(6,5));
        list1.add(new Monomial(2,-4));
        ArrayList<Monomial> list3=new ArrayList<>();
        list3.add(new Monomial(5,30));
        list3.add(new Monomial(1,-8));
        Polynomial a = new Polynomial(list1);
        Polynomial result = new Polynomial(list3);
        Polynomial c=a.derivation();
        assertTrue(c.equalPolynomials(result),"The result of the derivation operation is correct.");
    }

    //Multiplication Tests
    @Test
    public void multiplyTest1() {
        ArrayList<Monomial> list1=new ArrayList<>();
        list1.add(new Monomial(2,1));
        ArrayList<Monomial> list2=new ArrayList<>();
        list2.add(new Monomial(2,1));
        ArrayList<Monomial> list3=new ArrayList<>();
        list3.add(new Monomial(4,1));
        Polynomial a = new Polynomial(list1);
        Polynomial b = new Polynomial(list2);
        Polynomial result = new Polynomial(list3);
        Polynomial c=a.multiply(b);
        assertTrue(c.equalPolynomials(result),"The result of the multiplication operation is correct.");
    }
    @Test
    public void multiplyTest2() {
        ArrayList<Monomial> list1=new ArrayList<>();
        list1.add(new Monomial(6,5));
        list1.add(new Monomial(2,-4));
        ArrayList<Monomial> list2=new ArrayList<>();
        list2.add(new Monomial(2,4));
        ArrayList<Monomial> list3=new ArrayList<>();
        list3.add(new Monomial(8,20));
        list3.add(new Monomial(4,-16));
        Polynomial a = new Polynomial(list1);
        Polynomial b = new Polynomial(list2);
        Polynomial result = new Polynomial(list3);
        Polynomial c=a.multiply(b);
        assertTrue(c.equalPolynomials(result),"The result of the multiplication operation is correct.");
    }

    //Integration Tests
    @Test
    public void integrateTest1() {
        ArrayList<Monomial> list1=new ArrayList<>();
        list1.add(new Monomial(2,1));
        ArrayList<Monomial> list3=new ArrayList<>();
        list3.add(new Monomial(3,0.6666666666666667));
        Polynomial a = new Polynomial(list1);
        Polynomial result = new Polynomial(list3);
        Polynomial c=a.integration();
        assertTrue(c.equalPolynomials(result),"The result of the integration operation is correct.");
    }
    @Test
    public void integrateTest2() {
        ArrayList<Monomial> list1=new ArrayList<>();
        list1.add(new Monomial(6,5));
        list1.add(new Monomial(2,-4));
        ArrayList<Monomial> list3=new ArrayList<>();
        list3.add(new Monomial(7,0.7142857142857143));
        list3.add(new Monomial(3,-1.333333333333333));
        Polynomial a = new Polynomial(list1);
        Polynomial result = new Polynomial(list3);
        Polynomial c=a.integration();
        assertTrue(c.equalPolynomials(result),"The result of the integration operation is correct.");
    }
    //Division Tests
    @Test
    public void divideTest1() {
        ArrayList<Monomial> list1=new ArrayList<>();
        list1.add(new Monomial(3,1));
        list1.add(new Monomial(2,-2));
        list1.add(new Monomial(1,6));
        list1.add(new Monomial(0,-5));
        ArrayList<Monomial> list2=new ArrayList<>();
        list2.add(new Monomial(2,1));
        list2.add(new Monomial(0,-1));
        ArrayList<Monomial> list3=new ArrayList<>();
        list3.add(new Monomial(1,1));
        list3.add(new Monomial(0,-2));
        ArrayList<Monomial> list4=new ArrayList<>();
        list4.add(new Monomial(1,7));
        list4.add(new Monomial(0,-7));
        Polynomial a = new Polynomial(list1);
        Polynomial b = new Polynomial(list2);
        Polynomial[] result = new Polynomial[2];
        result[0]=new Polynomial(list3);
        result[1]=new Polynomial(list4);
        Polynomial[] c=a.division(b);
        assertTrue(c[0].equalPolynomials(result[0])&&c[1].equalPolynomials(result[1]),"The result of the division operation is correct.");
    }
    @Test
    public void divideTest2() {
        ArrayList<Monomial> list1=new ArrayList<>();
        list1.add(new Monomial(3,1));
        list1.add(new Monomial(2,-2));
        list1.add(new Monomial(1,6));
        list1.add(new Monomial(0,-5));
        ArrayList<Monomial> list2=new ArrayList<>();
        list2.add(new Monomial(2,1));
        list2.add(new Monomial(0,-1));
        ArrayList<Monomial> list3=new ArrayList<>();
        list3.add(new Monomial(1,1));
        list3.add(new Monomial(0,-2));
        ArrayList<Monomial> list4=new ArrayList<>();
        list4.add(new Monomial(1,7));
        list4.add(new Monomial(0,-7));
        Polynomial a = new Polynomial(list2);
        Polynomial b = new Polynomial(list1);
        Polynomial[] result = new Polynomial[2];
        result[0]=new Polynomial(list3);
        result[1]=new Polynomial(list4);
        Polynomial[] c=a.division(b);
        assertTrue(c[0].equalPolynomials(result[0])&&c[1].equalPolynomials(result[1]),"The result of the division operation is correct.");
    }


}
