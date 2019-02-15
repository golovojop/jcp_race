package test_stream;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collector;

class Main {
    public static void main(String[] args) {
//        StringJoiner sj = new StringJoiner(":", "[", "]");
//        sj.add("George").add("Sally").add("Fred");
//        String desiredString = sj.toString();
//        System.out.println(desiredString);


//        List<Person> persons = Arrays.asList(new Person("Bill", 30),
//                new Person("Alice", 25),
//                new Person("Bob", 29),
//                new Person("Lers", 44));
//
//        Collector<Person, StringJoiner, String> personNameCollector =
//                Collector.of(
//                        () -> new StringJoiner(" | "),          // supplier
//                        (j, p) -> j.add(p.getName().toUpperCase()),  // accumulator
//                        (j1, j2) -> j1.merge(j2),               // combiner
//                        StringJoiner::toString);                // finisher
//
//        String names = persons
//                .stream()
//                .collect(personNameCollector);
//
//        System.out.println(names);

        StringJoiner sj1 = new StringJoiner(":", "[", "]");
        sj1.add("a1").add("a2");
        StringJoiner sj2 = new StringJoiner("-", "<", ">");
        sj2.add("b1").add("b2");

        System.out.println(sj1.merge(sj2));



    }
}


class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return name;
    }
}