package de.teamLocster.user;

import de.teamLocster.core.BaseEntity;
import de.teamLocster.friends.Friendship;
import de.teamLocster.guestbook.GuestbookEntry;
import de.teamLocster.statistics.ProfileStatistic;
import de.teamLocster.enums.OnlineStatus;
import de.teamLocster.enums.PrivacyStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity
{

    private String eMailAddress;
    private String passwordHash;

    private String profileText;
    @OneToOne(cascade = CascadeType.PERSIST)
    private PersonalInfo personalInfo;
    @OneToOne(cascade = CascadeType.PERSIST)
    private ProfileStatistic profileStatistic;
    private String personalStatus;
    private PrivacyStatus privacyStatus;
    private OnlineStatus onlineStatus;
    @OneToMany(mappedBy = "user")
    private Set<GuestbookEntry> guestbook = new HashSet<>();
    /*
    @OneToMany(mappedBy = "sender OR receiver")  // TODO how to map friendships
    private Set<Friendship> friends = new HashSet<>(); */
}