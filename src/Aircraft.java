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

      //  int i1 = random.nextInt(10000);
      //  speed=i1;
        speed = 300;

        if (speed>=3501){
            int i2 = random.nextInt(39);
            alt=i2+21;
            }  else if (speed>=900 && speed<=3500 ){
            int i2 = random.nextInt(17);
            alt=i2+3;
            } else if (speed>=90 && speed<=180){
                     int i2 = random.nextInt(2);
            alt=i2+1;
            }
                            // здесь сделано так, чтобы не генерировалась высота равная 0 км
        int s2 = random.nextInt(90);
        range=s2+10;                              // здесь сделано так, чтобы не генерировалась дистанция меньше 10км
        int a2 = random.nextInt(360);
        azimuth =a2;

    }


    // метод, описывающий логику определения типа цели
    public void targetSelector (){

        if (speed>=900 && speed<=3500 && alt>3 && alt<=19) {
            System.out.println("Ціль - Літак");
            System.out.println(speed);
               }
        else if (speed>=90 && speed<=180 && alt>1 && alt<=3) {

            System.out.println("Ціль БПЛА");

                }
        else {
            System.out.println("Ціль - баллістична ракета!");
             }
        }
    // будет использоваться как пауза
    public void pause (){
        try     {
            Thread.sleep(500);
        }
        catch (InterruptedException e) {

            throw new RuntimeException(e);
        }

    }

    // вывод тревожных сообщений
    public void displayWarning() {

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

}
