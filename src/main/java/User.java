/*
===================================
== edited by
== Molham Al-khodari
== Jakob Gensel
== Matthias Gabel
===================================
*/

import java.util.ArrayList;     // new code

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
    private String personalStatus;          // new name
    private privacyStatus privacyStatusFlag;             // new code
    private onlineStatus onlineStatusFlag;
    private Friendlist friendlist;
    private Guestbook guestbook;
    private ProfileText profileText;
    private Chat[] messenger;
    private User[] blockedUsers;
    ArrayList<User> BlockUserList = new ArrayList<User>();  // create a block list ?????    // new code

    /*
    ===================================
    == User Constructors & Destructors
    ===================================
    */

    public User(PersonalInfo personalInfo, AccountDetails accountDetails,
                Friendlist friendlist, ProfileText profileText, Chat[] messenger,
                User[] blockedUsers) {
        this.personalInfo = personalInfo;
        this.accountDetails = accountDetails;
        this.messenger = messenger;
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
        BlockUserList.add(user);
    }

    public void deleteBlockUser(User user) {
        BlockUserList.remove(user);
    }

    public void changePrivacyStatusFlag(User.privacyStatus status) {
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

    public void setPrivacyStatusFlag(User.privacyStatus privacyStatusFlag) {
        this.privacyStatusFlag = privacyStatusFlag;
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
        return BlockUserList;
    }

    public void setBlockUserList(ArrayList<User> blockUserList) {
        BlockUserList = blockUserList;
    }
}
