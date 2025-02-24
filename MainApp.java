package Frontend;
//Package imports

//Necessary imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

//Main class
public class MainApp {

    private static JFrame frame;
    private static JPanel mainPanel;
    private static CardLayout cardLayout;

    // Database connection helper
    static class DatabaseConfig {
        private static final String URL = "jdbc:mysql://localhost:3306/SHOPPING";
        private static final String USER = "root";
        private static final String PASSWORD = "Shreiya.2805";

        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }
    }


    private static Font getHeadingFont() {
        return new Font("Artifakt Element", Font.BOLD, 26); // For main headings
    }
    private static Font getLabelFont() {
        return new Font("Artifakt Element", Font.PLAIN, 18); // For labels
    }
    private static Font getButtonFont() {
        return new Font("Artifakt Element", Font.PLAIN, 20); // For buttons
    }
    private static Font getLinkFont() {
        return new Font("SansSerif", Font.PLAIN, 14); // For small link-style buttons
    }
    private static JPanel stylePanel(JPanel panel) {
        panel.setBackground(Color.decode("#F7B9C4")); // Set background color
        return panel;
    }
    // Welcome Panel
    private static JPanel createWelcomePanel() {
        JPanel panel = stylePanel(new JPanel());
        panel.setLayout(new GridLayout(5, 1));
        JLabel label = new JLabel("Welcome to the Shopping App", JLabel.CENTER);
        label.setFont(getHeadingFont());
        JButton registerButton = new JButton("Register");
        registerButton.setFont(getButtonFont());
        JButton loginButton = new JButton("Login");
        loginButton.setFont(getButtonFont());
        /*JButton forgotPasswordButton = new JButton("<html><u>Forget Password</u></html>");
        forgotPasswordButton.setForeground(Color.BLUE);
        forgotPasswordButton.setBorderPainted(false);
        forgotPasswordButton.setContentAreaFilled(false);
        forgotPasswordButton.setFont(getLinkFont());*/
        registerButton.addActionListener(e -> cardLayout.show(mainPanel, "Register"));
        loginButton.addActionListener(e -> cardLayout.show(mainPanel, "Login"));
        //forgotPasswordButton.addActionListener(e -> cardLayout.show(mainPanel, "ForgetPassword"));
        panel.add(label);
        panel.add(registerButton);
        panel.add(loginButton);
        //panel.add(forgotPasswordButton);
        return panel;
    }

    private static JPanel createRegistrationPanel() {
        JPanel panel = stylePanel(new JPanel(new GridLayout(9, 2, 10, 10))); // Increased gap for aesthetics

        // Adding Customer Name
        JLabel nameLabel = new JLabel("Customer Name:");
        nameLabel.setFont(getLabelFont());
        JTextField nameField = new JTextField();

        // Adding Username
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(getLabelFont());
        JTextField usernameField = new JTextField();

        // Adding Phone Number
        JLabel phoneLabel = new JLabel("Phone No:");
        phoneLabel.setFont(getLabelFont());
        JTextField phoneField = new JTextField();

        // Adding Location
        JLabel locationLabel = new JLabel("Location:");
        locationLabel.setFont(getLabelFont());
        JTextField locationField = new JTextField();

        // Adding Email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(getLabelFont());
        JTextField emailField = new JTextField();

        // Adding Password
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(getLabelFont());
        JPasswordField passwordField = new JPasswordField();

        // Adding Confirm Password
        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setFont(getLabelFont());
        JPasswordField confirmPasswordField = new JPasswordField();

        // Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.setFont(getButtonFont());
        submitButton.addActionListener(e -> {
            String customerName = nameField.getText();
            String username = usernameField.getText();
            String phoneNo = phoneField.getText();
            String location = locationField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());

            if (customerName.isEmpty() || username.isEmpty() || phoneNo.isEmpty() || location.isEmpty() || email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(frame, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                boolean success = DatabaseHelper.insertCustomer(username,password,customerName,phoneNo,location,email);
                if (success) {
                    JOptionPane.showMessageDialog(frame, "Registration Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    cardLayout.show(mainPanel, "Login");
                } else {
                    JOptionPane.showMessageDialog(frame, "Registration Failed!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Back Button
        JButton backButton = new JButton("Back");
        backButton.setFont(getButtonFont());
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Welcome"));

        // Add components to panel
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(phoneLabel);
        panel.add(phoneField);
        panel.add(locationLabel);
        panel.add(locationField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(confirmPasswordLabel);
        panel.add(confirmPasswordField);
        panel.add(submitButton);
        panel.add(backButton);

        return panel;
    }

    // Login Panel
    private static JPanel createLoginPanel() {
        JPanel panel = stylePanel(new JPanel(new GridLayout(4, 2)));
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(getLabelFont());
        JTextField usernameField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(getLabelFont());
        JPasswordField passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");
        loginButton.setFont(getButtonFont());
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                try (Connection conn = DatabaseConfig.getConnection()) {
                    String query = "SELECT * FROM CustomerDetails WHERE UserName = ? AND Password = ?";
                    PreparedStatement ps = conn.prepareStatement(query);
                    ps.setString(1, username);
                    ps.setString(2, password);
                    ResultSet rs = ps.executeQuery();

                    if (rs.next()) {
                        JOptionPane.showMessageDialog(frame, "Login Successful!");
                        cardLayout.show(mainPanel, "GenderSelection");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Invalid credentials!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
                }
                if ("admin".equals(usernameField.getText()) && "admin@2024".equals(new String(passwordField.getPassword())))
                {
                    JOptionPane.showMessageDialog(frame, "Admin Login Successful!");
                    try {
                        String url = "jdbc:mysql://localhost:3306/SHOPPING";
                        String u = "root";
                        String p = "Shreiya.2805";

                        Connection connection = null;
                        try {
                            // Load the driver
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            System.out.println("Driver loaded successfully");

                            // Establish the connection
                            connection = DriverManager.getConnection(url, u, p);
                            System.out.println("Connection established successfully");



                        } catch (ClassNotFoundException | SQLException ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Failed to connect to the database. Please try again.");
                        }

                        MainFinalAdmin.main(new String[0]);
                    } catch (Exception ee) {
                        ee.printStackTrace();
                        System.out.println(ee.getMessage());

                    }

                }



            }
        });



        JButton backButton = new JButton("Back");
        backButton.setFont(getButtonFont());
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Welcome"));

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(backButton);

        return panel;
    }


    // Gender Selection Panel
    private static JPanel createGenderSelectionPanel() {
        JPanel panel = stylePanel(new JPanel(new GridLayout(4, 1)));
        JLabel label = new JLabel("Choose your category", JLabel.CENTER);
        label.setFont(getHeadingFont());

        JButton maleButton = new JButton("Male");
        maleButton.setFont(getButtonFont());
        maleButton.addActionListener(e -> {
            String url = "jdbc:mysql://localhost:3306/SHOPPING";
            String username = "root";
            String password = "Shreiya.2805";

            try {
                // Load the driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("Driver loaded successfully");

                // Establish the connection
                Connection connection = DriverManager.getConnection(url, username, password);
                System.out.println("Connection established successfully");

                // Launch the ECommerceApp panel

            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Failed to connect to the database. Please try again.");
            }
            try{
                ECommerceApp_M.main(new String[0]);}
            catch(Exception ee){
                ee.printStackTrace();
                System.out.println(ee.getMessage());

            }
        });


        JButton femaleButton = new JButton("Female");
        femaleButton.setFont(getButtonFont());
        femaleButton.addActionListener(e -> {
            String url = "jdbc:mysql://localhost:3306/SHOPPING";
            String username = "root";
            String password = "Shreiya.2805";

            try {
                // Load the driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("Driver loaded successfully");

                // Establish the connection
                Connection connection = DriverManager.getConnection(url, username, password);
                System.out.println("Connection established successfully");

                // Launch the ECommerceApp panel

            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Failed to connect to the database. Please try again.");
            }
            try{
                Main.main(new String[0]);}
            catch(Exception ee){
                ee.printStackTrace();
                System.out.println(ee.getMessage());

            }
        });



        JButton backButton = new JButton("Back");
        backButton.setFont(getButtonFont());
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Welcome"));

        panel.add(label);
        panel.add(maleButton);
        panel.add(femaleButton);
        panel.add(backButton);

        return panel;
    }

    // Forget Password Panel
    /*private static JPanel createForgetPasswordPanel() {
        JPanel panel = stylePanel(new JPanel(new GridLayout(5, 2)));

        JLabel emailLabel = new JLabel("Enter Registered Email:");
        emailLabel.setFont(getLabelFont());
        JTextField emailField = new JTextField();

        JLabel newPasswordLabel = new JLabel("New Password:");
        newPasswordLabel.setFont(getLabelFont());
        JPasswordField newPasswordField = new JPasswordField();

        JLabel confirmPasswordLabel = new JLabel("Confirm New Password:");
        confirmPasswordLabel.setFont(getLabelFont());
        JPasswordField confirmPasswordField = new JPasswordField();

        JButton resetButton = new JButton("Reset Password");
        resetButton.setFont(getButtonFont());
        resetButton.addActionListener(e -> {
            String email = emailField.getText();
            String newPassword = new String(newPasswordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());

            if (email.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!newPassword.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(frame, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Password reset successful for: " + email, "Success", JOptionPane.INFORMATION_MESSAGE);
                cardLayout.show(mainPanel, "Login");
            }
        });

        JButton backButton = new JButton("Back");
        backButton.setFont(getButtonFont());
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Welcome"));

        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(newPasswordLabel);
        panel.add(newPasswordField);
        panel.add(confirmPasswordLabel);
        panel.add(confirmPasswordField);
        panel.add(resetButton);
        panel.add(backButton);

        return panel;
    }*/

    public static void main(String[] args) {
        LoadingEntries.main(new String[0]);
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
        Connection finalConnection=connection;


        // Initialize the main frame
        frame = new JFrame("Shopping App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);  // Increased size for better space

        // Initialize CardLayout and main panel
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Add all panels
        mainPanel.add(createWelcomePanel(), "Welcome");
        mainPanel.add(createRegistrationPanel(), "Register");
        mainPanel.add(createLoginPanel(), "Login");
        mainPanel.add(createGenderSelectionPanel(), "GenderSelection");
        //mainPanel.add(createForgetPasswordPanel(), "ForgetPassword");

        // Add the main panel to the frame
        frame.add(mainPanel);
        frame.setVisible(true);
        SwingUtilities.invokeLater(MainApp::new);
    }

    // DatabaseHelper Class
    class DatabaseHelper {
        private static final String DB_URL = "jdbc:mysql://localhost:3306/SHOPPING";
        private static final String USER = "root";
        private static final String PASSWORD = "Shreiya.2805";

        public static Connection connect() {
            try {
                return DriverManager.getConnection(DB_URL, USER, PASSWORD);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public static boolean insertCustomer(String username,String password,String customerName, String phoneNo, String location, String email) {
            String sql = "INSERT INTO CustomerDetails (UserName,Password,CustomerName,PhoneNo,Location,Email) VALUES (?, ?, ?, ?, ?, ?)";
            try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, username);
                stmt.setString(2, password);
                stmt.setString(3, customerName);
                stmt.setString(4, phoneNo);
                stmt.setString(5, location);
                stmt.setString(6, email);
                stmt.executeUpdate();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }
}