import javax.swing.*;
import java.awt.*;
import java.util.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent; //class
import java.awt.event.MouseListener; // interface
public class JComboBoxTask {
    public static void main(String[] args) {
        //label

        JFrame frame = new JFrame("Test");
        JLabel Label=new JLabel();
        Label.setBounds(100,100,300,300);
        Label.setBackground(Color.black);
        Label.setOpaque(true);

        //combobox
        String[] boxitems={"red","green","black","blue"};
        JComboBox box=new JComboBox(boxitems);
        box.setBounds(200,200,100,30);
        box.setFont(new Font("Comic Sans MS",Font.BOLD,20));
        box.setBackground(Color.white);
        box.setSelectedItem(null);


        //jbutton

        JButton button=new JButton("Click Me");
        button.setBounds(210,250,80,30);
        button.setFocusable(false);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //System.out.println("you picked"+ box.getSelectedItem());
                if(box.getSelectedItem().equals("red")){
                    Label.setBackground(Color.red);
                }
                if(box.getSelectedItem().equals("green")){
                    Label.setBackground(Color.green);
                }

                if(box.getSelectedItem().equals("black")){
                    Label.setBackground(Color.black);
                }
                if(box.getSelectedItem().equals("blue")){
                    Label.setBackground(Color.blue);
                }

                JOptionPane.showMessageDialog(null,"you Picked"+ box.getSelectedItem()+"Message" +JOptionPane.INFORMATION_MESSAGE);
            }
        });


        //frame

        frame.add(button);
        frame.add(box);
        frame.add(Label);// adding label to frame
        frame.setLayout(null);
        frame.setSize(500,500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
