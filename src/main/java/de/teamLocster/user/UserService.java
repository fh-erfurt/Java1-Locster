package de.teamLocster.user;

import de.teamLocster.actions.ActionRepository;
import de.teamLocster.core.BaseService;
import de.teamLocster.core.errors.UserAlreadyExistException;
import de.teamLocster.core.errors.UserNotFoundException;
import de.teamLocster.enums.OnlineStatus;
import de.teamLocster.enums.PrivacyStatus;
import de.teamLocster.enums.RelationshipStatus;
import de.teamLocster.guestbook.GuestbookEntryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserService extends BaseService<User>
{
    @Autowired
    UserRepository userRepository;
    @Autowired
    GuestbookEntryRepository guestbookEntryRepository;
    @Autowired
    ActionRepository actionRepository;

    PasswordEncoder encoder = new BCryptPasswordEncoder();

    // TODO return User?
    public void registerNewUser(SignupUser userDto) throws UserAlreadyExistException {
        if (userRepository.findByEmailAddress(userDto.getEmailAddress()).isPresent()) {
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
                    RelationshipStatus.NOT_SPECIFIED,
                    userDto.getSex(),
                    "images/profilePic.png",
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
        return userRepository.findByIsOnlineTrueAndOnlineStatus(OnlineStatus.ONLINE);
    }

    public List<User> search(String query) {
        return userRepository.findAllByKey(query);
    }


    public User getUserByEmailAddress(String emailAddress) throws UserNotFoundException {
        Optional<User> data = userRepository.findByEmailAddress(emailAddress);
        if(data.isPresent()) return data.get();
        throw new UserNotFoundException("No user with this email address was found in the database!");
    }

    public User getUserById(Long id) throws UserNotFoundException {
        Optional<User> data = userRepository.findById(id);
        if(data.isPresent()) return data.get();
        throw new UserNotFoundException("No user with this id was found in the database!");
    }

    public void deleteUser(String email) throws UserNotFoundException, IOException {
        boolean exists = userRepository.findByEmailAddress(email).isPresent();
        if(!exists) {
            throw new UserNotFoundException("User with email " + email + " does not exists");
        }
        User user = getUserByEmailAddress(email);
        guestbookEntryRepository.deleteAll(guestbookEntryRepository.findByUserId(user.getId()));
        guestbookEntryRepository.deleteAll(guestbookEntryRepository.findByCreatorId(user.getId()));
        actionRepository.deleteAll(actionRepository.findByActorId(user.getId()));
        actionRepository.deleteAll(actionRepository.findByAffectedId(user.getId()));
        FileUploadUtilities.deleteFile(user.getProfilePicture());

        userRepository.deleteById(user.getId());
    }

    public void updateUser(String userEmail, SettingsUser userDto, MultipartFile multipartFile) throws UserNotFoundException, UserAlreadyExistException {

        if (!userEmail.equals(userDto.getEmailAddress()) && userRepository.findByEmailAddress(userDto.getEmailAddress()).isPresent()) {
            throw new UserAlreadyExistException("There already exists an account with that email address: " + userDto.getEmailAddress());
        }
        User user = getUserByEmailAddress(userEmail);

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setRegion(userDto.getRegion());
        user.setBirthDay(LocalDate.parse(userDto.getBirthday()));
        user.setSex(userDto.getSex());
        user.setOccupation(userDto.getOccupation());
        user.setRelationshipStatus(userDto.getRelationshipStatus());
        user.setEmailAddress(userDto.getEmailAddress());
        user.setRelationshipStatus(userDto.getRelationshipStatus());
        user.setPersonalStatus(userDto.getPersonalStatus());
        user.setOnlineStatus(userDto.getOnlineStatus());

        String password = userDto.getPassword();
        if(password != null && !password.isEmpty()) user.setPasswordHash(encoder.encode(password));

        if(!multipartFile.isEmpty()) {
            try {
                String filename = "picture-" + user.getId() + "." + StringUtils.getFilenameExtension(multipartFile.getOriginalFilename());
                FileUploadUtilities.saveFile(filename, multipartFile);
                user.setProfilePicture("/profile-picture/" + filename);
            } catch(IOException ioException) {
                //TODO Do whatever you want :P
            }
        }

        userRepository.save(user);
    }

    public void login(String email) throws UserNotFoundException {
        User user = getUserByEmailAddress(email);
        user.setIsOnline(true);
        userRepository.save(user);
    }

    public void logout(String email) {
        try
        {
            User user = getUserByEmailAddress(email);
            user.setIsOnline(false);
            userRepository.save(user);
        }
        catch (UserNotFoundException ignored) {}
    }
    
    public void updateProfileText(String userEmail, ProfileTextUser userDto) throws UserNotFoundException, UserAlreadyExistException {

        User user = getUserByEmailAddress(userEmail);
        user.setProfileText(userDto.getProfileText());
        userRepository.save(user);
    }

}
