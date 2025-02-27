import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;
public class TextAreaExample2 {
    public static void main(String[] args) {
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
        frame.setSize(600,600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
