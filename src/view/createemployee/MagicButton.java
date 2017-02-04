package view.createemployee;

import javax.swing.*;

public class MagicButton extends JButton {
  int index=0;

  public MagicButton(String text, int index) {
    super(text);
    this.index = index;
    this.setEnabled(false);
  }

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }
}
