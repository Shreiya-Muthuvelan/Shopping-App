package Frontend;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class ViewHoodies extends JFrame {
    //Defining all components
    private JPanel ViewPanel;
    private JTable table1;

    //Constructor
    public ViewHoodies(Connection connection) {
        setLayout(new BorderLayout());
        viewShirt(connection);
        setContentPane(ViewPanel);
        setTitle("View Hoodies");
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
        model.addColumn("Item Gender");
        model.addColumn("Item Colour");
        model.addColumn("Item Type");
        model.addColumn("Item Size");
        table1 = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table1);
        ViewPanel = new JPanel();
        ViewPanel.setLayout(new BorderLayout());
        ViewPanel.setBackground(Color.decode("#F7B9C4"));
        ViewPanel.add(scrollPane, BorderLayout.CENTER);

        //Connecting to database
        String query = "SELECT * FROM Hoodies";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                int id = result.getInt("ItemNo");
                String name = result.getString("ItemName");
                String price = result.getString("Price");
                String store = result.getString("Store");
                String gender = result.getString("Gender");
                String colour = result.getString("Colour");
                String type = result.getString("Type");
                String size = result.getString("Size");
                model.addRow(new Object[]{id, name, price, store, gender, colour,type, size});
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching data: " + e.getMessage());
        }
    }


}
