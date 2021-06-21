package de.teamLocster.user;

import de.teamLocster.core.BaseRepository;
import de.teamLocster.core.BaseService;
import de.teamLocster.enums.OnlineStatus;
import de.teamLocster.enums.PrivacyStatus;
import de.teamLocster.enums.Sex;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

@Slf4j
@Service
public class UserService extends BaseService<User>
{
    SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);

    @Autowired
    public UserService(BaseRepository<User> userRepository)
    {
        super(userRepository);
    }

    public List<User> findAllUsers() {
        List<User> users = new ArrayList<>();
        repository.findAll().forEach(users::add); // todo refactor
        return users;
    }

    public Long saveUser(User user) {
        return repository.save(user).getId();
    }

    public boolean registerNewUser(
            String firstName,
            String lastName,
            String birthday,
            String gender,
            String email,
            String password
    ) {
        try {
            // TODO passwortsicherheit und andere anforderungen prüfen DEFAULT VALUES IN ENUMS
            // city (required?)
            // occupation (required?)
            // beziehungsstatus (required?)
            // sex (select? default?)
            // privatssphäre (default?)
            // onlinestatus (default?)
            User userToRegister = new User(
                    email,
                    Integer.toString(password.hashCode()),
                    firstName,
                    lastName,
                    null,
                    formatter.parse(birthday),
                    null,
                    null,
                    "männlich".equals(gender) ? Sex.MALE : Sex.FEMALE, // TODO
                    "pseudo/path",
                    "Apparently, this user prefers to keep an air of mystery about them.",
                    "Hey, I'm using Locster!",
                    PrivacyStatus.PRIVATE, // TODO
                    OnlineStatus.ONLINE,
                    new HashSet<>()
            );

            Long id = saveUser(userToRegister);

            // TODO LOGGING
            // User result = findBy(id).get();
            //System.out.println(result.getBirthDay());
            return true;
        }
        catch (Exception e) {

            // TODO LOGGING
            System.out.println("EXCEPTION  |  " + e.toString());
            for (StackTraceElement el : e.getStackTrace()) {
                System.out.println(el.toString());
            }
            return false;
        }
    }
}
