package de.teamLocster.storages;

import de.teamLocster.core.H2Controller;
import de.teamLocster.domains.OnlineStatus;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OnlineStatusRepository extends BaseRepository<OnlineStatus> {

    public OnlineStatusRepository() {super(OnlineStatus.class, H2Controller.getManager().getEntityManager());}

}
