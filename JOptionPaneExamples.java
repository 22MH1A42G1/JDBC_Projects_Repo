import javax.swing.JOptionPane;
public class JOptionPaneExamples {
    public static void main(String[] args) {
        // DialogBoxes
        // 1. ShowMessageDialog
        // Show some message as a pop-up to the user
        JOptionPane.showMessageDialog(null, "Nothing");
        JOptionPane.showMessageDialog(null, "Hey I am a Message", "Message", 1);
        JOptionPane.showMessageDialog(null, "Be careful buddy", "Warning", 2);
        JOptionPane.showMessageDialog(null, "Something's Wrong", "Error", 0);


        // 2. ShowInputDialog
        // Let the user enter some text in the pop-up
        String input1 = JOptionPane.showInputDialog(null, "Enter Something", "Entry", 3);
        System.out.println(input1);

        String input2 = JOptionPane.showInputDialog(null, "Enter your name", "Get Name", 1);
        System.out.println("Hey, " + input2);

        // 3. ShowConfirmDialog
        int res = JOptionPane.showConfirmDialog(null, "Please confirm deletion", "Are you sure??", JOptionPane.YES_NO_CANCEL_OPTION);
        System.out.println("You selected " + res);

    }
}
