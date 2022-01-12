package planes.comporator;

import planes.Plane;

import java.util.Comparator;

public class MaxLoadCapacityComparator implements Comparator<Plane> {
    @Override
    public int compare(Plane plane1, Plane plane2) {
        return plane1.getMaxLoadCapacity() - plane2.getMaxLoadCapacity();
    }
}

