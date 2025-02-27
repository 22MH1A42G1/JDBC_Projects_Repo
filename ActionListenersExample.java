import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenersExample {
    public static void fun1() {
        System.out.println("Hey, I am Button 2");
    }
    public static void main(String[] args) {
        // JButton
        JButton button1 = new JButton("Button1");
        button1.setBounds(100, 40, 120, 60);
        button1.setFont(new Font("Times", Font.BOLD, 20));
        button1.setFocusable(false);
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hey, I am Button1");
            }
        });

        JButton button2 = new JButton("Button2");
        button2.setBounds(100, 110, 120, 60);
        button2.setFont(new Font("Times", Font.BOLD, 20));
        button2.setFocusable(false);
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fun1();
            }
        });

        // A textfield
        JTextField tf = new JTextField();
        tf.setBounds(100, 250, 120, 40);
        tf.setFont(new Font("Times", Font.BOLD, 20));

        JFrame frame = new JFrame("Button Example");
        frame.setSize(500, 500);

        JButton button3 = new JButton("Button3");
        button3.setBounds(100, 180, 120, 60);
        button3.setFont(new Font("Times", Font.BOLD, 20));
        button3.setFocusable(false);
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //
                String s = tf.getText();
                System.out.println("Hey, " + s);
                tf.setText("");
            }
        });



        // Adding components to frame
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(tf);

        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}