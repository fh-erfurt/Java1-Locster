package de.teamLocster.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.*;
import java.util.Objects;


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
