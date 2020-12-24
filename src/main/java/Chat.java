/*
===================================
== Molham Al-khodari    24.12.2020
===================================
*/

// Create a Chat class
public class Chat
{
    /*
    =========================
    == Chat Class Attributes
    =========================
    */

    private int chatId;
    private String chatName;
    private Message[] chatMessages;

    /*
    ===================================
    == Chat Constructors & Destructors
    ===================================
    */

    public Chat(int chatId, String chatName, Message[] chatMessages)
    {
        this.chatId         = chatId;
        this.chatName       = chatName;
        this.chatMessages   = chatMessages;       // kann das richtig sein ?
    }

    public Chat()
    {
        this.chatId             = 0;
        this.chatName           = "";
        // this.chatMessages    = {};
    }

    /*
    ==========================
    == Chat setter und getter
    ==========================
    */

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public Message[] getChatMessages() {
        return chatMessages;
    }

    public void setChatMessages(Message[] chatMessages) {
        this.chatMessages = chatMessages;
    }

    /*
    ==================
    == Chat functions
    ==================
    */

    public void receiveMessage(Message message, User user)
    {
        // do something .... was macht receiveMessage genau ?
    }

}
