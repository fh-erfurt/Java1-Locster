package de.teamLocster.User;/*
===================================
== Matthias Gabel
===================================
*/

import de.teamLocster.Exceptions.EmailException;
import de.teamLocster.Exceptions.PasswordException;
import de.teamLocster.Utility.ValidationUtility;

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
                             String password, Date Birthdate, PersonalInfo.Sex sex) throws EmailException, PasswordException
    {
        if (!this.checkEmail(email))
        {
            throw new EmailException("Invalid Email!");
        }

        if (!this.checkPassword(password)) {
            throw new PasswordException("Invalid Password!");
        }

        final User user = new User(firstName, lastName, userName, email, password, Birthdate, sex);

        this.users.add(user);
    }

    public ArrayList<User> activeUsers()
    {
        ArrayList<User> activeUser = new ArrayList<User>();
        for (User user : this.users) // for-each user in users
        {
            if (user.getOnlineStatus() == User.OnlineStatus.online)
            {
                activeUser.add(user);
            }
        }
        return activeUser;
    }

    public void deleteUser(User userToDelete)//TODO: have to do
    {
        this.users.removeIf(user -> user == userToDelete);
    }

    public ArrayList<User> getUserList() //TODO: have to do
    {
        return this.users;
    }

    public void sortBy()
    {
        // TODO: Add functionality
    }

    public boolean checkEmail(String email)//TODO: access modifier may have to be changed
    {
        if (ValidationUtility.isValidEmail(email)
             && !ValidationUtility.stringAlreadyExistInArray(email, this.getEntireEmailOfAllUsers()))
        {
            return true;
        }

        return false;
    }

    public boolean checkPassword(String password) // TODO: checkPassword might be extendend in future with more validations (next semester)
    {
        if (ValidationUtility.isValidPassword(password))
        {
            return true;
        }
        return false;
    }

    public ArrayList<String> getEntireEmailOfAllUsers()
    {
        ArrayList<String> StringContainer = new ArrayList<String>();

        for (User user : this.users)
        {
            StringContainer.add(user.getAccountDetails().getMailAddress());
        }

        return StringContainer;
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
