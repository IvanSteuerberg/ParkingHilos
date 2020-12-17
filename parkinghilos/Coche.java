package parkinghilos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ivansteuerberg
 */
public class Coche extends Thread {

    private int posicion;
    private final int numero;
    private Parking parking;

    public Coche(String nombre, int numero, Parking p) {
        super(nombre);
        this.numero = numero;
        parking = p;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public void run() {
        while (1==1){
            try {
                Thread.sleep((int) (Math.random() * 300)+250);
            } catch (InterruptedException ex) {
                Logger.getLogger(Coche.class.getName()).log(Level.SEVERE, null, ex);
            }
            int randomPos = (int) (Math.random() * parking.contarPlazas2());
            setPosicion(randomPos);
            parking.insertarCoche(posicion, numero);
            try {
                Thread.sleep((int) (Math.random() * 15000)+250);
            } catch (InterruptedException ex) {
                Logger.getLogger(Coche.class.getName()).log(Level.SEVERE, null, ex);
            }
            parking.borrarCoche(posicion, numero);
            try {
                Thread.sleep((int) (Math.random() * 5000)+250);
            } catch (InterruptedException ex) {
                Logger.getLogger(Coche.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
