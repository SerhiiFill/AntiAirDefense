import Service.AntiAirFactory;
import Service.IrisTSAM;

import java.util.Scanner;

public class AntiAirMain {
    public static void main(String[] args) {

       AntiAirFactory antiAirFactory = createSAM("2");

      System.out.println(antiAirFactory);

    }

    public static AntiAirFactory createSAM(String select) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("ОБЕРІТЬ ЗАСІБ УРАЖЕННЯ :");
        System.out.println("1...........PATRIOT");
        System.out.println("2...........IRIS-T");
        select = scanner.nextLine();

        if (select.equalsIgnoreCase("1")) {
            return new PatriotSAM(6);
        } else if (select.equalsIgnoreCase("2")) {
            return new IrisTSAM(8);
        } else {
            System.out.println("Ціль наближається!!!");
            createSAM(select);
        }
        return null;
    }

}




