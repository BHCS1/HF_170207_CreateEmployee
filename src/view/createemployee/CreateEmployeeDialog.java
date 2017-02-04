package view.createemployee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CreateEmployeeDialog extends JDialog {
  private Integer employeeId=null;
  private JTabbedPane tb = new JTabbedPane();
  private StepPanel[] stepPanels = new StepPanel[5];
  private final CreateEmployeeDialog THIS_CreateEmployeeDialog = this;

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
    for (int i = 0; i < stepPanels.length; i++) {
      stepPanels[i] = new StepPanel((i + 1) + ". step");
    }
  }

  @SuppressWarnings("Convert2Lambda")
  private void buildTabbedPane() {
    fillTAbbedPane();
    this.add(tb);
    final int LENGTH = stepPanels.length;

    for (int i = 0; i < LENGTH; i++) {
      StepPanel sp = stepPanels[i];
      String stepTitle = stepPanels[i].getTitle();

      sp.add(new JLabel(stepTitle), BorderLayout.PAGE_START);

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
      if (i < LENGTH - 1) {
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
      if(i==LENGTH-1) {
        btnFinish.setEnabled(true);
        btnFinish.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            //Kapcsolat a modellel
            // insert query meghívása
            // lajos -1-et van id-t
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
