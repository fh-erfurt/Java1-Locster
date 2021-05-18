package de.teamLocster.storages;

import de.teamLocster.core.H2Controller;
import de.teamLocster.domains.Message;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageRepository extends BaseRepository<Message> {
    public MessageRepository() {
        super(Message.class, H2Controller.getManager().getEntityManager());
    }
}
