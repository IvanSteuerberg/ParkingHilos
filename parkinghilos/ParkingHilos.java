package parkinghilos;

/**
 *
 * @author ivansteuerberg
 */
public class ParkingHilos {

    public static void main(String[] args) {
        Parking parking = new Parking(6, 6);
        Coche coche1 = new Coche("Coche 1",1,parking);
        coche1.start();
        Coche coche2 = new Coche("Coche 2",2,parking);
        coche2.start();
        Coche coche3 = new Coche("Coche 3",3,parking);
        coche3.start();
        Coche coche4 = new Coche("Coche 4",4,parking);
        coche4.start();
        Coche coche5 = new Coche("Coche 5",5,parking);
        coche5.start();
        Coche coche6 = new Coche("Coche 6",6,parking);
        coche6.start();
    }

}
