package Service;

// В классе будет описан Iris-T
public class IrisTSAM implements AntiAirFactory {

    private int ammo;
    public IrisTSAM ( int ammo)
    {
        this.ammo=ammo;
    }

    @Override
    public void GenObject() {
        System.out.println("Iris-T" + " " + ammo);
    }

    @Override
    public void launchMissile() {

    }


    public void targetHit() {

    }


    public void randomHit() {

    }

    public void pause () {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "IrisTSAM{" +
                "ammo=" + ammo +
                '}';
    }
}



