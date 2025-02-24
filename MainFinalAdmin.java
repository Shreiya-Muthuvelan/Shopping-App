package Frontend;

import javax.swing.*;
import java.sql.*;
import java.awt.*;

public class MainFinalAdmin extends JFrame{
    private JButton ShirtsButton;
    private JButton BottomsButton;
    private JButton DressesButton;
    private JButton EthnicButton;
    private JButton HoodiesButton;
    private JButton TopsButton;
    private JButton TshirtsButton;
    private JButton CustomerButton;
    private JPanel MainPanel;

    //Constructor
    public MainFinalAdmin(Connection connection) {
        setTitle("ADMIN STOCK MANAGEMENT");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 400);
        setLayout(new BorderLayout());

        MainPanel = new JPanel();
        MainPanel.setLayout(new GridLayout(9, 1, 10, 10));
        //MainPanel.setBackground(Color.decode("F7B9C4"));
        ShirtsButton = new JButton("SHIRTS");
        ShirtsButton.setFont(new Font("Artifakt Element", Font.PLAIN, 20));
        BottomsButton = new JButton("BOTTOMS");
        BottomsButton.setFont(new Font("Artifakt Element", Font.PLAIN, 20));
        DressesButton = new JButton("DRESSES");
        DressesButton.setFont(new Font("Artifakt Element", Font.PLAIN, 20));
        EthnicButton = new JButton("ETHNIC");
        EthnicButton.setFont(new Font("Artifakt Element", Font.PLAIN, 20));
        HoodiesButton = new JButton("HOODIES");
        HoodiesButton.setFont(new Font("Artifakt Element", Font.PLAIN, 20));
        TopsButton = new JButton("TOPS");
        TopsButton.setFont(new Font("Artifakt Element", Font.PLAIN, 20));
        TshirtsButton = new JButton("T-SHIRTS");
        TshirtsButton.setFont(new Font("Artifakt Element", Font.PLAIN, 20));
        CustomerButton = new JButton("CUSTOMERS");
        CustomerButton.setFont(new Font("Artifakt Element", Font.PLAIN, 20));

        //Action Listeners for all buttons

        ShirtsButton.addActionListener(e -> new MainMenuShirts(connection));
        BottomsButton.addActionListener(e -> new MainMenuBottoms(connection));
        DressesButton.addActionListener(e -> new MainMenuDresses(connection));
        EthnicButton.addActionListener(e -> new MainMenuEthnic(connection));
        HoodiesButton.addActionListener(e -> new MainMenuHoodies(connection));
        TopsButton.addActionListener(e -> new MainMenuTops(connection));
        TshirtsButton.addActionListener(e -> new MainMenuTshirts(connection));
        CustomerButton.addActionListener(e -> new MainMenuCustomer(connection));

        //Adding to main panel
        MainPanel.add(ShirtsButton);
        MainPanel.add(BottomsButton);
        MainPanel.add(DressesButton);
        MainPanel.add(EthnicButton);
        MainPanel.add(HoodiesButton);
        MainPanel.add(TopsButton);
        MainPanel.add(TshirtsButton);
        MainPanel.add(CustomerButton);
        MainPanel.setBackground(Color.decode("#F7B9C4"));
        add(MainPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3306/SHOPPING";
        String username = "root";
        String pw ="Shreiya.2805";
        Connection connection=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,username,pw);
            Connection finalConnection = connection;

        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error connecting to database");}

        MainFinalAdmin finalAdmin = new MainFinalAdmin(connection);



    }


}
