import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
        //Create frame and panel objects
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        //Label for first number
        JLabel firstNum = new JLabel("First number:");
        firstNum.setFont((new Font("Arial", Font.BOLD, 14)));
        firstNum.setBounds(30, 20, 120, 20);
        panel.add(firstNum);

        //Text field for first number
        JTextField firstNumText = new JTextField();
        firstNumText.setBounds(150, 20, 100, 20);
        panel.add(firstNumText);

        //Label for second number
        JLabel secondNum = new JLabel("Second number:");
        secondNum.setFont((new Font("Arial", Font.BOLD, 14)));
        secondNum.setBounds(30, 50, 120, 20);
        panel.add(secondNum);

        //Text field for second number
        JTextField secondNumText = new JTextField();
        secondNumText.setBounds(150, 50, 100, 20);
        panel.add(secondNumText);

        //Label for third number
        JLabel thirdNum = new JLabel("Third number:");
        thirdNum.setFont((new Font("Arial", Font.BOLD, 14)));
        thirdNum.setBounds(30, 80, 120, 20);
        panel.add(thirdNum);

        //Text field for third number
        JTextField thirdNumText = new JTextField();
        thirdNumText.setBounds(150, 80, 100, 20);
        panel.add(thirdNumText);

        //Label for arithmetic operations
        JLabel arithOper = new JLabel("Choose arithmetic operation:");
        arithOper.setFont((new Font("Arial", Font.BOLD, 14)));
        arithOper.setBounds(40, 110, 280, 20);
        panel.add(arithOper);

        //Radio button for addition
        JRadioButton addition = new JRadioButton("Add");
        addition.setFont((new Font("Arial", Font.BOLD, 14)));
        addition.setBounds(20, 140, 60, 20);
        panel.add(addition);

        //Radio button for subtraction
        JRadioButton subtraction = new JRadioButton("Subtract");
        subtraction.setFont((new Font("Arial", Font.BOLD, 14)));
        subtraction.setBounds(90, 140, 90, 20);
        panel.add(subtraction);

        //Radio button for multiplication
        JRadioButton multiplication = new JRadioButton("Multiply");
        multiplication.setFont((new Font("Arial", Font.BOLD, 14)));
        multiplication.setBounds(180, 140, 100, 20);
        panel.add(multiplication);

        //Button grouper
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(addition);
        buttonGroup.add(subtraction);
        buttonGroup.add(multiplication);

        //Label for result
        JLabel result = new JLabel("Result:");
        result.setFont((new Font("Arial", Font.BOLD, 16)));
        result.setBounds(40, 180, 290, 20);
        result.setForeground(Color.BLUE);
        panel.add(result);

        //Calculate button
        JButton calculate = new JButton("Calculate");
        calculate.setFont((new Font("Arial", Font.BOLD, 14)));
        calculate.setBounds(90, 220, 100, 30);
        calculate.setBackground(Color.GREEN);
        panel.add(calculate);

        //Adding action listeners to radio buttons
        calculate.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Check calculate button is clicked
                if (e.getSource() == calculate) {
                    //Control flow
                    if (addition.isSelected()) {
                        try {
                            int first = Integer.parseInt(firstNumText.getText());
                            int second = Integer.parseInt(secondNumText.getText());
                            int third = Integer.parseInt(thirdNumText.getText());
                            int sum = first + second + third;
                            result.setText("Result: " + String.valueOf(sum));
                        } catch (NumberFormatException nfe) {
                            result.setText("Result: Enter number!");
                        }
                    } else if (subtraction.isSelected()) {
                        try {
                            int first = Integer.parseInt(firstNumText.getText());
                            int second = Integer.parseInt(secondNumText.getText());
                            int third = Integer.parseInt(thirdNumText.getText());
                            int sum = first - second - third;
                            result.setText("Result: " + String.valueOf(sum));
                        } catch (NumberFormatException nfe) {
                            result.setText("Result: Enter number!");
                        }
                    } else if (multiplication.isSelected()) {
                        try {
                            int first = Integer.parseInt(firstNumText.getText());
                            int second = Integer.parseInt(secondNumText.getText());
                            int third = Integer.parseInt(thirdNumText.getText());
                            int sum = first * second * third;
                            result.setText("Result: " + String.valueOf(sum));
                        } catch (NumberFormatException nfe) {
                            result.setText("Result: Enter number!");
                        }
                    }
                }
            }
        });

        //Frame settings
        panel.setLayout(null);
        frame.setSize(300, 300);
        frame.setTitle("Calculator");
        frame.add(panel);

        //Adding action listeners to frame close
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //Set confirmation dialog
                int close = JOptionPane.showConfirmDialog(frame, "Are you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
                //Control flow
                if (close == JOptionPane.YES_OPTION) {
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                } else {
                    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
