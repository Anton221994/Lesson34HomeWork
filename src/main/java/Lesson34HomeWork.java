import java.sql.*;

public class Lesson34HomeWork {
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String login = "postgres";
    private static final String password = "7193";


    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement statement = null;

        connection = DriverManager.getConnection(url, login, password);
        statement = connection.createStatement();

        String firstNameUser = "Ivan";
        String lastNameUser = "Ivanov";

         deletePetByOwner(firstNameUser, lastNameUser, statement);

    }

    public static void deletePetByOwner(String firstName, String lastName, Statement statement) {
        try {
            String searchUser = "select * from users where first_name = '" + firstName + "'" +
                    " and last_name = '" + lastName + "'";
            ResultSet resultSetUser = statement.executeQuery(searchUser);
            Owner owner = new Owner();
            while (resultSetUser.next()) {
                owner.setId(resultSetUser.getLong(1));
                owner.setFirstName(resultSetUser.getString(2));
                owner.setLastName(resultSetUser.getString(3));
            }
            String pet = "select * from pets where owner_id = '" + owner.getId() + "'";
            ResultSet resultSetPet = statement.executeQuery(pet);
            Pet pets = new Pet();
            while (resultSetPet.next()) {
                pets.setName(resultSetPet.getString(2));

            }
            String deletePetAndUser = " delete from pets where owner_id =  '" + owner.getId() + "';\n" +
                    " delete from users where first_name = '" + firstName + "' and last_name = '" + lastName + "'";

            statement.executeUpdate(deletePetAndUser);

            System.out.println("Владелец по имени " + firstName + " " + lastName + " был удален вместе со своими питомцами " +
                    pets.getName());
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }


}
