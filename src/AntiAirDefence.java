import java.sql.SQLOutput;

public class AntiAirDefence {
    public static void main(String[] args) {


        Aircraft aircraft = new Aircraft();
        SAM nasams = new SAM("NASAMS", 24,25,8);

        aircraft.displayWarning();

        aircraft.printTargetSelector();

        // это проверка работы printTargetSelector
        System.out.println();
        System.out.println("______________________________________");
        System.out.println();
        System.out.println("Літак  " + aircraft.aircraft);
        System.out.println("Гелікоптер  " + aircraft.helix);
        System.out.println("Криалата ракета  " + aircraft.wingm);
        System.out.println("БПЛА  " + aircraft.bpla);
        System.out.println("МБР  " + aircraft.mbr);

    }

}