package de.teamLocster.actions;

import static org.junit.Assert.assertTrue;

import de.teamLocster.core.errors.NoFriendRequestPresentException;
import de.teamLocster.user.User;
import de.teamLocster.user.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ActionTest {

    @Autowired
    ActionService actionService;

    @Autowired
    ActionRepository actionRepository;

    @Autowired
    UserRepository userRepository;


    User user1 = new User();
    User user2 = new User();
    User user3 = new User();

    @BeforeEach
    public void beforeEach() {
        user1.setFirstName("Uno");
        user2.setFirstName("Dos");
        user3.setFirstName("Tres");

        user1 = userRepository.save(user1);
        user2 = userRepository.save(user2);
        user3 = userRepository.save(user3);
    }

    @AfterEach
    public void afterEach() {
        // actionRepository.deleteAll();
        // userRepository.deleteAll();
    }

    @Test
    void sendFriendRequest() {
        actionService.sendFriendRequest(user1, user2);
        actionService.sendFriendRequest(user3, user1);
        actionService.sendFriendRequest(user3, user2);

        List<User> requests = actionService.getReceivedFriendRequests(user2);
        List<Long> ids = new ArrayList<>();
        for (User fr : requests) ids.add(fr.getId());

        assertTrue("User1 should appear in User2's friend requests", ids.contains(user1.getId()));
        assertTrue("User3 should appear in User2's friend requests", ids.contains(user3.getId()));
    }

    @Test
    void acceptFriendRequest() throws NoFriendRequestPresentException {
        actionService.sendFriendRequest(user1, user2);
        actionService.sendFriendRequest(user3, user1);

        actionService.acceptFriendRequest(user2, user1);
        actionService.acceptFriendRequest(user1, user3);

        List<User> friendsOfUser1 = actionService.getFriends(user1);
        List<Long> ids1 = new ArrayList<>();
        friendsOfUser1.forEach(f -> ids1.add(f.getId()));

        List<User> friendsOfUser2 = actionService.getFriends(user2);
        List<Long> ids2 = new ArrayList<>();
        friendsOfUser2.forEach(f -> ids2.add(f.getId()));

        List<User> friendsOfUser3 = actionService.getFriends(user3);
        List<Long> ids3 = new ArrayList<>();
        friendsOfUser3.forEach(f -> ids3.add(f.getId()));

        assertTrue("User3 should appear in User1's friends", ids1.contains(user3.getId()));
        assertTrue("User1 should appear in User2's friends", ids2.contains(user1.getId()));
        assertTrue("User1 should appear in User3's friends", ids3.contains(user1.getId()));
        assertTrue("User2 should appear in User1's friends", ids1.contains(user2.getId()));
    }

    @Test
    void blockUser() {
        actionService.blockUser(user1, user2);
        actionService.blockUser(user1, user3);

        List<User> blockedUsers = actionService.getBlockedUsers(user1);
        List<Long> ids = new ArrayList<>();
        for (User fr : blockedUsers) ids.add(fr.getId());

        assert ids.contains(user2.getId());
        assert ids.contains(user3.getId());
    }
}
