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
import java.sql.Timestamp;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity
{

    private String eMailAddress;
    private String passwordHash;

    private String firstName;
    private String lastName;
    private String region;
    private Timestamp birthDay;
    private String occupation;
    @Enumerated(EnumType.ORDINAL)
    private RelationshipStatus relationshipStatus;
    @Enumerated(EnumType.ORDINAL)
    private Sex sex;

    /*
    @Lob
    private Byte[] profilePicture; // TODO client muss Dateityp kennen
    */
    private String profilePicture;
    // @Lob CLOB in DB für Kodierung von Umlauten bzw. deutschen Zeichen
    private String profileText;
    private String personalStatus;
    @Enumerated(EnumType.ORDINAL)
    private PrivacyStatus privacyStatus;
    @Enumerated(EnumType.ORDINAL)
    private OnlineStatus onlineStatus;
    Boolean isOnline;
}