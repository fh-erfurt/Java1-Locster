/*
===================================
Matthias Gabel
===================================
*/

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserContainer
{

    private ArrayList<User> users;
    private int userID = 0;

    public UserContainer()
    {
        users = new ArrayList<User>();
    }

    public void registerUser(String firstName, String lastName, String userName, String email, String password, Date Birthdate, PersonalInfo.sex sex)
    {
        userID++;

        if (!this.checkEmail(email))
        {
            //todo throw("Invalid Email");
        }

        if (!this.checkPassword(password))
        {
            //todo throw("Invalid Password.");
        }

        User user = new User(userID, firstName, lastName, userName, email, password, Birthdate, sex);

        users.add(user);
    }

    public ArrayList<User> getAktivUser()
    {
        ArrayList<User> usersUsers = new ArrayList<User>();
        for (User user : users) // for-each user in users
        {
            if (user.getStatus() == User.statusFlag.online)
            {
                usersUsers.add(user);
            }
        }
        return usersUsers;
    }

    public void deleteUser(User userToDelete)
    {
        users.removeIf(user -> user == userToDelete);
    }

    public ArrayList<User> getUserList()
    {
        return this.users;
    }

    public void sortBy()
    {
        // TODO: Add functionality
    }

    private boolean checkEmail(String email)
    {
        //Minimum one @
        String regex = "^(.+)@(.+)$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean checkPassword(String password)
    {   //Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }


    /*
    ===================================
    Getter & Setter
    ===================================
    */
    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}
