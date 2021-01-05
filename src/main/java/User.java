/*
===================================
== Molham Al-khodari    24.12.2020
== Jakob Gensel         05.01.2020
===================================
*/

import java.util.ArrayList;

// Create a User class
public class User
{

    /*
    =========================
    == ENUM class User
    =========================
    */

    enum privacyFlag
    {
        global,
        friends,
        nobody
    }

    /*
    =========================
    == User Class Attributes
    =========================
    */

    private PersonalInfo personalInfo;          // PersonalInfo     class still missing
    private ProfileStatistic profileStatistic;  // ProfileStatistic class still missing
    private AccountDetails accountDetails;      // AccountDetails   class still missing
    private String status;
    private Friendlist friendlist;
    private Guestbook guestbook;
    private ProfileText profileText;
    private ArrayList<Chat> chats;
    private ArrayList<User> blockedUsers;

    /*
    ===================================
    == User Constructors & Destructors
    ===================================
    */

    public User(PersonalInfo personalInfo, ProfileStatistic profileStatistic, AccountDetails accountDetails,
                String status, Friendlist friendlist, Guestbook guestbook, ProfileText profileText, ArrayList<Chat> messenger,
                ArrayList<User> blockedUsers)
    {
        this.personalInfo       = personalInfo;
        this.profileStatistic   = profileStatistic;
        this.accountDetails     = accountDetails;
        this.status             = status;
        this.friendlist         = friendlist;
        this.guestbook          = guestbook;
        this.profileText        = profileText;
        this.chats = messenger;     // what about ENUM here?
        this.blockedUsers       = blockedUsers;
    }

    public User()
    {
        // if we need a constructor without parameters
    }

    /*
    ==================
    == User functions
    ==================
    */

    public void addBlockUser(User user)
    {
        // do something
    }

    public void deleteBlockUser()
    {
        // do something
    }

    public void changePrivacyFlag()
    {
        // do something
    }

    /*
    ==========================
    == User setter und getter
    ==========================
    */

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    public ProfileStatistic getProfileStatistic() {
        return profileStatistic;
    }

    public void setProfileStatistic(ProfileStatistic profileStatistic) {
        this.profileStatistic = profileStatistic;
    }

    public AccountDetails getAccountDetails() {
        return accountDetails;
    }

    public void setAccountDetails(AccountDetails accountDetails) {
        this.accountDetails = accountDetails;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Friendlist getFriendlist() {
        return friendlist;
    }

    public void setFriendlist(Friendlist friendlist) {
        this.friendlist = friendlist;
    }

    public Guestbook getGuestbook() {
        return guestbook;
    }

    public void setGuestbook(Guestbook guestbook) {
        this.guestbook = guestbook;
    }

    public ProfileText getProfileText() {
        return profileText;
    }

    public void setProfileText(ProfileText profileText) {
        this.profileText = profileText;
    }

    public ArrayList<Chat> getChats() {
        return chats;
    }

    public void setChats(ArrayList<Chat> chats) {
        this.chats = chats;
    }

    public ArrayList<User> getBlockedUsers() {
        return blockedUsers;
    }

    public void setBlockedUsers(ArrayList<User> blockedUsers) {
        this.blockedUsers = blockedUsers;
    }

}
