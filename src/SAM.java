import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// В этом классе будут описаны объекты ПВО
public class SAM {

 public String name;
 public int range;
 public int altitude;
 public int ammo;

    SAM (String name, int range, int altitude, int ammo)
    {
        this.name=name;
        this.range=range;
        this.altitude=altitude;
        this.ammo=ammo;
    }

    Scanner scanner= new Scanner(System.in);









    @Override
    public String toString() {
        return "SAM{" +
                "name='" + name + '\'' +
                ", range=" + range +
                ", altitude=" + altitude +
                ", ammo=" + ammo +
                '}';
    }
}
