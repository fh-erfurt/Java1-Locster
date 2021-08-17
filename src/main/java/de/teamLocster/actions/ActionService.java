package de.teamLocster.actions;

import de.teamLocster.core.BaseService;
import de.teamLocster.core.errors.NoFriendRequestPresentException;
import de.teamLocster.core.errors.UsersAreNotFriendsException;
import de.teamLocster.enums.ActionType;
import de.teamLocster.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ActionService extends BaseService<Action>
{
    @Autowired
    ActionRepository actionRepository;

    /**
     * method used to send friend request
     * if there is already a request present in the opposite direction, it just gets accepted
     * if there is already a request present in the same direction, nothing is done
     * @param actor the user sending the request
     * @param affected the user that gets requested
     */
    public void sendFriendRequest(User actor, User affected) {
        try {
            acceptFriendRequest(actor, affected);
        }
        catch (NoFriendRequestPresentException nfrEx) {
            Optional<Action> sentRequest = actionRepository.findByActionTypeAndActorIdAndAffectedId(ActionType.FRIEND_REQUEST, actor.getId(), affected.getId());
            if(sentRequest.isEmpty()) actionRepository.save(new Action(actor, affected, ActionType.FRIEND_REQUEST));
        }
    }

    public List<User> getReceivedFriendRequests(User user) {
        List<User> requestingUsers = new ArrayList<>();
        actionRepository.findByActionTypeAndAffectedId(ActionType.FRIEND_REQUEST, user.getId()).forEach(r -> requestingUsers.add(r.getActor()));
        return requestingUsers;
    }

    /**
     *
     * @param actor
     * @param affected
     * @throws NoFriendRequestPresentException if there is no friend request
     */
    public void acceptFriendRequest(User actor, User affected) throws NoFriendRequestPresentException {
        Optional<Action> friendRequest = actionRepository.findByActionTypeAndActorIdAndAffectedId(ActionType.FRIEND_REQUEST, affected.getId(), actor.getId());
        if (friendRequest.isPresent()) {
            actionRepository.save(new Action(actor, affected, ActionType.FRIEND_ACKNOWLEDGEMENT));
            actionRepository.deleteById(friendRequest.get().getId());
            return;
        }
        throw new NoFriendRequestPresentException("There was no friend request found from this User");
    }

    public List<User> getFriends(User user) {
        List<User> friends = new ArrayList<>();
        // get friends where given user is the actor
        actionRepository.findByActionTypeAndActorId(ActionType.FRIEND_ACKNOWLEDGEMENT, user.getId()).forEach(f -> friends.add(f.getAffected()));
        // get friends where given user is the affected
        actionRepository.findByActionTypeAndAffectedId(ActionType.FRIEND_ACKNOWLEDGEMENT, user.getId()).forEach(f -> friends.add(f.getActor()));
        return friends;
    }

    public boolean isFriend(User user1, User user2) {
        return getFriends(user1).contains(user2);
    }

    private Optional<Action> getFriendshipAcknowledgementAction(Long actorId, Long affectedId) {
        Optional<Action> data1 = actionRepository.findByActionTypeAndActorIdAndAffectedId(ActionType.FRIEND_ACKNOWLEDGEMENT, actorId, affectedId);
        Optional<Action> data2 = actionRepository.findByActionTypeAndActorIdAndAffectedId(ActionType.FRIEND_ACKNOWLEDGEMENT, affectedId, actorId);
        return data1.isPresent() ? data1 : data2;
    }

    public void removeFriend(User actor, User affected) throws UsersAreNotFriendsException {
        Optional<Action> friendship = getFriendshipAcknowledgementAction(actor.getId(), affected.getId());
        if(isFriend(actor, affected) && friendship.isPresent()) {
            actionRepository.delete(friendship.get());
        }
    }

    public Action blockUser(User actor, User affected) {
        return actionRepository.save(new Action(actor, affected, ActionType.BLOCK));
    }

    public List<User> getBlockedUsers(User user) {
        List<User> blockedUsers = new ArrayList<>();
        actionRepository.findByActionTypeAndActorId(ActionType.BLOCK,user.getId()).forEach(r -> blockedUsers.add(r.getAffected()));
        return blockedUsers;
    }
}
