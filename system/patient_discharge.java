package hospital.management.system;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class patient_discharge extends JFrame {

    public patient_discharge() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 790, 390);
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("CHECK-OUT");
        label.setBounds(100, 20, 150, 20);
        label.setFont(new Font("Roboto", Font.BOLD, 20));
        label.setForeground(Color.BLACK);
        panel.add(label);

        JLabel label2 = new JLabel("PATIENT ID");
        label2.setBounds(30, 80, 150, 20);
        label2.setFont(new Font("Roboto", Font.BOLD, 14));
        label2.setForeground(Color.BLACK);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(200, 80, 150, 25);
        panel.add(choice);

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from Patient_Info");
            while (resultSet.next()) {
                choice.add(resultSet.getString("number"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel Pname = new JLabel("Name:");
        Pname.setBounds(30, 110, 150, 20);
        Pname.setFont(new Font("Roboto", Font.BOLD, 14));
        Pname.setForeground(Color.BLACK);
        panel.add(Pname);

        JLabel nameLabel = new JLabel();
        nameLabel.setBounds(200, 110, 150, 20);
        nameLabel.setFont(new Font("Roboto", Font.BOLD, 14));
        nameLabel.setForeground(Color.BLACK);
        panel.add(nameLabel);

        JLabel label3 = new JLabel("Room Number");
        label3.setBounds(30, 150, 150, 20);
        label3.setFont(new Font("Roboto", Font.BOLD, 14));
        label3.setForeground(Color.BLACK);
        panel.add(label3);

        JLabel RNo = new JLabel();
        RNo.setBounds(200, 150, 150, 20);
        RNo.setFont(new Font("Roboto", Font.BOLD, 14));
        RNo.setForeground(Color.BLACK);
        panel.add(RNo);

        JLabel label4 = new JLabel("In Time");
        label4.setBounds(30, 190, 150, 20);
        label4.setFont(new Font("Roboto", Font.BOLD, 14));
        label4.setForeground(Color.BLACK);
        panel.add(label4);

        JLabel INTime = new JLabel();
        INTime.setBounds(200, 190, 250, 20);
        INTime.setFont(new Font("Roboto", Font.BOLD, 14));
        INTime.setForeground(Color.BLACK);
        panel.add(INTime);

        JLabel label5 = new JLabel("Out Time");
        label5.setBounds(30, 230, 150, 20);
        label5.setFont(new Font("Roboto", Font.BOLD, 14));
        label5.setForeground(Color.BLACK);
        panel.add(label5);

        Date date = new Date();

        JLabel OUTTime = new JLabel("" + date);
        OUTTime.setBounds(200, 230, 250, 20);
        OUTTime.setFont(new Font("Roboto", Font.BOLD, 14));
        OUTTime.setForeground(Color.BLACK);
        panel.add(OUTTime);

        JLabel pendingAmountLabel = new JLabel("Pending Amount:");
        pendingAmountLabel.setBounds(30, 270, 150, 20);
        pendingAmountLabel.setFont(new Font("Roboto", Font.BOLD, 14));
        pendingAmountLabel.setForeground(Color.BLACK);
        panel.add(pendingAmountLabel);

        JLabel Pamount = new JLabel();
        Pamount.setBounds(200, 270, 150, 20);
        Pamount.setFont(new Font("Roboto", Font.BOLD, 14));
        Pamount.setForeground(Color.BLACK);
        panel.add(Pamount);

        JButton discharge = new JButton("Discharge");
        discharge.setBounds(30, 320, 120, 30);
        discharge.setBackground(Color.black);
        discharge.setForeground(Color.white);
        panel.add(discharge);
        discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JButton Check = new JButton("Check");
        Check.setBounds(170, 320, 120, 30);
        Check.setBackground(Color.black);
        Check.setForeground(Color.white);
        panel.add(Check);
        Check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = choice.getSelectedItem();
                try {
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery("SELECT * FROM Patient_Info WHERE number = '" + id + "'");
                    if (resultSet.next()) {
                        nameLabel.setText(resultSet.getString("Name"));
                        RNo.setText(resultSet.getString("Room_Number"));
                        INTime.setText(resultSet.getString("Time"));
                        int paidAmount = resultSet.getInt("Deposite");

                        ResultSet roomResult = c.statement.executeQuery("SELECT * FROM room WHERE room_no = '" + RNo.getText() + "'");
                        if (roomResult.next()) {
                            int roomPrice = roomResult.getInt("Price");
                            int pendingAmount = roomPrice - paidAmount;
                            Pamount.setText("" + pendingAmount);
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton button = new JButton("BACK");
        button.setBounds(310, 320, 120, 30);
        button.setBackground(Color.black);
        button.setForeground(Color.white);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(800, 400);
        setLayout(null);
        setLocation(400, 250);
        setVisible(true);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
        panel.setBorder(border);
    }

    public static void main(String[] args) {
        new patient_discharge();
    }
}
