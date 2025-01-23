import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Calculator extends JFrame implements ActionListener
{
    JFrame f;
    JButton b1;
    JTextField t1,t2,t3,t4;
    JLabel l1;
    int result;
    Calculator()
    {
        f=new JFrame("Calculator");
        f.getContentPane().setBackground(new Color(0x123456));
        f.setSize(400,400);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        t1=new JTextField("NUM1");
        t1.setBounds(180,240,80,30);
        t1.setBackground(Color.white);
         t1.setForeground(Color.black);
         t2=new JTextField("NUM2");
        t2.setBounds(180,270,80,30);
         t2.setBackground(Color.white);
         t2.setForeground(Color.black);
         t4=new JTextField("OPeration u wanna perform ex:+");
        t4.setBounds(180,300,100,40);
         t4.setBackground(Color.white);
         t4.setForeground(Color.black);
         
         b1=new JButton("Enter");
         b1.setBounds(180,330,80,30);
         b1.setBackground(Color.green);
         b1.setForeground(Color.white);
         b1.addActionListener(this);
        f.add(t1);
        f.add(t2);
        f.add(t4);
        f.add(b1);
        
        f.setVisible(true);
       


    }
     public void actionPerformed(ActionEvent ae)
        {
        
    String num1Str = t1.getText();
    String num2Str = t2.getText();
    String p = t4.getText();

   
    int num1 = Integer.parseInt(num1Str);
    int num2 = Integer.parseInt(num2Str);
    char op = p.charAt(0);

    if(op=='+')
    result = num1 + num2;
    else if(op=='-')
    result = num1 - num2;
    else if(op=='*')
    result = num1 * num2;
    else if(op=='/')
    result = num1 / num2;

    // Create a new JTextField for the result
    t3 = new JTextField("Result:"+Integer.toString(result));

        t3.setBounds(180,300,80,30);
         t3.setBackground(Color.green);
         t3.setForeground(Color.white);
        t3.setEditable(false);
        f.add(t3);


        }
}
class M
{
    public static void main(String...args)
    {
        Calculator c=new Calculator();
    }
}