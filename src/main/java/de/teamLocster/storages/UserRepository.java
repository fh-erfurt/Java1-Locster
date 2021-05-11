package de.teamLocster.storages;

import de.teamLocster.domains.User;
import de.teamLocster.core.H2Controller;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Slf4j
public class UserRepository extends BaseRepository<User> {

    public UserRepository() {
        super(User.class, H2Controller.getManager().getEntityManager());
    }

    public Optional<User> findBy(String lastName){

        TypedQuery<User> query = entityManager.createQuery("SELECT person FROM " + User.class.getCanonicalName() + " person WHERE person.lastName = :lastname", User.class);
        query.setParameter("lastname", lastName);

        List<User> loaded = query.getResultList();

        if(loaded.isEmpty()){
            return Optional.empty();
        }

        return Optional.of(loaded.get(0));
    }
}