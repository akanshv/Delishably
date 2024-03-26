import java.util.*;
import java.sql.*;

// abstract class JDBCConnection
// {
//     public static final String DB_URL = "jdbc:mysql://localhost/OOPSProject";
//     public static final String USER = "root";
//     public static final String PASS = "m@sterS4M4";

//     //Customer

//     void viewCustomer();
//     void insertCustomer();
//     void deleteCustomer();
//     void updateCustomer();

//     //PaymentArchives

//     void viewPaymentArchives();
//     void insertPaymentArchives();
//     void deletePaymentArchives();
//     void updatePaymentArchives();
    
//     //Employee

//     void viewEmployee();
//     void insertEmployee();
//     void deleteEmployee();
//     void updateEmployee();

//     //Branch

//     void viewBranch();
//     void insertBranch();
//     void deleteBranch();
//     void updateBranch();

//     //Economy

//     void viewEconomy();
//     void insertEconomy();
//     void deleteEconomy();
//     void updateEconomy();




// Insert
//  // Open a connection
//  try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//  Statement stmt = conn.createStatement();
// {		      
//      // Execute a query
//      System.out.println("Inserting records into the table...");          
//      String sql = "INSERT INTO Registration VALUES (100, 'Zara', 'Ali', 18)";
//      stmt.executeUpdate(sql);
//      sql = "INSERT INTO Registration VALUES (101, 'Mahnaz', 'Fatma', 25)";
//      stmt.executeUpdate(sql);
//      sql = "INSERT INTO Registration VALUES (102, 'Zaid', 'Khan', 30)";
//      stmt.executeUpdate(sql);
//      sql = "INSERT INTO Registration VALUES(103, 'Sumit', 'Mittal', 28)";
//      stmt.executeUpdate(sql);
//      System.out.println("Inserted records into the table...");   	  
// } 
//catch (SQLException e) 
//{
//  e.printStackTrace();
// } 

//Select 
// try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//          Statement stmt = conn.createStatement();)
//          ResultSet rs = stmt.executeQuery(QUERY);
//       ) {		      
//          while(rs.next()){
//             //Display values
//             System.out.print("ID: " + rs.getInt("id"));
//             System.out.print(", Age: " + rs.getInt("age"));
//             System.out.print(", First: " + rs.getString("first"));
//             System.out.println(", Last: " + rs.getString("last"));
//          }
//       } catch (SQLException e) {
//          e.printStackTrace();
//       } 


//Update
// try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//     Statement stmt = conn.createStatement();
//       ) 
// {		      
//     String sql = "UPDATE Registration " +"SET age = 30 WHERE id in (100, 101)";
//     stmt.executeUpdate(sql);
//     ResultSet rs = stmt.executeQuery(QUERY);
//     while(rs.next())
//     {
//         //Display values
//         System.out.print("ID: " + rs.getInt("id"));
//         System.out.print(", Age: " + rs.getInt("age"));
//         System.out.print(", First: " + rs.getString("first"));
//         System.out.println(", Last: " + rs.getString("last"));
//     }
//     rs.close();
// } 
// catch (SQLException e) 
// {
//     e.printStackTrace();
// } 

//Delete
// try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);Statement stmt = conn.createStatement();) 
//     {		      
//         String sql = "DELETE FROM Registration " + "WHERE id = 101";
//         stmt.executeUpdate(sql);
//         ResultSet rs = stmt.executeQuery(QUERY);
//         while(rs.next())
//         {
//             //Display values
//             System.out.print("ID: " + rs.getInt("id"));
//             System.out.print(", Age: " + rs.getInt("age"));
//             System.out.print(", First: " + rs.getString("first"));
//             System.out.println(", Last: " + rs.getString("last"));
//         }
//         rs.close();
//     }
// catch (SQLException e) 
// {
//     e.printStackTrace();
// } 

class Employee extends JDBC_Connection
{
    Scanner input= new Scanner();

   // Functions Required :

   void AddCustomer(int Number,String Name,int Age, String Gender, int amount)
   {
        // GetFinal Bill Controller Class

        // Ask Customer Details
        // Bill Method : 
        //          Checks if Customer is a existing member using the Phone Number
        //          If already a member then give discount based on points and reset the points
        //          If not a member then add the values in customr table
        //          Returns the final bill after calculating points
        //          Returns details of every item
        //          Update Economy Table


        // These details will come from FX Class
        // System.out.println("\n\nEnter details of Customer :\n");
        // String Name = input.nextLine();
        // String Gender = input.nextLine();
        // int Age= input.nexInt();
        // long Number=  input.nextInt();
        // insert into Customer values(%s,Gender,Age,Number)

        int point=amount/100;

        //insertCustomer(Number,Name,Age,Gender,point);
        try()
        {
            stmt.executeUpdate("insert into Cutomer values(%d,%s,%d,%s,%d)",Number,Name,Age,Gender,point);
        }
        catch(SQLException e)
        {
            stmt.executeUpdate("Update Customer set point = %d where Phone = %d",Number,point);
        }

   }

   int Amount_Finalizer(int Phone)
   {
        // TAkes amount from Final Bill COntroller CLass and returns Final amount to GetFinal Bill Contoller

        // Searches Customer in Customer Table and stores point and gives discount;

        int point;

        rs = pst.executeQuery("select Points from Customer where Phone = %d;",Phone);

        if(rs.next())
        {
            point = rs.getInt(1);
        }

        int amount= amount - point;
        point=amount/100;

        stmt.executeUpdate("Upadte Customer set Point=%d where Phone=%d;",point,Phone);

        return amount;
    }

   void TakePayment(int amount, String Payment_Method)
   {
        // Bill Controller Class

        // Payment Method :
        //          Takes the total amount and Payment type
        //          Updates the value in Economy Table
        //          Records entry in Payment_Archoives table 

        // Payment Method and Payment will come from FX Class


        // Call insert Payment Arch9ives from Abstract Class
        stmt.executeUpdate("insert into Payment_Archives values(%d,'%s')",amount,Payment_Method);

        int expenses=amount*0.5;
        int profit=amount-expenses;
        insertEconomy(amount,Payment_Method);


        // Call inserteconomy Function from abstract class
        stmt.executeUpdate("Updayte Economy set Income = Income+ %d, Expenses = Expenses + %d, Profit = Profit + %d;",amount,expenses,profit);

   }


   // Define Abstract Method of JDBC Connection :

}