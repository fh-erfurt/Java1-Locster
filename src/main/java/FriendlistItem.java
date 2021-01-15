/*
===================================
== Dirk Hofmann
===================================
*/

import java.time.LocalDateTime;

public class FriendlistItem
{

    /*
    =========================
    == FriendlistItem Class Attributes
    =========================
    */

    private User friend;
    private LocalDateTime friendSince;

    /*
    ===================================
    == FriendlistItem Constructors & Destructors
    ===================================
    */

    public FriendlistItem(User friend)
    {
        this.friend = friend;
        this.friendSince = LocalDateTime.now();
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

    public LocalDateTime getFriendSince() {
        return friendSince;
    }

    public void setFriendSince(LocalDateTime friendSince) { this.friendSince = friendSince; }

    /*
    ==================
    == FriendlistItem Functions
    ==================
    */
}
