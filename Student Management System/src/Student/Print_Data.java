package Student;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class Print_Data implements ActionListener{
    JFrame f;
    JLabel id8,id,aid,id1,aid1,id2,aid2,id3,aid3,id4,aid4,id5,aid5,id6,aid6,id7,aid7,id9,id10,id11,id12,id13,id14,id15,id16,id17,lab;
    String reg_no,name,father,course,phone,email,age,dob,gpa;
    JButton b1,b2;
    ImageIcon icon;

    Print_Data(String r_no){
        try{
            conn con = new conn();
            String str = "select * from student where reg_no = '"+r_no+"'";
            ResultSet rs= con.s.executeQuery(str);

            while(rs.next()){

               
                name = rs.getString("name");
                father = rs.getString("fname");
                age = rs.getString("age");
                dob = rs.getString("dob");
                course = rs.getString("course");
                reg_no = rs.getString("reg_no");
                phone = rs.getString("phone");
                email = rs.getString("email");
                gpa = rs.getString("gpa");
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
 
        f=new JFrame("Print Data");
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
        

        id8 = new JLabel("Student Details");
        id8.setBounds(520,10,250,30);
        f.add(id8);
        id8.setFont(new Font("ubuntu",Font.BOLD,30));
        id9.add(id8);
        f.add(id9);

        id = new JLabel("Reg. no.");
        id.setBounds(350,70,120,30);
        id.setFont(new Font("ubuntu",Font.BOLD,20));
        id9.add(id);

        aid = new JLabel(reg_no);
        aid.setBounds(550,70,200,30);
        aid.setFont(new Font("ubuntu",Font.BOLD,20));
        id9.add(aid);

        id1 = new JLabel("Name:");
        id1.setBounds(350,120,100,30);
        id1.setFont(new Font("ubuntu",Font.BOLD,20));
        id9.add(id1);

        aid1 = new JLabel(name);
        aid1.setBounds(550,120,300,30);
        aid1.setFont(new Font("ubuntu",Font.BOLD,20));
        id9.add(aid1);

  
        id2 = new JLabel("Father's Name:"); 
        id2.setBounds(350,170,200,30);
        id2.setFont(new Font("ubuntu",Font.BOLD,20));
        id9.add(id2);

        aid2 = new JLabel(father);
        aid2.setBounds(550,170,300,30);
        aid2.setFont(new Font("ubuntu",Font.BOLD,20));
        id9.add(aid2);

        id3= new JLabel("Course:");
        id3.setBounds(350,220,100,30);
        id3.setFont(new Font("ubuntu",Font.BOLD,20));
        id9.add(id3);

        aid3= new JLabel(course);
        aid3.setBounds(550,220,300,30);
        aid3.setFont(new Font("ubuntu",Font.BOLD,20));
        id9.add(aid3);


        id4= new JLabel("Phone:");  
        id4.setBounds(350,270,100,30);
        id4.setFont(new Font("ubuntu",Font.BOLD,20));
        id9.add(id4);

        aid4= new JLabel(phone);
        aid4.setBounds(550,270,300,30); 
        aid4.setFont(new Font("ubuntu",Font.BOLD,20));
        id9.add(aid4);

        
        id5= new JLabel("Email Id:");
        id5.setBounds(350,320,100,30);
        id5.setFont(new Font("ubuntu",Font.BOLD,20));
        id9.add(id5);

        aid5= new JLabel(email);
        aid5.setBounds(550,320,300,30);
        aid5.setFont(new Font("ubuntu",Font.BOLD,20));
        id9.add(aid5);

        
        id6= new JLabel("GPA:");
        id6.setBounds(350,370,100,30);
        id6.setFont(new Font("ubuntu",Font.BOLD,20));
        id9.add(id6);

        aid6= new JLabel(gpa);
        aid6.setBounds(550,370,300,30); 
        aid6.setFont(new Font("ubuntu",Font.BOLD,20));
        id9.add(aid6);


        id7= new JLabel("DOB:");
        id7.setBounds(350,420,100,30);
        id7.setFont(new Font("ubuntu",Font.BOLD,20));
        id9.add(id7);

        aid7= new JLabel(dob);
        aid7.setBounds(550,420,300,30);
        aid7.setFont(new Font("ubuntu",Font.BOLD,20));
        id9.add(aid7);

        
        b1=new JButton("Print");
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        b1.setBounds(400,520,150,40);
        b1.setFont(new Font("Ubuntu", Font.PLAIN, 24));
        b1.addActionListener(this);
        id9.add(b1);

        b2=new JButton("Cancel");
        b2.setBackground(Color.BLUE);
        b2.setForeground(Color.WHITE);
        b2.setBounds(600,520,150,40);
        b2.setFont(new Font("Ubuntu", Font.PLAIN, 24));
        b2.addActionListener(this);
        id9.add(b2);


    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b1){
            JOptionPane.showMessageDialog(null,"printed successfully");
            f.setVisible(false);
            details d=new details();
        }
        if(ae.getSource()==b2){
            f.setVisible(false);
            new View();
        }
    }
    public static void main(String[] args){
        new Print_Data("Print Data");
    }

}
