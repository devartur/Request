package pl.artur.request.filter;

import java.io.IOException;
import java.security.Principal;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import pl.artur.request.model.User;
import pl.artur.request.service.UserService;






@WebFilter({"/*"})
public class LoginFilter
  implements Filter
{
  public LoginFilter() {}
  
  public void destroy() {}
  
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    throws IOException, ServletException
  {
    HttpServletRequest httpReq = (HttpServletRequest)request;
    if ((httpReq.getUserPrincipal() != null) && (httpReq.getSession().getAttribute("user") == null)) {
      saveUserInSession(httpReq);
    }
    chain.doFilter(request, response);
  }
  
  private void saveUserInSession(HttpServletRequest request)
  {
    UserService userService = new UserService();
    String username = request.getUserPrincipal().getName();
    User userByUsername = userService.getUserByUsername(username);
    request.getSession(true).setAttribute("user", userByUsername);
  }
  
  public void init(FilterConfig arg0)
    throws ServletException
  {}
}