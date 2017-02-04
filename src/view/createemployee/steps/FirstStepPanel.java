package view.createemployee.steps;

import javax.swing.JLabel;
import model.Employee;


public class FirstStepPanel extends StepPanel {
  private String title;
  private Employee employee;
  
  public FirstStepPanel(String title, Employee employee){
    super(title, employee);
    this.title = title;
    this.employee = employee;
  }
  
  @Override
  public void initComponents() {
    JLabel instructions = new JLabel("<html>1.New employee's first name and last name without any digit character<br>"
            + "2.Select the department and the job title<br>"
            + "3.Set the employee's salary between the given limits</html>");
    add(instructions);
    instructions.setSize(200, 100);
  }
  
  @Override
  public boolean checking() {
    return true;
  }
  
}
