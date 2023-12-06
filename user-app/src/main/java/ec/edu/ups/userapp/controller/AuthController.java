package ec.edu.ups.userapp.controller;

import ec.edu.ups.userapp.model.User;
import ec.edu.ups.userapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User loginDetails) {
        User user = userService.validateUser(loginDetails.getUsername(), loginDetails.getPassword());
        if (user != null) {
            return ResponseEntity.ok().body(user);
        }
        return ResponseEntity.status(401).build(); // No autorizado
    }

}
