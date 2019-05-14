package pl.artur.request.model;


public class User
{
  private long id;
  private String username;
  private String email;
  private String password;
  private String firstname;
  private String secondname;
  private long superiorId;
  private int active;
  
  public User() {}
  
  public User(User user)
  {
    id = id;
    username = username;
    email = email;
    password = password;
  }
  
  public User(Long userID, String username, String email, String firstname, String secondname, Long superiorUserId) {
    id = userID.longValue();
    this.username = username;
    this.email = email;
    this.firstname = firstname;
    this.secondname = secondname;
    superiorId = superiorUserId.longValue();
  }
  

  public long getId()
  {
    return id;
  }
  
  public void setId(long id) { this.id = id; }
  
  public String getUsername() {
    return username;
  }
  
  public void setUsername(String username) { this.username = username; }
  
  public String getEmail() {
    return email;
  }
  
  public void setEmail(String email) { this.email = email; }
  
  public String getPassword() {
    return password;
  }
  
  public void setPassword(String password) { this.password = password; }
  
  public String getFirstname() {
    return firstname;
  }
  
  public void setFirstname(String firstname) { this.firstname = firstname; }
  
  public String getSecondname() {
    return secondname;
  }
  
  public void setSecondname(String secondname) { this.secondname = secondname; }
  
  public long getSuperiorId() {
    return superiorId;
  }
  
  public void setSuperiorId(long superiorId) { this.superiorId = superiorId; }
  
  public int getActive() {
    return active;
  }
  
  public void setActive(int active) { this.active = active; }
  
  public int hashCode()
  {
    int prime = 31;
    int result = 1;
    result = 31 * result + active;
    result = 31 * result + (email == null ? 0 : email.hashCode());
    result = 31 * result + (firstname == null ? 0 : firstname.hashCode());
    result = 31 * result + (int)(id ^ id >>> 32);
    result = 31 * result + (password == null ? 0 : password.hashCode());
    result = 31 * result + (secondname == null ? 0 : secondname.hashCode());
    result = 31 * result + (int)(superiorId ^ superiorId >>> 32);
    result = 31 * result + (username == null ? 0 : username.hashCode());
    return result;
  }
  
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    User other = (User)obj;
    if (active != active)
      return false;
    if (email == null) {
      if (email != null)
        return false;
    } else if (!email.equals(email))
      return false;
    if (firstname == null) {
      if (firstname != null)
        return false;
    } else if (!firstname.equals(firstname))
      return false;
    if (id != id)
      return false;
    if (password == null) {
      if (password != null)
        return false;
    } else if (!password.equals(password))
      return false;
    if (secondname == null) {
      if (secondname != null)
        return false;
    } else if (!secondname.equals(secondname))
      return false;
    if (superiorId != superiorId)
      return false;
    if (username == null) {
      if (username != null)
        return false;
    } else if (!username.equals(username))
      return false;
    return true;
  }
  
  public String toString() {
    return 
      "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + ", firstname=" + firstname + ", secondname=" + secondname + ", superiorId=" + superiorId + ", active=" + active + "]";
  }
}