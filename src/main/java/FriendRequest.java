public class FriendRequest {

    /*
    =========================
    == FriendRequest Class Attributes
    =========================
    */

    private User receiver;
    private User sender;

    /*
    ===================================
    == FriendRequest Constructors & Destructors
    ===================================
    */

    public FriendRequest(User receiver, User sender)
    {
        this.receiver = receiver;
        this.sender = sender;
    }

    /*
    ===================================
    ==  FriendRequest Getter & Setter
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
