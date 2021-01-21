/*
===================================
Dirk Hofmann
===================================
*/
package de.teamLocster.Friends;

import de.teamLocster.User.User;


public class FriendRequest
{

    /*
    =========================
    Variable
    =========================
    */

    private User receiver;
    private User sender;

    /*
    ===================================
    Constructors
    ===================================
    */

    public FriendRequest(User receiver, User sender)
    {
        this.receiver = receiver;
        this.sender = sender;
    }

    /*
    ===================================
    ==  de.teamLocster.Friends.FriendRequest Getter & Setter
    ===================================
    */

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }
}
