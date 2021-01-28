/*
===================================
== Matthias Gabel
== Molham Al-khodari
===================================
*/
package de.teamLocster.User;

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

    public AccountDetails(String username, String mailAddress, String password)
    {
        this.username = username;
        this.mailAddress = mailAddress;
        this.password = password;
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
