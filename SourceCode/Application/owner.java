package application;

import java.util.*;
import java.sql.*;
import javajdbctut1.Javajdbc;


public class owner extends Manager
{



    static void update_manager(String Branch, String Name, String Sal, String A, String Gender) 
    {
        System.out.println("in update manager");
        try 
        {
            
            int Branch_Id= Integer.parseInt(Branch);
            int Age= Integer.parseInt(A);
            int Salary = Integer.parseInt(Sal);
            
            Connection con=Javajdbc.getConnection("oopsproject", "root", "dhruv");
            PreparedStatement st = con.prepareStatement("update Manager set Name = ?, Salary = ?, Age = ?, Gender =? where Branch_Id = ?");
            st.setString(1,Name);
            st.setInt(2,Salary);
            st.setInt(3,Age);
            st.setString(4,Gender);
            st.setInt(5,Branch_Id);
            
            
            int row = st.executeUpdate();
            System.out.println(row + "row/s updated in manager table");
            st.close();
        }   
        catch(Exception e)
        {
            System.out.println("Exception in update manager method");
        }
    }
    
    static void createnewbranch(String Branch, String Name, String Address)
    {
        System.out.println("in create branch");
        try 
        {
            
            int Branch_Id= Integer.parseInt(Branch);
            
            Connection con=Javajdbc.getConnection("oopsproject", "root", "dhruv");
            PreparedStatement st = con.prepareStatement("insert into Branch(Branch_Id, Name, Address) values(?,?,?)");
            st.setInt(1,Branch_Id);
            st.setString(2,Name);
            st.setString(3,Address);
            
            
            int row = st.executeUpdate();
            System.out.println(row + "row/s inserted in Branch table");
            st.close();
        }   
        catch(Exception e)
        {
            System.out.println("Exception in insert Branch method");
        }       
    }

   public static void takedownbranch(String Branch) 
    {
        System.out.println("in takedown branch");
        int Manager_Id=0;
        
        int Branch_Id= Integer.parseInt(Branch);
        
        try 
        {
            Connection con=Javajdbc.getConnection("oopsproject", "root", "dhruv");
            PreparedStatement st = con.prepareStatement("delete from branch where Branch_ID = ?");
            st.setInt(1,Branch_Id);
            int row = st.executeUpdate();
            System.out.println(row + "row/s deleted in takedownbranch branch table");
            st.close();
        }   
        catch(Exception e)
        {
            System.out.println("Exception in update takedownbranch branch delete method");
        }
        
        try
        {		
            Connection con = Javajdbc.getConnection("oopsproject","root","dhruv");
            PreparedStatement st = con.prepareStatement("select * from Manager where Branch_ID = ?");
            st.setInt(1,Branch_Id);
            ResultSet rs= st.executeQuery();
            
            while(rs.next()){
             //Display values
            System.out.print("ID: " + rs.getInt("Manager_ID"));
            Manager_Id = rs.getInt("Manager_ID");
            }
        } 
        catch (SQLException e) 
        {
            System.out.println("Exception in takedownbranch manager print get Manager_ID");
       } 
        
        try 
        {
            Connection con=Javajdbc.getConnection("oopsproject", "root", "dhruv");
            PreparedStatement st = con.prepareStatement("delete from manager where Branch_ID = ?");
            st.setInt(1,Branch_Id);
            int row = st.executeUpdate();
            System.out.println(row + "row/s deleted in takedownbranch manager table");
            st.close();
        }   
        catch(Exception e)
        {
            System.out.println("Exception in takedownbranch manager method");
        }
        
        try 
        {
            Connection con=Javajdbc.getConnection("oopsproject", "root", "dhruv");
            PreparedStatement st = con.prepareStatement("delete from employee where Branch_ID = ?");
            st.setInt(1,Branch_Id);
            int row = st.executeUpdate();
            System.out.println(row + "row/s deleted in takedownbranch employee table");
            st.close();
        }   
        catch(Exception e)
        {
            System.out.println("Exception in takedownbranch employee method");
        }
        
        Javajdbc.allbranchid.remove(Branch);
        Javajdbc.allmanagerid.remove(String.valueOf(Manager_Id));
    }

    
    
   public static void update_employeeby_owner(int ID, String Name, String Position, int Salary, int age, String Gender,String Branch_Id )
    {
        System.out.println("in update employeebyid");
        Manager.update_employee(ID, Name, Position, Salary, age, Gender,Branch_Id);
    }   

  


  public static  void show_one_employee_byowner(int ID,String Branch_Id)
    {
        System.out.println("in show one employee by owner");
        String id=String.valueOf(ID);
      Manager.show_one_employee(id,Branch_Id);
    }

   public static void show_allbyowner(String Branch_Id)
    {
                System.out.println("in show_all  by owner");

        Manager.show_all(Branch_Id);
    }




   public static void ShowIncome(String Branch_Id)
    {
        // show Income from Economy table
                System.out.println("in show  income by owner");

        Manager.showincome(Branch_Id);
    }

   public static void showExpenses(String Branch_Id)
    {
        // show Expenses from Economy table
                System.out.println("in show expenses by owner");

       Manager.showexpenses(Branch_Id);
    }

   public static void showProfit(String Branch_Id)
    {
        // show Profit from Economy table
                System.out.println("in show profit by owner");

      Manager.showprofit(Branch_Id);
    }


}