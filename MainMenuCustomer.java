package Frontend;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MainMenuCustomer extends JPanel {
    private JPanel mainPanel;

    public MainMenuCustomer(Connection connection){
        mainPanel=new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.decode("#F7B9C4"));

        openPanel(new ViewCustomer(connection),"View Customer");
        add(mainPanel,BorderLayout.CENTER);
        setVisible(true);
    }

    //This method is to openPanels as per the button click

    private void openPanel(Object component, String title ){
        if(component instanceof JPanel){
            mainPanel.removeAll();
            mainPanel.add((JPanel)component);
            mainPanel.revalidate();
            mainPanel.repaint();
            /*JFrame frame = new JFrame(title);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(800,600);
            frame.add((JPanel) component);
            frame.setVisible(true);*/
        }
        else if(component instanceof JFrame){
            JFrame existingframe = (JFrame) component;
            if(!existingframe.isVisible()){
                existingframe.setVisible(true);
            }
        }
        else{
            throw new IllegalArgumentException("Unsupported Component Type");
        }
    }


}
