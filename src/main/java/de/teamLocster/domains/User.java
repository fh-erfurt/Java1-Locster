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

    private Long personalInfoID;
    private Long profileStatisticID;
    private Long accountDetailsID;
    private Long personalStatus;
    private Long privacyStatusID;
    private Long onlineStatusID;
}
