package de.teamLocster.friends;


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
public class Friendship extends BaseEntity
{

    @ManyToOne
    @JoinColumn(name="sender", referencedColumnName = "id")
    private User sender;
    @ManyToOne
    @JoinColumn(name="receiver", referencedColumnName = "id")
    private User receiver;
    private Date friendSince;
    private boolean isAccepted;
}
