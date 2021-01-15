/*
===================================
== edited by
== Molham Al-khodari
== Jakob Gensel
== Matthias Gabel
===================================
*/

import java.util.ArrayList;     // new code
import java.util.Date;

// Create a User class
public class User {

    /*
    =========================
    == ENUM class User
    =========================
    */

    enum privacyStatus
    {
        global,
        friends,
        nobody
    }
    enum onlineStatus
    {
        online,
        absent,
        offline
    }

    /*
    =========================
    == User Class Attributes
    =========================
    */

    private PersonalInfo personalInfo;
    private ProfileStatistic profileStatistic;
    private AccountDetails accountDetails;
    private String personalStatus;
    private privacyStatus privacyStatusFlag;
    private onlineStatus onlineStatusFlag;
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

    public User(String firstName, String lastName, String userName, String email, String password, Date birthdate, PersonalInfo.sex sex, PersonalInfo.relationshipStatus relationshipStatus)
    {
        this.accountDetails    = new AccountDetails(userName, email, password);
        this.personalInfo      = new PersonalInfo(firstName, lastName, birthdate, sex, relationshipStatus);

        this.profileStatistic  = new ProfileStatistic();
        this.personalStatus    = "Hey I'm using Locster";
        this.friendlist        = new Friendlist();
        this.guestbook         = new Guestbook();
        this.profileText       = new ProfileText();
        this.chats             = new ArrayList<Chat>();
        this.blockedUsers      = new ArrayList<User>();
    }

    /**
     * THIS CONSTRUCTOR SHOULD ONLY BE USED FOR TESTING
     */
    private User() {
        this.personalInfo       = new PersonalInfo("Max", "Mustermann", new Date(1999, 3,2), PersonalInfo.sex.male, PersonalInfo.relationshipStatus.no_information);
        this.profileStatistic   = new ProfileStatistic();
        this.accountDetails     = new AccountDetails("MaMu257", "max.mustermann@fh-email.de", "PW123456");
        this.personalStatus     = "";
        this.privacyStatusFlag  = privacyStatus.global;
        this.onlineStatusFlag   = onlineStatus.online;
        this.friendlist         = new Friendlist();
        this.guestbook          = new Guestbook();
        this.profileText        = new ProfileText();
        this.chats              = new ArrayList<Chat>();
        this.blockedUsers       = new ArrayList<User>();
    }

    /*
    ==================
    == User functions
    ==================
    */

    public void addBlockUser(User user) { blockedUsers.add(user);  }

    public void deleteBlockUser(User user) {
        blockedUsers.remove(user);
    }

    public void changePrivacyStatusFlag(User.privacyStatus status) { // TODO  warum switch case?
        switch (status) {
            case global:
                this.privacyStatusFlag = User.privacyStatus.global;
                System.out.println(status);
                break;
            case friends:
                this.privacyStatusFlag = User.privacyStatus.friends;
                System.out.println(status);
                break;
            case nobody:
                this.privacyStatusFlag = User.privacyStatus.nobody;
                System.out.println(status);
                break;
        }
    }

    public static User getNewUserForTesting()
    {
        return new User();
    }

     /*
    ==========================
    == User setter und getter           // new code
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

    public String getPersonalStatus() {
        return personalStatus;
    }

    public void setPersonalStatus(String personalStatus) {
        this.personalStatus = personalStatus;
    }

    public User.privacyStatus getPrivacyStatusFlag() {
        return privacyStatusFlag;
    }

    public void setPrivacyStatusFlag(User.privacyStatus privacyStatusFlag) { this.privacyStatusFlag = privacyStatusFlag; }

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

    public ArrayList<User> getBlockedUsers() {
        return blockedUsers;
    }

    public void setBlockedUsers(ArrayList<User> blockedUsers) {
        this.blockedUsers = blockedUsers;
    }

    public onlineStatus getOnlineStatusFlag()
    {
        return onlineStatusFlag;
    }

    public void setOnlineStatusFlag(onlineStatus onlineStatusFlag)
    {
        this.onlineStatusFlag = onlineStatusFlag;
    }
}
