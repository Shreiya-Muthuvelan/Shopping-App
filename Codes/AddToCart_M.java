package Frontend;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AddToCart_M {
    private JFrame frame;
    private JTextField itemNumberField;
    private JLabel cartLabel;
    private JButton addToCartButton;
    private JButton exitButton;

    // Cart to store the items and their total
    private double totalAmount = 0.0;

    // Item catalog structure
    private static final Map<String, Item> itemCatalog = new HashMap<>();

    // Database connection details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/SHOPPING";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Shreiya.2805";

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                AddToCart_M window = new AddToCart_M();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public AddToCart_M() {
        // Set up UI components
        frame = new JFrame();
        frame.setTitle("Shopping Cart");
        frame.setBounds(100, 100, 400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout());

        JLabel itemLabel = new JLabel("Enter Item Number:");
        frame.getContentPane().add(itemLabel);

        itemNumberField = new JTextField();
        frame.getContentPane().add(itemNumberField);
        itemNumberField.setColumns(10);

        addToCartButton = new JButton("Add to Cart");
        frame.getContentPane().add(addToCartButton);

        cartLabel = new JLabel("Total: $0.00");
        frame.getContentPane().add(cartLabel);

        exitButton = new JButton("Exit");
        frame.getContentPane().add(exitButton);

        // Add item to cart button action
        addToCartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String itemNumber = itemNumberField.getText();
                if (itemCatalog.containsKey(itemNumber)) {
                    Item item = itemCatalog.get(itemNumber);
                    totalAmount += item.getPrice();
                    cartLabel.setText("Total: $" + totalAmount);
                    JOptionPane.showMessageDialog(frame, "Item added to cart!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid item number!");
                }
                itemNumberField.setText(""); // Clear input field
            }
        });

        // Exit button action
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?");
                if (option == JOptionPane.YES_OPTION) {
                    // Display total amount in a message dialog before exiting
                    JOptionPane.showMessageDialog(frame, "Total amount: $" + totalAmount);
                    //System.exit(0); // Exit the application
                }
            }
        });

        // Load data from the database into the item catalog
        loadItemCatalogFromDatabase();
    }

    // Class to represent each item
    static class Item {
        private String id;
        private double price;

        public Item(String id, double price) {
            this.id = id;
            this.price = price;
        }

        public String getId() {
            return id;
        }


        public double getPrice() {
            return price;
        }
    }

    // Method to load the item catalog from the database
    private void loadItemCatalogFromDatabase() {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            // Query to fetch items and their details
            String sql = "SELECT ItemNo, Price FROM ethnic UNION SELECT ItemNo, Price FROM bottoms UNION SELECT ItemNo, Price FROM shirts UNION SELECT ItemNo, Price FROM tshirts UNION SELECT ItemNo, Price FROM hoodies";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String itemId = rs.getString("ItemNo");
                double itemPrice = rs.getDouble("Price");

                // Create a new Item and add it to the catalog
                Item item = new Item(itemId, itemPrice);
                itemCatalog.put(itemId, item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}