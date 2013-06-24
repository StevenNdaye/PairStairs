package com.sgrailways.resteasy.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "developers")
public class Developer {

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String name;

    public Developer() {
        // ORMLite needs a no-arg constructor
    }

    public Developer(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
