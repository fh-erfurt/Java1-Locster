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

public class GuestbookEntry extends BaseEntity {

    private long creatorID;
    private long userID;  // muss es abgespeichert werden?
    private String text;
    private Date sentAt;
    private Date editedAt;
    private boolean edited;
}
