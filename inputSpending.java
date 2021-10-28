/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//frame to input spendings
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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 */
class inputSpending extends JFrame implements ActionListener

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
    private JRadioButton weeklyButton;
    private JRadioButton monthlyButton;
    private JRadioButton OTButton;
    private Date date1;
    private JLabel typeLabel;
    private String billType;
    private JTextField typeInput;
    //colors
    private final Color BACKGROUND_COLOR = new Color(237, 230, 173);
    private final Color DARKGREEN_COLOR = new Color(48, 89, 98);
    private final Color DULLYELLOW_COLOR = new Color(220, 194, 134);
    private final Font MAIN_FONT = new Font("Arial", Font.BOLD, 40);

    public inputSpending(JFrame pFrame)
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
        typeLabel = new JLabel("Type:");
        //resultLabel = new JLabel("   ");

        weeklyButton = new JRadioButton("Weekly");
        weeklyButton.setBackground(DULLYELLOW_COLOR);
        weeklyButton.setOpaque(true);
        weeklyButton.setBorderPainted(false);
        weeklyButton.addActionListener(this);

        monthlyButton = new JRadioButton("Monthly");
        monthlyButton.setBackground(DULLYELLOW_COLOR);
        monthlyButton.setOpaque(true);
        monthlyButton.setBorderPainted(false);
        monthlyButton.addActionListener(this);

        OTButton = new JRadioButton("One Time");
        OTButton.setBackground(DULLYELLOW_COLOR);
        OTButton.setOpaque(true);
        OTButton.setBorderPainted(false);
        OTButton.addActionListener(this);

        nameInput = new JTextField(10);
        dateInput = new JTextField(10);
        amountInput = new JTextField(10);
        typeInput = new JTextField(10);

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
        inputPanel.add(dateLabel);
        inputPanel.add(dateInput);
        inputPanel.add(amountLabel);
        inputPanel.add(amountInput);
        inputPanel.add(deleteButton);
        inputPanel.add(closeButton);
        inputPanel.add(submitButton);
        inputPanel.add(homeButton);
        inputPanel.add(updateButton);

        JPanel rdPanel = new JPanel(new FlowLayout());
        rdPanel.add(typeLabel);
        rdPanel.add(typeInput);

        this.add(inputPanel, BorderLayout.NORTH);
        this.add(rdPanel, BorderLayout.SOUTH);

    }

    public inputSpending()
    {
        super();
        this.setBounds(100, 100, 1200, 500);
        this.getContentPane().setBackground(BACKGROUND_COLOR);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);

        nameLabel = new JLabel("Name:");
        dateLabel = new JLabel("Date:");
        amountLabel = new JLabel("Amount:");
        //resultLabel = new JLabel("   ");
        typeLabel = new JLabel("Type:");

        nameInput = new JTextField(10);
        dateInput = new JTextField(10);
        amountInput = new JTextField(10);

        typeInput = new JTextField(10);

        weeklyButton = new JRadioButton("Weekly");
        weeklyButton.setBackground(DULLYELLOW_COLOR);
        weeklyButton.setOpaque(true);
        weeklyButton.setBorderPainted(false);
        weeklyButton.addActionListener(this);

        monthlyButton = new JRadioButton("Monthly");
        monthlyButton.setBackground(DULLYELLOW_COLOR);
        monthlyButton.setOpaque(true);
        monthlyButton.setBorderPainted(false);
        monthlyButton.addActionListener(this);

        OTButton = new JRadioButton("One Time");
        OTButton.setBackground(DULLYELLOW_COLOR);
        OTButton.setOpaque(true);
        OTButton.setBorderPainted(false);
        OTButton.addActionListener(this);

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

        JPanel rdPanel = new JPanel(new FlowLayout());
        rdPanel.add(typeLabel);
        rdPanel.add(typeInput);

        this.add(inputPanel, BorderLayout.NORTH);
        this.add(rdPanel, BorderLayout.SOUTH);

        this.setVisible(true);

    }

    public static void main(String[] args)
    {
        // TODO code application logic here

        inputSpending objFrame6 = new inputSpending();
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
        
        //potential table headers and table names
        String [] MtableHeaders = {
            "Name", "MBillingDate", "MonthlyBillAmount"
        };
        
        String mtable = "monthlyBillsTable";
        
        String [] WtableHeaders = {
            "Name", "WBillingDate", "WeeklyBillAmount"
        };
        
        String wtable = "weeklyBillsTable";
        
        String [] OTtableHeaders = {
            "Name", "Date", "OTPurchasesAmount"
        };
        
        String OTtable = "OTPurchasesTable";
        
        if (buttonCommand.equals("Home"))
        {
            this.dispose();
            gFrame.setVisible(true);
        } else if (buttonCommand.equals("Close"))
        {
            this.dispose();
            System.exit(0);

            //Input Spendings
        } else if (buttonCommand.equals("Submit"))
        {
            String nameString = nameInput.getText();
            String amountString = amountInput.getText();
            String dateString = dateInput.getText();

            String typeString = typeInput.getText();

            int amountInt = Integer.parseInt(amountString);

            date1 = java.sql.Date.valueOf(dateString);
            nameInput.setText("");
            amountInput.setText("");
            dateInput.setText("");
            typeInput.setText("");
           
            //if the input doesnt equal any of these display error frame
            if(!typeString.equalsIgnoreCase("Monthly") && !typeString.equalsIgnoreCase("Weekly") && !typeString.equalsIgnoreCase("OTPurchase")){
                ErrorFrame objErrorFrame = new ErrorFrame(this);
            }

            //If monthly Spending insert into Monthly DB
            if (typeString.equals("Monthly"))
            {
                //Query
                String dbQuery1 = "INSERT INTO monthlyBillsTable VALUES " + "(?,?,?)";
                System.out.println(dbQuery1);
                try
                {
                    //Prepared Statement
                    PreparedStatement ps = myDbConn.prepareStatement(dbQuery1);
                    ps.setString(1, nameString);
                    ps.setDate(2, date1);
                    ps.setInt(3, amountInt);
                    ps.executeUpdate();
                    System.out.println("inserted!!!");

                } catch (SQLException r)
                {
                    System.out.println("Error: Did not insert");
                    ErrorFrame objErrorFrame = new ErrorFrame(this);
                }

                //If weekly Spending insert into Weekly DB
            } else if (typeString.equals("Weekly"))
            {

                //Query
                String dbQuery1 = "INSERT INTO weeklyBillsTable VALUES " + "(?,?,?)";

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
                    //resultLabel.setText("Submit button was pressed");
                    this.validate();
                    this.repaint();

                } catch (SQLException r)
                {
                    System.out.println("Error: Did not insert");
                    ErrorFrame objErrorFrame = new ErrorFrame(this);
                }

                //If one time  spending insert into OT Purchases DB
            } else if (typeString.equals("OTPurchase"))
            {
                System.out.println("1");

                int total = Obj1.getTotalAmount();  
                total= total - amountInt; 
                Obj1.setTotalAmount(total);
                
                System.out.println("2");
                //Query
                String dbQuery1 = "INSERT INTO OTPurchasesTable VALUES " + "(?,?,?)";

                System.out.println("3");
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
                    //resultLabel.setText("Submit button was pressed");
                    this.validate();
                    this.repaint();

                } catch (SQLException r)
                {
                    System.out.println("Error: Did not insert");
                    ErrorFrame objErrorFrame = new ErrorFrame(this);
                }
            }
            else{
                ErrorFrame objErrorFrame = new ErrorFrame(this);
            }

            //Delete Spendings    
        } else if (buttonCommand.equals("Delete"))
        {
            String nameString = nameInput.getText();
            String amountString = amountInput.getText();
            String dateString = dateInput.getText();
            String typeString = typeInput.getText();
            
             //if the input doesnt equal any of these display error frame
            if(!typeString.equalsIgnoreCase("Monthly") && !typeString.equalsIgnoreCase("Weekly") && !typeString.equalsIgnoreCase("OTPurchase")){
                ErrorFrame objErrorFrame = new ErrorFrame(this);
            }

            int amountInt = Integer.parseInt(amountString);

            date1 = java.sql.Date.valueOf(dateString);
            nameInput.setText("");
            amountInput.setText("");
            dateInput.setText("");
            typeInput.setText("");

            //If monthly spending delete from monthly DB
            if (typeString.equalsIgnoreCase("Monthly"))
            {
                
                boolean check = Obj1.checkData(MtableHeaders, nameString, mtable);
                System.out.println("check" + check);
                if (check == false){
                    
                    ErrorFrame objErrorFrame = new ErrorFrame(this);
                    System.out.println("FALSEE");
                }
                else{

                String dbQuery3 = "DELETE FROM monthlyBillsTable WHERE Name=?";
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
                }

                //If weekly spending delete from weekly DB
            } else if (typeString.equalsIgnoreCase("Weekly"))
            {
                boolean check = Obj1.checkData(WtableHeaders, nameString, wtable);
                System.out.println("check" + check);
                if (check == false){
                    
                    ErrorFrame objErrorFrame = new ErrorFrame(this);
                }

                else{
                String dbQuery3 = "DELETE FROM weeklyBillsTable WHERE Name=?";
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
                }

                //If One time spending delete from OTPurchases DB
            } else if (typeString.equalsIgnoreCase("OTPurchase"))
            {
                
                boolean check = Obj1.checkData(OTtableHeaders, nameString, OTtable);
                System.out.println("check" + check);
                if (check == false){
                     ErrorFrame objErrorFrame = new ErrorFrame(this);
                }
                else{

                String dbQuery3 = "DELETE FROM OTPurchasesTable WHERE StoreName=?";
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
                    ErrorFrame objErrorFrame = new ErrorFrame(this);;
                }
            }

            }
            

            //Update Spendings
        } else if (buttonCommand.equalsIgnoreCase("Update"))
        {
            
            String nameString = nameInput.getText();
            String amountString = amountInput.getText();
            String dateString = dateInput.getText();
            String typeString = typeInput.getText();
            
            if(!typeString.equalsIgnoreCase("Monthly") && !typeString.equalsIgnoreCase("Weekly") && !typeString.equalsIgnoreCase("OTPurchase")){
                ErrorFrame objErrorFrame = new ErrorFrame(this);
            }

            int amountInt = Integer.parseInt(amountString);

            date1 = java.sql.Date.valueOf(dateString);
            nameInput.setText("");
            amountInput.setText("");
            dateInput.setText("");
            typeInput.setText("");

            //If monthly spending update monthly DB
            if ((typeString.equalsIgnoreCase("Monthly")))
            {
                
                boolean check = Obj1.checkData(MtableHeaders, nameString, mtable);
                System.out.println("check" + check);
                if (check == false){
                    
                    ErrorFrame objErrorFrame = new ErrorFrame(this);
                }
                else{
                    
                
                String dbQuery2 = "UPDATE monthlyBillsTable SET MBillingDate=?, MonthlyBillAmount=? "
                        + "WHERE Name=?";

                try
                {
                    //Prepared Statement
                    PreparedStatement ps = myDbConn.prepareStatement(dbQuery2);
                    ps.setDate(1, date1);
                    ps.setInt(2, amountInt);
                    ps.setString(3, nameString);
                    ps.executeUpdate();

//            this.dispose();
//            DrivingLog objDrivingLog = new DrivingLog();  
                } catch (SQLException s)
                {
                    System.out.println("Error: did not update!!");
                    ErrorFrame objErrorFrame = new ErrorFrame(this);
                }
                }
                //If weekly spending update weekly DB
            } else if (typeString.equalsIgnoreCase("Weekly"))
            {
                boolean check = Obj1.checkData(WtableHeaders, nameString, wtable);
                System.out.println("check" + check);
                if (check == false){
                    
                    ErrorFrame objErrorFrame = new ErrorFrame(this);
                }
                else{
                String dbQuery2 = "UPDATE weeklyBillsTable SET WBillingDate=?, WeeklyBillAmount=? "
                        + "WHERE Name=?";

                try
                {
                    //Prepared Statement
                    PreparedStatement ps = myDbConn.prepareStatement(dbQuery2);
                    ps.setDate(1, date1);
                    ps.setInt(2, amountInt);
                    ps.setString(3, nameString);;
                    ps.executeUpdate();

//            this.dispose();
//            DrivingLog objDrivingLog = new DrivingLog();  
                } catch (SQLException s)
                {
                    System.out.println("Error: did not update!!");
                    ErrorFrame objErrorFrame = new ErrorFrame(this);
                }
                }
            } //If one time spending update OT DB
            else if (typeString.equalsIgnoreCase("OTPurchase"))
            {
                String dbQuery2 = "UPDATE OTPurchasesTable SET Date=?, OTPurchasesAmount=? "
                        + "WHERE StoreName=?";
                
                boolean check = Obj1.checkData(OTtableHeaders, nameString, OTtable);
                System.out.println("check" + check);     
                if (check == false){
                     ErrorFrame objErrorFrame = new ErrorFrame(this);
                }

                else{
                try
                {
                    //Prepared Statement
                    PreparedStatement ps = myDbConn.prepareStatement(dbQuery2);
                    ps.setDate(1, date1);
                    ps.setInt(2, amountInt);
                    ps.setString(3, nameString);
                    ps.executeUpdate();

//            this.dispose();
//            DrivingLog objDrivingLog = new DrivingLog();  
                } catch (SQLException s)
                {
                    System.out.println("Error: did not update!!");
                    ErrorFrame objErrorFrame = new ErrorFrame(this);
                }
                }
                }

            //resultLabel.setText("Update Button was pressed");
            this.validate();
            this.repaint();

        }
        
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
