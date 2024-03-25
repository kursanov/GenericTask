package kg.service.impl;

import kg.enums.Gender;
import kg.models.Animal;
import kg.service.GenericService;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class AnimalServiceImpl implements GenericService<Animal> {


    List<Animal> animals = new LinkedList<>();
    @Override
    public String add(List<Animal> t) {
        animals.addAll(t);
        return "Success";
    }

    @Override
    public Animal getById(Long id) {
        for (Animal animal : animals) {
            if (animal.getId().equals(id)){
                System.out.println(animal);
            }
        }
        return null;
    }

    @Override
    public List<Animal> getAll() {
        System.out.println(animals);
        return animals;
    }

    @Override
    public List<Animal> sortByName() {
  Comparator<Animal> comparator = Comparator.comparing(Animal::getName);
        animals.sort(comparator);
        System.out.println(animals);
        return animals;
    }

    @Override
    public List<Animal> filterByGender() {
        List<Animal> maleList = new LinkedList<>();
        List<Animal> femaleList = new LinkedList<>();

        for (Animal animal : animals) {
            if (animal.getGender().equals(Gender.MALE)){
                maleList.add(animal);
            }else femaleList.add(animal);
        }
        System.out.println(maleList);
        System.out.println(femaleList);
        return null;
    }

    @Override
    public List<Animal> clear() {
        animals.clear();
        System.out.println(animals);
        return animals;
    }
}
