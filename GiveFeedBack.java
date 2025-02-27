import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class GiveFeedBack {
    public static void displayFrame(){
        //JLabel
        JLabel label=new JLabel("Select a Subject");
        label.setBounds(150,50,300,80);
        label.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        //JComboBox
        String[] boxItems={"Java","AIML","DBMS","M3","MFCS"};
        JComboBox box=new JComboBox(boxItems);
        box.setBounds(150,150,200,50);
        box.setFont(new Font("Comic Sans MS",Font.ITALIC + Font.BOLD,20));
        box.setBackground(Color.WHITE);
        box.setSelectedItem(null);

        //JButton
        JButton button=new JButton("Select");
        button.setBounds(350,350,80,40);
        button.setFocusable(false);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FeedBackFrame.displayFeedBack();
            }
        });


        //Jframe
        JFrame frame=new JFrame("Combo Example");

        frame.add(label);
        frame.add(box);
        frame.add(button);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
