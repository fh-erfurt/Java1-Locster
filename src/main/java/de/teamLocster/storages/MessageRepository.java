package de.teamLocster.storages;

import de.teamLocster.domains.Message;

public class MessageRepository extends BaseRepository<Message> {
    public MessageRepository() {
        super(Message.class, H2Controller.getManager().getEntityManager());
    }
}
