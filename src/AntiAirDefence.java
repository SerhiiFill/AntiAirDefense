public class AntiAirDefence {
    public static void main(String[] args) {


        Aircraft aircraft = new Aircraft();


        AntiAirClass Patriot = new AntiAirClass("Patriot", 185,55,6);
        AntiAirClass IrisT = new AntiAirClass("IrisT",100,35,16);
        AntiAirClass Nasams = new AntiAirClass("Nasams", 80,25,8);
        AntiAirClass Hawk = new AntiAirClass("Hawk", 20,8,8);
        AntiAirClass Stinger = new AntiAirClass("Stinger", 5,3,999);

        aircraft.displayWarning();
        aircraft.printTargetType();
        Patriot.selectSAM();

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