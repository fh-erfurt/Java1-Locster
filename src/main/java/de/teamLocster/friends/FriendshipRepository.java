package de.teamLocster.friends;

import de.teamLocster.core.BaseRepository;
import de.teamLocster.core.DBController;
import de.teamLocster.friends.Friendship;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FriendshipRepository extends BaseRepository<Friendship>
{

    public FriendshipRepository() {
            super(Friendship.class, DBController.getManager().getEntityManager());
    }

}
