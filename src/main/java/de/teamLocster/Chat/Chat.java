/*
===================================
Molham Al-khodari
Jakob Gensel
===================================
*/
package de.teamLocster.Chat;

import java.util.ArrayList;

public class Chat
{
    /*
    =========================
    Variable
    =========================
    */

    private String name; // TODO Überlegung: Gruppenchat / automatisch generiert / de.teamLocster.User.User ArrayList?
    private ArrayList<Message> messages;

    /*
    ===============
    Constructors
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
    Methods
    ==================
    */

    public void receiveMessage(Message message)
    {
        this.messages.add(message);
    }


    /*
    ==========================
    setter & getter
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
