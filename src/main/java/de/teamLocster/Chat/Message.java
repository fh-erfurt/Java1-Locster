/*
===============
== Jakob Gensel
===============
*/
package de.teamLocster.Chat;

import de.teamLocster.User.User;

import java.time.LocalDateTime;
import java.util.ArrayList;


public class Message
{
    /*
    ============
    == Variables
    ============
    */

    private User            sender;
    private ArrayList<User> readBy;
    private String          text;
    private LocalDateTime   sentAt;

    /*
    ===============
    == Constructors
    ===============
    */
    public Message(String text , User sender)
    {
        this.text = text;
        this.sender = sender;
        this.readBy = new ArrayList<User>();
    }

    /*
    ==========
    == Methods
    ==========
    */

    /**
     * Sends the message to a chat and calls the receiving function in the chat.
     * @param chat the chat, which the message is sent to
     */
    public void sendToChat(Chat chat)
    {
        this.sentAt = LocalDateTime.now();
        chat.receiveMessage(this);
    }

    /**
     * Deletes the message from a chat.
     * @param chat the chat, which the message is deleted from
     */
    public void deleteInChat(Chat chat)
    {
        chat.deleteFromMessages(this);
    }

    /**
     * Marks the messsage as read by the reading user and returns the message text.
     * @param reader user, who is reading the message
     * @return the text the message contains
     */
    public String read(User reader)
    {
        this.readBy.add(reader);
        return this.text;
    }

    /*
    ====================
    == Getters & Setters
    ====================
    */

    public User getSender()
    {
        return sender;
    }

    public ArrayList<User> getReadBy()
    {
        return readBy;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public LocalDateTime getSentAt()
    {
        return sentAt;
    }
}
