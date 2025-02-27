import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class viewfeedback {
    public static Connection con;

    public static void displayFrame() {
        final String[] ggwk = {""};
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/team14", "root", "aditya");
            Statement st = con.createStatement();
            ResultSet s = st.executeQuery("select * from facultyfeedback;");
            ArrayList<String> str = new ArrayList<>();
            while (s.next()) {
                str.add(s.getString(2));
            }
            String[] arr = str.toArray(new String[0]);

            SwingUtilities.invokeLater(() -> {
                // JFrame
                JFrame f1 = new JFrame();
                f1.setSize(680, 400);
                f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // JLabel
                JLabel text1 = new JLabel("SELECT A TRAINER");
                text1.setBounds(250, 30, 200, 50);
                text1.setFont(new Font("Lucida Bright", Font.BOLD, 20));

                // JComboBox
                JComboBox<String> jb = new JComboBox<>(arr);
                jb.setBounds(245, 140, 200, 50);
                jb.setSelectedItem(null);

                // JButton
                JButton button = new JButton("Select");
                button.setBounds(400,300,150,50);
                button.setFocusable(false);

                // Action Listener for JButton
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            String s1 = "" + jb.getSelectedItem();
                            String q1 = "select * from facultyfeedback where name = ?; ";
                            
                            PreparedStatement pst = con.prepareStatement(q1);
                            pst.setString(1, s1);
                            ResultSet res = pst.executeQuery();

                            // JFrame for displaying feedback
                            JFrame f2 = new JFrame(" Rating Of " + jb.getSelectedItem());
                            f2.setSize(600, 400);
                            f2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            f2.setResizable(false);

                            // JLabel
                            JLabel t2 = new JLabel("Rating of " + jb.getSelectedItem());
                            t2.setBounds(240, 30, 280, 50);
                            t2.setFont(new Font("Lucida Bright", Font.BOLD, 20));

                            // JTextArea
                            JTextArea a1 = new JTextArea();
                            while (res.next()) {
                                int belowAverage = Integer.parseInt(res.getString(6));
                                int average = Integer.parseInt(res.getString(7));
                                int good = Integer.parseInt(res.getString(8));
                                int excellent = Integer.parseInt(res.getString(9));
                            
                                int Total = (belowAverage + average + good + excellent);
                                
                                a1.append(" EmpId:- " + res.getString(1) + "\n" +
                                        " Below_average:- " + belowAverage + "\n" +
                                        " Average:- " + average + "\n" +
                                        " Good:- " + good + "\n" +
                                        " Excellent:- " + excellent + "\n" +
                                        "\n" +
                                        " Total:- " + Total);
                            }
                            
                            a1.setFont(new Font("Bright Italic", Font.BOLD, 15));
                            a1.setBounds(100, 100, 200, 200);

                            f2.add(a1);
                            f2.add(t2);
                            f2.setLayout(null);
                            f2.setVisible(true);
                        } catch (SQLException ex) {
                            ex.printStackTrace(); // Handle exception appropriately
                        }
                    }
                });

                f1.add(jb);
                f1.add(button);
                f1.add(text1);
                f1.setLayout(null);
                f1.setVisible(true);
            });
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exception appropriately
        }
    }

    public static void main(String[] args) {
        displayFrame();
    }
}
