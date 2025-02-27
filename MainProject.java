import javax.swing.JFrame;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.JButton;
public class MainProject {
    public static void main(String[] args) throws Exception{

        JFrame frame = new JFrame("GUI App");
        frame.setSize(600, 400);

        JButton button1 = new JButton("View FeedBack");
        button1.setBounds(50, 100, 200, 80);
        button1.setFocusable(false);
        button1.setFont(new Font("Cascadia Code", Font.BOLD | Font.ITALIC, 20));
        button1.setForeground(Color.red);


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewfeedback.displayFrame();

            }
        });

        JButton button2 = new JButton("Give FeedBack");
        button2.setBounds(300, 100, 200, 80);
        button2.setFocusable(false);
        button2.setFont(new Font("Cascadia Code", Font.BOLD | Font.ITALIC, 20));
        button2.setForeground(Color.red);

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                GiveFeedBack.displayFrame();
            }
        });

        frame.add(button1);
        frame.add(button2);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
