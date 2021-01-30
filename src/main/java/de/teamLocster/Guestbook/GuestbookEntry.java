/*
===================================
== Matthias Gabel
== Jakob Gensel
== Saskia Wohlers
===================================
*/
package de.teamLocster.Guestbook;


import de.teamLocster.User.User;

import java.time.LocalDateTime;


public class GuestbookEntry
{
    /*
    ===================================
    == Variable
    ===================================
    */
    private User          creator;
    private String        text;
    private LocalDateTime sentAt;


    private LocalDateTime editedAt;
    private boolean       edited = false;

    /*
    ===================================
    == Constructor
    ===================================
    */
    public GuestbookEntry(User creator, String text)
    {
        this.creator    = creator;
        this.text       = text;
    }

    /*
    ===================================
    == Methods
    ===================================
    */

    /**
     * Edits the text of the entry and updates the edited flag as well as the time of the last edit.
     * @param newText
     */
    public void editText(String newText)
    {
        this.text     = newText;
        this.editedAt = LocalDateTime.now();
        this.edited   = true;
    }

    /*
    ===================================
    == Getter & Setter
    ===================================
    */

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getEditedAt()
    {
        return editedAt;
    }

    public boolean isEdited()
    {
        return edited;
    }
}
