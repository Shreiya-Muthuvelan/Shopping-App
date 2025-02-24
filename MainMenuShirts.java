package Frontend;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MainMenuShirts extends JFrame {
    private JButton addShirts;
    private JButton deleteShirts;
    private JButton updateShirts;
    private JButton viewShirts;
    private JPanel mainPanel;

    public MainMenuShirts(Connection connection){
        //Setting frame layout
        setTitle("Shirts MANAGEMENT SYSTEM");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400,300);
        setLayout(new BorderLayout());

        //Setting panel layout
        mainPanel=new JPanel();
        mainPanel.setLayout(new GridLayout(4,1,10,10));
        mainPanel.setBackground(Color.decode("#F7B9C4"));

        //Initializing buttons
        addShirts=new JButton("Add Shirts");
        addShirts.setFont(new Font("Artifakt Element", Font.PLAIN, 20));
        deleteShirts=new JButton("Delete Shirts");
        deleteShirts.setFont(new Font("Artifakt Element", Font.PLAIN, 20));
        updateShirts=new JButton("Update Shirts");
        updateShirts.setFont(new Font("Artifakt Element", Font.PLAIN, 20));
        viewShirts=new JButton("View Shirts");
        viewShirts.setFont(new Font("Artifakt Element", Font.PLAIN, 20));

        //Action listeners for all buttons
        addShirts.addActionListener(e -> openPanel(new AddShirts(connection),"Add Shirts"));
        viewShirts.addActionListener(e -> openPanel(new ViewShirts(connection),"View Shirts"));
        updateShirts.addActionListener(e -> openPanel(new UpdateShirts(connection),"Update Shirts"));
        deleteShirts.addActionListener(e -> openPanel(new DeleteShirts(connection),"Delete Shirts"));

        //Add Buttons to the main panel
        mainPanel.add(addShirts);
        mainPanel.add(viewShirts);
        mainPanel.add(updateShirts);
        mainPanel.add(deleteShirts);

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
