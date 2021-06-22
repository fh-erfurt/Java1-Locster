package de.teamLocster.actions;

import de.teamLocster.core.BaseRepository;
import de.teamLocster.core.BaseService;
import de.teamLocster.enums.ActionType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ActionService extends BaseService<Action>
{
    public ActionService(BaseRepository<Action> actionRepository)
    {
        super(actionRepository);
    }

    public void findActionsByType(ActionType type) {
        List<Action> actions = repository.findAll();
    }
}
