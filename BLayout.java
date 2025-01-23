import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class BLayout extends JFrame {
    JFrame f;
    JPanel p1,p2,p3,p4,p5;
    BLayout()
    {
        f=new JFrame("FRAME WITH PANEL");
        f.setSize(800,800);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());
        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();
        p4=new JPanel();
        p5=new JPanel();
        p1.setBounds(0,0,400,200);
        p2.setBounds(0,400,400,200);
        p3.setBounds(400,0,400,200);
        p4.setBounds(0,400,400,200);
        p5.setBounds(200,200,400,200);
         p1.setBackground(Color.red);
        p2.setBackground(Color.blue);
        p3.setBackground(Color.orange);
        p4.setBackground(Color.blue);
        p5.setBackground(Color.yellow);


        f.add(p1,BorderLayout.NORTH);
        f.add(p2,BorderLayout.SOUTH);
        f.add(p3,BorderLayout.EAST);
        f.add(p4,BorderLayout.WEST);
        f.add(p5,BorderLayout.CENTER);

        

        f.setVisible(true);
    }
   


    
     


    public static void main(String...args)
    {
        BLayout c=new BLayout();
    }
}