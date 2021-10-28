//package expensehandler;
//file with all the calculation methods
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Calendar;
import java.time.DayOfWeek; 
import static java.time.Instant.now;
import java.util.ArrayList;
/**
 *
 * 
 */
public class calculationMethods
{
     JavaDb objDb = new JavaDb();

    //method compares current date with date(number) of inputed date 
    public static boolean checkDayOfMonth(Date incomeDate)
    {
        
        boolean checkDate; 
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int today = localDate.getDayOfMonth();
        int incomeDateDay =incomeDate.getDate();
        //if todays date equals inputed date
        if (today == incomeDateDay){
            checkDate = true;
        }
        else checkDate = false;
        
        return checkDate;
    }
    
    //checks if today is a saturday. 
    public static boolean checkIfToday()
    {
        boolean checkDate; 
        Date date = new Date();
        
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Object today = localDate.getDayOfWeek();
        String todayString = today.toString();
        System.out.println( "today " +todayString);
        //if today is a saturday
        if (todayString.equals("SATURDAY")){
            checkDate = true;
        }
        else checkDate = false;
        return checkDate;
    }

    
    
    
    
    public void incomeAddition (ArrayList<Date> dateArrayList, ArrayList<Integer> amountArrayList){
      
        int total;
        //getTotal from db
        //loops through every date in array 
        for ( int i=0; i< dateArrayList.size() ; i++){
            //gets total from db
            total = objDb.getTotalAmount();
            //gets date from db
            Date incomeDate = dateArrayList.get(i);
            //calls method to check if dates match
            boolean deductBool = checkDayOfMonth(incomeDate);
            //if dates match
            if (deductBool == true){
                //change total by adding amount from corresponding index from the arraylist of amounts
                total = total + amountArrayList.get(i);
                //update amount in db
                objDb.setTotalAmount(total);
        }
        }
    }
                
    public void  monthlyBillDeduction(ArrayList<Date> dateArrayList, ArrayList<Integer> amountArrayList ){
        
        int total;
        //getTotal from db
        //loops through every date in array
        for ( int i=0; i< dateArrayList.size() ; i++){
            //gets total from db
            total = objDb.getTotalAmount();
            //gets date from db
            Date billDate = dateArrayList.get(i);
            //calls method to check if dates match
            boolean deductBool = checkDayOfMonth(billDate);
            //if dates match
            if (deductBool == true){
                //change total by subtracting amount from corresponding index from the arraylist of amounts
                total = total - amountArrayList.get(i);
                //update amount in db
                objDb.setTotalAmount(total);
        }
        }
            
            
        }
    public void  weeklyBillDeduction(ArrayList<Date> dateArrayList, ArrayList<Integer> amountArrayList ){
        
        int total;
        //loops through arraylist of dates 
        for ( int i=0; i< dateArrayList.size() ; i++){
            //get total from database
            total = objDb.getTotalAmount();
            //get date from arraylist of dates
            Date incomeDate = dateArrayList.get(i);
            //call method to see if current day is a saturday
            boolean deductBool = checkDayOfMonth(incomeDate);
            if (deductBool == true){
                //change total by subtracting amount from corresponding index from the arraylist of amounts
                total = total - amountArrayList.get(i);
                //update total in db
                objDb.setTotalAmount(total);
        }
        }
    }
    
    //check if afford
        public boolean checkIfAfford (int amount){
            boolean afford;
            //get total from db
            int total = objDb.getTotalAmount();
            //subtract potential price from total
            int futureTotal = total - amount;
            //min = budget (user given)
            int budget = 1000;
            //check if greater
            //if total is less than equal to
            if (futureTotal <= budget) 
            {
              afford = false;
            }
            else 
            {
              afford = true; 
            }
        
            return afford;
    }
        
        //deduct savings
        public void savingsDeduction (int amount ){
            //get total from db
            int total = objDb.getTotalAmount();
            //total minus the amount
            total = total - amount;
            //set new total
            objDb.setTotalAmount(total);
            
    }
        
        public static void main(String[] args) throws SQLException{
         Date d1 = new Date(2020, 01, 11); 
         int testAmount = 200;
         boolean answer = checkIfToday();
         System.out.println(answer);
        }
        
}

