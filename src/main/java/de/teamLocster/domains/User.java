package de.teamLocster.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

    private String personalInfoID;
    private String profileStatisticID;
    private String accountDetailsID;
    private String personalStatus;
    private String privacyStatusID;
    private String onlineStatusID;
}
