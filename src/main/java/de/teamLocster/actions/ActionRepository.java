package de.teamLocster.actions;

import de.teamLocster.core.BaseRepository;
import de.teamLocster.core.DBController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ActionRepository extends BaseRepository<Action> {

    public ActionRepository() {super(Action.class, DBController.getManager().getEntityManager());}
}