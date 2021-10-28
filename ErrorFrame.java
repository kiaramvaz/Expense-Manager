/*
 September 7th. This class is the error frame 
 */
//package expensehandler;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

/**
 *
 * 
 */
public class ErrorFrame extends JFrame implements ActionListener
{

    private JFrame gFrame;
    private JLabel errorLabel;
    private JPanel errorPanel;
    private JButton homeButton;

    private final Font FRAME_FONT = new Font("Comic Sans", Font.BOLD, 30);
    private final Color BACKGROUND_COLOR = new Color(237, 230, 173);
    private final Color DARKGREEN_COLOR = new Color(48, 89, 98);
    private final Color DULLYELLOW_COLOR = new Color(220, 194, 134);

    public ErrorFrame(JFrame pFrame)
    {
        gFrame = pFrame;
        this.setBounds(100, 100, 1200, 500);
        this.getContentPane().setBackground(DULLYELLOW_COLOR);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);

        homeButton = new JButton("Home");
        homeButton.setBackground(DARKGREEN_COLOR);
        homeButton.setOpaque(true);
        homeButton.setBorderPainted(false);
        homeButton.addActionListener(this);

        //error message
        errorLabel = new JLabel("<html> You have an error! <br/> "
                + "Please ensure your inputs are valid <br/> "
                + "-date(YYYY-MM-DD) <br/> "
                + "-amount: (integer) <br/> "
                + "-name cannot include numbers and special characters <br/>"
                + "-spending type input: Monthly, Weekly, OTPurchase <br/> "
                + "</html>", SwingConstants.CENTER);
        errorPanel = new JPanel(new FlowLayout());
        errorPanel.setBackground(BACKGROUND_COLOR);
        errorPanel.add(homeButton);
        //displays error! to let user know they did something wrong

        //errorLabel = new JLabel("<html> Please make sure your inputs are valid <br/>  (ie: date: (YYYY-MM-DD), amount: (integer) </html>" , SwingConstants.CENTER);
        errorLabel.setFont(FRAME_FONT);
        this.add(errorLabel, BorderLayout.NORTH);
        this.add(errorPanel);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        //back button
        String buttonCommand = e.getActionCommand();
        JavaDb Obj1 = new JavaDb("ExpenseDatabase");
        Connection myDbConn;
        myDbConn = Obj1.getdbConn();
        if (buttonCommand.equals("Home"))
        {
            this.dispose();
            gFrame.setVisible(true);
        }

    }
//    public static void main(String[] args){
//        
//    }
}
