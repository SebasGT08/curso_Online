package ec.edu.ups.userapp.repository;

import ec.edu.ups.userapp.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}