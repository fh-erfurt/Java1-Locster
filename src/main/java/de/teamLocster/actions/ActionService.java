package de.teamLocster.actions;

import de.teamLocster.core.BaseRepository;
import de.teamLocster.core.BaseService;
import de.teamLocster.enums.ActionType;
import de.teamLocster.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
@Service
public class ActionService extends BaseService<Action>
{
    public ActionService(BaseRepository<Action> actionRepository)
    {
        super(actionRepository);
    }

    public void sendFriendRequest(User actor, User affected) {
        repository.save(new Action(actor, affected, ActionType.FRIEND_REQUEST));
    }

    public void blockUser(User actor, User affected) {
        repository.save(new Action(actor, affected, ActionType.BLOCK));
    }

    public List<User> getFriendsOfUser(User user) {
        List<User> friends = new ArrayList<>();
        Stream<Action> friendships = repository.findAll().stream().filter(a -> a.getActionType().equals(ActionType.FRIEND_ACKNOWLEDGEMENT));
        // get friends where given user is the actor
        friendships.filter(f -> f.getActor().getId().equals(user.getId())).forEach(f -> friends.add(f.getAffected()));
        // get friends where given user is the affected
        friendships.filter(f -> f.getAffected().getId().equals(user.getId())).forEach(f -> friends.add(f.getActor()));
        return friends;
    }

    public List<User> getReceivedFriendRequestsOfUser(User user) {
        List<User> friendRequests = new ArrayList<>();
        repository.findAll().stream().filter(a -> a
                .getActionType().equals(ActionType.FRIEND_REQUEST) && a.getAffected().getId().equals(user.getId()))
                .forEach(r -> friendRequests.add(r.getActor()));
        return friendRequests;
    }

    public List<User> getBlockedUsersOfUser(User user) {
        List<User> blockedUsers = new ArrayList<>();
        repository.findAll().stream().filter(a -> a
                .getActionType().equals(ActionType.BLOCK) && a.getAffected().getId().equals(user.getId()))
                .forEach(r -> blockedUsers.add(r.getActor()));
        return blockedUsers;
    }
}
