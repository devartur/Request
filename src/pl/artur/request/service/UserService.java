package pl.artur.request.service;

import pl.artur.request.model.User;
import pl.artur.request.dao.DAOFactory;
import  pl.artur.request.dao.UserDAO;


public class UserService {
  public static final int USER_ACTIVE = 1;
  
  public UserService() {}
  
  public void addUser(String username, String email, String password) {
    User user = new User();
    user.setUsername(username);
    user.setPassword(password);
    user.setEmail(email);
    user.setActive(1);
    DAOFactory factory = DAOFactory.getDAOFactory();
    UserDAO userDao = factory.getUserDAO();
    userDao.create(user);
  }
  
  public User getUserById(long userId) {
    DAOFactory factory = DAOFactory.getDAOFactory();
    UserDAO userDao = factory.getUserDAO();
    User user = (User)userDao.read(Long.valueOf(userId));
    return user;
  }
  
  public User getUserByUsername(String username) {
    DAOFactory factory = DAOFactory.getDAOFactory();
    UserDAO userDao = factory.getUserDAO();
    User user = userDao.getUserByUsername(username);
    return user;
  }
  
  public void addUserInformation(Long userID, String username, String email, String firstname, String secondname, Long superiorUserId) {
    User user = new User(userID, username, email, firstname, secondname, superiorUserId);
    
    DAOFactory factory = DAOFactory.getDAOFactory();
    UserDAO userDao = factory.getUserDAO();
    userDao.addUserInformation(Long.valueOf(user.getId()), user.getUsername(), user.getEmail(), user.getFirstname(), user.getSecondname(), Long.valueOf(user.getSuperiorId()));
  }
}