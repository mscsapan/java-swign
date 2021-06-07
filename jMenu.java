package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class jMenu extends JFrame implements ActionListener {
    private ImageIcon icon, addIcon;
    private JMenuBar menuBar;
    private JMenu file, edit, view, help;
    private JMenuItem newItem, openItem, closeItem, cutItem, copyItem, pasteItem, undoItem, redoItem, info, contact;

    jMenu() {
        Container con;
        con = getContentPane();
        con.setLayout(null);
        con.setBackground(Color.gray);

        menuBar = new JMenuBar();
        menuBar.setBackground(Color.green);
        this.setJMenuBar(menuBar);

        icon = new ImageIcon(getClass().getResource("cut.png"));
        addIcon = new ImageIcon(getClass().getResource("add.png"));

        file = new JMenu("File");
        edit = new JMenu("Edit");
        view = new JMenu("View");
        help = new JMenu("Help");

        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(view);
        menuBar.add(help);

        newItem = new JMenuItem("New");
        newItem.setIcon(addIcon);
        newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.SHIFT_MASK));

        openItem = new JMenuItem("Open");
        closeItem = new JMenuItem("Close");
        cutItem = new JMenuItem("Cut");
        cutItem.setIcon(icon);
        copyItem = new JMenuItem("Copy");
        pasteItem = new JMenuItem("Paste");
        undoItem = new JMenuItem("undo");
        redoItem = new JMenuItem("redo");
        info = new JMenuItem("Info");
        contact = new JMenuItem("Contact");

        file.add(newItem);
        file.addSeparator();
        file.add(openItem);
        file.add(closeItem);

        edit.add(cutItem);
        edit.addSeparator();
        edit.add(copyItem);
        edit.addSeparator();
        edit.add(pasteItem);
        edit.addSeparator();
        edit.add(undoItem);
        edit.addSeparator();
        edit.add(redoItem);
        edit.addSeparator();

        help.add(info);
        help.add(contact);

        newItem.addActionListener(this);
        closeItem.addActionListener(this);


    }

    public static void main(String[] args) {
        jMenu menu = new jMenu();
        menu.setVisible(true);
        menu.setDefaultCloseOperation(3);
        menu.setBounds(100, 50, 600, 500);
        menu.setTitle("JManu");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == newItem) {
            LoginForm login = new LoginForm();
            login.setVisible(true);
            login.setDefaultCloseOperation(2);
            login.setBounds(100, 50, 600, 500);
            login.setTitle("This is Login Form");

        } else if (ae.getSource() == closeItem) {
            System.exit(0);
        }
    }


}
