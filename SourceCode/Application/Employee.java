package application;

import javajdbctut1.Javajdbc;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javajdbctut1.Javajdbc.alltablevaluesQuery;


class Employee extends jdbcconnection {

      //composition in employee class
    //composition and overriding called in addcustomer
    static ArrayList<Object> arr = new ArrayList<>();
    static  Javajdbc obj;
    @Override
    public Connection getConnection(String database, String user, String password) {
        Connection con = Javajdbc.getConnection(database, user, password);
        return con;
    }
//    Scanner input= new Scanner();
//
//   // Functions Required :
//

    static void holdcustomerdetails(String name, String Gender, String age, String ph) {
        ArrayList<Object> arrtemp = new ArrayList<>();
        int integerage = Integer.parseInt(age);
        arrtemp.add(name);
        arrtemp.add(Gender);
        arrtemp.add(integerage);
        arrtemp.add(ph);
        System.out.println("holdcustomer");
        for (int i = 0; i < 4; i++) {
            System.out.println(arrtemp.get(i));
        }
        for (int i = 0; i < 4; i++) {
            arr.add(arrtemp.get(i));
        }

    }
    static void insertcustomer(Connection con,String name,String gender,int age,String ph,int points)  
    {
        System.out.println(con);
        System.out.println(name);
        System.out.println(gender);
        System.out.println(age);
        System.out.println(ph);
        System.out.println(points);
        try {
            PreparedStatement st = con.prepareStatement("insert into customer values(?,?,?,?,?)");
            st.setString(1, ph);
            st.setString(2, name);
            st.setInt(3,age);
            st.setString(4,gender);
            st.setInt(5,points);
            
              int row = st.executeUpdate();
            System.out.println(row + "row/s inserted in customer table");
            st.close();
          
        } catch (SQLException ex) {
            System.out.println("Exception in insertcustomer");
        }
    }

    static void updatepoints(Connection con,String ph,int points)
    {
        
        try { 
            PreparedStatement st = con.prepareStatement("update customer set points = ? where mobile = ?");
            st.setInt(1, points);
            st.setString(2,ph);
            int x=st.executeUpdate();
            System.out.println("point upadated successfully");
            st.close();
        } catch (SQLException ex) {
            System.out.println("Exception in updating points..");
        }
    }
    static void AddCustomer(String amount)   {
        
        System.out.println("addcustomer");
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
        int amt = Integer.parseInt(amount);
        String name = (String) arr.get(0);
        String gender = (String) arr.get(1);
        int age = (int) arr.get(2);
        String ph = (String) arr.get(3);
        
        System.out.println("performing method overriding and compostion in add customer");
        Employee emp=new Employee();
      Connection con= emp.getConnection("oopsproject", "root", "dhruv");
        Statement st = obj.get_a_fresh_statement(con);
        ResultSet tabledetails=null;
        try {
             tabledetails = st.executeQuery(Javajdbc.alltablevaluesQuery("customer"));
        } catch (SQLException ex) {
           System.out.println("exception in addcustomer resutlset");
        }
      boolean res= Javajdbc.searchcustomerdetails(tabledetails, "mobile", ph);
      
        try {
            st.close();
        } catch (SQLException ex) {
             System.out.println("Exception in closing statement in add custome method");
        }
      if(!res)
      {
          int points= (amt*5)/100;
          Employee.insertcustomer(con,name,gender,age,ph,points);
          
      }
      else
      {
          int points = (amt* 5)/100;
//          System.out.println("amt"+amt);
//                  System.out.println("points"+points);
          Employee.updatepoints(con, ph, points);
      }
        arr.removeAll(arr);
        //System.out.println(amt);

    }
//
  static int Amount_Finalizer(int amount)
   {
       System.out.println("in amount finalizer method");
        // TAkes amount from Final Bill COntroller CLass and returns Final amount to GetFinal Bill Contoller

        // Searches Customer in Customer Table and stores point and gives discount;

        int point=0;
        Connection con=Javajdbc.getConnection("oopsproject", "root", "dhruv");
        Statement st = Javajdbc.get_a_fresh_statement(con);
        try {
            ResultSet  rs = st.executeQuery(Javajdbc.alltablevaluesQuery("customer"));
            String Phone=(String)arr.get(3);
            int row_no=Javajdbc.get_particular_row_number_basedon_id(Phone, rs);
            int x=0;
            while(rs.next())
            {
                if(x==row_no)
                {
                point=rs.getInt(5);
                    break;
                }
                x++;
            }
        } catch (SQLException ex) {
            System.out.println("Exception in amount finalizer");
        }

       

         amount= amount - point;
       
        System.out.println("point"+point);
      System.out.println("amount finalizer "+ amount);

        return amount;
    }

}
