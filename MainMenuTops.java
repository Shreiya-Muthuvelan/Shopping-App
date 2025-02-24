package Frontend;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MainMenuTops extends JFrame {
    private JButton addTops;
    private JButton deleteTops;
    private JButton updateTops;
    private JButton viewTops;
    private JPanel mainPanel;

    public MainMenuTops(Connection connection){
        //Setting frame layout
        setTitle("Tops MANAGEMENT SYSTEM");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400,300);
        setLayout(new BorderLayout());

        //Setting panel layout
        mainPanel=new JPanel();
        mainPanel.setLayout(new GridLayout(4,1,10,10));
        mainPanel.setBackground(Color.decode("#F7B9C4"));

        //Initializing buttons
        addTops=new JButton("Add Tops");
        addTops.setFont(new Font("Artifakt Element", Font.PLAIN, 20));
        deleteTops=new JButton("Delete Tops");
        deleteTops.setFont(new Font("Artifakt Element", Font.PLAIN, 20));
        updateTops=new JButton("Update Tops");
        updateTops.setFont(new Font("Artifakt Element", Font.PLAIN, 20));
        viewTops=new JButton("View Tops");
        viewTops.setFont(new Font("Artifakt Element", Font.PLAIN, 20));

        //Action listeners for all buttons
        addTops.addActionListener(e -> openPanel(new AddTops(connection),"Add Tops"));
        viewTops.addActionListener(e -> openPanel(new ViewTops(connection),"View Tops"));
        updateTops.addActionListener(e -> openPanel(new UpdateTops(connection),"Update Tops"));
        deleteTops.addActionListener(e -> openPanel(new DeleteTops(connection),"Delete Tops"));

        //Add Buttons to the main panel
        mainPanel.add(addTops);
        mainPanel.add(viewTops);
        mainPanel.add(updateTops);
        mainPanel.add(deleteTops);

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

