package de.teamLocster.user;

import de.teamLocster.core.BaseRepository;
import de.teamLocster.user.PersonalInfo;
import de.teamLocster.core.DBController;

import lombok.extern.slf4j.Slf4j;


import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;


@Slf4j
public class PersonalInfoRepository extends BaseRepository<PersonalInfo>
{

    public PersonalInfoRepository() {
        super(PersonalInfo.class, DBController.getManager().getEntityManager());
    }

    public Optional<PersonalInfo> findBy(String lastName){

        TypedQuery<PersonalInfo> query = entityManager.createQuery("SELECT person FROM " + PersonalInfo.class.getCanonicalName() + " person WHERE person.lastName = :lastname", PersonalInfo.class);
        query.setParameter("lastname", lastName);

        List<PersonalInfo> loaded = query.getResultList();

        if(loaded.isEmpty()){
            return Optional.empty();
        }

        return Optional.of(loaded.get(0));
    }
}
