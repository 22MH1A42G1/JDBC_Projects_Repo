import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;

public class JTextFieldExample {
    public static void main(String[] args) {

        JTextField tf = new JTextField();
        tf.setBounds(200, 200, 180, 60);
        tf.setFont(new Font("MV Boli", Font.PLAIN, 25));
        tf.setForeground(Color.blue);
        tf.setBackground(Color.black);


        JFrame frame = new JFrame("GUI App");
        frame.setSize(500, 500);
        // Adding component to the frame
        frame.add(tf);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
