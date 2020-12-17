package parkinghilos;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ivansteuerberg
 */
public class Parking {

    private int numCoches;
    private int numPlazas;
    ArrayList<Integer> parking;
    private boolean disponible;

    public int getNumCoches() {
        return numCoches;
    }

    public void setNumCoches(int numCoches) {
        this.numCoches = numCoches;
    }

    public int getNumPlazas() {
        return numPlazas;
    }

    public void setNumPlazas(int numPlazas) {
        this.numPlazas = numPlazas;
    }

    public Parking(int numCoches, int numPlazas) {
        this.disponible = true;
        this.numCoches = numCoches;
        this.numPlazas = numPlazas;
        this.parking = new ArrayList<>();
        for (int i = 0; i < numPlazas; i++) {
            parking.add(0);
        }
    }

    public void mostrarParking() {
        System.out.print("Parking: ");
        for (int i = 0; i < parking.size(); i++) {
            System.out.print("[" + parking.get(i) + "] ");

        }
        System.out.println("");
    }

    public void contarPlazas() {
        int plazasLibres = 0;
        for (int i = 0; i < parking.size(); i++) {
            if (parking.get(i) == 0) {
                plazasLibres++;
            }
        }
        System.out.println("Plazas libres: " + plazasLibres);
    }

    public int contarPlazas2() {
        int plazasLibres = 0;
        for (int i = 0; i < parking.size(); i++) {
            if (parking.get(i) == 0) {
                plazasLibres++;
            }
        }
        return plazasLibres;
    }

    public synchronized void insertarCoche(int posicion, int numero) {
        while (disponible == false) {
            try {
                wait((int) (Math.random() * 500));
            } catch (InterruptedException ex) {
                Logger.getLogger(Parking.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        disponible = false;
        if (parking.get(posicion) == 0) {
            System.out.println("ENTRADA: Coche" + numero + " aparca en " + posicion);
            parking.set(posicion, numero);
            mostrarTodo();
            System.out.println("");
        }
        disponible = true;
        notifyAll();
    }

    public synchronized void borrarCoche(int posicion, int numero) {
        while (disponible == false) {
            try {
                wait((int) (Math.random() * 500));
            } catch (InterruptedException ex) {
                Logger.getLogger(Parking.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        disponible = false;
        if (parking.get(posicion) == numero) {
            System.out.println("SALIDA: Coche" + numero + " saliendo");
            parking.set(posicion, 0);
            mostrarTodo();
            System.out.println("");
        }
        disponible = true;
        notifyAll();
    }

    public void mostrarTodo() {
        contarPlazas();
        mostrarParking();
    }

}
