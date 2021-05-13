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
public class Friendship extends BaseEntity {

    private String sender;
    private String receiver;
    private String friendSince; // timestamp
    private boolean isAccepted;
}
