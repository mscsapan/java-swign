package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioButton extends JFrame {
    private JRadioButton male, female;
    private ButtonGroup buttonGroup;
    private JComboBox jComboBox;
    private JLabel label;

    RadioButton() {
        Container container;
        container = getContentPane();
        container.setLayout(null);
        container.setBackground(Color.gray);
        buttonGroup = new ButtonGroup();

        Font font = new Font("Tahoma", 1, 20);
        Font f = new Font("magneto", Font.BOLD, 18);

        male = new JRadioButton("Male");
        male.setBounds(100, 30, 80, 50);
        male.setBackground(Color.gray);
        male.setFont(font);
        container.add(male);

        female = new JRadioButton("Female");
        female.setBounds(190, 30, 100, 50);
        female.setBackground(Color.gray);
        female.setFont(font);
        container.add(female);

        buttonGroup.add(male);
        buttonGroup.add(female);

        String[] properties = {"Bangla", "English", "Mathematics", "Physics", "Chemistry"};
        jComboBox = new JComboBox(properties);
        jComboBox.setBounds(100, 100, 180, 50);
        jComboBox.setEditable(true);
        //jComboBox.setSelectedIndex(2);
        jComboBox.setSelectedItem("Chemistry");
        jComboBox.setFont(font);
        container.add(jComboBox);

        label = new JLabel("Nothing is Selected!");
        label.setBounds(100, 160, 300, 40);
        label.setFont(f);
        container.add(label);

        ActionHandler action = new ActionHandler();
        male.addActionListener(action);
        female.addActionListener(action);
        jComboBox.addActionListener(action);


    }

    public static void main(String[] args) {
        RadioButton radioButton = new RadioButton();
        radioButton.setVisible(true);
        radioButton.setDefaultCloseOperation(3);
        radioButton.setBounds(100, 50, 600, 500);
        radioButton.setTitle("Radio Button");
    }

    class ActionHandler implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            String getText = jComboBox.getSelectedItem().toString();
            label.setText("You've Selected " + getText);

 /*           if(male.isSelected()){
                JOptionPane.showConfirmDialog(null,"You've Selected Male","Confirmation",0);

            }else{
                JOptionPane.showConfirmDialog(null,"You've Selected Female","Confirmation",JOptionPane.YES_OPTION);
            }*/

        }

    }
}
