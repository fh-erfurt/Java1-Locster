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

    private String name;
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

    public void deleteFromMessages(Message message)
    {
        messages.remove(message);
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
