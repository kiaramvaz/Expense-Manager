To install database for application:
First Run installDb.jar (There are two ways to do so)
-Either double click install.jar in the Product Directory 
-OR run in the terminal
	java -jar install.jar 
How To run appliation
Run ExpenseHandler.jar
-Either double click ExpenseHandler.jar in the Product Directory 
-OR run in the terminal
	java -jar ExpenseHandler.jar

If you want to delete the old database
-Delete ExpenseDatabase directory in the product directory

If you want to create a new database:
-Run installDb.jar
	-Either double click install.jar
	-OR run in the terminal
		java -jar install.jar 

Things to know while using the application
Date Input: YYYY-MM-DD
Spending type input: Monthly, Weekly, OTPurchase
Calculation methods are scheduled to run every 24-hours (86400000)  hence closing the application may risk in missed calculations (bills/incomes)


