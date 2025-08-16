package hospital.management.system;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class update_patient_details extends JFrame {

    JTextField textFieldR, textFieldAmount, textFieldPending;
    JLabel date;
    Choice choice;

    update_patient_details() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 940, 490);
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(600, 60, 300, 300);
        panel.add(label);

        JLabel label1 = new JLabel("Update Patient Details");
        label1.setBounds(124, 11, 260, 25);
        label1.setFont(new Font("Roboto", Font.BOLD, 20));
        label1.setForeground(Color.BLACK);
        panel.add(label1);

        JLabel label2 = new JLabel("Name :");
        label2.setBounds(25, 88, 100, 14);
        label2.setFont(new Font("Roboto", Font.PLAIN, 14));
        label2.setForeground(Color.BLACK);
        panel.add(label2);

        choice = new Choice();
        choice.setBounds(248, 85, 140, 25);
        choice.setBackground(Color.BLACK);
        panel.add(choice);

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM Patient_Info");
            while (resultSet.next()) {
                choice.add(resultSet.getString("Name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room Number :");
        label3.setBounds(25, 129, 150, 14);
        label3.setFont(new Font("Roboto", Font.PLAIN, 14));
        label3.setForeground(Color.BLACK);
        panel.add(label3);

        textFieldR = new JTextField();
        textFieldR.setBounds(248, 129, 140, 20);
        textFieldR.setBackground(Color.BLACK);
        textFieldR.setForeground(Color.WHITE);
        panel.add(textFieldR);

        JLabel label4 = new JLabel("In-Time :");
        label4.setBounds(25, 174, 100, 14);
        label4.setFont(new Font("Roboto", Font.PLAIN, 14));
        label4.setForeground(Color.BLACK);
        panel.add(label4);

        Date date1 = new Date();
        date = new JLabel(""+date1);
        date.setBounds(248,174,250,20);
        date.setForeground(Color.BLACK);
        date.setFont(new Font("Roboto",Font.BOLD,14));
        panel.add(date);

        JLabel label5 = new JLabel("Amount Paid (Rs) :");
        label5.setBounds(25, 216, 150, 14);
        label5.setFont(new Font("Roboto", Font.PLAIN, 14));
        label5.setForeground(Color.BLACK);
        panel.add(label5);

        textFieldAmount = new JTextField();
        textFieldAmount.setBounds(248, 216, 140, 20);
        textFieldAmount.setBackground(Color.BLACK);
        textFieldAmount.setForeground(Color.WHITE);
        panel.add(textFieldAmount);

        JLabel label6 = new JLabel("Pending Amount (Rs) :");
        label6.setBounds(25, 261, 150, 14);
        label6.setFont(new Font("Roboto", Font.PLAIN, 14));
        label6.setForeground(Color.BLACK);
        panel.add(label6);

        textFieldPending = new JTextField();
        textFieldPending.setBounds(248, 261, 140, 20);
        textFieldPending.setBackground(Color.BLACK);
        textFieldPending.setForeground(Color.WHITE);
        panel.add(textFieldPending);

        JButton check = new JButton("CHECK");
        check.setBounds(281, 378, 89, 23);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        panel.add(check);

        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = choice.getSelectedItem();
                String query = "SELECT * FROM Patient_Info WHERE Name = '" + id + "'";
                try {
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery(query);
                    while (resultSet.next()) {
                        textFieldR.setText(resultSet.getString("Room_Number"));
                        date.setText(resultSet.getString("Time"));
                        textFieldAmount.setText(resultSet.getString("Deposite"));
                    }

                    // Calculate pending amount based on room price
                    ResultSet resultSet1 = c.statement.executeQuery("SELECT * FROM room WHERE room_no = '" + textFieldR.getText() + "'");
                    while (resultSet1.next()) {
                        String price = resultSet1.getString("Price");
                        int pendingAmount = Integer.parseInt(price) - Integer.parseInt(textFieldAmount.getText());
                        textFieldPending.setText("" + pendingAmount);
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton update = new JButton("UPDATE");
        update.setBounds(56, 378, 89, 23);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        panel.add(update);

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    conn c = new conn();
                    String name = choice.getSelectedItem();
                    String room = textFieldR.getText();
                    String time = date.getText();
                    String amount = textFieldAmount.getText();
                    c.statement.executeUpdate("UPDATE Patient_Info SET Room_Number = '" + room + "', Time = '" + time + "', Deposite = '" + amount + "' WHERE Name = '" + name + "'");
                    JOptionPane.showMessageDialog(null, "Updated Successfully");
                    setVisible(false);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton back = new JButton("BACK");
        back.setBounds(168, 378, 89, 23);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(950, 500);
        setLayout(null);
        setLocation(400, 250);
        setVisible(true);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
        panel.setBorder(border);
    }

    public static void main(String[] args) {
        new update_patient_details();
    }
}
