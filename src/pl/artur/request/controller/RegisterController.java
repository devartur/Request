package pl.artur.request.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.artur.request.service.UserService;

@javax.servlet.annotation.WebServlet({"/register"})
public class RegisterController extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  
  public RegisterController() {}
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    request.getRequestDispatcher("WEB-INF/register.jsp").forward(request, response);
  }
  

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    request.setCharacterEncoding("UTF-8");
    String username = request.getParameter("inputUsername");
    String email = request.getParameter("inputEmail");
    String password = request.getParameter("inputPassword");
    
    UserService userService = new UserService();
    userService.addUser(username, email, password);
    response.sendRedirect(request.getContextPath() + "/");
  }
}