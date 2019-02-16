import java.util.ArrayList;
import java.util.List;

public class MainClass {

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        // Подготовить трассу
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));

        // Дать старт
        List<Thread> li = new ArrayList<>();
        for(int i = 1; i <= Referee.CARS_COUNT; i++) {
            Thread t = new Thread(new Car(race, 20 + ((int) (Math.random() * 10)), i));
            li.add(t);
            t.start();
        }

        try {
            Referee.startGate.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            for(Thread t : li) {
                t.join();
            }

        } catch (InterruptedException e) {e.printStackTrace();}

        // Ждем завершения
//        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
//        for(Thread t : li) {
//            try {
//                t.join();
//            } catch (InterruptedException e) {e.printStackTrace();}
//        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        System.out.println("\n*** Победил: " + Referee.winner.get() + " ***");
    }
}