package Frontend;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MainMenuHoodies extends JFrame {
    private JButton addHoodies;
    private JButton deleteHoodies;
    private JButton updateHoodies;
    private JButton viewHoodies;
    private JPanel mainPanel;

    public MainMenuHoodies(Connection connection){
        //Setting frame layout
        setTitle("Hoodies MANAGEMENT SYSTEM");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400,300);
        setLayout(new BorderLayout());

        //Setting panel layout
        mainPanel=new JPanel();
        mainPanel.setLayout(new GridLayout(4,1,10,10));
        mainPanel.setBackground(Color.decode("#F7B9C4"));

        //Initializing buttons
        addHoodies=new JButton("Add Hoodies");
        addHoodies.setFont(new Font("Artifakt Element", Font.PLAIN, 20));
        deleteHoodies=new JButton("Delete Hoodies");
        deleteHoodies.setFont(new Font("Artifakt Element", Font.PLAIN, 20));
        updateHoodies=new JButton("Update Hoodies");
        updateHoodies.setFont(new Font("Artifakt Element", Font.PLAIN, 20));
        viewHoodies=new JButton("View Hoodies");
        viewHoodies.setFont(new Font("Artifakt Element", Font.PLAIN, 20));

        //Action listeners for all buttons
        addHoodies.addActionListener(e -> openPanel(new AddHoodies(connection),"Add Hoodies"));
        viewHoodies.addActionListener(e -> openPanel(new ViewHoodies(connection),"View Hoodies"));
        updateHoodies.addActionListener(e -> openPanel(new UpdateHoodies(connection),"Update Hoodies"));
        deleteHoodies.addActionListener(e -> openPanel(new DeleteHoodies(connection),"Delete Hoodies"));

        //Add Buttons to the main panel
        mainPanel.add(addHoodies);
        mainPanel.add(viewHoodies);
        mainPanel.add(updateHoodies);
        mainPanel.add(deleteHoodies);

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
