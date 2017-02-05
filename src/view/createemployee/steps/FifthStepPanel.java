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
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.text.NumberFormat;
import javax.swing.BoxLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.NumberFormatter;
import model.Employee;
import static view.createemployee.steps.StepPanel.minSalary;

/**
 *
 * @author ferenc
 */
public class FifthStepPanel extends StepPanel {
   private JLabel lbInstructionText=new JLabel();
  
  private JFormattedTextField tftSalary= new JFormattedTextField();
  private JPanel pnCheck;
  
  public FifthStepPanel(String title, Employee employee) {
    super(title, employee);
    this.addComponentListener(new ComponentAdapter() {
      @Override
      public void componentShown(ComponentEvent e) {
        lbInstructionText.setText("<html><br>Employee's name: "+employee.getFirstName()+" "+employee.getLastName()+"<br><br>Employees's email: "+
                employee.getEmail()+"<br><br>Employee's phone number: "+employee.getPhoneNumber()+
                "<br><br>Selected department: "+depName+"<br><br>Selected job title: "+ jobTile+
                "<br><br>Employee's salary: "+employee.getSalary()+"</html>");
      }
    });
    
    initComponents();


  }

  @Override
  public void initComponents() {
    JPanel pn=new JPanel();
    pn.add((lbInstructionText));
    add(pn);
  }

  @Override
  public boolean checking() {


       
    return true;
  }

  
  
}
