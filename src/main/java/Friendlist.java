public class Friendlist {

    /*
    =========================
    == Friendlist Class Attributes
    =========================
    */

    private FriendlistItem[] acceptedFriends;
    private FriendRequest[] waitingFriends;

    /*
    ===================================
    == Friendlist Constructors & Destructors
    ===================================
    */

    /*
    ===================================
    ==  Friendlist Getter & Setter
    ===================================
    */

    public FriendlistItem[] getAcceptedFriends() {
        return acceptedFriends;
    }

    public void setAcceptedFriends(FriendlistItem[] acceptedFriends) {
        this.acceptedFriends = acceptedFriends;
    }

    public FriendRequest[] getWaitingFriends() {
        return waitingFriends;
    }

    public void setWaitingFriends(FriendRequest[] waitingFriends) {
        this.waitingFriends = waitingFriends;
    }

    /*
    ==================
    == Friendlist Functions
    ==================
    */

    void sendFriendRequest(User user) {

    }

    void deleteFriend(FriendlistItem friendlistItem) {

    }
}
