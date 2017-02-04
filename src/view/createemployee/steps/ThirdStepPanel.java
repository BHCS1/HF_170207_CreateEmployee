/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.createemployee.steps;

import model.Employee;

/**
 *
 * @author ferenc
 */
public class ThirdStepPanel extends StepPanel {
  private String title;
  private Employee employee;

  public ThirdStepPanel(String title, Employee employee) {
    super(title, employee);
    this.title = title;
    this.employee = employee;
  }
  
  

  @Override
  public void initComponents() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean checking() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
  
}
