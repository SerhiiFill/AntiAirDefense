import java.util.Random;

public class Aircraft {

    public int speed;

    public Aircraft() {
    }

    public int randomSpeed(){

       Random random = new Random();

      int speed2 = random.nextInt(10000);
        speed=speed2;

        return speed;
    }


}
