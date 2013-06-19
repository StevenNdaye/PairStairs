package com.sgrailways.resteasy;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.name.Names;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.sgrailways.resteasy.controllers.DevelopersController;
import com.sgrailways.resteasy.repositories.DevelopersRepository;
import com.sgrailways.resteasy.service.DevelopersService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class HeyWorldModule implements Module {
    @Override
    public void configure(Binder binder) {

        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream("/environments/dev/application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        Names.bindProperties(binder, properties);
        JdbcConnectionSource connectionSource = null;

        try {
            connectionSource = new JdbcConnectionSource(
                    properties.getProperty("databaseUrl"),
                    properties.getProperty("databaseUser"),
                    properties.getProperty("databasePassword"));
        } catch (SQLException e) {
            e.printStackTrace();
        }


        binder.bind(DevelopersController.class);
        binder.bind(DevelopersService.class);
        binder.bind(ConnectionSource.class).toInstance(connectionSource);
        binder.bind(DevelopersRepository.class);
    }
}
