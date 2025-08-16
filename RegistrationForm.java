package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationForm extends JFrame implements ActionListener {

    JTextField usernameField;
    JPasswordField passwordField;
    JButton registerButton;

    RegistrationForm() {

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 50, 100, 30);
        usernameLabel.setForeground(Color.BLACK);
        setFont(new Font("Roboto",Font.BOLD,25));
        add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(150, 50, 200, 30);
        usernameField.setForeground(Color.WHITE);
        usernameField.setBackground(Color.BLACK);
        setFont(new Font("Roboto",Font.BOLD,25));
        add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 100, 100, 30);
        passwordLabel.setForeground(Color.BLACK);
        setFont(new Font("Roboto",Font.BOLD,25));
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 100, 200, 30);
        passwordField.setForeground(Color.WHITE);
        passwordField.setBackground(Color.BLACK);
        setFont(new Font("Roboto",Font.BOLD,25));
        add(passwordField);

        registerButton = new JButton("Register");
        registerButton.setBounds(150, 150, 100, 30);
        registerButton.setForeground(Color.WHITE);
        registerButton.setBackground(Color.BLACK);
        setFont(new Font("Roboto",Font.BOLD,25));
        add(registerButton);
        registerButton.addActionListener(this);

        setUndecorated(true);
        getContentPane().setBackground(new Color(255,255,255));
        setSize(400, 250);
        setLayout(null);
        setVisible(true);
        setLocation(400, 270);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            String s1 = usernameField.getText();
            String s2 = passwordField.getText();

            try {
                conn c = new conn();
                String q = "insert into login values ('" + s1 + "', '" + s2 + "')";
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Registered Successfully");
                setVisible(false);
                new Login();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new RegistrationForm();
    }
}
