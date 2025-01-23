import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

class GMail extends JFrame implements ActionListener {

    JFrame frame, f, f1;
    JButton button, button1;

    GMail() {
        frame = new JFrame("GMail");
        frame.setSize(400, 400);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(0x123456));
        frame.setLayout(null);

        button1 = new JButton("SignUp");
        button1.setBounds(600, 250, 80, 50);
        button1.setBackground(Color.white);
        button1.setForeground(Color.black);
        button1.setFocusable(false);

        button = new JButton("Login");
        button.setBounds(600, 210, 80, 50);
        button.setBackground(Color.white);
        button.setForeground(Color.black);
        button.setFocusable(false);

        frame.add(button1);
        frame.add(button);
        frame.setVisible(true);

        button.addActionListener(this);
        button1.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            frame.dispose();
            f = new JFrame("Login");
            f.setSize(400, 400);
            f.setLayout(null);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setResizable(true);
            f.getContentPane().setBackground(new Color(0x123456));

            JLabel usernameLabel = new JLabel("Username");
            usernameLabel.setBounds(600, 220, 100, 20);
            usernameLabel.setForeground(Color.WHITE); 
            f.add(usernameLabel);

            JTextField b1 = new JTextField(20);
            b1.setBounds(600, 250, 200, 30);

            JLabel passwordLabel = new JLabel("Password");
            passwordLabel.setBounds(600, 290, 100, 20);
            passwordLabel.setForeground(Color.WHITE); 
            f.add(passwordLabel);

            JPasswordField b2 = new JPasswordField(20);
            b2.setBounds(600, 330, 200, 30);
            b2.setEchoChar('*');

            JButton b3 = new JButton("Enter");
            b3.setBackground(Color.green);
            b3.setForeground(Color.white);
            b3.setFocusable(false);
            b3.setBounds(650, 390, 100, 30);

            b3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "0709"); // Replace with your credentials
                        String q = "select isAvailable from data where username=? and password=?";
                        PreparedStatement stmt = con.prepareStatement(q);

                        String user = b1.getText();
                        String pass = new String(b2.getPassword());

                        stmt.setString(1, user);
                        stmt.setString(2, pass);

                        ResultSet r = stmt.executeQuery();

                        if (r.next()) {
                            boolean isAvailable = r.getBoolean(1);
                            if (isAvailable) {
                                JOptionPane.showMessageDialog(f, "Logged in successfully!!");
                            } else {
                                JOptionPane.showMessageDialog(f, "Invalid username or password");
                            }
                        } else {
                            JOptionPane.showMessageDialog(f, "Invalid username or password");
                        }
                        con.close();
                    } catch (Exception ae) {
                        System.out.println(ae);
                    }
                }
            });

            f.add(b1);
            f.add(b2);
            f.add(b3);
            f.setVisible(true);
        } else if (e.getSource() == button1) {
            frame.dispose();
            f1 = new JFrame("Signup");
            f1.setSize(400, 400);
            f1.setLayout(null);
            f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f1.setResizable(true);
            f1.getContentPane().setBackground(new Color(0x123456));

            JLabel usernameLabel = new JLabel("Username");
            usernameLabel.setBounds(600, 220, 100, 20);
            usernameLabel.setForeground(Color.WHITE); 
            f1.add(usernameLabel);

            JTextField b1 = new JTextField(20);
            b1.setBounds(600, 250, 200, 30);

            JLabel passwordLabel = new JLabel("Password");
            passwordLabel.setBounds(600, 290, 100, 20);
            passwordLabel.setForeground(Color.WHITE); 
            f1.add(passwordLabel);

            JPasswordField b2 = new JPasswordField(20);
            b2.setBounds(600, 330, 200, 30);
            b2.setEchoChar('*');

            JLabel confirmPasswordLabel = new JLabel("Confirm Password");
            confirmPasswordLabel.setBounds(600, 370, 100, 20);
            confirmPasswordLabel.setForeground(Color.WHITE); 
            f1.add(confirmPasswordLabel);

            JPasswordField b3 = new JPasswordField(20);
            b3.setBounds(600, 400, 200, 30);
            b3.setEchoChar('*');

            JButton b4 = new JButton("Enter");
            b4.setBackground(Color.green);
            b4.setForeground(Color.white);
            b4.setFocusable(false);
            b4.setBounds(650, 460, 100, 30);

            b4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        String password = new String(b2.getPassword());
                        String confirmPassword = new String(b3.getPassword());

                        if (!password.equals(confirmPassword)) {
                            JOptionPane.showMessageDialog(f1, "Passwords do not match.");
                            return;
                        }

                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "0709"); // Replace with your credentials
                        String q = "insert into data (username, password, isAvailable) values (?, ?, ?)";
                        PreparedStatement stmt = con.prepareStatement(q);

                        String user = b1.getText();
                        boolean isAvailable = true;

                        stmt.setString(1, user);
                        stmt.setString(2, password);
                        stmt.setBoolean(3, isAvailable);

                        stmt.executeUpdate();
                        con.close();
                        JOptionPane.showMessageDialog(f1, "Signup successful!");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(f1, "These credentials already exist try to sign up with new credentials ");
                    }
                }
            });

            f1.add(b1);
            f1.add(b2);
            f1.add(b3);
            f1.add(b4);
            f1.setVisible(true);
        }
    }

    public static void main(String args[]) {
        new GMail();
    }
}