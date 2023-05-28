import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class AAEngine {
    // ------------------  пишем и иниализируем поля класса -----------------------
    private String name;
    private int speed;
    private int alt;
    private int altmax;
    private int range;
    private int rangemax;
    private int azimuth;
    private int ammo;

    public AAEngine(String name,int speed, int alt, int altmax,int rangemax, int range, int azimuth, int ammo) {
        this.name = name;
        this.speed = setSpeed();
        this.alt = setAlt();
        this.altmax = altmax;
        this.range = setRange();
        this.rangemax=rangemax;
        this.azimuth = setAzimuth();
        this.ammo = ammo;
    }

    // ---------------- инициализируем рандом и сканер ----------------------------
    Random random = new Random();
    Scanner scanner= new Scanner(System.in);




    // ------------------ ИНФОРМАЦИОННЫЕ И ДИАЛОГОВЫЕ ЭКРАНЫ -----------------------
    public void displayWarning()
    {
        System.out.println("......УВАГА! ПОВІТРЯНА ЦІЛЬ!.....");
        pause();
        System.out.println("......ІДЕ ОБЧИСЛЕННЯ ДАННИХ.......");
        pause();
    }



    //------------------- МЕТОДЫ ДЛЯ ВОЗДУШНЫХ ЦЕЛЕЙ -------------------------------

    // -------------------генерим скорость -----------------

    public void targetId ()
    {
        if (speed>=900 && speed<=3500) {
            System.out.println("Ціль розпізнано як літак! :");

            Map<String, Integer> airplane=new LinkedHashMap<>();
            airplane.put("Швидкість   :",speed);
            airplane.put("Висота      :",alt);
            airplane.put("Дистанція   :",range);
            airplane.put("Азимут      :",azimuth);

            for (Map.Entry<String,Integer> item: airplane.entrySet())
            {
                System.out.println(item.getKey() + "     " + item.getValue());
            }

        } else {
            System.out.println(".......ЦІЛЬ НЕ РОЗПІЗНАНО!........");
                }
    }
    public int setSpeed ()
    {
        int i1 = random.nextInt(10000);
        speed=i1+90;

        return i1;
    }
    // ------------------ генерим расстояние до цели-------------------------

    public int setRange(){
        int r2 = random.nextInt(90);
        range=r2+10;

        return r2;
    }
    // ----------- генерим азимут на цель -----------------------------------

    public int setAzimuth ()
    {
        int a2 = random.nextInt(360);
        azimuth =a2;
        return a2;
    }

    // ------------------генерим высоту в зависимости от диапазона скорости-----В КОНЦЕ ДОПИСАТЬ!!!----
    public int setAlt ()
    {
        if (speed>=3501)
        {
            int i2 = random.nextInt(39);
            alt=i2+21;
        }  else if (speed>=900 && speed<=3500 ){ // Высота и скорость  характерная самолетам
            int i2 = random.nextInt(17);
            alt=i2+3;
        }  else if (speed>=181 && speed<=280){     // Высота и скорость  характерная вертолетам
            int i2 = random.nextInt(4);
            alt=i2+1;
        }  else if (speed>=281 && speed<=899){   // Высота и скорость  характерная КР
            alt=1;
        }  else if (speed>=90 && speed<=180) {   // Высота и скорость  характерная БПЛА
            int i2 = random.nextInt(3);
            alt = i2 + 1; }
        else {
        }
        return alt;
    }

    //---------------------МЕТОДЫ ДЛЯ ЗРК--------------------------------------------

    //-------------- метод запускает ракету и уменьшает ammo на единицу --------------------
    public void launchMissile()
    {
        System.out.println("???ЗАПУСК РАКЕТИ???           Y/N");
        String select = scanner.nextLine();
        switch (select) {
            case "y":
                System.out.println("Ракета пішла!  ");
                setAmmo();
                System.out.println("Залишок ракет :" + ammo);
                break;
            default:
                System.out.println("Здесь ничего не происходит");
        }
    }

    public int setAmmo ()
        {
            int a3=ammo;
            return a3;
        }

   // ------------------ ТЕХНИЧЕСКИЕ МЕТОДЫ ------------------------------
    public void pause ()
    {
        try     {
            Thread.sleep(500);
        }
        catch (InterruptedException e) {

            throw new RuntimeException(e);
        }
    }


    // ----------------- здесь я пишу всякие проверки для себя
     public void print(){

     }
}

