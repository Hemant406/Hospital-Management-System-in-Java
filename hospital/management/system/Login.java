package hospital.management.system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField textField;
    JPasswordField passwordField;
    JButton b1,b2;
    Login(){
        JLabel nameLabel = new JLabel("Username");
        nameLabel.setBounds(40,20,100,30);
        nameLabel.setFont(new java.awt.Font("Tahoma",java.awt.Font.BOLD,16));
        add(nameLabel);

        JLabel password = new JLabel("Password");
        password.setBounds(40,70,100,30);
        password.setFont(new java.awt.Font("Tahoma",java.awt.Font.BOLD,16));
        add(password);

        textField = new JTextField();
        textField.setBounds(150, 20, 150, 30);
        textField.setFont(new java.awt.Font("Tahoma",java.awt.Font.PLAIN,15));
        textField.setBackground(new java.awt.Color(255,179,0));
        add(textField);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 70, 150, 30);
        passwordField.setFont(new java.awt.Font("Tahoma",java.awt.Font.PLAIN,15));
        passwordField.setBackground(new java.awt.Color(255,179,0));
        add(passwordField);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i1  = imageIcon.getImage().getScaledInstance(500,500,java.awt.Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(320,-30,400,300);
        add(label);


        b1=new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new java.awt.Font("serif",java.awt.Font.BOLD,15));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new java.awt.Font("serif",java.awt.Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        getContentPane().setBackground(new Color(109,164,170));
        setSize(750,300);
        setLocation(400,270);
        setLayout(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
           try{
               conn c= new conn();
               String user = textField.getText();
               String pass = passwordField.getText();

               String q = "select  * from login where ID = '"+user+"'and PW = '"+pass+"'";
               ResultSet resultSet = c.statement.executeQuery(q);

               if(resultSet.next()){
                   new Reception();
                   setVisible(false);
               }
               else{
                   JOptionPane.showMessageDialog(null,"Invalid");
               }
           }catch(Exception E){
               E.printStackTrace();
           }
        }else{
            System.exit(10);
        }
    }
    public static void main(String[] args) {
        Login newLogin =new Login();
    }


}