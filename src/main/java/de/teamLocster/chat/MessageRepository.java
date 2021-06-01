package de.teamLocster.chat;

import de.teamLocster.core.BaseRepository;
import de.teamLocster.core.DBController;
import de.teamLocster.chat.Message;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageRepository extends BaseRepository<Message>
{
    public MessageRepository() {
        super(Message.class, DBController.getManager().getEntityManager());
    }
}
