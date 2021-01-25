/*
===================================
== edited by
== Molham Al-khodari
== Jakob Gensel
== Matthias Gabel
===================================
*/
package de.teamLocster.User;


import de.teamLocster.Chat.Chat;
import de.teamLocster.Friends.Friendlist;
import de.teamLocster.Guestbook.Guestbook;

import java.util.ArrayList;
import java.util.Date;


public class User {

    /*
    =========================
    == ENUM class User
    =========================
    */

    enum PrivacyStatus
    {
        global,
        friends,
        nobody
    }
    enum OnlineStatus
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
    private PrivacyStatus privacyStatus;
    private OnlineStatus onlineStatus;
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

    public User(String firstName, String lastName, String userName, String email, String password, Date birthdate, PersonalInfo.Sex sex)
    {
        this.accountDetails    = new AccountDetails(userName, email, password);
        this.personalInfo      = new PersonalInfo(firstName, lastName, birthdate, sex);

        this.privacyStatus     = PrivacyStatus.nobody;
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
        this.personalInfo       = new PersonalInfo("Max", "Mustermann", new Date(1999, 3,2), PersonalInfo.Sex.male, PersonalInfo.RelationshipStatus.no_information);
        this.profileStatistic   = new ProfileStatistic();
        this.accountDetails     = new AccountDetails("MaMu257", "max.mustermann@fh-email.de", "PW123456");
        this.personalStatus     = "";
        this.privacyStatus      = PrivacyStatus.global;
        this.onlineStatus       = OnlineStatus.online;
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


    /**
     *
     * toString It is called when a user outputs to the console, thus ensuring legible display and meaningful information
     */

    public String toString()
    {
        return "User{'" + personalInfo.getFirstName() + " " + personalInfo.getLastName() + "'}";
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

    public String getPersonalStatus() {
        return personalStatus;
    }

    public void setPersonalStatus(String personalStatus) {
        this.personalStatus = personalStatus;
    }

    public PrivacyStatus getPrivacyStatus() {
        return privacyStatus;
    }

    public void setPrivacyStatus(PrivacyStatus privacyStatus) { this.privacyStatus = privacyStatus; }

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

    public OnlineStatus getOnlineStatus()
    {
        return onlineStatus;
    }

    public void setOnlineStatus(OnlineStatus onlineStatus)
    {
        this.onlineStatus = onlineStatus;
    }
}
