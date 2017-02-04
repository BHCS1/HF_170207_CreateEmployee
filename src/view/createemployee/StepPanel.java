package view.createemployee;

import javax.swing.*;
import java.awt.*;

public class StepPanel extends JPanel {
  private String title;
  private boolean check;

  public StepPanel(String title) {
    this.title=title;
    this.setLayout(new BorderLayout());
  }

  boolean setCheck() {
    return true;
  }

  boolean getCheck() {
    return true;
  }

  public String getTitle() {
    return title;
  }

//  public void setTitle(String title) {
//    this.title = title;
//  }

  boolean checking() {
    return true;
  }
}
