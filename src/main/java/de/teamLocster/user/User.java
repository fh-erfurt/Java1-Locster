package de.teamLocster.user;

import de.teamLocster.core.BaseEntity;
import de.teamLocster.guestbook.GuestbookEntry;
import de.teamLocster.statistics.ProfileStatistic;
import de.teamLocster.enums.OnlineStatus;
import de.teamLocster.enums.PrivacyStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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

    /*
    @Lob
    private Byte[] profilePicture; // TODO client muss Dateityp kennen
    */

    // @Lob CLOB in DB für Kodierung von Umlauten bzw. deutschen Zeichen
    private String profileText;
    @OneToOne(cascade = CascadeType.PERSIST)
    private PersonalInfo personalInfo;
    @OneToOne(cascade = CascadeType.PERSIST)
    private ProfileStatistic profileStatistic;
    private String personalStatus;
    @Enumerated(EnumType.ORDINAL)
    private PrivacyStatus privacyStatus;
    @Enumerated(EnumType.ORDINAL)
    private OnlineStatus onlineStatus;
    @OneToMany(mappedBy = "user")  // fetch = FetchType.LAZY
    private Set<GuestbookEntry> guestbook = new HashSet<>();
    /*
    @OneToMany(mappedBy = "sender OR receiver")  // TODO how to map friendships
    private Set<Friendship> friends = new HashSet<>(); */
}