package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.border.Border;

public class Doctor_info extends JFrame {

    Doctor_info(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,1290,590);
        panel.setBackground(new Color(255,255,255));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,34,1270,450);
        table.setBackground(new Color(255,255,255));
        panel.add(table);

        try {
            conn c = new conn();
            String q = "select * from Doctors";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("Name");
        label1.setBounds(41,10,70,20);
        label1.setFont(new Font("Roboto", Font.BOLD,14));
        panel.add(label1);

        JLabel label2 = new JLabel("Department");
        label2.setBounds(231,10,105,20);
        label2.setFont(new Font("Roboto", Font.BOLD,14));
        panel.add(label2);

        JLabel label3 = new JLabel("Age");
        label3.setBounds(431,10,105,20);
        label3.setFont(new Font("Roboto", Font.BOLD,14));
        panel.add(label3);

        JLabel label4 = new JLabel("Gender");
        label4.setBounds(601,10,105,20);
        label4.setFont(new Font("Roboto", Font.BOLD,14));
        panel.add(label4);

        JLabel label5 = new JLabel("Phone Number");
        label5.setBounds(771,10,105,20);
        label5.setFont(new Font("Roboto", Font.BOLD,14));
        panel.add(label5);

        JLabel label6 = new JLabel("Gmail");
        label6.setBounds(981,10,105,20);
        label6.setFont(new Font("Roboto", Font.BOLD,14));
        panel.add(label6);

        JLabel label7 = new JLabel("Aadhar Number");
        label7.setBounds(1131,10,120,20);
        label7.setFont(new Font("Roboto", Font.BOLD,14));
        panel.add(label7);

        JButton b1 = new JButton("BACK");
        b1.setBounds(580,520,130,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        panel.add(b1);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(1300,600);
        setLocation(120,230);
        setLayout(null);
        setVisible(true);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
        panel.setBorder(border);

    }



    public static void main(String[] args){
        new Doctor_info();
    }

}
