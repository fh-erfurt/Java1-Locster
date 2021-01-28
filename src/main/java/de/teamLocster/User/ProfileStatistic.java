/*
===================================
== edited by
== Molham Al-khodari
== Matthias Gabel
===================================
*/
package de.teamLocster.User;
    /*
    ===================================
    == Variable
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
    == Constructor
    ===================================
    */
    public ProfileStatistic()
    {
        lastVisitors = new User[MAX_VISITORS];
        lastVisits   = new User[MAX_VISITS];
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
        if (this.visitorsCount >= 0) System.arraycopy(this.lastVisitors, 0, this.lastVisitors, 1, this.visitorsCount);
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
