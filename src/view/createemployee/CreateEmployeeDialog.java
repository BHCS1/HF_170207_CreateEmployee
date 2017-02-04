package view.createemployee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Employee;

public class CreateEmployeeDialog extends JDialog {
  private Integer employeeId=null;
  private JTabbedPane tb = new JTabbedPane();
  private final int STEPS_NUMBER=3;
  private StepPanel[] stepPanels = new StepPanel[STEPS_NUMBER];
  private final CreateEmployeeDialog THIS_CreateEmployeeDialog = this;
  
  private Employee employee=new Employee();

  public CreateEmployeeDialog(Frame owner, Integer employeeId) {
    super(owner, true);
    this.setTitle("Create New Employee");
    this.setSize(500, 400);
    this.setLocationRelativeTo(this);
    this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    tb.setFocusable(false);
    tb.setEnabled(false);
    
    this.employeeId=employeeId;
    buildTabbedPane();
  }

  private void fillTAbbedPane() {
    // BALAZS
    // proba miatt ciklussal feltoltottam
    /*  1. tájékoztatás a varázsló lépéseiről,
        2. alapadatok bekérése (név, elérhetőségek),
        3. részleg kiválasztása,
        4. munkakör kiválasztása a cégnél lévő össze munkakörből,
        5. fizetés megadása úgy, hogy azt a munkaköréhez tartozó
           minimális és maximális fizetés még éppen behatárolja,
        6. befejezés, ellenőrzés, listázás*/
    
    int i=0;
    // FIRST STEP
    stepPanels[i++] = new StepPanel("First step") {

      @Override
      void initComponents() {
        JLabel lbText=new JLabel("First step");
        this.add(lbText);
      }
      
      @Override
      boolean checking() {
        return true;
      }
    };
    // SECOND STEP
    // ...
  }

  @SuppressWarnings("Convert2Lambda")
  private void buildTabbedPane() {
    fillTAbbedPane();
    this.add(tb);

    for (int i = 0; i < STEPS_NUMBER; i++) {
      StepPanel sp = stepPanels[i];
      String stepTitle = stepPanels[i].getTitle();

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
      MagicButton btBack = new MagicButton("Back", i);
      if (i > 0) {
        btBack.setEnabled(true);
        btBack.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            boolean check = sp.checking();
            if (check) {
              tb.setSelectedIndex(backStepPanelIndex);
            } else {
              // BALAZS System.out.println("Hiba");
              // A tartalmat a borderlayout.centerrel kel hozzaadni,de ugye ez az alap
              // a page starton a lepes feliratat add hozza, pl Nev megadasa, department kivalasztasa,
              // a page enden a nyomogombok lesznek
            }
          }
        });
      }
      pnButtons.add(btBack);

      // NEXT BUTTON
      MagicButton btNext = new MagicButton("Next", i);
      if (i < STEPS_NUMBER - 1) {
        btNext.setEnabled(true);
        btNext.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            boolean check = sp.checking();
            if (check) {
              tb.setSelectedIndex(nextStepPanelIndex);
            } else {
              // BALAZS System.out.println("Hiba");
            }
          }
        });
      }
      pnButtons.add(btNext);

      // CANCEL BUTTON
      JButton btCancel = new JButton("Cancel");
      btCancel.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
          THIS_CreateEmployeeDialog.dispose();
        }
      });
      pnButtons.add(btCancel);

      // FINISH BUTTON
      JButton btnFinish=new JButton("Finish");
      btnFinish.setEnabled(false);
      if(i==STEPS_NUMBER-1) {
        btnFinish.setEnabled(true);
        btnFinish.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            try {
              //Kapcsolat a modellel
              // insert query meghívása
              // lajos -1-et van id-t
              employee.save();
            } catch (SQLException ex) {
              ; // BALAZS hibauzenet
            } catch (ClassNotFoundException ex) {
              ; // BALAZS hibauzenet
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
