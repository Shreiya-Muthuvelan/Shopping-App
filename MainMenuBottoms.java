package Frontend;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MainMenuBottoms extends JFrame {
    private JButton addBottoms;
    private JButton deleteBottoms;
    private JButton updateBottoms;
    private JButton viewBottoms;
    private JPanel mainPanel;

    public MainMenuBottoms(Connection connection){
        //Setting frame layout
        setTitle("BOTTOMS MANAGEMENT SYSTEM");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400,300);
        setLayout(new BorderLayout());

        //Setting panel layout
        mainPanel=new JPanel();
        mainPanel.setLayout(new GridLayout(4,1,10,10));
        mainPanel.setBackground(Color.decode("#F7B9C4"));

        //Initializing buttons
        addBottoms=new JButton("Add Bottoms");
        addBottoms.setFont(new Font("Artifakt Element", Font.PLAIN, 20));
        deleteBottoms=new JButton("Delete Bottoms");
        deleteBottoms.setFont(new Font("Artifakt Element", Font.PLAIN, 20));
        updateBottoms=new JButton("Update Bottoms");
        updateBottoms.setFont(new Font("Artifakt Element", Font.PLAIN, 20));
        viewBottoms=new JButton("View Bottoms");
        viewBottoms.setFont(new Font("Artifakt Element", Font.PLAIN, 20));

        //Action listeners for all buttons
        addBottoms.addActionListener(e -> openPanel(new AddBottoms(connection),"Add Bottoms"));
        viewBottoms.addActionListener(e -> openPanel(new ViewBottoms(connection),"View Bottoms"));
        updateBottoms.addActionListener(e -> openPanel(new UpdateBottoms(connection),"Update Bottoms"));
        deleteBottoms.addActionListener(e -> openPanel(new DeleteBottoms(connection),"Delete Bottoms"));

        //Add Buttons to the main panel
        mainPanel.add(addBottoms);
        mainPanel.add(viewBottoms);
        mainPanel.add(updateBottoms);
        mainPanel.add(deleteBottoms);

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
