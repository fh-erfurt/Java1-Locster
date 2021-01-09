import java.util.ArrayList;

public class Friendlist {

    /*
    =========================
    == Friendlist Class Attributes
    =========================
    */

    private ArrayList<FriendlistItem> acceptedFriends = new ArrayList<FriendlistItem>();
    private ArrayList<FriendRequest> waitingFriends = new ArrayList<FriendRequest>();

    /*
    ===================================
    == Friendlist Constructors & Destructors
    ===================================
    */

    public Friendlist() {
    }

    /*
    ===================================
    ==  Friendlist Getter & Setter
    ===================================
    */

    public ArrayList<FriendlistItem> getAcceptedFriends() {
        return acceptedFriends;
    }

    public FriendlistItem getAcceptedFriendWithIndex(int index) {
        return getAcceptedFriends().get(index);
    }

    public void setAcceptedFriends(ArrayList<FriendlistItem> acceptedFriends) {
        this.acceptedFriends = acceptedFriends;
    }


    public ArrayList<FriendRequest> getWaitingFriends() {
        return waitingFriends;
    }

    public FriendRequest getWaitingFriendWithIndex(int index) {
        return getWaitingFriends().get(index);
    }

    public void setWaitingFriends(ArrayList<FriendRequest> waitingFriends) {
        this.waitingFriends = waitingFriends;
    }

    /*
    ==================
    == Friendlist Functions
    ==================
    */

    public void sendFriendRequest(User receiver, User sender) {

        if (sender != receiver) {
            sender.getFriendlist().addEntryToWaitingFriends(new FriendRequest(receiver, sender));
            receiver.getFriendlist().addEntryToWaitingFriends(new FriendRequest(receiver, sender));
        }
    }


    public void deleteFriend(FriendlistItem friendlistItem, User executingUser) {
        User toBeRemovedUser = friendlistItem.getFriend();
        toBeRemovedUser.getFriendlist().removeEntryFromAcceptedFriend(executingUser);
        executingUser.getFriendlist().removeEntryFromAcceptedFriend(toBeRemovedUser);
    }


    private void removeEntryFromAcceptedFriend(User toBeRemovedUser) {
        for (int count = 0; count < getAcceptedFriends().size(); count++) {
            if (getAcceptedFriends().get(count).getFriend() == toBeRemovedUser) {
                getAcceptedFriends().remove(count);
                return;
            }
        }
    }


    public void acceptFriendRequest(FriendRequest friendRequest, User executingUser) {

        User sender = friendRequest.getSender();
        User receiver = friendRequest.getReceiver();

        if (sender != executingUser) {

            receiver.getFriendlist().addEntryToAcceptedFriends(new FriendlistItem(sender));
            sender.getFriendlist().addEntryToAcceptedFriends(new FriendlistItem(receiver));

            receiver.getFriendlist().removeEntryFromWaitingFriends(sender, false);
            sender.getFriendlist().removeEntryFromWaitingFriends(receiver, true);

        }
    }



    public void denyFriendRequest(FriendRequest friendRequest) {

        User sender = friendRequest.getSender();
        User receiver = friendRequest.getReceiver();

        receiver.getFriendlist().removeEntryFromWaitingFriends(sender, false);
        sender.getFriendlist().removeEntryFromWaitingFriends(receiver, true);
    }

    private void addEntryToAcceptedFriends(FriendlistItem friendlistItem) {
        this.acceptedFriends.add(friendlistItem);
    }



    private void removeEntryFromWaitingFriends(User user, boolean isSender) {

        if (isSender) {
            for (int count = 0; count < getWaitingFriends().size(); count++) {
                if (getWaitingFriends().get(count).getReceiver() == user) {
                    getWaitingFriends().remove(count);
                    return;
                }
            }
        } else {
            for (int count = 0; count < getWaitingFriends().size(); count++) {
                if (getWaitingFriends().get(count).getSender() == user) {
                    getWaitingFriends().remove(count);
                    return;
                }
            }
        }
    }


    private void addEntryToWaitingFriends(FriendRequest friendRequest) {
        getWaitingFriends().add(friendRequest);
    }
}

