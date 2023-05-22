import java.util.Random;
import java.util.Scanner;

public class Aircraft {

    private int speed;
    private int alt;
    private int range;
    private int azimuth;
    private boolean aircraft;
    private boolean helix;
    private boolean wingm;
    private boolean bpla;
    private boolean mbr;

    Random random = new Random();
    Scanner scanner= new Scanner(System.in);

    public Aircraft()   // генерируем и иниализируем случайные значения для полей класса при вызове конструктора
    {
       int i1 = random.nextInt(10000);
       speed=i1+90;

       // С этого места генерируется высота в зависимости от диапазона скорости

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
            System.out.println("Ціль - БАЛЛІСТИЧНА РАКЕТА!");

        }// здесь сделано так, чтобы не генерировалась высота равная 0 км


        int s2 = random.nextInt(90);
        range=s2+10;                              // здесь сделано так, чтобы не генерировалась дистанция меньше 10км
        int a2 = random.nextInt(360);
        azimuth =a2;

    }
    // метод, описывающий логику определения типа цели
    public void printTargetType()
        {
        if (speed>=900 && speed<=3500)
            {
           // здесь писать диалог выбора при помощи сканера
            System.out.println("Ціль - ЛІТАК");
                System.out.println("Підтверджуєте тип цілі???  Y/N?");
                String select = scanner.nextLine();
                if (select=="n"){
                    System.out.println("Виберіть самостійно тип цілі : ");
                } else
                    aircraft = true;
            }
        else if (speed>=181 && speed<=280)
            {
            System.out.println("Ціль - ГЕЛІКОПТЕР");
            helix = true;
            }
        else if (speed>=90 && speed<=180)
            {
            System.out.println("Ціль БПЛА");
            bpla = true;
            }
        else if (speed>=281 && speed<=899)
             {
            System.out.println("Ціль - КРИЛАТА РАКЕТА");
            wingm = true;
             }
        else {
            System.out.println("Ціль - БАЛЛІСТИЧНА РАКЕТА!");
            mbr = true;
             }
        }
    //         Метод будет использоваться как пауза
    public void pause ()
    {
        try     {
            Thread.sleep(500);
        }
        catch (InterruptedException e) {

            throw new RuntimeException(e);
        }
    }

    // Метод описывающий подтверждение типа цели и логику выбора средств поражения

    public void targetSelector()
    {

    }

    // вывод тревожных сообщений
    public void displayWarning()
    {
        System.out.println("УВАГА! ПОВІТРЯНА ЦІЛЬ!");
        pause();
        System.out.println("......ЙДЕ ОБЧИСЛЕННЯ ДАННИХ.......");
        pause();
        pause();
        System.out.println();
        pause();
        pause();
        System.out.println("Шшвидкість : " + speed + "  КМ/год");
        System.out.println("Висота     : "   + alt + "    КМ");
        System.out.println("Дистанція  : " + range + "    КМ");
        System.out.println("Азімут     : "   + alt + "    ГРАД");
    }

    public boolean isAircraft() {
        return aircraft;
    }

    public void setAircraft(boolean aircraft) {
        this.aircraft = aircraft;
    }

    public boolean isHelix() {
        return helix;
    }

    public void setHelix(boolean helix) {
        this.helix = helix;
    }

    public boolean isWingm() {
        return wingm;
    }

    public void setWingm(boolean wingm) {
        this.wingm = wingm;
    }

    public boolean isBpla() {
        return bpla;
    }

    public void setBpla(boolean bpla) {
        this.bpla = bpla;
    }

    public boolean isMbr() {
        return mbr;
    }

    public void setMbr(boolean mbr) {
        this.mbr = mbr;
    }
}
