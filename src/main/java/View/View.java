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
    private JTextField resultPolynomial = new JTextField();
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

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setPreferredSize(new Dimension(300, 405));

        opButtons.setLayout(new FlowLayout());
        opButtons.setPreferredSize(new Dimension(70, 30));

        firstPolynomial.setPreferredSize(new Dimension(150, 40));
        secondPolynomial.setPreferredSize(new Dimension(150, 40));
        resultPolynomial.setPreferredSize(new Dimension(150,40));
        remainderPolynomial.setPreferredSize(new Dimension(150,40));

        addition.setPreferredSize(new Dimension(40, 30));
        subtraction.setPreferredSize(new Dimension(40, 30));
        multiplication.setPreferredSize(new Dimension(40,30));
        derivation.setPreferredSize(new Dimension(40,30));
        integration.setPreferredSize(new Dimension(40,30));
        division.setPreferredSize(new Dimension(40,30));
        confirm.setPreferredSize(new Dimension(40, 30));

        mainPanel.add(Box.createRigidArea(new Dimension(150, 10)));
        mainPanel.add(firstPolynomial);
        mainPanel.add(Box.createRigidArea(new Dimension(150, 10)));
        mainPanel.add(secondPolynomial);
        mainPanel.add(Box.createRigidArea(new Dimension(150, 10)));
        mainPanel.add(resultPolynomial);
        mainPanel.add(Box.createRigidArea(new Dimension(150, 10)));
        mainPanel.add(remainderPolynomial);
        mainPanel.add(Box.createRigidArea(new Dimension(150, 10)));
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
        mainPanel.add(division);
        mainPanel.add(Box.createRigidArea(new Dimension(150, 5)));
        mainPanel.add(confirm);
        mainPanel.add(Box.createRigidArea(new Dimension(150, 10)));

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
