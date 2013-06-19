package com.sgrailways.resteasy.repositories;

import com.google.inject.Inject;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.sgrailways.resteasy.model.Developer;

import java.sql.SQLException;
import java.util.List;

import static com.j256.ormlite.dao.DaoManager.createDao;

public class DevelopersRepository {
    private Dao<Developer, Integer> developerDao;


    @Inject
    public DevelopersRepository(ConnectionSource connectionSource) {
        try {
             developerDao = createDao(connectionSource, Developer.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Developer> list() throws SQLException {
            return developerDao.queryForAll();

    }

    public Developer create(Developer developer) throws SQLException {
        developerDao.create(developer);
        return developer;
    }
}
