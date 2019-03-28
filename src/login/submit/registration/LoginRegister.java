package login.submit.registration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginRegister
 */
@WebServlet("/LoginRegister")
public class LoginRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginRegister() {
      
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		CustomerDAO cd = new CustomerDAOImpl();
		String username = request.getParameter("username");
		String password = request.getParameter("password1");
		String name = request.getParameter("name");
		
		String submitType = request.getParameter("submit");

		//------------------login page------------------------
		Customer c = cd.getCustomer(username,password,name);
		
		if(submitType.equals("login") && c!=null)
		{  
			request.setAttribute("message", c.getName());
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
			
		}
		//-------------------Registration page---------------------
       else if(submitType.equals("Register")){
			c.setUsername(username);
			c.setName(request. getParameter("name"));
			c.setPassword(password);
			cd.insertCustomer(c);
			request.setAttribute("successMessage", "Registration done,Please login to continue!!!");
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
		else {
			request.setAttribute("message","Data not Found,click on register");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
