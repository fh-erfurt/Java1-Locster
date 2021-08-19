package de.teamLocster.user;

import de.teamLocster.core.BaseEntity;
import de.teamLocster.enums.RelationshipStatus;
import de.teamLocster.enums.Sex;
import de.teamLocster.enums.OnlineStatus;
import de.teamLocster.enums.PrivacyStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {
    @Column(unique = true)
    private String emailAddress;
    private String passwordHash;

    private String firstName;
    private String lastName;
    private String region;
    private LocalDate birthDay;
    private String occupation;
    @Enumerated(EnumType.ORDINAL)
    private RelationshipStatus relationshipStatus;
    @Enumerated(EnumType.ORDINAL)
    private Sex sex;

    private String profilePicture = "/images/profilePic.png";
    private String profileText;
    private String personalStatus;
    @Enumerated(EnumType.ORDINAL)
    private PrivacyStatus privacyStatus;
    @Enumerated(EnumType.ORDINAL)
    private OnlineStatus onlineStatus;
    Boolean isOnline;

    public int getAge() {
        return LocalDate.now().minusDays(birthDay.toEpochDay()).getYear() - 1970;
    }
}