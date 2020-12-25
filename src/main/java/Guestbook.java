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

    public void editGuestbookEntry(GuestbookEntry oldGuestbookEntry, String message)
    {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        User creator = oldGuestbookEntry.getCreator();
        GuestbookEntry newGuestbookEntry = new GuestbookEntry(creator, timestamp, message);
        for (int Index = 0; Index < book.size(); Index++)
        {
            if (book.get(Index) == oldGuestbookEntry)
            {
                book.set(Index, newGuestbookEntry);
            }
        }
    }


    public void deleteGuestbookEntry(GuestbookEntry toDeleteGuestbookEntry)
    {
        book.removeIf(GuestbookEntry -> GuestbookEntry == toDeleteGuestbookEntry);
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
