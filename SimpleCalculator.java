import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame implements ActionListener {

    private JTextField textField1, textField2;
    private JButton addButton, subtractButton, multiplyButton, divideButton;
    private JLabel resultLabel;

    public SimpleCalculator() {

        setTitle("Simple Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10)); // Using GridLayout for simplicity

        textField1 = new JTextField();
        textField2 = new JTextField();
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        resultLabel = new JLabel("Result: ");

        add(new JLabel("Number 1:"));
        add(textField1);
        add(new JLabel("Number 2:"));
        add(textField2);
        add(addButton);
        add(subtractButton);
        add(multiplyButton);
        add(divideButton);
        add(resultLabel);

        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(textField1.getText());
            double num2 = Double.parseDouble(textField2.getText());
            double result = 0;

            if (e.getSource() == addButton) {
                result = num1 + num2;
            } else if (e.getSource() == subtractButton) {
                result = num1 - num2;
            } else if (e.getSource() == multiplyButton) {
                result = num1 * num2;
            } else if (e.getSource() == divideButton) {
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    resultLabel.setText("Result: Cannot divide by zero");
                    return;
                }
            }

            resultLabel.setText("Result: " + result);
        } catch (NumberFormatException ex) {
            // Handle invalid input
            resultLabel.setText("Result: Invalid input");
        }
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}
