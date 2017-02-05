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

/**
 *
 * @author ferenc
 */
public class FifthStepPanel extends StepPanel {
  
  private JFormattedTextField tftSalary= new JFormattedTextField();
  private JPanel pnCheck;
  
  public FifthStepPanel(String title, Employee employee) {
    super(title, employee);
    this.employee=employee;
    initComponents();


  }

  @Override
  public void initComponents() {
    JPanel pn=new JPanel();
    pn.setLayout(new GridLayout(5,1));
    pn.add(new JLabel("valami"));
    pn.add(new JLabel("valami2"));
    add(pn);
  }

  @Override
  public boolean checking() {


       
    return true;
  }

  
  
}
