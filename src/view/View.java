package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.table.DefaultTableCellRenderer;
import model.Employee;

public class View extends JFrame implements ActionListener {

  private JTable tEmployees = new JTable();
  private JScrollPane spTable = new JScrollPane(tEmployees);
  private JPanel pnUp = new JPanel(new GridLayout(1, 2));
  private JPanel pnLeft = new JPanel();
  private JButton btRegister = new JButton("Register new employee");
  private JLabel lMessage = new JLabel(" ", SwingConstants.RIGHT);
  Timer timerMessage = new Timer(3000, this);
  DefaultTableCellRenderer buttonAndCenterRenderer = new DefaultTableCellRenderer() {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
      if (column == 3) {
        return (TableButton) value;
      }
      return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }

  };

  public View() {
    super("Data of the employees");
    setSize(800, 600);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    lMessage.setFont(new Font("Ariel", Font.BOLD, 16));
    lMessage.setForeground(Color.GREEN);
    lMessage.setHorizontalTextPosition(SwingConstants.RIGHT);
    pnUp.add(pnLeft);
    pnLeft.add(btRegister);
    pnUp.add(lMessage);
    pnUp.setSize(590, 50);
    add(pnUp, BorderLayout.PAGE_START);
    add(spTable);
    buttonAndCenterRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
    tEmployees.addMouseListener(new JTableButtonMouseListener(tEmployees));
    tEmployees.setAutoCreateRowSorter(true);
    lookAndFeel();
    setResizable(false);
    setLocationRelativeTo(this);
  }

  public void showDialog(Employee employee, int buttonIndex) {
    int actualSalary = employee.getSalary();
    try {
      DataSheet ds = new DataSheet(this, employee);
      ds.setVisible(true);
      if (actualSalary != employee.getSalary()) {
        if (!employee.update()) {
          employee.setSalary(actualSalary);
          JOptionPane.showMessageDialog(this, "Update of the salary was not successful, please try again...", "Information Message", JOptionPane.INFORMATION_MESSAGE);
          return;
        }
        tEmployees.setRowSelectionInterval(buttonIndex, buttonIndex);
        tEmployees.setColumnSelectionInterval(2, 2);
        lMessage.setText("Salary updated successfully!  ");
        timerMessage.start();
      }
    } catch (ClassNotFoundException e) {
      employee.setSalary(actualSalary);
      JOptionPane.showMessageDialog(this, "Most probably misssing ojdbc driver!", "Error", JOptionPane.ERROR_MESSAGE);
      System.out.println(e.getMessage());
    } catch (SQLException e) {
      employee.setSalary(actualSalary);
      JOptionPane.showMessageDialog(this, "Querying data failed!", "Error", JOptionPane.ERROR_MESSAGE);
      System.out.println(e.getMessage());
    }
  }

  public void setEmployees(EmployeeTableModel employeeTableModel) {
    tEmployees.setModel(employeeTableModel);
    for (int i = 0; i < tEmployees.getColumnCount(); i++) {
      tEmployees.getColumnModel().getColumn(i).setCellRenderer(buttonAndCenterRenderer);
    }
    tEmployees.getColumnModel().getColumn(3).setPreferredWidth(10);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    lMessage.setText(" ");
    timerMessage.stop();
    if (e.getSource() == btRegister) {
      Integer employeeId = -1;
      CreateEmployeeDialog ced = new CreateEmployeeDialog(this, employeeId);
      ced.setVisible(true);
      if (employeeId > 0) {
        System.out.println("Teszt");
      }
    }
  }

  private static class JTableButtonMouseListener extends MouseAdapter {

    private final JTable table;

    public JTableButtonMouseListener(JTable table) {
      this.table = table;
    }

    public void mouseClicked(MouseEvent e) {
      int column = table.getColumnModel().getColumnIndexAtX(e.getX()); // get the coloum of the button
      int row = e.getY() / table.getRowHeight(); //get the row of the button

      /*Checking the row or column is valid or not*/
      if (row < table.getRowCount() && row >= 0 && column == 3) {
        Object value = table.getValueAt(row, column);
        if (value instanceof TableButton) {
          /*perform a click event*/
          TableButton bt = (TableButton) value;
          bt.setButtonIndex(row);
          bt.doClick();
        }
      }
    }
  }

  private void lookAndFeel() {
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
      ex.printStackTrace();
    }
  }

}
