package sg.edu.nus.iss.vttp5_ssf_day13l.repo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.vttp5_ssf_day13l.model.Person;

@Repository
public class PersonRepo {

    private List<Person> persons = new ArrayList<>(); 

    public PersonRepo() {

        LocalDate dob = LocalDate.of(2000, 12, 24);
        Person person = new Person("Jo Yie", "Leong", 3500, "joyieleong@gmail.com", dob, "83394927", 509506);
        persons.add(person);

        dob = LocalDate.of(1997, 10, 28);
        person = new Person("Kit Ling", "Leong", 5000, "kitlingleong@gmail.com", dob, "83300928", 506509);
        persons.add(person);

    }

    public List<Person> findAll() {
        return persons;
        
    }

    public Person findById(String personId) {
        Person foundPerson = persons.stream().filter(p -> p.getId().equals(personId)).findFirst().get();

        return foundPerson;

    }

    public Boolean create(Person person) {
        persons.add(person);
        return true;

    }

    public Boolean delete(Person person) {
        int iFoundPerson = persons.indexOf(person);

        if (iFoundPerson >= 0) {
            persons.remove(person);
            return true;

        }

        return false; 

    }

    public Boolean update(Person person) { 
        List<Person> filteredPerson = persons.stream().filter(p -> p.getId().equals(person.getId())).collect(Collectors.toList());
        
        if (filteredPerson.size() >= 0) {
            persons.remove(filteredPerson.getFirst()); 
            persons.add(person);
            return true;

        }

        return false;

    }
    
}
