package javajdbctut1;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;
import java.sql.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

class ConnectionProvider {

    private static Connection con;

    public static Connection getConnection(String database, String user, String password) {
        try {
            if (con == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/" + database, user, password);
//here sonoo is database name, root is username and password 
                System.out.println("connection created....");

            }
        } catch (Exception e) {
            System.out.println("connection not made....");
        }
        return con;
    }
}

public class Javajdbc {

    public static String holdbranch=null;
    public static String holdbranchidinowner=null;
    public static ArrayList<String> allmanagerid=new ArrayList<>();
    public static ArrayList<String>allbranchid = new ArrayList<>();
    
  
    public static void holdbranchdetails(String detail)
    {
        holdbranch=detail;
    }
    public static String alltablevaluesQuery(String tablename) {
        return ("select * from " + tablename);
    }

    public static Connection getConnection(String database, String user, String password) {
        return ConnectionProvider.getConnection(database, user, password);
    }

    public static Statement get_a_fresh_statement(Connection con) {
        Statement st = null;
        try {
            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (Exception e) {
            System.out.println("Statement object is not created");
        }
        return st;
    }

    public static int totalcolumnscountQuery(ResultSet rs) {
        int column_count = 0;
        try {
            //Retrieving the ResultSetMetaData object
            ResultSetMetaData rsmd = rs.getMetaData();
//getting the column type
            column_count = rsmd.getColumnCount();
        } catch (Exception e) {
            System.out.println("totalcolumncountQuery is having an exception....");
        }
        return column_count;
    }

    public static void printparticularrow(ResultSet tabledetails, int index_of_row_to_be_printed) {
        try {
            ArrayList<String> arr = Javajdbc.a_particular_rowtoarray(tabledetails, index_of_row_to_be_printed);
            for (int i = 0; i < arr.size(); i++) {
                System.out.print(arr.get(i) + " ");
            }
        } catch (Exception e) {
            System.out.println("printparticular row is having an exception...");
        }
    }
    public static int sumparticularrow( String columnname) {
        Connection con=Javajdbc.getConnection("oopsproject","root","dhruv");
        Statement st=Javajdbc.get_a_fresh_statement(con);
        ResultSet rs=null;
        String sql="select sum("+columnname+") from economy";
        System.out.println(sql);
        try {
             rs= st.executeQuery(sql);
             rs.next();
             System.out.println(rs.getString(1));
             return (Integer.parseInt(rs.getString(1)));
        } catch (SQLException ex) {
            System.out.println("Excpetion in sumparticular row..");
        }
        return 0;
    }

    
    public static int sumparticularrowbybranch(String columnname,String branchid)
    {
         Connection con=Javajdbc.getConnection("oopsproject","root","dhruv");
        Statement st=Javajdbc.get_a_fresh_statement(con);
        ResultSet rs=null;
        String sql="select sum("+columnname+") from economy where Branch_ID = "+Integer.parseInt(branchid);
        System.out.println(sql);
        try {
             rs= st.executeQuery(sql);
             rs.next();
             System.out.println(rs.getString(1));
             return (Integer.parseInt(rs.getString(1)));
        } catch (SQLException ex) {
            System.out.println("Excpetion in sumparticular row..");
        }
        return 0;
    }
    public static int get_column_index(ResultSet rs, String attribute_name) {
        int column_count = 0;
        try {
            ResultSetMetaData rsmetadata = rs.getMetaData();
            column_count = Javajdbc.columncount(rs);
            for (int i = 1; i <= column_count; i++) {
                if (attribute_name.equals(rsmetadata.getColumnName(i))) {
                    return i;
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in get_column index...");
        }

        return 0;
    }

    public static ArrayList<String> get_arrayof_column_names(ResultSet rs) {
        int column_count = 0;
        ArrayList<String> arr = null;
        try {
            ResultSetMetaData rsmetadata = rs.getMetaData();
            column_count = Javajdbc.columncount(rs);
            for (int i = 1; i <= column_count; i++) {
                arr.add(rsmetadata.getColumnName(i));
            }
        } catch (Exception e) {
            System.out.println("Exception in get_arrayof_column_names...");
        }
        return arr;
    }

    public static ArrayList<String> a_particular_rowtoarray(ResultSet rs, int index_of_row) throws SQLException {
        ArrayList<String> arr = new ArrayList<>();
        int no_of_columns = Javajdbc.totalcolumnscountQuery(rs);
        int count = 1;
        while (rs.next()) {
            if (count == index_of_row) {
                for (int i = 1; i <= no_of_columns; i++) {
                    arr.add(rs.getString(i));
                }
                break;
            } else {
                count++;
            }

        }
        return arr;
    }

    public static int count_number_of_rows(Connection con, String database, String table_name) {
        int x = 0;
        try {
            Statement st2 = con.createStatement();

            String query = "select count(*) from " + database + "." + table_name;
            // System.out.println(query);
            ResultSet rs = st2.executeQuery(query);
            rs.next();
            x = Integer.parseInt(rs.getString(1));
            rs.close();
            st2.close();
        } catch (Exception e) {
            System.out.println("Exception in count_number_of_rows....");
        }
        return x;
    }

    public static void printparticularcolumn(int columnindex, ResultSet rs) {
        try {
            while (rs.next()) {
                System.out.println(rs.getString(columnindex));
            }
        } catch (Exception e) {
            System.out.println("Exception in printparituclarcolumn ");
        }

    }

    public static ArrayList<String> particularcolumntoarray(ResultSet tabledetails, int columnindex) {
        ArrayList<String> arr = new ArrayList<>();
        try {
            while (tabledetails.next()) {
                arr.add(tabledetails.getString(columnindex));
                //System.out.println(tabledetails.getString(columnindex));
            }
        } catch (Exception e) {
            System.out.println("Exception in particularcolumntoarray");
        }
        return arr;
    }

    public static int columncount(ResultSet rs) throws SQLException {
        ResultSetMetaData resultdata = rs.getMetaData();

        return resultdata.getColumnCount();
    }

    public static int get_particular_row_number_basedon_id(String id, ResultSet rs) {
        int x = 0;
        try {
            while (rs.next()) {
                x++;
                if (rs.getString(1).equals(id)) {
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("exception in get_particular_row_number_basedon_id...");
        }
        return x;
    }

    public static boolean searchemployee(ResultSet rs, String searchcategory, String searchvalue) {
        boolean flag = false;
        int colindex = 0;
        try {
            int columncount = Javajdbc.columncount(rs);
            ResultSetMetaData resultmetadata = rs.getMetaData();

            for (int i = 1; i <= columncount; i++) {
                if (resultmetadata.getColumnName(i).equals(searchcategory)) {
                    colindex = i;
                }
            }

            while (rs.next()) {
                if ((searchvalue).equals(rs.getString(colindex))) {
                    flag = true;
                }

            }

        } catch (Exception e) {
            System.out.println("...");
        }
        return flag;
    }

    public static ArrayList<String> get_employees_with_same_category(ResultSet rs, String searchcategory, String searchvalue) {
        int colindex = 0;
        ArrayList<String> arr = new ArrayList<>();
        try {
            int columncount = Javajdbc.columncount(rs);

            ResultSetMetaData resultmetadata = rs.getMetaData();

            for (int i = 1; i <= columncount; i++) {
                if (resultmetadata.getColumnName(i).equals(searchcategory)) {
                    colindex = i;
                }
            }

            while (rs.next()) {
                if ((searchvalue).equals(rs.getString(colindex))) {
                    arr.add(rs.getString(1));
                }

            }

        } catch (Exception e) {
            System.out.println("caught exception in javajdbc get_employees_with_same_category");
        }
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
        return arr;
    }

    public static void insertrow(String id, ResultSet tabledetails, Connection con, String First_name, String Last_name, String Phone_no, String job_id, int salary, String manager_id, String department_id) {
        boolean res = searchemployee(tabledetails, "EMPLOYEE_ID", id);
        if (res == true) {
            System.out.println("Employee is already present");
            return;
        }
        try {
            PreparedStatement st = con.prepareStatement("insert into employees values(?,?,?,?,?,?,?,?)");
            st.setString(1, id);

            st.setString(2, First_name);
            st.setString(3, Last_name);
            st.setString(4, Phone_no);
            st.setString(5, job_id);
            st.setInt(6, salary);
            st.setString(7, manager_id);
            st.setString(8, department_id);
            int row = st.executeUpdate();
            System.out.println(row + "rows affected");
        } catch (Exception e) {
            System.out.println("Primary key violation...");
            System.out.println("Please enter a different id...");
            return;
        }
        System.out.println("Row inserted successfully...");
    }

    public static boolean searchcustomerdetails(ResultSet rs, String searchcategory, String searchvalue) {
        boolean flag = false;
        int colindex = 0;
        try {
            int columncount = Javajdbc.columncount(rs);
            ResultSetMetaData resultmetadata = rs.getMetaData();

            for (int i = 1; i <= columncount; i++) {
                if (resultmetadata.getColumnName(i).equals(searchcategory)) {
                    colindex = i;
                    System.out.println("in searchcustomerdetails function i  " + i);
                }
            }

            while (rs.next()) {
                if ((searchvalue).equals(rs.getString(colindex))) {
                    System.out.println(rs.getString(colindex));
                    flag = true;
                }

            }

        } catch (Exception e) {
            System.out.println("...");
        }
        return flag;
    }

    public static void insertcustomerdetails(String name, String gender, int age, String phone_num, Connection con) throws SQLException {

//        boolean flag= Javajdbc.searchcustomerdetails(rs, "phoneNumber",valueOf(phone_num));
//        if(flag)
//        {
//            System.out.print("phone number is already present");
//            return;
//        }
        try {
            PreparedStatement st = con.prepareStatement("insert into customerdetails values(?,?,?,?)");
            st.setString(1, name);
            st.setString(2, gender);
            st.setInt(3, age);
            st.setString(4, phone_num);

            int row = st.executeUpdate();
            System.out.println(row + "rows affected");
            st.close();
        } catch (Exception e) {
            System.out.println("exception in insertcustomerdetails...");
            return;
        }
    }

    public static void updaterow(String id, ResultSet rs, Connection con, String First_name, String Last_name, String Phone_no, String job_id, int salary, String manager_id, String department_id) {
        try {
            PreparedStatement st = con.prepareStatement("update employees set first_name = ? , last_name = ? , phone_number = ? , job_id = ? , salary = ? , manager_id = ? , department_id = ?  where employee_id = ?");
            st.setString(1, First_name);
            st.setString(2, Last_name);
            st.setString(3, Phone_no);
            st.setString(4, job_id);
            st.setInt(5, salary);
            st.setString(6, manager_id);
            st.setString(7, department_id);
            st.setString(8, id);
            int x = st.executeUpdate();
            System.out.println(x + "rows affected");

        } catch (Exception e) {
            System.out.println("Row was not updated...");
            return;
        }
        System.out.println("Row updated successfully...");
    }

    public static void deleterow_by_id(String id, Connection con) {

        try {
            PreparedStatement st = con.prepareStatement("delete from employees where employee_id=?");
            st.setString(1, id);
            int val = st.executeUpdate();
            System.out.println("Row deleted successfully...");
            System.out.println(val + "rows affected");
        } catch (Exception e) {
            System.out.println("This id is not present in the database...");
        }

    }

    public static void seteconomy(int amount,String branch) {
        System.out.println("in economy table");
        try {
            Random random=new Random();
            int x=random.nextInt(20);
            int expense = (x+15) * amount / 100;
            int profit = amount - expense;
            Connection con = Javajdbc.getConnection("oopsproject", "root", "dhruv");
            // System.out.println(con);
            int branchid=Integer.parseInt(branch);
            System.out.println("branch:"+branch);
            PreparedStatement stmt = con.prepareStatement("insert into economy values(?,?,?,?)");
            stmt.setInt(1, amount);
            stmt.setInt(2, expense);
            stmt.setInt(3, profit);
            stmt.setInt(4,branchid);
            int i = stmt.executeUpdate();
            System.out.println(i + "rows inserted in economytable");

        } catch (Exception e) {
            System.out.println("Exception in economy");
        }
    }

    public static int getdetails(String fieldname) {
        int x = 0;
        try {
            Connection con = Javajdbc.getConnection("oopsproject", "root", "dhruv");
            PreparedStatement st =con.prepareStatement("select sum(" + fieldname + ") from economy");
          //  st.setInt(1, branch_id);
            ResultSet rs = st.executeQuery();
            rs.next();
            x = rs.getInt(1);
           // System.out.println(x);

        } catch (Exception e) {
            System.out.println("Exception in javajdbc getdetails");
        }
        return x;
    }
    
    public static int getnoofmales(String fieldname,String gender) {
        int x = 0;
        try {
            Connection con = Javajdbc.getConnection("oopsproject", "root", "dhruv");
            PreparedStatement st =con.prepareStatement("select count(" + fieldname + ") from customer where Gender = ?");
            st.setString(1,gender);
          //  st.setInt(1, branch_id);
            ResultSet rs = st.executeQuery();
            rs.next();
            x = rs.getInt(1);
           // System.out.println(x);

        } catch (Exception e) {
            System.out.println("Exception in javajdbc getdetails");
        }
        return x;
    }


   public static void createtable(String tablename)
   {
       System.out.println("in create table javajdbc");
        Connection con=Javajdbc.getConnection("oopsproject","root","dhruv");
        try {
           Statement st=Javajdbc.get_a_fresh_statement(con);
            String sql = "CREATE TABLE economy " +
                   "(Income int not NULL, " +
                   " Expenses int not NULL, " + 
                   " Profit int not NULL, " + 
                   " Branch_Id int not NULL) " ; 
                   
            int x=st.executeUpdate(sql);
            System.out.println(x+"row/s affected");
        } catch (SQLException ex) {
            System.out.println("exception in create table in javajdbc");
        }
   }
        public static void csvtodatabase() 
        {
            Connection con=null;
            BufferedReader lineReader=null;
            PreparedStatement st=null;
        try {
            String filepath="D:\\desktop,downloads,documents\\Documents\\NetBeansProjects\\Javaproject\\src\\application\\economycsvfile.csv";
            int batchsize=16;
            con=Javajdbc.getConnection("oopsproject", "root", "dhruv");
            con.setAutoCommit(false);
            String sql="insert into economy(Income , Expenses , Profit , Branch_ID) values(? ,? , ? ,?)";
             st= con.prepareStatement(sql);
            try {
                 lineReader = new BufferedReader(new FileReader(filepath));
                String linetext=null;
                int count=0;
                try {
                    lineReader.readLine();
                } catch (IOException ex) {
                    System.out.println("Exception in lineReader.readLine() csv to database javajdbc");
                }
                try {
                    while((linetext=lineReader.readLine())!=null)
                    {
                        String[]data=linetext.split(",");
                        String income=data[0];
                        String expense=data[1];
                        String profit=data[2];
                        String branch_id=data[3];
                        
                        
                        
                        System.out.println("income in csvtodatabase"+income);
                        
                        
                     st.setInt(1,parseInt(income))  ; 
                     st.setInt(2,parseInt(expense))  ; 
                     st.setInt(3,parseInt(profit))  ; 
                     st.setInt(4,parseInt(branch_id))  ; 
                     st.addBatch();
                     if(count%batchsize==0)
                     {
                         st.executeBatch();
                     }
                        
                    }
                } catch (IOException ex) {
                  System.out.println("Exception in linereader while loop in csv to database javajdbc");
                }
            } catch (FileNotFoundException ex) {
                System.out.println("Exception in csv to database javajdbc file not found exception");
            }
                try {
                    lineReader.close();
                } catch (IOException ex) {
            System.out.println("Exception in lineReader.close() in csv to database javajdbc");                }
        st.executeBatch();
        con.commit();
        con.close();
        } catch (SQLException ex) {
            System.out.println("Excpetion in csvtodatabase");
        }
        }
 
        
        
        

       

    public static void main(String args[]) throws Exception {
        String tablename = "employees";
        String database = "projpractice";
        String user = "root";
        String password = "dhruv";
        Connection con = ConnectionProvider.getConnection(database, user, password);
        Statement st = Javajdbc.get_a_fresh_statement(con);
        ResultSet tabledetails = st.executeQuery(alltablevaluesQuery(tablename));
//
        Javajdbc.printparticularcolumn(3, tabledetails);
        Javajdbc.printparticularrow(tabledetails, 2);
//
//        System.out.println(count_number_of_rows(con, database, tablename));
//       Javajdbc.printparticularcolumn(2, tabledetails);
//      System.out.println(columncount(tabledetails));

//        System.out.println(Javajdbc.searchemployee(tabledetails, "employee_id", "101"));
//        Javajdbc.insertrow("101", tabledetails, con, "Neena", "Kochhar", "523.223.4568 ", "AD_VP", 27000, "100", "90");
//         st = Javajdbc.get_a_fresh_statement(con);
//        tabledetails = st.executeQuery(alltablevaluesQuery(tablename));
//
//        Javajdbc.updaterow("101", tabledetails, con, "Rahul", " raj", " 345.56.6978", " mechanic", 10000, "101", "60");
//                 st = Javajdbc.get_a_fresh_statement(con);
//
//        tabledetails = st.executeQuery(alltablevaluesQuery(tablename));
//        ArrayList<String> arr = Javajdbc.a_particular_rowtoarray(tabledetails, 1);
//        for (int i = 0; i < arr.size(); i++) {
//            System.out.print(arr.get(i) + " ");
//        }
//        Javajdbc.get_employees_with_same_category(tabledetails, "manager_id", "101");
//        Javajdbc.deleterow_by_id("211", con);
        con.close();
    }
}
