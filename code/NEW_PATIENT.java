package hospital.management.system;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;


public class NEW_PATIENT extends JFrame implements ActionListener {

    JComboBox comboBox;

    JTextField textFieldNumber, textName, textFieldDisease, textFieldDeposite;

    JRadioButton r1,r2;
    Choice c1;
    JLabel date;
    JButton b1,b2;

    NEW_PATIENT(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,840,540);
        panel.setBackground(new Color(255,255,255));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/patient.png"));
        Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(550,150,200,200);
        panel.add(label);

        JLabel labelName = new JLabel("NEW PATIENT FORM");
        labelName.setBounds(118,11,260,53);
        labelName.setFont(new Font("Roboto",Font.BOLD,20 ));
        labelName.setForeground(Color.BLACK);
        panel.add(labelName);

        JLabel labelID = new JLabel("ID :");
        labelID.setBounds(35,76,200,20);
        labelID.setFont(new Font("Roboto",Font.BOLD,14 ));
        labelID.setForeground(Color.BLACK);
        panel.add(labelID);

        comboBox = new JComboBox(new String[] {"Aadhar Card","Voter ID","Driving License"});
        comboBox.setBounds(271,73,150,20);
        comboBox.setBackground(new Color(0,0,0));
        comboBox.setForeground(Color.WHITE);
        comboBox.setFont(new Font("Roboto",Font.BOLD,14 ));
        panel.add(comboBox);

        JLabel labelNumber = new JLabel("NUMBER :");
        labelNumber.setBounds(35,111,200,14);
        labelNumber.setFont(new Font("Roboto",Font.BOLD,14 ));
        labelNumber.setForeground(Color.BLACK);
        panel.add(labelNumber);

        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(271,111,150,22);
        textFieldNumber.setBackground(new Color(0,0,0));
        textFieldNumber.setForeground(Color.WHITE);
        panel.add(textFieldNumber);

        JLabel labelName1 = new JLabel("NAME :");
        labelName1.setBounds(35,151,200,14);
        labelName1.setFont(new Font("Roboto",Font.BOLD,14 ));
        labelName1.setForeground(Color.BLACK);
        panel.add(labelName1);

        textName = new JTextField();
        textName.setBounds(271,151,150,22);
        textName.setBackground(new Color(0,0,0));
        textName.setForeground(Color.WHITE);
        panel.add(textName);

        JLabel labelGender = new JLabel("GENDER :");
        labelGender.setBounds(35,191,200,14);
        labelGender.setFont(new Font("Roboto",Font.BOLD,14 ));
        labelGender.setForeground(Color.BLACK);
        panel.add(labelGender);

        r1 = new JRadioButton("MALE");
        r1.setFont(new Font("Roboto",Font.BOLD,14 ));
        r1.setForeground(Color.WHITE);
        r1.setBackground(new Color(0,0,0));
        r1.setBounds(271,191,80,22);
        panel.add(r1);

        r2 = new JRadioButton("FEMALE");
        r2.setFont(new Font("Roboto",Font.BOLD,14 ));
        r2.setForeground(Color.WHITE);
        r2.setBackground(new Color(0,0,0));
        r2.setBounds(350,191,85,22);
        panel.add(r2);

        JLabel labelDisease = new JLabel("SYMPTOMS :");
        labelDisease.setBounds(35,231,200,14);
        labelDisease.setFont(new Font("Roboto",Font.BOLD,14 ));
        labelDisease.setForeground(Color.BLACK);
        panel.add(labelDisease);

        textFieldDisease = new JTextField();
        textFieldDisease.setBounds(271,231,150,22);
        textFieldDisease.setBackground(new Color(0,0,0));
        textFieldDisease.setForeground(Color.WHITE);
        panel.add(textFieldDisease);

        JLabel labelRoom = new JLabel("ROOM :");
        labelRoom.setBounds(35,274,150,14);
        labelRoom.setFont(new Font("Roboto",Font.BOLD,14 ));
        labelRoom.setForeground(Color.BLACK);
        panel.add(labelRoom);

        c1 = new Choice();
        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from room");
            while (resultSet.next()){
                c1.add(resultSet.getString("room_no"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        c1.setBounds(271,274,150,20);
        c1.setFont(new Font("Roboto",Font.BOLD,14));
        c1.setBackground(new Color(0,0,0));
        c1.setForeground(Color.WHITE);
        panel.add(c1);

        JLabel labelDate = new JLabel("DATE & TIME :");
        labelDate.setBounds(35,316,150,14);
        labelDate.setFont(new Font("Roboto",Font.BOLD,14 ));
        labelDate.setForeground(Color.BLACK);
        panel.add(labelDate);


        Date date1 = new Date();
        date = new JLabel(""+date1);
        date.setBounds(271,316,250,14);
        date.setForeground(Color.BLACK);
        date.setFont(new Font("Roboto",Font.BOLD,14));
        panel.add(date);

        JLabel labelDeposite = new JLabel("DEPOSITE :");
        labelDeposite.setBounds(35,359,200,14);
        labelDeposite.setFont(new Font("Roboto",Font.BOLD,14 ));
        labelDeposite.setForeground(Color.BLACK);
        panel.add(labelDeposite);

        textFieldDeposite = new JTextField();
        textFieldDeposite.setBounds(271,359,150,22);
        textFieldDeposite.setBackground(new Color(0,0,0));
        textFieldDeposite.setForeground(Color.WHITE);
        panel.add(textFieldDeposite);

        b1 = new JButton("ADD");
        b1.setBounds(100,430,120,30);
        b1.setBackground(new Color(0,0,0));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        panel.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(260,430,120,30);
        b2.setBackground(new Color(0,0,0));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        panel.add(b2);

        setUndecorated(true);
        setSize(850,550);
        setLayout(null);
        setLocation(300,250);
        setVisible(true);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
        panel.setBorder(border);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String radioBTN = null;
        if (e.getSource() == b1) {
            // Input validation for required fields
            if (comboBox.getSelectedItem() == null || textFieldNumber.getText().isEmpty() || textName.getText().isEmpty() ||
                    (!r1.isSelected() && !r2.isSelected()) || textFieldDisease.getText().isEmpty() || c1.getSelectedItem() == null ||
                    textFieldDeposite.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (r1.isSelected()) {
                radioBTN = "Male";
            } else if (r2.isSelected()) {
                radioBTN = "Female";
            }
            String s1 = (String) comboBox.getSelectedItem();
            String s2 = textFieldNumber.getText();
            String s3 = textName.getText();
            String s4 = radioBTN;
            String s5 = textFieldDisease.getText();
            String s6 = c1.getSelectedItem();
            String s7 = date.getText();
            String s8 = textFieldDeposite.getText();
            try {
                conn c = new conn();
                String q = "insert into patient_info values ('" + s1 + "', '" + s2 + "', '" + s3 + "', '" + s4 + "', '" + s5 + "', '" + s6 + "', '" + s7 + "', '" + s8 + "')";
                String q1 = "update room set Availability = 'Occupied' where room_no = " + s6;
                c.statement.executeUpdate(q);
                c.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null, "added Successfully");
                setVisible(false);

            } catch (Exception E) {
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }




    }
    public static void main(String[] args){
        new NEW_PATIENT();
    }

}
