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


public class Manager extends Employee
{

    Scanner input=new Scanner();


    void insert_employee(int ID, String Name, String Position, int Salary, int age, String Gender) 
    {
        // Add Employee Controller CLass

        // int id = input.nextInt();
        // String name = input.String();
        // String position = input.String();
        // int Salary = input.nextInt();
        // int Age = input.nextInt();
        // String Gender=input.String();

        // insertEmployee Function fron absrtract class
        st.executeUpdate("insert into employee values(%d,%s,%s,%d,%d,%s);",ID,Name,Position,Salary,Gender);
    }

    void delete_employee(int ID) 
    {
        // Delete Employee Controller class

        // int id = input.nextInt();
        // String query = input.nextString();
        // Statement st = con.Statement(query);


        st.executeUpdate("Delete from employee where employee_id= %d",ID);
    }

    void update_employee(int ID, String Name, String Position, int Salary, int age, String Gender)
    {
        // Update Employee Controller class

        // Statement st = con.Statement(query);
        // Update Employee Class
        st.executeUpdate("Update Employee set Name= %s, Position = %s, Salary = %d, Age = %d, Gender = %s where Employee_Id = %d",Name,Position,Salary,Age,Gender,ID);
    }

    void show_one_employee(int ID)
    {
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();)
                ResultSet rs = stmt.executeQuery("Select * from Employee where EMployee_Id= %d;",ID);
             {		      
                while(rs.next())
                {
                    //Display values
                    System.out.print("ID: " + rs.getInt("Employee_ID"));
                    System.out.print(", NAme: " + rs.getString("Name"));
                    System.out.print(", Position: " + rs.getString("Position"));
                    System.out.print(", Salary: " + rs.getInt("Salary"));
                    System.out.print(", Age: " + rs.getInt("age"));
                    System.out.print(", Gender: " + rs.getString("Gender"));
                }
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            } 
    }

    void show_all()
    {
        // show All Employee Controller CLass

        // Call Select Employee Class

        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();)
                ResultSet rs = stmt.executeQuery("Select * from Employee;");
             {		      
                while(rs.next())
                {
                    //Display values
                    System.out.print("ID: " + rs.getInt("Employee_ID"));
                    System.out.print(", NAme: " + rs.getString("Name"));
                    System.out.print(", Position: " + rs.getString("Position"));
                    System.out.print(", Salary: " + rs.getInt("Salary"));
                    System.out.print(", Age: " + rs.getInt("age"));
                    System.out.print(", Gender: " + rs.getString("Gender"));
                }
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            } 
    }


    void ShowIncome()
    {
        // show Income from Economy table

        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();)
                ResultSet rs = stmt.executeQuery("Select Income from Employee;");
             {		      
                while(rs.next())
                {
                    //Display values
                    System.out.print("Income: " + rs.getInt("Income"));
                }
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            } 
    }

    void showExpenses()
    {
        // show Expenses from Economy table

        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();)
                ResultSet rs = stmt.executeQuery("Select Expenses from Employee;");
             {		      
                while(rs.next())
                {
                    //Display values
                    System.out.print("Expenses: " + rs.getInt("Expenses"));
                }
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            } 
    }

    void showProfit()
    {
        // show Profit from Economy table

        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();)
                ResultSet rs = stmt.executeQuery("Select Profit from Employee;");
             {		      
                while(rs.next())
                {
                    //Display values
                    System.out.print("Profit: " + rs.getInt("Profit"));
                }
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            } 
    }

    void showPaymentArchives()
    {
        // call select PaymentArchives table
        // Payment Archives Controller class

        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();)
                ResultSet rs = stmt.executeQuery("Select * from Payment_Archives;");
             {		      
                while(rs.next())
                {
                    //Display values
                    System.out.print("Amount: " + rs.getInt("Amount"));
                    System.out.print(", Payment Method: " + rs.getInt("Payment_Method"));
                }
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            } 
    }
}
