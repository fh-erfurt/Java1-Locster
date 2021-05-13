package de.teamLocster.storages;

import de.teamLocster.core.H2Controller;
import de.teamLocster.domains.Friendship;

public class FriendshipRepository extends BaseRepository<Friendship>{
    public FriendshipRepository() {
            super(Friendship.class, H2Controller.getManager().getEntityManager());
    }

}
