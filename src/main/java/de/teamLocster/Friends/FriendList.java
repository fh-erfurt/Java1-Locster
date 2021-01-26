/*
===================================
Dirk Hofmann
===================================
*/
package de.teamLocster.Friends;

import de.teamLocster.User.User;
import de.teamLocster.Exceptions.CannotSendFriendRequestException;
import de.teamLocster.Exceptions.CannotAcceptFriendRequestException;

import java.util.ArrayList;

public class FriendList
{

    /*
    =========================
    Variable
    =========================
    */

    private ArrayList<FriendListItem> acceptedFriends; // accepted friends are stored here
    private ArrayList<FriendRequest> waitingFriends;   // waiting requests are stored here

    /*
    ===================================
    Constructors
    ===================================
    */

    public FriendList()
    {
        acceptedFriends = new ArrayList<FriendListItem>();
        waitingFriends = new ArrayList<FriendRequest>();
    }

    /*
    ==================
    Methods
    ==================
    */

    /**
     * Calls methods to add entries in 'waitingFriends' to both the sender and receiver, throws Exceptions if sender == receiver
     * @param receiver
     * @param sender
     */
    public void sendFriendRequest(User receiver, User sender) throws CannotSendFriendRequestException
    {
        if (sender != receiver)
        {
            sender.getFriendlist().addEntryToWaitingFriends(new FriendRequest(receiver, sender));
            receiver.getFriendlist().addEntryToWaitingFriends(new FriendRequest(receiver, sender));
        } else {
            throw new CannotSendFriendRequestException("Cannot send yourself a Friend Request!");
        }
    }

    /**
     * Calls methods to remove entries from 'acceptedFriends' from both users in the 'friendlistItem'
     * @param friendListItem == to be removed entry
     * @param executingUser
     */
    public void removeFriend(FriendListItem friendListItem, User executingUser)
    {
        User toBeRemovedUser = friendListItem.getFriend();
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
    public void acceptFriendRequest(FriendRequest friendRequest, User executingUser) throws CannotAcceptFriendRequestException
    {
        User sender = friendRequest.getSender();
        User receiver = friendRequest.getReceiver();

        if (sender != executingUser)
        {
            receiver.getFriendlist().addEntryToAcceptedFriends(new FriendListItem(sender));
            sender.getFriendlist().addEntryToAcceptedFriends(new FriendListItem(receiver));

            receiver.getFriendlist().removeEntryFromWaitingFriends(sender, false);
            sender.getFriendlist().removeEntryFromWaitingFriends(receiver, true);
        } else {
            throw new CannotAcceptFriendRequestException("Cannot accept own Friend Request!");
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
    private void addEntryToAcceptedFriends(FriendListItem friendlistItem) { this.acceptedFriends.add(friendlistItem); }


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

    /*
    ===================================
    Getter & Setter
    ===================================
    */

    /**
     * Getter acceptedFriends
     * @return ArrayList 'acceptedFriends'
     */
    public ArrayList<FriendListItem> getAcceptedFriends() { return acceptedFriends; }

    /**
     * Getter acceptedFriends with index
     * @param index
     * @return entry with index from ArrayList 'acceptedFriends'
     */
    public FriendListItem getAcceptedFriendWithIndex(int index) { return this.acceptedFriends.get(index); }

    /**
     * Setter acceptedFriends
     * @param acceptedFriends
     */
    public void setAcceptedFriends(ArrayList<FriendListItem> acceptedFriends) { this.acceptedFriends = acceptedFriends; }

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
}
