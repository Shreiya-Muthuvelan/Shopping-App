package Frontend;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MainMenuEthnic extends JFrame {
    private JButton addEthnic;
    private JButton deleteEthnic;
    private JButton updateEthnic;
    private JButton viewEthnic;
    private JPanel mainPanel;

    public MainMenuEthnic(Connection connection){
        //Setting frame layout
        setTitle("Ethnic MANAGEMENT SYSTEM");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400,300);
        setLayout(new BorderLayout());

        //Setting panel layout
        mainPanel=new JPanel();
        mainPanel.setLayout(new GridLayout(4,1,10,10));
        mainPanel.setBackground(Color.decode("#F7B9C4"));

        //Initializing buttons
        addEthnic=new JButton("Add Ethnic");
        addEthnic.setFont(new Font("Artifakt Element", Font.PLAIN, 20));
        deleteEthnic=new JButton("Delete Ethnic");
        deleteEthnic.setFont(new Font("Artifakt Element", Font.PLAIN, 20));
        updateEthnic=new JButton("Update Ethnic");
        updateEthnic.setFont(new Font("Artifakt Element", Font.PLAIN, 20));
        viewEthnic=new JButton("View Ethnic");
        viewEthnic.setFont(new Font("Artifakt Element", Font.PLAIN, 20));

        //Action listeners for all buttons
        addEthnic.addActionListener(e -> openPanel(new AddEthnic(connection),"Add Ethnic"));
        viewEthnic.addActionListener(e -> openPanel(new ViewEthnic(connection),"View Ethnic"));
        updateEthnic.addActionListener(e -> openPanel(new UpdateEthnic(connection),"Update Ethnic"));
        deleteEthnic.addActionListener(e -> openPanel(new DeleteEthnic(connection),"Delete Ethnic"));

        //Add Buttons to the main panel
        mainPanel.add(addEthnic);
        mainPanel.add(viewEthnic);
        mainPanel.add(updateEthnic);
        mainPanel.add(deleteEthnic);

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
