package de.teamLocster.storages;

import de.teamLocster.core.DBController;
import de.teamLocster.domains.Friendship;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FriendshipRepository extends BaseRepository<Friendship>{

    public FriendshipRepository() {
            super(Friendship.class, DBController.getManager().getEntityManager());
    }

}
