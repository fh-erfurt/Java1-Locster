/*
===============
== Jakob Gensel
===============
*/
package de.teamLocster.Chat;

import de.teamLocster.User.User;
import de.teamLocster.Exceptions.MessageNotFoundException;
import de.teamLocster.Exceptions.MessageNotDeletedException;

import de.teamLocster.Utility.TestUtility;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class MessageTest
{
    private Chat testChat;
    private User testUser;

    @BeforeEach
    void prepare()
    {
        // Given
        testChat = new Chat("");
        testUser = TestUtility.getNewUserForTesting();
    }

    /**
     * checks if a created message returns the given text from the constructor via getter.
     */
    @Test
    void message_should_contain_given_text()
    {
        // When
        String testText = "Hi, wie geht's?";
        Message testMessage = new Message(testText, testUser);

        // Then
        Assertions.assertEquals(testText, testMessage.getText(), "Given message is not the same as received message.");
    }

    /**
     * creates a new chat, saves a new message in its messages, then looks for the message and throws an exception if not found.
     * deletes the message from the chat, looks for the message and throws an exception if found.
     * @throws MessageNotFoundException
     */
    @Test
    void message_should_be_saved_to_and_deleted_from_given_chat() throws MessageNotFoundException, MessageNotDeletedException
    {
        //Given
        Message testMsg = new Message("test text", testUser);

        // When
        testMsg.sendToChat(testChat);
        // Then
        if(!testChat.getMessages().contains(testMsg)) throw new MessageNotFoundException("Message was not found in chat.");

        // When
        testMsg.deleteInChat(testChat);
        // Then
        if (testChat.getMessages().contains(testMsg)) throw new MessageNotDeletedException("Message was not deleted from chat.");
    }

    /**
     * creates two messages with a small delay to compare their times of dispatch
     * and check if the LocalDateTime is saved correctly.
     * @throws AssertionError
     */
    @Test
    void comparing_datetime_should_return_relative_value() throws AssertionError
    {
        // Given
        Message oldMsg = new Message("old", testUser);
        Message newMsg = new Message("new", testUser);

        try
        {
            //When
            oldMsg.sendToChat(testChat);
            Thread.sleep(10);
            newMsg.sendToChat(testChat);
        }
        catch (Exception e)
        {
            System.out.println("sentAt of old message: " + oldMsg.getSentAt());
            System.out.println("sentAt of old message: " + newMsg.getSentAt());
            throw new AssertionError("Exception message: " + e.getMessage());
        }

        // Then
        Assertions.assertEquals(-1, oldMsg.getSentAt().compareTo(newMsg.getSentAt()), "Comparing should return that the old message is older.");
        Assertions.assertEquals( 1, newMsg.getSentAt().compareTo(oldMsg.getSentAt()), "Comparing should return that the new message is newer.");
        Assertions.assertEquals( 0, oldMsg.getSentAt().compareTo(oldMsg.getSentAt()), "Comparing should return that the messages are equally old.");
        Assertions.assertEquals( 0, newMsg.getSentAt().compareTo(newMsg.getSentAt()), "Comparing should return that the messages are equally new.");
    }

    @Test
    void reading_message_should_save_user()
    {
        //Given
        User sendingUser = TestUtility.getNewUserForTesting();
        Message testMsg = new Message("read me!", sendingUser);

        // When
        testMsg.read(testUser);

        // Then
        Assertions.assertEquals(true, testMsg.getReadBy().contains(testUser), "User should appear in readBy list.");
    }

    @Test
    void message_should_contain_user_it_was_sent_by()
    {
        // When
        Message testMsg = new Message("sup?", testUser);

        // Then
        Assertions.assertEquals(testUser, testMsg.getSender(), "Message should contain sender.");
    }

    @AfterEach
    void cleanup()
    {
        testChat = null;
        testUser = null;
    }
}