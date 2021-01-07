public class AccountDetails
{
    private int userID;
    private String username;
    private String mailadress;
    private String password;

    /*
       ===================================
       Constructor
       ===================================
       */

    public AccountDetails(int userID, String username, String mailadress, String password)
    {
        this.userID = userID;
        this.username = username;
        this.mailadress = mailadress;
        this.password = password;
    }

    public void changeUserName(String newusername)
    {
        this.username = newusername;
    }

    public void changeMailadress(String newmailadress)
    {
        this.mailadress = newmailadress;
    }

    public void changePassword(String newpassword)
    {
        this.password = newpassword;
    }

    /*
       ===================================
       Getter & Setter
       ===================================
       */
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMailadress() {
        return mailadress;
    }

    public void setMailadress(String mailadresse) {
        this.mailadress = mailadresse;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
