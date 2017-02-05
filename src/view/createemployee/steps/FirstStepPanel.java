package view.createemployee.steps;

import java.awt.Font;
import javax.swing.JLabel;
import model.Employee;

public class FirstStepPanel extends StepPanel {
  
  public FirstStepPanel(String title, Employee employee){
    super(title, employee);
    initComponents();
  }
  
  @Override
  public void initComponents() {
    JLabel instructions = new JLabel("<html>1. New employee's first name and last name without any digit character<br>"
            + "2. Select the department and the job title<br>"
            + "3. Set the employee's salary between the given limits</html>");
    add(instructions);
<<<<<<< HEAD
    instructions.setFont(new Font("Arial",0,18));
    

=======
    instructions.setFont(new Font("Arial",0,20));
>>>>>>> 1115d9dc5fb452e6e99f897935b03d684b9072ce
  }
  
  @Override
  public boolean checking() {
    return true;
  }
  
}
