package de.teamLocster.storages;

import de.teamLocster.domains.Friendship;
import de.teamLocster.domains.User;

public class FriendshipRepository extends BaseRepository<Friendship>{

    public FriendshipRepository() {
        super(User.class, H2Controller.getManager().getEntityManager());
    }
}
