package pl.artur.request.dao;

public class MysqlDAOFactory extends DAOFactory {
  public MysqlDAOFactory() {}
  
  public UserDAO getUserDAO() {
    return new UserDAOImpl();
  }
  
  public RequestDAO getRequestDAO()
  {
    return new RequestDAOImpl();
  }
}