/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.createemployee.steps;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
  private JTextField tfEmail;
  private JTextField tfFirstName;
  private JTextField tfLastName;
  
  public SecondStepPanel(String title, Employee employee) {
    super(title, employee);
  }
  
  @Override
  public void initComponents() {
    JPanel pn=new JPanel();
    pn.setLayout(new FlowLayout());
    JPanel pnFname= new JPanel();
    pnFname.add(new JLabel("First name:"));
    tfFirstName = new JTextField();
    pnFname.add(tfFirstName);
    pn.add(pnFname);
    JPanel pnLname=new JPanel();
    pnLname.add(new JLabel("Last name:"));
    tfLastName = new JTextField();
    pnLname.add(tfLastName);
    pn.add(pnLname);
    JPanel pnEmail=new JPanel();
    JLabel lbEmail= new JLabel("Email:");
    pnEmail.add(new JLabel("Email:"));
    tfEmail = new JTextField();
    pnEmail.add(tfEmail);
    pn.add(pnEmail);
    JPanel pnPhone = new JPanel();
    pnPhone.add(new JLabel("Phone number:"));
    JTextField tfPhone = new JTextField();
    pnPhone.add(tfPhone);
    pn.add(pnPhone);


 
    tfFirstName.setColumns(25);
    tfLastName.setColumns(25);
    tfEmail.setColumns(25);
    tfPhone.setColumns(25);
    
    
    add(pn);
  }

  @Override
  public boolean checking() {
    int i=0;
    String email = tfEmail.getText();
    String name = tfFirstName.getText()+tfLastName.getText();
    if (email.contains("@") && email.contains(".") && email.indexOf("@")<email.indexOf("."))
      i++;
    else {
      JOptionPane.showMessageDialog(this, "Please type a valid email address!", "Information Message", JOptionPane.INFORMATION_MESSAGE);
    }
    return i==1;
            
  }
  
}
