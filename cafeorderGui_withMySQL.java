import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class cafeorderGui_withMySQL extends JFrame {
    int count = 0;

    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    cafeorderGui_withMySQL frame = new cafeorderGui_withMySQL();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public cafeorderGui_withMySQL() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        JLabel takeorder = new JLabel("WHAT WOULD YOU LIKE TO ORDER?");

        JLabel total = new JLabel();

        JComboBox selectDrink = new JComboBox();

        selectDrink.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe", "root", "");
                    System.out.println("ok4");

                    Statement stmn = con.createStatement();
                    String sql="SELECT * FROM drinks ";
                    ResultSet rs=stmn.executeQuery(sql);

                    while (rs.next()) {
                        String var = (rs.getString("drink"));
                        System.out.println(var);
                    }
                    rs.next();

                }  catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });

        JTextField amount = new JTextField(count);

        JButton incr = new JButton("+");
        incr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                count++;
                amount.setText("" + count); //converted count (int) to string
            }
        });

        JButton decr = new JButton("-");
        decr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                count--;
                amount.setText("" + count); //converted count (int) to string
            }
        });

        JButton check = new JButton("calculate");
        check.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int x = Integer.parseInt(total.getText());
                int y = Integer.parseInt(amount.getText());
                total.setText("" + x * y );
            }
        });

        contentPane.add(takeorder);
        contentPane.add(selectDrink);
        contentPane.add(amount);
        contentPane.add(incr);
        contentPane.add(decr);
        contentPane.add(total);
        contentPane.add(check);
    }
}