/*
===================================
== Molham Al-khodari
== Matthias Gabel
== Dirk Hofmann
===================================
*/
package de.teamLocster.User;
    /*
    ===================================
    == Variable
    ===================================
    */

import de.teamLocster.Friends.FriendList;
import de.teamLocster.Friends.FriendListItem;

import java.util.ArrayList;
import java.util.Collections;

public class ProfileStatistic
{
    private final int MAX_VISITS = 10;
    private final int MAX_VISITORS = 10;

    private int viewsTotal;
    private User[] lastVisitors;
    private User[] lastVisits;
    private User latestFriend;
    private User oldestFriend;
    private int visitorsCount;
    private int visitsCount;

    /*
    ===================================
    == Constructor
    ===================================
    */
    public ProfileStatistic()
    {
        viewsTotal = 0;
        lastVisitors = new User[MAX_VISITORS];
        lastVisits   = new User[MAX_VISITS];
        latestFriend = null;
        oldestFriend = null;
        visitorsCount = 0;
        visitsCount = 0;
    }
    /*
    ===================================
    == Methods
    ===================================
    */
    public void succTotal()
    {
        this.viewsTotal ++;
    }

    /**
     * pushes the user in the lastVisitors list and prevent a out of bounce exception
     * @param latestVisitor the latest visitor of our user
     */
    public void updateLastVisitors(User latestVisitor)
    {
        if(this.visitorsCount >= this.lastVisitors.length)
        {
            this.lastVisitors[9]=null;
            --this.visitorsCount;
        }
        if (this.visitorsCount >= 0) System.arraycopy(this.lastVisitors, 0, this.lastVisitors, 1, this.visitorsCount);
        this.lastVisitors[0]=latestVisitor;
        ++this.visitorsCount;
    }

    /**
     * updates 'oldestFriend' for 'executingUser'.
     * 'isAccepting' == true  ==> If 'oldestFriend' is null -> 'oldestFriend' becomes 'friend'
     * 'isAccepting' == false ==> If 'executingUser' ArrayList 'acceptedFriends' is empty -> 'oldestFriend' becomes null, else copy of 'acceptedFriends' is sorted by LocalDateTime in the entries and 'oldestFriend' becomes first entry
     * @param executingUser == calling user
     * @param friend == friend to be added or removed
     * @param isAccepting == checks if 'friend' is to be removed or added
     */
    public void updateOldestFriend(User executingUser, User friend, boolean isAccepting)
    {
        if (isAccepting)
        {
            if (executingUser.getProfileStatistic().getOldestFriend() == null)
            {
                setOldestFriend(friend);
                return;
            }
        }
        else
        {
            if (friend == executingUser.getProfileStatistic().getOldestFriend())
            {
                if (!executingUser.getFriendlist().getAcceptedFriends().isEmpty()) {
                    ArrayList<FriendListItem> sortedList = new ArrayList<FriendListItem>(executingUser.getFriendlist().getAcceptedFriends());
                    Collections.sort(sortedList);
                    executingUser.getProfileStatistic().setOldestFriend(sortedList.get(0).getFriend());
                }
                else executingUser.getProfileStatistic().setOldestFriend(null);
            }
        }
    }

    /**
     * updates 'latestFriend' for 'executingUser'.
     * 'isAccepting' == true  ==> 'latestFriend' becomes 'friend'
     * 'isAccepting' == false ==> If 'executingUser' ArrayList 'acceptedFriends' is empty -> 'latestFriend' becomes null, else copy of 'acceptedFriends' is sorted by LocalDateTime in the entries and 'latestFriend' becomes last entry
     * @param executingUser == calling user
     * @param friend == friend to be added or removed
     * @param isAccepting == checks if 'friend' is to be removed or added
     */
    public void updateLatestFriend(User executingUser, User friend, boolean isAccepting)
    {
        if (isAccepting)
        {
            setLatestFriend(friend);
        }
        else
        {
            if (friend == getLatestFriend())
            {
                if (!executingUser.getFriendlist().getAcceptedFriends().isEmpty())
                {
                    ArrayList<FriendListItem> sortedList = new ArrayList<FriendListItem>(executingUser.getFriendlist().getAcceptedFriends());
                    Collections.sort(sortedList);
                    executingUser.getProfileStatistic().setLatestFriend(sortedList.get(sortedList.size() - 1).getFriend());
                }
                else executingUser.getProfileStatistic().setLatestFriend(null);
            }
        }
    }

    /**
     * pushes the user in the lastVisits list and prevent a out of bounce exception
     * @param latestVisit the user we visit
     */
    public void updateLastVisits(User latestVisit)
    {
        if(this.visitsCount >= this.lastVisits.length)
        {
            this.lastVisits[9]=null;
            --this.visitsCount;
        }
        if (this.visitsCount >= 0) System.arraycopy(this.lastVisits, 0, this.lastVisits, 1, this.visitsCount);
        this.lastVisits[0]=latestVisit;
        ++this.visitsCount;
    }

    /*
    ===================================
    == Getter & Setter
    ===================================
    */
    public int getViewsTotal() {
        return viewsTotal;
    }

    public void setViewsTotal(int viewsTotal) {
        this.viewsTotal = viewsTotal;
    }

    public User[] getLastVisitors() {
        return lastVisitors;
    }

    public void setLastVisitors(User[] lastVisitors) {
        this.lastVisitors = lastVisitors;
    }

    public User[] getLastVisits() {
        return lastVisits;
    }

    public void setLastVisits(User[] lastVisits) {
        this.lastVisits = lastVisits;
    }

    public User getLatestFriend() {
        return latestFriend;
    }

    public void setLatestFriend(User latestFriend) {
        this.latestFriend = latestFriend;
    }

    public User getOldestFriend() {
        return oldestFriend;
    }

    public void setOldestFriend(User oldestFriend) {
        this.oldestFriend = oldestFriend;
    }

    public int getVisitorsCount() {
        return visitorsCount;
    }

    public int getVisitsCount() {
        return visitsCount;
    }
}
