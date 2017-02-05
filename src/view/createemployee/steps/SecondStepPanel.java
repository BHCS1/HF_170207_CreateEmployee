/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.createemployee.steps;

import java.awt.FlowLayout;
import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import model.Employee;

/**
 *
 * @author ferenc
 */
public class SecondStepPanel extends StepPanel {

  private JTextField tfEmail;
  private JTextField tfFirstName;
  private JTextField tfLastName;
  private JFormattedTextField ftfPhone;
  
  public SecondStepPanel(String title, Employee employee) {
    super(title, employee);
    this.employee=employee;
    initComponents();
 

  }
  
  @Override
  public void initComponents() {
    JPanel pn=new JPanel();
    pn.setLayout(new FlowLayout(0));
    JPanel pnFname= new JPanel();
    pnFname.add(new JLabel("First name:          "));
    tfFirstName = new JTextField();
    pnFname.add(tfFirstName);
    pn.add(pnFname);
    JPanel pnLname=new JPanel();
    pnLname.add(new JLabel("Last name:         "));
    tfLastName = new JTextField();
    pnLname.add(tfLastName);
    pn.add(pnLname);
    JPanel pnEmail=new JPanel();
    pnEmail.add(new JLabel("Email:                  "));
    tfEmail = new JTextField();
    pnEmail.add(tfEmail);
    pn.add(pnEmail);
    JPanel pnPhone = new JPanel();
    try {
      pnPhone.add(new JLabel("Phone number:  "));
      MaskFormatter mf = new MaskFormatter("###.###.####");
      mf.setPlaceholderCharacter('_');
      ftfPhone = new JFormattedTextField(mf);
      pnPhone.add(ftfPhone);
    } catch (ParseException ex) {
    }
    pn.add(pnPhone);
    tfFirstName.setColumns(25);
    tfLastName.setColumns(25);
    tfEmail.setColumns(25);
    
    
    add(pn);
  }

  @Override
  public boolean checking() {
    int i=0;
//    String email = tfEmail.getText();
//    String phoneNumber = (String)ftfPhone.getValue();
//    employee.setFirstName(tfFirstName.getText());
//    employee.setLastName(tfLastName.getText());
//    
//    if (email.matches("^[A-Za-z0-9_.]+[@][A-Za-z.]+$")) {
//      i++;
//      employee.setEmail(email);
//    }
//    else {
//      JOptionPane.showMessageDialog(this, "Please type a valid email address!", "Information Message", JOptionPane.INFORMATION_MESSAGE);
//    }
//      
//      if (phoneNumber!= null){
//        i++;
//        employee.setPhoneNumber(phoneNumber);
//      }
//      else
//        JOptionPane.showMessageDialog(this, "Please type a valid phone number!", "Information Message", JOptionPane.INFORMATION_MESSAGE);  
//    
    return i==0;
            
  }
  
}
