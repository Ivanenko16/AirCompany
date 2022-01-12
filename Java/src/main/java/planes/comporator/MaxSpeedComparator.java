package planes.comporator;

import planes.Plane;

import java.util.Comparator;

public class MaxSpeedComparator implements Comparator<Plane> {
    @Override
    public int compare(Plane plane1, Plane plane2) {
        return plane1.getMaxSpeed() - plane2.getMaxSpeed();
    }
}
