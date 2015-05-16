  package models;

  import javax.persistence.Entity;
import javax.persistence.Table;

import play.db.jpa.Model;

  /**
   * User has been escaped: This is necessary because User is a reserved word in PostGreSQL
   * However, if working in local host and wish to use localhost:9000/@db (for example) to view database
   * Then it is necessary to temporarily comment out the line (i.e. @Table(name = "`User`") while testing with local host
   *
   */
  @Entity
  // @Table(name="`User`")
  public class User extends Model
  {
    public boolean usaCitizen;
    public String  firstName ;
    public String  lastName  ;
    public int     age       ; // Story 1
    public String  location  ; // Story 1
    public String  email     ;
    public String  password  ;

    public User(boolean usaCitizen,
              String firstName, 
              String lastName, 
              int    age,
              String location,
              String email, 
              String password
              )
    {
      this.usaCitizen = usaCitizen;
      this.firstName = firstName;
      this.lastName = lastName;
      this.age      = age;
      this.location = location;
      this.email = email;
      this.password = password;
    }

    public static User findByEmail(String email) 
    {
        return find("email", email).first();
    }

    public boolean checkPassword(String password) 
    {
        return this.password.equals(password);
    }
  }
