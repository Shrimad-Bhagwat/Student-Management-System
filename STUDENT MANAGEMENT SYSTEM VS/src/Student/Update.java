package Student;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

class Update extends Add implements ActionListener{

    JFrame f;
    JLabel id,id1,id2,id3,id4,id5,id6,id7,id8,id9,id10,id11,id12,id15,lab,lab1;
    JTextField t,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
    JButton b,b1,b2,b3; 
    String r_no;

    Update(String idaa){
        super(0);
        f=new JFrame("Update Student details");
        f.setVisible(true);
        f.setSize(1280,720);
        f.setLocation(0,0);
        f.setBackground(Color.white);
        f.setLayout(null);

        r_no=idaa;    
        id15=new JLabel();
        id15.setBounds(0,0,1280,720);
        id15.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Student/project_images/backgroud.png"));
        id15.setIcon(img);

        id8 = new JLabel("Update Student Details");
        id8.setBounds(450,10,500,50);
        id8.setFont(new Font("ubuntu",Font.BOLD,30));
        id8.setForeground(Color.BLUE);
        id15.add(id8);
        f.add(id15);


        id1 = new JLabel("Name:");  
        id1.setBounds(250,100,100,30);
        id1.setFont(new Font("ubuntu",Font.PLAIN, 24));
        id15.add(id1);

        t1=new JTextField();
        t1.setBounds(360,100,200,30);
        t1.setFont(new Font("ubuntu",Font.PLAIN, 20));
        id15.add(t1);

        id2 = new JLabel("Father's Name:");
        id2.setBounds(600,100,200,30);
        id2.setFont(new Font("ubuntu",Font.PLAIN, 24));
        id15.add(id2);

        t2=new JTextField();
        t2.setBounds(800,100,200,30);
        t2.setFont(new Font("ubuntu",Font.PLAIN, 20));
        id15.add(t2);

        id3= new JLabel("Course:");
        id3.setBounds(250,150,100,30);
        id3.setFont(new Font("ubuntu",Font.PLAIN, 24));
        id15.add(id3);

        t3=new JTextField();
        t3.setBounds(360,150,200,30);
        t3.setFont(new Font("ubuntu",Font.PLAIN, 20));
        id15.add(t3);

        id4= new JLabel("Phone:");
        id4.setBounds(600,150,100,30);
        id4.setFont(new Font("ubuntu",Font.PLAIN, 24));
        id15.add(id4);

        t4=new JTextField();
        t4.setBounds(800,150,200,30);   
        t4.setFont(new Font("ubuntu",Font.PLAIN, 20));
        id15.add(t4);

        id5= new JLabel("Email:");
        id5.setBounds(250,200,100,30);
        id5.setFont(new Font("ubuntu",Font.PLAIN, 24));
        id15.add(id5);

        t5=new JTextField();
        t5.setBounds(360,200,200,30);
        t5.setFont(new Font("ubuntu",Font.PLAIN, 20));
        id15.add(t5);

        id6= new JLabel("GPA:");
        id6.setBounds(600,200,100,30);
        id6.setFont(new Font("ubuntu",Font.PLAIN, 24));    
        id15.add(id6);

        t6=new JTextField();
        t6.setBounds(800,200,200,30);
        t6.setFont(new Font("ubuntu",Font.PLAIN, 20));
        id15.add(t6);



        b=new JButton("Update");
        b.setBounds(400,400,150,40);
        b.setFont(new Font("ubuntu",Font.BOLD, 24));
        b.addActionListener(this);
        b.setForeground(Color.white);
        b.setBackground(Color.blue);
        id15.add(b);

        b1=new JButton("Cancel");
        b1.setBounds(600,400,150,40);
        b1.setFont(new Font("ubuntu",Font.BOLD, 24));
        b1.addActionListener(this);
        b1.setForeground(Color.white);
        b1.setBackground(Color.blue);
        id15.add(b1);

        showData(idaa);
    }

    int i=0;
    String age,dat;

    void showData(String r_no){
        try{
            conn con = new conn();
            String str = "select * from student where reg_no = '"+r_no+"'";
            ResultSet rs = con.s.executeQuery(str);

            if(rs.next()){
                f.setVisible(true);
                i=1;

                t1.setText(rs.getString(1));
                t2.setText(rs.getString(2));
                t3.setText(rs.getString(5));
                t4.setText(rs.getString(7));
                t5.setText(rs.getString(8));
                t6.setText(rs.getString(9));

            }
            if(i==0)
                JOptionPane.showMessageDialog(null,"Id not found");
            new Search();
        }catch(Exception ex){}
        f.setVisible(true);
        f.setSize(1280,720);
        f.setLocation(0,0);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b && i==1){
            try{
                conn con = new conn();
                String str = "update student set name='"+t1.getText()+"',fname='"+t2.getText()+"',course='"+t3.getText()+"',phone='"+t4.getText()+"',email='"+t5.getText()+"',gpa='"+t6.getText()+"' where reg_no='"+r_no+"'";
                con.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Successfully Updated");
                f.setVisible(false);
                new Search();
            }catch(Exception e){
                System.out.println("The error is:"+e);
            }
        }
        if(ae.getSource()==b1){
            f.setVisible(false);
            details d=new details();
        }
    }

    public static void main(String[] arg){
        new Update("Update Employee");
    }
}



