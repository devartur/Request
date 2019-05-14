package pl.artur.request.dao;

import java.io.Serializable;
import java.util.List;
import pl.artur.request.model.User;

public abstract interface GenericDAO<T, PK extends Serializable>
{
  public abstract T create(T paramT);
  
  public abstract T read(PK paramPK);
  
  public abstract boolean update(T paramT);
  
  public abstract boolean delete(PK paramPK);
  
  public abstract List<T> getAll();
  
  public abstract User addUserInformation(Long paramLong1, String paramString1, String paramString2, String paramString3, String paramString4, Long paramLong2);
}