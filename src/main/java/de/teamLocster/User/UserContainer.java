package de.teamLocster.User;/*
===================================
== Matthias Gabel
===================================
*/

import de.teamLocster.Exceptions.EmailException;
import de.teamLocster.Exceptions.PasswordException;
import de.teamLocster.User.PersonalInfo;
import de.teamLocster.User.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserContainer
{
    /*
    ===================================
    == Variable
    ===================================
    */
    private ArrayList<User> users;
    /*
    ===================================
    == Constructor
    ===================================
    */
    public UserContainer()
    {
        users = new ArrayList<User>();
    }
    /*
    ===================================
    == Methods
    ===================================
    */
    public void registerUser(String firstName, String lastName, String userName, String email,
                             String password, Date Birthdate, PersonalInfo.sex sex) throws EmailException, PasswordException
    {
        if (!this.checkEmail(email))
        {
            throw new EmailException("Invalid Email!");
        }

        if (!this.checkPassword(password)) {
            throw new PasswordException("Invalid Password!");
        }

        final User user = new User(firstName, lastName, userName, email, password, Birthdate, sex, PersonalInfo.relationshipStatus.married);

        this.users.add(user);
    }

    public ArrayList<User> activeUsers()
    {
        ArrayList<User> activeUser = new ArrayList<User>();
        for (User user : this.users) // for-each user in users
        {
            if (user.getOnlineStatusFlag() == User.onlineStatus.online)
            {
                activeUser.add(user);
            }
        }
        return activeUser;
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
        String minimum = "8";
        String specialCharacter = "@$!%*?&";

        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*["+specialCharacter+"])[A-Za-z\\d"+specialCharacter+"]{"+minimum+",}$";

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
