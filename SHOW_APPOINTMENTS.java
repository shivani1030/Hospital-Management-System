package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SHOW_APPOINTMENTS extends JFrame {

    Choice c1;
    JTable table;

    SHOW_APPOINTMENTS() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 800, 490);
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);
        add(panel);

        JLabel title = new JLabel("Search Doctor Appointments");
        title.setBounds(210, 11, 300, 31);
        title.setForeground(Color.BLACK);
        title.setFont(new Font("Roboto", Font.BOLD, 20));
        panel.add(title);

        JLabel status = new JLabel("Doctor:");
        status.setBounds(70, 70, 80, 20);
        status.setForeground(Color.BLACK);
        status.setFont(new Font("Roboto", Font.BOLD, 14));
        panel.add(status);

        c1 = new Choice();
        c1.setBounds(170, 70, 120, 20);
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT Name FROM doctors");
            while (resultSet.next()) {
                c1.add(resultSet.getString("Name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        panel.add(c1);

        table = new JTable();
        table.setBounds(10, 197, 785, 210);
        table.setBackground(new Color(255, 255, 255));
        table.setForeground(Color.BLACK);
        panel.add(table);

        try {
            conn c = new conn();
            String query = "SELECT * FROM appointments";
            ResultSet resultSet = c.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel pname = new JLabel("Patient Name");
        pname.setBounds(40, 155, 150, 25);
        pname.setForeground(Color.BLACK);
        pname.setFont(new Font("Roboto", Font.BOLD, 14));
        panel.add(pname);

        JLabel dname = new JLabel("Doctor Name");
        dname.setBounds(195, 155, 150, 25);
        dname.setForeground(Color.BLACK);
        dname.setFont(new Font("Roboto", Font.BOLD, 14));
        panel.add(dname);

        JLabel dt = new JLabel("Booking Date & Time");
        dt.setBounds(325, 155, 300, 25);
        dt.setForeground(Color.BLACK);
        dt.setFont(new Font("Roboto", Font.BOLD, 14));
        panel.add(dt);

        JLabel date = new JLabel("Appointment Time");
        date.setBounds(495, 155, 150, 25);
        date.setForeground(Color.BLACK);
        date.setFont(new Font("Roboto", Font.BOLD, 14));
        panel.add(date);

        JLabel deposite = new JLabel("Deposite");
        deposite.setBounds(690, 155, 150, 25);
        deposite.setForeground(Color.BLACK);
        deposite.setFont(new Font("Roboto", Font.BOLD, 14));
        panel.add(deposite);

        JButton Search = new JButton("Search");
        Search.setBounds(200, 420, 120, 25);
        Search.setBackground(Color.BLACK);
        Search.setForeground(Color.WHITE);
        panel.add(Search);
        Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "SELECT * FROM appointments where doctor_name = '"+c1.getSelectedItem()+"'";
                try {
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        JButton Back = new JButton("Back");
        Back.setBounds(380, 420, 120, 25);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        panel.add(Back);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(810, 500);
        setLayout(null);
        setLocation(360, 250);
        setVisible(true);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
        panel.setBorder(border);
    }

    public static void main(String[] args) {
        new SHOW_APPOINTMENTS();
    }
}
