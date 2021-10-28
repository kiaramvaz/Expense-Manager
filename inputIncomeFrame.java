/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//frame to input income 
//package expensehandler;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 */
class inputIncomeFrame extends JFrame implements ActionListener
{

    private JFrame gFrame;
    private JPanel buttonPanel;
    private JTextField nameInput;
    private JTextField dateInput;
    private JTextField amountInput;
    private JPanel inputPanel;
    private JLabel nameLabel;
    private JLabel dateLabel;
    private JLabel amountLabel;
    private JLabel timeLabel;
    private JButton closeButton;
    private JButton deleteButton;
    private JButton submitButton;
    private JButton updateButton;
    private JButton homeButton;
    private JLabel resultLabel;
    private Date date1;

    private final Color BACKGROUND_COLOR = new Color(237, 230, 173);
    private final Color DARKGREEN_COLOR = new Color(48, 89, 98);
    private final Color DULLYELLOW_COLOR = new Color(220, 194, 134);
    private final Font MAIN_FONT = new Font("Arial", Font.BOLD, 40);

    public inputIncomeFrame(JFrame pFrame)
    {
        gFrame = pFrame;
        this.setBounds(100, 100, 1200, 500);
        this.getContentPane().setBackground(BACKGROUND_COLOR);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);

        //initialization
        nameLabel = new JLabel("Name:");
        dateLabel = new JLabel("Date:");
        amountLabel = new JLabel("Amount:");
        resultLabel = new JLabel("   ");

        nameInput = new JTextField(10);
        dateInput = new JTextField(10);
        amountInput = new JTextField(10);

        closeButton = new JButton("Close");
        closeButton.setBackground(DULLYELLOW_COLOR);
        closeButton.setOpaque(true);
        closeButton.setBorderPainted(false);

        closeButton.addActionListener(this);

        deleteButton = new JButton("Delete");
        deleteButton.setBackground(DULLYELLOW_COLOR);
        deleteButton.setOpaque(true);
        deleteButton.setBorderPainted(false);
        deleteButton.addActionListener(this);

        submitButton = new JButton("Submit");
        submitButton.setBackground(DULLYELLOW_COLOR);
        submitButton.setOpaque(true);
        submitButton.setBorderPainted(false);
        submitButton.addActionListener(this);

        updateButton = new JButton("Update");
        updateButton.setBackground(DULLYELLOW_COLOR);
        updateButton.setOpaque(true);
        updateButton.setBorderPainted(false);
        updateButton.addActionListener(this);

        homeButton = new JButton("Home");
        homeButton.setBackground(DULLYELLOW_COLOR);
        homeButton.setOpaque(true);
        homeButton.setBorderPainted(false);
        homeButton.addActionListener(this);

        inputPanel = new JPanel(new FlowLayout());
        inputPanel.setBackground(DARKGREEN_COLOR);
        inputPanel.add(nameLabel);
        inputPanel.add(nameInput);
        inputPanel.add(dateLabel);
        inputPanel.add(dateInput);
        inputPanel.add(amountLabel);
        inputPanel.add(amountInput);
        inputPanel.add(deleteButton);
        inputPanel.add(closeButton);
        inputPanel.add(submitButton);
        inputPanel.add(homeButton);
        inputPanel.add(updateButton);

        this.add(inputPanel, BorderLayout.NORTH);
        this.add(resultLabel, BorderLayout.CENTER);

    }

    public inputIncomeFrame()
    {
        super();
        this.setBounds(100, 100, 1200, 500);
        this.getContentPane().setBackground(BACKGROUND_COLOR);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);

        nameLabel = new JLabel("Name:");
        dateLabel = new JLabel("Date:");
        amountLabel = new JLabel("Amount:");
        resultLabel = new JLabel("   ");

        nameInput = new JTextField(10);
        dateInput = new JTextField(10);
        amountInput = new JTextField(10);

        closeButton = new JButton("Close");
        closeButton.setBackground(DULLYELLOW_COLOR);
        closeButton.setOpaque(true);
        closeButton.setBorderPainted(false);

        closeButton.addActionListener(this);

        deleteButton = new JButton("Delete");
        deleteButton.setBackground(DULLYELLOW_COLOR);
        deleteButton.setOpaque(true);
        deleteButton.setBorderPainted(false);
        deleteButton.addActionListener(this);

        submitButton = new JButton("Submit");
        submitButton.setBackground(DULLYELLOW_COLOR);
        submitButton.setOpaque(true);
        submitButton.setBorderPainted(false);
        submitButton.addActionListener(this);

        updateButton = new JButton("Update");
        updateButton.setBackground(DULLYELLOW_COLOR);
        updateButton.setOpaque(true);
        updateButton.setBorderPainted(false);
        updateButton.addActionListener(this);

        homeButton = new JButton("Home");
        homeButton.setBackground(DULLYELLOW_COLOR);
        homeButton.setOpaque(true);
        homeButton.setBorderPainted(false);
        homeButton.addActionListener(this);

        inputPanel = new JPanel(new FlowLayout());
        inputPanel.setBackground(DARKGREEN_COLOR);
        inputPanel.add(nameLabel);
        inputPanel.add(nameInput);
        inputPanel.add(dateLabel);
        inputPanel.add(dateInput);
        inputPanel.add(amountLabel);
        inputPanel.add(amountInput);
        inputPanel.add(deleteButton);
        inputPanel.add(closeButton);
        inputPanel.add(submitButton);
        inputPanel.add(homeButton);
        inputPanel.add(updateButton);

        this.add(inputPanel, BorderLayout.NORTH);
        this.add(resultLabel, BorderLayout.CENTER);
        this.setVisible(true);

    }

    public static void main(String[] args)
    {
        // TODO code application logic here

        inputIncomeFrame objFrame4 = new inputIncomeFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        try
        {

            String[] tableHeaders =
            {
                "Name", "StartDate", "IncomeAmount"
            };

            String table = "incomeTable";

            String buttonCommand = e.getActionCommand();
            JavaDb Obj1 = new JavaDb("ExpenseDatabase");
            Connection myDbConn;
            myDbConn = Obj1.getdbConn();

            //button commands to perform applications actions
            if (buttonCommand.equals("Home"))
            {
                this.dispose();
                gFrame.setVisible(true);
            } else if (buttonCommand.equals("Close"))
            {
                this.dispose();
                System.exit(0);

            } //InputIncome
            else if (buttonCommand.equals("Submit"))
            {
                String nameString = nameInput.getText();
                String amountString = amountInput.getText();
                String dateString = dateInput.getText();

                int amountInt = Integer.parseInt(amountString);

                date1 = java.sql.Date.valueOf(dateString);
                nameInput.setText("");
                amountInput.setText("");
                dateInput.setText("");

                //Query
                String dbQuery1 = "INSERT INTO incomeTable VALUES " + "(?,?,?)";

                try
                {
                    //Prepared Statement
                    System.out.println("1");
                    PreparedStatement ps = myDbConn.prepareStatement(dbQuery1);
                    System.out.println("2");
                    ps.setString(1, nameString);
                    System.out.println("3");
                    ps.setDate(2, date1);
                    System.out.println("4");
                    ps.setInt(3, amountInt);
                    System.out.println("5");
                    ps.executeUpdate();
                    System.out.println("6");
                } catch (SQLException r)
                {
                    System.out.println("Error: Did not insert brooo");
                    ErrorFrame objErrorFrame = new ErrorFrame(this);
                }
            } //Delete Income
            else if (buttonCommand.equals("Delete"))
                
            {
                
                
                String dbQuery3 = "DELETE FROM incomeTable WHERE Name=?";
                String nameString = nameInput.getText();
                
                boolean check = Obj1.checkData(tableHeaders, nameString, table);
                System.out.println("check" + check);
                if (check == false){
                    
                    ErrorFrame objErrorFrame = new ErrorFrame(this);
                }
                
                dateInput.setText("");
                try
                {
                    //Prepared Statement
                    PreparedStatement ps = myDbConn.prepareStatement(dbQuery3);
                    ps.setString(1, nameString);
                    ps.executeUpdate();
                } catch (SQLException s)
                {
                    System.out.println("Error: did not delete");
                    ErrorFrame objErrorFrame = new ErrorFrame(this);
                }

                //resultLabel.setText("Delete Button was pressed");
                this.validate();
                this.repaint();

            } //Update Income
            else if (buttonCommand.equals("Update"))
            {
                String nameString = nameInput.getText();
                String amountString = amountInput.getText();
                String dateString = dateInput.getText();
                
                boolean check = Obj1.checkData(tableHeaders, nameString, table);
                System.out.println("check" + check);
                if (check == false){
                    
                    ErrorFrame objErrorFrame = new ErrorFrame(this);
                }

                int amountInt = Integer.parseInt(amountString);

                date1 = Date.valueOf(dateString);
                nameInput.setText("");
                amountInput.setText("");
                dateInput.setText("");
                //Query
                System.out.println("1");
                String dbQuery2 = "UPDATE incomeTable SET StartDate=?, IncomeAmount=? "
                        + "WHERE Name=?";

                try
                {
                    //Prepared Statement
                    PreparedStatement ps = myDbConn.prepareStatement(dbQuery2);
                    ps.setDate(1, date1);
                    ps.setInt(2, amountInt);
                    ps.setString(3, nameString);
                    ps.executeUpdate();

                } catch (SQLException s)
                {
                    System.out.println("Error: did not update!!");
                    ErrorFrame objErrorFrame = new ErrorFrame(this);
                }
            }

        } catch (NullPointerException ne)
        {
            System.out.println("Null");
            ErrorFrame objErrorFrame = new ErrorFrame(this);
        } catch (IllegalArgumentException iae)
        {
            System.out.println("Null");
            ErrorFrame objErrorFrame = new ErrorFrame(this);
        }

    }
}
