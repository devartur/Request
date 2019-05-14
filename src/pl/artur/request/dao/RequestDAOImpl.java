package pl.artur.request.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import pl.artur.request.model.Request;
import pl.artur.request.model.User;
import pl.artur.request.util.ConnectionProvider;









public class RequestDAOImpl
  implements RequestDAO
{
  private static final String CREATE_REQUEST = "INSERT INTO request(name, description, date_create, date_start, date_stop, user_id, superior_user_id)VALUES(:name, :description, :date_create, :date_start, :date_stop, :user_id, :superior_user_id)";
  private static final String READ_ALL_REQUEST = "SELECT user.user_id, username, email, is_active, password, request_id, name, description, date_create, date_start, date_stop, response, request.superior_user_id FROM request LEFT JOIN user ON request.user_id=user.user_id";
  private static final String UPDATE_REQUEST = "UPDATE request SET response=:request WHERE request_id =:id";
  private NamedParameterJdbcTemplate template;
  
  public RequestDAOImpl()
  {
    template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
  }
  
  public Request create(Request request)
  {
    Request resultRequest = new Request(request);
    KeyHolder holder = new GeneratedKeyHolder();
    Map<String, Object> paramMap = new HashMap();
    
    paramMap.put("name", request.getName());
    paramMap.put("description", request.getDescription());
    paramMap.put("date_create", request.getTimestamp());
    paramMap.put("date_start", request.getStart());
    paramMap.put("date_stop", request.getStop());
    paramMap.put("user_id", Long.valueOf(request.getUser().getId()));
    paramMap.put("superior_user_id", Long.valueOf(request.getUser().getSuperiorId()));
    SqlParameterSource paramSource = new MapSqlParameterSource(paramMap);
    
    int update = template.update(CREATE_REQUEST, paramSource, holder);
    if (update > 0) {
      resultRequest.setId(holder.getKey().longValue());
    }
    return resultRequest;
  }
  

  public Request read(Long primaryKey)
  {
    return null;
  }
  
  public boolean update(Request request)
  {
    Request resultRequest = new Request();
    resultRequest.setId(request.getId());
    resultRequest.setRequest(request.getRequest());
    SqlParameterSource paramSource = new BeanPropertySqlParameterSource(resultRequest);
    int update = template.update(UPDATE_REQUEST, paramSource);
    boolean isUpadate;
    if (update > 0)
      isUpadate = true; else {
      isUpadate = false;
    }
    return isUpadate;
  }
  

  public boolean delete(Long key)
  {
    return false;
  }
  
  public List<Request> getAll()
  {
    List<Request> allRequest = template.query(READ_ALL_REQUEST, new RequestDAOImpl.RequestRowMapper(this));
    return allRequest;
  }
  


  public User addUserInformation(Long userID, String username, String email, String firstname, String secondname, Long superiorUserId)
  {
    return null;
  }
}