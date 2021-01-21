package de.teamLocster.Chat;

import de.teamLocster.User.User;

import java.time.LocalDateTime;
import java.util.ArrayList;

// TODO JGE Kommentare


/**
 *
 */
public class Message
{
    /*
    =========================
    Variable
    =========================
    */

    private User sender;
    private ArrayList<User> readBy; // dynamic array
    private String          text;
    private LocalDateTime   sentAt;

    /*
    =========================
    Constructors
    =========================
    */
    public Message(String text , User sender)
    {
        this.text = text;
        this.sender = sender;
        this.readBy = new ArrayList<User>();
    }

    /*
    =========================
    Methods
    =========================
    */
    /**
     * Sends a message to a chat and calls the receiving function in the chat.
     * @param chat the chat, which the message is sent to
     */
    public void sendToChat(Chat chat)
    {
        this.sentAt = LocalDateTime.now();
        chat.receiveMessage(this);
    }

    /**
     * Deletes a message from a chat.
     * @param chat the chat, which the message is deleted from
     */
    public void deleteFromChat(Chat chat)   // de.teamLocster.Chat.Message = null reicht.
    {
        // TODO JGE de.teamLocster.Chat.Message eindeutig identifizieren
        // TODO MAL(Molham Al-Khodari) de.teamLocster.Chat.Chat braucht noch eine Funktion zum löschen
    }

    /**
     * Marks a messsage as read by the reading user and returns the message text.
     * @param reader user, who is reading the message
     * @return the text the message contains
     */
    public String read(User reader)
    {
        this.readBy.add(reader);
        return this.getText();
    }

    protected void finalize()
    {
        // this.chat       = null;
        this.sender     = null;
        this.readBy     = null;
        this.text       = null;
        this.sentAt     = null;
    }

    /*
    =========================
    Getter & Setter
    =========================
    */

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
