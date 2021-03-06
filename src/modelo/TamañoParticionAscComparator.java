package modelo;

import java.util.Comparator;

/**
 *
 * @author Mauro Federico Lopez
 */
public class TamañoParticionAscComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Particion p1 = (Particion)o1;
        Particion p2 = (Particion)o2;
        return p1.getTamaño() - p2.getTamaño();
    }

}
