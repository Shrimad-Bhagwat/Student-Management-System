package Student;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class login  implements ActionListener{

    JFrame f;
    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;

    login(){

        f=new JFrame("Login");

        f.setBackground(Color.white);
        f.setLayout(null);

        l1 = new JLabel("Username");
        l1.setBounds(750,300,200,30);
        f.add(l1);
        l1.setFont(new Font("Ubuntu", Font.PLAIN, 24));
        
        l2 = new JLabel("Password");
        l2.setBounds(750,360,200,30);
        f.add(l2);
        l2.setFont(new Font("Ubuntu", Font.PLAIN, 24));
 
        t1=new JTextField();
        t1.setBounds(950,300,200,30);
        f.add(t1);
        t1.setFont(new Font("Ubuntu", Font.PLAIN, 24));

        t2=new JPasswordField();
        t2.setBounds(950,360,200,30);
        f.add(t2);
        t2.setFont(new Font("Ubuntu", Font.PLAIN, 24));
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Student/project_images/login.png"));
        Image i2 = i1.getImage().getScaledInstance(1280,720,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1280,720);
        f.add(l3);


        b1 = new JButton("Login");
        b1.setBounds(800,450,150,50);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        f.add(b1);
        b1.setFont(new Font("Ubuntu", Font.PLAIN, 24));

        b2=new JButton("Cancel");
        b2.setBounds(1000,450,150,50);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        f.add(b2);
        b2.setFont(new Font("Ubuntu", Font.PLAIN, 24));

        b2.addActionListener(this);
        
        f.getContentPane().setBackground(Color.WHITE);

        f.setVisible(true);
        f.setSize(1280,720);
        f.setLocation(0,0);

    }

    public void actionPerformed(ActionEvent ae){

        try{
            conn c1 = new conn();
            String u = t1.getText();
            String v = t2.getText();
            
            String q = "select * from login where username='"+u+"' and password='"+v+"'";
            
            ResultSet rs = c1.s.executeQuery(q); 
            if(rs.next()){
                new details().f.setVisible(true);
                f.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, "Invalid login");
                f.setVisible(false);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] arg){
        login l=new login();
    }
}