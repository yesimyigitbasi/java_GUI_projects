import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginGui extends JFrame{
    private static JLabel userlabel, passlabel, Lbl;
    private static JTextField userText;
    private static JPasswordField  passText;
    private static JButton button;

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setSize(300,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(null);


        userlabel = new JLabel("Username");
        userlabel.setBounds(10,20,80,25);
        frame.add(userlabel);

        userText = new JTextField();
        userText.setBounds(100,20,165,25);
        frame.add(userText);

        passlabel = new JLabel("Password");
        passlabel.setBounds(10,50,80,25);
        frame.add(passlabel);

        passText = new JPasswordField();
        passText.setBounds(100,50,165,25);
        frame.add(passText);

        button = new JButton("click");
        button.setBounds(90,80,80,25);
        frame.add(button);
        button.addActionListener((ActionListener) new loginGui());

        Lbl = new JLabel();
        Lbl.setBounds(50,120,200,25);
        frame.add(Lbl);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String username = userText.getText();
        String password = passText.getText();
        if (username.equals("yesim") && password.equals("123")) {
            Lbl.setText("Log in successfull");
        }
        else {
            Lbl.setText("wrong password or username");
        }
    }
}