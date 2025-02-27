import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class FeedBackFrame extends GiveFeedBack {
    public static void displayFeedBack() {
        JLabel label=new JLabel("you are giving feedback to");
        label.setOpaque(true);
        label.setBounds(20,50,300,40);
        label.setFont(new Font("Cascadia Code", Font.BOLD | Font.ITALIC, 20));

        JFrame frame = new JFrame("Faculty FeedBack");
        JButton button=new JButton("Submit");
        button.setBounds(250,300,100,30);

        JPanel panel = new JPanel();
        ButtonGroup buttonGroup = new ButtonGroup();


        JRadioButton button1 = new JRadioButton("Below Average");
        JRadioButton button2 = new JRadioButton("Average");
        JRadioButton button3 = new JRadioButton("Good");
        JRadioButton button4 = new JRadioButton("Excellent");

        button1.setBounds(80, 110, 150, 50);
        button2.setBounds(80, 160, 80, 50);
        button3.setBounds(80, 210, 80, 50);
        button4.setBounds(80, 260, 80, 50);

        buttonGroup.add(button1);
        buttonGroup.add(button2);
        buttonGroup.add(button3);
        buttonGroup.add(button4);

        // Add radio buttons to the panel
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);

        // Setting initial selection
        button1.setSelected(false);

        // Adding a selection listener to the radio buttons
        ActionListener radioListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AbstractButton selectedButton = (AbstractButton) e.getSource();

                // Hiding the previously selected button
                for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
                    AbstractButton button = buttons.nextElement();
                    if (button != selectedButton) {
                        button.setVisible(true);
                    }
                }
            }
        };

        button1.addActionListener(radioListener);
        button2.addActionListener(radioListener);
        button3.addActionListener(radioListener);
        button4.addActionListener(radioListener);



        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Are you sure to conform", "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        frame.add(panel);
        frame.add(label);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        frame.add(button);
        frame.setSize(500,400);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
