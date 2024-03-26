package javajdbctut1;


import java.sql.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import javajdbctut1.Javajdbc;


class Customer_connection_provider
{
    public static Connection get_customer_connection()
    {
        
        return ConnectionProvider.getConnection("oopsproject","root","dhruv");
    }
}

public class Customerclass 
{
    private int Customer_id;
    private String Name;
    private int age;
    private String Gender;
    private String mobile;
    private int points ;
    private String Address;

    public void set_customer_name(String name,int id)
    {
        
    }
    public void set_customer_age(int age,int id)
    {
        
    }
    public void set_customer_gender(String gender,int id)
    {
        
    }
    public void set_customer_mobile(String mobile,int id)
    {
        
    }
    public void set_points(int points,int id)
    {
        
    }
    public void set_address(String address,int id)
    {
        
    }
    public void get_customer_name(String name,int id)
    {
        
    }
    public void get_customer_age(int age,int id)
    {
        
    }
    public void get_customer_gender(String gender,int id)
    {
        
    }
    public void get_customer_mobile(String mobile,int id)
    {
        
    }
    public void get_points(int points,int id)
    {
        
    }
    public void get_address(String address,int id)
    {
        
    }
    
    public static void main(String args[])
    {
      Connection con= Customer_connection_provider.get_customer_connection();
      
                   System.out.println(con);
    }
}

