package de.teamLocster.chat;

import de.teamLocster.core.BaseService;
import de.teamLocster.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
public class ChatService extends BaseService<Chat>
{
    ChatRepository chatRepository;

    @Autowired
    public ChatService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    public Chat createChat() {
        return createChat("Locster Chat");
    }

    public Chat createChat(String name) {
        return createChat(name, new HashSet<>());
    }

    public Chat createChat(String name, Set<User> users) {
        return chatRepository.save(new Chat(name, users, null));
    }

    public List<Chat> findChatsOfUser(User user) {
        return chatRepository.findChatsByUsersContains(user);
    }
}
