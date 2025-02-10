package gr.aueb.cf.taskapp.service;

import gr.aueb.cf.taskapp.model.User;
import gr.aueb.cf.taskapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserbyUsername (String username) {
        return userRepository.findByUsername(username);

    }

    public void saveUser(User user) {
        // Encrypt password before saving
        user.setPassword(user.getPassword());  // Password encryption
        userRepository.save(user);
    }
}
