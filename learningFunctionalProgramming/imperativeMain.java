import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class imperativeMain {
    public static void main(String[] args) {
        List<Person> people = List.of(
            new Person("John", Gender.MALE),
            new Person("Maria", Gender.FEMALE),
            new Person("Aisha", Gender.FEMALE),
            new Person("Alex", Gender.MALE),
            new Person("Alice", Gender.FEMALE)
        );

        //Imperative Approach
        System.out.println("//Imperative Approach");
        List<Person> females = new ArrayList<>();

        for(Person p:people){
            if(p.gender.equals(Gender.FEMALE)){ // we can also do 'FEMALE.equals(p.gender)'
                females.add(p);
            }
        }
        for(Person f:females){
            System.out.println(f);
        }
        System.out.println();

        //Declarative approach
        System.out.println("//Declarative Approach");
        people.stream()
            .filter(p -> p.gender.equals(Gender.FEMALE))
            .forEach(System.out::println);
    }

    static class Person {
        private String name;
        private Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person [name=" + name + ", gender=" + gender + "]";
        }

    }

    enum Gender {
        MALE, FEMALE;
    }
}
