import kg.enums.Gender;
import kg.models.Animal;
import kg.models.Person;
import kg.service.GenericService;
import kg.service.impl.AnimalServiceImpl;
import kg.service.impl.PersonServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GenericService<Animal> animalService = new AnimalServiceImpl();
        List<Animal> animals = List.of(
                new Animal(1L,"Bobik",5, Gender.MALE),
                new Animal(2L,"Taigan",5, Gender.MALE),
                new Animal(3L,"Baltika",7, Gender.FEMALE));
        GenericService<Person> personService = new PersonServiceImpl();
        List<Person> people = List.of(
                new Person(1L,"Myky",18,Gender.MALE),
                new Person(2L,"Aizat",18,Gender.FEMALE),
                new Person(3L,"Zuh",18,Gender.MALE));



        while (true){
            System.out.println("""
                    1.Add animals
                    2.Get by id animal
                    3.Get all animals
                    4.Sort by animal name
                    5.Filter by animal gender
                    6.Clear Animal
                    
                    7.Add people
                    8.Get by id person
                    9.Get all people
                    10.Sort by person name
                    11.Filter by person gender
                    12.Clear animal
                    
                    """);
            switch (new Scanner(System.in).nextInt()){
                case 1:{
                    animalService.add(animals);break;
                }
                case 2:{
                    animalService.getById(2L);break;
                }
                case 3:{
                    animalService.getAll();break;
                }
                case 4:{
                    animalService.sortByName();break;
                }
                case 5:{
                    animalService.filterByGender();break;
                }
                case 6:{
                    animalService.clear();break;
                }
                case 7:{
                    personService.add(people);break;
                }
                case 8:{
                    personService.getById(3L);break;
                }
                case 9:{
                    personService.getAll();break;
                }
                case 10:{
                    personService.sortByName();break;
                }
                case 11:{
                    personService.filterByGender();break;
                }
                case 12:{
                    personService.clear();break;
                }

            }
        }



    }
}