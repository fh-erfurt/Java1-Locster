/*
===================================
== Molham Al-khodari
== Jakob Gensel
== Matthias Gabel
===================================
*/
package de.teamLocster.User;


import de.teamLocster.Chat.Chat;
import de.teamLocster.Friends.FriendList;
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
    private FriendList friendList;
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
        this.friendList        = new FriendList();
        this.guestbook         = new Guestbook();
        this.profileText       = new ProfileText();
        this.chats             = new ArrayList<Chat>();
        this.blockedUsers      = new ArrayList<User>();
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
     * updates the statistics of both users
     * @param visitedUser the user that should be visit
     */
    public void visitUser(User visitedUser)
    {
        visitedUser.getProfileStatistic().updateLastVisitors(this);

        this.getProfileStatistic().updateLastVisits(visitedUser);
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

    public FriendList getFriendlist() {
        return friendList;
    }

    public void setFriendlist(FriendList friendList) {
        this.friendList = friendList;
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
