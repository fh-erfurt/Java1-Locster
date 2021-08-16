/*das ganze funktioniert nicht */

package de.teamLocster.guestbook;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserPost {

    private String content;
    private  Long creator_id;
    private  Long userId;
}
