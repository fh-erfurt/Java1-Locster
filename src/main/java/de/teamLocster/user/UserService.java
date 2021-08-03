package de.teamLocster.user;

import de.teamLocster.core.BaseService;
import de.teamLocster.core.errors.UserAlreadyExistException;
import de.teamLocster.core.errors.UserNotFoundException;
import de.teamLocster.enums.OnlineStatus;
import de.teamLocster.enums.PrivacyStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.*;

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

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    // TODO return User?
    public void registerNewUser(SignupUser userDto) throws UserAlreadyExistException
    {
        // TODO NULL CHECK
        if ( userRepository.findByEmailAddress(userDto.getEmailAddress()).isPresent()) {
            throw new UserAlreadyExistException("There already exists an account with that email address: " + userDto.getEmailAddress());
        }
        try {
            User userToRegister = new User(
                    userDto.getEmailAddress(),
                    encoder.encode(userDto.getPassword()),
                    userDto.getFirstName(),
                    userDto.getLastName(),
                    null,
                    LocalDate.parse(userDto.getBirthday()),
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

    /*
    public void updateUser( SignupUser userDto){
        return userService.getUserByEmailAddress(newUser.getEmailAddress())
                .map(user -> {
                    user.setFirstname(newUser.getFirstname());
                    user.setLastname(newUser.getLastname());
                    user.setDob(newUser.getDob());
                    user.setEmail(newUser.getEmail());
                    user.setPhone(newUser.getPhone());
                    return userRepository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return userRepository.save(newUser);
                });
    }

     */

        /*
    public void updateUserInfo(User user) {
        try {
            user = new User(
                    user.getEmailAddress(),
                    encoder.encode(user.getPasswordHash()),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getRegion(),
                    LocalDate.parse(user.getBirthDay()),
                    user.getOccupation(),
                    null,
                    user.getSex(),
                    "pseudo/path",
                    "Apparently, this user prefers to keep an air of mystery about them.",
                    "Hey, I'm using Locster!",
                    PrivacyStatus.PRIVATE,
                    OnlineStatus.ONLINE,
                    false
            );

            userRepository.save(user);
        }
        catch (Exception e) {
            System.out.println("EXCEPTION  |  " + e.toString());
        }
    }

     */

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

    public User getUserByEmailAddress(String emailAddress) throws UserNotFoundException {
        Optional<User> data = userRepository.findByEmailAddress(emailAddress);
        if(data.isPresent()) {
            return data.get();
        }
        throw new UserNotFoundException("No user with this email address was found in the database!");
    }

    public void deleteUser(Long userId) throws UserNotFoundException {
        boolean exists = userRepository.existsById(userId);
        if(!exists) {
            throw new UserNotFoundException("User with id " + userId + " does not exists");
        }
        userRepository.deleteById(userId);

    }

    @Transactional
    public void updateUserInSetting(Long userId, String email, String password) throws UserNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User with id " + userId + " dose not exist"));

                if (email != null && email.length() > 0 && !Objects.equals(user.getEmailAddress(),email)) {
                    Optional<User> userOptional = userRepository.findByEmailAddress(email);
                    if(userOptional.isPresent()) {
                        throw new UserNotFoundException("email taken");
                    }
            user.setEmailAddress(email);
        }
                /* das stimmt nicht */
                if (password != null && password.length() > 0) {
                    user.setPasswordHash(password);
                }

    }

    public void updateUser(User user) {

        userRepository.save(user);
    }
}
