import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numberButton = new JButton[10];
    JButton[] functionButton = new JButton[9];
    JButton addBtn, subBtn, multBtn, divBtn;
    JButton decBtn, equalBtn, delBtn, clrBtn, negBtn;
    JPanel panel;


    Font myFont = new Font("Ink Free", Font.BOLD, 30);
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);

        frame.add(textField);
        textField.setEditable(false);

        addBtn = new JButton("+");
        subBtn = new JButton("-");
        multBtn = new JButton("*");
        divBtn = new JButton("/");
        decBtn = new JButton(".");
        equalBtn = new JButton("=");
        delBtn = new JButton("Del");
        clrBtn = new JButton("Clr");
        negBtn = new JButton("(-)");

        functionButton[0] = addBtn;
        functionButton[1] = subBtn;
        functionButton[2] = multBtn;
        functionButton[3] = divBtn;
        functionButton[4] = decBtn;
        functionButton[5] = equalBtn;
        functionButton[6] = delBtn;
        functionButton[7] = clrBtn;
        functionButton[8] = negBtn;

        for (int i = 0; i < functionButton.length; i++) {
            functionButton[i].addActionListener(this);
            functionButton[i].setFont(myFont);
            functionButton[i].setFocusable(false);
        }
        for (int i = 0; i < numberButton.length; i++) {
            numberButton[i] = new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setFont(myFont);
            numberButton[i].setFocusable(false);
        }

        negBtn.setBounds(50, 430, 100, 50);
        delBtn.setBounds(150, 430, 100, 50);
        clrBtn.setBounds(250, 430, 100, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        panel.add(numberButton[1]);
        panel.add(numberButton[2]);
        panel.add(numberButton[3]);
        panel.add(addBtn);
        panel.add(numberButton[4]);
        panel.add(numberButton[5]);
        panel.add(numberButton[6]);
        panel.add(subBtn);
        panel.add(numberButton[7]);
        panel.add(numberButton[8]);
        panel.add(numberButton[9]);
        panel.add(multBtn);
        panel.add(decBtn);
        panel.add(numberButton[0]);
        panel.add(equalBtn);
        panel.add(divBtn);

        frame.add(negBtn);
        frame.add(delBtn);
        frame.add(clrBtn);
        frame.add(panel);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < numberButton.length; i++) {
            if (e.getSource() == numberButton[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decBtn) {
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == addBtn) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subBtn) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == multBtn) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divBtn) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == equalBtn) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '*' -> result = num1 * num2;
                case '/' -> result = num1 / num2;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clrBtn) {
            textField.setText("");
        }
        if (e.getSource() == delBtn) {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textField.setText(textField.getText() + string.charAt(i));
            }
        }
        if (e.getSource() == negBtn) {
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }
    }
}
