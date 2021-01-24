/*
===================================
Molham Al khodari
===================================
*/
package de.teamLocster.User;

import java.util.Arrays;
import java.util.List;

    /*
    ===================================
    Variable
    ===================================
    */

public class ProfileStatistic
{
    private final int MAX_VISITS = 10;
    private final int MAX_VISITORS = 10;

    private int viewsTotal;
    private User[] lastVisitors;
    private User[] lastVisits;
    private User latestFriend;
    private User oldestFriend;
    /*
    ===================================
    Constructor
    ===================================
    */
    public ProfileStatistic()
    {
        lastVisitors = new User[MAX_VISITORS];
        lastVisits = new User[MAX_VISITS];
    }
    /*
    ===================================
    Methods
    ===================================
    */
    public void succTotal()
    {
        this.viewsTotal ++;
    }

    public void updateLastVisitors(User latestVisitor)
    {
        if (this.lastVisitors.length<MAX_VISITORS)
        {
            this.lastVisitors[lastVisitors.length] = latestVisitor;
        }
        else
        {
            this.lastVisitors[0]=latestVisitor; //TODO: das logik stimmt nicht ganz...
        }
    }

    public void updateLastVisits(User latestVisit)  //for(User visit : this.lastVisit) {......};
    {
        if (this.lastVisits.length<MAX_VISITORS)
        {
            this.lastVisits[lastVisits.length] = latestVisit;
        }
        else
        {
            this.lastVisits[0] = latestVisit; //TODO: das logik stimmt nicht ganz...
        }
    }

    /*
    ===================================
    Getter & Setter
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
}
