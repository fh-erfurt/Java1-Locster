/*
===================================
== Dirk Hofmann
===================================
*/
package de.teamLocster.Friends;

import de.teamLocster.User.User;
import de.teamLocster.Exceptions.FriendlistException;

import java.util.ArrayList;

public class Friendlist
{

    /*
    =========================
    == de.teamLocster.Friends.Friendlist Class Attributes
    =========================
    */

    private ArrayList<FriendlistItem> acceptedFriends = new ArrayList<FriendlistItem>(); // accepted friends are stored here
    private ArrayList<FriendRequest> waitingFriends = new ArrayList<FriendRequest>();   // waiting requests are stored here

    /*
    ===================================
    == de.teamLocster.Friends.Friendlist Constructors & Destructors
    ===================================
    */

    public Friendlist() {
    }

    /*
    ===================================
    ==  de.teamLocster.Friends.Friendlist Getter & Setter
    ===================================
    */

    /**
     * Getter acceptedFriends
     * @return ArrayList 'acceptedFriends'
     */
    public ArrayList<FriendlistItem> getAcceptedFriends() { return acceptedFriends; }

    /**
     * Getter acceptedFriends with index
     * @param index
     * @return entry with index from ArrayList 'acceptedFriends'
     */
    public FriendlistItem getAcceptedFriendWithIndex(int index) { return this.acceptedFriends.get(index); }

    /**
     * Setter acceptedFriends
     * @param acceptedFriends
     */
    public void setAcceptedFriends(ArrayList<FriendlistItem> acceptedFriends) { this.acceptedFriends = acceptedFriends; }

    /**
     * Getter waitingFriends
     * @return ArrayList 'waitingFriends'
     */
    public ArrayList<FriendRequest> getWaitingFriends() { return waitingFriends; }

    /**
     * Getter waitingFriends with index
     * @param index
     * @return entry with index from ArrayList 'waitingFriends'
     */
    public FriendRequest getWaitingFriendWithIndex(int index) { return this.waitingFriends.get(index); }

    /**
     * Setter waitingFriends
     * @param waitingFriends
     */
    public void setWaitingFriends(ArrayList<FriendRequest> waitingFriends) { this.waitingFriends = waitingFriends; }

    /*
    ==================
    == de.teamLocster.Friends.Friendlist Functions
    ==================
    */

    /**
     * Calls methods to add entries in 'waitingFriends' to both the sender and receiver
     * @param receiver
     * @param sender
     */
    public void sendFriendRequest(User receiver, User sender) throws FriendlistException
    {
        if (sender != receiver)
        {
            sender.getFriendlist().addEntryToWaitingFriends(new FriendRequest(receiver, sender));
            receiver.getFriendlist().addEntryToWaitingFriends(new FriendRequest(receiver, sender));
        } else {
            throw new FriendlistException("Cannot send yourself a Friend Request!");
        }
    }

    /**
     * Calls methods to remove entries from 'acceptedFriends' from both users in the 'friendlistItem'
     * @param friendlistItem == to be removed entry
     * @param executingUser
     */
    public void removeFriend(FriendlistItem friendlistItem, User executingUser)
    {
        User toBeRemovedUser = friendlistItem.getFriend();
        toBeRemovedUser.getFriendlist().removeEntryFromAcceptedFriend(executingUser);
        executingUser.getFriendlist().removeEntryFromAcceptedFriend(toBeRemovedUser);
    }


    /**
     * Searches 'acceptedFriends' until 'toBeRemovedUser' is found, removes the entry and returns
     * @param toBeRemovedUser
     */
    private void removeEntryFromAcceptedFriend(User toBeRemovedUser)
    {
        for (int count = 0; count < this.acceptedFriends.size(); count++)
        {
            if (this.acceptedFriends.get(count).getFriend() == toBeRemovedUser)
            {
                this.acceptedFriends.remove(count);
                return;
            }
        }
    }


    /**
     * Calls methods to add entries in 'acceptedFriends' to both users in the 'friendRequest', calls methods to remove entries from 'waitingFriends' from both users in the 'friendRequest'
     * @param friendRequest
     * @param executingUser
     */
    public void acceptFriendRequest(FriendRequest friendRequest, User executingUser) throws FriendlistException
    {
        User sender = friendRequest.getSender();
        User receiver = friendRequest.getReceiver();

        if (sender != executingUser)
        {
            receiver.getFriendlist().addEntryToAcceptedFriends(new FriendlistItem(sender));
            sender.getFriendlist().addEntryToAcceptedFriends(new FriendlistItem(receiver));

            receiver.getFriendlist().removeEntryFromWaitingFriends(sender, false);
            sender.getFriendlist().removeEntryFromWaitingFriends(receiver, true);
        } else {
            throw new FriendlistException("Cannot accept own Friend Request!");
        }
    }


    /**
     * Calls methods to remove entries from 'waitingFriends' from both users in the 'friendRequest'
     * @param friendRequest
     */
    public void denyFriendRequest(FriendRequest friendRequest)
    {
        User sender = friendRequest.getSender();
        User receiver = friendRequest.getReceiver();

        receiver.getFriendlist().removeEntryFromWaitingFriends(sender, false);
        sender.getFriendlist().removeEntryFromWaitingFriends(receiver, true);
    }


    /**
     * Adds entry 'friendlistItem' to 'acceptedFriends'
     * @param friendlistItem
     */
    private void addEntryToAcceptedFriends(FriendlistItem friendlistItem) { this.acceptedFriends.add(friendlistItem); }


    /**
     * Searches 'waitingFriends' until an entry with 'user' is found, removes the entry and returns
     * @param user
     * @param isSender == it´s necessary to know if 'user' is the 'sender' or 'receiver' in the entry
     */
    private void removeEntryFromWaitingFriends(User user, boolean isSender)
    {
        if (isSender)
        {
            for (int count = 0; count < this.waitingFriends.size(); count++)
            {
                if (this.waitingFriends.get(count).getReceiver() == user)
                {
                    this.waitingFriends.remove(count);
                    return;
                }
            }
        } else {
            for (int count = 0; count < this.waitingFriends.size(); count++)
            {
                if (this.waitingFriends.get(count).getSender() == user)
                {
                    this.waitingFriends.remove(count);
                    return;
                }
            }
        }
    }


    /**
     * Adds entry 'friendRequest' to 'waitingFriends'
     * @param friendRequest
     */
    private void addEntryToWaitingFriends(FriendRequest friendRequest) { this.waitingFriends.add(friendRequest); }
}