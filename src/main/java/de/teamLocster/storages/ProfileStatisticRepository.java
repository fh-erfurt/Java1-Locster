package de.teamLocster.storages;

import de.teamLocster.core.DBController;
import de.teamLocster.domains.ProfileStatistic;
import de.teamLocster.domains.ProfileText;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProfileStatisticRepository extends BaseRepository<ProfileStatistic> {

    public ProfileStatisticRepository(){ super(ProfileStatistic.class, DBController.getManager().getEntityManager());}
}
