package pl.coderslab.users;

import org.mindrot.jbcrypt.BCrypt;
import pl.coderslab.users.User;
import pl.coderslab.utils.DbUtil;

import java.awt.print.Book;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class UserDAO {

    private static final String CREATE_USER_QUERY = "INSERT INTO workshop3.users(username, email, password) VALUES (?, ?, ?);";
    private static final String SELECT_USER_QUERY = "SELECT username, email, password FROM workshop3.users WHERE id=?;";
    private static final String UPDATE_USER_QUERY = "UPDATE workshop3.users SET username=?, email=?, password=? WHERE id=?;";
    private static final String DELETE_USER_QUERY = "DELETE FROM workshop3.users where id = ?";
    private static final String SELECT_USER_PASSWORD_QUERY = "SELECT password FROM workshop3.users WHERE username=?;";
    private static final String SELECT_USERNAME_QUERY = "SELECT username FROM workshop3.users WHERE username=?;";
    private static final String SELECT_EMAIL_QUERY = "SELECT email FROM workshop3.users WHERE email=?;";


    public User create(User user) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement =
                    conn.prepareStatement(CREATE_USER_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getEmail());
            statement.setString(3, hashPassword(user.getPassword()));
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean isPasswordValid(String username, String password){
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement =
                    conn.prepareStatement(SELECT_USER_PASSWORD_QUERY);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                if(BCrypt.checkpw(password,resultSet.getString("password"))){
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public User read(int userId){
        User user = new User();
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement =
                    conn.prepareStatement(SELECT_USER_QUERY);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user.setId(userId);
                user.setUserName(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(User user){
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement =
                    conn.prepareStatement(UPDATE_USER_QUERY);
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getEmail());
            statement.setString(3, hashPassword(user.getPassword()));
            statement.setInt(4, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int userId){
        try (Connection conn = DbUtil.getConnection()){
            PreparedStatement statement =
                    conn.prepareStatement(DELETE_USER_QUERY);
            statement.setInt(1, userId);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User[] findAll(){
        String dbSize="SELECT * FROM workshop3.users ORDER BY id;";
        try (Connection conn = DbUtil.getConnection()) {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(dbSize);
            User[] users = new User[0];
            while(rs.next()) {
                int id = rs.getInt("id");
                User user = new User();
                user.setId(id);
                user.setUserName(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                addToArray(user,users);
                System.out.println(read(id).toString());
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private User[] addToArray(User u, User[] users) {
        User[] tmpUsers = Arrays.copyOf(users, users.length + 1);
        tmpUsers[users.length] = u;
        return tmpUsers;
    }

    public void deleteAll(){
        String deleteAll="DELETE FROM workshop3.users;;";
        try (Connection conn = DbUtil.getConnection()) {
            Statement statement = conn.createStatement();
            statement.executeUpdate(deleteAll);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printAll(){
        try(Connection conn = DbUtil.getConnection()) {
            String selectAll = "SELECT id, username, email FROM workshop3.users";
            Statement statement = conn.createStatement();
            ResultSet resultSetMovie = statement.executeQuery(selectAll);
            System.out.printf("%3s | %30s | %30s%n", "id", "username", "email");
            while (resultSetMovie.next()) {
                int id = resultSetMovie.getInt("id");
                String username = resultSetMovie.getString("username");
                String email = resultSetMovie.getString("email");
                System.out.printf("%3s | %30s | %30s%n", id, username, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<User> findAllArray(){
        String dbSize="SELECT * FROM workshop3.users ORDER BY id;";
        try (Connection conn = DbUtil.getConnection()) {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(dbSize);
            ArrayList<User> users = new ArrayList<User>();
            while(rs.next()) {
                int id = rs.getInt("id");
                User user = new User();
                user.setId(id);
                user.setUserName(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                users.add(user);
                System.out.println(read(id).toString());
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean verifyEmail(String email){
        return email.matches("[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.([a-zA-Z]{2,}){1}");
    }

    public boolean isEmailAvailable(String username){
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement =
                    conn.prepareStatement(SELECT_EMAIL_QUERY);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                    return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean isUsernameAvailable(String email){
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement =
                    conn.prepareStatement(SELECT_USERNAME_QUERY);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

}

