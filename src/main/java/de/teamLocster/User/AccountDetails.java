package de.teamLocster.User;

public class AccountDetails
{
    private int userID;
    private String username;
    private String mailAddress;
    private String password;

    /*
       ===================================
       Constructor
       ===================================
       */

    public AccountDetails(String username, String mailAddress, String password)
    {
        this.username = username;
        this.mailAddress = mailAddress;
        this.password = password;
    }

    public void changeUserName(String newusername)
    {
        this.username = newusername;
    }

    public void changeMailadress(String newmailadress)
    {
        this.mailAddress = newmailadress;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailadresse) {
        this.mailAddress = mailadresse;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
