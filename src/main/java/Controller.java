import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private Model model;
    private View view;

    Controller(Model m, View v) {

        model = m;
        view = v;

        v.addConfirmListener(new confirmListener());

    }

    class confirmListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            String firstPolynomialString = view.getFirstPolynomial();
            String secondPolynomialString = view.getSecondPolynomial();

            String pattern = "";



        }
    }

}
