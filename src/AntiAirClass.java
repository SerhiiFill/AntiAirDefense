import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

// В этом классе будут описаны объекты ПВО
public class AntiAirClass {

 private String name;
 private int range;
 private int altmax;
 private int ammo;

    AntiAirClass(String name, int range, int altmax, int ammo)
    {
        this.name=name;
        this.range=range;
        this.altmax =altmax;
        this.ammo=ammo;

    }

     Scanner scanner= new Scanner(System.in);



    @Override
    public String toString() {
        return "SAM{" +
                "name='" + name + '\'' +
                ", range=" + range +
                ", altitude=" + altmax +
                ", ammo=" + ammo +
                '}';
    }

    // Диалог выбор ЗРК

    public void selectSAM()
    {
        System.out.println("Вибір ЗРК для ураження :");
        System.out.println("ЗРК Patriot..................натисни ..'1'");
        System.out.println("ЗРК IRIS-T...................натисни ..'2'");
        System.out.println("ЗРК NASAMS...................натисни ..'3'");
        System.out.println("ЗРК HAWK.....................натисни ..'4'");
        System.out.println("ПЗРК STINGER.................натисни ..'5'");

        String select = scanner.nextLine();
        switch (select) {
            case "1":
                System.out.println("--------------------------------- ");
                System.out.println("Вибрано Patriot ");

                Map<String, Integer> samData=new LinkedHashMap<>();

                samData.put("Дальність ураження :",range);
                samData.put("Максимальна висота ураження :",altmax);
                samData.put("Боєкомлект",ammo);

                for (Map.Entry<String,Integer> item: samData.entrySet())
                {
                    System.out.println(item.getKey() + " " + item.getValue());
                }
                System.out.println("??ПУСК??........ Y/N" );
                launch();
                break;

            case "2":
                System.out.println("--------------------------------- ");
                System.out.println("Вибрано Patriot ");

                Map<String, Integer> samData=new LinkedHashMap<>();

                samData.put("Дальність ураження :",range);
                samData.put("Максимальна висота ураження :",altmax);
                samData.put("Боєкомлект",ammo);

                for (Map.Entry<String,Integer> item: samData.entrySet())
                {
                    System.out.println(item.getKey() + " " + item.getValue());
                }
                System.out.println("??ПУСК??........ Y/N" );
                launch();
                break;

            case "3":

            case "4":

            case "5":

            default:

                System.out.println("Зробіть вибір!");

        }

    }
    public void launch()
    {
        String select = scanner.nextLine();
        switch (select)
        {
            case "Y":
            case "y":
                System.out.println("РАКЕТА ПІШЛА!");
                // Здесь (наверное) дописать уменьшение БК конкретного ЗРК
                break;
            default:
                selectSAM();
        }
    }

}
