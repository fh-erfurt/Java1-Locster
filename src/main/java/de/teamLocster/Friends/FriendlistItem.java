/*
===================================
Dirk Hofmann
===================================
*/
package de.teamLocster.Friends;
import de.teamLocster.User.User;

import java.time.LocalDateTime;

public class FriendlistItem
{

    /*
    =========================
    Variables
    =========================
    */

    private User friend;
    private LocalDateTime friendSince;

    /*
    ===================================
    Constructors
    ===================================
    */

    public FriendlistItem(User friend)
    {
        this.friend = friend;
        this.friendSince = LocalDateTime.now();
    }

    /*
    ===================================
    Getter & Setter
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

}
