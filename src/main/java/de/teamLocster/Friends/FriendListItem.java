/*
===================================
== Dirk Hofmann
===================================
*/
package de.teamLocster.Friends;
import de.teamLocster.User.User;

import java.time.LocalDateTime;

public class FriendListItem implements Comparable<FriendListItem>
{

    /*
    =========================
    == Variables
    =========================
    */

    private User friend;
    private LocalDateTime friendSince;

    /*
    ===================================
    == Constructors
    ===================================
    */

    public FriendListItem(User friend)
    {
        this.friend = friend;
        this.friendSince = LocalDateTime.now();
    }

    /*
    ===================================
    == Getter & Setter
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

    /**
     * Compares two entries from FriendListItem by friendSince
     * @param other == Entry to be compared to
     * @return -1 if this < other, 1 if this < other, 0 if this == other
     */
    @Override
    public int compareTo(FriendListItem other)
    {
        return this.friendSince.compareTo(other.friendSince);
    }
}
