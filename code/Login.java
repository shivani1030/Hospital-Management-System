package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField textField;
    JPasswordField jPasswordField;
    JButton b1, b2,b3;


    Login() {

        JLabel namelabel = new JLabel("Username");
        namelabel.setBounds(40, 20, 100, 30);
        namelabel.setFont(new Font("Roboto", Font.BOLD, 16));
        namelabel.setForeground(Color.BLACK);
        add(namelabel);

        JLabel password = new JLabel("Password");
        password.setBounds(40, 70, 100, 30);
        password.setFont(new Font("Roboto", Font.BOLD, 16));
        password.setForeground(Color.BLACK);
        add(password);

        textField = new JTextField();
        textField.setBounds(150, 20, 150, 30);
        textField.setFont(new Font("Roboto", Font.PLAIN, 15));
        textField.setBackground(new Color(255, 255, 255));
        add(textField);

        jPasswordField = new JPasswordField();
        jPasswordField.setBounds(150, 70, 150, 30);
        jPasswordField.setFont(new Font("Roboto", Font.PLAIN, 15));
        jPasswordField.setBackground(new Color(255, 255, 255));
        add(jPasswordField);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/login1.png"));
        Image i1 = imageIcon.getImage().getScaledInstance(250, 240, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(390, -5, 400, 300);
        add(label);

        ImageIcon imageIcon2 = new ImageIcon(ClassLoader.getSystemResource("icon/VIT1.png"));
        Image i11 = imageIcon2.getImage().getScaledInstance(335, 100, Image.SCALE_DEFAULT);
        ImageIcon imageIcon3 = new ImageIcon(i11);
        JLabel label2 = new JLabel(imageIcon3);
        label2.setBounds(10, 190, 345, 100);
        add(label2);

        b1 = new JButton("Login");
        b1.setBounds(40, 140, 120, 30);
        b1.setFont(new Font("Roboto", Font.BOLD, 15));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        add(b1);
        b1.addActionListener(this);

        b2 = new JButton("Cancel");
        b2.setBounds(180, 140, 120, 30);
        b2.setFont(new Font("Roboto", Font.BOLD, 15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        add(b2);
        b2.addActionListener(this);

        b3 = new JButton("Register");
        b3.setBounds(320, 140, 120, 30);
        b3.setFont(new Font("Roboto", Font.BOLD, 15));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.white);
        add(b3);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegistrationForm();
                setVisible(false);
            }
        });

        setUndecorated(true);
        getContentPane().setBackground(new Color(98, 60, 128));
        setSize(750, 300);
        setLayout(null);
        setVisible(true);
        setLocation(400, 270);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                conn c = new conn();
                String user = textField.getText();
                String Pass = jPasswordField.getText();

                String q = "select * from login where ID = '" + user + "' and PW = '" + Pass + "'";
                ResultSet resultSet = c.statement.executeQuery(q);
                if (resultSet.next()){
                    new Reception();
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid login credentials. Please try again.");
                }

            } catch (Exception E) {
                E.printStackTrace();
            }

        } else{
            System.exit(10);
        }
    }

    public static void main(String[] args){
        new Login();
    }
}



