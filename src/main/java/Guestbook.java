import java.sql.Timestamp;
import java.util.ArrayList;

public class Guestbook
{

    private ArrayList<GuestbookEntry> book;

    public Guestbook()
    {
        book = new ArrayList<GuestbookEntry>();
    }

    public void addGuestbookEntry(User creator, String message)
    {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        GuestbookEntry guestbookEntry = new GuestbookEntry(creator, timestamp, message);
        book.add(guestbookEntry);
    }

    public void editGuestbookEntry(GuestbookEntry oldGuestbookEntry, String message) throws Exception
    {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        GuestbookEntry newGuestbookEntry = new GuestbookEntry(oldGuestbookEntry.getCreator(), timestamp, message);
        for (GuestbookEntry entry : this.book)
        {
            if (entry.equals(oldGuestbookEntry))
            {
                entry = newGuestbookEntry;
                return;
            }
        }
        throw new Exception("GuestbookEntry to edit not found in Guestbook!");
        // TODO JGE Fehler, wenn oldGuestbookEntry nicht in Guestbook
    }


    public void deleteGuestbookEntry(GuestbookEntry guestbookEntryToDelete)
    {
        book.removeIf(GuestbookEntry -> GuestbookEntry == guestbookEntryToDelete);
        // TODO warum nicht wie bei Message und Chat?
    }

    /*
    ===================================
    Getter & Setter
    ===================================
    */

    public ArrayList<GuestbookEntry> getBook() {
        return book;
    }

    public void setBook(ArrayList<GuestbookEntry> book) {
        this.book = book;
    }
}
