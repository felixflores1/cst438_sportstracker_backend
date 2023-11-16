import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean authenticateUser(String username, String password) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        return optionalUser.map(user -> passwordEncoder.matches(password, user.getPassword())).orElse(false);
    }

    public boolean registerUser(String username, String password) {
        // Check if the username is already taken
        if (userRepository.findByUsername(username).isPresent()) {
            return false; // Username is already taken
        }

        // Encode the password before saving it to the database
        String encodedPassword = passwordEncoder.encode(password);

        // Create a new user entity
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(encodedPassword);

        // Save the new user to the database
        userRepository.save(newUser);

        return true; // User registration successful
    }
}
