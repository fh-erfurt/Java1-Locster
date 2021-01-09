public class FriendlistItem {

    /*
    =========================
    == FriendlistItem Class Attributes
    =========================
    */

    private User friend;
    private long friendSince; // https://stackoverflow.com/questions/732034/getting-unixtime-in-java

    /*
    ===================================
    == FriendlistItem Constructors & Destructors
    ===================================
    */

    public FriendlistItem(User friend)
    {
        this.friend = friend;
        this.friendSince = getUnixTime();
    }

    /*
    ===================================
    ==  FriendlistItem Getter & Setter
    ===================================
    */

    public User getFriend() {
        return friend;
    }

    public void setFriend(User friend) {
        this.friend = friend;
    }

    public long getFriendSince() {
        return friendSince;
    }

    public void setFriendSince(long friendSince) {
        this.friendSince = friendSince;
    }

    /*
    ==================
    == FriendlistItem Functions
    ==================
    */

    private long getUnixTime() {
        return System.currentTimeMillis() / 1000L;
    }
}
