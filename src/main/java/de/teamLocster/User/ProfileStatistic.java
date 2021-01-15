package de.teamLocster.User;

import java.util.Arrays;
import java.util.List;

public class ProfileStatistic {
    private int viewsTotal;
    private List<User> lastVisitors;
    private List<User> lastVisits;
    private User latestFriend;
    private User oldestFriend;

    public ProfileStatistic()
    {
        lastVisitors = Arrays.asList(new User[10]);
        lastVisits   = Arrays.asList(new User[10]);
    }

    public void succTotal()
    {
        this.viewsTotal ++;
    }

    public void updateLastVisitors(User latestVisitor)
    {
        this.lastVisitors.add(0, latestVisitor);
    }

    public void updateLastVisits(User latestVisit)
    {
        this.lastVisits.add(0, latestVisit);
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

    public List<User> getLastVisitors() {
        return lastVisitors;
    }

    public void setLastVisitors(List<User> lastVisitors) {
        this.lastVisitors = lastVisitors;
    }

    public List<User> getLastVisits() {
        return lastVisits;
    }

    public void setLastVisits(List<User> lastVisits) {
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
