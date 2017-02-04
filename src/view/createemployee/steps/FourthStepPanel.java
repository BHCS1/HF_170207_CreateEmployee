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
public class FourthStepPanel extends StepPanel {
  private String title;
  private Employee employee;
  
  public FourthStepPanel(String title, Employee employee) {
    super(title, employee);
  }

  @Override
  public void initComponents() {
    ;
  }

  @Override
  public boolean checking() {
    return true;
  }
  
}
