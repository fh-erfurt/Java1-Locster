package de.teamLocster.storages;

import de.teamLocster.core.DBController;
import de.teamLocster.domains.ProfileText;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProfileTextRepository extends BaseRepository<ProfileText> {

    public ProfileTextRepository(){ super(ProfileText.class, DBController.getManager().getEntityManager());}
}
