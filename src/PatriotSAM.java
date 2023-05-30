import Service.AntiAirFactory;

import java.util.Random;
import java.util.Scanner;

// В этом классе будет описано Patriot
public class PatriotSAM implements AntiAirFactory {

    private int hitTarget; // процент верояности попадания по конекретному типу цели
    private int ammo;
    private boolean kill;
    public PatriotSAM ( int ammo)
    {
        this.ammo=ammo;
        this.hitTarget=(targetHit()/10);
    }

    Random random=new Random();
    Scanner scanner=new Scanner(System.in);



    @Override
    public void GenObject() {
        System.out.println("Обрано ЗРК Patriot : " + "Боєкомлект: " + ammo +" ракет. Вірогідність ураження : " +hitTarget+"0%");
    }

    @Override
    public void launchMissile()
    {
        System.out.println("     ПУСК?      Y/N? ");
        String select=scanner.nextLine();
        if (select.equalsIgnoreCase("Y") && select.equalsIgnoreCase("y")){
            System.out.println("Ракета пішла!");
            ammo=ammo-1;
            setKill();
            System.out.println(kill);


        } else {
            System.out.println("ЧТо-то пошло не так!");
        }
    }

    // --------------  цей метод дає вірогідность ураження в залежності від типу цілі ----------------------
    public int targetHit ()
    {
        if (AAEngine.air=true) {
            hitTarget=50;
        } else {
            System.out.println("ERROR!!");
        }
        return hitTarget;
    }

    public boolean setKill (){
        int i=random.nextInt(10);
        System.out.println("KILL "+i);
        System.out.println("Hit = "+hitTarget);
        if (i<=hitTarget) {
            kill=true;
        }
        else {
            kill=false;
        }
        return kill;
    }
//  --------------------------- Цей метод розраховує ураження чи промах  -------------------

    public void pause () {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

            throw new RuntimeException(e);
        }
    }
}




