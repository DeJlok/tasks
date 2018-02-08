package com.semenchuk.refactor.service;

import com.semenchuk.refactor.dao.PersonDAO;
import com.semenchuk.refactor.model.Person;

import java.util.LinkedList;
import java.util.List;

public class PersonService {

    private PersonDAO personDAO;

    public PersonService(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    private boolean haveMobileNumber(Person person) {
        return person.getPhoneNumber().getNumber().startsWith("070");
    }

    public boolean hasMobile(String name) {
        Person person = personDAO.findByName(name);
        return haveMobileNumber(person);
    }

    public int getSize() {
        return personDAO.getCount();
    }

    /**
     * Gets the given user's mobile phone number,
     * or null if he doesn't have one.
     */
    public String getMobile(String name) {
        Person person = personDAO.findByName(name);
        return person.getPhoneNumber().getNumber();
    }

    /**
     * Returns all names in the book truncated to the given length.
     */
    public List<String> getNames(int maxLength) {
        List<String> names = new LinkedList<>();
        for (Person person : personDAO.getAll()) {
            String name = person.getName();
            if (name.length() > maxLength) {
                name = name.substring(0, maxLength);
            }
            names.add(name);
        }
        return names;
    }

    /**
     * Returns all people who have mobile phone numbers.
     */
    public List<Person> getList() {
        List<Person> people = personDAO.getAll();
        List<Person> result = new LinkedList<>();
        for (Person person : people) {
            if (haveMobileNumber(person)) {
                result.add(person);
            }
        }
        return result;
    }


}
