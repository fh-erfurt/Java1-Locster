/*
===================================
== Jakob Gensel         05.01.2020
===================================
*/
package de.teamLocster.Chat;

import de.teamLocster.Chat.Chat;
import de.teamLocster.Chat.Message;
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
        testChat = new Chat();
        testUser = TestUtility.getNewUserForTesting();
    }

    /**
     * checks if a created message returns the given text from the constructor via getter.
     */
    @Test
    void message_should_contain_given_text()
    {
        String testText = "Hi, wie geht's?";
        Message testMessage = new Message(testText, testUser);

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
        Message testMsg = new Message("test text", testUser);
        testMsg.sendToChat(testChat);
        if(!testChat.getMessages().contains(testMsg)) throw new MessageNotFoundException("Message was not found in chat.");

        testMsg.deleteInChat(testChat);
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
        testChat = new Chat();
        Message oldMsg = new Message("old", testUser);
        Message newMsg = new Message("new", testUser);
        try
        {
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

        Assertions.assertEquals(-1, oldMsg.getSentAt().compareTo(newMsg.getSentAt()), "Comparing should return that the old message is older.");
        Assertions.assertEquals( 1, newMsg.getSentAt().compareTo(oldMsg.getSentAt()), "Comparing should return that the new message is newer.");
        Assertions.assertEquals( 0, oldMsg.getSentAt().compareTo(oldMsg.getSentAt()), "Comparing should return that the messages are equally old.");
        Assertions.assertEquals( 0, newMsg.getSentAt().compareTo(newMsg.getSentAt()), "Comparing should return that the messages are equally new.");
    }

    @AfterEach
    void cleanup()
    {
        testChat = null;
        testUser = null;
    }
}