public class AntiAirDefence {
    public static void main(String[] args) {


        Aircraft aircraft = new Aircraft();

        SAM nasams = new SAM("NASAMS", 24,25,8);

        aircraft.displayWarning();

        aircraft.printTargetType();

        // это проверка работы разного
        System.out.println();
        System.out.println("______________________________________");
        System.out.println();
        System.out.println("Літак  " + aircraft.isAircraft());
        System.out.println("Гелікоптер  " + aircraft.isHelix());
        System.out.println("Крилата ракета  " + aircraft.isWingm());
        System.out.println("БПЛА  " + aircraft.isBpla());
        System.out.println("МБР  " + aircraft.isMbr());

        System.out.println(nasams);
    }
}