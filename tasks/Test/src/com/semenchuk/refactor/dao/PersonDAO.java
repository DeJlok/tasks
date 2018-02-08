package com.semenchuk.refactor.dao;

import com.semenchuk.refactor.model.Person;

import java.util.List;

/**
 * Created by MrWhite_PRO on 04.02.2018.
 */
public interface PersonDAO {
    void save(Person person);

    Person findByName(String name);

    List<Person> getAll();

    int getCount();
}
