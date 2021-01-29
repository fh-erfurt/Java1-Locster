/*
===================================
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
