import javax.swing.JFrame;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;

public class JButtonExample {
    public static void main(String[] args) {
        JButton button = new JButton("Submit");
        button.setBounds(200, 200, 170, 100);
        button.setFocusable(false);
        button.setFont(new Font("Cascadia Code", Font.BOLD | Font.ITALIC, 30));
        button.setForeground(Color.red);

        
        JFrame frame = new JFrame("GUI App");
        frame.setSize(500, 500);
        // Adding component to the frame
        frame.add(button);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
