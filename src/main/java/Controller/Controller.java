package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Model.*;
import View.*;

import javax.swing.*;

public class Controller {
    private Model model;
    private View view;
    private int operation = -1;


    public Controller(Model m, View v) {

        model = m;
        view = v;

        v.addConfirmListener(new confirmListener());
        v.addAdditionListener(new additionListener());
        v.addSubtractionListener(new subtractionListener());
        v.addMultiplicationListener(new multiplicationListener());
        v.addDerivationListener(new derivationListener());
        v.addIntegrationListener(new integrationListener());
        v.addDivisionListener(new divisionListener());

    }

    class confirmListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            if (operation == -1) {
                JOptionPane.showMessageDialog(view.getMainPanel(), "Please choose an operation. ");
            }

            String firstPolynomialString = view.getFirstPolynomial();
            String secondPolynomialString = view.getSecondPolynomial();

            try {
                ArrayList<String> firstMonomialGroups = model.getGroups(firstPolynomialString);
                model.setFirst(new Polynomial(model.setMonomial(firstMonomialGroups)));
                ArrayList<String> secondMonomialGroups = model.getGroups(secondPolynomialString);
                model.setSecond(new Polynomial(model.setMonomial(secondMonomialGroups)));
            } catch (Exception exc) {
                JOptionPane.showMessageDialog(view.getMainPanel(), "Invalid input data. ");
            }

            Polynomial res = new Polynomial();
            res = model.getFirst();

            if (operation == 0) {
                res = res.add(model.getSecond());
            }
            if (operation == 1) {
                res = res.subtract(model.getSecond());
            }

            if (operation == 2) {
                res = res.multiply(model.getSecond());
            }

            if (operation == 3) {
                res = res.derivation();
            }

            if (operation == 4) {
                res = res.integration();
            }

            String result;
            if (operation == 5) {
                Polynomial[] resu;
                resu = res.division(model.getSecond());
                result = model.convertList(resu[0]);
                if(resu[1]!=null){
                String remainder = model.convertList(resu[1]);
                view.setRemainderPolynomial(remainder);}else
                    view.setRemainderPolynomial("0");
            } else {
                result = model.convertList(res);
            }


            if(res.getMonomialsList().isEmpty())
                view.setResultPolynomial("0");
            else
                view.setResultPolynomial(result);
            view.setResultPolynomial(result);
            model.printPolynomials();
            System.out.println(result);

        }
    }

    class additionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            operation = 0;
        }
    }

    class subtractionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            operation = 1;
        }
    }

    class multiplicationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            operation = 2;
        }
    }

    class derivationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            operation = 3;
        }
    }

    class integrationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            operation = 4;
        }
    }

    class divisionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            operation = 5;
        }
    }


}
