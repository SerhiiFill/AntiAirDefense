package Service;

public interface IRadar {

    void speed();
    void alt ();
    void azimuth();
    void range();

    default void print()
    {
        System.out.println("Radar");
    }
}
