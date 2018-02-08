package com.semenchuk.refactor.dao;

import com.semenchuk.refactor.dao.impl.PersonDAOImpl;

/**
 * Created by MrWhite_PRO on 04.02.2018.
 */
public class DAOFactory {
    private static PersonDAO personDAO;


    public static PersonDAO getPersonDAO() {
        if (personDAO == null) {
            personDAO = new PersonDAOImpl(DataSourceSingleton.getInstance());
        }
        return personDAO;
    }
}
