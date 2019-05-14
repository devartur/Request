package pl.artur.request.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pl.artur.request.model.User;
import pl.artur.request.service.RequestService;

@WebServlet({"/add"})
public class RequestAddController extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  
  public RequestAddController() {}
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    if (request.getUserPrincipal() != null) {
      request.getRequestDispatcher("WEB-INF/new.jsp").forward(request, response);
    } else {
      response.sendError(403);
    }
  }
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    request.setCharacterEncoding("UTF-8");
    String name = request.getParameter("inputName");
    String description = request.getParameter("inputDescription");
    User authenticatedUser = (User)request.getSession().getAttribute("user");
    String data_start = request.getParameter("data_start");
    String data_stop = request.getParameter("data_stop");
    
    if (request.getUserPrincipal() != null) {
      RequestService requestService = new RequestService();
      requestService.addRequest(name, description, data_start, data_stop, authenticatedUser);
      response.sendRedirect(request.getContextPath() + "/");
    } else {
      response.sendError(403);
    }
  }
}