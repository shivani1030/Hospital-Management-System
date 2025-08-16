package hospital.management.system;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame {

    Reception(){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,160,1520,670);
        panel.setBackground(new Color(98, 60, 128));
        add(panel);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5,5,1520,150);
        panel1.setBackground(new Color(98, 60, 128));
        add(panel1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/VIT.jpg"));
        Image image = i1.getImage().getScaledInstance(280,135,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(image);
        JLabel label = new JLabel(i2);
        label.setBounds(1100,-50,250,250);
        panel1.add(label);

        JButton btn1 = new JButton("Add new Patient");
        btn1.setBounds(30,15,200,30);
        btn1.setBackground(new Color(255,255,255));
        setFont(new Font("Roboto",Font.BOLD,25));
        panel1.add(btn1);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NEW_PATIENT();
            }
        });

        JButton btn2 = new JButton("Room");
        btn2.setBounds(30,100,200,30);
        btn2.setBackground(new Color(255,255,255));
        setFont(new Font("Roboto",Font.BOLD,25));
        panel1.add(btn2);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Room();
            }
        });

        JButton btn3 = new JButton("Department");
        btn3.setBounds(270,58,200,30);
        btn3.setBackground(new Color(255,255,255));
        setFont(new Font("Roboto",Font.BOLD,25));
        panel1.add(btn3);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Department();
            }
        });

        JButton btn4 = new JButton("Doctor Info.");
        btn4.setBounds(270,100,200,30);
        btn4.setBackground(new Color(255,255,255));
        setFont(new Font("Roboto",Font.BOLD,25));
        panel1.add(btn4);
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Doctor_info();
            }
        });

        JButton btn5 = new JButton("Patient Info.");
        btn5.setBounds(510,58,200,30);
        btn5.setBackground(new Color(255,255,255));
        setFont(new Font("Roboto",Font.BOLD,25));
        panel1.add(btn5);
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ALL_Patient_Info();
            }
        });

        JButton btn6 = new JButton("Patient Discharge");
        btn6.setBounds(750,15,200,30);
        btn6.setBackground(new Color(255,255,255));
        setFont(new Font("Roboto",Font.BOLD,25));
        panel1.add(btn6);
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new patient_discharge();
            }
        });

        JButton btn7 = new JButton("Update Patient Details");
        btn7.setBounds(510,100,200,30);
        btn7.setBackground(new Color(255,255,255));
        setFont(new Font("Roboto",Font.BOLD,25));
        panel1.add(btn7);
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new update_patient_details();
            }
        });

        JButton btn8 = new JButton("Ambulance");
        btn8.setBounds(750,58,200,30);
        btn8.setBackground(new Color(255,255,255));
        setFont(new Font("Roboto",Font.BOLD,25));
        panel1.add(btn8);
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Ambulance();
            }
        });

        JButton btn9 = new JButton("Search Room");
        btn9.setBounds(270,15,200,30);
        btn9.setBackground(new Color(255,255,255));
        setFont(new Font("Roboto",Font.BOLD,25));
        panel1.add(btn9);
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchRoom();
            }
        });

        JButton btn10 = new JButton("Logout");
        btn10.setBounds(750,100,200,30);
        btn10.setBackground(new Color(255,255,255));
        setFont(new Font("Roboto",Font.BOLD,25));
        panel1.add(btn10);
        btn10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login();
            }
        });

        JButton btn11 = new JButton("Book Appointment");
        btn11.setBounds(30,58,200,30);
        btn11.setBackground(new Color(255,255,255));
        setFont(new Font("Roboto",Font.BOLD,25));
        panel1.add(btn11);
        btn11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NEW_APPOINTMENT();
            }
        });

        JButton btn12 = new JButton("Show Appointments");
        btn12.setBounds(510,15,200,30);
        btn12.setBackground(new Color(255,255,255));
        setFont(new Font("Roboto",Font.BOLD,25));
        panel1.add(btn12);
        btn12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SHOW_APPOINTMENTS();
            }
        });


        setUndecorated(true);
        setSize(1950,1090);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
        panel.setBorder(border);
        Border border1 = BorderFactory.createLineBorder(Color.BLACK, 5);
        panel1.setBorder(border1);
    }




    public static void main(String[] args){
        new Reception();

    }
}
