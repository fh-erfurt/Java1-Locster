package de.teamLocster.storages;

import de.teamLocster.core.H2Controller;
import de.teamLocster.domains.PrivacyStatus;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrivacyStatusRepository extends BaseRepository<PrivacyStatus> {

    public PrivacyStatusRepository() {super(PrivacyStatus.class, H2Controller.getManager().getEntityManager());}
}
