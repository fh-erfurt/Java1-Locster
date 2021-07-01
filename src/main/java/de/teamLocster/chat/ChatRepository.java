package de.teamLocster.chat;

import de.teamLocster.core.BaseRepository;
import de.teamLocster.user.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends BaseRepository<Chat>
{
    /*
    @Query("SELECT chat FROM users_in_chats WHERE user = ?1")
    List<Chat> findChats(User user);

     */

    List<Chat> findChatsByUsersContains(User user);
}
