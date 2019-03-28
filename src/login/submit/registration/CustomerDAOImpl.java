package login.submit.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerDAOImpl implements CustomerDAO {

	
	static Connection con;
	static PreparedStatement ps;
	@Override
	public Customer getCustomer(String username, String password,String name) {
		Customer C = new Customer();
        try {
        	
        	con = MyConnectionProvider.getCon();
        	ps = con.prepareStatement("select * from customer_db where username=? and password =?");
        	ps.setString(1, username);
        	ps.setString(2, password);

        	
        	ResultSet rs = ps.executeQuery();
        	while(rs.next()) {
        		C.setUsername(rs.getString(1));
        		C.setPassword(rs.getString(2));	
        		
        	}
			
		}
        catch(Exception e)
		{
			System.out.println(e);
		}
		return C;
	}

	@Override
	public int insertCustomer(Customer c) {
		int status = 0;
		try {
			con = MyConnectionProvider.getCon();
			ps= con.prepareStatement("insert into customer_db values(?,?,?)");
			ps.setString(1, c.getUsername());
			ps.setString(2, c.getPassword());
			ps.setString(3, c.getName());
			status = ps.executeUpdate();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
		
	}

}
