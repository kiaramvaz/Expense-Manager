/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package expensehandler;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author KiaraVaz
 */
public class welcomeFrame extends JFrame implements ActionListener
{
    private final Color BACKGROUND_COLOR = new Color(237,230,173);
    private final Color DARKGREEN_COLOR = new Color(48,89,98);
    private final Color DULLYELLOW_COLOR = new Color(220,194,134);
    private final Font MAIN_FONT = new Font("Arial",Font.BOLD,25);

    //Decleration
    //private final Color ACCELERATION_COLOR = new Color(255, 229, 204);
    private JPanel buttonPanel1;
    private JPanel buttonPanel2;
    private JPanel buttonPanel3;
    private JLabel resultLabel;
    private JFrame gFrame;
    private JLabel welcomeLabel;
    private JLabel pictureLabel;
    private JButton closeButton;
    private JButton spendingButton;
    private JButton savingsButton;
    private JButton incomeButton;
    private JButton totalButton;
    private JButton monthlyDisplayButton;
    private JButton weeklyDisplayButton;
    private JButton budgetsButton;
    private JButton affordButton;
    
    //image
    private final java.net.URL MONEY_PICTURE = getClass().getResource("Money.png");
    ImageIcon myIcon = new ImageIcon(new ImageIcon(
        MONEY_PICTURE).getImage().getScaledInstance(
        1,1,Image.SCALE_DEFAULT));
    private final ImageIcon MONEY_IMAGE = new ImageIcon(MONEY_PICTURE);
    
    public welcomeFrame()
    {
        super();
        this.setBounds(100, 100, 1200, 500);
        this.getContentPane().setBackground(BACKGROUND_COLOR);
        
        //initialization
        welcomeLabel = new JLabel("<html> Expense Organizer: <br/> Application should be running at all times   <br/> if you close the application you risk missing  <br/> income/bill calculations </html>",SwingConstants.CENTER);
        welcomeLabel.setFont(MAIN_FONT);

        pictureLabel = new JLabel(MONEY_IMAGE, SwingConstants.CENTER);
        
        closeButton = new JButton("Close");
        closeButton.setBackground(DULLYELLOW_COLOR);
        closeButton.setOpaque(true);
        closeButton.setBorderPainted(false);
        closeButton.addActionListener(this);

        spendingButton = new JButton("Input Spending");
        spendingButton.setBackground(DULLYELLOW_COLOR);
        spendingButton.setOpaque(true);
        spendingButton.setBorderPainted(false);
        spendingButton.addActionListener(this);

        savingsButton = new JButton("Input Savings");
        savingsButton.setBackground(DULLYELLOW_COLOR);
        savingsButton.setOpaque(true);
        savingsButton.setBorderPainted(false);
        savingsButton.addActionListener(this);

        incomeButton = new JButton("Input Income");
        incomeButton.setBackground(DULLYELLOW_COLOR);
        incomeButton.setOpaque(true);
        incomeButton.setBorderPainted(false);
        incomeButton.addActionListener(this);

        totalButton = new JButton("View Total");
        totalButton.setBackground(DULLYELLOW_COLOR);
        totalButton.setOpaque(true);
        totalButton.setBorderPainted(false);
        totalButton.addActionListener(this);

        monthlyDisplayButton = new JButton("View Monthly Bills");
        monthlyDisplayButton.setBackground(DULLYELLOW_COLOR);
        monthlyDisplayButton.setOpaque(true);
        monthlyDisplayButton.setBorderPainted(false);
        monthlyDisplayButton.addActionListener(this);

        weeklyDisplayButton = new JButton("View Weekly Bills");
        weeklyDisplayButton.setBackground(DULLYELLOW_COLOR);
        weeklyDisplayButton.setOpaque(true);
        weeklyDisplayButton.setBorderPainted(false);
        weeklyDisplayButton.addActionListener(this);

        affordButton = new JButton("Check if you can afford");
        affordButton.setBackground(DULLYELLOW_COLOR);
        affordButton.setOpaque(true);
        affordButton.setBorderPainted(false);
        affordButton.addActionListener(this);
        
        buttonPanel1 = new JPanel(new FlowLayout());
        buttonPanel1.setBackground(DARKGREEN_COLOR);
        buttonPanel3 = new JPanel(new FlowLayout());
        buttonPanel3.setBackground(DARKGREEN_COLOR);
        buttonPanel2 = new JPanel(new FlowLayout());
        buttonPanel2.setBackground(DARKGREEN_COLOR);
        buttonPanel1.add(closeButton);
        buttonPanel1.add(spendingButton);
        buttonPanel1.add(savingsButton);
        buttonPanel1.add(incomeButton);
        buttonPanel2.add(totalButton);
        buttonPanel2.add(monthlyDisplayButton);
        buttonPanel2.add(weeklyDisplayButton);
        buttonPanel2.add(affordButton);
        
        buttonPanel3.add(welcomeLabel,BorderLayout.NORTH);
        buttonPanel3.add(buttonPanel2,BorderLayout.CENTER);

        this.add(buttonPanel1,BorderLayout.SOUTH);
        this.add(buttonPanel3,BorderLayout.NORTH);
        this.add(pictureLabel,BorderLayout.CENTER);
        this.setVisible(true);

    }

    public static void main(String[] args)
    {

        
        welcomeFrame objFrame1 = new welcomeFrame();
        JavaDb Obj1 = new JavaDb("ExpenseDatabase");
        Connection myDbConn;
        myDbConn = Obj1.getdbConn();
        
        
        TimerTask tasknew = new TimerTask()
        
        {
            
            @Override
            public void run()
            { 
                JLabel brokeLabel = new JLabel("",SwingConstants.CENTER);
                int min = 1000;
                int total = Obj1.getTotalAmount();  
                if (total == 0){
                    brokeLabel = new JLabel("You have 0$ in ur bank account");
                    brokeDisplay objBrokeDisplay = new brokeDisplay(brokeLabel);
                }
                if (total < min && total > 0){
                    brokeLabel = new JLabel("You are almost broke watch ur spending!!");
                    brokeDisplay objBrokeDisplay = new brokeDisplay(brokeLabel);
                
                }
                if (total < 0){
                    brokeLabel = new JLabel("You total is now in the negatives!");
                    brokeDisplay objBrokeDisplay = new brokeDisplay(brokeLabel);
                }
                
                //income Date List
                ArrayList<Date> incomeDateList = new ArrayList<>();
                String[] incomeColumnsDate =
                {"Name", "StartDate", "IncomeAmount"};
                ArrayList<ArrayList<java.sql.Date>> incomeDateList2;
                incomeDateList2 = Obj1.getDateList("incomeTable","StartDate", incomeColumnsDate);
                for (int i = 0; i<incomeDateList2.size(); i++){
                    incomeDateList.add(incomeDateList2.get(i).get(0));
                }
                
                //income Amount List
                ArrayList<Integer> incomeAmountList = new ArrayList<>();
                String[] incomeColumnsAmt =
                {"Name", "StartDate", "IncomeAmount"};
                ArrayList<ArrayList<Integer>> incomeAmountList2;
                incomeAmountList2 = Obj1.getAmountList("incomeTable","IncomeAmount", incomeColumnsDate);
                for (int i = 0; i<incomeAmountList2.size(); i++){
                    incomeAmountList.add(incomeAmountList2.get(i).get(0));
                }
                
                //Monthly Date List
                ArrayList<Date> monthlyDateList = new ArrayList<>();
                String[] MonthlyColumnsDate =
                {"Name", "MBillingDate", "MonthlyBillAmount"};
                ArrayList<ArrayList<java.sql.Date>> monthlyDateList2;
                monthlyDateList2 = Obj1.getDateList("monthlyBillsTable","MBillingDate", MonthlyColumnsDate);
                for (int i = 0; i<monthlyDateList2.size(); i++){
                    monthlyDateList.add(monthlyDateList2.get(i).get(0));
                }
                
                //Monthly Amount List
                ArrayList<Integer> monthlyAmountList = new ArrayList<>();
                String[] monthlyColumnsAmt =
                {"Name", "MBillingDate", "MonthlyBillAmount"};
                ArrayList<ArrayList<Integer>>  monthlyAmountList2;
                monthlyAmountList2 = Obj1.getAmountList("monthlyBillsTable","MonthlyBillAmount", monthlyColumnsAmt);
                for (int i = 0; i<monthlyAmountList2.size(); i++){
                    monthlyAmountList.add(monthlyAmountList2.get(i).get(0));
                }
                
                //Weekly Date List
                ArrayList<Date> weeklyDateList = new ArrayList<>();
                String[] WeeklyColumnsDate =
                {"Name", "WBillingDate", "WeeklyBillAmount"};
                ArrayList<ArrayList<java.sql.Date>> weeklyDateList2;
                weeklyDateList2 = Obj1.getDateList("weeklyBillsTable","WBillingDate", WeeklyColumnsDate);
                for (int i = 0; i<weeklyDateList2.size(); i++){
                    weeklyDateList.add(weeklyDateList2.get(i).get(0));
                }
                
                //Weekly Amount List
                ArrayList<Integer> weeklyAmountList = new ArrayList<>();
                String[] weeklyColumnsAmt =
                {"Name", "WBillingDate", "WeeklyBillAmount"};
                ArrayList<ArrayList<Integer>>  weeklyAmountList2;
                weeklyAmountList2 = Obj1.getAmountList("weeklyBillsTable","WeeklyBillAmount", weeklyColumnsAmt);
                for (int i = 0; i<weeklyAmountList2.size(); i++){
                    weeklyAmountList.add(weeklyAmountList2.get(i).get(0));
                }

                
                calculationMethods objMethods = new calculationMethods();
                //income addition method
                objMethods.incomeAddition(incomeDateList, incomeAmountList);
                //monthly bill method
                objMethods.monthlyBillDeduction(monthlyDateList, monthlyAmountList);
                //weekly bill method
                objMethods.weeklyBillDeduction(weeklyDateList, weeklyAmountList);
                
            }
        };
        Timer timer = new Timer();

        // scheduling the task at fixed rate of 86400000 ( miliseconds in a day)
        timer.scheduleAtFixedRate(tasknew, 0, 86400000);    
   
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        
        //button comands to navigate to next frames
        String buttonCommand = e.getActionCommand();
        if(buttonCommand.equals("Input Spending"))
        {
            inputSpending objInputSpending = new inputSpending(this);
            this.setVisible(false);
        }
        else if(buttonCommand.equals("Input Savings"))
        {
            inputSavings objInputSavings = new inputSavings(this);
            this.setVisible(false);
        }
        else if(buttonCommand.equals("Input Income"))
        {
            inputIncomeFrame objInputIncome = new inputIncomeFrame(this);
            this.setVisible(false);
        }
        else if(buttonCommand.equals("View Total"))
        {
            totalDisplay objTotalDisplay = new totalDisplay(this);
            this.setVisible(false);
        }
        
        else if(buttonCommand.equals("View Monthly Bills"))
        {
            monthlyDisplay objMonthlyDisplay = new monthlyDisplay(this);
            this.setVisible(false);
        }
        
        else if(buttonCommand.equals("View Weekly Bills"))
        {
            weeklyDisplay objWeeklyDisplay = new weeklyDisplay(this);
            this.setVisible(false);
        }
       
        
        else if(buttonCommand.equals("Check if you can afford"))
        {
            affordInput objAffordInput = new affordInput(this);
            this.setVisible(false);
        }
        else if(buttonCommand.equals("Close"))
        {
            this.dispose();
            System.exit(0);
            
        }
        
        
    }

}
