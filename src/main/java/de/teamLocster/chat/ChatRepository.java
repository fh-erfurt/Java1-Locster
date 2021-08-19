package de.teamLocster.chat;

import de.teamLocster.core.BaseRepository;
import de.teamLocster.user.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * has not yet been implemented
 */
@Repository
public interface ChatRepository extends BaseRepository<Chat> {
    List<Chat> findChatsByUsersContains(User user);
}
