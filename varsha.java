import java.util.*;

import javax.swing.*;

import javax.swing.JLabel;

import javax.swing.JButton;

import javax.swing.border.Border;

import javax.swing.BorderFactory;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

import java.sql.*;



class GMail extends JFrame implements ActionListener{

    JFrame frame,f,f1;

    JButton button;

    JButton button1;

   

    GMail()

    {

       // frame=new JFrame("GMail"); in this way we can write frame title and name at a time

       frame=new JFrame();

       frame.setTitle("GMail");

       frame.setSize(400,400);

       frame.setResizable(true);

       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;

       frame.getContentPane().setBackground(new Color(0x123456));

       frame.setLayout(null);

       

      button1=new JButton();

       button1.setText("SignUp");

       button1.setBounds(480,250,80,50);

       button1.setBackground(Color.white);

       button1.setForeground(Color.black);

       button1.setFocusable(false);

       button=new JButton();

       button.setText("Login");

       button.setBounds(480,210,80,50);

       button.setBackground(Color.white);

       button.setForeground(Color.black);

       button.setFocusable(false);  



       frame.add(button1);

       frame.add(button);

       frame.setVisible(true);

        button.addActionListener(new ActionListener (){

         public void actionPerformed(ActionEvent e)

            {

               // frame.remove(button);

               //frame.remove(button1);

             

                  frame.dispose();

                f=new JFrame();

                f.setTitle("Login");

                f.setSize(400,400);

                f.setLayout(null);

                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                f.setResizable(true);

                f.getContentPane().setBackground(new Color(0x123456));

               

               

                JTextField b1=new JTextField("Username",20);

               

                b1.setBounds(200,250,100,30);

                JTextField b2=new JTextField("Password",20);

               

                b2.setBounds(200,290,100,30);

                 JButton b3=new JButton("Enter");

                  b3.setBackground(Color.white);

                   b3.setForeground(Color.black);

                   b3.setFocusable(false);  

               

                b3.setBounds(200,310,100,30);

                b3.addActionListener(new ActionListener(){

                        public void actionPerformed(ActionEvent e){

                           try{

                                 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","0709");

                                 String q="select isAvailable from data where username=? and password=?";

                                 PreparedStatement stmt=con.prepareStatement(q);

                                 String user=b1.getText();

                                 String pass=b1.getText();

                                 stmt.setString(1,user);

                                 stmt.setString(2,pass);

                                 ResultSet r=stmt.executeQuery();

                 

                                    if(r.getBoolean(1)){

                                 JOptionPane.showMessageDialog(f,"logged in successfully!!");}

                             

                                 else{

                                    JOptionPane.showMessageDialog(f,"invalid");

                                 }

                           }

                           catch(Exception ae)

                           {

                              System.out.println(ae);

                           }



                        }



                });

                f.add(b1);

                f.add(b2);

                f.add(b3);

                f.setVisible(true);

            }

        });





      button1.addActionListener(new ActionListener (){

          public void actionPerformed(ActionEvent e)

            {

          frame.dispose();

                f1=new JFrame();

                f1.setTitle("Login");

                f1.setSize(400,400);

                f1.setLayout(null);

                f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                f1.setResizable(true);

                f1.getContentPane().setBackground(new Color(0x123456));

                f1.setVisible(true);

               

               

                JTextField b1=new JTextField("Username",20);

               

                b1.setBounds(200,250,100,30);

                JTextField b2=new JTextField("Password",20);

               

                b2.setBounds(200,290,100,30);

                 JButton b3=new JButton("Enter");

                  b3.setBackground(Color.white);

                   b3.setForeground(Color.black);

                   b3.setFocusable(false);  

               

                b3.setBounds(200,310,100,30);

               b3.addActionListener(new ActionListener(){

                        public void actionPerformed(ActionEvent e){

                           try{

                                 Connection con=DriverManager.getConnection("jdbc:/mysql://localhost:3306/project","root","0709");

                                 String q="insert into data values(username=?,password=?)";

                                 PreparedStatement stmt=con.prepareStatement(q);

                                 String user=b1.getText();

                                 String pass=b2.getText();

                                 stmt.setString(1,user);

                                 stmt.setString(2,pass);

                                 stmt.executeUpdate();

                                 con.close();

                           }

                           catch(Exception ae)

                           {

                              System.out.println(ae);

                           }

                                 

                        }



                });

                f1.add(b1);

                f1.add(b2);

                f1.add(b3);

               }

});





     //   button1.addActionListener(this);

     //  frame.setVisible(true);

        }

       

           

               

             

               

           

            //frame.dispose();

       

         public static void main(String args[]){

            new GMail();

             }

} this was my code