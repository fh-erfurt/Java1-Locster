import java.time.LocalDateTime;

public class Message
{

    // private User       sender;
    // private User[]     readBy;
    private String        text;
    private LocalDateTime createdAt;

    Message(String text /*, User sender*/)
    {
        this.text = text;
        // this.sender = sender;
        // this.readBy = new User[];   // dynamic arrays java?
        this.createdAt = LocalDateTime.now();   // hier schon Zeit speichern?
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
