import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;

public class View extends JFrame {

    private Model model;
    private JTextField firstPolynomial = new JTextField();
    private JTextField secondPolynomial = new JTextField();
    private JButton addition=new JButton("+");
    private JButton subtraction=new JButton("-");
    private JButton confirm=new JButton("Confirm");

    View(Model m) {

        model=m;

        JPanel mainPanel = new JPanel();
        JPanel opButtons = new JPanel();

        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
        mainPanel.setPreferredSize(new Dimension(200,205));

        opButtons.setLayout(new FlowLayout());
        opButtons.setPreferredSize(new Dimension(70,30));

        firstPolynomial.setPreferredSize(new Dimension(150,40));
        secondPolynomial.setPreferredSize(new Dimension(150,40));

        addition.setPreferredSize(new Dimension(60,30));
        subtraction.setPreferredSize(new Dimension(60,30));
        confirm.setPreferredSize(new Dimension(60,30));

        mainPanel.add(Box.createRigidArea(new Dimension(150, 10)));
        mainPanel.add(firstPolynomial);
        mainPanel.add(Box.createRigidArea(new Dimension(150, 10)));
        mainPanel.add(secondPolynomial);
        mainPanel.add(Box.createRigidArea(new Dimension(150, 10)));
        mainPanel.add(addition);
        mainPanel.add(subtraction);
        mainPanel.add(Box.createRigidArea(new Dimension(150, 5)));
        mainPanel.add(confirm);

        this.setContentPane(mainPanel);
        this.pack();
        this.setTitle("Polynomial Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    void addConfirmListener(ActionListener e){
        confirm.addActionListener(e);
    }

    String getFirstPolynomial(){
        return firstPolynomial.getText();
    }

    String getSecondPolynomial(){
        return secondPolynomial.getText();
    }

}
