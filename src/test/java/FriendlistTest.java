import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FriendlistTest {


    @Test
    public void should_have_empty_waitingFriends () {
        //Given
        User userA = new User();
        User userB = new User();

        //When


        //Then
        assertEquals(0, userA.getFriendlist().getWaitingFriends().size(),"userA and userB should have no entry in waitingFriends");
        assertEquals(0, userB.getFriendlist().getWaitingFriends().size(),"userA and userB should have no entry in waitingFriends");
    }


    @Test
    public void should_have_empty_acceptedFriends () {
        //Given
        User userA = new User();
        User userB = new User();

        //When


        //Then
        assertEquals(0, userA.getFriendlist().getAcceptedFriends().size(),"userA and userB should have no entry in acceptedFriends");
        assertEquals(0, userB.getFriendlist().getAcceptedFriends().size(),"userA and userB should have no entry in acceptedFriends");
    }


    @Test
    public void should_send_friend_request () {
        //Given
        User userA = new User();
        User userB = new User();

        //When
        userA.getFriendlist().sendFriendRequest(userB, userA);

        //Then
        assertEquals(1, userA.getFriendlist().getWaitingFriends().size(),"userA and userB should have one entry in waitingFriends");
        assertEquals(1, userB.getFriendlist().getWaitingFriends().size(),"userA and userB should have one entry in waitingFriends");
    }


    @Test
    public void should_return_correct_sender_and_receiver () {
        //Given
        User userA = new User();
        User userB = new User();

        //When
        userA.getFriendlist().sendFriendRequest(userB, userA);

        //Then
        assertEquals(userA, userA.getFriendlist().getWaitingFriendWithIndex(0).getSender(),"userA should be sender");
        assertEquals(userA, userB.getFriendlist().getWaitingFriendWithIndex(0).getSender(),"userA should be sender");
        assertEquals(userB, userA.getFriendlist().getWaitingFriendWithIndex(0).getReceiver(),"userB should be receiver");
        assertEquals(userB, userB.getFriendlist().getWaitingFriendWithIndex(0).getReceiver(),"userB should be receiver");
    }


    /**
     *    userA sent the friendRequest, userB should be able to accept
     */
    @Test
    public void should_accept_friend_request () {
        //Given
        User userA = new User();
        User userB = new User();
        userA.getFriendlist().sendFriendRequest(userB, userA);

        //When
        userB.getFriendlist().acceptFriendRequest(userB.getFriendlist().getWaitingFriendWithIndex(0), userB);

        //Then
        assertEquals(0, userA.getFriendlist().getWaitingFriends().size(),"userA and userB should have no entry in waitingFriends");
        assertEquals(0, userB.getFriendlist().getWaitingFriends().size(),"userA and userB should have no entry in waitingFriends");
        assertEquals(1, userA.getFriendlist().getAcceptedFriends().size(),"userA and userB should have one entry in acceptedFriends");
        assertEquals(1, userB.getFriendlist().getAcceptedFriends().size(),"userA and userB should have one entry in acceptedFriends");
    }


    /**
     *    userA sent the friendRequest, userA should not be able to accept
     */
    @Test
    public void should_not_accept_friend_request () {
        //Given
        User userA = new User();
        User userB = new User();
        userA.getFriendlist().sendFriendRequest(userB, userA);

        //When
        userA.getFriendlist().acceptFriendRequest(userA.getFriendlist().getWaitingFriendWithIndex(0), userA);

        //Then
        assertEquals(1, userA.getFriendlist().getWaitingFriends().size(),"userA and userB should have one entry in waitingFriends");
        assertEquals(1, userB.getFriendlist().getWaitingFriends().size(),"userA and userB should have one entry in waitingFriends");
        assertEquals(0, userA.getFriendlist().getAcceptedFriends().size(),"userA and userB should have no entry in acceptedFriends");
        assertEquals(0, userB.getFriendlist().getAcceptedFriends().size(),"userA and userB should have no entry in acceptedFriends");
    }


    /**
     *    both users should be able to deny the friendRequest
     */
    @Test
    public void should_deny_friend_request_from_userA () {
        //Given
        User userA = new User();
        User userB = new User();
        userA.getFriendlist().sendFriendRequest(userB, userA);

        //When
        userA.getFriendlist().denyFriendRequest(userA.getFriendlist().getWaitingFriendWithIndex(0));

        //Then
        assertEquals(0, userA.getFriendlist().getWaitingFriends().size(),"userA and userB should have no entry in waitingFriends");
        assertEquals(0, userB.getFriendlist().getWaitingFriends().size(),"userA and userB should have no entry in waitingFriends");
        assertEquals(0, userA.getFriendlist().getAcceptedFriends().size(),"userA and userB should have no entry in acceptedFriends");
        assertEquals(0, userB.getFriendlist().getAcceptedFriends().size(),"userA and userB should have no entry in acceptedFriends");
    }


    /**
     *    both users should be able to deny the friendRequest
     */
    @Test
    public void should_deny_friend_request_from_userB () {
        //Given
        User userA = new User();
        User userB = new User();
        userA.getFriendlist().sendFriendRequest(userB, userA);

        //When
        userB.getFriendlist().denyFriendRequest(userB.getFriendlist().getWaitingFriendWithIndex(0));

        //Then
        assertEquals(0, userA.getFriendlist().getWaitingFriends().size(),"userA and userB should have no entry in waitingFriends");
        assertEquals(0, userB.getFriendlist().getWaitingFriends().size(),"userA and userB should have no entry in waitingFriends");
        assertEquals(0, userA.getFriendlist().getAcceptedFriends().size(),"userA and userB should have no entry in acceptedFriends");
        assertEquals(0, userB.getFriendlist().getAcceptedFriends().size(),"userA and userB should have no entry in acceptedFriends");
    }


    /**
     *   both users should be able to terminate the friendship
     */
    @Test
    public void should_delete_accepted_friend_from_userA () {
        //Given
        User userA = new User();
        User userB = new User();
        userA.getFriendlist().sendFriendRequest(userB, userA);
        userB.getFriendlist().acceptFriendRequest(userB.getFriendlist().getWaitingFriendWithIndex(0), userB);

        //When
        userA.getFriendlist().deleteFriend(userA.getFriendlist().getAcceptedFriendWithIndex(0),userA);

        //Then
        assertEquals(0, userA.getFriendlist().getWaitingFriends().size(),"userA and userB should have no entry in waitingFriends");
        assertEquals(0, userB.getFriendlist().getWaitingFriends().size(),"userA and userB should have no entry in waitingFriends");
        assertEquals(0, userA.getFriendlist().getAcceptedFriends().size(),"userA and userB should have no entry in acceptedFriends");
        assertEquals(0, userB.getFriendlist().getAcceptedFriends().size(),"userA and userB should have no entry in acceptedFriends");
    }


    /**
     *   both users should be able to terminate the friendship
     */
    @Test
    public void should_delete_accepted_friend_from_userB () {
        //Given
        User userA = new User();
        User userB = new User();
        userA.getFriendlist().sendFriendRequest(userB, userA);
        userB.getFriendlist().acceptFriendRequest(userB.getFriendlist().getWaitingFriendWithIndex(0), userB);

        //When
        userB.getFriendlist().deleteFriend(userB.getFriendlist().getAcceptedFriendWithIndex(0),userB);

        //Then
        assertEquals(0, userA.getFriendlist().getWaitingFriends().size(),"userA and userB should have no entry in waitingFriends");
        assertEquals(0, userB.getFriendlist().getWaitingFriends().size(),"userA and userB should have no entry in waitingFriends");
        assertEquals(0, userA.getFriendlist().getAcceptedFriends().size(),"userA and userB should have no entry in acceptedFriends");
        assertEquals(0, userB.getFriendlist().getAcceptedFriends().size(),"userA and userB should have no entry in acceptedFriends");
    }


    /**
     *    tests with more users
     */


    /**
     *    userA has friendRequests from userB to userJ, userA should be able to accept them all
     */
    @Test
    public void should_send_friend_requests_with_more_users () {
        //Given
        User userA = new User();
        User userB = new User();
        User userC = new User();
        User userD = new User();
        User userE = new User();
        User userF = new User();
        User userG = new User();
        User userH = new User();
        User userI = new User();
        User userJ = new User();

        //When
        userB.getFriendlist().sendFriendRequest(userA, userB);
        userC.getFriendlist().sendFriendRequest(userA, userC);
        userD.getFriendlist().sendFriendRequest(userA, userD);
        userE.getFriendlist().sendFriendRequest(userA, userE);
        userF.getFriendlist().sendFriendRequest(userA, userF);
        userG.getFriendlist().sendFriendRequest(userA, userG);
        userH.getFriendlist().sendFriendRequest(userA, userH);
        userI.getFriendlist().sendFriendRequest(userA, userI);
        userJ.getFriendlist().sendFriendRequest(userA, userJ);

        //Then
        assertEquals(9, userA.getFriendlist().getWaitingFriends().size(),"userA should have nine entries in waitingFriends");
        assertEquals(0, userA.getFriendlist().getAcceptedFriends().size(),"userA should have no entry in acceptedFriends");
    }


    /**
     *    userA has friendRequests from userB to userJ, userA should be able to accept them all
     */
    @Test
    public void should_accept_friend_request_with_more_users () {
        //Given
        User userA = new User();
        User userB = new User();
        User userC = new User();
        User userD = new User();
        User userE = new User();
        User userF = new User();
        User userG = new User();
        User userH = new User();
        User userI = new User();
        User userJ = new User();
        userB.getFriendlist().sendFriendRequest(userA, userB);
        userC.getFriendlist().sendFriendRequest(userA, userC);
        userD.getFriendlist().sendFriendRequest(userA, userD);
        userE.getFriendlist().sendFriendRequest(userA, userE);
        userF.getFriendlist().sendFriendRequest(userA, userF);
        userG.getFriendlist().sendFriendRequest(userA, userG);
        userH.getFriendlist().sendFriendRequest(userA, userH);
        userI.getFriendlist().sendFriendRequest(userA, userI);
        userJ.getFriendlist().sendFriendRequest(userA, userJ);

        //When
        while (!userA.getFriendlist().getWaitingFriends().isEmpty()) {
            userA.getFriendlist().acceptFriendRequest(userA.getFriendlist().getWaitingFriendWithIndex(0), userA);
        }

        //Then
        assertEquals(0, userA.getFriendlist().getWaitingFriends().size(),"userA should have no entry in waitingFriends");
        assertEquals(9, userA.getFriendlist().getAcceptedFriends().size(),"userA should have nine entries in acceptedFriends");
    }


    /**
     *    userA has nine friends, userA should be able to terminate all the friendships
     */
    @Test
    public void should_delete_accepted_friend_with_more_users () {
        //Given
        User userA = new User();
        User userB = new User();
        User userC = new User();
        User userD = new User();
        User userE = new User();
        User userF = new User();
        User userG = new User();
        User userH = new User();
        User userI = new User();
        User userJ = new User();
        userB.getFriendlist().sendFriendRequest(userA, userB);
        userC.getFriendlist().sendFriendRequest(userA, userC);
        userD.getFriendlist().sendFriendRequest(userA, userD);
        userE.getFriendlist().sendFriendRequest(userA, userE);
        userF.getFriendlist().sendFriendRequest(userA, userF);
        userG.getFriendlist().sendFriendRequest(userA, userG);
        userH.getFriendlist().sendFriendRequest(userA, userH);
        userI.getFriendlist().sendFriendRequest(userA, userI);
        userJ.getFriendlist().sendFriendRequest(userA, userJ);
        while (!userA.getFriendlist().getWaitingFriends().isEmpty()) {
            userA.getFriendlist().acceptFriendRequest(userA.getFriendlist().getWaitingFriendWithIndex(0), userA);
        }

        //When
        while (!userA.getFriendlist().getAcceptedFriends().isEmpty()) {
            userA.getFriendlist().deleteFriend(userA.getFriendlist().getAcceptedFriendWithIndex(0),userA);
        }

        //Then
        assertEquals(0, userA.getFriendlist().getWaitingFriends().size(),"userA should have no entry in waitingFriends");
        assertEquals(0, userA.getFriendlist().getAcceptedFriends().size(),"userA should have no entry in acceptedFriends");
    }
}
