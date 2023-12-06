package ec.edu.ups.assignmentsapp.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "courses")
public class Course {
    
    @Id
    private String id;
    private String name;
    private String description;
    private String category;

    public Course() {
        // Constructor por defecto necesario para Spring Data
    }

    public Course(String id, String name, String description, String category ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
    }

    // Getters y setters para id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Getters y setters para name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getters y setters para description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getters y setters para category
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // Método toString() para representar el objeto como cadena
    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category +
                '}';
    }
}