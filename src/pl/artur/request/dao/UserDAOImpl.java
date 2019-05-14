package pl.artur.request.dao;

import java.util.List;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import pl.artur.request.model.User;
import pl.artur.request.util.ConnectionProvider;








public class UserDAOImpl
  implements UserDAO
{
  private static final String CREATE_USER = "INSERT INTO user(username, email, password, is_active) VALUES(:username, :email, :password, :active)";
  private static final String READ_USER = "SELECT user_id, username, email, password, is_active FROM user WHERE user_id=:id";
  private static final String READ_USER_BY_USER_NAME = "SELECT user_id, username, email, password, is_active,superior_user_id FROM user WHERE username =:username";
  private static final String UPDATE_USER_INFORMATION = "UPDATE user SET username=:username, email=:email, firstname=:firstname, secondname=:secondname, superior_user_id=:superiorId WHERE user_id =:id";
  private NamedParameterJdbcTemplate template;
  
  public UserDAOImpl()
  {
    template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
  }
  
  public User create(User user)
  {
    User resultUser = new User(user);
    KeyHolder keyHolder = new GeneratedKeyHolder();
    SqlParameterSource paramSource = new BeanPropertySqlParameterSource(user);
    int update = template.update(CREATE_USER, paramSource, keyHolder);
    
    if (update > 0) {
      resultUser.setId(keyHolder.getKey().longValue());
      setDeflautUserRole(resultUser);
    }
    

    return resultUser;
  }
  
  public User addUserInformation(Long userID, String username, String email, String firstname, String secondname, Long superiorUserId)
  {
    User resultUser = new User(userID, username, email, firstname, secondname, superiorUserId);
    SqlParameterSource paramSource = new BeanPropertySqlParameterSource(resultUser);
    int update = template.update(UPDATE_USER_INFORMATION, paramSource);
    

    return resultUser;
  }
  
  private void setDeflautUserRole(User user) {
    String userRoleQuery = "INSERT INTO user_role(username) VALUES(:username)";
    SqlParameterSource paramSource = new BeanPropertySqlParameterSource(user);
    template.update("INSERT INTO user_role(username) VALUES(:username)", paramSource);
  }
  


  public User read(Long primaryKey)
  {
    User resultUser = null;
    SqlParameterSource paramSource = new MapSqlParameterSource("id", primaryKey);
    resultUser = (User)template.queryForObject(READ_USER, paramSource, new UserDAOImpl.UserRowMapper(this));
    return resultUser;
  }
  

  public boolean update(User updateObject)
  {
    return false;
  }
  

  public boolean delete(Long key)
  {
    return false;
  }
  

  public List<User> getAll()
  {
    return null;
  }
  
  public User getUserByUsername(String username)
  {
    User resultUser = null;
    SqlParameterSource paramSource = new MapSqlParameterSource("username", username);
    resultUser = (User)template.queryForObject("SELECT user_id, username, email, password, is_active,superior_user_id FROM user WHERE username =:username", paramSource, new UserDAOImpl.UserRowMapper(this));
    return resultUser;
  }
}