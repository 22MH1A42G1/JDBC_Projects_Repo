import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
public class StudentDataEntryForm {
    public static Connection con;
    public static void main(String[] args) throws Exception {

        // DB Connection
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "Aditya@1710");

        if (con != null) {
            System.out.println("Connected Successfully");
        }

        // Frame Creation using JFrame
        JFrame frame = new JFrame("First GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500); // 500 - width, 500 - height
        frame.setResizable(false);
//		frame.getContentPane().setBackground(Color.white);

        // JLabel -> allow you to create labels to display some text
        JLabel roll = new JLabel("Enter your roll number: ");
        roll.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        roll.setBounds(10, 18, 240, 40);

        JLabel name = new JLabel("Enter your name: ");
        name.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        name.setBounds(10, 78, 240, 40);

        JLabel college = new JLabel("Enter your college: ");
        college.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        college.setBounds(10, 138, 240, 40);

        JLabel branch = new JLabel("Enter your branch: ");
        branch.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        branch.setBounds(10, 198, 240, 40);

        JLabel age = new JLabel("Enter your age: ");
        age.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        age.setBounds(10, 258, 240, 40);


        // JTextFields -> allow you do enter some text
        JTextField tf1 = new JTextField();
        tf1.setBounds(250, 20, 210, 40);
        tf1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        JTextField tf2 = new JTextField();
        tf2.setBounds(250, 80, 210, 40);
        tf2.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        JTextField tf3 = new JTextField();
        tf3.setBounds(250, 140, 210, 40);
        tf3.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        JTextField tf4 = new JTextField();
        tf4.setBounds(250, 200, 210, 40);
        tf4.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        JTextField tf5 = new JTextField();
        tf5.setBounds(250, 260, 210, 40);
        tf5.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        // Creating a button --> Submit using JButton
        JButton button = new JButton("Submit");
        button.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        button.setBounds(300, 350, 150, 50);
        button.setFocusable(false);
        // Adding ActionListener
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String r, n, c, b, a;
                r = tf1.getText().trim();
                n = tf2.getText().trim();
                c = tf3.getText().trim();
                b = tf4.getText().trim();
                a = tf5.getText().trim();
                System.out.println(r + " " + n + " " + c + " " + b + " " + a);
                if (r.isEmpty() || n.isEmpty() || c.isEmpty() || b.isEmpty() || a.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Required Data Missing", "Error", 0);
                    return;
                }
                insertDataintoDB(r, n, c, b, a);
                tf1.setText("");
                tf2.setText("");
                tf3.setText("");
                tf4.setText("");
                tf5.setText("");

            }
        });

        //Adding button to frame
        frame.add(button);

        // Adding Labels to Frame
        frame.add(roll);
        frame.add(name);
        frame.add(college);
        frame.add(branch);
        frame.add(age);

        // Adding textfields to frame
        frame.add(tf1);
        frame.add(tf2);
        frame.add(tf3);
        frame.add(tf4);
        frame.add(tf5);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public static void insertDataintoDB(String r, String n, String c, String b, String a) {
        // Prepared Statment
        try {
            String sql = "INSERT INTO STUDENT VALUES(?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, r);
            pst.setString(2, n);
            pst.setString(3, c);
            pst.setString(4, b);
            pst.setString(5, a);
            int res = pst.executeUpdate();
            if (res == 1) {
                JOptionPane.showMessageDialog(null, "Data Inserted Successfully", "Success", 1);
            } else {
                System.out.println("Failed");
            }
        }
        catch (Exception e) {

        }
    }

}
