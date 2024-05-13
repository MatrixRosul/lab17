import java.sql.*;

public class ContactDAO {
    public void addContact(String name, String phoneNumber, String email) {
        String query = "INSERT INTO contacts (name, phone_number, email) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, name);
            statement.setString(2, phoneNumber);
            statement.setString(3, email);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public void updateContact(int id, String name, String phoneNumber, String email) {
        String query = "UPDATE contacts SET name = ?, phone_number = ?, email = ? WHERE id = ?";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setString(2, phoneNumber);
            statement.setString(3, email);
            statement.setInt(4, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteContact(int id) {
        String query = "DELETE FROM contacts WHERE id = ?";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void displayContacts() {
        String query = "SELECT * FROM contacts";

        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement statement = conn.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            System.out.println("Contacts:");
            System.out.println("ID\tName\tPhone Number\tEmail");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");

                System.out.println(id + "\t" + name + "\t" + phoneNumber + "\t" + email);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
