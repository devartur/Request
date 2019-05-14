package pl.artur.request.dao;

import java.util.List;
import pl.artur.request.model.User;

public abstract interface UserDAO
  extends GenericDAO<User, Long>
{
  public abstract List<User> getAll();
  
  public abstract User getUserByUsername(String paramString);
  
  public abstract User addUserInformation(Long paramLong1, String paramString1, String paramString2, String paramString3, String paramString4, Long paramLong2);
}