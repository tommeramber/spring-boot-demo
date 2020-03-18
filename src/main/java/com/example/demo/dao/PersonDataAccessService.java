package com.example.demo.dao;

import static java.util.Optional.ofNullable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.model.Person;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

@Repository("postgresql")
// @Component == @Repository
public class PersonDataAccessService implements PersonDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPerson(UUID id, Person person) {
        final String sqlQuary = "INSERT INTO person (id, name) VALUES (?, ?); ";
        return jdbcTemplate.update(sqlQuary, id, person.getName());
    }

    @Override
    public List<Person> getAllPeople() {
        final String sqlQuary = "SELECT id, name FROM person";
        return this.jdbcTemplate.query(sqlQuary, (resultSet,rowNum)->{
            return new Person(UUID.fromString(resultSet.getString("id")),resultSet.getString("name"));
        });            
    }

    @Override
    public Optional<Person> getPersonById(UUID id) {
        final String sqlQuary = "SELECT id, name FROM person WHERE id = ?";
        Person person = this.jdbcTemplate.queryForObject(sqlQuary, new Object[]{id}, (resultSet,rowNum)->{
            return new Person(UUID.fromString(resultSet.getString("id")),resultSet.getString("name"));
        }); 
        return Optional.ofNullable(person);
    }

    @Override
    public int deletePersonById(UUID id) {
        final String sqlQuary = "DELETE FROM person WHERE id = ?";
        return jdbcTemplate.update(sqlQuary, id);
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        final String sqlQuary = "UPDATE person SET name = ? WHERE id = ?";
        return jdbcTemplate.update(sqlQuary, person.getName(), id);
    }
}