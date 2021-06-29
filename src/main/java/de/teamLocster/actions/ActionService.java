package de.teamLocster.actions;

import de.teamLocster.core.BaseService;
import de.teamLocster.enums.ActionType;
import de.teamLocster.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ActionService extends BaseService<Action>
{
    ActionRepository actionRepository;



    @Autowired
    public ActionService(ActionRepository actionRepository)
    {
        this.actionRepository = actionRepository;
    }

    public void sendFriendRequest(User actor, User affected) {
        actionRepository.save(new Action(actor, affected, ActionType.FRIEND_REQUEST));
    }

    public List<User> getReceivedFriendRequests(User user) {
        List<User> requestingUsers = new ArrayList<>();
        actionRepository.findByActionTypeAndAffectedId(ActionType.FRIEND_REQUEST, user.getId()).forEach(r -> requestingUsers.add(r.getActor()));
        return requestingUsers;
    }

    public void acceptFriendRequest(User actor, User affected) {
        Action friendRequest = actionRepository.findByActionTypeAndActorIdAndAffectedId(ActionType.FRIEND_REQUEST, actor.getId(), affected.getId());
        if (friendRequest != null) {
            actionRepository.save(new Action(actor, affected, ActionType.FRIEND_ACKNOWLEDGEMENT));
            // actionRepository.delete(friendRequest); // TODO sollen Anfragen nach Bestätigung gelöscht werden?
        }
    }

    public List<User> getFriends(User user) {
        List<User> friends = new ArrayList<>();
        // get friends where given user is the actor
        actionRepository.findByActionTypeAndActorId(ActionType.FRIEND_ACKNOWLEDGEMENT, user.getId()).forEach(f -> friends.add(f.getAffected()));
        // get friends where given user is the affected
        actionRepository.findByActionTypeAndAffectedId(ActionType.FRIEND_ACKNOWLEDGEMENT, user.getId()).forEach(f -> friends.add(f.getActor()));
        return friends;
    }

    public void blockUser(User actor, User affected) {
        actionRepository.save(new Action(actor, affected, ActionType.BLOCK));
    }

    public List<User> getBlockedUsers(User user) {
        List<User> blockedUsers = new ArrayList<>();
        actionRepository.findByActionTypeAndActorId(ActionType.BLOCK,user.getId()).forEach(r -> blockedUsers.add(r.getAffected()));
        return blockedUsers;
    }
}
