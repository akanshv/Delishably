package application;

import java.util.*;
import java.sql.*;
import javajdbctut1.Javajdbc;

public class Manager extends Employee {
    
    public static int offset=0;
    static void insertemployee(int ID, String Name, String Position, int Salary, int age, String Gender,String branch_id) {
        Connection con = Javajdbc.getConnection("oopsproject", "root", "dhruv");
        System.out.println("In insertemployee");
        System.out.println(ID);
        System.out.println(con);
        System.out.println(Name);
        System.out.println(Position);
        System.out.println(Salary);
        System.out.println(age);
        System.out.println(Gender);
        System.out.println(branch_id);
        try {
            PreparedStatement st = con.prepareStatement("insert into employee values(?,?,?,?,?,?,?)");
            st.setInt(1, ID);
            st.setString(2, Name);
            st.setInt(3, age);
            st.setString(4, Position);
            st.setInt(5, Salary);
            st.setString(6, Gender);
            int branchid=Integer.parseInt(branch_id);
            st.setInt(7, branchid);
            int row = st.executeUpdate();
            System.out.println(row + "row/s inserted in employee table");
            st.close();

        } catch (SQLException ex) {
            System.out.println("Exception in insertemployee method");
        }
    }

    static void deleteemployee(int ID,String branch_id) {
        // Delete Employee Controller class

        Connection con = Javajdbc.getConnection("oopsproject", "root", "dhruv");
        System.out.println("In deleteemployee");
        System.out.println(ID);

        try {
            PreparedStatement st = con.prepareStatement("Delete from employee where employee_id= ? and Branch_ID=?");
            st.setInt(1, ID);
            int branchid=Integer.parseInt(branch_id);
            st.setInt(2,branchid);
            int row = st.executeUpdate();
            System.out.println(row + "row/s deleted in employee table");
            st.close();

        } catch (SQLException ex) {
            System.out.println("Exception in deleteemployee method");
        }
    }

    static void update_employee(int ID, String Name, String Position, int Salary, int age, String Gender,String branch_id) {
        // Update Employee Controller class

        Connection con = Javajdbc.getConnection("oopsproject", "root", "dhruv");
        System.out.println("In updateemployee");
        System.out.println(ID);
        System.out.println(con);
        System.out.println(Name);
        System.out.println(Position);
        System.out.println(Salary);
        System.out.println(age);
        System.out.println(Gender);
        System.out.println(branch_id);
        try {
            PreparedStatement st = con.prepareStatement("Update Employee set Name= ?,Position = ?, Salary = ?, Age = ?, Gender = ?, Branch_Id=? where Employee_Id = ?");
            st.setString(1, Name);
            st.setString(2, Position);
            st.setInt(3, Salary);
            st.setInt(4, age);
            st.setString(5, Gender);
            int branchid=Integer.parseInt(branch_id);
            st.setInt(6,branchid);
            st.setInt(7, ID);
            int row = st.executeUpdate();
            System.out.println(row + "row/s updated in employee table");
            st.close();

        } catch (SQLException ex) {
            System.out.println("Exception in updateemployee method");
        }
    }

    static void show_one_employee(String id,String branch_id) 
    {
        System.out.println("Inside showoneemployee method");
        try {
            int branchid=Integer.parseInt(branch_id);
            int ID=Integer.parseInt(id);
            
            Connection con = Javajdbc.getConnection("oopsproject", "root", "dhruv");
            PreparedStatement stmt = con.prepareStatement("select * from Employee where Employee_ID=? and Branch_ID=?;");
            stmt.setInt(1, ID);
            stmt.setInt(2,branchid);
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                //Display values
                System.out.print("Employee ID: " + rs.getInt("Employee_ID"));
                System.out.print(", Name: " + rs.getString("Name"));
                System.out.print(", Position: " + rs.getString("Position"));
                System.out.print(", Salary: " + rs.getInt("Salary"));
                System.out.print(", Age: " + rs.getInt("Age"));
                System.out.print(", Gender: " + rs.getString("Gender"));
                System.out.print(", Branch ID" + rs.getString("Branch_ID"));
                System.out.println("");
            }
        } catch (SQLException e) {
            System.out.println("Exception in showoneemployee method");
        }
    }
//

    static void show_all(String branch_id) 
    {  
        // Employeesearch Controller Class

        // Call Select Employee Class
        System.out.println("Inside showoallmployee method");
        try {
            Connection con = Javajdbc.getConnection("oopsproject", "root", "dhruv");
            PreparedStatement stmt = con.prepareStatement("select * from employee where Branch_Id=? limit 5 offset ?");
            int branchid=Integer.parseInt(branch_id);
            stmt.setInt(1,branchid);
            stmt.setInt(2,offset);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                //Display values
                System.out.print("Employee ID: " + rs.getInt("Employee_ID"));
                System.out.print(", Name: " + rs.getString("Name"));
                System.out.print(", Position: " + rs.getString("Position"));
                System.out.print(", Salary: " + rs.getInt("Salary"));
                System.out.print(", Age: " + rs.getInt("age"));
                System.out.print(", Gender: " + rs.getString("Gender"));
                System.out.print(", Branch ID: " + rs.getString("Branch_ID"));
                System.out.println(" ");
                offset++;
            }
        } catch (SQLException e) {
            System.out.println("Exception in showall method");
        }
    }
    
    static void showalldetailspartialstring(String namejd ,String branch_id)
    {
          System.out.println("Inside showoall by partial name method");
        try {
            Connection con = Javajdbc.getConnection("oopsproject", "root", "dhruv");
            PreparedStatement stmt = con.prepareStatement("select * from employee where Branch_Id=? and Name like ?");
            int branchid=Integer.parseInt(branch_id);
            String name="%"+namejd+"%";
            stmt.setInt(1,branchid);
            stmt.setString(2,name);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                //Display values
                System.out.print("Employee ID: " + rs.getInt("Employee_ID"));
                System.out.print(", Name: " + rs.getString("Name"));
                System.out.print(", Position: " + rs.getString("Position"));
                System.out.print(", Salary: " + rs.getInt("Salary"));
                System.out.print(", Age: " + rs.getInt("age"));
                System.out.print(", Gender: " + rs.getString("Gender"));
                System.out.print(", Branch ID: " + rs.getString("Branch_ID"));
                System.out.println(" ");
            }
        } catch (SQLException e) {
            System.out.println("Exception in showall by partial name method");
        }
    }
    
        static void showallgreaterthan(String Sal ,String branch_id)
    {
          System.out.println("Inside showoall greater than method");
        try {
            Connection con = Javajdbc.getConnection("oopsproject", "root", "dhruv");
            PreparedStatement stmt = con.prepareStatement("select * from employee where Branch_Id=? and Salary > ?");
            int branchid=Integer.parseInt(branch_id);
            int Salary= Integer.parseInt(Sal);
            stmt.setInt(1,branchid);
            stmt.setInt(2,Salary);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                //Display values
                System.out.print("Employee ID: " + rs.getInt("Employee_ID"));
                System.out.print(", Name: " + rs.getString("Name"));
                System.out.print(", Position: " + rs.getString("Position"));
                System.out.print(", Salary: " + rs.getInt("Salary"));
                System.out.print(", Age: " + rs.getInt("age"));
                System.out.print(", Gender: " + rs.getString("Gender"));
                System.out.print(", Branch ID: " + rs.getString("Branch_ID"));
                System.out.println(" ");
            }
        } catch (SQLException e) {
            System.out.println("Exception in showall greater than method");
        }
    }

    static void showincome(String branch_id) {
        // show Income from Economy table

        System.out.println("Inside showincome method");
        try {
            Connection con = Javajdbc.getConnection("oopsproject", "root", "dhruv");
            PreparedStatement stmt = con.prepareStatement("select income from economy where Branch_Id=?");
            int branchid=Integer.parseInt(branch_id);
            stmt.setInt(1,branchid);
            ResultSet rs = stmt.executeQuery();
            {
                while (rs.next()) {
                    System.out.print("Income: " + rs.getInt("Income"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Exception in showincome method");
        }
    }

    static void showexpenses(String branch_id) {
        // show Expenses from Economy table

        System.out.println("Inside showexpenses method");
        try {
            Connection con = Javajdbc.getConnection("oopsproject", "root", "dhruv");
            PreparedStatement stmt = con.prepareStatement("select expenses from economy where Branch_Id=?");
            int branchid=Integer.parseInt(branch_id);
            stmt.setInt(1,branchid);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.print("Expenses: " + rs.getInt("Expenses"));
            }
        } catch (SQLException e) {
            System.out.println("Exception in showexpenses method");
        }
    }

    static void showprofit(String branch_id) {
        // show Profit from Economy table

        System.out.println("Inside showprofit method");
        try {
            Connection con = Javajdbc.getConnection("oopsproject", "root", "dhruv");
            PreparedStatement stmt = con.prepareStatement("select profit from economy where Branch_Id=?");
               int branchid=Integer.parseInt(branch_id);
            stmt.setInt(1,branchid);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.print("Profit: " + rs.getInt("Profit"));
            }
        } catch (SQLException e) {
            System.out.println("Exception in showprofit method");
        }
    }


}
