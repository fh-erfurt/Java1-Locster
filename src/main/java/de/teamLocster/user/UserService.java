package de.teamLocster.user;

import de.teamLocster.core.BaseService;
import de.teamLocster.core.errors.UserAlreadyExistException;
import de.teamLocster.enums.OnlineStatus;
import de.teamLocster.enums.PrivacyStatus;
import de.teamLocster.enums.Sex;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

@Slf4j
@Service
public class UserService extends BaseService<User>
{
    UserRepository userRepository;

    PasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    // TODO return User?
    public void registerNewUser(SignupUser userDto) throws UserAlreadyExistException
    {
        // TODO NULL CHECK
        if ( userRepository.findByEmailAddress(userDto.getEmailAddress()) != null) {
            throw new UserAlreadyExistException("There already exists an account with that email address: " + userDto.getEmailAddress());
        }
        try {
            User userToRegister = new User(
                    userDto.getEmailAddress(),
                    encoder.encode(userDto.getPassword()),
                    userDto.getFirstName(),
                    userDto.getLastName(),
                    null,
                    Timestamp.valueOf(userDto.getBirthday() + " 00:00:00"),
                    null,
                    null,
                    userDto.getSex(),
                    "pseudo/path",
                    "Apparently, this user prefers to keep an air of mystery about them.",
                    "Hey, I'm using Locster!",
                    PrivacyStatus.PRIVATE,
                    OnlineStatus.ONLINE,
                    false
            );

            userRepository.save(userToRegister);
        }
        catch (Exception e) {
            // TODO LOGGING handle timestamp error better
            System.out.println("EXCEPTION  |  " + e.toString());
        }
    }

    public List<User> whoIsOnline() {
        return userRepository.findByIsOnlineTrue();
    }

    public List<PublicUser> whoIsOnlinePublic() {
        List<PublicUser> onlineUsers = new ArrayList<>();
        for(User user : userRepository.findByIsOnlineTrue()) {
            onlineUsers.add(new PublicUser(user));
        }
        return onlineUsers;
    }
}
