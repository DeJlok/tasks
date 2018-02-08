package com.semenchuk.refactor.dao.impl;

import com.semenchuk.refactor.dao.PersonDAO;
import com.semenchuk.refactor.dao.util.JDBCTemplate;
import com.semenchuk.refactor.dao.util.ResultSetExtractor;
import com.semenchuk.refactor.model.Person;
import com.semenchuk.refactor.model.PhoneNumber;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public final class PersonDAOImpl implements PersonDAO {

    private final JDBCTemplate jdbcTemplate;
    private static final String INSERT = "insert into PersonEntry values (?, ?, ?)";
    private static final String FIND_BY_NAME = "select * from PersonEntry where name like ?";
    private static final String FIND_ALL = "select * from PersonEntry";
    private static final String GET_PERSON_COUNT = "select COUNT(*) from PersonEntry";

    private ResultSetExtractor<Person> extractor = new ResultSetExtractor<Person>() {
        @Override
        public Person extractData(ResultSet resultSet) throws SQLException {
            Person person = new Person();
            person.setName(resultSet.getString("name"));
            person.setDate(resultSet.getDate("date"));
            person.setPhoneNumber(new PhoneNumber(resultSet.getString("phoneNumber")));
            return person;
        }
    };

    public PersonDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JDBCTemplate(dataSource);
    }

    @Override
    public void save(Person person) {
        jdbcTemplate.insert(INSERT, person.getDate().getTime(), person.getName(), person.getPhoneNumber().getNumber());
    }

    /**
     * Looks up the given person, null if not found.
     */
    @Override
    public Person findByName(String name) {
        return jdbcTemplate.queryWithParameters(FIND_BY_NAME, extractor, name);
    }

    @Override
    public List<Person> getAll() {
        return jdbcTemplate.queryForList(FIND_ALL, extractor);
    }

    @Override
    public int getCount() {
        return jdbcTemplate.queryWithParameters(GET_PERSON_COUNT, resultSet -> resultSet.getInt(1));

    }

}
