package de.teamLocster.storages;

import de.teamLocster.domains.BaseEntity;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
public abstract class BaseRepository<E extends BaseEntity> {

    protected final Class<E> type;
    protected final EntityManager entityManager;

    public Long save(E entity){

        entityManager.getTransaction().begin();
        if (Objects.isNull(entity.getId())){
            entityManager.persist(entity);
        } else {
            entityManager.merge(entity);
        }
        entityManager.getTransaction().commit();
        return entity.getId();
    }

    public Optional<E> findBy(Long id){
        return Optional.ofNullable(entityManager.find(type, id));
    }

    public List<E> findAll(){
        final String sql = "SELECT entity FROM " + type.getCanonicalName() + " entity";
        return entityManager.createQuery(sql, type).getResultList();
    }

    public void delete(E entity){
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }

    public void deleteAll(){
        entityManager.getTransaction().begin();
        entityManager.createQuery("DELETE FROM " + type.getCanonicalName()).executeUpdate();
        entityManager.getTransaction().commit();
    }
}