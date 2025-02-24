package Frontend;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

class Ethnic_M {
    // Updated method to accept the connection object as a parameter
    public static void viewEthnic(Connection connection, JTable table) {
        try {
            // Create the Statement object and execute the query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Ethnic where Gender='M'");

            // Get the column count from the result set
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Create a vector to hold the data for the table
            Vector<Vector<Object>> rowData = new Vector<>();

            // Create a vector to hold the column names (optional)
            Vector<String> columnNames = new Vector<>();
            for (int i = 1; i <= columnCount; i++) {
                columnNames.add(metaData.getColumnName(i));
            }

            // Loop through the result set and fill the row data vector
            while (resultSet.next()) {
                Vector<Object> row = new Vector<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(resultSet.getObject(i));
                }
                rowData.add(row);
            }

            // Set the model for the table (with column names and row data)
            table.setModel(new DefaultTableModel(rowData, columnNames));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void viewTshirt(Connection connection,JTable table){
        try {
            // Create the Statement object and execute the query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM tshirts where Gender='M'");

            // Get the column count from the result set
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Create a vector to hold the data for the table
            Vector<Vector<Object>> rowData = new Vector<>();

            // Create a vector to hold the column names (optional)
            Vector<String> columnNames = new Vector<>();
            for (int i = 1; i <= columnCount; i++) {
                columnNames.add(metaData.getColumnName(i));
            }

            // Loop through the result set and fill the row data vector
            while (resultSet.next()) {
                Vector<Object> row = new Vector<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(resultSet.getObject(i));
                }
                rowData.add(row);
            }

            // Set the model for the table (with column names and row data)
            table.setModel(new DefaultTableModel(rowData, columnNames));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void viewBottom(Connection connection, JTable table) {
        try {
            // Create the Statement object and execute the query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM bottoms where Gender='M'");

            // Get the column count from the result set
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Create a vector to hold the data for the table
            Vector<Vector<Object>> rowData = new Vector<>();

            // Create a vector to hold the column names (optional)
            Vector<String> columnNames = new Vector<>();
            for (int i = 1; i <= columnCount; i++) {
                columnNames.add(metaData.getColumnName(i));
            }

            // Loop through the result set and fill the row data vector
            while (resultSet.next()) {
                Vector<Object> row = new Vector<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(resultSet.getObject(i));
                }
                rowData.add(row);
            }

            // Set the model for the table (with column names and row data)
            table.setModel(new DefaultTableModel(rowData, columnNames));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void viewShirts(Connection connection, JTable table) {
        try {
            // Create the Statement object and execute the query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Shirts");

            // Get the column count from the result set
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Create a vector to hold the data for the table
            Vector<Vector<Object>> rowData = new Vector<>();

            // Create a vector to hold the column names (optional)
            Vector<String> columnNames = new Vector<>();
            for (int i = 1; i <= columnCount; i++) {
                columnNames.add(metaData.getColumnName(i));
            }

            // Loop through the result set and fill the row data vector
            while (resultSet.next()) {
                Vector<Object> row = new Vector<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(resultSet.getObject(i));
                }
                rowData.add(row);
            }

            // Set the model for the table (with column names and row data)
            table.setModel(new DefaultTableModel(rowData, columnNames));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void viewHoodie(Connection connection, JTable table) {
        try {
            // Create the Statement object and execute the query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Hoodies where Gender='M'");

            // Get the column count from the result set
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Create a vector to hold the data for the table
            Vector<Vector<Object>> rowData = new Vector<>();

            // Create a vector to hold the column names (optional)
            Vector<String> columnNames = new Vector<>();
            for (int i = 1; i <= columnCount; i++) {
                columnNames.add(metaData.getColumnName(i));
            }

            // Loop through the result set and fill the row data vector
            while (resultSet.next()) {
                Vector<Object> row = new Vector<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(resultSet.getObject(i));
                }
                rowData.add(row);
            }

            // Set the model for the table (with column names and row data)
            table.setModel(new DefaultTableModel(rowData, columnNames));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

public class ECommerceApp_M {
    private JPanel panel1;
    private JButton button;

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/SHOPPING";
        String username = "root";
        String password = "Shreiya.2805";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    // Create the main frame for the application
    JFrame frame = new JFrame("E-Commerce App");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1000,1000);


    JButton button = new JButton("View Ethnic Products");
    Connection finalConnection = connection;
    JButton button1 = new JButton("View Tshirts");
    JButton button2 = new JButton("View Bottoms");

    JButton button4 = new JButton("View Shirts");
    JButton button5 = new JButton("View Hoodies");

    JButton cartbutton = new JButton("Proceed to shopping cart");


    JPanel buttonPanel = new JPanel();
        buttonPanel.add(button);
        buttonPanel.add(button1);
        buttonPanel.add(button2);

        buttonPanel.add(button4);
        buttonPanel.add(button5);
        buttonPanel.add(cartbutton);

    JTable table = new JTable();


    JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane,BorderLayout.CENTER);
        frame.add(buttonPanel,BorderLayout.NORTH);


        button.addActionListener(new

    ActionListener() {
        @Override
        public void actionPerformed (ActionEvent e){
            // Call the viewEthnic function when the button is pressed
            if (finalConnection != null) {
                Ethnic_M.viewEthnic(finalConnection, table);  // Pass connection and table to the method
            } else {
                System.out.println("Connection not established!");
            }
            FilterEthnic_M.main(new String[0]);
        }
    });
        button1.addActionListener(new

    ActionListener() {
        @Override
        public void actionPerformed (ActionEvent e){
            // Call the viewEthnic function when the button is pressed
            if (finalConnection != null) {
                Ethnic_M.viewTshirt(finalConnection, table);  // Pass connection and table to the method
            } else {
                System.out.println("Connection not established!");
            }
            FilterTshirts_M.main(new String[0]);
        }
    });
        button2.addActionListener(new

    ActionListener() {
        @Override
        public void actionPerformed (ActionEvent e){
            // Call the viewEthnic function when the button is pressed
            if (finalConnection != null) {
                Ethnic_M.viewBottom(finalConnection, table);  // Pass connection and table to the method
            } else {
                System.out.println("Connection not established!");
            }
            FilterBottom_M.main(new String[0]);
        }
    });

        button4.addActionListener(new

    ActionListener() {
        @Override
        public void actionPerformed (ActionEvent e){
            // Call the viewEthnic function when the button is pressed
            if (finalConnection != null) {
                Ethnic_M.viewShirts(finalConnection, table);  // Pass connection and table to the method
            } else {
                System.out.println("Connection not established!");
            }
            FilterShirts_M.main(new String[0]);
        }
    });
        button5.addActionListener(new

    ActionListener() {
        @Override
        public void actionPerformed (ActionEvent e){
            // Call the viewEthnic function when the button is pressed
            if (finalConnection != null) {
                Ethnic_M.viewHoodie(finalConnection, table);  // Pass connection and table to the method
            } else {
                System.out.println("Connection not established!");
            }
            FilterHoodies_M.main(new String[0]);

        }
    });
        cartbutton.addActionListener(new

    ActionListener() {
        @Override
        public void actionPerformed (ActionEvent e){
            if (finalConnection != null) {
                AddToCart_M.main(new String[0]);  // Pass connection and table to the method
            } else {
                System.out.println("Connection not established!");
            }

        }
    });

        frame.setVisible(true);
}

}