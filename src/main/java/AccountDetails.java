/*
===================================
== Matthias Gabel
===================================
*/
public class AccountDetails
{
    /*
   ===================================
   == Variable
   ===================================
   */
    private String username;
    private String mailAddress;
    private String password;
    /*
   ===================================
   == Constructor
   ===================================
   */
    public AccountDetails(String username, String mailaddress, String password)
    {
        this.username = username;
        this.mailAddress = mailaddress;
        this.password = password;
    }
    /*
   ===================================
   == Methods
   ===================================
   */
    public void changeUserName(String newUsername)
    {
        this.username = newUsername;
    }

    public void changeMailaddress(String newMailAddress)
    {
        this.mailAddress = newMailAddress;
    }

    public void changePassword(String newPassword)
    {
        this.password = newPassword;
    }

    /*
   ===================================
   == Getter & Setter
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

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
