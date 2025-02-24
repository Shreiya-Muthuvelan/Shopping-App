package Frontend;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MainMenuTshirts extends JFrame {
    private JButton addTshirts;
    private JButton deleteTshirts;
    private JButton updateTshirts;
    private JButton viewTshirts;
    private JPanel mainPanel;

    public MainMenuTshirts(Connection connection){
        //Setting frame layout
        setTitle("Tshirts MANAGEMENT SYSTEM");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400,300);
        setLayout(new BorderLayout());

        //Setting panel layout
        mainPanel=new JPanel();
        mainPanel.setLayout(new GridLayout(4,1,10,10));
        mainPanel.setBackground(Color.decode("#F7B9C4"));

        //Initializing buttons
        addTshirts=new JButton("Add Tshirts");
        addTshirts.setFont(new Font("Artifakt Element", Font.PLAIN, 20));
        deleteTshirts=new JButton("Delete Tshirts");
        deleteTshirts.setFont(new Font("Artifakt Element", Font.PLAIN, 20));
        updateTshirts=new JButton("Update Tshirts");
        updateTshirts.setFont(new Font("Artifakt Element", Font.PLAIN, 20));
        viewTshirts=new JButton("View Tshirts");
        viewTshirts.setFont(new Font("Artifakt Element", Font.PLAIN, 20));

        //Action listeners for all buttons
        addTshirts.addActionListener(e -> openPanel(new AddTshirts(connection),"Add Tshirts"));
        viewTshirts.addActionListener(e -> openPanel(new ViewTshirts(connection),"View Tshirts"));
        updateTshirts.addActionListener(e -> openPanel(new UpdateTshirts(connection),"Update Tshirts"));
        deleteTshirts.addActionListener(e -> openPanel(new DeleteTshirts(connection),"Delete Tshirts"));

        //Add Buttons to the main panel
        mainPanel.add(addTshirts);
        mainPanel.add(viewTshirts);
        mainPanel.add(updateTshirts);
        mainPanel.add(deleteTshirts);

        add(mainPanel,BorderLayout.CENTER);
        setVisible(true);
    }

    //This method is to openPanels as per the button click

    private void openPanel(Object component, String title ){
        if(component instanceof JPanel){
            JFrame frame = new JFrame(title);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(800,600);
            frame.add((JPanel) component);
            frame.setVisible(true);
        }
        else if(component instanceof JFrame){
            ((JFrame) component).setVisible(true);
        }
        else{
            throw new IllegalArgumentException("Unsupported Component Type");
        }
    }


}
