package Frontend;
//All necessary imports
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.*;

public class UpdateBottoms extends JPanel {

    //Initializing the components
    private JTextField idField, nameField, PriceField, StoreField, GenderField, ColourField, TypeField, SizeField;
    private JButton UpdateStock;

    //Constructor
    public UpdateBottoms(Connection connection) {
        setLayout(new GridLayout(9, 2));
        idField = new JTextField();
        nameField = new JTextField();
        PriceField = new JTextField();
        StoreField = new JTextField();
        GenderField = new JTextField();
        ColourField = new JTextField();
        TypeField = new JTextField();
        SizeField = new JTextField();
        UpdateStock = new JButton("Update Stock");
        UpdateStock.setFont(new Font("Artifakt Element", Font.PLAIN, 20));

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
        add(new JLabel("TYPE :")).setFont(new Font("Artifakt Element", Font.PLAIN, 15));
        add(TypeField);
        add(new JLabel("SIZE :")).setFont(new Font("Artifakt Element", Font.PLAIN, 15));
        add(SizeField);
        add(UpdateStock);
        setBackground(Color.decode("#F7B9C4"));

        //Action Listener for addToStock Button
        UpdateStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateStock(connection);
            }
        });
    }

    //Function to link UpdateStock and Database table
    private void updateStock(Connection connection) {
        int no = 0;
        int p = 0;
        boolean validInp = true;

        //Getting fields entered by user
        String No = idField.getText().trim();
        String Name = nameField.getText().trim();
        String Price = PriceField.getText().trim();
        String Store = StoreField.getText().trim();
        String Gender = GenderField.getText().trim();
        String Colour = ColourField.getText().trim();
        String Type = TypeField.getText().trim();
        String Size = SizeField.getText().trim();

        //Checking if entered id and price and integers or not
        try {
            no = Integer.parseInt(No);
        } catch (NumberFormatException e) {
            validInp = false;
            JOptionPane.showMessageDialog(this, "Please Enter valid Integer for Item Number");
        }
        if (!Price.isEmpty()) {
            try {
                p = Integer.parseInt(Price);
            } catch (NumberFormatException e) {
                validInp = false;
                JOptionPane.showMessageDialog(this, "Please Enter valid Integer for Item Price");
            }
        } else {
        }
        StringBuilder query = new StringBuilder("UPDATE Bottoms SET ");
        boolean hasField = false;

        if (!Name.isEmpty()) {
            query.append("ItemName = ?,");
            hasField = true;
        }

        if (!Price.isEmpty()) {
            query.append("Price = ?,");
            hasField = true;
        }

        if (!Store.isEmpty()) {
            query.append("Store = ?,");
            hasField = true;
        }

        if (!Gender.isEmpty()) {
            query.append("Gender = ?,");
            hasField = true;
        }

        if (!Colour.isEmpty()) {
            query.append("Colour = ?,");
            hasField = true;
        }

        if (!Type.isEmpty()) {
            query.append("Type = ?,");
            hasField = true;
        }

        if (!Size.isEmpty()) {
            query.append("Size = ?,");
            hasField = true;
        }

        if (!hasField) {
            JOptionPane.showMessageDialog(this, "No fields to update");
            return;
        }

        query.setLength(query.length() - 1);
        query.append(" WHERE ItemNo = ?");
        try {
            PreparedStatement ps = connection.prepareStatement(query.toString());
            int index = 1;

            //Set parameters
            if (!Name.isEmpty()) {
                ps.setString(index++, Name);
            }

            if (!Price.isEmpty()) {
                ps.setInt(index++, p);
            }

            if (!Store.isEmpty()) {
                ps.setString(index++, Store);
            }

            if (!Gender.isEmpty()) {
                ps.setString(index++, Gender);
            }

            if (!Colour.isEmpty()) {
                ps.setString(index++, Colour);
            }

            if (!Type.isEmpty()) {
                ps.setString(index++, Type);
            }

            if (!Size.isEmpty()) {
                ps.setString(index++, Size);
            }

            ps.setInt(index, no);
            //System.out.println(query.toString());
            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(this, "UPDATES SUCCESSFUL");

                //Clearing all fields
                idField.setText("");
                nameField.setText("");
                PriceField.setText("");
                StoreField.setText("");
                GenderField.setText("");
                ColourField.setText("");
                TypeField.setText("");
                SizeField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "No item found with given No");

            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error in updation"+e.getMessage());
        }
    }
}



