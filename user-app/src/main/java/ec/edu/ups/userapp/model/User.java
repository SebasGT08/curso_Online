package ec.edu.ups.userapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String username;
    private String password;

    public User() {
        // Constructor por defecto necesario para Spring Data
    }

    public User(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    // Getters y setters para id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Getters y setters para username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getters y setters para password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Método toString() para representar el objeto como cadena
    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
