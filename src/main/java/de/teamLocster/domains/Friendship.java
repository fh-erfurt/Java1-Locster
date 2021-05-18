package de.teamLocster.domains;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Friendship extends BaseEntity {

    private long senderID;
    private long receiverID;
    private Date friendSince; // timestamp
    private boolean isAccepted;
}
