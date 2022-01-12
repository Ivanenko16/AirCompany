import models.MilitaryType;
import planes.ExperimentalPlane;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;
import planes.comporator.MaxDistanceComparator;
import planes.comporator.MaxLoadCapacityComparator;
import planes.comporator.MaxSpeedComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Airport {
    private final List<? extends Plane> planes;

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    public List<PassengerPlane> getPassengerPlanes() {
        List<PassengerPlane> passengerPlaneList = new ArrayList<>();
        for (Plane plane : this.planes) {
            if (plane instanceof PassengerPlane) {
                passengerPlaneList.add((PassengerPlane) plane);
            }
        }
        return passengerPlaneList;
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof MilitaryPlane) {
                militaryPlanes.add((MilitaryPlane) plane);
            }
        }
        return militaryPlanes;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPassengerPlanes();
        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
        for (PassengerPlane passengerPlane : passengerPlanes) {
            if (passengerPlane.getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = passengerPlane;
            }
        }
        return planeWithMaxCapacity;
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        for (MilitaryPlane militaryPlane : militaryPlanes) {
            if (militaryPlane.getMilitaryType() == MilitaryType.TRANSPORT) {
                transportMilitaryPlanes.add(militaryPlane);
            }
        }
        return transportMilitaryPlanes;
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        List<MilitaryPlane> bomberMilitaryPlanes;
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        bomberMilitaryPlanes = militaryPlanes.stream().filter(plane -> plane.getMilitaryType() == MilitaryType.BOMBER).collect(Collectors.toList());
        return bomberMilitaryPlanes;

    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        List<ExperimentalPlane> experimentalPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof ExperimentalPlane) {
                experimentalPlanes.add((ExperimentalPlane) plane);
            }
        }
        return experimentalPlanes;
    }

    public Airport sortByMaxDistance() {
        Comparator<Plane> distanceComparator = new MaxDistanceComparator();
        planes.sort(distanceComparator);
        return this;
    }

    public Airport sortByMaxSpeed() {
        Comparator<Plane> speedComparator = new MaxSpeedComparator();
        planes.sort(speedComparator);
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        Comparator<Plane> loadCapacityComparator = new MaxLoadCapacityComparator();
        planes.sort(loadCapacityComparator);
        return this;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }
}
