import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.sound.sampled.*;
import java.io.File;

class Cal extends JFrame {
    JFrame f;

    Cal() {
        f = new JFrame("HAPPY REPUBLIC DAY");
        f.setSize(800, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());

        JLabel heading = new JLabel("Happy Republic Day", JLabel.CENTER);
        heading.setFont(new Font("Serif", Font.BOLD, 36));
        heading.setForeground(Color.BLUE);
        f.add(heading, BorderLayout.NORTH);

      
        JPanel p1 = new JPanel();
        p1.setBackground(Color.ORANGE);

        JPanel p2 = new JPanel();
        p2.setBackground(Color.WHITE);

        JPanel p3 = new JPanel();
        p3.setBackground(Color.GREEN);

        
        ImageIcon originalIcon = new ImageIcon("w.png"); 
        Image originalImage = originalIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(250, 150, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        JLabel imageLabel = new JLabel(resizedIcon);
        JPanel imagePanel = new JPanel(new BorderLayout());
        imagePanel.add(imageLabel, BorderLayout.CENTER);

        
        JPanel mainPanel = new JPanel(new GridLayout(3, 1));
        mainPanel.add(p1);
        mainPanel.add(imagePanel);
        mainPanel.add(p3);

        f.add(mainPanel, BorderLayout.CENTER);

        
        JPanel bottomPanel = new JPanel(new BorderLayout());
        JLabel scrollingText = new JLabel("Jai Hind! Celebrating Unity in Diversity!", JLabel.CENTER);
        scrollingText.setFont(new Font("Serif", Font.BOLD, 24));
        scrollingText.setForeground(Color.RED);

        Timer timer = new Timer(100, new ActionListener() {
            int x = 0;
           
            public void actionPerformed(ActionEvent e) {
                x = (x + 1) % f.getWidth();
                scrollingText.setLocation(x, scrollingText.getY());
            }
        });
        timer.start();

        JButton anthemButton = new JButton("Play Anthem");
        anthemButton.addActionListener(e -> playNationalAnthem());
        anthemButton.setPreferredSize(new Dimension(150, 40));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(anthemButton);

        bottomPanel.add(scrollingText, BorderLayout.CENTER);
        bottomPanel.add(buttonPanel, BorderLayout.SOUTH);

        f.add(bottomPanel, BorderLayout.SOUTH);

     
        f.getRootPane().setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.ORANGE));

        f.setVisible(true);
    }

    
    private void playNationalAnthem() {
        try {
            File soundFile = new File("WhatsApp Audio 2025-01-14 at 9.49.33 PM.wav"); // Replace with the path to your .wav file
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String... args) {
        new Cal();
    }
}
