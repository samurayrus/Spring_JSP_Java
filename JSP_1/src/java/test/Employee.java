package test;

 import java.sql.*;
import java.util.*;

public class Employee {
    public String[] getEmployees(int id) throws Exception
    {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //
        String url= "jdbc:sqlserver://10.5.4.150\\SQLExpress;database=AdventureWorks;";   // SQLExpress - название субд,
        Connection con = DriverManager.getConnection(url, "sa", "1234");
        /////////////////////////////////////
        //102 Хранимая процедура
        String sql = "{call dbo.uspGetManagerEmployees(?)}";
        CallableStatement st = con.prepareCall(sql);
        st.setInt(1,id);
        ResultSet rs = st.executeQuery();
        List<String> list=new LinkedList<>();
       
        while(rs.next())  //чекаем построчно для вывода
        {Formatter f = new Formatter(); //чистка форматтера. привет сборщику мусора
        f.format("%d %s %s %s %s\n", rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(5), rs.getString(6));
        list.add(f.toString());}
        con.close();
    return  list.toArray(new String[]{});
    }
}
