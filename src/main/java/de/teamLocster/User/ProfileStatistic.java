/*
===================================
== edited by
== Molham Al-khodari
== Matthias Gabel
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
    private int visitorsCount;
    private int visitsCount;

    /*
    ===================================
    Constructor
    ===================================
    */
    public ProfileStatistic()
    {
        lastVisitors = new User[MAX_VISITORS];
        lastVisits   = new User[MAX_VISITS];
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

    /**
     *      UPDATELASTVISITORS: THIS METHOD EXPECTS A USER WHO HAS VISITED OUR PROFILES
     *      CHECKS FIRST WHETHER THE ARRAY IS FULL IF THAT IS THE CASE, THE OLDEST VISITOR
     *      WILL BE DELETED AND THE NEWEST VISITOR WILL BE ADDED TO THE LIST
     */


    public void updateLastVisitors(User latestVisitor)
    {
        if(this.visitorsCount >= this.lastVisitors.length)
        {
            this.lastVisitors[9]=null;
            --this.visitorsCount;
        }
        for (int i= this.visitorsCount; i > 0; --i)
        {
            this.lastVisitors[i] = this.lastVisitors[i-1];
        }
        this.lastVisitors[0]=latestVisitor;
        ++this.visitorsCount;
    }

    /**
     *
     * UPDATELASTVISITS: THIS METHOD EXPECTS A USER WE VISITED HIM
     * CHECKS FIRST WHETHER THE ARRAY IS FULL IF THAT IS THE CASE, THE OLDEST VISITS
     * WILL BE DELETED AND THE NEWEST VISITS WILL BE ADDED TO THE LIST
     */

    public void updateLastVisits(User latestVisit)
    {
        if(this.visitsCount >= this.lastVisits.length)
        {
            this.lastVisits[9]=null;
            --this.visitsCount;
        }
        for (int i= this.visitsCount; i > 0; --i)
        {
            this.lastVisits[i] = this.lastVisits[i-1];
        }
        this.lastVisits[0]=latestVisit;
        ++this.visitsCount;
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

    public int getVisitorsCount() {
        return visitorsCount;
    }

    public int getVisitsCount() {
        return visitsCount;
    }
}
