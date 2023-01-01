import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cafeorderGui extends JFrame{
    int count = 1;

    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    cafeorderGui frame = new cafeorderGui();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public cafeorderGui() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        JLabel takeorder = new JLabel("WHAT WOULD YOU LIKE TO ORDER?");

        JLabel total = new JLabel();

        JComboBox selectDrink = new JComboBox();
        selectDrink.addItem("tea");
        selectDrink.addItem("coffee");
        selectDrink.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (selectDrink.getSelectedItem() == "tea") {
                    total.setText("10");
                }
                if (selectDrink.getSelectedItem() == "coffee") {
                    total.setText("20");
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