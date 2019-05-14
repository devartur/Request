package pl.artur.request.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@javax.servlet.annotation.WebServlet({"/login"})
public class LoginController extends javax.servlet.http.HttpServlet
{
  private static final long serialVersionUID = 1L;
  
  public LoginController() {}
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException
  {
    if (request.getUserPrincipal() != null) {
      response.sendRedirect(request.getContextPath() + "/");
    } else {
      response.sendError(403);
    }
  }
}