package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    private JLabel loginForm, userName, passWord, gender, occupation;
    private JPasswordField password;
    private JTextField jTextField;
    private JRadioButton male, female;
    private JCheckBox bus, stu, showpass;
    private ButtonGroup button1, button2;
    private JButton submit, reset;


    LoginForm() {
        Container container;
        container = getContentPane();
        container.setLayout(null);
        container.setBackground(Color.GRAY);

        Font font = new Font("magneto", Font.BOLD, 20);
        Font labelFont = new Font("Arial", Font.BOLD, 18);
        Font textField = new Font("Arial", 0, 18);
        Font button = new Font("Arial", Font.BOLD, 20);

        button1 = new ButtonGroup();
        button2 = new ButtonGroup();

        loginForm = new JLabel("Login Form");
        loginForm.setBounds(230, 10, 140, 40);
        loginForm.setForeground(Color.PINK);
        loginForm.setFont(font);
        container.add(loginForm);

        userName = new JLabel("UserName: ");
        userName.setBounds(30, 60, 120, 40);
        userName.setFont(labelFont);
        container.add(userName);

        passWord = new JLabel("PassWord: ");
        passWord.setBounds(30, 120, 120, 40);
        passWord.setFont(labelFont);
        container.add(passWord);

        jTextField = new JTextField("UserName");
        jTextField.setBounds(160, 60, 180, 40);
        jTextField.setFont(textField);
        container.add(jTextField);

        password = new JPasswordField("PassWord");
        password.setBounds(160, 120, 180, 40);
        //password.setEchoChar('*');
        password.setFont(textField);
        container.add(password);

        showpass = new JCheckBox("Show");
        showpass.setBounds(340, 120, 100, 40);
        showpass.setFont(labelFont);
        showpass.setBackground(Color.gray);
        container.add(showpass);

        gender = new JLabel("Gender:");
        gender.setBounds(30, 180, 80, 40);
        gender.setFont(labelFont);
        container.add(gender);

        occupation = new JLabel("Occupation:");
        occupation.setBounds(30, 230, 130, 40);
        occupation.setFont(labelFont);
        container.add(occupation);

        male = new JRadioButton("Male");
        male.setBounds(160, 180, 80, 40);
        male.setFont(labelFont);
        male.setBackground(Color.GRAY);
        container.add(male);

        female = new JRadioButton("Female");
        female.setBounds(250, 180, 90, 40);
        female.setFont(labelFont);
        female.setBackground(Color.GRAY);
        container.add(female);

        bus = new JCheckBox("Business");
        bus.setBounds(160, 230, 110, 40);
        bus.setFont(labelFont);
        bus.setBackground(Color.GRAY);
        container.add(bus);

        stu = new JCheckBox("Student");
        stu.setBounds(280, 230, 100, 40);
        stu.setFont(labelFont);
        stu.setBackground(Color.GRAY);
        container.add(stu);

        button1.add(male);
        button1.add(female);

        button2.add(bus);
        button2.add(stu);

        submit = new JButton("Submit");
        submit.setBounds(190, 300, 100, 50);
        submit.setFont(button);
        container.add(submit);

        reset = new JButton("Reset");
        reset.setBounds(300, 300, 100, 50);
        reset.setFont(button);
        container.add(reset);

        Cursor sub = new Cursor(Cursor.HAND_CURSOR);
        submit.setCursor(sub);
        Cursor res = new Cursor(12);
        reset.setCursor(res);

        Handler handler = new Handler();
        submit.addActionListener(handler);
        reset.addActionListener(handler);

        showpass.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (showpass.isSelected()) {
                    password.setEchoChar((char) 0);
                    showpass.setText("Hide");
                } else {
                    password.setEchoChar('*');
                    showpass.setText("Show");
                }
            }
        });

  /*  reset.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae){
            int choice = JOptionPane.showConfirmDialog(null,"Are you sure, You want to clear All??","Warning",JOptionPane.YES_NO_OPTION);
            if(choice == 0) {
                jTextField.setText(" ");
                password.setText("");
            }else{
                System.exit(0);
            }
        }
    });*/

    }

    public static void main(String[] args) {
        LoginForm login = new LoginForm();
        login.setVisible(true);
        login.setDefaultCloseOperation(3);
        login.setBounds(100, 50, 600, 500);
        login.setTitle("This is Login Form");
    }

    class Handler implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == reset) {
                int choice = JOptionPane.showConfirmDialog(null, "Are you sure, You want to clear All??", "Warning", JOptionPane.YES_NO_OPTION);
                if (choice == 0) {
                    jTextField.setText(" ");
                    password.setText("");
                } else {
                    System.exit(0);
                }
            } else if (ae.getSource() == submit) {
                String name = jTextField.getText();
                String pass = password.getText();
                if (name.equals("Sapan") && pass.equals("mscsapan") && male.isSelected() && stu.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Successfully Login", "Welcome", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid PassWord or UserName", "Warning", JOptionPane.ERROR_MESSAGE);
                    System.exit(1);
                }
            }
        }
    }
}
