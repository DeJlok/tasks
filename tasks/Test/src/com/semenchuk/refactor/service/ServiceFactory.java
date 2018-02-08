package com.semenchuk.refactor.service;

import com.semenchuk.refactor.dao.DAOFactory;
import com.semenchuk.refactor.dao.DataSourceSingleton;
import com.semenchuk.refactor.dao.PersonDAO;
import com.semenchuk.refactor.dao.impl.PersonDAOImpl;

/**
 * Created by MrWhite_PRO on 04.02.2018.
 */
public class ServiceFactory {
    private static PersonService personService;
    public static PersonService getPersonService() {
        if (personService == null) {
            personService= new PersonService(DAOFactory.getPersonDAO());
        }
        return personService;
    }
}
