package de.teamLocster.chat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import de.teamLocster.user.User;
import de.teamLocster.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class ChatTest
{
    @Autowired
    ChatService chatService;

    @Autowired
    ChatRepository chatRepository;

    @Autowired
    UserRepository userRepository;


    User user1 = new User();
    User user2 = new User();
    User user3 = new User();

    @BeforeEach
    public void beforeEach() {
        user1.setFirstName("Ichi");
        user2.setFirstName("Ni");
        user3.setFirstName("San");

        user1 = userRepository.save(user1);
        user2 = userRepository.save(user2);
        user3 = userRepository.save(user3);
    }

    @Test
    void getChatsOfUser() {
        Set<User> members = new HashSet<>();
        members.add(user1);
        members.add(user2);
        members.add(user3);

        Chat testChat = chatService.createChat("chat name", members);

        List<Chat> foundChats = chatService.findChatsOfUser(user1);

        boolean isFound = false;

        for (Chat c : foundChats) isFound = isFound || testChat.getId().equals(c.getId());

        assertTrue("Found chats of user should contain chat.", isFound);
    }
}
