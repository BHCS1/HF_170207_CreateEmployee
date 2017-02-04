/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.createemployee.steps;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import model.Department;
import model.Employee;
import model.Job;

/**
 *
 * @author ferenc
 */
public class ThirdStepPanel extends StepPanel {
  private String title;
  private Employee employee;
  private String[] jobsList, depsList;

  public ThirdStepPanel(String title, Employee employee) {
    super(title, employee);
    this.title = title;
    this.employee = employee;
  }
  


  @Override
  public void initComponents() {
    try {
      ArrayList<Department> depList=Department.getAll();//new ArrayList<>();
//      int jobListSize=Job.getAll().size();
//      jobsList = new String [jobListSize];
//      for (int i = 0; i < jobListSize; i++) 
//        jobsList[i]=Job.getAll().get(i).getTitle();
//      
      int depListSize=depList.size();//Department.getAll().size();
      depsList = new String [depListSize];
      for (int i = 0; i < depListSize; i++) {
        depsList[i]=depList.get(i).toString();//Department.getAll().get(i).toString();
        System.out.println(depsList[i]);
      }
    } catch (ClassNotFoundException ex) {
      System.out.println("?");
    } catch (SQLException ex) {
      ex.printStackTrace();
      //System.out.println("H??");
      }
  //  JComboBox cbJobs=new JComboBox(jobsList);
    JComboBox cbDeps=new JComboBox(depsList);
    add(cbDeps);
    
  }

  @Override
  public boolean checking() {
    return true;
  }
  
}
