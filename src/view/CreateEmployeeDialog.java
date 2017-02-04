package view;

import java.awt.Frame;
import javax.swing.JDialog;

public class CreateEmployeeDialog extends JDialog {
  
  private Integer employeeId;

  public CreateEmployeeDialog(Frame owner, Integer employeeId) {
    super(owner);
    this.employeeId = employeeId;
  }
  
  
  
}
