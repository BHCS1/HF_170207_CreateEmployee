/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.createemployee.steps;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.BoxLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.NumberFormatter;
import model.Employee;

public class FourthStepPanel extends StepPanel {
  
  private JFormattedTextField tftSalary= new JFormattedTextField();
  private JPanel pnCheck;
  
  public FourthStepPanel(String title, Employee employee) {
    super(title, employee);
    this.employee=employee;
    initComponents();


  }

  @Override
  public void initComponents() {
    JPanel pn = new JPanel(new BorderLayout());
    JPanel pnSalary=new JPanel();
    pnSalary.setLayout(new FlowLayout(FlowLayout.CENTER));
    pnSalary.add(new JLabel("Please type the monthly salary ($): "));
    NumberFormat format = NumberFormat.getInstance();
    NumberFormatter formatter = new NumberFormatter(format);
    formatter.setValueClass(Integer.class);
    formatter.setAllowsInvalid(false);
    formatter.setCommitsOnValidEdit(false);
    tftSalary= new JFormattedTextField(formatter);
    tftSalary.setFocusLostBehavior(JFormattedTextField.PERSIST);
    tftSalary.setColumns(8);
    pnSalary.add(tftSalary);
    pn.add(pnSalary, BorderLayout.NORTH);
    pnCheck = new JPanel();
    pn.add(pnCheck);
    add(pn);
    
  }
  

  @Override
  public boolean checking() {
    pnCheck.add(new JLabel(minSalary+""));
      return true;
       

  }

  
  
}
