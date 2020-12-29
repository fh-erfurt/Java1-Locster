/*
===================================
== Molham Al-khodari    24.12.2020
===================================
*/

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
    private Chat[] messenger;
    private User[] blockedUsers;

    /*
    ===================================
    == User Constructors & Destructors
    ===================================
    */

    public User(PersonalInfo personalInfo, ProfileStatistic profileStatistic, AccountDetails accountDetails,
                String status, Friendlist friendlist, Guestbook guestbook, ProfileText profileText, Chat[] messenger,
                User[] blockedUsers)
    {
        this.personalInfo       = personalInfo;
        this.profileStatistic   = profileStatistic;
        this.accountDetails     = accountDetails;
        this.status             = status;
        this.friendlist         = friendlist;
        this.guestbook          = guestbook;
        this.profileText        = profileText;
        this.messenger          = messenger;     // what about ENUM here?
        this.blockedUsers       = blockedUsers;
    }

    public User()
    {
        // if we need a constructor without parameters
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

    public Chat[] getMessenger() {
        return messenger;
    }

    public void setMessenger(Chat[] messenger) {
        this.messenger = messenger;
    }

    public User[] getBlockedUsers() {
        return blockedUsers;
    }

    public void setBlockedUsers(User[] blockedUsers) {
        this.blockedUsers = blockedUsers;
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

}
