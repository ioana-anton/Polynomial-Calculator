package View;

import Model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {

    private Model model;

    private JPanel mainPanel = new JPanel();

    private JTextField firstPolynomial = new JTextField();
    private JTextField secondPolynomial = new JTextField();
    private JTextField resultPolynomial = new JTextField("Result");
    private JTextField remainderPolynomial = new JTextField();
    private JButton addition = new JButton("+");
    private JButton subtraction = new JButton("-");
    private JButton multiplication = new JButton("*");
    private JButton derivation = new JButton("d/dx");
    private JButton integration = new JButton("I");
    private JButton division = new JButton("/");
    private JButton confirm = new JButton("Confirm");

    public View(Model m) {

        model = m;

        resultPolynomial.setEditable(false);
        remainderPolynomial.setEditable(false);

        JPanel opButtons = new JPanel();
        JPanel centerP=new JPanel();
        JPanel leftP=new JPanel();
        JPanel rightP=new JPanel();

        centerP.setLayout(new BoxLayout(centerP, BoxLayout.Y_AXIS));
        centerP.setPreferredSize(new Dimension(300, 405));
        centerP.setBackground(new Color(52, 158, 235));

        opButtons.setLayout(new GridLayout(2,3));
        opButtons.setPreferredSize(new Dimension(100, 100));

        firstPolynomial.setPreferredSize(new Dimension(150, 40));
        secondPolynomial.setPreferredSize(new Dimension(150, 40));
        resultPolynomial.setPreferredSize(new Dimension(150,40));
        remainderPolynomial.setPreferredSize(new Dimension(150,40));

        mainPanel.setBackground(new Color(43, 144, 217));
        rightP.setBackground(new Color(43, 144, 217));
        leftP.setBackground(new Color(43, 144, 217));

        /*
        addition.setPreferredSize(new Dimension(40, 30));
        subtraction.setPreferredSize(new Dimension(40, 30));
        multiplication.setPreferredSize(new Dimension(40,30));
        derivation.setPreferredSize(new Dimension(40,30));
        integration.setPreferredSize(new Dimension(40,30));
        division.setPreferredSize(new Dimension(40,30));
        confirm.setPreferredSize(new Dimension(40, 30));*/

        opButtons.add(addition);
        opButtons.add(subtraction);
        opButtons.add(integration);
        opButtons.add(division);
        opButtons.add(derivation);
        opButtons.add(multiplication);

        centerP.add(Box.createRigidArea(new Dimension(150, 10)));
        centerP.add(firstPolynomial);
        centerP.add(Box.createRigidArea(new Dimension(150, 10)));
        centerP.add(secondPolynomial);
        centerP.add(Box.createRigidArea(new Dimension(150, 10)));
        centerP.add(resultPolynomial);
        centerP.add(Box.createRigidArea(new Dimension(150, 10)));
        centerP.add(remainderPolynomial);
        centerP.add(Box.createRigidArea(new Dimension(150, 10)));
        /*
        mainPanel.add(addition);
        mainPanel.add(Box.createRigidArea(new Dimension(150, 10)));
        mainPanel.add(subtraction);
        mainPanel.add(Box.createRigidArea(new Dimension(150, 10)));
        mainPanel.add(multiplication);
        mainPanel.add(Box.createRigidArea(new Dimension(150, 10)));
        mainPanel.add(derivation);
        mainPanel.add(Box.createRigidArea(new Dimension(150, 10)));
        mainPanel.add(integration);
        mainPanel.add(Box.createRigidArea(new Dimension(150, 10)));
        mainPanel.add(division);*/
        centerP.add(opButtons);
        centerP.add(Box.createRigidArea(new Dimension(150, 5)));
        centerP.add(confirm);
        centerP.add(Box.createRigidArea(new Dimension(150, 10)));

        mainPanel.add(rightP);
        mainPanel.add(centerP);
        mainPanel.add(leftP);

        this.setContentPane(mainPanel);
        this.pack();
        this.setTitle("Model.Polynomial Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void addConfirmListener(ActionListener e) {
        confirm.addActionListener(e);
    }

    public void addAdditionListener(ActionListener e) {
        addition.addActionListener(e);
    }

    public void addSubtractionListener(ActionListener e) {
        subtraction.addActionListener(e);
    }

    public void addMultiplicationListener(ActionListener e) {
        multiplication.addActionListener(e);
    }

    public void addDerivationListener(ActionListener e) {
        derivation.addActionListener(e);
    }

    public void addIntegrationListener(ActionListener e) {
        integration.addActionListener(e);
    }

    public void addDivisionListener(ActionListener e) {
        division.addActionListener(e);
    }

    public JPanel getMainPanel(){return mainPanel;}

    public String getFirstPolynomial() {
        return firstPolynomial.getText();
    }

    public String getSecondPolynomial() {
        return secondPolynomial.getText();
    }

    public void setResultPolynomial(String s){
        resultPolynomial.setText(s);
    }

    public void setRemainderPolynomial(String s){
        remainderPolynomial.setText(s);
    }

}
