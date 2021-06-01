package de.teamLocster.statistics;

import de.teamLocster.core.BaseRepository;
import de.teamLocster.core.DBController;
import de.teamLocster.statistics.ProfileStatistic;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProfileStatisticRepository extends BaseRepository<ProfileStatistic>
{

    public ProfileStatisticRepository(){ super(ProfileStatistic.class, DBController.getManager().getEntityManager());}
}
