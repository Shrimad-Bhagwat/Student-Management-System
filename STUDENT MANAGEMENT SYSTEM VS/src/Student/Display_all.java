package Student;

import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class Display_all implements ActionListener{
    JFrame f;
    JLabel id8,id,aid,id1,aid1,id2,aid2,id3,aid3,id4,aid4,id5,aid5,id6,aid6,id7,aid7,id9,id10,id11,id12,id13,id14,id15,id16,id17,lab;
    String reg_no,name,father,course,phone,email,age,dob,gpa;
    JButton b1,b2;
    ImageIcon icon;
    JTextField t,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
    JTable jt;
    
    
    Display_all(){

        f=new JFrame("View All");
        f.setVisible(true);
        f.setSize(1280,720);
        f.setLocation(0,0);
        f.setBackground(Color.white);
        f.setLayout(null);


        id9=new JLabel();
        id9.setBounds(0,0,1280,720);
        id9.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Student/project_images/backgroud.png"));
        id9.setIcon(img);
        

        id8 = new JLabel("Students Details");
        id8.setBounds(450,10,250,30);
        f.add(id8);
        id8.setFont(new Font("ubuntu",Font.BOLD,30));
        id9.add(id8);
        f.add(id9);
    	
        ArrayList<String> name_list = new ArrayList<String>(); 
        ArrayList<String> reg_no_list = new ArrayList<String>(); 
        
        
    	try{
            conn con = new conn();
            String str = "select name,reg_no from student";
            ResultSet rs= con.s.executeQuery(str);
            

            
            id = new JLabel("Reg. no.");
            id.setBounds(50,70,120,30);
            id.setFont(new Font("ubuntu",Font.PLAIN,20));
            id9.add(id);

            id1 = new JLabel("Name:");
            id1.setBounds(200,70,200,30);
            id1.setFont(new Font("ubuntu",Font.PLAIN,20));
            id9.add(id1);
            
            while(rs.next()){
                name = rs.getString("name");
                reg_no = rs.getString("reg_no");
                
                name_list.add(name);
                reg_no_list.add(reg_no);

            }
            
            int y_bound = 120;
            
            for(int i=0; i < name_list.size(); i++) {
            	
            	
	            aid = new JLabel(reg_no_list.get(i));
	            aid.setBounds(50,y_bound,150,30);
	            aid.setFont(new Font("ubuntu",Font.PLAIN,20));
	            id9.add(aid);
	
	
	            aid1 = new JLabel(name_list.get(i));
	            aid1.setBounds(200,y_bound,300,30);
	            aid1.setFont(new Font("ubuntu",Font.PLAIN,20));
	            id9.add(aid1);
	            y_bound += 50;
            }
           
        }catch(Exception e){
            e.printStackTrace();
        }
 
        b2=new JButton("Back");
        b2.setBackground(Color.BLUE);
        b2.setForeground(Color.WHITE);
        b2.setBounds(900,30,120,40);
        b2.addActionListener(this);
        b2.setFont(new Font("ubuntu",Font.BOLD,24));
        id9.add(b2);


    }

   
	public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b1){
            
            f.setVisible(false);
            new details();
        }
        if(ae.getSource()==b2){
            f.setVisible(false);
            new details();
        }
    }
    public static void main(String[] args){
        new Print_Data("Print Data");
    }

}
