import java.util.ArrayList;

public class UserContainer
{

    private ArrayList<User> users;

    public UserContainer()
    {
        users = new ArrayList<User>();
    }

    public void registerUser()
    {
        User user = new User();

        users.add(user);
    }

    public ArrayList<User> getAktivUser()
    {
        ArrayList<User> usersUsers = new ArrayList<User>();
        for (User user : users) // for-each user in users
        {
            if (user.getStatus() == 'online')
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
