import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class AAEngine {
    // ------------------  пишем и иниализируем поля класса -----------------------

    private int speed;
    private int alt;
    private int range;
    private int azimuth;
    static boolean air;


    public AAEngine(int speed, int alt, int range, int azimuth) {
        this.speed = setSpeed();
        this.alt = setAlt();
        this.range = setRange();
        this.azimuth = setAzimuth();
    }

    // ---------------- инициализируем рандом и сканер ----------------------------
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);


    // ------------------ ИНФОРМАЦИОННЫЕ И ДИАЛОГОВЫЕ ЭКРАНЫ -----------------------
    public void displayWarning() {
        System.out.println("......УВАГА! ПОВІТРЯНА ЦІЛЬ!.....");
        pause();
        System.out.println("......ІДЕ ОБЧИСЛЕННЯ ДАННИХ.......");
        pause();
    }


    //------------------- МЕТОДЫ ДЛЯ ВОЗДУШНЫХ ЦЕЛЕЙ -------------------------------

    //------------------ расчет вероятности поражения конкретного типа цели конкретным ЗРК-----------

    // -------------------генерим скорость -----------------

    public void targetId() {
        System.out.println(" ");
        if (speed >= 900 && speed <= 3500) {
            System.out.println("Ціль розпізнано як літак! :");
            putlinked();
            air = true;
            System.out.println(" ");
            pause();
            System.out.println("ВІРОГІДНСТЬ УРАЖЕННЯ: ");
            System.out.println("ЗРК Patriot .................. 90%");
            System.out.println("ЗРК IRIS-T.................... 95%");
            pause();


        } else if (speed >= 450 && speed <= 899) {
            System.out.println("Ціль розпізнано як крилата ракета! :");
            putlinked();
            pause();
        } else if (speed >= 200 && speed <= 499) {
            System.out.println("Ціль розпізнано як гелікоптер! :");
            putlinked();
            pause();
        } else if (speed >= 90 && speed <= 199) {
            System.out.println("Ціль розпізнано як БПЛА! :");
            putlinked();
            pause();
        } else {
            System.out.println("Ціль розпізнано як баллістична ракета! :");
            putlinked();
            pause();
        }
    }

    public void putlinked() {
        pause();
        Map<String, Integer> airTarget = new LinkedHashMap<>();
        airTarget.put("Швидкість   :", speed);
        airTarget.put("Висота      :", alt);
        airTarget.put("Дистанція   :", range);
        airTarget.put("Азимут      :", azimuth);

        for (Map.Entry<String, Integer> item : airTarget.entrySet()) {
            System.out.println(item.getKey() + "   " + item.getValue());
        }
    }


    public int setSpeed() {
        // int i1 = random.nextInt(2500);
        // speed=i1+899;
        speed = 950;
        return speed;
    }
    // ------------------ генерим расстояние до цели-------------------------

    public int setRange() {
        int r2 = random.nextInt(90);
        range = r2 + 10;

        return r2;
    }
    // ----------- генерим азимут на цель -----------------------------------

    public int setAzimuth() {
        int a2 = random.nextInt(360);
        azimuth = a2;
        return a2;
    }

    // ------------------генерим высоту в зависимости от диапазона скорости-----В КОНЦЕ ДОПИСАТЬ!!!----
    public int setAlt() {
        if (speed >= 3501) {
            int i2 = random.nextInt(39);
            alt = i2 + 21;
        } else if (speed >= 900 && speed <= 3500) { // Высота и скорость  характерная самолетам
            int i2 = random.nextInt(17);
            alt = i2 + 3;
        } else if (speed >= 181 && speed <= 280) {     // Высота и скорость  характерная вертолетам
            int i2 = random.nextInt(4);
            alt = i2 + 1;
        } else if (speed >= 281 && speed <= 899) {   // Высота и скорость  характерная КР
            alt = 1;
        } else if (speed >= 90 && speed <= 180) {   // Высота и скорость  характерная БПЛА
            int i2 = random.nextInt(3);
            alt = i2 + 1;
        } else {
        }
        return alt;
    }
    // ------------------ ТЕХНИЧЕСКИЕ МЕТОДЫ ------------------------------
    public void pause() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

            throw new RuntimeException(e);
        }
    }



        // ----------------- здесь я пишу всякие проверки для себя

        public void setAir ( boolean air){
            this.air = air;
        }
    }


