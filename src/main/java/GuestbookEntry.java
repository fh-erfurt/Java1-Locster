import java.sql.Timestamp;

public class GuestbookEntry
{

    private User        creator;
    private Timestamp   datetime;
    private String      text;

    public GuestbookEntry(User creator, Timestamp datetime, String text)
    {
        this.creator    = creator;
        this.datetime   = datetime;
        this.text       = text;
    }



    /*
    ===================================
    Getter & Setter
    ===================================
    */

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
