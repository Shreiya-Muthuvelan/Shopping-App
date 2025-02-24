package Frontend;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class LoadingEntries {
    private static Connection connection;

    public LoadingEntries() {
        String url = "jdbc:mysql://localhost:3306/SHOPPING";
        String username = "root";
        String password = "Shreiya.2805";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established successfully");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL Connection Error: " + e.getMessage());
            e.printStackTrace(); // Print the full error
        }
    }
    private static void executeSQL(String createTableQuery, String[] insertQueries) {
        if (connection == null) {
            System.out.println("No active database connection.");
            return;
        }

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(createTableQuery);
            for (String query : insertQueries) {
                statement.executeUpdate(query);
            }
            System.out.println("Database update successful.");
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
    }


    public void loadEntriesBottoms() {
        String bottomsQuery = "CREATE TABLE IF NOT EXISTS bottoms (ItemNo INT PRIMARY KEY, ItemName VARCHAR(200), Price INT, Store VARCHAR(40), Gender VARCHAR(10), Colour VARCHAR(30), Type VARCHAR(25), size VARCHAR(10))";
        String[] bottomsInserts = {
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0101, 'DaMensch Bermudas', 1690, 'Myntra', 'M', 'Grey', 'Shorts', 'M')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0102, 'Highlander Lounge Shorts', 300, 'Myntra', 'M', 'Grey and White Checks', 'Shorts', 'L')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0103, 'The Souled Store Lounge Shorts', 400, 'Myntra', 'M', 'Black and red', 'Shorts', 'M')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0104, 'US Polo Assn Mens Shorts', 660, 'Myntra', 'M', 'Charcoal grey', 'Shorts', 'M')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0105, 'DaMensch Textured Shorts', 940, 'Myntra', 'M', 'Olive green', 'Shorts', 'S')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0106, 'Jockey Performance Shorts', 1200, 'Amazon', 'M', 'Navy Blue', 'Shorts', 'M')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0107, 'VanHeusen Athleisure Smart Tech Shorts', 800, 'Amazon', 'M', 'Red', 'Shorts', 'L')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0108, 'Adidas Mens Shorts', 1900, 'Amazon', 'M', 'Black', 'Shorts', 'M')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0109, 'US Polo Assn Hybrid Shorts', 760, 'Amazon', 'M', 'Malachite Green', 'Shorts', 'S')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0110, 'Just Rider Gym Shorts', 250, 'Amazon', 'M', 'Black', 'Shorts', 'L')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0111, 'Manfinity Homme Mens Solid Shorts', 1300, 'Shein', 'M', 'Royal Blue', 'Shorts', 'S')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0112, 'Mens Casual Jacquard Shorts', 1400, 'Shein', 'M', 'Off white', 'Shorts', 'M')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0113, 'Manfinity Basics Shorts', 1700, 'Shein', 'M', 'Green', 'Shorts', 'L')",

                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0201, 'bottoms Project Slim Formal bottomss', 1940, 'Myntra', 'M', 'Shiny Black', 'Formal bottomss', 'M')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0202, 'Arrow Men Formal Trouser', 1640, 'Myntra', 'M', 'Light grey', 'Formal bottomss', 'L')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0203, 'Raymond', 900, 'Myntra', 'M', 'Black', 'Formal bottomss', 'M')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0204, 'Park Avenue Trousers', 2000, 'Amazon', 'M', 'Dark Blue', 'Formal bottomss', 'S')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0205, 'Maleno Mens Formal Trousers', 800, 'Amazon', 'M', 'Light Green', 'Formal bottomss', 'M')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0206, 'FTX Mens Loose bottomss', 540, 'Amazon', 'M', 'Dark Grey', 'Formal bottomss', 'M')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0207, 'Manfinity Mode Mens Simple Trousers', 1600, 'Shein', 'M', 'Light grey', 'Formal bottomss', 'S')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0208, 'Manfinity Bizformal', 6200, 'Shein', 'M', 'Blue', 'Formal bottomss', 'M')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0209, 'Business Simple and Slim Trousers', 800, 'Shein', 'M', 'Black', 'Formal bottomss', 'L')",

                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0301, 'Puma Motor Sport Trackbottoms', 2100, 'Myntra', 'M', 'Black', 'Track bottomss', 'S')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0302, 'Nobero Men Regular Joggers', 780, 'Myntra', 'M', 'Black', 'Track bottomss', 'L')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0303, 'HRX Rapid-dry Trackbottomss', 840, 'Myntra', 'M', 'Dark Grey', 'Track bottomss', 'S')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0304, 'Jockey Regular Fit Trackbottomss', 1000, 'Amazon', 'M', 'Light Grey', 'Track bottomss', 'M')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0305, 'Lymio Trackbottoms for Men', 450, 'Amazon', 'M', 'Navy Blue', 'Track bottomss', 'M')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0306, 'Pepe Jeans Mens Slim Trackbottoms', 900, 'Amazon', 'M', 'Dark Grey', 'Track bottomss', 'S')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0307, 'Sumwon Straight Fit Tracks', 1330, 'Shein', 'M', 'Light Grey', 'Track bottomss', 'M')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0308, 'Manfinity Sport Trackbottoms', 1900, 'Shein', 'M', 'Striped Grey', 'Track bottomss', 'S')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0309, 'Aknotic Party Mens Trackbottoms', 3800, 'Shein', 'M', 'Black and White Checks', 'Track bottomss', 'L')",

                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0401, 'Flying Machine Men Stretchable Jeans', 15, 'Myntra', 'M', 'Light blue', 'Jeans', 'S')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0402, 'Urbano Fashion Relaxed Fit Jeans', 700, 'Myntra', 'M', 'Black', 'Jeans', 'M')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0403, 'Highlander Men Tapered Jeans', 450, 'Myntra', 'M', 'Black', 'Jeans', 'M')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0404, 'Ben Martin Mens Slim Fit Jeans', 650, 'Amazon', 'M', 'Light Grey', 'Jeans', 'M')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0405, 'Mufti Mens Ankkle Length Jeans', 2000, 'Amazon', 'M', 'Black', 'Jeans', 'L')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0406, 'QNIM Stylish Jeans', 850, 'Amazon', 'M', 'Classic Blue', 'Jeans', 'S')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0407, 'Manfinity HOMME Mens Jeans', 2320, 'Shein', 'M', 'Dark Blue', 'Jeans', 'S')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0408, 'Mens Casual Distress Jeans', 2700, 'Shein', 'M', 'Dark Grey', 'Jeans', 'L')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0409, 'Manfinity LEGND Mens Relaxed Jeans', 2660, 'Shein', 'M', 'Light Blue', 'Jeans', 'M')",

                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0501, 'Zastra Mini Skirt', 3450, 'Myntra', 'F', 'Black', 'Skirts', 'S')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0502, 'Fable Street Pencil Skirt', 6700, 'Myntra', 'F', 'Off white', 'Skirts', 'M')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0503, 'StyleCast Denim Skirt', 2000, 'Myntra', 'F', 'Blue', 'Skirts', 'M')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0504, 'Oomph Floral Skirt', 390, 'Amazon', 'F', 'Pink', 'Skirts', 'XS')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0505, 'Mehrang Skater Skirt', 1900, 'Amazon', 'F', 'Black and White', 'Skirts', 'XS')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0506, 'Lehriya Fashion Skirt', 1200, 'Amazon', 'F', 'Denim', 'Skirts', 'M')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0507, 'Womens Satin Shiny Skirt', 1300, 'Shein', 'F', 'Ochre', 'Skirts', 'M')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0508, 'Shein High Waist Skirt', 1400, 'Shein', 'F', 'Brown', 'Skirts', 'M')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0509, 'Shein Relaxia Skirt', 900, 'Shein', 'F', 'Green', 'Skirts', 'L')",

                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0601, 'Max White Palazzo', 600, 'Myntra', 'F', 'White', 'Palazzos', 'M')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0602, 'Sangria Embroidered Palazzo', 600, 'Myntra', 'F', 'Black', 'Palazzos', 'S')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0603, 'Vaastra Fusion Palazzo', 1200, 'Myntra', 'F', 'Off White', 'Palazzos', 'L')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0604, 'Go colours Basic Palazzo', 800, 'Amazon', 'F', 'Black', 'Palazzos', 'S')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0605, 'Jhilora New Palazzo', 1100, 'Amazon', 'F', 'Green', 'Palazzos', 'XS')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0606, 'Rangriti Womens Straight Palazzo', 800, 'Amazon', 'F', 'Beige', 'Palazzos', 'M')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0607, 'Shein EZwear Solid Palazzo', 1500, 'Shein', 'F', 'Grey', 'Palazzos', 'M')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0608, 'Shein Coolane Womens Paterned Palazzo', 1300, 'Shein', 'F', 'Crocodile', 'Palazzos', 'L')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0609, 'Shein Lune Spring Palazzo', 1200, 'Shein', 'F', 'Brown', 'Palazzos', 'S')",

                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0701, 'Next Womens Cropped Leggings', 850, 'Myntra', 'F', 'Grey', 'Leggings', 'S')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0702, 'H&M Cotton Leggings', 1000, 'Myntra', 'F', 'Black', 'Leggings', 'M')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0703, 'BeIndi Womens Leggings', 200, 'Myntra', 'F', 'Green', 'Leggings', 'L')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0704, 'BlissClub Fitted Leggings', 1200, 'Amazon', 'F', 'Black', 'Leggings', 'M')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0705, 'STRCH Womens Nylon Leggings', 1700, 'Amazon', 'F', 'Pink', 'Leggings', 'S')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0706, 'OneSky Ankle Length Leggings', 500, 'Amazon', 'F', 'Blue', 'Leggings', 'S')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0707, 'Womens Casual Leggings', 800, 'Shein', 'F', 'Black', 'Leggings', 'L')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0708, 'Shein Sports Womens Leggings', 900, 'Shein', 'F', 'Black', 'Leggings', 'M')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0709, 'Shein EZwear Casual Leggings', 1000, 'Shein', 'F', 'Black', 'Leggings', 'S')",

                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0801, 'H&M Wide Twill Trousers', 1000, 'Myntra', 'F', 'Black', 'Trousers', 'XS')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0802, 'Blissclub Women High Trousers', 2000, 'Myntra', 'F', 'Black', 'Trousers', 'M')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0803, 'Knocks Women Straight Fit Trousers', 2500, 'Myntra', 'F', 'Grey', 'Trousers', 'S')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0804, 'Kotty Women Polyester Trousers', 1000, 'Amazon', 'F', 'Black', 'Trousers', 'L')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0805, 'Alen Solly Casual Trousers', 1000, 'Amazon', 'F', 'Grey', 'Trousers', 'M')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0806, 'Leriya Fashion Trousers', 2000, 'Amazon', 'F', 'Black', 'Trousers', 'S')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0807, 'Shein Essence Trousers', 1000, 'Shein', 'F', 'Black', 'Trousers', 'S')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0808, 'Shein Moosta Trousers', 1000, 'Shein', 'F', 'Brown', 'Trousers', 'M')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0809, 'Shein Lune Spring Trousers', 1200, 'Shein', 'F', 'Beige', 'Trousers', 'L')",

                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0901, 'Roadster Women Wide Jeans', 2000, 'Myntra', 'F', 'Black', 'Jeans', 'S')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0902, 'Dolce Skinny Jeans', 3000, 'Myntra', 'F', 'Blue', 'Jeans', 'M')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0903, 'DressBerry Women Faded Jeans', 1200, 'Myntra', 'F', 'Blue', 'Jeans', 'XS')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0904, 'Levis Straight Jeans', 1440, 'Amazon', 'F', 'Blue', 'Jeans', 'M')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0905, 'Levis High Rise Jeans', 1500, 'Amazon', 'F', 'Blue', 'Jeans', 'L')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0906, 'Levis Skinny Jeans', 1600, 'Amazon', 'F', 'Black', 'Jeans', 'XS')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0907, 'High Waist Jeans', 1640, 'Shein', 'F', 'Black', 'Jeans', 'M')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0908, 'Shein Frenchy Jeans', 2530, 'Shein', 'F', 'Blue', 'Jeans', 'M')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, size) VALUES (0909, 'Womens Retro Loose Jeans', 2300, 'Shein', 'F', 'Grey', 'Jeans', 'S')"};
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(bottomsQuery);
            for (String q : bottomsInserts) {
                statement.executeUpdate(q);
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //executeSQL(bottomsQuery,bottomsInserts);
    }

    public void loadEntriesCustomer() {
        String query = "CREATE TABLE IF NOT EXISTS CustomerDetails (UserName VARCHAR(20) UNIQUE,Password VARCHAR(20),CustomerName VARCHAR(200), PhoneNo VARCHAR(20) UNIQUE , Location VARCHAR(500), Email VARCHAR(150) UNIQUE)";
        String query1 = "ALTER TABLE CustomerDetails auto_increment =100";
        String[] insertqueries = new String[]{
                "INSERT INTO CustomerDetails (UserName,Password,CustomerName, PhoneNo, Location, Email) VALUES ('apat1245','abcde','Andrew Patrick','91 98765 43210', '20/3, Gk Temple Times, Behind Maruthi Plaza, Chickpet, Bangalore, Karnataka','a.patrick.1234@gmail.com')",
                "INSERT INTO CustomerDetails (Username,Password,CustomerName, PhoneNo, Location, Email) VALUES ('ananyamehta04','ana4522','Ananya Mehta','91 91234 56789', 'Hazari Baugh, 2 10 Th Rd, Jvpd Scheme, Juhu Vile Parle, Mumbai, Maharastra','ananya.mehta@gmail.com')",
                "INSERT INTO CustomerDetails (Username,Password,CustomerName, PhoneNo, Location, Email) VALUES ('vkreddy08','vikram@2024','Vikram Reddy','91 99876 54321', '4 Thalayari St, Royapettah, Chennai, TamilNadu','vikram_r@hotmail.com')",
                "INSERT INTO CustomerDetails (Username,Password,CustomerName, PhoneNo, Location, Email) VALUES ('arjun2456','arj2024','Arjun Verma','91 98700 65432', 'No 5, United Builders, S D Road,Hyderabad,Andhra Pradesh','arjun_verma89@hotmail.com')"};

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.executeUpdate(query1);
            for (String q : insertqueries) {
                statement.executeUpdate(q);
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //executeSQL(query,insertqueries);
    }

    public void loadEntriesDresses() {
        String query = "CREATE TABLE IF NOT EXISTS Dresses " +
                "(ItemNo INT PRIMARY KEY, " +
                "ItemName VARCHAR(200), " +
                "Price INT, " +
                "Store VARCHAR(50), " +
                "Colour VARCHAR(50), " +
                "Size VARCHAR(5))";
        String[] insertqueries = new String[]{
                "INSERT INTO Dresses (ItemNo, ItemName, Price, Store, Colour, Size) VALUES (2016,'Maxi Dress',1990,'Zara','Red','M')",
                "INSERT INTO Dresses (ItemNo, ItemName, Price, Store, Colour, Size) VALUES (2017,'Summer Floral Dress',1299,'H&M','Yellow','S')",
                "INSERT INTO Dresses (ItemNo, ItemName, Price, Store, Colour, Size) VALUES (2018,'Bodycon Dress',999,'Forever21','Black','L')",
                "INSERT INTO Dresses (ItemNo, ItemName, Price, Store, Colour, Size) VALUES (2019,'Evening Gown',2999,'Myntra','Blue','M')",
                "INSERT INTO Dresses (ItemNo, ItemName, Price, Store, Colour, Size) VALUES (2020,'Casual Tunic Dress',499,'Shein','White','L')",
                "INSERT INTO Dresses (ItemNo, ItemName, Price, Store, Colour, Size) VALUES (2021,'Lace Mini Dress',1599,'Amazon','Pink','S')",
                "INSERT INTO Dresses (ItemNo, ItemName, Price, Store, Colour, Size) VALUES (2022,'Denim Shirt Dress',899,'Levis','Blue','XL')",
                "INSERT INTO Dresses (ItemNo, ItemName, Price, Store, Colour, Size) VALUES (2023,'A-line Dress',1299,'Zara','Green','M')",
                "INSERT INTO Dresses (ItemNo, ItemName, Price, Store, Colour, Size) VALUES (2024,'Off-Shoulder Dress',1199,'H&M','Black','S')",
                "INSERT INTO Dresses (ItemNo, ItemName, Price, Store, Colour, Size) VALUES (2025,'Wrap Dress',1499,'Forever21','Purple','L')",
                "INSERT INTO Dresses (ItemNo, ItemName, Price, Store, Colour, Size) VALUES (2026,'Shift Dress',999,'Myntra','Orange','M')",
                "INSERT INTO Dresses (ItemNo, ItemName, Price, Store, Colour, Size) VALUES (2027,'Midi Dress',1299,'Shein','Red','XL')",
                "INSERT INTO Dresses (ItemNo, ItemName, Price, Store, Colour, Size) VALUES (2028,'Boho Dress',899,'Amazon','White','S')",
                "INSERT INTO Dresses (ItemNo, ItemName, Price, Store, Colour, Size) VALUES (2029,'Formal Blazer Dress',1999,'Zara','Black','M')",
                "INSERT INTO Dresses (ItemNo, ItemName, Price, Store, Colour, Size) VALUES (2030,'Polka Dot Dress',699,'H&M','Yellow','L')"
        };
        try {
            // Loading the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found: " + e.getMessage());
        }
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            for (String q : insertqueries) {
                statement.executeUpdate(q);
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
        //executeSQL(query,insertqueries);
    }

    public void loadEntriesEthnic() {
        String query = "CREATE TABLE IF NOT EXISTS Ethnic (ItemNo INT PRIMARY KEY,ItemName VARCHAR(60),Price INT,Store VARCHAR(40),Gender VARCHAR(10),Colour VARCHAR(30),Type VARCHAR(25),Size VARCHAR(10))";
        String[] insertQueries1 = {
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0011', 'Kurta set Men', 1500, 'Myntra', 'M', 'Blue', 'Kurta', 'M')",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0012', 'Anouk Kurta', 1800, 'Myntra', 'M', 'Pink', 'Kurta', 'L')",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0013', 'Tattva Kurta', 800, 'Myntra', 'M', 'Yellow', 'Kurta', 'XL')",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0014', 'Sojanya Kurta', 2400, 'Amazon', 'M', 'Brown', 'Kurta', 'S')",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0015', 'Ivoc Kurta', 1300, 'Amazon', 'M', 'Green', 'Kurta', 'M')",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0016', 'Jomper Kurta', 480, 'Amazon', 'M', 'Blue', 'Kurta', 'XL')",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0017', 'Fubar Kurta', 1100, 'Shein', 'M', 'Yellow', 'Kurta', 'S');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0018', 'Manyavar', 3800, 'Shein', 'M', 'Brown', 'Kurta', 'XL');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0019', 'Diwas', 2300, 'Shein', 'M', 'Red', 'Kurta', 'M');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0020', 'Ramraj', 500, 'Amazon', 'M', 'White', 'Dhoti', 'OneSize');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0021', 'Sangaria', 1050, 'Amazon', 'M', 'White', 'Dhoti', 'OneSize');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0022', 'Vastramay', 780, 'Amazon', 'M', 'Black', 'Dhoti', 'OneSize');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0023', 'Anug', 900, 'Myntra', 'M', 'Green', 'Dhoti', 'OneSize');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0024', 'Prakasam', 600, 'Myntra', 'M', 'White', 'Dhoti', 'OneSize');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0025', 'Sanwara', 850, 'Myntra', 'M', 'White', 'Dhoti', 'OneSize');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0026', 'Shiwam', 700, 'Shein', 'M', 'White', 'Dhoti', 'OneSize');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0027', 'Amodh', 680, 'Shein', 'M', 'White', 'Dhoti', 'OneSize');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0028', 'Sehur', 870, 'Shein', 'M', 'White', 'Dhoti', 'OneSize');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0029', 'Kisah', 1700, 'Amazon', 'M', 'Yellow', 'Nehru Jacket', 'M');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0030', 'Anouk', 2000, 'Amazon', 'M', 'Blue', 'Nehru Jacket', 'L');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0031', 'Ode', 2500, 'Amazon', 'M', 'Pink', 'Nehru Jacket', 'M');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0032', 'Vastraa', 1200, 'Myntra', 'M', 'Red', 'Nehru Jacket', 'XL');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0033', 'Manyavar', 3000, 'Myntra', 'M', 'Yellow', 'Nehru Jacket', 'M');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0034', 'Vastramay', 900, 'Myntra', 'M', 'Brown', 'Nehru Jacket', 'XL');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0035', 'Sojanya', 2400, 'Shein', 'M', 'Blue', 'Nehru Jacket', 'L');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0036', 'Kraft', 4000, 'Shein', 'M', 'Green', 'Nehru Jacket', 'XL');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0037', 'Cavio', 2900, 'Shein', 'M', 'White', 'Nehru Jacket', 'M');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0038', 'Kalini', 2500, 'Amazon', 'F', 'Red', 'Saree', 'OneSize');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0039', 'Mitera', 1400, 'Amazon', 'F', 'Pink', 'Saree', 'OneSize');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0040', 'Sangria', 2300, 'Amazon', 'F', 'Yellow', 'Saree', 'OneSize');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0041', 'Anouk', 2300, 'Myntra', 'F', 'Green', 'Saree', 'OneSize');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0042', 'Tikhi', 1800, 'Myntra', 'F', 'Blue', 'Saree', 'OneSize');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0043', 'Silk Land', 3500, 'Myntra', 'F', 'Brown', 'Saree', 'OneSize');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0044', 'Kasee', 2800, 'Shein', 'F', 'Pink', 'Saree', 'OneSize');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0045', 'Pataudi', 1790, 'Shein', 'F', 'Red', 'Saree', 'OneSize');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0046', 'Zinzaraa', 980, 'Shein', 'F', 'Yellow', 'Saree', 'OneSize');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0047', 'Purvaja', 1200, 'Amazon', 'F', 'Red', 'Lehenga', 'M');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0048', 'Singaria', 2000, 'Amazon', 'F', 'Blue', 'Lehenga', 'L');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0049', 'Ode', 3500, 'Amazon', 'F', 'Green', 'Lehenga', 'M');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0050', 'Mitra', 4000, 'Myntra', 'F', 'Pink', 'Lehenga', 'XL');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0051', 'Sidhidta', 3800, 'Myntra', 'F', 'Yellow', 'Lehenga', 'S');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0052', 'Zeel', 1200, 'Myntra', 'F', 'Purple', 'Lehenga', 'M');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0053', 'Janasya', 1500, 'Shein', 'F', 'Red', 'Lehenga', 'M');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0054', 'Ishu', 2900, 'Shein', 'F', 'Pink', 'Lehenga', 'S');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0055', 'Kedarth', 3200, 'Shein', 'F', 'Brown', 'Lehenga', 'XL');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price,Store, Gender, Colour, Type, Size) VALUES ('0056', 'Rimeline', 1200, 'Amazon', 'F', 'Red', 'Kurta', 'S');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0057', 'Anouk', 480, 'Amazon', 'F', 'Pink', 'Kurta', 'M');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0058', 'Sangaria', 900, 'Amazon', 'F', 'Yellow', 'Kurta', 'XL');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0059', 'Pataudi', 1500, 'Myntra', 'F', 'Brown', 'Kurta', 'L');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0060', 'Indo', 2200, 'Myntra', 'F', 'Blue', 'Kurta', 'S');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0061', 'Nayo', 2400, 'Myntra', 'F', 'Purple', 'Kurta', 'M');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0062', 'Ode', 1000, 'Shein', 'F', 'Green', 'Kurta', 'L');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0063', 'Kedarth', 500, 'Shein', 'F', 'Blue', 'Kurta', 'XL');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0064', 'Kalini', 1400, 'Shein', 'F', 'Pink', 'Kurta', 'M');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0065', 'Saragni', 1800, 'Amazon', 'F', 'Blue', 'Salwar set', 'M');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0067', 'Ode', 1900, 'Amazon', 'F', 'Pink', 'Salwar set', 'L');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0068', 'Adanth', 1700, 'Amazon', 'F', 'Green', 'Salwar set', 'S');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0069', 'Indo', 2500, 'Myntra', 'F', 'Red', 'Salwar set', 'XL');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0070', 'Tithi', 800, 'Myntra', 'F', 'Yellow', 'Salwar set', 'M');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0071', 'Anouk', 480, 'Myntra', 'F', 'Black', 'Salwar set', 'L');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0072', 'Purvaja', 1900, 'Shein', 'F', 'Brown', 'Salwar set', 'S');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0073', 'Heman', 1700, 'Shein', 'F', 'Blue', 'Salwar set', 'M');",
                "INSERT INTO Ethnic (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('0074', 'Kalini', 1900, 'Shein', 'F', 'Green', 'Salwar set', 'XL')",
        };
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
            for (String q : insertQueries1) {
                stmt.executeUpdate(q);
            }

            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //executeSQL(query,insertQueries1);
    }

    public void loadEntriesHoodies() {
        String query = "CREATE TABLE IF NOT EXISTS Hoodies (ItemNo INT PRIMARY KEY, ItemName VARCHAR(60), Price INT, Store VARCHAR(40), Gender VARCHAR(10), Colour VARCHAR(30), Type VARCHAR(25), Size VARCHAR(10))";
        String[] insertQueries = {
                "INSERT INTO Hoodies (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('1001', 'Nike Sports Hoodie', 2500, 'Nike', 'M', 'Black', 'Pullover', 'M')",
                "INSERT INTO Hoodies (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('1002', 'Adidas Originals Hoodie', 3000, 'Adidas', 'M', 'White', 'Zipper', 'L')",
                "INSERT INTO Hoodies (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('1003', 'Puma Hoodie', 1800, 'Puma', 'M', 'Blue', 'Pullover', 'XL')",
                "INSERT INTO Hoodies (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('1004', 'H&M Casual Hoodie', 1200, 'H&M', 'M', 'Grey', 'Pullover', 'S')",
                "INSERT INTO Hoodies (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('1005', 'Levis Hoodie', 2200, 'Levis', 'F', 'Red', 'Zipper', 'M')",
                "INSERT INTO Hoodies (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('1006', 'Under Armour Hoodie', 3500, 'Under Armour', 'F', 'Pink', 'Pullover', 'L')",
                "INSERT INTO Hoodies (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('1007', 'Zara Oversized Hoodie', 2800, 'Zara', 'F', 'Green', 'Oversized', 'XL')",
                "INSERT INTO Hoodies (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('1008', 'Uniqlo Basic Hoodie', 1500, 'Uniqlo', 'M', 'White', 'Pullover', 'M')",
                "INSERT INTO Hoodies (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('1009', 'Gap Hoodie', 2000, 'Gap', 'M', 'Yellow', 'Pullover', 'L')",
                "INSERT INTO Hoodies (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('1010', 'Hollister Graphic Hoodie', 2700, 'Hollister', 'F', 'Blue', 'Zipper', 'S')",
                "INSERT INTO Hoodies (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('1011', 'Superdry Classic Hoodie', 3200, 'Superdry', 'M', 'Black', 'Pullover', 'XL')",
                "INSERT INTO Hoodies (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('1012', 'Tommy Hilfiger Hoodie', 4000, 'Tommy Hilfiger', 'F', 'Red', 'Zipper', 'M')",
                "INSERT INTO Hoodies (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('1013', 'Abercrombie Hoodie', 2900, 'Abercrombie', 'M', 'Grey', 'Pullover', 'L')",
                "INSERT INTO Hoodies (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('1014', 'Champion Hoodie', 1800, 'Champion', 'F', 'Purple', 'Pullover', 'S')",
                "INSERT INTO Hoodies (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES ('1015', 'Fila Vintage Hoodie', 2000, 'Fila', 'M', 'Green', 'Zipper', 'M')"
        };
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
            for (String q : insertQueries) {
                stmt.executeUpdate(q);
            }
            stmt.close();
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
        //executeSQL(query,insertQueries);

    }

    public void loadEntriesShirts() {
        String query = "CREATE TABLE IF NOT EXISTS Shirts " +
                "(ItemNo INT PRIMARY KEY, " +
                "ItemName VARCHAR(200), " +
                "Price INT, " +
                "Store VARCHAR(50), " +
                "Colour VARCHAR(50), " +
                "Size VARCHAR(5))";
        String[] insertqueries = new String[]{
                "INSERT INTO Shirts (ItemNo, ItemName, Price, Store, Colour, Size) VALUES (1031,'Fabfarm Linen Casual Spread Collar',1990,'Amazon','Blue','L')",
                "INSERT INTO Shirts (ItemNo, ItemName, Price, Store, Colour, Size) VALUES (1032,'Inkast Double pocket cotton shirt',699,'Amazon','Black','XL')",
                "INSERT INTO Shirts (ItemNo, ItemName, Price, Store, Colour, Size) VALUES (1033,'CB Colebrook casual button down shirt linen',474,'Amazon','Brown','M')",
                "INSERT INTO Shirts (ItemNo, ItemName, Price, Store, Colour, Size) VALUES (1034,'Indian Garage Co slim fit checkered casual shirt',612,'Amazon','White','S')",
                "INSERT INTO Shirts (ItemNo, ItemName, Price, Store, Colour, Size) VALUES (1035,'Dennis Lingo Solid slim fit casual shirt',699,'Amazon','Yellow','L')",
                "INSERT INTO Shirts (ItemNo, ItemName, Price, Store, Colour, Size) VALUES (1036,'U turn casual shirt printed striped',428,'Amazon','Pink','L')",
                "INSERT INTO Shirts (ItemNo, ItemName, Price, Store, Colour, Size) VALUES (1037,'Plaid print simple casual button up long sleeve shirt',1129,'Shein','Red','XL')",
                "INSERT INTO Shirts (ItemNo, ItemName, Price, Store, Colour, Size) VALUES (1038,'Manfinity NiteLife curved hip plaid shirt',1317,'Shein','Blue','M')",
                "INSERT INTO Shirts (ItemNo, ItemName, Price, Store, Colour, Size) VALUES (1039,'Manfinity collared striped shirt',1466,'Shein','White','S')",
                "INSERT INTO Shirts (ItemNo, ItemName, Price, Store, Colour, Size) VALUES (1040,'Highlander slim fit opaque casual shirt',335,'Myntra','Black','S')",
                "INSERT INTO Shirts (ItemNo, ItemName, Price, Store, Colour, Size) VALUES (1041,'The Bear House Slim Fit Cotton Concealed Placket Formal Shirt',1247,'Myntra','Brown','M')",
                "INSERT INTO Shirts (ItemNo, ItemName, Price, Store, Colour, Size) VALUES (1042,'Park Avenue Checked Cotton Formal Shirt',2499,'Myntra','Purple','XL')",
                "INSERT INTO Shirts (ItemNo, ItemName, Price, Store, Colour, Size) VALUES (1043,'Raymond Pure Cotton Slim Fit Formal Shirt',1218,'Myntra','Green','S')",
                "INSERT INTO Shirts (ItemNo, ItemName, Price, Store, Colour, Size) VALUES (1044,'Park Avenue Slim Fit Formal Shirt',764,'Myntra','Pink','L')",
                "INSERT INTO Shirts (ItemNo, ItemName, Price, Store, Colour, Size) VALUES (1045,'Raymond Slim Fit Pure Cotton Printed Formal Shirt',1165,'Myntra','Blue','M')"};

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            for (String q : insertqueries) {
                statement.executeUpdate(q);
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //executeSQL(query,insertqueries);

    }

    public void loadEntriesTShirts() {
        String createTShirtsTable = "CREATE TABLE IF NOT EXISTS TShirts (" +
                "ItemNo INT PRIMARY KEY, " +
                "ItemName VARCHAR(60), " +
                "Price INT, " +
                "Store VARCHAR(40), " +
                "Gender VARCHAR(10), " +
                "Colour VARCHAR(30), " +
                "Size VARCHAR(10))";
        String[] tshirtsEntries = {
                "INSERT INTO TShirts VALUES (201, 'Levis Graphic Tee', 1200, 'Amazon', 'M', 'Red', 'M')",
                "INSERT INTO TShirts VALUES (202, 'Tommy Hilfiger Tee', 2100, 'Amazon', 'M', 'Navy', 'L')",
                "INSERT INTO TShirts VALUES (203, 'Adidas Performance Tee', 1500, 'Amazon', 'M', 'Black', 'XL')",
                "INSERT INTO TShirts VALUES (204, 'Nike Casual Tee', 1180, 'Amazon', 'F', 'Pink', 'S')",
                "INSERT INTO TShirts VALUES (205, 'Puma Sports Tee', 1130, 'Amazon', 'F', 'Blue', 'M')",
                "INSERT INTO TShirts VALUES (206, 'HRX Active Tee', 1000, 'Myntra', 'M', 'Grey', 'M')",
                "INSERT INTO TShirts VALUES (207, 'H&M Regular Fit Tee', 1110, 'Myntra', 'F', 'Yellow', 'L')",
                "INSERT INTO TShirts VALUES (208, 'Zara Slim Fit Tee', 1450, 'Myntra', 'M', 'White', 'S')",
                "INSERT INTO TShirts VALUES (209, 'Roadster Solid Tee', 900, 'Myntra', 'F', 'Green', 'M')",
                "INSERT INTO TShirts VALUES (210, 'Mango Casual Tee', 1200, 'Myntra', 'F', 'Black', 'XL')",
                "INSERT INTO TShirts VALUES (211, 'Shein Print Tee', 800, 'Shein', 'F', 'Yellow', 'M')",
                "INSERT INTO TShirts VALUES (212, 'Shein V-Neck Tee', 900, 'Shein', 'F', 'Red', 'S')",
                "INSERT INTO TShirts VALUES (213, 'Shein Crop Tee', 700, 'Shein', 'F', 'Pink', 'L')",
                "INSERT INTO TShirts VALUES (214, 'Shein Basic Tee', 600, 'Shein', 'M', 'Blue', 'XL')",
                "INSERT INTO TShirts VALUES (215, 'Shein Oversized Tee', 1185, 'Shein', 'M', 'Grey', 'M')"
        };
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(createTShirtsTable);
            for (String query : tshirtsEntries)
                stmt.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //executeSQL(createTShirtsTable,tshirtsEntries);
    }

    public void loadEntriesTops() {
        String topsQuery = "CREATE TABLE IF NOT EXISTS Tops (ItemNo INT PRIMARY KEY, ItemName VARCHAR(200), price INT, store VARCHAR(50), colour VARCHAR(50), size VARCHAR(5))";

        String[] topsInserts = new String[]{
                "INSERT INTO Tops (ItemNo, ItemName, Price, Store, Colour, Size) VALUES (1016,'Sheetal casual puff sleeves floral print top',275,'Amazon','Black','L')",
                "INSERT INTO Tops (ItemNo, ItemName, price, store, colour, size) VALUES (1017,'Greciilooks long shirt top',409,'Amazon','Green','XL')",
                "INSERT INTO Tops (ItemNo, ItemName, price, store, colour, size) VALUES (1018,'Vastravibes regular fit ',426,'Amazon','Pink','M')",
                "INSERT INTO Tops (ItemNo, ItemName, price, store, colour, size) VALUES (1019,'Siril georgette regular fit top',349,'Amazon','Blue','S')",
                "INSERT INTO Tops (ItemNo, ItemName, price, store, colour, size) VALUES (1020,'Rytras cotton printed regular fit',479,'Amazon','Yellow','L')",
                "INSERT INTO Tops (ItemNo, ItemName, price, store, colour, size) VALUES (1021,'Shein EZwear Buttoned Front Lettuced Trim knit top',773,'Shein','Blue','XL')",
                "INSERT INTO Tops (ItemNo, ItemName, price, store, colour, size) VALUES (1022,'Essense mock neck rib knit top',529,'Shein','Green','M')",
                "INSERT INTO Tops (ItemNo, ItemName, price, store, colour, size) VALUES (1023,'SHEIN Mock Neck Drop Shoulder Crop Top',1491,'Shein','Brown','S')",
                "INSERT INTO Tops (ItemNo, ItemName, price, store, colour, size) VALUES (1024,'SHEIN EZwear Solid Crop Rib-knit Tank Top',490,'Shein','Red','L')",
                "INSERT INTO Tops (ItemNo, ItemName, price, store, colour, size) VALUES (1025,'Floral Print Self-Tie Wrap Crop Top',535,'Shein','White','S')",
                "INSERT INTO Tops (ItemNo, ItemName, price, store, colour, size) VALUES (1026,'Anouk ethnic cuban collar top',699,'Myntra','Brown','M')",
                "INSERT INTO Tops (ItemNo, ItemName, price, store, colour, size) VALUES (1027,'Dress Berry global floral dainty top',1025,'Myntra','Blue','XL')",
                "INSERT INTO Tops (ItemNo, ItemName, price, store, colour, size) VALUES (1028,'Trendyol striped off shoulder top',959,'Myntra','Red','S')",
                "INSERT INTO Tops (ItemNo, ItemName, price, store, colour, size) VALUES (1029,'Sassafras high neck cropped top',419,'Myntra','Black','L')",
                "INSERT INTO Tops (ItemNo, ItemName, price, store, colour, size) VALUES (1030,'Dress Berry round neck three quarter sleeves top',464,'Myntra','Pink','M')"
        };
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(topsQuery);
            for (String q : topsInserts) {
                statement.executeUpdate(q);
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //executeSQL(topsQuery,topsInserts);

    }

    public static void main(String[] args) {
        //LoadingEntries obj=new LoadingEntries(connection)
        LoadingEntries obj=new LoadingEntries();

        obj.loadEntriesBottoms();
        obj.loadEntriesCustomer();
        obj.loadEntriesDresses();
        obj.loadEntriesEthnic();
        obj.loadEntriesHoodies();
        obj.loadEntriesTops();
        obj.loadEntriesShirts();
        obj.loadEntriesTShirts();
    }
}




/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class LoadingEntries {
    private static Connection connection;

    public LoadingEntries() {
        String url = "jdbc:mysql://localhost:3306/SHOPPING";
        String username = "root";
        String password = "Shreiya.2805";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established successfully");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL Connection Error: " + e.getMessage());
            e.printStackTrace(); // Print the full error
        }
    }


    public  void loadEntriesBottoms() {
        if (connection == null) {
            System.out.println("Database connection is not established.");
            return;
        }

        String bottomsQuery = "CREATE TABLE IF NOT EXISTS bottoms (" +
                "ItemNo INT PRIMARY KEY, " +
                "ItemName VARCHAR(200), " +
                "Price INT, " +
                "Store VARCHAR(40), " +
                "Gender VARCHAR(10), " +
                "Colour VARCHAR(30), " +
                "Type VARCHAR(25), " +
                "Size VARCHAR(10))";

        String[] bottomsInserts = {
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES (101, 'DaMensch Bermudas', 1690, 'Myntra', 'M', 'Grey', 'Shorts', 'M')",
                "INSERT INTO bottoms (ItemNo, ItemName, Price, Store, Gender, Colour, Type, Size) VALUES (601, 'Max White Palazzo', 600, 'Myntra', 'F', 'White', 'Palazzos', 'M')"
        };

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(bottomsQuery);
            for (String q : bottomsInserts) {
                try {
                    statement.executeUpdate(q);
                } catch (SQLException e) {
                    System.out.println("Error inserting data: " + e.getMessage());
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
    }

    public void loadEntriesCustomer() {
        if (connection == null) {
            System.out.println("Database connection is not established.");
            return;
        }

        String query = "CREATE TABLE IF NOT EXISTS CustomerDetails (" +
                "CustomerId INT AUTO_INCREMENT PRIMARY KEY, " +
                "UserName VARCHAR(20) UNIQUE, " +
                "Password VARCHAR(20), " +
                "CustomerName VARCHAR(200), " +
                "PhoneNo VARCHAR(20) UNIQUE, " +
                "Location VARCHAR(500), " +
                "Email VARCHAR(150) UNIQUE)";
        String query1 = "ALTER TABLE CustomerDetails AUTO_INCREMENT = 100";

        String[] insertQueries = {
                "INSERT INTO CustomerDetails (UserName, Password, CustomerName, PhoneNo, Location, Email) VALUES " +
                        "('apat1245','abcde','Andrew Patrick','91 98765 43210', 'Bangalore, Karnataka','a.patrick.1234@gmail.com')"
        };

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
            statement.executeUpdate(query1);
            for (String q : insertQueries) {
                try {
                    statement.executeUpdate(q);
                } catch (SQLException e) {
                    System.out.println("Duplicate entry error: " + e.getMessage());
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        LoadingEntries obj=new LoadingEntries();

        obj.loadEntriesBottoms();
    }
}
*/