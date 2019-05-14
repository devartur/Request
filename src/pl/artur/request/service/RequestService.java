package pl.artur.request.service;

import java.util.Comparator;
import java.util.List;
import pl.artur.request.dao.DAOFactory;
import pl.artur.request.dao.RequestDAO;
import pl.artur.request.model.Request;
import pl.artur.request.model.User;

public class RequestService
{
  public RequestService() {}
  
  public void addRequest(String name, String description, String data_start, String data_stop, User user)
  {
    Request request = createRequestObject(name, description, data_start, data_stop, user);
    DAOFactory factory = DAOFactory.getDAOFactory();
    RequestDAO requestDao = factory.getRequestDAO();
    requestDao.create(request);
  }
  


  private Request createRequestObject(String name, String description, String data_start, String data_stop, User user)
  {
    Request request = new Request();
    request.setName(name);
    request.setDescription(description);
    User userCopy = new User(user);
    request.setUser(userCopy);
    request.setTimestamp(new java.sql.Timestamp(new java.util.Date().getTime()));
    request.setStart(data_start);
    request.setStop(data_stop);
    return request;
  }
  
  public List<Request> getAllRequest() {
    return getAllRequest(null);
  }
  
  public List<Request> getAllRequest(Comparator<Request> comparator)
  {
    DAOFactory factory = DAOFactory.getDAOFactory();
    RequestDAO requestDao = factory.getRequestDAO();
    List<Request> allRequest = requestDao.getAll();
    if ((comparator != null) && (allRequest != null)) {
      allRequest.sort(comparator);
    }
    
    return allRequest;
  }
  
  public void updateResponse(String option, String idRequest) {
    Request request = new Request();
    
    int optionRequest; 
    
    switch (option) {
	case "Potwierdzam":
	optionRequest = 2;
		break;
		
	case "Odrzucam":
		optionRequest = 1;
			break;

	default:
		optionRequest = 1;
		break;
	}
    
    request.setRequest(optionRequest);
    request.setId(Long.parseLong(idRequest));
    DAOFactory factory = DAOFactory.getDAOFactory();
    RequestDAO requestDao = factory.getRequestDAO();
    requestDao.update(request);
  }
}