package Student;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Remove implements ActionListener{
    JFrame f;
    JTextField t;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JButton b,b1,b2,b3;

    Remove(){
        f=new JFrame("Remove Student");
        f.setBackground(Color.green);   
        f.setLayout(null);

        l5=new JLabel();
        l5.setBounds(0,0,1280,720);
        l5.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Student/project_images/search.png"));
        l5.setIcon(img);
        f.add(l5);

        
        l1=new JLabel("Reg.no.");
        l1.setBounds(550,50,250,30);
        l1.setForeground(Color.black);
        Font f2 = new Font("ubuntu",Font.BOLD,25); 
        l1.setFont(f2);
        l5.add(l1);

        t=new JTextField();
        t.setBounds(750,50,200,30);
        t.setFont(new Font("Ubuntu", Font.PLAIN, 20));
        l5.add(t);


        b=new JButton("Search");
        b.setBounds(700,100,150,40);
        b.setFont(new Font("Ubuntu", Font.PLAIN, 20));
        b.setForeground(Color.white);
        b.setBackground(Color.blue);
        b.addActionListener(this);
        l5.add(b);

        b3=new JButton("Back");
        b3.setBounds(860,100,150,40);   
        b3.setFont(new Font("Ubuntu", Font.PLAIN, 20));
        b3.setForeground(Color.white);
        b3.setBackground(Color.blue);
        b3.addActionListener(this);
        l5.add(b3);


        l2=new JLabel("Name:"); 
        l2.setBounds(550,350,250,30);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Ubuntu", Font.PLAIN, 24));
        l5.add(l2);

        l6=new JLabel();    
        l6.setBounds(700,350,350,30);
        l6.setForeground(Color.BLACK);
        l6.setFont(new Font("Ubuntu", Font.PLAIN, 24));
        l5.add(l6);

        l3=new JLabel("Mobile No:");
        l3.setBounds(550,400,250,30);
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Ubuntu", Font.PLAIN, 24));
        l5.add(l3);


        l7=new JLabel();
        l7.setBounds(700,400,350,30);
        l7.setForeground(Color.BLACK);
        l7.setFont(new Font("Ubuntu", Font.PLAIN, 24));
        l5.add(l7);



        l4=new JLabel("Email Id:");
        l4.setBounds(550,450,250,30);
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("Ubuntu", Font.PLAIN, 24));
        l5.add(l4);

        l8=new JLabel();
        l8.setBounds(700,450,350,30);
        l8.setForeground(Color.BLACK);
        Font f8=(new Font("Ubuntu", Font.PLAIN, 24));
        l8.setFont(f8);
        l5.add(l8);

        b1=new JButton("Remove");
        b1.setBounds(620,500,150,40);
        b1.setFont(new Font("Ubuntu", Font.PLAIN, 24));
        b1.setForeground(Color.white);
        b1.setBackground(Color.blue);
        b1.addActionListener(this);
        l5.add(b1);


        b2=new JButton("Cancel");
        b2.setBounds(900,500,150,40);
        b2.setFont(new Font("Ubuntu", Font.PLAIN, 24));
        b2.setForeground(Color.white);
        b2.setBackground(Color.blue);
        b2.addActionListener(this);
        l5.add(b2);
        l2.setVisible(false);
        l3.setVisible(false);
        l4.setVisible(false);
        b1.setVisible(false);
        b2.setVisible(false);

        f.setSize(1280,720);
        f.setLocation(0,0);  
        f.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b){
            try{
                conn con = new conn();
                String str = "select name,phone,email from student where reg_no ='"+t.getText()+"' ";
                ResultSet rs = con.s.executeQuery(str);

                int i=0;
                if(rs.next()){
                    String name = rs.getString(1);
                    String mob = rs.getString(2);
                    String email=rs.getString(3);

                    l2.setVisible(true);
                    l3.setVisible(true);
                    l4.setVisible(true);
                    b1.setVisible(true);
                    b2.setVisible(true);    
                    i=1;
                    l6.setText(name);
                    l7.setText(mob);
                    l8.setText(email);
                }
                if(i==0)
                    JOptionPane.showMessageDialog(null,"Id not found");
            }catch(Exception ex){}
        }
        if(ae.getSource()==b1){
            try{
                conn con = new conn();
                String str = "delete from student where reg_no = '"+t.getText()+"'";
                con.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"deleted successfully");
                l2.setVisible(false);
                l3.setVisible(false);
                l4.setVisible(false);
                l6.setVisible(false);
                l7.setVisible(false);
                l8.setVisible(false);
                b1.setVisible(false);
                b2.setVisible(false);

            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"Exception occured while delting record "+ex);
            }
        }
        if(ae.getSource()==b2){
            f.setVisible(false);
            details d=new details();
        }
        if(ae.getSource()==b3){
            f.setVisible(false);
            details d=new details();
        }
    }

    public static void main(String[]ar){
        new Remove();
    }
}