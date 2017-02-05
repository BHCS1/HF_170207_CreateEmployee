package view.createemployee.steps;

import java.awt.FlowLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Department;
import model.Employee;
import model.Job;

public class ThirdStepPanel extends StepPanel {
  private String[] jobsList, depsList;
  private JComboBox cbJobs, cbDeps;
  private ArrayList<Job> jobList;
  private ArrayList<Department> depList;

  public ThirdStepPanel(String title, Employee employee) {
    super(title, employee);
    initComponents();
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
     
      int depListSize=depList.size();//Department.getAll().size();
      depsList = new String [depListSize];
      
      for (int i = 0; i < depListSize; i++)
        depsList[i]= depList.get(i).getName();//Department.getAll().get(i).toString();
      
    } catch (ClassNotFoundException ex) {
      ;
    } catch (SQLException ex) {;
      ;
    }
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
    
    employee.setManagerId(200);
    
    minSalary=(Integer)selectedJob.getMinSalary();
    maxSalary=(Integer)selectedJob.getMaxSalary();
    
    System.out.println(minSalary+" "+maxSalary);
    return true;
  }
  
}
