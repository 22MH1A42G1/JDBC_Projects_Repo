import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpeReaction {
    public static void main(String[] args){
        JFrame frame = new JFrame("GUI app");
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JButton button1 = new JButton("button1");
        button1.setBounds(100,40,150,60);
        button1.setFocusable(false);
        button1.setFont(new Font("Comic Sans Ms",1,25));
        button1.setForeground(Color.red);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("hey! i am button 1");
            }
        });
        frame.add(button1);

        JButton button2 = new JButton("button2");
        button2.setBounds(100,110,150,60);
        button2.setFocusable(false);
        button2.setFont(new Font("Comic Sans Ms",1,25));
        button2.setForeground(Color.red);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("hey! i am button 2");
            }
        });
        frame.add(button2);

        JTextField tf = new JTextField();
        tf.setBounds(100,250,150,60);
        tf.setFont(new Font("MV Boli", Font.PLAIN, 25));
        tf.setForeground(Color.blue);
        tf.setBackground(Color.black);

        // Adding component to the frame
        frame.add(tf);

        JButton button3 = new JButton("button2");
        button3.setBounds(100,180,150,60);
        button3.setFocusable(false);
        button3.setFont(new Font("Comic Sans Ms",1,25));
        button3.setForeground(Color.red);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s=tf.getText();
                System.out.println("hey"+s);
                tf.setText("");
            }
        });
        frame.add(button3);



    }
}
