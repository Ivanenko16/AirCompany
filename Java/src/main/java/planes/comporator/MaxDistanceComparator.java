package planes.comporator;

import planes.Plane;

import java.util.Comparator;

public class MaxDistanceComparator implements Comparator<Plane> {
    @Override
    public int compare(Plane plane1, Plane plane2) {
        return plane1.getMaxFlightDistance() - plane2.getMaxFlightDistance();
    }
}
