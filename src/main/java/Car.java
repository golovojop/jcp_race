public class Car implements Runnable {

    private String name;
    private Race race;
    private int speed;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car (Race race, int speed, int num) {
        this.name = "Участник #" + num;
        this.race = race;
        this.speed = speed;
    }

    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));

            // Сообщаем о готовности и встаем у стартовой калитки
            System.out.println(this.name + " готов");
            Referee.startGate.countDown();
            Referee.startGate.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

        // Сообщить о победе и записать победителя в протокол соревнований
        if(Referee.winner.compareAndSet(null, name)) {
            System.out.println(this.name + " WIN");
        }
    }
}
