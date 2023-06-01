import Service.AntiAirFactory;

import java.util.Random;
import java.util.Scanner;

// В этом классе будет описано Patriot
public class PatriotSAM implements AntiAirFactory {

    private int hitTarget; // процент верояности попадания по конекретному типу цели
    private int ammo;
    private boolean kill;


    public PatriotSAM(int ammo) {
        this.ammo = ammo;
        this.hitTarget = (targetHit() / 10);
    }

    Random random = new Random();
    Scanner scanner = new Scanner(System.in);


    @Override
    public void genObject() {
        System.out.println("Обрано ЗРК Patriot : " + "Боєкомлект: " + ammo + " ракет. Вірогідність ураження : " + hitTarget + "0%");
        System.out.println(" ");
        if (ammo > 0) {
            launchMissile();
        } else {
            System.out.println("Закінчилсь ракети! ");
        }
    }

    @Override
    public void launchMissile() {
        System.out.println("     ПУСК?      Y/N? ");
        String select = scanner.nextLine();
        if (select.equalsIgnoreCase("Y")) {
            System.out.println("Ракета пішла!");
            flyMissile();
            setKill();

        } else {
            flyTarget();
            AntiAirMain.createSAM("");
        }
    }

    @Override
    public void flyMissile() {
        int r = random.nextInt(20);
        for (int i = 0; i < r; i++) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {

                throw new RuntimeException(e);
            }

            System.out.print(" * ");
        }

    }

    @Override
    public void flyTarget() {
        int r = random.nextInt(7);
        for (int i = 0; i < r; i++) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {

                throw new RuntimeException(e);
            }

            System.out.print(" * Ціль наближається! ");
        }
            System.out.println(" ");
    }

    @Override
    public void setAmmo(int ammo) {
        System.out.println(ammo);
    }

    @Override
    public void getAmmo() {
        System.out.println(ammo);
    }


    //  --------------------------- Цей метод розраховує ураження чи промах  -------------------
    public boolean setKill() {
        ammo = ammo - 1;
        int i = random.nextInt(10);// тимчасово вірогіднсть зменшена до 10% щоб було простіше тестувати
        if (i <= hitTarget) {
            kill = true;
            System.out.print("Ціль уражено!");
            pause();
            System.out.println("     Залишок боєкомплекту:  " + ammo);
        } else {
            kill = false;
            System.out.print("    Промах!");
            pause();
            System.out.println("    Залишок боєкомплекту:  " + ammo);
            genObject();
        }
        return kill;
    }

    // --------------  цей метод дає вірогідность ураження в залежності від типу цілі ----------------------
    public int targetHit() {
        if (AAEngine.air = true) {
            hitTarget = 10;
        } else {
            System.out.println("ERROR!!");
        }
        return hitTarget;
    }

    public void pause() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

            throw new RuntimeException(e);
        }
    }

// ------------------ Далі, методи, які ще не дороблені


}



