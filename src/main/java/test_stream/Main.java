package test_stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

class Main {
    public static void main(String[] args) {
//        StringJoiner sj = new StringJoiner(":", "[", "]");
//        sj.add("George").add("Sally").add("Fred");
//        String desiredString = sj.toString();
//        System.out.println(desiredString);


        List<Person> persons = Arrays.asList(new Person("Bill", 30),
                new Person("Alice", 25),
                new Person("Bob", 29),
                new Person("Lers", 44));
//
//        Collector<Person, StringJoiner, String> personNameCollector =
//                Collector.of(
//                        () -> new StringJoiner(" | "),     // supplier
//                        (j, p) -> j.add(p.getName().toUpperCase()), // accumulator
//                        (j1, j2) -> j1.merge(j2),                   // combiner
//                        StringJoiner::toString);                    // finisher
//        String names = persons
//                .stream()
//                .collect(personNameCollector);
//        System.out.println(names);


        /**
         * Моя реализация объекта Collector
         *
         * @supplier - функция создает контейнер для очередного отдельного элемента из стрима
         *
         * @accumulator - функция помещает элемент стрима в контейнер. В данном случае мы получаем
         * из стрима инстанс Person, но забираем из него только строку имени.
         *
         * @combiner - конкатенация контейнеров
         *
         * @finisher - финальная операция над итоговым контейнером
         *
         */
        Supplier<ArrayList<String>> supplier = () -> new ArrayList<String>();
        BiConsumer<ArrayList<String>, Person> accumulator =  (al, p) -> al.add(p.getName());

        BinaryOperator<ArrayList<String>> combiner = (al1, al2) -> {
            al1.addAll(al2);
            return al1;
        };
        Function<ArrayList<String>, String> finisher = ArrayList<String>::toString;

        Collector<Person, ArrayList<String>, String> myCollector = Collector.of(
                supplier,
                accumulator,
                combiner,
                finisher);

        String pNames = persons
                .stream()
                .collect(myCollector);
        System.out.println(pNames);



//                        () -> new ArrayList<String>(),      // supplier
//                        (j, p) -> j.add(p.getName()),       // accumulator
//                        (j1, j2) -> j1.addAll(j2),                   // combiner
//                        ArrayList::toString);                    // finisher



//        StringJoiner sj1 = new StringJoiner(":", "[", "]");
//        sj1.add("a1").add("a2");
//        System.out.println(sj1);
//        StringJoiner sj2 = new StringJoiner("-", "<", ">");
//        sj2.add("b1").add("b2");
//        System.out.println(sj1.merge(sj2));

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