/*
===================================
== Matthias Gabel
== Jakob Gensel
== Saskia Wohlers
===================================
*/
package de.teamLocster.Guestbook;

import java.time.LocalDateTime;
import java.util.ArrayList;

import de.teamLocster.Exceptions.GuestbookEntryNotFoundException;

public class Guestbook
{
    /*
    ===================================
    == Variable
    ===================================
    */
    private ArrayList<GuestbookEntry> book;

    /*
    ===================================
    == Constructor
    ===================================
    */
    public Guestbook()
    {
        book = new ArrayList<GuestbookEntry>();
    }

    /*
    ===================================
    == Methods
    ===================================
    */

    public void addEntry(GuestbookEntry entry)
    {
        entry.setSentAt(LocalDateTime.now());
        book.add(entry);
    }

    /**
     * Searches for a given entry in the guestbook and sets the given text, if the entry was found.
     * @param oldGuestbookEntry
     * @param newText
     * @throws GuestbookEntryNotFoundException
     */
    public void editEntry(GuestbookEntry oldGuestbookEntry, String newText) throws GuestbookEntryNotFoundException
    {
        for (GuestbookEntry entry : this.book)
        {
            if (entry.equals(oldGuestbookEntry))
            {
                entry.editText(newText);
                return;
            }
        }
        throw new GuestbookEntryNotFoundException("GuestbookEntry to edit not found in Guestbook!");
    }

    public void deleteEntry(GuestbookEntry guestbookEntryToDelete)
    {
        book.removeIf(GuestbookEntry -> GuestbookEntry == guestbookEntryToDelete);
    }

    /*
    ===================================
    == Getter & Setter
    ===================================
    */

    public ArrayList<GuestbookEntry> getBook() {
        return book;
    }
}
