package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Ambulance extends JFrame{
    Ambulance(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(255,255,255));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(20,40,865,450);
        table.setBackground(new Color(255,255,255));
        table.setFont(new Font("Roboto",Font.BOLD,12));
        panel.add(table);

        try{
            conn c = new conn();
            String q = "select * from Ambulance";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("Name");
        label1.setBounds(106,11,100,18);
        label1.setFont(new Font("Roboto",Font.BOLD,14));
        panel.add(label1);

        JLabel label2 = new JLabel("Gender");
        label2.setBounds(325,11,100,18);
        label2.setFont(new Font("Roboto",Font.BOLD,14));
        panel.add(label2);

        JLabel label3 = new JLabel("Car_id");
        label3.setBounds(531,11,100,18);
        label3.setFont(new Font("Roboto",Font.BOLD,14));
        panel.add(label3);

        JLabel label4 = new JLabel("Age");
        label4.setBounds(750,11,100,18);
        label4.setFont(new Font("Roboto",Font.BOLD,14));
        panel.add(label4);


        JButton button = new JButton("BACK");
        button.setBounds(380,510,120,30);
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
        setSize(900,600);
        setLayout(null);
        setLocation(300,200);
        setVisible(true);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
        panel.setBorder(border);
    }
    public static void main(String[] args) {
        new Ambulance();
    }
}

