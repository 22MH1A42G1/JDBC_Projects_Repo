import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class TextAreaExample1 {
    public static void main(String[] args) {
        JTextArea area = new JTextArea();
        area.setBounds(100,100,400,400);
        area.setFont(new Font("MV Boli",Font.BOLD,30));
        String s = "This\nis\nText\nArea";
        area.setText(s);

        JFrame frame = new JFrame("Hello");
        frame.setLayout(new FlowLayout());
        frame.add(new JButton("Button1"));
        frame.add(new JButton("Button2"));
        frame.add(new JButton("Button3"));
        frame.add(new JButton("Button4"));
        frame.add(new JButton("Button5"));
        frame.add(new JButton("Button6"));
        frame.add(new JButton("Button7"));
        frame.add(new JButton("Button8"));
        //frame.add(area);
        //frame.setLayout(null);
        frame.setSize(600,600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
