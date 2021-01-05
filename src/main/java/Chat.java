/*
===================================
== Molham Al-khodari    24.12.2020
== Jakob Gensel         05.01.2020
===================================
*/

import java.util.ArrayList;

// Create a Chat class
public class Chat
{
    /*
    =========================
    == Chat Class Attributes
    =========================
    */

    private int chatId;
    private String name;
    private ArrayList<Message> messages = new ArrayList<Message>();

    /*
    ===================================
    == Chat Constructors & Destructors
    ===================================
    */

    public Chat(int chatId, String chatName)
    {
        this.chatId = chatId;
        this.name   = chatName;
    }

    public Chat()
    {
        this.chatId = 0;
        this.name   = "";
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    /*
    ==================
    == Chat functions
    ==================
    */

    public void receiveMessage(Message message)
    {

        this.messages.add(message);
    }

}
