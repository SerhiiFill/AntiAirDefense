import Service.AntiAirFactory;

// В этом классе будут описаны объекты ПВО и методы свойственные только им
public class PatriotSAM implements AntiAirFactory {

    private int ammo;
    public PatriotSAM ( int ammo)
    {
        this.ammo=ammo;
    }

    @Override
    public void GenObject() {
        System.out.println("Patriot" + " " + ammo);
    }

    @Override
    public String toString() {
        return "PatriotSAM{" +
                "ammo=" + ammo +
                '}';
    }
}



