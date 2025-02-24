package Frontend;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class ViewCustomer extends JFrame {
    //Defining all components
    private JPanel ViewPanel;
    private JTable table1;

    //Constructor
    public ViewCustomer(Connection connection) {
        setLayout(new BorderLayout());
        view(connection);
        setContentPane(ViewPanel);
        setTitle("View Customer");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void view(Connection connection) {
        //Default model for table

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Customer ID");
        model.addColumn("Username");
        model.addColumn("Password");
        model.addColumn("Customer Name");
        model.addColumn("Phone Number");
        model.addColumn("Location");
        model.addColumn("Email");
        table1 = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table1);
        ViewPanel = new JPanel();
        ViewPanel.setLayout(new BorderLayout());
        ViewPanel.setBackground(Color.decode("#F7B9C4"));
        ViewPanel.add(scrollPane, BorderLayout.CENTER);

        //Connecting to database
        String query = "SELECT * FROM CustomerDetails";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                int id = result.getInt("CustomerId");
                String uname = result.getString("UserName");
                String pw = result.getString("Password");
                String cname = result.getString("CustomerName");
                String phno = result.getString("PhoneNo");
                String loc = result.getString("Location");
                String mail = result.getString("Email");
                model.addRow(new Object[]{id, uname,pw, cname, phno, loc, mail});
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching data: " + e.getMessage());
        }
    }


}
