package ec.edu.ups.userapp.service;

import ec.edu.ups.userapp.model.User;
import ec.edu.ups.userapp.repository.UserRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User validateUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    public User updateUser(String id, User updatedUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(updatedUser.getUsername());
                    user.setPassword(updatedUser.getPassword());
                    // Copia otras propiedades necesarias
                    return userRepository.save(user);
                })
                .orElseGet(() -> {
                    updatedUser.setId(id);
                    return userRepository.save(updatedUser);
                });
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
