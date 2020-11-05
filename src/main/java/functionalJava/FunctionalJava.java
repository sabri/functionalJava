package functionalJava;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FunctionalJava {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("sabri", Gender.male),
                new Person("sabrina", Gender.female),
                new Person("sabrino", Gender.male),
                new Person("sabrine", Gender.female),
                new Person("saber", Gender.male)

        );
        //imperative programming
        System.out.println(" //imperative programming");
        List<Person> females = new ArrayList<>();
        for (Person person : people) {
            if (Gender.female.equals(person.getGender())) {
                females.add(person);
            }
        }
        for (Person female : females) {
            System.out.println(female);
        }
// declarative programming
        System.out.println(" //declarative programming");
         people.stream().filter(person -> person.getGender().equals(Gender.female))
                 .collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("other way without collector");
        people.stream().filter(person -> person.getGender().equals(Gender.female)).forEach(System.out::println);
        System.out.println("other way2 using list");
 List<Person> females2 = people.stream().filter(person -> person.getGender().equals(Gender.female)).collect(Collectors.toList());
females2.forEach(System.out::println);
        System.out.println("other way3 using Predicate");

        Predicate<Person> filter1 = (person)->person.getGender().equals(Gender.female)==true;
        people.stream().filter(filter1).peek(System.out::println);


    }




}