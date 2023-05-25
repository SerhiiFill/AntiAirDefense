import java.util.*;
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
     //   speed=940;
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

        }                                 // здесь сделано так, чтобы не генерировалась высота равная 0 км


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
                                             // здесь диалог выбора цели
            System.out.println("Ціль - ЛІТАК");
            aircraft=true;
            confirmSelect();
            }
        else if (speed>=181 && speed<=280)
            {
            System.out.println("Ціль - ГЕЛІКОПТЕР");
            helix = true;
            confirmSelect();
            }
        else if (speed>=90 && speed<=180)
            {
            System.out.println("Ціль БПЛА");
            bpla = true;
            confirmSelect();
            }
        else if (speed>=281 && speed<=899)
             {
            System.out.println("Ціль - КРИЛАТА РАКЕТА");
            wingm = true;
            confirmSelect();
             }
        else {
            System.out.println("Ціль - БАЛЛІСТИЧНА РАКЕТА!");
            mbr = true;
            confirmSelect();
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

    // Создание хешмэпа в котором зафиксированы поля класса ( параметры цели )
    public void airMonitorData(){

        Map<String, Integer> airData=new LinkedHashMap<>();
        airData.put("Швидкість:",speed);
        airData.put("Висота",alt);
        airData.put("Дистанція",range);
        airData.put("Азимут",azimuth);

        for (Map.Entry<String,Integer> item: airData.entrySet())
        {
            System.out.println(item.getKey() + " " + item.getValue());
        }
    }

       // вывод тревожных сообщений
    public void displayWarning()
    {
        System.out.println("УВАГА! ПОВІТРЯНА ЦІЛЬ!");
        pause();
        System.out.println("......ЙДЕ ОБЧИСЛЕННЯ ДАННИХ.......");
        pause();
        System.out.println();
        pause();
        System.out.println("Шшвидкість : " + speed + "  КМ/год");
        System.out.println("Висота     : "   + alt + "    КМ");
        System.out.println("Дистанція  : " + range + "    КМ");
        System.out.println("Азімут     : " + azimuth + "    ГРАД");
    }
    public void targetManualSelector()             // Ручной выбор типа цели
    {
        System.out.println("Повітряна ціль - ЛІТАК:..................натисни ..'1'");
        System.out.println("Повітряна ціль - ГЕЛІКОПТЕР:.............натисни ..'2'");
        System.out.println("Повітряна ціль - КРИЛАТА РАКЕТА:.........натисни ..'3'");
        System.out.println("Повітряна ціль - БПЛА:...................натисни ..'4'");
        System.out.println("Повітряна ціль - БАЛЛІСТИЧНА РАКЕТА:.....натисни ..'5'");

        String select = scanner.nextLine();
        switch (select) {
            case "1":
                System.out.println("ОК! ----Ручний вибір цілі:------ ЛІТАК! ");
                aircraft = true;

            case "2":
                System.out.println("ОК! ----Ручний вибір цілі:---ГЕЛІКОПТЕР! ");
                helix=true;
            case "3":
                System.out.println("ОК! ----Ручний вибір цілі:--КРИЛАТА РАКЕТА");
                wingm=true;
            case "4":
                System.out.println("ОК! ----Ручний вибір цілі:---БПЛА! ");
                bpla=true;
            case "5":
                System.out.println("ОК! ----Ручний вибір цілі:---БАЛЛІСТИЧНА РАКЕТА ");
                mbr=true;

            default:

                System.out.println("Зробіть вибір!");
                targetManualSelector();
        }
    }
// Диалог подтверждения данных о цели, которые сгенерировались
    public void confirmSelect(){

    System.out.println("Підтверджуєте тип цілі???  Y/N?");
    String select = scanner.nextLine();
                switch (select){
        case "N":
            System.out.println("Ручний вибір цілі: ");
            targetManualSelector();
        case "n":
            System.out.println("Ручний вибір цілі: ");
            targetManualSelector();
        default:
            System.out.print("ОК!  Вибрана ціль: ");
            exitConfirmSelect();
            airMonitorData();
       }

    }
    public void exitConfirmSelect(){
        if (aircraft==true) {
            System.out.println(" ЛІТАК! ");
        } else if (helix==true) {
            System.out.println(" ГЕЛІКОПТЕР! ");
        } else if (wingm==true) {
            System.out.println(" КРИЛАТА РАЕКТА! ");
        } else if (bpla==true) {
            System.out.println(" БПЛА! ");
        }
        else {
            System.out.println("БАЛЛІСТИЧНА РАКЕТА!");
        }

    }

    // Гетеры и сетеры

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

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }
}
