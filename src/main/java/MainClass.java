import java.util.ArrayList;
import java.util.List;

public class MainClass {
    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        // Подготовить трассу
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));

        // Дать старт
        List<Thread> li = new ArrayList<>();
        for(int i = 0; i < CARS_COUNT; i++) {
            Thread t = new Thread(new Car(race, 20 + (int) (Math.random() * 10)));
            li.add(t);
            t.start();
        }

        // Ждем завершения
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        for(Thread t : li) {
            try {
                t.join();
            } catch (InterruptedException e) {e.printStackTrace();}
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}