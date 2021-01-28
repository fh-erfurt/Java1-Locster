/*
===================================
== Dirk Hofmann
===================================
*/
package de.teamLocster.Friends;

import de.teamLocster.User.User;
import de.teamLocster.Exceptions.CannotSendFriendRequestException;
import de.teamLocster.Exceptions.CannotAcceptFriendRequestException;
import de.teamLocster.Utility.TestUtility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FriendListTest
{
    User userA;
    User userB;
    User userC;
    User userD;
    User userE;
    User userF;
    User userG;
    User userH;
    User userI;
    User userJ;

    @BeforeEach
    public void init()
    {
        userA = TestUtility.getNewUserForTesting();
        userB = TestUtility.getNewUserForTesting();
        userC = TestUtility.getNewUserForTesting();
        userD = TestUtility.getNewUserForTesting();
        userE = TestUtility.getNewUserForTesting();
        userF = TestUtility.getNewUserForTesting();
        userG = TestUtility.getNewUserForTesting();
        userH = TestUtility.getNewUserForTesting();
        userI = TestUtility.getNewUserForTesting();
        userJ = TestUtility.getNewUserForTesting();
    }

    /**
     *  tests if userA´s and userB´s 'waitingFriends' ArrayList has one entry after userA sent userB a friend request
     */
    @Test
    public void should_send_friend_request ()
    {
        //Given


        //When
        userA.getFriendlist().sendFriendRequest(userB, userA);

        //Then
        assertEquals(1, userA.getFriendlist().getWaitingFriends().size(),"userA and userB should have one entry in waitingFriends");
        assertEquals(1, userB.getFriendlist().getWaitingFriends().size(),"userA and userB should have one entry in waitingFriends");
    }


    /**
     * tests if userA´s and userB´s entry in 'waitingFriends' ArrayList has the correct sender and receiver
     */
    @Test
    public void should_return_correct_sender_and_receiver ()
    {
        //Given


        //When
        userA.getFriendlist().sendFriendRequest(userB, userA);

        //Then
        assertEquals(userA, userA.getFriendlist().getWaitingFriendWithIndex(0).getSender(),"userA should be sender");
        assertEquals(userA, userB.getFriendlist().getWaitingFriendWithIndex(0).getSender(),"userA should be sender");
        assertEquals(userB, userA.getFriendlist().getWaitingFriendWithIndex(0).getReceiver(),"userB should be receiver");
        assertEquals(userB, userB.getFriendlist().getWaitingFriendWithIndex(0).getReceiver(),"userB should be receiver");
    }


    /**
     * tests if userA cannot send a friend request to userA
     */
    @Test
    public void should_throw_CannotSendFriendRequestException()
    {
        //Given


        //When

        //Then
        assertThrows(CannotSendFriendRequestException.class, () -> userA.getFriendlist().sendFriendRequest(userA, userA));
    }


    /**
     * tests if userA´s friend request can be accepted by userB
     */
    @Test
    public void should_accept_friend_request ()
    {
        //Given
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
     * tests if userA´s friend request cannot be accepted by userA
     */
    @Test
    public void should_throw_CannotAcceptFriendRequestException()
    {
        //Given
        userA.getFriendlist().sendFriendRequest(userB, userA);

        //When

        //Then
        assertThrows(CannotAcceptFriendRequestException.class, () -> userA.getFriendlist().acceptFriendRequest(userA.getFriendlist().getWaitingFriendWithIndex(0), userA));
    }


    /**
     * tests if userA can deny the friend request by userA
     */
    @Test
    public void should_deny_friend_request_from_userA ()
    {
        //Given
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
     * tests if userB can deny the friend request by userA
     */
    @Test
    public void should_deny_friend_request_from_userB ()
    {
        //Given
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
     * tests if UserA can remove the friendship with userB
     */
    @Test
    public void should_remove_accepted_friend_from_userA ()
    {
        //Given
        userA.getFriendlist().sendFriendRequest(userB, userA);
        userB.getFriendlist().acceptFriendRequest(userB.getFriendlist().getWaitingFriendWithIndex(0), userB);

        //When
        userA.getFriendlist().removeFriend(userA.getFriendlist().getAcceptedFriendWithIndex(0),userA);

        //Then
        assertEquals(0, userA.getFriendlist().getWaitingFriends().size(),"userA and userB should have no entry in waitingFriends");
        assertEquals(0, userB.getFriendlist().getWaitingFriends().size(),"userA and userB should have no entry in waitingFriends");
        assertEquals(0, userA.getFriendlist().getAcceptedFriends().size(),"userA and userB should have no entry in acceptedFriends");
        assertEquals(0, userB.getFriendlist().getAcceptedFriends().size(),"userA and userB should have no entry in acceptedFriends");
    }


    /**
     * tests if UserB can remove the friendship with userA
     */
    @Test
    public void should_remove_accepted_friend_from_userB ()
    {
        //Given
        userA.getFriendlist().sendFriendRequest(userB, userA);
        userB.getFriendlist().acceptFriendRequest(userB.getFriendlist().getWaitingFriendWithIndex(0), userB);

        //When
        userB.getFriendlist().removeFriend(userB.getFriendlist().getAcceptedFriendWithIndex(0),userB);

        //Then
        assertEquals(0, userA.getFriendlist().getWaitingFriends().size(),"userA and userB should have no entry in waitingFriends");
        assertEquals(0, userB.getFriendlist().getWaitingFriends().size(),"userA and userB should have no entry in waitingFriends");
        assertEquals(0, userA.getFriendlist().getAcceptedFriends().size(),"userA and userB should have no entry in acceptedFriends");
        assertEquals(0, userB.getFriendlist().getAcceptedFriends().size(),"userA and userB should have no entry in acceptedFriends");
    }


    /**
     * tests with more users
     */


    /**
     * tests if userA can receive friendRequests from userB to userJ
     */
    @Test
    public void should_send_friend_requests_with_more_users ()
    {
        //Given


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
     * tests if userA can accept friendRequests from userB to userJ
     */
    @Test
    public void should_accept_friend_request_with_more_users ()
    {
        //Given
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
     * tests if UserA can remove the friendship with userB to userJ
     */
    @Test
    public void should_remove_accepted_friend_with_more_users ()
    {
        //Given
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
            userA.getFriendlist().removeFriend(userA.getFriendlist().getAcceptedFriendWithIndex(0),userA);
        }

        //Then
        assertEquals(0, userA.getFriendlist().getWaitingFriends().size(),"userA should have no entry in waitingFriends");
        assertEquals(0, userA.getFriendlist().getAcceptedFriends().size(),"userA should have no entry in acceptedFriends");
    }
}