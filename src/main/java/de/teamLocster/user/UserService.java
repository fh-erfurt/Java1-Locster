package de.teamLocster.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootApplication
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add); // todo refactor
        return users;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
}
