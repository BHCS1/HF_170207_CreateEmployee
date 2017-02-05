
package view.createemployee.steps;

import java.awt.FlowLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Department;
import model.Employee;
import model.Job;
import static view.createemployee.steps.StepPanel.minSalary;

public class ThirdStepPanel extends StepPanel {
  private String[] jobsList, depsList;
  private JComboBox cbJobs, cbDeps, cbManagers;
  private ArrayList<Job> jobList;
  private ArrayList<Department> depList;
  private Department department;

  public ThirdStepPanel(String title, Employee employee) {
    super(title, employee);
    initComponents();
    
    this.addComponentListener(new ComponentAdapter() {
      @Override
      public void componentShown(ComponentEvent e) {
        int choosedDep=cbDeps.getSelectedIndex();
        String choosedDepName= depList.get(choosedDep).getName();
        int choosedDepId= depList.get(choosedDep).getId();
//        Department dep = new Department(choosedDepId, choosedDepName);
        ArrayList<Employee> manList= new ArrayList<>();
        try {
          manList=department.getManagers();
        } catch (ClassNotFoundException ex) {
          System.out.println("Hiba1");
        } catch (SQLException ex) {
          System.out.println("Hiba2");
        }
        System.out.println(manList);
        
      }
    });
  }
  
  @Override
  public void initComponents() {
    datas();
    JPanel pn=new JPanel();
    pn.setLayout(new FlowLayout(0));
    JPanel pnDeps= new JPanel();
    pnDeps.add(new JLabel("Choose department:   "));
    cbDeps=new JComboBox(depsList);
    pnDeps.add(cbDeps);
    pn.add(pnDeps);
    JPanel pnJobs= new JPanel();
    pnJobs.add(new JLabel("Choose Job title:          "));
    cbJobs=new JComboBox(jobsList);
    pnJobs.add(cbJobs);
    pn.add(pnJobs);
    JPanel pnManagers= new JPanel();
    pnManagers.add(new JLabel("Choose manager:        "));
    cbManagers=new JComboBox(depsList);
    pnManagers.add(cbManagers);
    pn.add(pnManagers);
    add(pn);
  }
  
  void datas(){
    try {
      depList=Department.getAll();
      jobList=Job.getAll();
      
      int jobListSize=jobList.size();
      jobsList = new String [jobListSize];
      
      for (int i = 0; i < jobListSize; i++) 
        jobsList[i]=jobList.get(i).getTitle();
     
      int depListSize=depList.size();
      depsList = new String [depListSize];

      for (int i = 0; i < depListSize; i++) {
        depsList[i]= depList.get(i).getName();
      }

    } catch (ClassNotFoundException ex) {
        JOptionPane.showMessageDialog(null, "Most probably misssing ojdbc driver!", "Error", JOptionPane.ERROR_MESSAGE);
        System.out.println(ex.getMessage());
        System.exit(0);
    } catch (SQLException ex) {;

        JOptionPane.showMessageDialog(null, "Querying data failed!", "Error", JOptionPane.ERROR_MESSAGE);
        System.out.println(ex.getMessage());
        System.exit(0);
      }
    

      ;
    }

  @Override
  public boolean checking() {
    int cbDepsSelectedIndex=cbDeps.getSelectedIndex();
    int cbJobsSelectedIndex=cbJobs.getSelectedIndex();
    
    Department selectedDepartment=depList.get(cbDepsSelectedIndex);
    Job selectedJob=jobList.get(cbJobsSelectedIndex);
    
    employee.setJobId(selectedJob.getId());
    employee.setDepartmentId(selectedDepartment.getId());
    
    depName=selectedDepartment.getName();
    jobTile=selectedJob.getTitle();
    
//    int managerId=selectedDepartment.getManagerId();
    employee.setManagerId(100);
    
    minSalary=(Integer)selectedJob.getMinSalary();
    maxSalary=(Integer)selectedJob.getMaxSalary();
    return true;
  }
  
}
