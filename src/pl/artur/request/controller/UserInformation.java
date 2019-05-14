package pl.artur.request.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.artur.request.model.User;
import pl.artur.request.service.UserService;

@javax.servlet.annotation.WebServlet({"/userInformation"})
public class UserInformation extends javax.servlet.http.HttpServlet
{
  private static final long serialVersionUID = 1L;
  
  public UserInformation() {}
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    request.getRequestDispatcher("WEB-INF/userInformation.jsp").forward(request, response);
  }
  

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    request.setCharacterEncoding("UTF-8");
    User authenticatedUser = (User)request.getSession().getAttribute("user");
    Long userID = Long.valueOf(authenticatedUser.getId());
    
    String username = request.getParameter("inputUsername");
    String email = request.getParameter("inputEmail");
    String firstname = request.getParameter("inputFirstname");
    String secondname = request.getParameter("inputSecondname");
    String superiorUserIdString = request.getParameter("inputSuperiorID");
    Long superiorUserId = Long.valueOf(Long.parseLong(superiorUserIdString));
    
    UserService userService = new UserService();
    userService.addUserInformation(userID, username, email, firstname, secondname, superiorUserId);
    response.sendRedirect(request.getContextPath() + "/");
  }
}