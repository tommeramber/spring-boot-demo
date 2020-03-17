package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.model.Person;

import org.springframework.stereotype.Repository;

/**
 * FakePersonDataAccessService
 */
@Repository("postgresql")
// @Component == @Repository
public class PersonDataAccessService implements PersonDao {

    @Override
    public int insertPerson(UUID id, Person person) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Person> getAllPeople() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<Person> getPersonById(UUID id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int deletePersonById(UUID id) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        // TODO Auto-generated method stub
        return 0;
    }
}