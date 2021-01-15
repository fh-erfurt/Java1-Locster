package de.teamLocster.Guestbook;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Guestbook
{

    private ArrayList<GuestbookEntry> book;

    public Guestbook()
    {
        book = new ArrayList<GuestbookEntry>();
    }

    public void addEntry(GuestbookEntry entry)
    {
        entry.setSentAt(LocalDateTime.now());
        book.add(entry);
    }

    public void editEntry(GuestbookEntry oldGuestbookEntry, String newText) throws Exception
    {
        for (GuestbookEntry entry : this.book)
        {
            if (entry.equals(oldGuestbookEntry))
            {
                entry.editText(newText);
                return;
            }
        }
        throw new Exception("de.teamLocster.Guestbook.GuestbookEntry to edit not found in de.teamLocster.Guestbook.Guestbook!");
    }

    public void deleteEntry(GuestbookEntry guestbookEntryToDelete)
    {
        book.removeIf(GuestbookEntry -> GuestbookEntry == guestbookEntryToDelete);
        // TODO warum nicht wie bei de.teamLocster.Chat.Message und de.teamLocster.Chat.Chat?
    }

    /*
    ===================================
    Getter & Setter
    ===================================
    */

    public ArrayList<GuestbookEntry> getBook() {
        return book;
    }
}
