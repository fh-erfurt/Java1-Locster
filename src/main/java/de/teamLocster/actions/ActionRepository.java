package de.teamLocster.actions;

import de.teamLocster.core.BaseRepository;
import de.teamLocster.enums.ActionType;
import de.teamLocster.user.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionRepository extends BaseRepository<Action>
{
    List<Action> findByActionTypeAndActorId(ActionType actionType, Long actorId);

    List<Action> findByActionTypeAndAffectedId(ActionType actionType, Long affectedId);

    Action findByActionTypeAndActorIdAndAffectedId(ActionType actionType, Long actorId, Long affectedId);

    /*
    @Query("SELECT actor FROM Action WHERE Action.actionType = ?1 and affected = ?2")
    List<User> findFriends(ActionType actionType, User affected);
    */
}
