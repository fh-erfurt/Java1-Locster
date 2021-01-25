package de.teamLocster.Chat;/*
=====================
== Molham Al khodari
== Jakob Gensel
=====================
*/
package de.teamLocster.Chat;

import de.teamLocster.Chat.Chat;
import de.teamLocster.Chat.Message;
import de.teamLocster.User.User;
import de.teamLocster.Utility.TestUtility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ChatTest {

    // Given
    private Chat testChat;
    private User testUser;
    private Message testMessage;

    @BeforeEach
    void prepare()
    {
        testChat    = new Chat();
        testUser    = TestUtility.getNewUserForTesting();
        testMessage = new Message("whats up!", testUser);
    }

    /**
     * checks if a created Chat returns the given chatname from the constructor via getter.
     */
    @Test
    public void should_create_a_chat_room()
    {
        // When
        String testChatName = "what ever!";
        testChat = new Chat(testChatName);

        // Then
        Assertions.assertEquals(testChatName, testChat.getName(), "Given chatname is not the same as received message.");
    }

    @Test
    public void chat_should_receive_message()
    {
        // When
        String testChatName = "what ever!";
        testChat = new Chat(testChatName);

        testChat.receiveMessage(testMessage);

        // Then
        Assertions.assertEquals(testChat.getMessages().get(0).getText(), testMessage.getText(), "The de.teamLocster.Chat.Chat receive a message");

    }

    @AfterEach
    public void cleanup()
    {
        testChat    = null;
        testUser    = null;
        testMessage = null;
    }
}
