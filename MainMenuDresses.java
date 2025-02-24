package Frontend;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MainMenuDresses extends JFrame {
    private JButton addDresses;
    private JButton deleteDresses;
    private JButton updateDresses;
    private JButton viewDresses;
    private JPanel mainPanel;

    public MainMenuDresses(Connection connection){
        //Setting frame layout
        setTitle("Dresses MANAGEMENT SYSTEM");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400,300);
        setLayout(new BorderLayout());

        //Setting panel layout
        mainPanel=new JPanel();
        mainPanel.setLayout(new GridLayout(4,1,10,10));
        mainPanel.setBackground(Color.decode("#F7B9C4"));

        //Initializing buttons
        addDresses=new JButton("Add Dresses");
        addDresses.setFont(new Font("Artifakt Element", Font.PLAIN, 20));
        deleteDresses=new JButton("Delete Dresses");
        deleteDresses.setFont(new Font("Artifakt Element", Font.PLAIN, 20));
        updateDresses=new JButton("Update Dresses");
        updateDresses.setFont(new Font("Artifakt Element", Font.PLAIN, 20));
        viewDresses=new JButton("View Dresses");
        viewDresses.setFont(new Font("Artifakt Element", Font.PLAIN, 20));

        //Action listeners for all buttons
        addDresses.addActionListener(e -> openPanel(new AddDresses(connection),"Add Dresses"));
        viewDresses.addActionListener(e -> openPanel(new ViewDresses(connection),"View Dresses"));
        updateDresses.addActionListener(e -> openPanel(new UpdateDresses(connection),"Update Dresses"));
        deleteDresses.addActionListener(e -> openPanel(new DeleteDresses(connection),"Delete Dresses"));

        //Add Buttons to the main panel
        mainPanel.add(addDresses);
        mainPanel.add(viewDresses);
        mainPanel.add(updateDresses);
        mainPanel.add(deleteDresses);

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
