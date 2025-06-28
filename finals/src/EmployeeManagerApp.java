import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeManagerApp extends JFrame {

    private JTextField managerField;
    private JTextArea resultArea;

    public EmployeeManagerApp() {
        createUI();
    }

    private void createUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setTitle("Employee Manager Search");

        setLayout(new BorderLayout());

        // Top panel with label, text field, and button
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Manager:"));
        managerField = new JTextField(20);
        topPanel.add(managerField);  // Corrected line

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(this::searchEmployees);
        topPanel.add(searchButton);

        add(topPanel, BorderLayout.NORTH);

        // Text area for results
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void searchEmployees(ActionEvent e) {
        String manager = managerField.getText().trim();
        if (!manager.isEmpty()) {
            try {
                ResultSet rs = DatabaseConnector.getEmployeesByManager(manager);
                displayResults(rs);
            } catch (SQLException ex) {
                ex.printStackTrace();
                resultArea.setText("Error accessing the database.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a manager name.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }




    private void displayResults(ResultSet rs) throws SQLException {

        StringBuilder sb = new StringBuilder();
        while (rs.next()) {
            sb.append(rs.getString(1)).append("\t")
                    .append(rs.getString(2)).append("\t")
                    .append(rs.getString(3)).append("\t")
                    .append(rs.getString(4)).append("\t")
                    .append(rs.getString(5)).append("\t")
                    .append(rs.getString(6)).append("\t")
                    .append(rs.getString(7)).append("\t")
                    .append(rs.getString(8)).append("\t")
                    .append(rs.getString(9)).append("\n"); // Ensure all these column names match your database
        }
        resultArea.setText(sb.toString());
    }







    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EmployeeManagerApp().setVisible(true));
    }
}
