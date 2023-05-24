public class AntiAirDefence {
    public static void main(String[] args) {


        Aircraft aircraft = new Aircraft();

        SAM Patriot = new SAM("Patriot", 185,55,6);
        SAM IrisT = new SAM("IrisT",100,35,16);
        SAM Nasams = new SAM("Nasams", 80,25,8);
        SAM Hawk = new SAM("Hawk", 20,8,8);
        SAM Stinger = new SAM("Stinger", 5,3,999);

        aircraft.displayWarning();
        aircraft.printTargetType();
        /*
        // это проверка работы разного
        System.out.println();
        System.out.println("______________________________________");
        System.out.println();
        System.out.println("Літак  " + aircraft.isAircraft());
        System.out.println("Гелікоптер  " + aircraft.isHelix());
        System.out.println("Крилата ракета  " + aircraft.isWingm());
        System.out.println("БПЛА  " + aircraft.isBpla());
        System.out.println("МБР  " + aircraft.isMbr());

        System.out.println(Patriot);
        System.out.println(IrisT);
        System.out.println(Nasams);
        System.out.println(Hawk);
        System.out.println(Stinger);

        */
   }
}