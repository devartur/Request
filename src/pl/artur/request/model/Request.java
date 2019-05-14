package pl.artur.request.model;

import java.sql.Timestamp;




public class Request
{
  private long id;
  private String name;
  private String description;
  private Timestamp timestamp;
  private String start;
  private String stop;
  private int response;
  private long superior;
  private User user;
  
  public Request() {}
  
  public Request(Request request)
  {
    id = id;
    name = name;
    description = description;
    timestamp = new Timestamp(timestamp.getTime());
    start = start;
    stop = stop;
    this.response = response;
    superior = superior;
    user = new User(user);
  }
  


  public long getId()
  {
    return id;
  }
  
  public void setId(long id) { this.id = id; }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) { this.name = name; }
  
  public String getDescription() {
    return description;
  }
  
  public void setDescription(String description) { this.description = description; }
  
  public Timestamp getTimestamp() {
    return timestamp;
  }
  
  public void setTimestamp(Timestamp timestamp) { this.timestamp = timestamp; }
  
  public String getStart() {
    return start;
  }
  
  public void setStart(String start) { this.start = start; }
  
  public String getStop() {
    return stop;
  }
  
  public void setStop(String stop) { this.stop = stop; }
  
  public int getRequest() {
    return response;
  }
  
  public void setRequest(int request) { this.response = request; }
  
  public long getSuperior() {
    return superior;
  }
  
  public void setSuperior(long superior) { this.superior = superior; }
  
  public User getUser() {
    return user;
  }
  
  public void setUser(User user) { this.user = user; }
  
  public int hashCode()
  {
    int prime = 31;
    int result = 1;
    result = 31 * result + (description == null ? 0 : description.hashCode());
    result = 31 * result + (int)(id ^ id >>> 32);
    result = 31 * result + (name == null ? 0 : name.hashCode());
    result = 31 * result + response;
    result = 31 * result + (start == null ? 0 : start.hashCode());
    result = 31 * result + (stop == null ? 0 : stop.hashCode());
    result = 31 * result + (int)(superior ^ superior >>> 32);
    result = 31 * result + (timestamp == null ? 0 : timestamp.hashCode());
    result = 31 * result + (user == null ? 0 : user.hashCode());
    return result;
  }
  
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Request other = (Request)obj;
    if (description == null) {
      if (description != null)
        return false;
    } else if (!description.equals(description))
      return false;
    if (id != id)
      return false;
    if (name == null) {
      if (name != null)
        return false;
    } else if (!name.equals(name))
      return false;
    if (response != response)
      return false;
    if (start == null) {
      if (start != null)
        return false;
    } else if (!start.equals(start))
      return false;
    if (stop == null) {
      if (stop != null)
        return false;
    } else if (!stop.equals(stop))
      return false;
    if (superior != superior)
      return false;
    if (timestamp == null) {
      if (timestamp != null)
        return false;
    } else if (!timestamp.equals(timestamp))
      return false;
    if (user == null) {
      if (user != null)
        return false;
    } else if (!user.equals(user))
      return false;
    return true;
  }
}