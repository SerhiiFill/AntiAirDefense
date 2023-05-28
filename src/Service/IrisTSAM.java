package Service;

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
    public String toString() {
        return "IrisTSAM{" +
                "ammo=" + ammo +
                '}';
    }
}



