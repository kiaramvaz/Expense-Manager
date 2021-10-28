/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//frame to input savings
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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
/**
 *
 *
 */
public class inputSavings extends JFrame implements ActionListener {
    
    private JFrame gFrame;
    private JPanel buttonPanel;
    private JTextField nameInput;
    private JTextField dateInput;
    private JTextField amountInput;
    private JPanel inputPanel;
    private JLabel nameLabel;
    private JLabel startDateLabel;
    private JLabel amountLabel;
    private JLabel timeLabel;
    private JButton closeButton;
    private JButton deleteButton;
    private JButton submitButton;
    private JButton updateButton;
    private JButton homeButton;
    private Date date1;
    //colors
    private final Color BACKGROUND_COLOR = new Color(237,230,173);
    private final Color DARKGREEN_COLOR = new Color(48,89,98);
    private final Color DULLYELLOW_COLOR = new Color(220,194,134);
    private final Font MAIN_FONT = new Font("Arial",Font.BOLD,40);

    public inputSavings(JFrame pFrame)
    {
        gFrame = pFrame;
        this.setBounds(100, 100, 1200, 500);
        this.getContentPane().setBackground(BACKGROUND_COLOR);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);

        //initialization
        nameLabel = new JLabel("Name:");
        startDateLabel = new JLabel("Start Date:");
        amountLabel = new JLabel("Amount:");
        //resultLabel = new JLabel("   ");

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
        
         //panel
        inputPanel = new JPanel(new FlowLayout());
        inputPanel.setBackground(DARKGREEN_COLOR);
        inputPanel.add(nameLabel);
        inputPanel.add(nameInput);
        inputPanel.add(startDateLabel);
        inputPanel.add(dateInput);
        inputPanel.add(amountLabel);
        inputPanel.add(amountInput);
        //inputPanel.add(deleteButton);
        inputPanel.add(closeButton);
        inputPanel.add(submitButton);
        inputPanel.add(homeButton);
        //inputPanel.add(updateButton);

        this.add(inputPanel, BorderLayout.NORTH);
        //this.add(resultLabel, BorderLayout.CENTER);


    }
    
       public inputSavings()
    {
        super();
        this.setBounds(100, 100, 1200, 500);
        this.getContentPane().setBackground(BACKGROUND_COLOR);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);

        nameLabel = new JLabel("Name:");
        startDateLabel = new JLabel("Start Date:");
        amountLabel = new JLabel("Amount:");
        //resultLabel = new JLabel("   ");

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
        inputPanel.add(startDateLabel);
        inputPanel.add(dateInput);
        inputPanel.add(amountLabel);
        inputPanel.add(amountInput);
        //inputPanel.add(deleteButton);
        inputPanel.add(closeButton);
        inputPanel.add(submitButton);
        inputPanel.add(homeButton);
        //inputPanel.add(updateButton);

        this.add(inputPanel, BorderLayout.NORTH);
        //this.add(resultLabel, BorderLayout.CENTER);
        this.setVisible(true);

    }
       public static void main(String[] args)
    {
        // TODO code application logic here

        inputSavings objFrame5 = new inputSavings();
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        try{
        //button commands to perform applications actions
        String buttonCommand = e.getActionCommand();
        JavaDb Obj1 = new JavaDb("ExpenseDatabase");
        Connection myDbConn;
        myDbConn = Obj1.getdbConn();
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
        //Input Savings
        else if(buttonCommand.equals("Submit"))
        {
           String nameString = nameInput.getText();
           String amountString = amountInput.getText();
           String dateString = dateInput.getText();  
           
           int amountInt = Integer.parseInt(amountString);
           
           date1 = Date.valueOf(dateString);
           nameInput.setText("");
           amountInput.setText("");
           dateInput.setText("");
           
           calculationMethods objMethods = new calculationMethods();
           
           //call method to deduct savings 
           objMethods.savingsDeduction(amountInt);
           
           
           //Query
           String dbQuery1 = "INSERT INTO savingsTable VALUES " + "(?,?,?)";
           
           try{
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
            //resultLabel.setText("Submit button was pressed");
            this.validate();
            this.repaint();
            
        }
           catch(SQLException r)
        {
            System.out.println("Error: Did not insert");
            ErrorFrame objErrorFrame = new ErrorFrame(this);
        }   
        }
        
        //Delete Savings
//        else if(buttonCommand.equals("Delete"))
//        {
//           String dbQuery3 = "DELETE FROM savingsTable WHERE Name=?"; 
//           String nameString = nameInput.getText();
//           dateInput.setText("");
//           try{
//           //Prepared Statement
//           PreparedStatement ps = myDbConn.prepareStatement(dbQuery3);
//           ps.setString(1, nameString);
//           ps.executeUpdate();
//           }
//           catch(SQLException s)
//        {
//            System.out.println("Error: did not delete");
//            ErrorFrame objErrorFrame = new ErrorFrame(this);
//        }
//          
//            resultLabel.setText("Delete Button was pressed");
//            this.validate();
//            this.repaint();
//            
//        }
        //Update Savings
//        else if(buttonCommand.equals("Update"))
//        {
//           String nameString = nameInput.getText();
//           String amountString = amountInput.getText();
//           String dateString = dateInput.getText();  
//           
//           int amountInt = Integer.parseInt(amountString);
//           
//           date1 = Date.valueOf(dateString);
//           nameInput.setText("");
//           amountInput.setText("");
//           dateInput.setText("");
//          //Query
//           System.out.println("1"); 
//           String dbQuery2 = "UPDATE savingsTable SET StartDate=?, SavingsAmount=? "
//                   + "WHERE Name=?"; 
//           
//           try{
//            //Prepared Statement
//            PreparedStatement ps = myDbConn.prepareStatement(dbQuery2);
//            ps.setDate(1, date1);
//            ps.setInt(2, amountInt);
//            ps.setString(3, nameString);;
//            ps.executeUpdate();
//            
//        }
//        catch(SQLException s)
//        {
//            System.out.println("Error: did not update!!");
//            ErrorFrame objErrorFrame = new ErrorFrame(this);
//        }
//        }
//            resultLabel.setText("Update Button was pressed");
//            this.validate();
//            this.repaint();
            
        }
        catch (NullPointerException ne)
        {
            System.out.println("Null");
            ErrorFrame objErrorFrame = new ErrorFrame(this);
        }
        catch (IllegalArgumentException iae)
        {
            System.out.println("Null");
            ErrorFrame objErrorFrame = new ErrorFrame(this);
        }
    }
    }
