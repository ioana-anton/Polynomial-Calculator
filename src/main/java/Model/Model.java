package Model;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;


public class Model {

    private Polynomial first;
    private Polynomial second;
    private Polynomial result;

    public Polynomial getFirst() {
        return first;
    }

    public Polynomial getSecond() {
        return second;
    }

    public Polynomial getResult() {
        return result;
    }

    public void setFirst(Polynomial s) {
        first = s;
    }

    public void setSecond(Polynomial s) {
        second = s;
    }

    public ArrayList<String> getGroups(String s) { //separa in grupuri de termeni un polinom string

        s=s.replaceAll("X","x");
        s=s.replaceAll(" ","");

        ArrayList<String> groups = new ArrayList<>();

        String model = "([+-]?[^-+]+)";

            Pattern pattern = Pattern.compile(model);
            Matcher matcher = pattern.matcher(s);

            while (matcher.find()) {
                groups.add(matcher.group(1));
            }

        return groups;
    }

    public ArrayList<Monomial> setMonomial(ArrayList<String> s) {
        ArrayList<Monomial> monomialList = new ArrayList<Monomial>();

        for (String it : s) {
            Monomial tempMonomial = new Monomial();

            it = it.replaceAll("\\^", ""); //aici si celelalte conditii
            List<String> numbers = Arrays.asList(it.split("x"));
            int x = 0;
            for (String cont : numbers) {
                if (x % 2 == 0) {
                    tempMonomial.setCoef(Integer.parseInt(cont));
                    x++;
                } else {
                    tempMonomial.setDegree(Integer.parseInt(cont));
                    x++;
                }
            }
            monomialList.add(tempMonomial);
        }

        return monomialList;
    }

    public String convertList(Polynomial p) {
        String result = new String();
        for (Monomial it : p.getMonomialsList()) {
            //reconstituire polinom
            System.out.println(it.getDegree()+" "+it.getCoef());
            if(it.getCoefD()!=0) {
                System.out.println(it.getCoefD());
                result = result + String.format("%+.2f",it.getCoefD()) + "x^" + Integer.toString(it.getDegree()) ;
            }
            else
                result=result+String.format("%+d",it.getCoef()) + "x^" + Integer.toString(it.getDegree());
        }
        //pentru a elimina + de la final
        if (result != null && result.length() > 0 && result.charAt(0) == '+') {
            result = result.substring(1, result.length());
        }

        return result;
    }

    public void printPolynomials(){
        System.out.println("The first polynomial: ");
        for(Monomial it:first.getMonomialsList())
            System.out.println(it.getCoef()+ " "+it.getDegree());
        System.out.println("The second polynomial: ");
        for(Monomial it:second.getMonomialsList())
            System.out.println(it.getCoef()+ " "+it.getDegree());
    }


}
