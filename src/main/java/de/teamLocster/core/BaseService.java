package de.teamLocster.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BaseService<E extends BaseEntity>
{
    protected BaseRepository<E> repository;

    @Autowired
    public BaseService(BaseRepository<E> repository)
    {
        this.repository = repository;
    }

    public Long save(E entity) {
        return repository.save(entity).getId();
    }
}
