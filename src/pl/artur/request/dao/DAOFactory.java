package pl.artur.request.dao;

import pl.artur.request.exception.NoSuchDbTypeException;

public abstract class DAOFactory { public static final int MYSQL_DAO_FACTORY = 1;
  
  public DAOFactory() {}
  
  public abstract UserDAO getUserDAO();
  
  public abstract RequestDAO getRequestDAO();
  
  public static DAOFactory getDAOFactory() { DAOFactory factory = null;
    try {
      factory = getDAOFactory(1);
    } catch (NoSuchDbTypeException e) {
      e.printStackTrace();
    }
    
    return factory;
  }
  
  private static DAOFactory getDAOFactory(int typeEngine) throws NoSuchDbTypeException { switch (typeEngine) {
    case 1: 
      return new MysqlDAOFactory();
    }
    throw new NoSuchDbTypeException();
  }
}