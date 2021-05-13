package de.teamLocster.storages;

import de.teamLocster.domains.RelationshipStatus;

public class RelationshipStatusRepository extends BaseRepository<RelationshipStatus> {
    public RelationshipStatusRepository() { super(RelationshipStatus.class, H2Controller.getManager().getEntityManager()); }

}
