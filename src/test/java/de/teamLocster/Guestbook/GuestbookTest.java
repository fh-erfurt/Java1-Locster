/*
===================================
== Jakob Gensel
===================================
*/
package de.teamLocster.Guestbook;

import de.teamLocster.Guestbook.Guestbook;
import de.teamLocster.Guestbook.GuestbookEntry;
import de.teamLocster.User.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class GuestbookTest
{
    private User testUser;
    private GuestbookEntry testEntry;
    private Guestbook testBook;

    @BeforeEach
    void prepare()
    {
        testUser  = User.getNewUserForTesting();
        testEntry = new GuestbookEntry(testUser, "Test Text");
        testBook  = new Guestbook();
    }

    /**
     * Checks if GuetstbookEntry is added to a given de.teamLocster.Guestbook.Guestbook properly.
     * @throws Exception
     */
    @Test
    void added_entry_should_appear_in_guestbook() throws Exception
    {
        testBook.addEntry(testEntry);

        Assertions.assertTrue(testBook.getBook().contains(testEntry), "Created de.teamLocster.Guestbook.GuestbookEntry was not found.");
    }

    /**
     *
     * @throws Exception
     */
    @Test
    void when_edited_entry_should_have_new_text_flag_and_time() throws Exception
    {
        String testText = "Eintrag ist bearbeitet";
        testBook.addEntry(testEntry);
        Thread.sleep(10);
        testBook.editEntry(testEntry, testText);

        Assertions.assertEquals(testEntry.getText() , testText,                                       "The de.teamLocster.Guestbook.GuestbookEntry should contain the new text.");
        Assertions.assertTrue  (testEntry.isEdited(),                                                 "The flag \"edited\" should be set to true.");
        Assertions.assertEquals(-1, testEntry.getSentAt().compareTo(testEntry.getEditedAt()), "The de.teamLocster.Guestbook.GuestbookEntry should be edited after it was sent.");
    }

    /**
     * Checks if de.teamLocster.Guestbook.GuestbookEntry gets deleted properly.
     * @throws Exception
     */
    @Test
    void when_deleted_entry_should_not_be_found_anymore() throws Exception
    {
        testBook.addEntry(testEntry);
        testBook.deleteEntry(testEntry);

        Assertions.assertFalse(testBook.getBook().contains(testEntry), "de.teamLocster.Guestbook.GuestbookEntry should not be found anymore.");
    }

    @AfterEach
    void cleanup()
    {
        testUser  = null;
        testEntry = null;
        testBook  = null;
    }
}
