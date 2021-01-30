/*
===================================
== Dirk Hofmann
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
    == Variable
    =========================
    */

    private ArrayList<FriendListItem> acceptedFriends;
    private ArrayList<FriendRequest> waitingFriends;

    /*
    ===================================
    == Constructors
    ===================================
    */

    public FriendList()
    {
        acceptedFriends = new ArrayList<FriendListItem>();
        waitingFriends = new ArrayList<FriendRequest>();
    }

    /*
    ==================
    == Methods
    ==================
    */

    /**
     * Calls methods to add entries in 'waitingFriends' to both the sender and receiver, throws Exceptions if sender == receiver
     * @param receiver == receiving user
     * @param sender == sending user
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
     * Calls methods to remove entries in 'acceptedFriends' from both users in the 'friendlistItem' and updates latestFriend and oldestFriend in ProfileStatistics, calls methods to update 'latestFriend' and 'oldestFriend' from both users
     * @param friendListItem == to be removed entry
     * @param executingUser == calling user
     */
    public void removeFriend(FriendListItem friendListItem, User executingUser)
    {
        User toBeRemovedUser = friendListItem.getFriend();

        toBeRemovedUser.getFriendlist().removeEntryFromAcceptedFriend(executingUser);
        executingUser.getFriendlist().removeEntryFromAcceptedFriend(toBeRemovedUser);

        toBeRemovedUser.getProfileStatistic().updateLatestFriend(toBeRemovedUser,executingUser, false);
        executingUser.getProfileStatistic().updateLatestFriend(executingUser,toBeRemovedUser,false);

        toBeRemovedUser.getProfileStatistic().updateOldestFriend(toBeRemovedUser,executingUser, false);
        executingUser.getProfileStatistic().updateOldestFriend(executingUser,toBeRemovedUser,false);
    }


    /**
     * Searches 'acceptedFriends' until 'toBeRemovedUser' is found, removes the entry and returns
     * @param toBeRemovedUser == to be removed user
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
     * Calls methods to add entries in 'acceptedFriends' to both users in the 'friendRequest', calls methods to remove entries in 'waitingFriends' from both users in the 'friendRequest', calls methods to update 'latestFriend' and 'oldestFriend' from both users
     * @param friendRequest == to be accepted and removed friend request
     * @param executingUser == calling user
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

            receiver.getProfileStatistic().updateLatestFriend(receiver,sender, true);
            sender.getProfileStatistic().updateLatestFriend(sender,receiver,true);

            receiver.getProfileStatistic().updateOldestFriend(receiver,sender, true);
            sender.getProfileStatistic().updateOldestFriend(sender,receiver,true);
        }
        else
        {
            throw new CannotAcceptFriendRequestException("Cannot accept own Friend Request!");
        }
    }

    /**
     * Calls methods to remove entries in 'waitingFriends' from both users in the 'friendRequest'
     * @param friendRequest == to be removed friend request
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
     * @param friendListItem == to be added friendListItem
     */
    private void addEntryToAcceptedFriends(FriendListItem friendListItem) { this.acceptedFriends.add(friendListItem); }


    /**
     * Searches 'waitingFriends' until an entry with 'user' is found, removes the entry and returns
     * @param user == user which needs to be found to remove entry
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
        }
        else
        {
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
     * @param friendRequest == to be added entry
     */
    private void addEntryToWaitingFriends(FriendRequest friendRequest) { this.waitingFriends.add(friendRequest); }

    /*
    ===================================
    == Getter & Setter
    ===================================
    */

    public ArrayList<FriendListItem> getAcceptedFriends() { return acceptedFriends; }

    public FriendListItem getAcceptedFriendWithIndex(int index) { return this.acceptedFriends.get(index); }

    public void setAcceptedFriends(ArrayList<FriendListItem> acceptedFriends) { this.acceptedFriends = acceptedFriends; }

    public ArrayList<FriendRequest> getWaitingFriends() { return waitingFriends; }

    public FriendRequest getWaitingFriendWithIndex(int index) { return this.waitingFriends.get(index); }

    public void setWaitingFriends(ArrayList<FriendRequest> waitingFriends) { this.waitingFriends = waitingFriends; }
}
