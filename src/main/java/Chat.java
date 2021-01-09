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

    private String name; // TODO Überlegung: Gruppenchat / automatisch generiert / User ArrayList?
    private ArrayList<Message> messages;

    /*
    ===============
    == Constructors
    ===============
    */

    public Chat(String chatName)
    {
        this.name     = chatName;
        this.messages = new ArrayList<Message>();
    }

    public Chat()
    {
        this.name     = "";
        this.messages = new ArrayList<Message>();
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


    /*
    ==========================
    == Chat setter und getter
    ==========================
    */

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
}
