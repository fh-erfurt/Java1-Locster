package de.teamLocster.Friends;/*
===================================
== Dirk Hofmann
===================================
*/
import de.teamLocster.User.User;

import java.time.LocalDateTime;

public class FriendlistItem
{

    /*
    =========================
    == de.teamLocster.Friends.FriendlistItem Class Attributes
    =========================
    */

    private User friend;
    private LocalDateTime friendSince;

    /*
    ===================================
    == de.teamLocster.Friends.FriendlistItem Constructors & Destructors
    ===================================
    */

    public FriendlistItem(User friend)
    {
        this.friend = friend;
        this.friendSince = LocalDateTime.now();
    }

    /*
    ===================================
    ==  de.teamLocster.Friends.FriendlistItem Getter & Setter
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
    == de.teamLocster.Friends.FriendlistItem Functions
    ==================
    */
}
