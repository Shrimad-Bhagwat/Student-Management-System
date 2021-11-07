package Student;

import java.awt.*;
import javax.swing.*;
import java.lang.Thread;
import java.awt.event.*;

class Main implements ActionListener{
    JFrame f; 
    JLabel id,l1;
    JButton b;

    Main(){
 
        f=new JFrame("Student Management System");
        f.setBackground(Color.black);
        f.setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Student/project_images/front.png"));
        Image i2 = i1.getImage().getScaledInstance(1200,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        
        l1.setBounds(0,100,1360,530);
        f.add(l1);


        b = new JButton("Start");
        b.setBackground(Color.BLUE);
        b.setForeground(Color.WHITE);
        b.setOpaque(true);
        b.setFont(new Font("Ubuntu", Font.PLAIN, 24));
        

        b.setBounds(1100,600,150,50);
        b.addActionListener(this);

        id=new JLabel();
        id.setBounds(0,0,1360,750);
        id.setLayout(null);
        
   

        JLabel lid=new JLabel("");
        lid.setBounds(80,30,1500,100);
        lid.setFont(new Font("ubuntu",Font.PLAIN,70));
        lid.setForeground(Color.red);
        id.add(lid);

        id.add(b);
        f.add(id);
        
        
        f.getContentPane().setBackground(Color.WHITE);

        f.setVisible(true);
        f.setSize(1280,720);
        f.setLocation(0,0);

        while(true){
            lid.setVisible(false); 
            try{
                Thread.sleep(500); 
            }catch(Exception e){} 
            lid.setVisible(true);
            try{
                Thread.sleep(500);
            }catch(Exception e){}
        }

    }
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b){
            f.setVisible(false);
            new login();    
        }
    }

    public static void main(String[] arg){
        Main f = new Main();
    }
}

