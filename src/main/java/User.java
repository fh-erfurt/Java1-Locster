/*
===================================
== Molham Al-khodari    03.01.2020
===================================
*/

import java.sql.Timestamp;
import java.util.ArrayList;     // new code
import java.util.Date;

// Create a User class
public class User {

    /*
    =========================
    == ENUM class User
    =========================
    */

    enum statusFlag {
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
    private statusFlag onlineStatus;
    private Friendlist friendlist;
    private Guestbook guestbook;
    private ProfileText profileText;
    private Chat[] messenger;
    private User[] blockedUsers;
    private ArrayList<User> blockUserList;

    /*
    ===================================
    == User Constructors & Destructors
    ===================================
    */

    public User(String firstName, String lastName, String userName, String email, String password, Date birthdate, PersonalInfo.sex sex)
    {
         this.accountDetails    = new AccountDetails(userName, email, password);
         this.personalInfo      = new PersonalInfo(firstName, lastName, birthdate, sex);

         this.profileStatistic  = new ProfileStatistic();
         this.personalStatus    = "Hey I'm using Locster";
         this.friendlist        = new Friendlist();
         this.guestbook         = new Guestbook();
         this.profileText       = new ProfileText();
         this.messenger         = null;
         this.blockedUsers      = null;
         this.blockUserList     = new ArrayList<User>();
    }

    public User() {
        // if we need a constructor without parameters
    }

    /*
    ==================
    == User functions       // new code
    ==================
    */

    public void addBlockUser(User user) {
        blockUserList.add(user);
    }

    public void deleteBlockUser(User user) {
        blockUserList.remove(user);
    }

    public void changePrivacyFlag(statusFlag status) {
        switch (status) {
            case online:
                status = statusFlag.online;
                System.out.println(status);
                break;
            case absent:
                status = statusFlag.absent;
                System.out.println(status);
                break;
            case offline:
                status = statusFlag.offline;
                System.out.println(status);
                break;
        }
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

    public statusFlag getStatus() {
        return onlineStatus;
    }

    public void setStatus(statusFlag onlineStatus) {
        this.onlineStatus = onlineStatus;
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

    public ArrayList<User> getBlockUserList() {
        return blockUserList;
    }

    public void setBlockUserList(ArrayList<User> blockUserList) {
        blockUserList = blockUserList;
    }
}
