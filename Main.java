package Frontend;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Main {
    private JPanel panel1;
    private JButton button;

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/SHOPPING";
        String username = "root";
        String password = "Shreiya.2805";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        // Create the main frame for the application
        JFrame frame = new JFrame("E-Commerce App");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 400);


        JButton button = new JButton("View Ethnic Products");
        Connection finalConnection = connection;
        JButton button1 = new JButton("View Tshirts");
        JButton button2 = new JButton("View Bottoms");

        JButton button4 = new JButton("View Dresses");
        JButton button5 = new JButton("View Hoodies");
        JButton button6 = new JButton("View Tops");
        JButton cartbutton = new JButton("Proceed to shopping cart");


        JPanel buttonPanel = new JPanel();

        buttonPanel.setBackground(Color.decode("#F7B9C4"));
        buttonPanel.add(button);
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button4);
        buttonPanel.add(button5);
        buttonPanel.add(button6);
        buttonPanel.add(cartbutton);

        JTable table = new JTable();


        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.NORTH);


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the viewEthnic function when the button is pressed
                if (finalConnection != null) {
                    Ethnic2.viewEthnic(finalConnection, table);  // Pass connection and table to the method
                } else {
                    System.out.println("Connection not established!");
                }
                FilterEthnic.main(new String[0]);
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the viewEthnic function when the button is pressed
                if (finalConnection != null) {
                    Ethnic2.viewTshirt(finalConnection, table);  // Pass connection and table to the method
                } else {
                    System.out.println("Connection not established!");
                }
                FilterTshirt.main(new String[0]);
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the viewEthnic function when the button is pressed
                if (finalConnection != null) {
                    Ethnic2.viewBottom(finalConnection, table);  // Pass connection and table to the method
                } else {
                    System.out.println("Connection not established!");
                }
                FilterBottom.main(new String[0]);
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the viewEthnic function when the button is pressed
                if (finalConnection != null) {
                    Ethnic2.viewDresses(finalConnection, table);  // Pass connection and table to the method
                } else {
                    System.out.println("Connection not established!");
                }
                FilterDresses.main(new String[0]);
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the viewEthnic function when the button is pressed
                if (finalConnection != null) {
                    Ethnic2.viewHoodie(finalConnection, table);  // Pass connection and table to the method
                } else {
                    System.out.println("Connection not established!");
                }
                FilterHoodie.main(new String[0]);

            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the viewEthnic function when the button is pressed
                if (finalConnection != null) {
                    Ethnic2.viewTop(finalConnection, table);  // Pass connection and table to the method
                } else {
                    System.out.println("Connection not established!");
                }
                FilterTop.main(new String[0]);
            }
        });
        cartbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (finalConnection != null) {
                    AddToCart.main(new String[0]);  // Pass connection and table to the method
                } else {
                    System.out.println("Connection not established!");
                }

            }
        });


        frame.setVisible(true);
    }

}