package de.teamLocster.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

    @OneToOne(cascade = CascadeType.PERSIST)
    private PersonalInfo personalInfo;
    @OneToOne(cascade = CascadeType.PERSIST)
    private ProfileStatistic profileStatistic;
    @OneToOne(cascade = CascadeType.PERSIST)
    private AccountDetails accountDetails;
    private String personalStatus;
    private PrivacyStatus privacyStatus;
    private OnlineStatus onlineStatus;
}