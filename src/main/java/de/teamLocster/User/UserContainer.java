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

    /**
     * Checks each param before the user add to users
     * @param firstName first name of user
     * @param lastName last name of user
     * @param userName user name of user
     * @param email email address of user
     * @param password password of user
     * @param birthdate birthdate of user
     * @param sex sex of user
     * @throws EmailException throws exception when email string misses an @ character
     * @throws PasswordException throws exception when the password string is in conflict
     * with the following constraints: Minimum eight characters, at least one uppercase letter,
     * one lowercase letter, one number and one special character
     * @throws UserNameException throws exception when the length of the user name is less then 5
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

    /**
     * Iterates the users array and put every active user in a new list
     * @return ArrayList of all activeUser
     */
    public ArrayList<User> activeUsers()
    {
        ArrayList<User> activeUser = new ArrayList<User>();
        for (User user : this.users)
        {
            if (user.getOnlineStatus() == User.OnlineStatus.online)
            {
                activeUser.add(user);
            }
        }
        return activeUser;
    }

    /**
     * drops a user out of the user container
     * @param userToDelete user that should be delete
     */
    public void deleteUser(User userToDelete)
    {
        this.users.removeIf(user -> user == userToDelete);
    }

    /**
     * Is the email address not valid or already taken, the function throws an exception
     * @param email email address of user
     * @throws EmailException throws exception when email string misses an @ character
     */
    private void checkEmail(String email) throws EmailException
    {
        if (ValidationUtility.isValidEmail(email))
        {
             if (ValidationUtility.stringAlreadyExistInArray(email, this.getEntireEmailOfAllUsers()))
                {
                    throw new EmailException("Email already exist!");
                }
        }
        else
        {
            throw new EmailException("Invalid Email!");
        }
    }

    /**
     * Is the password not valid, the function throws an exception
     * @param password password of user
     * @throws PasswordException throws exception when the password string is in conflict
     * with the following constraints: Minimum eight characters, at least one uppercase letter,
     * one lowercase letter, one number and one special character
     */
    private void checkPassword(String password) throws PasswordException // TODO: checkPassword might be extendend in future with more validations (next semester)
    {
        if (!ValidationUtility.isValidPassword(password))
        {
            throw new PasswordException("Invalid Password!");
        }
    }

    /**
     * Is the username not valid, the function throws an exception
     * @param username user name of user
     * @throws UserNameException throws exception when the length of the user name is less then 5
     */
    private void checkUsername(String username) throws UserNameException // TODO: checkPassword might be extendend in future with more validations (next semester)
    {
        if(!ValidationUtility.isValidUsername(username))
        {
            throw new UserNameException("Invalid Username!");
        }
    }

    /**
     * Checks the email address is valid or already taken and set the new email address of the user
     * @param user user that email address should be change
     * @param newEmail new email address
     */
    public void changeEmail(User user, String newEmail) //TODO: has to move to AccountDetails (next semester)
    {
        this.checkEmail(newEmail);

        user.getAccountDetails().setMailAddress(newEmail);
    }

    /**
     * Checks the password is valid and set the new password of the user
     * @param user user that password should be change
     * @param newPassword new password
     */
    public void changePassword(User user, String newPassword) //TODO: has to move to AccountDetails (next semester)
    {
        this.checkPassword(newPassword);

        user.getAccountDetails().setPassword(newPassword);
    }

    /**
     * Checks the username is valid and set the new password of the user
     * @param user user that password should be change
     * @param newUsername new user name
     */
    public void changeUsername(User user, String newUsername) //TODO: has to move to AccountDetails (next semester)
    {
        this.checkUsername(newUsername);

        user.getAccountDetails().setUsername(newUsername);
    }

    /**
     * generates an ArrayList of email addresses from all users
     * @return email adresses from all users
     */
    public ArrayList<String> getEntireEmailOfAllUsers() //TODO: it can possibly move to it's own UserContainerUtility class (next semester)
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
    == Getter & Setter
    ===================================
    */
    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

}
