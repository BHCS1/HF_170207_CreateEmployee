package view.createemployee;

import view.createemployee.steps.StepPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.Employee;
import view.createemployee.steps.FifthStepPanel;
import view.createemployee.steps.FirstStepPanel;
import view.createemployee.steps.FourthStepPanel;
import view.createemployee.steps.SecondStepPanel;
import view.createemployee.steps.ThirdStepPanel;

public class CreateEmployeeDialog extends JDialog {
  //private Integer employeeId=null;
  private JTabbedPane tb = new JTabbedPane();
  private ArrayList<StepPanel> stepPanels=new ArrayList<>();
  private final CreateEmployeeDialog THIS_DIALOG = this;
  
  private Employee employee=null;

  public CreateEmployeeDialog(Frame owner, Employee employee) {
    super(owner, true);
    this.setTitle("Create new employee");
    this.setSize(500, 400);
    this.setLocationRelativeTo(this);
    this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    tb.setFocusable(false);
    tb.setEnabled(false);
    
    //this.employeeId=employeeId;
    this.employee=employee;
    buildTabbedPane();
  }

  private void fillTAbbedPane() {
    

    stepPanels.add(new FirstStepPanel("Instructions", employee));
    stepPanels.add(new SecondStepPanel("Person details", employee));
    stepPanels.add(new ThirdStepPanel("Department and job", employee));
    stepPanels.add(new FourthStepPanel("Salary", employee));
    stepPanels.add(new FifthStepPanel("Summary", employee));


  }

  @SuppressWarnings("Convert2Lambda")
  private void buildTabbedPane() {
    fillTAbbedPane();
    this.add(tb);

    final int STEPS_NUMBER=stepPanels.size();
    for (int i = 0; i < STEPS_NUMBER; i++) {
      StepPanel sp=stepPanels.get(i);
      String stepTitle = sp.getTitle();

      JPanel pnButtons = new JPanel();

      tb.add(sp, stepTitle);

      // COMPONENT POSITION
      int index = tb.indexOfComponent(sp);

      // COMPONENT
      Component component = tb.getComponentAt(index);
      component.setEnabled(false);

      int backStepPanelIndex = index - 1;
      int nextStepPanelIndex = index + 1;

      // BACK BUTTON
      JButton btBack = new JButton("Back");
      btBack.setEnabled(false);
      if (i > 0 && (STEPS_NUMBER > 1)) {
        btBack.setEnabled(true);
        btBack.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
            if(((JButton)e.getSource()).isEnabled())
              tb.setSelectedIndex(backStepPanelIndex);
          }
        });
      }
      pnButtons.add(btBack);

      // NEXT BUTTON
      JButton btNext = new JButton("Next");
      btNext.setEnabled(false);
      if (i < (STEPS_NUMBER - 1) && STEPS_NUMBER > 1) {
        btNext.setEnabled(true);
        btNext.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
            if(((JButton)e.getSource()).isEnabled() && sp.checking()  )
              tb.setSelectedIndex(nextStepPanelIndex);
          }
        });
      }
      pnButtons.add(btNext);

      // CANCEL BUTTON
      JButton btCancel = new JButton("Cancel");
      btCancel.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
          THIS_DIALOG.dispose();
        }
      });
      pnButtons.add(btCancel);

      // FINISH BUTTON
      JButton btnFinish=new JButton("Finish");
      btnFinish.setEnabled(false);
      if(i == (STEPS_NUMBER-1)) {
        btnFinish.setEnabled(true);
        btnFinish.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
            try {
              java.util.Date utilDate = new java.util.Date();
              java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
              employee.setHireDate(sqlDate);
              employee.save();
            } catch (SQLException ex) {
              System.out.println(ex.getMessage());
              JOptionPane.showMessageDialog(null, "Most probably misssing ojdbc driver!", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException ex) {
              System.out.println(ex.getMessage());
              JOptionPane.showMessageDialog(null, "Querying data failed!", "Error", JOptionPane.ERROR_MESSAGE);
            }
          }
        });
      }
      pnButtons.add(btnFinish);

      // add panel with buttons to this step panel
      sp.add(pnButtons, BorderLayout.PAGE_END);
    }
    // set the focus to the first panel
    tb.getComponent(0).setFocusable(true);

  }
}
