package view.createemployee.steps;

import javax.swing.*;
import java.awt.*;

public abstract class StepPanel extends JPanel {
  private String title;

  public StepPanel(String title) {
    this.title=title;
    
    this.setLayout(new BorderLayout());
    
    //TITLE
    JPanel pnTitle=new JPanel();
    JLabel lbTitle=new JLabel(title);
    lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
    lbTitle.setFont(new Font("Arial", Font.BOLD, 18));
    pnTitle.add(lbTitle);
    this.add(pnTitle, BorderLayout.PAGE_START);
    
    initComponents();
  }

  public String getTitle() {
    return title;
  }
  
  public abstract void initComponents();

  public abstract boolean checking();
  
}
