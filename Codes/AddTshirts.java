package Frontend;
//All necessary imports
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.*;

public class AddTshirts extends JPanel {
    //Initializing all components of the panel
    private JTextField idField, nameField, PriceField, StoreField, GenderField, ColourField, SizeField;
    private JButton addToStock;

    //Constructor
    public AddTshirts(Connection connection) {
        //Setting the layout
        setLayout(new GridLayout(9, 2));
        idField = new JTextField();
        nameField = new JTextField();
        PriceField = new JTextField();
        StoreField = new JTextField();
        GenderField = new JTextField();
        ColourField = new JTextField();
        SizeField = new JTextField();
        addToStock = new JButton("Add to Stock");
        addToStock.setFont(new Font("Artifakt Element", Font.PLAIN, 20));

        //Adding to panel
        add(new JLabel("ID :")).setFont(new Font("Artifakt Element", Font.PLAIN, 15));
        add(idField);
        add(new JLabel("NAME :")).setFont(new Font("Artifakt Element", Font.PLAIN, 15));
        add(nameField);
        add(new JLabel("PRICE :")).setFont(new Font("Artifakt Element", Font.PLAIN, 15));
        add(PriceField);
        add(new JLabel("STORE :")).setFont(new Font("Artifakt Element", Font.PLAIN, 15));
        add(StoreField);
        add(new JLabel("GENDER :")).setFont(new Font("Artifakt Element", Font.PLAIN, 15));
        add(GenderField);
        add(new JLabel("COLOUR :")).setFont(new Font("Artifakt Element", Font.PLAIN, 15));
        add(ColourField);
        add(new JLabel("SIZE :")).setFont(new Font("Artifakt Element", Font.PLAIN, 15));
        add(SizeField);
        add(addToStock);
        setBackground(Color.decode("#F7B9C4"));

        //Action Listener for addToStock Button
        addToStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStock(connection);
            }
        });
    }

    //Function to link addToStock and Database table
    private void addStock(Connection connection) {
        int no = 0;
        int p = 0;
        boolean validInp = true;

        //Getting fields entered by user
        String No = idField.getText();
        String Name = nameField.getText();
        String Price = PriceField.getText();
        String Store = StoreField.getText();
        String Gender = GenderField.getText();
        String Colour = ColourField.getText();
        String Size = SizeField.getText();

        //Checking if entered id and price and integers or not
        try {
            no = Integer.parseInt(No);
        } catch (NumberFormatException e) {
            validInp = false;
            JOptionPane.showMessageDialog(this, "Please Enter valid Integer for Item Number");
        }
        try {
            p = Integer.parseInt(Price);
        } catch (NumberFormatException e) {
            validInp = false;
            JOptionPane.showMessageDialog(this, "Please Enter valid Integer for Item Price");
        }

        if (validInp) {
            String query = "INSERT INTO TShirts(ItemNo,ItemName,Price,Store,Gender,Colour,Size) VALUES(?,?,?,?,?,?,?)";
            try {
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, no);
                ps.setString(2, Name);
                ps.setInt(3, p);
                ps.setString(4, Store);
                ps.setString(5, Gender);
                ps.setString(6, Colour);
                ps.setString(7, Size);
                System.out.println(query);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Item Added to stock successfully");

                //Clearing fields
                idField.setText("");
                nameField.setText("");
                PriceField.setText("");
                StoreField.setText("");
                GenderField.setText("");
                ColourField.setText("");
                SizeField.setText("");

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error Adding to stock");
            }
        }
    }
}




