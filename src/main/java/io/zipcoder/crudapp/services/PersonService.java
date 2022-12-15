package io.zipcoder.crudapp.services;

import io.zipcoder.crudapp.models.Person;
import io.zipcoder.crudapp.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;


    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public Iterable<Person> index(){
        return repository.findAll();
    }

    public Person show(Long id){
        return repository.findOne(id); //added method to repo and added casting
    }

    public Person create(Person person){
        return repository.save(person);
    }

    public Person update(Long id, Person newPersonData){
        Person originalPerson = repository.findOne(id);
        originalPerson.setFirstName(newPersonData.getFirstName());
        originalPerson.setLastName(newPersonData.getLastName());
        return repository.save(originalPerson);
    }

    public boolean delete(Long id){
        repository.delete(id);
        return true;
    }
}
