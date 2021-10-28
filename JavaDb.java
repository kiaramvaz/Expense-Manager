// September 7th. This class has all the sql database methods
//package expensehandler;
//Sql Database Methods

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
//import java.util.Date;
import java.sql.Date;
import java.sql.PreparedStatement;

/**
 *
 *  */
public class JavaDb
{

    private String dbName;
    private Object[][] data;
    private Connection dbConn;
    private int totalAmount;

    public JavaDb(String dbName)
    {
        this.dbName = dbName;
        this.data = null;
        this.totalAmount = 0; 
        setdbConn();
    }

    public JavaDb()
    {
        this.dbName = "";
        this.data = null;
        this.dbConn = null;
        this.totalAmount = 0;
    }

    //gets the db name
    public String getdbName()
    {
        return dbName;
    }

    //sets the db name
    public void setdbName(String dbName)
    {
        this.dbName = dbName;
    }

    //select method to get data from the database
    public Object[][] getdata(String tableName, String[] tableHeaders)
    {
        JavaDb Obj1 = new JavaDb("ExpenseDatabase");
        Connection myDbConn;
        myDbConn = Obj1.getdbConn();
        int columnCount = tableHeaders.length;
        ResultSet rs = null;
        Statement s = null;
        String dbQuery = "SELECT * FROM " + tableName;
        ArrayList<ArrayList<String>> dataList = new ArrayList<>();
        System.out.println(1);
        try
        {
            s = this.dbConn.createStatement();
            rs = s.executeQuery(dbQuery);
            while (rs.next())
            {
                ArrayList<String> row = new ArrayList<>();
                for (int i = 0; i < columnCount; i++)
                {
                    row.add(rs.getString(tableHeaders[i]));
                }
                dataList.add(row);
                System.out.println(2);
            }

            this.data = new Object[dataList.size()][columnCount];
            for (int i = 0; i < dataList.size(); i++)
            {
                ArrayList<String> row;
                row = dataList.get(i);

                row = dataList.get(i);
                for (int j = 0; j < columnCount; j++)
                {
                    this.data[i][j] = row.get(j);
                }
            }
        } catch (SQLException err)
        {
            System.out.println("Unable to get the data from database!");
            err.printStackTrace();
            System.exit(0);
            
        }
        return this.data;
    }

    //gets an arraylist of arraylist of just the dates
   public ArrayList<ArrayList<Date>> getDateList(String tableName, String columnName, String [] columnNames){
       int columnCount= columnNames.length;
       ResultSet rs = null;
       Statement s= null;
       
       JavaDb Obj1 = new JavaDb("ExpenseDatabase");
       Connection myDbConn;
       myDbConn = Obj1.getdbConn();
       
       String dbQuery = "SELECT " + columnName + " FROM " + tableName;
       ArrayList<ArrayList<Date>> dataList = new ArrayList<>();
       
       try{
           s= this.dbConn.createStatement();
           rs= s.executeQuery(dbQuery);
           while(rs.next()){
               ArrayList<Date> row = new ArrayList<>();
               Date theDate = rs.getDate(columnNames[1]);
               row.add(theDate);
               dataList.add(row);          
           }
       }
       catch(SQLException sqle){
           sqle.printStackTrace();
           System.exit(0);
       }
      return dataList;
   }
   
   //get arraylist of arraylist of just the amounts 
   public ArrayList<ArrayList<Integer>> getAmountList(String tableName, String columnName, String [] columnNames){
       int columnCount= columnNames.length;
       ResultSet rs = null;
       Statement s= null;
       
       JavaDb Obj1 = new JavaDb("ExpenseDatabase");
       Connection myDbConn;
       myDbConn = Obj1.getdbConn();
       
       String dbQuery = "SELECT " + columnName + " FROM " + tableName;
       ArrayList<ArrayList<Integer>> dataList = new ArrayList<>();
       
       try{
           s= this.dbConn.createStatement();
           rs= s.executeQuery(dbQuery);
           while(rs.next()){
               
               ArrayList<Integer> row = new ArrayList<>();
               Integer theAmount = rs.getInt(columnNames[2]);
               row.add(theAmount);
               dataList.add(row);
                         
           }
       }
       catch(SQLException sqle){
           System.out.print("ERROR121");
           sqle.printStackTrace();
           System.exit(0);
       }
      return dataList;
   }
   
   //gets the total amount from database
   public int getTotalAmount(){
       String[] tableHeaders =
        {
            "id", "totalAmount"
        };
       int columnCount= tableHeaders.length;
       ResultSet rs = null;
       Statement s= null;
       
       JavaDb Obj1 = new JavaDb("ExpenseDatabase");
       Connection myDbConn;
       dbConn = Obj1.getdbConn();
       
       //db query
       String dbQuery = "SELECT totalAmount FROM totalTable1";
       ArrayList<ArrayList<Integer>> totalList2 = new ArrayList<>();
       ArrayList<Integer> totalList = new ArrayList<>();
       try{
           s= this.dbConn.createStatement();
           rs= s.executeQuery(dbQuery);
           while(rs.next()){
               ArrayList<Integer> row = new ArrayList<>();
               Integer theAmount = rs.getInt(tableHeaders[1]);
               row.add(theAmount);
               totalList2.add(row);            
           }
       }
       catch(SQLException sqle){
           System.out.print("ERRORY");
           sqle.printStackTrace();
           System.exit(0);
       }
       //one cell
       totalAmount = (totalList2.get(0).get(0));
       return totalAmount;
   }
   
   //checks to see if data exists in the db 
   public boolean checkData(String[] columnNames, String data, String tableName){
       
       boolean check = true;
       int columnCount= columnNames.length;
       ResultSet rs = null;
       Statement s= null;
       
       JavaDb Obj1 = new JavaDb("ExpenseDatabase");
       Connection myDbConn;
       myDbConn = Obj1.getdbConn();
       
       //String dbQuery2 = "SELECT * FROM monthlyBillsTable WHERE Name='Tanmai'";
       String dbQuery = "SELECT * FROM " + tableName + " WHERE Name=" + "'" +  data + "'" + " ";
       System.out.print(dbQuery); 
       ArrayList<ArrayList<Integer>> totalList2 = new ArrayList<>();
       ArrayList<Integer> totalList = new ArrayList<>();
       try{
           s= this.dbConn.createStatement();
           rs = s.executeQuery(dbQuery);
           if (rs.next()){
             check = true;   
           }
           else{
               check = false; 
           }
           
       }
       catch(SQLException sqle){
           //if doesnt exist it will throw a sql error and return false
           check = false; 
           sqle.printStackTrace();
           System.out.print("errorrr");
           
       }
       return check;
   }
   
    public void setTotalAmount(int totalAmount)
    {
        JavaDb Obj1 = new JavaDb("ExpenseDatabase");
        Connection myDbConn;
        myDbConn = Obj1.getdbConn();
        String dbQuery2 = "UPDATE totalTable1 SET totalAmount=? "
                + "WHERE id=1";
        try
        {
            //Prepared Statement
            PreparedStatement ps = myDbConn.prepareStatement(dbQuery2);
            ps.setInt(1, totalAmount);
            ps.executeUpdate();

        } catch (SQLException s)
        {
            System.out.println("Error: did not update!!");
        }
        
        this.totalAmount = totalAmount; 
   }
    //sets the data
    public void setdata(Object[][] hours)
    {
        this.data = hours;
    }

    //gets the database connection
    public Connection getdbConn()
    {
        return this.dbConn;
    }

    //sets the connection
    public void setdbConn()
    {

        String connectionURL = "jdbc:derby:" + this.dbName;
        this.dbConn = null;

        try
        {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            this.dbConn = DriverManager.getConnection(connectionURL);
        } catch (SQLException err)
        {
            err.printStackTrace();
            System.out.println("SQL Connection ERRORRR set db");
            System.exit(0);
        } catch (ClassNotFoundException ex)
        {
            System.out.println("Class For Name not Found");
            System.exit(0);

        }
    }

    //closes the connection
    public void closeDbConn()
    {
        try
        {
            this.dbConn.close();

        } catch (Exception err)
        {
            System.out.println("DB closing error");
            System.exit(0);
        }
    }

    //creates the database
    public void createDb(String newDbName)
    {
        setdbName(newDbName);
        String connectionURL = "jdbc:derby:" + this.dbName + ";create=true";
        this.dbConn = null;
        try
        {

            System.out.println("Connection to and creating the database");
            System.out.println("0");
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            System.out.println("1");
            this.dbConn = DriverManager.getConnection(connectionURL);
            System.out.println("2");
            System.out.println("Database created.");
            System.out.println("3");
            //dbConn.close();

        } catch (ClassNotFoundException ex)
        {
            System.out.println("Class for name not found1");
            ex.printStackTrace(System.err);

        } catch (SQLException se)
        {
            System.out.println("SQL ERRORRRR");
            se.printStackTrace(System.err);

        }

    }

    //sets connection and creates a table
    public void createTable(String newTable, String dbName)
    {
        Statement s;

        setdbName(dbName);
        setdbConn();
        try
        {
            s = this.dbConn.createStatement();
            s.execute(newTable);
            this.dbConn.close();

        } catch (SQLException err)
        {
            System.exit((0));
        }
    }

//    public static void main(String[] args)
//    {
//        System.out.print("1");
//        String dbName = "ExpenseDatabase";
//        String tableName = "incomeTable";
//        String tableHeader = "StartDate";
//        JavaDb dbObj = new JavaDb(dbName);
//
//        //ArrayList<Date> data = dbObj.getDates(tableName, tableHeader);
//        
////        System.out.print("3");
////        for (int i = 0; i < data.size(); i++)
////        {
////            System.out.print(data.get(i));
////        }
//    }
//
}
