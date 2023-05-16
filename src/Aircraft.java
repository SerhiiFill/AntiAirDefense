import java.util.Random;
import java.util.Scanner;

public class Aircraft {

    public int speed;
    public int alt;
    public int range;
    public int azimuth;
    public int type;
    Random random = new Random();
    Scanner scanner= new Scanner(System.in);

    public Aircraft()   // генерируем случайные значения для полей класса при вызове конструктора
    {

        int i1 = random.nextInt(10000);
        speed=i1;
        int i2 = random.nextInt(50);
        alt=i2;
        int s2 = random.nextInt(100);
        range=s2;
        int a2 = random.nextInt(360);
        azimuth =a2;


    }
        public void pause (){  // будет использоваться как пауза
        try     {
            Thread.sleep(500);
              }
        catch (InterruptedException e) {

            throw new RuntimeException(e);
        }


    }

    public void displayWarning() {          // вывод тревожных сообщений

        System.out.println("УВАГА! ПОВІТРЯНА ЦІЛЬ!");
        pause();
        System.out.println("......ЙДЕ ОБЧИСЛЕННЯ ДАННИХ.......");
        pause();
        pause();
        //   System.out.println("......ЙДЕ ОБЧИСЛЕННЯ ДАННИХ.......");
        System.out.println();
        pause();
        pause();
        System.out.println("Шшвидкість : " + speed + "  КМ/год");
        System.out.println("Висота     : "   + alt + "    КМ");
        System.out.println("Дистанція  : " + range + "    КМ");
        System.out.println("Азімут     : "   + alt + "    ГРАД");
    }

    public int targetSelector ()   // метод, описывающий логику определения типа цели
        {
        if (speed>=0 && speed<=3500) {
            System.out.println("Test1");
            System.out.println(speed);
            type =1;

        }
        else {
            System.out.println("Test2");
            System.out.println(speed);}
           // type=2;
        return type;
        }

}
