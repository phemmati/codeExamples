package javaBasics;

import java.util.Date;

public class PlanetExample {
    public static void main(String[] args) {
        Planet p = new Planet(900.6, "MyPlanet", new Date());
        Date date = p.getDateOfDiscovery();
        date.setTime(6000);
    }
}
