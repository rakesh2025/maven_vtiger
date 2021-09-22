package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;


public class unittesting_jdbc {

@Test
public void testAccountType() throws SQLException {
	Connection con=null;
	try {
	Driver d=new Driver();
		DriverManager.registerDriver(d);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cust", "root", "root");
		Statement s= con.createStatement();
		String query="select * from cust";
		ResultSet result =s.executeQuery(query);
while(result.next()) {
	int acctno=result.getInt("accno");
	System.out.println(acctno);
	if(acctno==12345600 && result.getString("type").equals("gold")) {
	System.out.println("account type gold & verified==pass");
	break;
}
}
}catch(Exception e) {
	System.err.println("account type is not gold==fail");
}finally {
con.close();
	}
}
}
