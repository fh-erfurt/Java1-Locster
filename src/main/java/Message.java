import java.time.LocalDateTime;
import java.util.ArrayList;

// TODO JGE Kommentare


/**
 *
 */
public class Message
{
    // private Chat            chat; // sollte hier auch ein eindeutiger Chat gespeichert werden? evtl. benötigt für deleteMessageFromChat()
    private User            sender;
    private ArrayList<User> readBy; // dynamic array
    private String          text;
    private LocalDateTime   createdAt;
    private LocalDateTime   sentAt;

    Message(String text , User sender)
    {
        this.text = text;
        this.sender = sender;
        this.readBy = new ArrayList<User>();
        this.createdAt = LocalDateTime.now();
    }

    /**
     * Sends a message to a chat and calls the receiving function in the chat.
     * @param chat the chat, which the message is sent to
     */
    public void sendMessageToChat(Chat chat)
    {
        this.sentAt = LocalDateTime.now();
        chat.receiveMessage(this, this.sender);
    }

    /**
     * Deletes a message from a chat.
     * @param chat the chat, which the message is deleted from
     */
    public void deleteMessageFromChat(/* Chat chat */)   // Message = null reicht.
    {
        // TODO JGE Message eindeutig identifizieren
        // TODO MAL(Molham Al-Khodari) Chat braucht noch eine Funktion zum löschen
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
        this.createdAt  = null;
        this.sentAt     = null;
    }

    // ----- Getters and Setters ----- //

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public LocalDateTime getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt)
    {
        this.createdAt = createdAt;
    }
}
