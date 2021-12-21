package Student;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class View implements ActionListener{

    JFrame f;
    JTextField t;
    JLabel l1,l2;
    JButton b,b2;

    View(){
        f=new JFrame("View");
        f.setBackground(Color.WHITE);
        f.setLayout(null);

        l1=new JLabel();
        l1.setBounds(0,0,1280,720);
        l1.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Student/project_images/search.png"));
        l1.setIcon(img);
        f.add(l1);

        l2=new JLabel("Reg. no.");
        l2.setVisible(true);
        l2.setBounds(700,200,250,40);
        l2.setForeground(Color.blue);
        l2.setFont(new Font("Ubuntu", Font.PLAIN, 40));
        l1.add(l2);
        
        l2.setFont(new Font("Ubuntu", Font.PLAIN, 24));

        t=new JTextField();
        t.setBounds(650,300,220,30);
        l1.add(t);
        t.setFont(new Font("Ubuntu", Font.PLAIN, 24));
        

        b=new JButton("Search");
        b.setBounds(600,400,150,40);
        b.addActionListener(this);
        b.setBackground(Color.BLUE);
        b.setForeground(Color.WHITE);
        l1.add(b);
        b.setFont(new Font("Ubuntu", Font.PLAIN, 24));


        b2=new JButton("Cancel");
        b2.setBounds(800,400,150,40);
        b2.addActionListener(this);
        b2.setBackground(Color.BLUE);
        b2.setForeground(Color.WHITE);
        l1.add(b2);
        b2.setFont(new Font("Ubuntu", Font.PLAIN, 24));

        f.setSize(1280,720);
        f.setLocation(0,0);
        f.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b2){
            f.setVisible(false);
            new details();
        }
        if(ae.getSource()==b){
            f.setVisible(false);
            new Print_Data(t.getText());
        }

    }

    public static void main(String[] args){
        new View();
    }
}