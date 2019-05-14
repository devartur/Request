package pl.artur.request.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({""})
public class HomeController extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  
  public HomeController() {}
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
  }
}