package Frontend;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class ViewDresses extends JFrame {
    //Defining all components
    private JPanel ViewPanel;
    private JTable table1;

    //Constructor
    public ViewDresses(Connection connection) {
        setLayout(new BorderLayout());
        viewShirt(connection);
        setContentPane(ViewPanel);
        setTitle("View Dresses");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void viewShirt(Connection connection) {
        //Default model for table

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ItemNo");
        model.addColumn("Item Name");
        model.addColumn("Item Price");
        model.addColumn("Item Store");
        model.addColumn("Item Colour");
        model.addColumn("Item Size");
        table1 = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table1);
        ViewPanel = new JPanel();
        ViewPanel.setLayout(new BorderLayout());
        ViewPanel.setBackground(Color.decode("#F7B9C4"));
        ViewPanel.add(scrollPane, BorderLayout.CENTER);

        //Connecting to database
        String query = "SELECT * FROM Dresses";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                int id = result.getInt("ItemNo");
                String name = result.getString("ItemName");
                String price = result.getString("Price");
                String store = result.getString("Store");
                String colour = result.getString("Colour");
                String size = result.getString("Size");
                model.addRow(new Object[]{id, name, price, store, colour, size});
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching data: " + e.getMessage());
        }
    }


}
