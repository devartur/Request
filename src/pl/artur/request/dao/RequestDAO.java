package pl.artur.request.dao;

import java.util.List;
import pl.artur.request.model.Request;

public abstract interface RequestDAO
  extends GenericDAO<Request, Long>
{
  public abstract List<Request> getAll();
}