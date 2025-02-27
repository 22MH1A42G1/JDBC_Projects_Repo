import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JRadioButtionexample {
    public static void main(String[] agrs){

        JFrame fr= new JFrame("TRAFFIC SIGNAL");
        fr.setSize(500,500);
        fr.setLayout(null);

        JLabel l1=new JLabel();
        l1.setBounds(100,250,500,50);
        l1.setFont(new Font("Comic Sans Ms",1,50));
        fr.add(l1);

        JRadioButton r1 = new JRadioButton("RED");
        r1.setBounds(50,200,50,20);
        r1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                l1.setText("STOP");
                l1.setBounds(130,250,500,50);
                l1.setForeground(Color.red);
            }
        });
        fr.add(r1);

        JRadioButton r2 = new JRadioButton("GREEN");
        r2.setBounds(150,200,100,20);
        r2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                l1.setText("GO");
                l1.setBounds(150,250,500,50);
                l1.setForeground(Color.green);
            }
        });
        fr.add(r2);

        JRadioButton r3 = new JRadioButton("ORANGE");
        r3.setBounds(251,200,100,20);
        r3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                l1.setText("READY");
                l1.setBounds(90,250,500,50);
                l1.setForeground(Color.orange);
            }
        });
        fr.add(r3);

        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
