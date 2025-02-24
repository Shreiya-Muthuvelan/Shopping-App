package Frontend;
//All necessary imports
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.*;

public class DeleteBottoms extends JPanel {
    private JTextField idField;
    private JButton DeleteFromStock;

    //Constructor
    public DeleteBottoms(Connection connection) {
        //Setting the layout
        setLayout(new GridLayout(1, 2));
        idField = new JTextField();
        DeleteFromStock = new JButton("Delete From Stock");
        DeleteFromStock.setFont(new Font("Artifakt Element", Font.PLAIN, 20));

        //Adding to panel
        add(new JLabel("ID :")).setFont(new Font("Artifakt Element", Font.PLAIN, 18));
        add(idField);
        add(DeleteFromStock);
        setBackground(Color.decode("#F7B9C4"));

        //Action Listener for DeleteFromStock Button
        DeleteFromStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteStock(connection);
            }
        });
    }

    //Function to link panel and database
    private void deleteStock(Connection connection) {
        int no = 0;
        boolean validInp = true;
        //Getting fields entered by user
        String No = idField.getText();

        //Checking if entered id is integers or not
        try {
            no = Integer.parseInt(No);
        } catch (NumberFormatException e) {
            validInp = false;
            JOptionPane.showMessageDialog(this, "Please Enter valid Integer for Item Number");
        }

        if (validInp) {
            String query = "DELETE FROM Bottoms WHERE ItemNo=?";
            try {
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, no);
                int affectedRows = ps.executeUpdate();
                if(affectedRows>0) {
                    JOptionPane.showMessageDialog(this, "Item deleted from stock successfully");
                }
                else{
                    JOptionPane.showMessageDialog(this,"Item with id"+No+"not found in table");}

                //Clearing fields
                idField.setText("");
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error deleting from stock");
            }

        }
    }
}



