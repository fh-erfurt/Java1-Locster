package de.teamLocster.guestbook;

import de.teamLocster.core.BaseEntity;
import de.teamLocster.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class GuestbookEntry extends BaseEntity
{

    @ManyToOne
    private User creator;
    @ManyToOne
    private User user;
    private String content;
    private Date sentAt;
    private Date editedAt;
    private boolean edited;
}
