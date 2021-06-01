package de.teamLocster.chat;

import de.teamLocster.core.BaseRepository;
import de.teamLocster.core.DBController;
import de.teamLocster.chat.Chat;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ChatRepository extends BaseRepository<Chat>
{

    public ChatRepository() {super(Chat .class, DBController.getManager().getEntityManager());}
}
