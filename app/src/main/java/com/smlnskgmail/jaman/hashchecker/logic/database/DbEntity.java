package com.smlnskgmail.jaman.hashchecker.logic.database;

import com.j256.ormlite.field.DatabaseField;

public class DbEntity {

    @DatabaseField(generatedId = true)
    private long id = -1;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
