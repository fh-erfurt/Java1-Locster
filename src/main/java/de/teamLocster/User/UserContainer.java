/*
===================================
== Matthias Gabel
===================================
*/
package de.teamLocster.User;

import de.teamLocster.Exceptions.EmailException;
import de.teamLocster.Exceptions.PasswordException;
import de.teamLocster.Exceptions.UserNameException;
import de.teamLocster.Utility.ValidationUtility;

import java.util.ArrayList;
import java.util.Date;

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
                             String password, Date birthdate, PersonalInfo.Sex sex) throws EmailException, PasswordException, UserNameException
    {
        this.checkEmail(email);

        this.checkPassword(password);

        this.checkUsername(userName);

        final User user = new User(firstName, lastName, userName, email, password, birthdate, sex);

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

    public void deleteUser(User userToDelete)
    {
        this.users.removeIf(user -> user == userToDelete);
    }

    public boolean checkEmail(String email) throws EmailException//TODO: access modifier may have to be changed
    {
        if (ValidationUtility.isValidEmail(email))
        {
             if (!ValidationUtility.stringAlreadyExistInArray(email, this.getEntireEmailOfAllUsers()))
                {
                    return true;
                }
             else
             {
                 throw new EmailException("Email already exist!");
             }
        }
        else
        {
            throw new EmailException("Invalid Email!");
        }
    }

    public boolean checkPassword(String password) throws PasswordException // TODO: checkPassword might be extendend in future with more validations (next semester)
    {
        if (ValidationUtility.isValidPassword(password))
        {
            return true;
        }
        else
        {
            throw new PasswordException("Invalid Password!");
        }
    }

    public boolean checkUsername(String username) throws UserNameException // TODO: checkPassword might be extendend in future with more validations (next semester)
    {
        if(ValidationUtility.isValidUsername(username))
        {
            return true;
        }
        else
        {
            throw new UserNameException("Invalid Username!");
        }
    }


    public void changeEmail(User user, String newEmail) //TODO: has to move to AccountDetails
    {
        this.checkEmail(newEmail);

        user.getAccountDetails().setMailAddress(newEmail);
    }

    public void changePassword(User user, String newPassword) //TODO: has to move to AccountDetails
    {
        this.checkPassword(newPassword);

        user.getAccountDetails().setPassword(newPassword);
    }

    public void changeUsername(User user, String newUsername) //TODO: has to move to AccountDetails
    {
        this.checkUsername(newUsername);

        user.getAccountDetails().setUsername(newUsername);
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
