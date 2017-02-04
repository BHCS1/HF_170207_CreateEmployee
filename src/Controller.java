
import model.*;
import view.View;
import view.TableButton;
import view.EmployeeTableModel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Controller implements ActionListener {
    private View view;
    private EmployeeTableModel etm = null;

    public Controller() {
        this.view=new View();
        try {
          etm = new EmployeeTableModel(Employee.getAll(), this);
          view.setEmployees(etm);
          view.setVisible(true);
        } catch (ClassNotFoundException e) {
          JOptionPane.showMessageDialog(null, "Most probably misssing ojdbc driver!", "Error", JOptionPane.ERROR_MESSAGE);
          
          System.out.println(e.getMessage());
          System.exit(0);
        } catch (SQLException e) {
          JOptionPane.showMessageDialog(null, "Querying data failed!", "Error", JOptionPane.ERROR_MESSAGE);
          System.out.println(e.getMessage());
          System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Controller();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      TableButton bt = (TableButton) e.getSource();
        Employee employee = etm.getRow(bt.getEmployeeIndex());
        view.showDialog(employee, bt.getButtonIndex());
    }
}
