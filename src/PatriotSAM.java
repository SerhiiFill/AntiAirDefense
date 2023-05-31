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
        System.out.println(" ");
        if (ammo>0)
        {
        launchMissile();
        }
        else {
            System.out.println("Закінчилсь ракети! ");
            AntiAirMain.createSAM("");
        }
    }

    @Override
    public void launchMissile()
    {   System.out.println("     ПУСК?      Y/N? ");
        String select=scanner.nextLine();
        if (select.equalsIgnoreCase("Y") && select.equalsIgnoreCase("y")){
            System.out.println("Ракета пішла!");
            flyMissile();
            setKill();

        } else {
            System.out.println("ЧТо-то пошло не так!");
        }
    }


    // --------------  цей метод дає вірогідность ураження в залежності від типу цілі ----------------------
    public int targetHit ()
    {
        if (AAEngine.air=true) {
            hitTarget=10;
        } else {
            System.out.println("ERROR!!");
        }
        return hitTarget;
    }

    //  --------------------------- Цей метод розраховує ураження чи промах  -------------------
    public boolean setKill (){
            ammo=ammo-1;
            int i=random.nextInt(10);
                 if (i<=hitTarget) {
                  kill=true;
                     System.out.println("Ціль уражено!");
                     pause();
                     System.out.println("Залишок боєкомплекту:  "+ammo);
                      }
                 else {
                         kill=false;
                        System.out.println("    Промах!");
                        pause();
                        System.out.println("Залишок боєкомплекту:  "+ammo);
                        GenObject();}
        return kill;
    }

    public void pause () {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

            throw new RuntimeException(e);
        }
    }

    @Override
    public void flyMissile() {
        int r=random.nextInt(30);
        for(int i = 0; i < r; i++) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {

                throw new RuntimeException(e);
            }

            System.out.print(" * ");
        }

    }

}




