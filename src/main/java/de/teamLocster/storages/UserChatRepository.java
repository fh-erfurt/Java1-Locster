package de.teamLocster.storages;

import de.teamLocster.core.DBController;
import de.teamLocster.domains.UserChat;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserChatRepository extends BaseRepository<UserChat> {

    public UserChatRepository() {
        super(UserChat.class, DBController.getManager().getEntityManager());
    }
}
