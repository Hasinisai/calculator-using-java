import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


class Calculator extends JFrame implements ActionListener {

    public static final int WIDTH = 400;
    public static final int HEIGHT = 200;
    private JTextField input;
    private JLabel resultLabel;
    private JLabel eqLabel;
    private double result;
    private String display = "";


    public Calculator() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        Container contentPane = getContentPane();
        contentPane.setBackground(Color.BLACK);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 3));
        inputPanel.setBackground(Color.GRAY);
        inputPanel.add(new JLabel(" Equation:  "));
        eqLabel = new JLabel();
        inputPanel.add(eqLabel);
        input = new JTextField(10);
        inputPanel.add(new JLabel(" INPUT: "));
        inputPanel.add(input);
        inputPanel.add(new JLabel(" RESULT "));
        resultLabel = new JLabel();
        inputPanel.add(resultLabel);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4));
        buttonPanel.setBackground(Color.BLACK);
        String Buttons[] = {"-", "+", "/", "*", "%", "pow", "sqrt", "sin", "cos", "tan", "C", "="};
        JButton buttons[] = new JButton[12];
        for (int i = 0; i < 12; i++) {
            buttons[i] = new JButton(Buttons[i]);
            buttons[i].addActionListener(this);
            buttons[i].setBackground(Color.LIGHT_GRAY);
            buttonPanel.add(buttons[i]);
        }

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            assumingCorrectNumberFormats(e);
        } catch (Exception e2) {
            resultLabel.setText("Error: Reenter Number.");
        }
    }

    public void assumingCorrectNumberFormats(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        double number = stringToDouble(input.getText());

        switch (actionCommand) {
            case "-":
                result -= number;
                display += " - " + number;
                break;
            case "+":
                result += number;
                display += " + " + number;
                break;
            case "*":
                result *= number;
                display += " * " + number;
                break;
            case "/":
                result /= number;
                display += " / " + number;
                break;
            case "sin":
                result = Math.sin(result);
                display = "sin(" + result + ")";
                break;
            case "cos":
                result = Math.cos(result);
                display = "cos(" + result + ")";
                break;
            case "tan":
                result = Math.tan(result);
                display = "tan(" + result + ")";
                break;
            case "sqrt":
                result = Math.sqrt(result);
                display = "sqrt(" + result + ")";
                break;
            case "%":
                result %= number;
                display += " % " + number;
                break;
            case "C":
                result = 0.0;
                resultLabel.setText("");
                display = "";
                eqLabel.setText("");
                input.setText("");
                break;
            case "=":
                resultLabel.setText(Double.toString(result));
                break;
            default:
                break;
        }

        eqLabel.setText(display);
    }

    private static double stringToDouble(String stringObject) {
        return Double.parseDouble(stringObject.trim());
    }
}

public class Runner {
    public static void main(String args[]) {
        Calculator calculator = new Calculator();
        calculator.setVisible(true);
    }
}
