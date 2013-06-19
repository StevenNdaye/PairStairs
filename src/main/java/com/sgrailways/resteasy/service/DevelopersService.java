package com.sgrailways.resteasy.service;

import com.sgrailways.resteasy.model.Developer;
import com.sgrailways.resteasy.repositories.DevelopersRepository;

import javax.inject.Inject;
import java.sql.SQLException;
import java.util.List;

public class DevelopersService {
    private DevelopersRepository developersRepository;

    @Inject
    public DevelopersService(DevelopersRepository developersRepository) {
        this.developersRepository = developersRepository;
    }

    public List<Developer> list() throws SQLException {
        return developersRepository.list();
    }

    public Developer create(Developer developer) throws SQLException {
       return developersRepository.create(developer);
    }

    public int count() throws SQLException {
        return list().size();
    }

    public void delete(int id) throws SQLException{
        developersRepository.delete(id);
    }
}
