package hospital.management.system;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class NEW_APPOINTMENT extends JFrame implements ActionListener {

    JComboBox<String> doctorComboBox, patientComboBox;
    JTextField textFieldPatientID, textFieldTime, textFieldDeposit;
    JLabel dateLabel;
    JButton bookButton, backButton;

    NEW_APPOINTMENT() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 840, 540);
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);
        add(panel);

        JLabel labelTitle = new JLabel("NEW APPOINTMENT FORM");
        labelTitle.setBounds(118, 11, 300, 53);
        labelTitle.setFont(new Font("Roboto", Font.BOLD, 20));
        labelTitle.setForeground(Color.BLACK);
        panel.add(labelTitle);

        // Patient ID Field
        JLabel labelPatientID = new JLabel("PATIENT ID:");
        labelPatientID.setBounds(35, 76, 200, 20);
        labelPatientID.setFont(new Font("Roboto", Font.BOLD, 14));
        labelPatientID.setForeground(Color.BLACK);
        panel.add(labelPatientID);

        doctorComboBox = new JComboBox<>();
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from doctors");
            while (resultSet.next()) {
                doctorComboBox.addItem(resultSet.getString("Name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        doctorComboBox.setBounds(271, 111, 150, 20);
        doctorComboBox.setBackground(new Color(0, 0, 0));
        doctorComboBox.setForeground(Color.WHITE);
        panel.add(doctorComboBox);

        // Doctor Selection
        JLabel labelDoctor = new JLabel("DOCTOR:");
        labelDoctor.setBounds(35, 111, 200, 14);
        labelDoctor.setFont(new Font("Roboto", Font.BOLD, 14));
        labelDoctor.setForeground(Color.BLACK);
        panel.add(labelDoctor);

        patientComboBox = new JComboBox<>();
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from patient_info");
            while (resultSet.next()) {
                patientComboBox.addItem(resultSet.getString("Name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        patientComboBox.setBounds(271, 76, 150, 20);
        patientComboBox.setBackground(new Color(0, 0, 0));
        patientComboBox.setForeground(Color.WHITE);
        panel.add(patientComboBox);

        // Appointment Time
        JLabel labelAppointmentTime = new JLabel("APPOINTMENT TIME:");
        labelAppointmentTime.setBounds(35, 151, 200, 14);
        labelAppointmentTime.setFont(new Font("Roboto", Font.BOLD, 14));
        labelAppointmentTime.setForeground(Color.BLACK);
        panel.add(labelAppointmentTime);

        textFieldTime = new JTextField();
        textFieldTime.setBounds(271, 151, 150, 22);
        textFieldTime.setBackground(new Color(0, 0, 0));
        textFieldTime.setForeground(Color.WHITE);
        panel.add(textFieldTime);

        // Date
        JLabel labelDate = new JLabel("DATE:");
        labelDate.setBounds(35, 191, 150, 14);
        labelDate.setFont(new Font("Roboto", Font.BOLD, 14));
        labelDate.setForeground(Color.BLACK);
        panel.add(labelDate);

        Date date1 = new Date();
        dateLabel = new JLabel("" + date1);
        dateLabel.setBounds(271, 191, 250, 14);
        dateLabel.setForeground(Color.BLACK);
        dateLabel.setFont(new Font("Roboto", Font.BOLD, 14));
        panel.add(dateLabel);

        // Deposit Field
        JLabel labelDeposit = new JLabel("DEPOSIT:");
        labelDeposit.setBounds(35, 231, 200, 14);
        labelDeposit.setFont(new Font("Roboto", Font.BOLD, 14));
        labelDeposit.setForeground(Color.BLACK);
        panel.add(labelDeposit);

        textFieldDeposit = new JTextField();
        textFieldDeposit.setBounds(271, 231, 150, 22);
        textFieldDeposit.setBackground(new Color(0, 0, 0));
        textFieldDeposit.setForeground(Color.WHITE);
        panel.add(textFieldDeposit);

        // Buttons
        bookButton = new JButton("BOOK");
        bookButton.setBounds(100, 430, 120, 30);
        bookButton.setBackground(new Color(0, 0, 0));
        bookButton.setForeground(Color.WHITE);
        bookButton.addActionListener(this);
        panel.add(bookButton);

        backButton = new JButton("BACK");
        backButton.setBounds(260, 430, 120, 30);
        backButton.setBackground(new Color(0, 0, 0));
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        panel.add(backButton);

        // Frame settings
        setUndecorated(true);
        setSize(850, 550);
        setLayout(null);
        setLocation(300, 250);
        setVisible(true);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
        panel.setBorder(border);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bookButton) {
            // Input validation for required fields
            if (doctorComboBox.getSelectedItem() == null || patientComboBox.getSelectedItem() == null || textFieldTime.getText().isEmpty() || textFieldDeposit.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String s1 = (String) doctorComboBox.getSelectedItem();
            String s2 = (String) patientComboBox.getSelectedItem();
            String s3 = textFieldTime.getText();
            String s4 = dateLabel.getText();
            String s5 = textFieldDeposit.getText();
            try {
                conn c = new conn();
                String q = "insert into appointments values ('" + s2 + "', '" + s1 + "', '" + s4 + "', '" + s3 + "', '" + s5 + "')";
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Booked Successfully");
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new NEW_APPOINTMENT();
    }
}
