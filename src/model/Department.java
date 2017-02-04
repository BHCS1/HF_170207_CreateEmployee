package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Department extends Model {

  private int id;
  private String name;

  public Department(int id, String name) {
    this.id = id;
    this.name = name;
  }
  
  public int getSumSalary() throws SQLException, ClassNotFoundException {
    connect();
    
    String query = "SELECT SUM(salary) AS sumSalary FROM employees WHERE department_id="+id;
    ResultSet result = connection.createStatement().executeQuery(query);
    result.next();
    int sumSalary = result.getInt("sumSalary");
    
    disconnect();
    
    return sumSalary;
  }
}
