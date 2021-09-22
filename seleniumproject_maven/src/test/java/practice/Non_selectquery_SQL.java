package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;


public class Non_selectquery_SQL {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		try {
		Driver d=new Driver();
		DriverManager.registerDriver(d);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Students", "root", "root");
		Statement s= con.createStatement();
		String query=" insert into students_info (regno, firstname, middlename, lastname) values('11', 'sanjay','bhusan ', 'pradhan');";
		int result =s.executeUpdate(query);
if(result==1) {
	System.out.println("user is created");
}
	}catch (Exception e) {
	System.err.println("user is not created");
}finally {
	con.close();
}
}
}
