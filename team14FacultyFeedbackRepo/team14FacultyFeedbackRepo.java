/*`````````````` Faculty-Feed-Back (java application)_team14 ````````````*/
// team14FacultyFeedback.java

//java.awt.*; package for import
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

//java.awt.event.*; package for import 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//java.sql.*; package for import
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//java.util.*; package for import
import java.util.ArrayList;

//javax.swing.*; package for import
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class team14FacultyFeedback {  
    public static void main(String[] args) throws Exception {
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/team14", "root", "Aditya@1710");
        Statement st = con.createStatement();
        ResultSet s = st.executeQuery("select * from facultyfeedback;");

        ArrayList<String> str=new ArrayList<>();
        while (s.next()) {
            System.out.println(s.getString(2));
            str.add(s.getString(2));
        }
        String arr[]=str.toArray(new String[0]); // 1 2 3 4 5
        Statement st1 = con.createStatement();
        ResultSet s3 = st1.executeQuery("select * from facultyfeedback");
        
        ArrayList<String> str1=new ArrayList<>();
        while (s3.next()) {
            System.out.println(s3.getString(5));
            str1.add(s3.getString(5));//adding 5th index means (subject column):java,m3,mfcs,aiml,dbms are added
        }
        String arr1[] = str1.toArray(new String[0]); // 1 2 3 4 5

        JFrame frame= new JFrame("FeedBack");
        frame.setResizable(false);
        frame.setSize(680,400);
        
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\LENOVO\\Downloads\\like.png");//logo
        frame.setIconImage(icon);
        frame.getContentPane().setBackground(new Color(166, 255, 213));
        
        JButton b1=new JButton("View FeedBack");
        b1.setBounds(100,140,200,50);
        b1.setFont(new Font("Lucida Bright",Font.BOLD,20));
        b1.setFocusable(false);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                JFrame f1=new JFrame("select faculty");
                
                Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\LENOVO\\Downloads\\like.png");//logo
                f1.setIconImage(icon);
                f1.setSize(680,400);
                
                JLabel text1=new JLabel("SELECT A TRAINER");
                text1.setBounds(250,30,200,50);
                text1.setFont(new Font("Lucida Bright",Font.BOLD,20));
                f1.setResizable(false);

                JComboBox jb=new JComboBox(arr);
                jb.setBounds(245,140,200,50);
                jb.setSelectedItem(null);
                f1.add(jb);
                f1.add(text1);
                f1.setLayout(null);
                f1.setVisible(true);
                f1.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        frame.setVisible(true);  //the main frame visible again when f1 is closed
                    }
                });

                jb.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        JFrame f2 = new JFrame(" Rating Of " + jb.getSelectedItem());
                        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\LENOVO\\Downloads\\like.png");//logo
                        f2.setIconImage(icon);
                        f2.setSize(680, 400);
                        f2.setResizable(false);
                        f1.setVisible(false);
                        f2.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosing(WindowEvent e) {
                                f1.setVisible(true);  //the main frame visible again when f1 is closed
                            }
                        });
                        try {
                            String gg = "" + jb.getSelectedItem();
                            String ok = "select * from facultyfeedback where name = ?; ";

                            PreparedStatement pst = con.prepareStatement(ok);
                            pst.setString(1, gg);
                            ResultSet resultSet = pst.executeQuery();

                            JLabel text2 = new JLabel("Rating of " + jb.getSelectedItem());
                            text2.setBounds(240, 30, 280, 50);
                            text2.setFont(new Font("Lucida Bright",Font.BOLD,20));
                            JTextArea area1 = new JTextArea();
                            
                            while (resultSet.next()) {
                                int belowAverage = Integer.parseInt(resultSet.getString(6));
                                int average = Integer.parseInt(resultSet.getString(7));
                                int good = Integer.parseInt(resultSet.getString(8));
                                int excellent = Integer.parseInt(resultSet.getString(9));

                            
                                int totalResponses = belowAverage + average + good + excellent;
                                int Total = (belowAverage * 2 + average * 3 + good * 4 + excellent * 5) / totalResponses;

                                area1.append(" EmpId:- " + resultSet.getString(1) + "\n" +
                                        " Below_average:- " + belowAverage + "\n" +
                                        " Average:- " + average + "\n" +
                                        " Good:- " + good + "\n" +
                                        " Excellent:- " + excellent + "\n" +
                                        " Total Rating:- " + Total + "\n\n");
                                
                            }
                            area1.setFont(new Font("Lucida Bright",Font.BOLD,15));
                            area1.setBounds(140, 100, 400, 200);

                            f2.add(area1);
                            f2.add(text2);
                            f2.setLayout(null);
                            f2.setVisible(true);




                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });

            }
        });
        frame.setVisible(true);

        final String[] ggwk = {""};

        JButton b2=new JButton("Give FeedBack");
        b2.setBounds(380,140,200,50);
        b2.setFont(new Font("Lucida Bright",Font.BOLD,20));
        b2.setFocusable(false);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);

                JFrame f5=new JFrame("select subject");
                f5.setSize(680,400);
                f5.setResizable(false);

                JLabel text2=new JLabel("SELECT A SUBJECT");
                text2.setBounds(250,30,200,50);
                text2.setFont(new Font("Lucida Bright",Font.BOLD,20));
                f5.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        frame.setVisible(true);  //the main frame visible again when f1 is closed
                    }
                });

                JComboBox jb1=new JComboBox(arr1);
                jb1.setBounds(245,150,200,50);
                jb1.setSelectedItem(null);
                f5.add(jb1);
                f5.add(text2);
                f5.setLayout(null);
                f5.setVisible(true);
        
                jb1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        JFrame f6 = null;

                        JLabel text3=null;
                        
                        f5.setVisible(false);

                        try {

                            String ok1 = "" + jb1.getSelectedItem();
                            String k1 = "select name from facultyfeedback where subject=?;";
                            PreparedStatement pst1 = con.prepareStatement(k1);
                            pst1.setString(1, ok1);
                            ResultSet sk = pst1.executeQuery();
                            f6 = new JFrame("Give Feedback");
                            f6.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                            while(sk.next()) {
                                text3=new JLabel("Give FeedBack To " + sk.getString(1));
                                ggwk[0] =""+sk.getString(1);
                            }
                        }


                        catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }

                        f6.setResizable(false);
                        f6.setSize(680, 400);
                        JRadioButton b1=new JRadioButton("Below_Average");
                        JRadioButton b2=new JRadioButton("Average");
                        JRadioButton b3=new JRadioButton("Good");
                        JRadioButton b4=new JRadioButton("Excellent");
                        f6.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosing(WindowEvent e) {
                                f5.setVisible(true);  //the main frame visible again when f1 is closed
                            }
                        });
                        b1.setBounds(100,50,200,50);
                        b2.setBounds(100,100,150,50);
                        b3.setBounds(100,150,150,50);
                        b4.setBounds(100,200,150,50);
                        JButton but1=new JButton("SUBMIT");
                        but1.setFocusable(false);
                        but1.setBounds(200,300,150,50);
                        f6.add(but1);


                        JFrame finalF = f6;
                        but1.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int n=0;
                                if(b1.isSelected()){
                                    n=1;
                                } else if (b2.isSelected()) {
                                    n=2;
                                } else if (b3.isSelected()) {
                                    n=3;
                                } else if (b4.isSelected()) {
                                    n=4;
                                }

                                if(n==1){
                                    try{


                                        String k12 = "update facultyfeedback set below_average = below_average+1 where name=?;";
                                        PreparedStatement pst12 = con.prepareStatement(k12);
                                        pst12.setString(1, ggwk[0]);
                                        pst12.executeUpdate();
                                        JOptionPane.showMessageDialog(null,"Thanks For FeedBack","Messege",1);
                                        finalF.dispose();
                                    }
                                    catch (SQLException ex) {
                                        throw new RuntimeException(ex);
                                    }

                                }
                                else if(n==2){
                                    try{


                                        String k12 = "update facultyfeedback set average = average+1 where name=?;";
                                        PreparedStatement pst12 = con.prepareStatement(k12);
                                        pst12.setString(1, ggwk[0]);
                                        pst12.executeUpdate();
                                        JOptionPane.showMessageDialog(null,"Thanks For FeedBack","Messege",1);
                                        finalF.dispose();
                                    }
                                    catch (SQLException ex) {
                                        throw new RuntimeException(ex);
                                    }
                                }
                                else if(n==3){
                                    try{


                                        String k12 = "update facultyfeedback set good = good+1 where name=?;";
                                        PreparedStatement pst12 = con.prepareStatement(k12);
                                        pst12.setString(1, ggwk[0]);
                                        pst12.executeUpdate();
                                        JOptionPane.showMessageDialog(null,"Thanks For FeedBack","Messege",1);
                                        finalF.dispose();
                                    }
                                    catch (SQLException ex) {
                                        throw new RuntimeException(ex);
                                    }
                                }
                                else if(n==4){
                                    try{


                                        String k12 = "update facultyfeedback set excellent = excellent+1 where name=?;";
                                        PreparedStatement pst12 = con.prepareStatement(k12);
                                        pst12.setString(1, ggwk[0]);
                                        pst12.executeUpdate();
                                        JOptionPane.showMessageDialog(null,"Thanks For FeedBack","Messege",1);
                                        finalF.dispose();
                                    }
                                    catch (SQLException ex) {
                                        throw new RuntimeException(ex);
                                    }
                                } else if (n==0) {

                                    JOptionPane.showMessageDialog(null, "Please select any option !", "Warning", 2);
                                    finalF.dispose();
                                }

                            }

                        });

                        text3.setFont(new Font("Lucida Bright",Font.BOLD,20));
                        text3.setBounds(250,10,250,50);
                        ButtonGroup bg=new ButtonGroup();
                        b1.setFont(new Font("Lucida Bright",Font.BOLD,20));
                        b2.setFont(new Font("Lucida Bright",Font.BOLD,20));
                        b3.setFont(new Font("Lucida Bright",Font.BOLD,20));
                        b4.setFont(new Font("Lucida Bright",Font.BOLD,20));
                        bg.add(b1);
                        bg.add(b2);
                        bg.add(b3);
                        bg.add(b4);
                        f6.add(b1);
                        f6.add(b2);
                        f6.add(b3);
                        f6.add(b4);
                        f6.add(text3);
                        f6.setLayout(null);
                        f6.setVisible(true);
                    }
                });

            }
        });

    b1.setBackground(Color.white);
    b2.setBackground(Color.white);
        frame.add(b2);
        frame.add(b1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
