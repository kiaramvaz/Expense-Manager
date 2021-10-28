/*
The database and the table are created in the class.
 */
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package expensehandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * 
 */
public class installDb
{

    public static void main(String[] args)
    {
        String OTPurchasesTable;
        String savingsTable;
        String incomeTable;
        String monthlyBillsTable;
        String weeklyBillsTable;
        String budgetsTable;
        String totalTable;
        String Savings;

        //create db
        JavaDb objDb = new JavaDb();
        objDb.createDb("ExpenseDatabase");
        
        JavaDb Obj1 = new JavaDb("ExpenseDatabase");
        Connection myDbConn;
        myDbConn = Obj1.getdbConn();

        //creation of  database tables 
        
        savingsTable = "CREATE TABLE savingsTable (" + "Name varchar(50), " + "StartDate date, " + "SavingsAmount int, " + "PRIMARY KEY (Name)" + ")";
        objDb.createTable(savingsTable, "ExpenseDatabase");
        System.out.println(savingsTable);
        
        OTPurchasesTable = "CREATE TABLE OTPurchasesTable (" + "Name varchar(50), " + "Date date, " + "OTPurchasesAmount int, " + "PRIMARY KEY (Name, Date, OTPurchasesAmount)" + ")";
        objDb.createTable(OTPurchasesTable, "ExpenseDatabase");
        System.out.println(OTPurchasesTable);

        incomeTable = "CREATE TABLE incomeTable (" + "Name varchar(50), " + "StartDate date, " + "IncomeAmount int, " + "PRIMARY KEY (Name)" + ")";
        objDb.createTable(incomeTable, "ExpenseDatabase");
        System.out.println(incomeTable);

        monthlyBillsTable = "CREATE TABLE monthlyBillsTable (" + "Name varchar(50), " + "MBillingDate date, " + "MonthlyBillAmount int, " + "PRIMARY KEY (Name)" + ")";
        objDb.createTable(monthlyBillsTable, "ExpenseDatabase");
        System.out.println(monthlyBillsTable);

        weeklyBillsTable = "CREATE TABLE weeklyBillsTable (" + "Name varchar(50), " + "WBillingDate date, " + "WeeklyBillAmount int, " + "PRIMARY KEY (Name)" + ")";
        objDb.createTable(weeklyBillsTable, "ExpenseDatabase");
        System.out.println(weeklyBillsTable);

        totalTable = "CREATE TABLE totalTable1 (" + "id int, " + "totalAmount int, " + "PRIMARY KEY (id)" + ")";
        objDb.createTable(totalTable, "ExpenseDatabase");
        System.out.println(totalTable);
        
        
        //inserting initial total value.
        String dbQuery1 = "INSERT INTO totalTable1 VALUES " + "(?,?)";
           
           try{
            //Prepared Statement
            PreparedStatement ps = myDbConn.prepareStatement(dbQuery1);
            ps.setInt(1, 1);;
            ps.setInt(2, 100000);
            ps.executeUpdate();
            
            
        }
           catch(SQLException r)
        {
            System.out.println("Error: Did not insert");
            r.printStackTrace();
           System.exit(0);
       }

    }
}
