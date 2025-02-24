package Frontend;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

class Ethnic2 {
    // Updated method to accept the connection object as a parameter
    public static void viewEthnic(Connection connection, JTable table) {
        try {
            // Create the Statement object and execute the query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Ethnic where Gender='F'");

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
            ResultSet resultSet = statement.executeQuery("SELECT * FROM tshirts where Gender='F'");

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
    public static void viewDresses(Connection connection, JTable table) {
        try {
            // Create the Statement object and execute the query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Dresses");

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
            ResultSet resultSet = statement.executeQuery("SELECT * FROM bottoms where Gender='F'");

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
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Hoodies where Gender='F'");

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
    public static void viewTop(Connection connection, JTable table) {
        try {
            // Create the Statement object and execute the query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Tops");

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

