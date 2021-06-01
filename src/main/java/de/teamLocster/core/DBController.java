package de.teamLocster.core;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class DBController
{
    private static final String PERSISTENCE_UNIT = "de.locster.jpa.mariaDB";

    private static DBController instance;

    private final EntityManagerFactory factory;

    public static DBController getManager() {
        if (Objects.isNull(instance)) {
            instance = new DBController(Persistence.createEntityManagerFactory(PERSISTENCE_UNIT));
        }
        return instance;
    }

    public EntityManager getEntityManager(){
        return factory.createEntityManager();
    }

}
