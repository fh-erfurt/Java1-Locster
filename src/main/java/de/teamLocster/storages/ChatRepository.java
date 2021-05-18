package de.teamLocster.storages;

import de.teamLocster.core.H2Controller;
import de.teamLocster.domains.Chat;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ChatRepository extends BaseRepository<Chat> {

    public ChatRepository() {super(Chat .class, H2Controller.getManager().getEntityManager());}
}
