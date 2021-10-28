/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//frame to display the total amount of money
//package expensehandler;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

/**
 *
 * 
 */
class totalDisplay extends JFrame implements ActionListener
{
    //declaration 
    private JFrame gFrame;
    private JPanel inputPanel;
    private JLabel nameLabel;
    private JButton closeButton;
    private JButton homeButton;
    private JLabel resultLabel;
    private final Color BACKGROUND_COLOR = new Color(237,230,173);
    private final Color DARKGREEN_COLOR = new Color(48,89,98);
    private final Color DULLYELLOW_COLOR = new Color(220,194,134);
    private final Font MAIN_FONT = new Font("Arial",Font.BOLD,50);

    public totalDisplay(JFrame pFrame)
    {
        gFrame = pFrame;
        this.setBounds(100, 100, 600, 500);
        this.getContentPane().setBackground(BACKGROUND_COLOR);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);

        //initialization
        nameLabel = new JLabel("THE TOTAL IS");
        JavaDb Obj1 = new JavaDb();
        int total = Obj1.getTotalAmount();
        String totalString = Integer.toString(total);
        resultLabel = new JLabel(totalString);
        resultLabel.setFont(MAIN_FONT);
        closeButton = new JButton("Close");
        closeButton.setBackground(DULLYELLOW_COLOR);
        closeButton.setOpaque(true);
        closeButton.setBorderPainted(false);
        closeButton.addActionListener(this);

        homeButton = new JButton("Home");
        homeButton.setBackground(DULLYELLOW_COLOR);
        homeButton.setOpaque(true);
        homeButton.setBorderPainted(false);
        homeButton.addActionListener(this);

        //panel
        inputPanel = new JPanel(new FlowLayout());
        inputPanel.setBackground(DARKGREEN_COLOR);
        inputPanel.add(nameLabel);
        inputPanel.add(homeButton);
        inputPanel.add(closeButton);
        
        String[] columns = new String[] {"Name", "MBilling Date", "MonthlyBillAmount"};
        Object[][] data = new Object[][] {{"Dinner", "01/1/18", 25}};
        JTable table = new JTable(data, columns);
        
        

        this.add(inputPanel, BorderLayout.NORTH);
        this.add(resultLabel, BorderLayout.CENTER);

    }
    
    public totalDisplay()
    {
        super();
        this.setBounds(100, 100, 600, 500);
        this.getContentPane().setBackground(BACKGROUND_COLOR);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);

        nameLabel = new JLabel("THE TOTAL IS:");
        JavaDb Obj1 = new JavaDb();
        int total = Obj1.getTotalAmount();
        String totalString = Integer.toString(total);
        resultLabel = new JLabel(totalString);
        resultLabel.setFont(MAIN_FONT);
        closeButton = new JButton("Close");
        closeButton.setBackground(DULLYELLOW_COLOR);
        closeButton.setOpaque(true);
        closeButton.setBorderPainted(false);
        closeButton.addActionListener(this);

        homeButton = new JButton("Home");
        homeButton.setBackground(DULLYELLOW_COLOR);
        homeButton.setOpaque(true);
        homeButton.setBorderPainted(false);
        homeButton.addActionListener(this);

        //panel
        inputPanel = new JPanel(new FlowLayout());
        inputPanel.setBackground(DARKGREEN_COLOR);
        inputPanel.add(nameLabel);
        inputPanel.add(homeButton);
        inputPanel.add(closeButton);
        
        String[] columns = new String[] {"Name", "MBilling Date", "MonthlyBillAmount"};
        Object[][] data = new Object[][] {{"Dinner", "01/1/18", 25}};
        JTable table = new JTable(data, columns);
        
        

        this.add(inputPanel, BorderLayout.NORTH);
        this.add(resultLabel, BorderLayout.CENTER);
        this.setVisible(true);

    }
    
    public static void main(String[] args)
    {
        // TODO code application logic here

        totalDisplay objFrame8 = new totalDisplay();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String buttonCommand = e.getActionCommand();
        if (buttonCommand.equals("Home"))
        {
            this.dispose();
            gFrame.setVisible(true);
        }
        else if(buttonCommand.equals("Close"))
        {
            this.dispose();
            System.exit(0);
            
        }
    }
    
    
}
