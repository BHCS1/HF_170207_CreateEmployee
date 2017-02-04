package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Employee extends Model {

  private final int ID;
  private String name;
  private int salary;
  private int departmentId;
  private String departmentName;
  private Department department;

  public static ArrayList<Employee> getAll() throws ClassNotFoundException, SQLException {
    connect();
    ArrayList<Employee> list = new ArrayList<>();

    String query = "SELECT e.employee_id AS id, "
            + "d.department_id AS depId, "
            + "d.department_name AS depName, "
            + "e.first_name || ' ' || e.last_name AS empName, "
            + "e.salary "
            + "FROM departments d "
            + "INNER JOIN employees e "
            + "ON e.department_id=d.department_id "
            + "ORDER BY depName, empName";

    ResultSet result = connection.createStatement().executeQuery(query);

    while (result.next()) {
      list.add(
              new Employee(
                      result.getInt("id"),
                      result.getString("empName"),
                      result.getInt("salary"),
                      result.getInt("depId"),
                      result.getString("depName")
              )
      );
    }

    disconnect();
    return list;
  }

  public Employee(int id, String name, int salary,
          int departmentId, String departmentName) {
    this.ID = id;
    this.name = name;
    this.salary = salary;
    this.departmentId = departmentId;
    this.departmentName = departmentName;
  }

  public boolean update() throws SQLException, ClassNotFoundException {
    connect();

    String query = "UPDATE employees SET salary=" + this.getSalary() + " WHERE employee_id=" + this.getID();
    int result = connection.createStatement().executeUpdate(query);
    System.out.println(""+result);
    disconnect();

    return result > 0;
  }

  public void setSalary(int salary) {
    this.salary = salary;
  }

  public int getID() {
    return ID;
  }

  public String getName() {
    return name;
  }

  public int getSalary() {
    return salary;
  }

  public int getDepartmentId() {
    return departmentId;
  }

  public String getDepartmentName() {
    return departmentName;
  }

  public Department getDepartment() {
    if (department == null) {
      department = new Department(departmentId, departmentName);
    }
    
    return department;
  }
}
