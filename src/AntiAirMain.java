import Service.AntiAirFactory;
import Service.IrisTSAM;

import java.util.Scanner;

public class AntiAirMain {
    public static void main(String[] args) {

       AAEngine aaEngine = new AAEngine(0,0,0,0);

        aaEngine.displayWarning();
        aaEngine.targetId();

        AntiAirFactory antiAirFactory = createSAM("");

        antiAirFactory.genObject();



    }

// ---------- Метод создающий новую сущность после выбора ---------------
    public static AntiAirFactory createSAM(String select) {
        Scanner scanner= new Scanner(System.in);
        System.out.println(" ");
        System.out.println("ОБЕРІТЬ ЗАСІБ УРАЖЕННЯ : ");
        System.out.println("1          SAM  PATRIOT");
        System.out.println("2          SAM  IRIS-T");
        select = scanner.nextLine();

        if (select.equalsIgnoreCase("1")) {
            return new PatriotSAM(2);           // ---------тимчасово бк зменшено до двох ракет -----------

        } else if (select.equalsIgnoreCase("2")) {
            return new IrisTSAM(8);

        } else {
            System.out.println("Ціль наближається!!!");
            createSAM(select);
        }
        return createSAM("");
    }

}




