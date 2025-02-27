import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class interfacesEx {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Test");

        // Label
        JLabel label = new JLabel();
        label.setBounds(50, 50, 300, 300);
        label.setBackground(Color.BLACK);
        label.setOpaque(true);

        label.addMouseListener(new MouseListener() {
            public void mouseEntered(MouseEvent e) {
                label.setBackground(Color.GREEN);
            }

            public void mouseExited(MouseEvent e) {
                label.setBackground(Color.BLACK);
            }

            public void mousePressed(MouseEvent e) {
                label.setBackground(Color.BLUE);
            }

            public void mouseReleased(MouseEvent e) {
                label.setBackground(Color.YELLOW);
            }

            public void mouseClicked(MouseEvent e) {
                label.setBackground(Color.CYAN);
            }
        });

        frame.add(label);
        frame.setLayout(null);
        frame.setSize(500, 500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
