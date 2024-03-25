package kg.service.impl;

import kg.enums.Gender;
import kg.models.Animal;
import kg.models.Person;
import kg.service.GenericService;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class PersonServiceImpl implements GenericService<Person> {

    List<Person> people = new LinkedList<>();

    @Override
    public String add(List<Person> t) {
        people.addAll(t);
        return "Success";
    }

    @Override
    public Person getById(Long id) {
        for (Person person : people) {
            if (person.getId().equals(id)){
                System.out.println(person);break;
            }
        }
        return null;
    }

    @Override
    public List<Person> getAll() {
        System.out.println(people);
        return people;
    }

    @Override
    public List<Person> sortByName() {
        Comparator<Person> comparator = Comparator.comparing(Person::getName);
        people.sort(comparator);
        System.out.println(people);
        return people;
    }

    @Override
    public List<Person> filterByGender() {
        List<Person> maleList = new LinkedList<>();
        List<Person> femaleList = new LinkedList<>();

        for (Person person : people) {
            if (person.getGender().equals(Gender.MALE)){
                maleList.add(person);
            }else femaleList.add(person);
        }
        System.out.println(maleList);
        System.out.println(femaleList);
        return null;
    }

    @Override
    public List<Person> clear() {
        people.clear();
        System.out.println(people);
        return people;
    }
}
