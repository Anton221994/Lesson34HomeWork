import java.sql.DriverManager;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static java.nio.file.Files.getOwner;

public class Lesson34 {
    private final static String url = "jdbc:postgresql://localhost:5432/postgres";
    private final static String username = "postgres";
    private final static int password = 7193;


    public static void main(String[] args) throws Exception {
        Connection connection = null;
        Statement statement = null;

        connection = DriverManager.getConnection(url, username, String.valueOf(password));
        statement = connection.createStatement();

//        createTableUser(statement);
//        createTablePets(statement);


        //Задание 2 создать 3 хозяев и 5 зверушек, данные принимаем с клавиатуры
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter name");
//        String name = scanner.nextLine();
//        System.out.println("Enter lastname");
//        String lastName = scanner.nextLine();
//
//        String query = "insert into users (first_name,last_name) values " +
//                "('" + name + "', '" + lastName + "')";
//        statement.execute(query);


        //создать 5 зверей
//        Scanner scanner1 = new Scanner(System.in);
//        System.out.println("Enter pet_name");
//        String name1 = scanner1.nextLine();
//        System.out.println("Enter pet type");
//        String petType = scanner1.nextLine();
//        System.out.println("Enter pet age");
//        int age = scanner1.nextInt();
//        System.out.println("Enter pet weight");
//        int weight = scanner1.nextInt();
//        System.out.println("Enter owner id");
//        long owner_id = scanner1.nextLong();
//
//        String query1 = "insert into pets (name,pet_type,age,weight,owner_id) values " +
//                "('" + name1 + "', '" + petType + "','" + age + "','" + weight + "','" + owner_id + "')";
//        statement.execute(query1);

        //Задание 2: Вводим имя и фамилия хозяина и находим всех его питомцев. Сделать с помощью ооп.
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter owner Name");
//        String name = scanner.nextLine();
//        System.out.println("Enter owner lastName");
//        String lastName = scanner.nextLine();
//
//        getPetByOwner(name, lastName, statement);
//

    }

        //Задание 3: Найти всех животных которые пренадлежат владельцу по имени.
//    public static void getPetByOwner(String name, String lastName, Statement statement)  {
//        try {
//            String searchUser = "select * from users where first_name ='" + name + "' and last_name = '"
//                    + lastName + "'";
//            ResultSet resultSetUser = statement.executeQuery(searchUser);
//            Owner owner = new Owner();
//
//            while (resultSetUser.next()) {
//                owner.setId(resultSetUser.getLong(1));
//                owner.setFirstName(resultSetUser.getString(2));
//                owner.setLastName(resultSetUser.getString(3));
//            }
//
//            String searchPet = "select * from pets where owner_id = '" + owner.getId() + "'";
//            ResultSet resulSetPet = statement.executeQuery(searchPet);
//
//            List<Pet> listOfPet = new ArrayList<>();
//
//            while (resulSetPet.next()) {
//                Pet pets = new Pet();
//                pets.setId(resulSetPet.getLong(1));
//                pets.setName(resulSetPet.getString(2));
//                pets.setType(resulSetPet.getString(3));
//                pets.setAge(resulSetPet.getInt(4));
//                pets.setWeight(resulSetPet.getInt(5));
//                pets.setOwnerId(resulSetPet.getLong(6));
//
//                listOfPet.add(pets);
//            }
//
//            System.out.println("Владельцу " + owner.getFirstName() + " " + owner.getLastName() + " " +
//                    "Принадлежат следующие животные " + listOfPet);
//        } catch (Exception e) {
//            System.out.println("getPetByOwner ERROR!!");
//            throw new RuntimeException(e);
//        }
//

//    }

//    public static void getPet(long id, Statement statement) throws SQLException {
//        String searchPet = "select * from pets where owner_id ='" + id + "'";
//        ResultSet resultSet = statement.executeQuery(searchPet);
//        while (resultSet.next()) {
//            Pet pet = new Pet();
//            pet.setId(resultSet.getLong(1));
//            pet.setName(resultSet.getString(2));
//            pet.setType(resultSet.getString(3));
//            pet.setAge(resultSet.getInt(4));
//            pet.setWeight(resultSet.getDouble(5));
//
//        }
//
//    }


    //Задание 1
    //написать фуункцию, которая создает таблицу домашние животные, в ней поля -
    // айди, имя зверушки, тип, возраст, вес, айди хозяина

    //таблица хозяин, в ней поля: айди, имя, фамилия

    public static void createTableUser(Statement statement) throws SQLException {
        String sql = "create table users (" +
                "id serial," +
                "first_name varchar(50)," +
                "last_name varchar(50))";
        statement.executeUpdate(sql);
    }

    public static void createTablePets(Statement statement) throws SQLException {
        String sql = "create table pets (" +
                "id serial," +
                "name varchar(50)," +
                "pet_type varchar(50)," +
                "age int," +
                "weight int," +
                "owner_id bigint)";
        statement.executeUpdate(sql);
    }
}

