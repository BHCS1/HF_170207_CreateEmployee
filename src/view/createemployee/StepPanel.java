package view.createemployee;

import javax.swing.*;
import java.awt.*;

public abstract class StepPanel extends JPanel {
  private String title;
  //private boolean check;

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

//  boolean setCheck() {
//    return true;
//  }
//
//  boolean getCheck() {
//    return true;
//  }

  public String getTitle() {
    return title;
  }

//  public void setTitle(String title) {
//    this.title = title;
//  }
  
  abstract void initComponents();

  abstract boolean checking();
  
}
