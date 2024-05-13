import java.sql.SQLException;
import java.util.Scanner;
import java.sql.*;
import java.io.*;

public class Main {
    private static String URL;
    private static String USERNAME;
    private static String PASSWORD;

    public static void main(String[] args) throws IOException {
        env_load(".env");
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            Scanner scanner = new Scanner(System.in);
            ContactDAO contactDAO = new ContactDAO();
            boolean running = true;

            while (running) {
                getHelp();
                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        System.out.println("Enter name:");
                        String name = scanner.nextLine();
                        System.out.println("Enter phone number:");
                        String phoneNumber = scanner.nextLine();
                        System.out.println("Enter email:");
                        String email = scanner.nextLine();
                        contactDAO.addContact(name, phoneNumber, email);
                        break;
                    case "2":
                        System.out.println("Enter contact ID to update:");
                        int idToUpdate;
                        try {
                            idToUpdate = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid ID format. Please enter a valid integer ID.");
                            return;
                        }
                        System.out.println("Enter new name:");
                        String newName = scanner.nextLine();
                        System.out.println("Enter new phone number:");
                        String newPhoneNumber = scanner.nextLine();
                        System.out.println("Enter new email:");
                        String newEmail = scanner.nextLine();
                        contactDAO.updateContact(idToUpdate, newName, newPhoneNumber, newEmail);
                        break;
                    case "3":
                        System.out.println("Enter contact ID to delete:");
                        int idToDelete = Integer.parseInt(scanner.nextLine());
                        contactDAO.deleteContact(idToDelete);
                        break;
                    case "4":
                        contactDAO.displayContacts();
                        break;
                    case "5":
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void env_load(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank() || line.startsWith("#")) {
                    continue;
                }

                String[] parts = line.split("=");
                String key = parts[0].trim();
                String value = parts[1].trim();
                switch (key) {
                    case "URL":
                        URL = value;
                        break;
                    case "USERNAME":
                        USERNAME = value;
                        break;
                    case "PASSWORD":
                        PASSWORD = value;
                        break;
                }
            }
        } catch (IOException e) {
            throw new IOException("Error reading .env file: " + e.getMessage());
        }
    }

    private static void getHelp() {
        System.out.println("Choose an option:");
        System.out.println("1. Add contact");
        System.out.println("2. Update contact");
        System.out.println("3. Delete contact");
        System.out.println("4. Display contacts");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }
}
