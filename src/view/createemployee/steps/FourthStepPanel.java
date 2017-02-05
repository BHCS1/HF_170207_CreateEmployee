/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.createemployee.steps;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.text.NumberFormat;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;
import model.Employee;

public class FourthStepPanel extends StepPanel {
  
  private JTextField tfSalary;
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
    tfSalary= new JTextField();
    tfSalary.setColumns(8);
    pnSalary.add(tfSalary);
    pn.add(pnSalary, BorderLayout.NORTH);
    pnCheck = new JPanel();
    pnCheck.add(new JLabel());
    pn.add(pnCheck);
    add(pn);
    
  }

  

  @Override
  public boolean checking() {
      int typedValue= Integer.parseInt(tfSalary.getText());
      System.out.println(typedValue);
      if ((typedValue<minSalary || typedValue>maxSalary)) {
        JOptionPane.showMessageDialog(this, "Invalid sum! Please select from this interval: "+ minSalary+"-"+ maxSalary+".", "Information Message", JOptionPane.INFORMATION_MESSAGE);
        return false;
      }
        else
      return true;
       

  }

  
  
}
