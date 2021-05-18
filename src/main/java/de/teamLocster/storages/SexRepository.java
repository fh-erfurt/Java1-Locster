package de.teamLocster.storages;

import de.teamLocster.core.H2Controller;
import de.teamLocster.domains.Sex;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SexRepository extends BaseRepository<Sex> {

    public SexRepository(){super(Sex.class, H2Controller.getManager().getEntityManager());}
}
