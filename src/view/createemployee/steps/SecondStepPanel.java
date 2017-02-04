/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.createemployee.steps;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Employee;

/**
 *
 * @author ferenc
 */
public class SecondStepPanel extends StepPanel {
  private String title;
  private Employee employee;
  
  public SecondStepPanel(String title, Employee employee) {
    super(title, employee);
  }

  @Override
  public void initComponents() {
    JPanel pn=new JPanel();
    pn.setLayout(new BorderLayout());
    JTextField tfFirstName = new JTextField();
    tfFirstName.setColumns(15);
    pn.add(tfFirstName, BorderLayout.NORTH);
    add(pn);
  }

  @Override
  public boolean checking() {
    return true;
  }
  
}
