import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.ImageIcon;

public class JFrameExample {
    public static void main(String[] args) {

        
        // JFrame --> javax.swing
        // Creates a GUI window
        JFrame frame = new JFrame();

        // Changing Icon in the frame
        ImageIcon image = new ImageIcon("C:\\Users\\LENOVO\\Pictures\\Camera Roll\\avatar.jpg");
        frame.setIconImage(image.getImage());

//        frame.getContentPane().setBackground(Color.cyan);
        frame.getContentPane().setBackground(new Color(255, 255, 255));
        // setTitle(titleString)
        frame.setTitle("First GUI");
        // setResizable(false)
        frame.setResizable(false);
        // setSize(width, height)
        frame.setSize(500, 500);
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setVisible(true) --> The visibility of the Frame
        frame.setVisible(true);
    }
}